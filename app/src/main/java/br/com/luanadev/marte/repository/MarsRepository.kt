package br.com.luanadev.marte.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import br.com.luanadev.marte.database.MarsDatabase
import br.com.luanadev.marte.database.asDomainModel
import br.com.luanadev.marte.domain.MarsModels
import br.com.luanadev.marte.network.MarsApi
import br.com.luanadev.marte.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class MarsRepository(private val database: MarsDatabase) {

    val marsProperties: LiveData<List<MarsModels>> =
        Transformations.map(database.marsDao.getProperties()) {
            it.asDomainModel()
        }

    suspend fun refreshMarsProperties() {
        withContext(Dispatchers.IO) {
            Timber.d("refresh properties mars is called");
            val marsPropertieslist = MarsApi.retrofitService.getProperties("filter")
            database.marsDao.insertAll(marsPropertieslist.asDatabaseModel())
        }
    }
}