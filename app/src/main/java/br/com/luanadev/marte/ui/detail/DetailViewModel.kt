package br.com.luanadev.marte.ui.detail

import android.app.Application
import androidx.lifecycle.*
import br.com.luanadev.marte.R
import br.com.luanadev.marte.database.MarsEntities

class DetailViewModel(mars: MarsEntities,
                      app: Application) : AndroidViewModel(app) {

    private val _selectedProperty = MutableLiveData<MarsEntities>()
    val selected: LiveData<MarsEntities>
        get() = _selectedProperty


    init {
        _selectedProperty.value = mars
    }

    val displayPropertyPrice = Transformations.map(selected) {
        app.applicationContext.getString(
            when (it.isRental) {
                true -> R.string.display_price_monthly_rental
                false -> R.string.display_price
            }, it.price)
    }

    val displayPropertyType = Transformations.map(selected) {
        app.applicationContext.getString(R.string.display_type,
            app.applicationContext.getString(
                when(it.isRental) {
                    true -> R.string.type_rent
                    false -> R.string.type_sale
                }))
    }

}
