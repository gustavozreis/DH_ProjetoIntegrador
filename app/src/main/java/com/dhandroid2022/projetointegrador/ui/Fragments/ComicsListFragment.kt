package com.dhandroid2022.projetointegrador.ui.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dhandroid2022.projetointegrador.R

class ComicsListFragment : Fragment(R.layout.fragment_comics_list) {

    companion object {
        fun create() = HeroesListFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}

