package br.com.luanadev.marte.network

import br.com.luanadev.marte.database.MarsPropertyEntities
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

enum class MarsApiFilter(val value: String) {
    SHOW_RENT("rent"),
    SHOW_BUY("buy"),
    SHOW_ALL("all")
}

interface MarsApiService {
    @GET("realestate")
    suspend fun getProperties(@Query("filter") type: String): List<MarsPropertyEntities>
}

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

object MarsApi {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val retrofitService: MarsApiService = retrofit.create(MarsApiService::class.java)
}



