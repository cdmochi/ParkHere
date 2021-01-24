package com.pete.parkhere.presentation.landowner_profile

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pete.parkhere.data.local.Location
import com.pete.parkhere.data.repository.LandOwnerProfileRepository
import kotlinx.coroutines.launch

class LandOwnerProfileViewModel @ViewModelInject constructor(
        private val repository: LandOwnerProfileRepository
) : ViewModel() {

    val locations = MutableLiveData<ArrayList<Location>>()
    val mockLocation = arrayListOf<Location>().apply {
        locations.value!!.add(
                Location(
                        0,
                        "London eyes",
                        13.221,
                        12.2123,
                        "",
                        "20012021-10:00",
                        "20012021-12:00",
                        122)
        )
        locations.value!!.add(
                Location(
                        1,
                        "London YEYEYE",
                        13.221,
                        12.2123,
                        "",
                        "20012021-10:00",
                        "20012021-12:00",
                        123)
        )
    }

    init {
        locations.value = mockLocation
    }

    fun getAllLocations(callback: (LiveData<List<Location>>) -> Unit) {
        viewModelScope.launch {
            val data = repository.getAllLocations()
            callback(data)
        }
    }



}