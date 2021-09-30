package br.com.luanadev.marte.ui.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.luanadev.marte.database.MarsEntities

class DetailViewModelFactory(
    private val mars: MarsEntities,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(mars, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}