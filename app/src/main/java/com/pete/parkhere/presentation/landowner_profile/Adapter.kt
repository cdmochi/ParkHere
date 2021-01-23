package com.pete.parkhere.presentation.landowner_profile

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pete.parkhere.data.entity.Land
import com.pete.parkhere.databinding.LandItemviewBinding

class Adapter(var modalList : List<Land>): RecyclerView.Adapter<Adapter.LocationViewHolder>() {

    inner class LocationViewHolder(binding: LandItemviewBinding)
        : RecyclerView.ViewHolder(binding.root) {
        val landItemView :TextView = binding.locationNameTv

        fun bind(position: Int) {
            landItemView.text = modalList[position].placeDescription
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding = LandItemviewBinding.inflate(LayoutInflater.from(parent.context))
        return LocationViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return modalList.size
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(position)
    }
}