package com.pete.parkhere.presentation.landowner_profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.pete.parkhere.data.local.Location
import com.pete.parkhere.databinding.FragmentLandOwnerProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandOwnerProfileFragment : Fragment() {

    private var _binding: FragmentLandOwnerProfileBinding? = null
    val binding get() = _binding!!

    private val viewModel by  viewModels<LandOwnerProfileViewModel>()
    var locations = mutableListOf<Location>()
    private var adapter: Adapter = Adapter(locations)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLandOwnerProfileBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        initRecyclerView()

//        viewModel._locations.observe(viewLifecycleOwner, Observer { newList ->
//            updateAdapter(newList)
//        })

        val newAdapter = ViewPagerAdapter(this,binding.tabpanelRg)
        binding.locationVpager.adapter = newAdapter

    }

    private fun updateAdapter(newList: MutableList<Location>) {
        adapter.modalList.clear()
        adapter.modalList.addAll(newList)
        adapter.notifyDataSetChanged()
    }

    private fun initRecyclerView() {
//        val recycler = binding.landsRv
//        recycler.setHasFixedSize(true)
//        recycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
//        recycler.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    companion object {

        fun getInstance(): LandOwnerProfileFragment {
            return LandOwnerProfileFragment()
        }

    }

}