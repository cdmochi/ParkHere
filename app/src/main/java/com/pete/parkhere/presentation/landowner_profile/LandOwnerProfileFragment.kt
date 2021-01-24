package com.pete.parkhere.presentation.landowner_profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pete.parkhere.data.entity.ParkLocation
import com.pete.parkhere.data.local.Location
import com.pete.parkhere.databinding.FragmentLandOwnerProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandOwnerProfileFragment : Fragment() {

    private var _binding: FragmentLandOwnerProfileBinding? = null
    val binding get() = _binding!!

    private val viewModel by  viewModels<LandOwnerProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLandOwnerProfileBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllLocations { locationLiveData: LiveData<List<Location>> ->
            locationLiveData.observe(viewLifecycleOwner, Observer {newLocations: List<Location>->
                initRecycler(newLocations)
            })
        }
    }

    private fun initRecycler(locations: List<Location>) {
        val recycler = binding.landsRv
        val layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL,false)
        val adapter = Adapter(locations)
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}