package com.dhandroid2022.projetointegrador.ui.ui.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.dhandroid2022.projetointegrador.Adapter.HomeViewPagerAdapter
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.ui.ui.Fragments.ComicsListFragment
import com.dhandroid2022.projetointegrador.ui.ui.Fragments.HeroesListFragment
import com.google.android.material.tabs.TabLayout

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val viewPagerAdapter = HomeViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.add(HeroesListFragment(), "Heroes")
        viewPagerAdapter.add(ComicsListFragment(), "Comics")

        val viewPagerHome: ViewPager = findViewById(R.id.viewpager_home)
        viewPagerHome.adapter = viewPagerAdapter

        val tabLayoutHome: TabLayout = findViewById(R.id.tablayout_home)
        tabLayoutHome.setupWithViewPager(viewPagerHome)

    }

    fun teste(): Int {
        return 1+1
    }
}