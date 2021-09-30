package br.com.luanadev.marte.domain

import br.com.luanadev.marte.util.smartTruncate
import com.squareup.moshi.Json

data class MarsModels(
    val id: String,
    // used to map img_src from the JSON to imgSrcUrl in our class
    @Json(name = "img_src") val imgSrcUrl: String,
    val type: String,
    val price: Double
){
    /**
    * Short description is used for displaying truncated descriptions in the UI
    */
    val shortDescription: String
        get() = id.smartTruncate(200)
}