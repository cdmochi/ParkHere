package com.pete.parkhere.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.pete.parkhere.data.local.LocationDatabase
import com.pete.parkhere.data.local.LocationsDB
import com.pete.parkhere.data.repository.LandOwnerProfileRepository
import com.pete.parkhere.data.repository.impl.LandOwnerProfileRepositoryImpl

//object AppContainer(appCtx : Context) {
//    val locationsLocalDB : LocationDatabase = LocationsDB.getInstance(appCtx)
//    val repository : LandOwnerProfileRepository = LandOwnerProfileRepositoryImpl(appCtx,locationsLocalDB.locationDao())
//}