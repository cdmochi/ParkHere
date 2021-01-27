package com.pete.parkhere.presentation.landowner_profile

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.pete.parkhere.data.local.Block
import com.pete.parkhere.data.repository.impl.LandOwnerProfileRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LandOwnerProfileViewModel @ViewModelInject constructor(
        private val repository: LandOwnerProfileRepositoryImpl
) : ViewModel() {

    var _blocks = MutableLiveData<MutableList<Block>>()

    init {
        getAllBlocksFromLocalDB()
    }

    private fun getAllBlocksFromLocalDB() {
        viewModelScope.launch {
            _blocks.value = repository.getAllBlocks()
        }
    }

    fun addNewBlock(newBlock: Block) {

        //TODO do not add the block rightAway but ask the #Verifier first
        //TODO if the response is yes add block
        // A  -Connected Peer Connected With-> Verifier
        // A   ---------send new Block-------------> Verifier
        // A   <------------------------------------ Verifier
        viewModelScope.launch {
            repository.insertAll(newBlock)
        }
    }

//    fun deleteLocation(block: Block) {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.delete(block)
//        }
//    }


}