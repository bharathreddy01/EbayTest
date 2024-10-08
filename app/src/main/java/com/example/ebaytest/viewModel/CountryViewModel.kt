package com.example.ebaytest.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.ebaytest.modelClasses.Country
import com.example.ebaytest.repository.CountryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class CountryViewModel(private val repository: CountryRepository) : ViewModel(){


    private val _countries = MutableLiveData<List<Country>>()
    val countries : LiveData<List<Country>> = _countries

    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> = _loading

    fun fetchCountries(){
        _loading.value = true
        viewModelScope.launch {
            try {
                val response = repository.getCountries()
                _countries.value = response
            } catch (e: Exception){
                e.printStackTrace()
            } finally {
                _loading.value = false
            }
        }
    }

}