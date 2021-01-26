package com.pete.parkhere.data.entity

import com.pete.parkhere.data.local.Location

data class Block(val index: Int,
                 val location: Location,
                 val from : User,
                 val to : User,
                 var previous: String = "",
                 var hash: String = "",
                 val bookingDetails: String = ""
) {

}

