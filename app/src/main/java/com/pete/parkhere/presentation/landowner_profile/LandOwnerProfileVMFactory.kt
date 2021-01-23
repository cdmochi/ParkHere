package com.pete.parkhere.presentation.landowner_profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pete.parkhere.data.repository.LandOwnerProfileRepository

class LandOwnerProfileVMFactory(private val repository: LandOwnerProfileRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LandOwnerProfileViewModel::class.java)) {
            return LandOwnerProfileViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknowned ViewModel class Exception")
    }
}