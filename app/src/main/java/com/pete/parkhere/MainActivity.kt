package com.pete.parkhere

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.core.view.doOnLayout
import androidx.navigation.Navigation
import com.google.android.material.tabs.TabLayout
import com.pete.parkhere.R
import com.pete.parkhere.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.choiceTablayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val navController = Navigation.findNavController(this@MainActivity,R.id.nav_host_fragment_container)
                when(tab!!.position) {
                    0 -> { navController.navigate(R.id.action_landOwnerAdding_to_landOwnerProfileFragment) }
                    1 -> { navController.navigate(R.id.action_landOwnerProfileFragment_to_landOwnerAdding) }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

}