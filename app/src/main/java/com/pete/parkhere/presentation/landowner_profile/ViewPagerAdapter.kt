package com.pete.parkhere.presentation.landowner_profile

import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.pete.parkhere.R
import com.pete.parkhere.presentation.landowner_adding.LandOwnerAdding

class ViewPagerAdapter(
    fa: Fragment,val radioGroupTab: RadioGroup
) : FragmentStateAdapter(fa) {

    // index[0] = RecyclerViewPage, index[1] = Fill in LocationPage
    private val fragmentsList = listOf(
        LocationsListFragment.getInstance(),
        LandOwnerAdding.getInstance()
    )
    private val itemIds = listOf<Long>(0L, 1L)

    override fun createFragment(position: Int): Fragment {
        return fragmentsList[position]
    }

    override fun getItemCount(): Int {
        return fragmentsList.size
    }

}