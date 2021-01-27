package com.pete.parkhere.data.remote

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson

object FirebaseDatabase {

    const val TAG = "FIREBASE_DATABASE_DEBUG"
    const val LOCATION_LIST_KEY = "locations_list"
    private var db = FirebaseFirestore.getInstance()

    fun addNewLocation(newLocation: Location) {

        val locationMap = hashMapOf(
            "name" to newLocation.name,
            "lat" to newLocation.lat,
            "lon" to newLocation.lon,
            "picture" to newLocation.picture,
            "price" to newLocation.price,
            "lend_date" to newLocation.lendDate,
            "lend_start" to newLocation.lendStart,
            "lend_end" to newLocation.lendEnd
        )

        db.collection(LOCATION_LIST_KEY)
            .document()
            .set(locationMap)
            .addOnCompleteListener {
                Log.d(TAG, "new location added:${Gson().toJson(newLocation)}")
            }
    }

    fun readFromDatabase(callback: (MutableList<Location>)-> Unit) {
        db.collection(LOCATION_LIST_KEY)
            .get()
            .addOnSuccessListener { docs ->
                val modelList = mutableListOf<Location>()
                for (eachDocument in docs) {
                    val name: String = eachDocument.getString("name")!!
                    val lat: Long = eachDocument.getLong("lat")!!
                    val long: Long = eachDocument.getLong("long")!!
                    val picture: String = eachDocument.getString("picture")!!
                    val price: Int = eachDocument.getLong("price")!!.toInt()
                    val lendDate: String = eachDocument.getString("lend_date")!!
                    val lendStart: String = eachDocument.getString("lend_start")!!
                    val lendEnd: String = eachDocument.getString("lend_end")!!
                    modelList.add(Location(name,lat,long,picture,price,lendDate,lendStart,lendEnd))
                }
                callback(modelList)
            }
    }
}
