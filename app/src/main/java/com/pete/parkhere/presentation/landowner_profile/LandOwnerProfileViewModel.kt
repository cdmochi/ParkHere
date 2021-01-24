package com.pete.parkhere.presentation.landowner_profile

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pete.parkhere.data.local.Location
import com.pete.parkhere.data.repository.impl.LandOwnerProfileRepositoryImpl
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class LandOwnerProfileViewModel @ViewModelInject constructor(
        private val repository: LandOwnerProfileRepositoryImpl
) : ViewModel() {

    val locations = MutableLiveData<MutableList<Location>>()

    init {
        val newList = mutableListOf<Location>().apply {
            add(Location("Bazaar0",1212.12,121.12,"","12:00","14:00",1222))
            add(Location("Bazaar1",1212.12,121.12,"","12:00","14:00",1222))
            add(Location("Bazaar2",1212.12,121.12,"","12:00","14:00",1222))
            add(Location("Bazaar3",1212.12,121.12,"","12:00","14:00",1222))
            add(Location("Bazaar4",1212.12,121.12,"","12:00","14:00",1222))
        }

        locations.value = newList
    }

    fun getAllLocations(callback: (LiveData<MutableList<Location>>) -> Unit) {
        viewModelScope.launch {
            val data = repository.getAllLocations()
            callback(data)
        }
    }



}