package com.example.ebaytest.retrofit

import com.example.ebaytest.modelClasses.Country
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface CountryAPi {


    @GET("v3.1/subregion/Southern%20Europe")
    suspend fun getCountries(): List<Country>


    companion object{
        fun create(): CountryAPi{
            val retrofit = Retrofit.Builder().baseUrl("https://restcountries.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(CountryAPi::class.java)

        }
    }
}