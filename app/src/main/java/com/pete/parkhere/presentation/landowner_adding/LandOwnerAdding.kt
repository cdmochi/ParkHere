package com.pete.parkhere.presentation.landowner_adding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.pete.parkhere.R
import com.pete.parkhere.databinding.LandItemviewBinding

class LandOwnerAdding : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //this set the softKeyboard to popup where the InputView is so input can still be visible
        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        return inflater.inflate(R.layout.fragment_land_owner_adding, container, false)
    }

    companion object {
        fun getInstance(): LandOwnerAdding {
            return LandOwnerAdding()
        }
    }

}