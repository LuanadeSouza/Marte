package br.com.luanadev.marte.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.luanadev.marte.domain.MarsModels
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class MarsEntities constructor(
    @PrimaryKey
    val id: String,
    // used to map img_src from the JSON to imgSrcUrl in our class
    @Json(name = "img_src") val imgSrcUrl: String,
    val type: String,
    val price: Double
    ) : Parcelable {
    val isRental
        get() = type == "rent"
}

/**
 * Map MarsPropertyEntities to domain entities
 */
fun List<MarsEntities>.asDomainModel(): List<MarsModels> {
    return map {
        MarsModels(
            id = it.id,
            imgSrcUrl = it.imgSrcUrl,
            type = it.type,
            price = it.price,
            )
    }
}