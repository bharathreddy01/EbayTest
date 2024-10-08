package com.example.ebaytest

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ebaytest.viewModel.CountryViewModel

@Composable
fun CountryList(viewModel: CountryViewModel= viewModel()){
    val countries by viewModel.countries.observeAsState(emptyList())
    val isLoading by viewModel.loading.observeAsState(false)

    LaunchedEffect(Unit) {
        viewModel.fetchCountries()
    }


    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading){
            CircularProgressIndicator()
        }else{
            LazyColumn(modifier = Modifier.fillMaxSize(),
                contentPadding =  PaddingValues(16.dp)
            ) {
                items(countries){ country ->
                    Text(text = country.name.common.toString(), modifier = Modifier.padding(8.dp))

                }
            }
        }
    }
}