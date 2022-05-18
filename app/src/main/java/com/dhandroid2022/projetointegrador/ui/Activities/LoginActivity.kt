package com.dhandroid2022.projetointegrador.ui.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.dhandroid2022.projetointegrador.ui.Adapter.ViewPagerAdapter
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.ui.Fragments.Login_frag
import com.dhandroid2022.projetointegrador.ui.Fragments.Sign_in_frag
import com.google.android.material.tabs.TabLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.add(Login_frag(), "Entrar")
        adapter.add(Sign_in_frag(), "Registrar")

        val pager = findViewById<ViewPager>(R.id.myviewpager)
        pager.adapter = adapter

        val tabLayout = findViewById<TabLayout>(R.id.mytablayout)
        tabLayout.setupWithViewPager(pager)

    }

}