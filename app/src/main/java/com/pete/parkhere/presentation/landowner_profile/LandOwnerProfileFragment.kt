package com.pete.parkhere.presentation.landowner_profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pete.parkhere.data.entity.Land
import com.pete.parkhere.data.local.Location
import com.pete.parkhere.data.local.LocationsDB
import com.pete.parkhere.databinding.FragmentLandOwnerProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LandOwnerProfileFragment : Fragment() {

    private var _binding: FragmentLandOwnerProfileBinding? = null
    val binding get() = _binding!!
//    private lateinit var appContainer: AppContainer

//    private val viewModel by lazy {
//        val factory = LandOwnerProfileVMFactory(appContainer.repository)
//        ViewModelProvider(this ,factory).get(LandOwnerProfileViewModel::class.java)
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        appContainer = (requireActivity().applicationContext as MyApplication).appContainer
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLandOwnerProfileBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = LocationsDB.getInstance(requireActivity().applicationContext).locationDao()

        val list = mutableListOf(Land("THIS IS AMAZING!!"))
        initRecycler(list)

    }

    private fun initRecycler(locations: MutableList<Land>) {
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