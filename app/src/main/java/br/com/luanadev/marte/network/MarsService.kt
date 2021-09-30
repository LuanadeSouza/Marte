package br.com.luanadev.marte.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

enum class MarsApiFilter(val value: String) {
    SHOW_RENT("rent"),
    SHOW_BUY("buy"),
    SHOW_ALL("all")
}

interface MarsService {
    @GET("realestate")
    suspend fun getProperties(@Query("filter") type: String): NetworkMarsContainer
}

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

object MarsNetwork {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val retrofitService: MarsService = retrofit.create(MarsService::class.java)
}



