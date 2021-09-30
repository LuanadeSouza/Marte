package br.com.luanadev.marte.ui.overview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.luanadev.marte.database.MarsDatabase.Companion.getDatabase
import br.com.luanadev.marte.database.MarsEntities
import br.com.luanadev.marte.network.MarsApiFilter
import br.com.luanadev.marte.repository.MarsRepository
import kotlinx.coroutines.launch
import java.io.IOException

enum class MarsApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel(application: Application) : AndroidViewModel(application) {

    private val marsRepository = MarsRepository(getDatabase(application))
    val marsPropertieslist = marsRepository.marsProperties

    private val _status = MutableLiveData<MarsApiStatus>()

    val status: LiveData<MarsApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<MarsEntities>>()

    val properties: LiveData<List<MarsEntities>>
        get() = _properties

    private val _navigateToSelectedProperty = MutableLiveData<MarsEntities>()
    val navigateToSelected: LiveData<MarsEntities>
        get() = _navigateToSelectedProperty

    private var _eventNetworkError = MutableLiveData(false)
    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkErrorShown = MutableLiveData(false)
    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown


    init {
        getMarsRealEstateProperties(MarsApiFilter.SHOW_ALL)
        refreshDataFromRepository()
    }

    private fun getMarsRealEstateProperties(filter: MarsApiFilter) {
        viewModelScope.launch {
            _status.value = MarsApiStatus.LOADING
            try {
                marsRepository.refreshMarsProperties()
                _status.value = MarsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MarsApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    fun updateFilter(filter: MarsApiFilter) {
        getMarsRealEstateProperties(filter)
    }

    fun displayPropertyDetails(mars: MarsEntities) {
        _navigateToSelectedProperty.value = mars
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }


    private fun refreshDataFromRepository() {
        viewModelScope.launch {
            try {
                marsRepository.refreshMarsProperties()
                _eventNetworkError.value = false
                _isNetworkErrorShown.value = false

            } catch (networkError: IOException) {
                // Show a Toast error message and hide the progress bar.
                if (marsPropertieslist.value.isNullOrEmpty())
                    _eventNetworkError.value = true
            }
        }
    }

    fun onNetworkErrorShown() {
        _isNetworkErrorShown.value = true
    }
}
