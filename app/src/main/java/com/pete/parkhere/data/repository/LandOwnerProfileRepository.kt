package com.pete.parkhere.data.repository

import androidx.lifecycle.LiveData
import com.pete.parkhere.data.local.Location


interface LandOwnerProfileRepository {

    suspend fun getAllLocations(): LiveData<List<Location>>

    suspend fun insertAll(vararg locations: Location)

    suspend fun delete(location: Location)
}