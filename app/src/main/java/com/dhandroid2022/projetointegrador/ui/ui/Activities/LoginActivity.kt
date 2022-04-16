package com.dhandroid2022.projetointegrador.ui.ui.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.dhandroid2022.projetointegrador.Adapter.HomeViewPagerAdapter
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.ui.ui.Fragments.Login_frag
import com.dhandroid2022.projetointegrador.ui.ui.Fragments.Sign_in_frag
import com.google.android.material.tabs.TabLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter = HomeViewPagerAdapter(supportFragmentManager)
        adapter.add(Login_frag(), "Entrar")
        adapter.add(Sign_in_frag(),"Registrar")

        var pager = findViewById<ViewPager>(R.id.myviewpager)
        pager.adapter = adapter

        var tabLayout = findViewById<TabLayout>(R.id.mytablayout)
        tabLayout.setupWithViewPager(pager)

        }

    }