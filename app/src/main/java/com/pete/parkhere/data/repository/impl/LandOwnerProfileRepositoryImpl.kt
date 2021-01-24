package com.pete.parkhere.data.repository.impl

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.pete.parkhere.data.local.Location
import com.pete.parkhere.data.local.LocationDao
import com.pete.parkhere.data.local.LocationDatabase
import com.pete.parkhere.data.repository.LandOwnerProfileRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LandOwnerProfileRepositoryImpl @Inject constructor(private val locationsLocalDB: LocationDatabase)
    : LandOwnerProfileRepository {

    override suspend fun getAllLocations(): MutableList<Location> {

            val data = locationsLocalDB
                    .locationDao()
                    .getAllLocations()
        return data

//        return object: LiveData<MutableList<Location>>() {
//            init {
//                val job = Job()
//                val coroutineCtx = Dispatchers.IO
//                CoroutineScope(coroutineCtx + job).launch {
//                    val newData = locationsLocalDB
//                        .locationDao()
//                        .getAllLocations()
//                    postValue(newData)
//                }
//            }
//        }
    }

    override suspend fun insertAll(vararg locations: Location) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(location: Location) {
        TODO("Not yet implemented")
    }
}