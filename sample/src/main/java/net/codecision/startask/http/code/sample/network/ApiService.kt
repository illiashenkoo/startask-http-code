package net.codecision.startask.http.code.sample.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("people/{id}")
    fun getPerson(@Path("id") person: Int): Call<PersonResponse>

}
