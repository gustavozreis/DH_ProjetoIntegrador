package com.dhandroid2022.projetointegrador.ui.Home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.ui.Home.Favorites.ui.FavoritesFragment
import com.dhandroid2022.projetointegrador.ui.Home.HeroList.ui.HeroesListFragment
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewPager()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() {
                    // Handle the back button even
                    Log.d("BACKBUTTON", "Back button clicks")
                }
            }

        requireActivity().onBackPressedDispatcher.addCallback(this, callback)

    }

    private fun setUpViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(childFragmentManager)
        viewPagerAdapter.apply {
            this.add(HeroesListFragment(), "Heroes")
            this.add(FavoritesFragment(), "Favorites")
        }

        viewPager = requireView().findViewById(R.id.home_view_pager)
        viewPager.adapter = viewPagerAdapter

        tabLayout = requireView().findViewById(R.id.home_tab_layout)
        tabLayout.setupWithViewPager(viewPager)
    }


}