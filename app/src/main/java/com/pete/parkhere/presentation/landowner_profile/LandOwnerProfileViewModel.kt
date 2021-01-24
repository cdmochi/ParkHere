package com.pete.parkhere.presentation.landowner_profile

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.pete.parkhere.data.local.Location
import com.pete.parkhere.data.repository.impl.LandOwnerProfileRepositoryImpl
import kotlinx.coroutines.launch

class LandOwnerProfileViewModel @ViewModelInject constructor(
        private val repository: LandOwnerProfileRepositoryImpl
) : ViewModel() {


    var _locations = MutableLiveData<MutableList<Location>>()

    init {
        val newList = mutableListOf<Location>().apply {
            add(Location("Bazaar0",1212.12,121.12,"","12:00","14:00",1222))
            add(Location("Bazaar1",1212.12,121.12,"","12:00","14:00",1222))
            add(Location("Bazaar2",1212.12,121.12,"","12:00","14:00",1222))
            add(Location("Bazaar3",1212.12,121.12,"","12:00","14:00",1222))
            add(Location("Bazaar4",1212.12,121.12,"","12:00","14:00",1222))
        }
        getAllLocationsFromLocalDB()
    }

    private fun getAllLocationsFromLocalDB() {
        viewModelScope.launch {
            _locations.value = repository.getAllLocations()
        }
    }



}