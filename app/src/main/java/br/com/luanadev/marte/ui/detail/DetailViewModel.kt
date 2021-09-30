package br.com.luanadev.marte.ui.detail

import android.app.Application
import androidx.lifecycle.*
import br.com.luanadev.marte.R
import br.com.luanadev.marte.database.MarsPropertyEntities
import br.com.luanadev.marte.repository.MarsRepository

class DetailViewModel(marsProperty: MarsPropertyEntities,
                      app: Application) : AndroidViewModel(app) {

    private val _selectedProperty = MutableLiveData<MarsPropertyEntities>()
    val selectedProperty: LiveData<MarsPropertyEntities>
        get() = _selectedProperty


    init {
        _selectedProperty.value = marsProperty
    }

    val displayPropertyPrice = Transformations.map(selectedProperty) {
        app.applicationContext.getString(
            when (it.isRental) {
                true -> R.string.display_price_monthly_rental
                false -> R.string.display_price
            }, it.price)
    }

    val displayPropertyType = Transformations.map(selectedProperty) {
        app.applicationContext.getString(R.string.display_type,
            app.applicationContext.getString(
                when(it.isRental) {
                    true -> R.string.type_rent
                    false -> R.string.type_sale
                }))
    }

}
