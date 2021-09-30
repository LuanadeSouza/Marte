package br.com.luanadev.marte.network

import br.com.luanadev.marte.database.MarsPropertyEntities
import br.com.luanadev.marte.domain.MarsModels
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkMarsContainer(val marsProperties: List<NetworkMarsProperties>)

/**
 * Videos represent a devbyte that can be played.
 */
@JsonClass(generateAdapter = true)
data class NetworkMarsProperties(
    val id: String,
    val type: String,
    val imgSrcUrl: String,
    val price: Double,
)

/**
 * Convert Network results to database objects
 */
fun NetworkMarsContainer.asDomainModel(): List<MarsPropertyEntities> {
    return marsProperties.map {
        MarsPropertyEntities(
            id = it.id,
            type = it.type,
            imgSrcUrl = it.imgSrcUrl,
            price = it.price
        )
    }
}

/**
 * Convert Network results to database objects
 */
fun NetworkMarsContainer.asDatabaseModel(): List<MarsPropertyEntities> {
    return marsProperties.map {
        MarsPropertyEntities(
            id = it.id,
            type = it.type,
            imgSrcUrl = it.imgSrcUrl,
            price = it.price
        )
    }
}
