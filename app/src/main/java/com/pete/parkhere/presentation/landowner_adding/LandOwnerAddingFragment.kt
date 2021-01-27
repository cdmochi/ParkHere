package com.pete.parkhere.presentation.landowner_adding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.navigation.Navigation
import com.google.android.material.chip.Chip
import com.pete.parkhere.CameraActivity
import com.pete.parkhere.R
import com.pete.parkhere.Utility.SToast
import com.pete.parkhere.databinding.FragmentLandOwnerAddingBinding

class LandOwnerAddingFragment : Fragment() {

    private var _binding : FragmentLandOwnerAddingBinding? = null
    val binding : FragmentLandOwnerAddingBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //this set the softKeyboard to popup where the InputView is so input can still be visible
        _binding = FragmentLandOwnerAddingBinding
                .inflate(inflater,container,false)
        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    private fun initViews(view: View) {
        with(binding) {
            val imgView = locationPicImgview
            val locationName = locationNameEt.editText?.text
            val cleanSelectedID = binding.cleanlinessCg.checkedChipId
            val selectedRadioButton = view.findViewById<Chip>(cleanSelectedID)
            val amountCarSelectedID = binding.availParkCg.checkedChipId
            val selectedCleanliness = view.findViewById<Chip>(amountCarSelectedID)

            pinImgbt.setOnClickListener {
//                val mapIntent = Intent(activity, MapActivity::class.java)
//                startActivity(mapIntent)
                Navigation.findNavController(it).navigate(R.id.action_landOwnerAdding_to_mapPickFragment)
            }
            imgView.setOnClickListener {
                val cameraIntent = Intent(activity,CameraActivity::class.java)
                startActivity(cameraIntent)
            }

            doneBt.setOnClickListener {
//                when (selectedRadioButton.text) {
//                    "Not So Clean" -> {
//                        requireContext().SToast("NOT SO CLEAN")
//                    }
//                    "Normal" -> {
//                        requireContext().SToast("Normal")
//                    }
//                    "Really Clean" -> {
//                        requireContext().SToast("Really Clean!")
//                    }
//                }
//                when (selectedCleanliness.text) {
//                    "1" -> {
//                        requireContext().SToast("1")
//                    }
//                    "2" -> {
//                        requireContext().SToast("2")
//                    }
//                    "3" -> {
//                        requireContext().SToast("3")
//                    }
//                    "4" -> {
//                        requireContext().SToast("4")
//                    }
//                }
                requireContext().SToast(locationName.toString())
            }
        }
    }



    companion object {
        fun getInstance(): LandOwnerAddingFragment {
            return LandOwnerAddingFragment()
        }
    }

}