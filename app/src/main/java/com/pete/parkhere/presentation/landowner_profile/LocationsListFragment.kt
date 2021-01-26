package com.pete.parkhere.presentation.landowner_profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pete.parkhere.databinding.FragmentLocationsListBinding

class LocationsListFragment : Fragment() {
    private var _binding : FragmentLocationsListBinding? = null
    val binding
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLocationsListBinding
            .inflate(inflater,container,false)

        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun getInstance(): LocationsListFragment {
            return LocationsListFragment()
        }
    }

}