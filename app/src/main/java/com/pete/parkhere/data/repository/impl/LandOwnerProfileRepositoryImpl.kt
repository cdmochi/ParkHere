package com.pete.parkhere.data.repository.impl

import android.content.Context
import androidx.lifecycle.LiveData
import com.pete.parkhere.data.local.Location
import com.pete.parkhere.data.local.LocationDao
import com.pete.parkhere.data.local.LocationDatabase
import com.pete.parkhere.data.repository.LandOwnerProfileRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LandOwnerProfileRepositoryImpl @Inject constructor(val locationsLocalDB: LocationDatabase)
    : LandOwnerProfileRepository {

    override suspend fun getAllLocations(): LiveData<List<Location>> {
        return object: LiveData<List<Location>>() {
            init {
                val coroutineCtx = Dispatchers.IO
                CoroutineScope(coroutineCtx).launch {
                    val newData = locationsLocalDB
                        .locationDao()
                        .getAllLocations()
                    value(newData)
                }
            }
            fun value(fromLocal : List<Location>) { this.value = fromLocal }
        }
    }

    override suspend fun insertAll(vararg locations: Location) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(location: Location) {
        TODO("Not yet implemented")
    }
}