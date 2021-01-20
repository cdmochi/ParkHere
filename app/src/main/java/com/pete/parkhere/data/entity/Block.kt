package com.pete.parkhere.data.entity

import com.pete.parkhere.data.local.Location

data class Block(val index: Int,
                 val location: Location,
                 var previous: String = "",
                 var hash: String = "") {

    fun calculateHash() {
        return
    }
}

