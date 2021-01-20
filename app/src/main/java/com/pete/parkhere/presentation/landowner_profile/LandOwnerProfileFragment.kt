package com.pete.parkhere.presentation.landowner_profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnLayout
import com.pete.parkhere.R
import com.pete.parkhere.data.local.Location
import com.pete.parkhere.data.local.LocationsDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class LandOwnerProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_land_owner_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = LocationsDB.getInstance(requireActivity().applicationContext).locationDao()

        val mockLocation = arrayListOf<Location>().apply {
            add(Location(0,
                "London eyes",
                13.221,
                12.2123,
                "",
                "20012021-10:00",
                "20012021-12:00",
                122)
            )
            add(Location(1,
                "London YEYEYE",
                13.221,
                12.2123,
                "",
                "20012021-10:00",
                "20012021-12:00",
                123)
            )
        }

        CoroutineScope(Dispatchers.IO).launch {
            Log.d("CoroutineScope","${Thread.currentThread()}")
            dao.insertAll(mockLocation[0],mockLocation[1])
            val mockLocations = dao.getAllLocations()
            Log.d("logScope",mockLocations[0].name)
        }



    }

    fun logLocations(locations: ArrayList<Location>) {
        Log.d("logScope",locations[0].name)
    }

}