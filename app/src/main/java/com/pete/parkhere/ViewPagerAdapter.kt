package com.pete.parkhere

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pete.parkhere.presentation.landowner_adding.LandOwnerAddingFragment

class ViewPagerAdapter(
    fa: Fragment
) : FragmentStateAdapter(fa) {

    // index[0] = RecyclerViewPage, index[1] = Fill in LocationPage
    private val fragmentsList = listOf(
        LandOwnerAddingFragment.getInstance()
    )
    private val itemIds = listOf<Long>(0L, 1L)

    override fun createFragment(position: Int): Fragment {
        return fragmentsList[position]
    }

    override fun getItemCount(): Int {
        return fragmentsList.size
    }

}