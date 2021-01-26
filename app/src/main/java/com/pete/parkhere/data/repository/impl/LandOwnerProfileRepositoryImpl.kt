package com.pete.parkhere.data.repository.impl

import com.pete.parkhere.data.local.Location
import com.pete.parkhere.data.local.LocationDatabase
import com.pete.parkhere.data.repository.LandOwnerProfileRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LandOwnerProfileRepositoryImpl @Inject constructor(private val locationsLocalDB: LocationDatabase)
    : LandOwnerProfileRepository {

    override suspend fun getAllLocations(): MutableList<Location> {

        return locationsLocalDB
                .locationDao()
                .getAllLocations()

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
        locationsLocalDB
                .locationDao()
                .insertAll(*locations)
    }

    override suspend fun delete(location: Location) {
        locationsLocalDB
                .locationDao()
                .delete(location)
    }
}