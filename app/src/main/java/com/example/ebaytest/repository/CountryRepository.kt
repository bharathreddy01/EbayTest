package com.example.ebaytest.repository

import com.example.ebaytest.modelClasses.Country
import com.example.ebaytest.retrofit.CountryAPi

class CountryRepository(private val api: CountryAPi) {
    suspend fun getCountries(): List<Country>{
        return api.getCountries()
    }

}