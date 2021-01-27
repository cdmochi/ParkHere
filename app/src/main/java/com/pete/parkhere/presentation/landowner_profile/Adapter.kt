package com.pete.parkhere.presentation.landowner_profile

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pete.parkhere.data.remote.Location
import com.pete.parkhere.databinding.LandItemviewBinding

class Adapter(var modalList : MutableList<Location>)
    : RecyclerView.Adapter<Adapter.LocationViewHolder>() {

    inner class LocationViewHolder(binding: LandItemviewBinding)
        : RecyclerView.ViewHolder(binding.root) {
        val locationName : TextView = binding.locationNameTv

        fun bind(position: Int) {
            locationName.text = modalList[position].name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding
                = LandItemviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LocationViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return modalList.size
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(position)
    }

}