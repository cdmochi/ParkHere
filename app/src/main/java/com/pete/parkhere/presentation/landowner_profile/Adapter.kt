package com.pete.parkhere.presentation.landowner_profile

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pete.parkhere.data.entity.ParkLocation
import com.pete.parkhere.data.local.Location
import com.pete.parkhere.databinding.LandItemviewBinding

class Adapter(private var modalList : List<Location>)
    : RecyclerView.Adapter<Adapter.LocationViewHolder>() {

    inner class LocationViewHolder(binding: LandItemviewBinding)
        : RecyclerView.ViewHolder(binding.root) {
//        val landItemView :TextView = binding.locationNameTv
        //TODO Hold the reference from the Location Item Here

        fun bind(position: Int) {
            //TODO BIND THE REFERENCE HERE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding
                = LandItemviewBinding.inflate(LayoutInflater.from(parent.context))
        return LocationViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return modalList.size
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(position)
    }
}