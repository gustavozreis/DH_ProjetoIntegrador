package com.dhandroid2022.projetointegrador.acess.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.dhandroid2022.projetointegrador.ui.Home.ViewPagerAdapter
import com.dhandroid2022.projetointegrador.R
import com.google.android.material.tabs.TabLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.add(LoginFrag(), "Entrar")
        adapter.add(RegisterFrag(), "Registrar")

        val pager = findViewById<ViewPager>(R.id.myviewpager)
        pager.adapter = adapter

        val tabLayout = findViewById<TabLayout>(R.id.mytablayout)
        tabLayout.setupWithViewPager(pager)

    }

}