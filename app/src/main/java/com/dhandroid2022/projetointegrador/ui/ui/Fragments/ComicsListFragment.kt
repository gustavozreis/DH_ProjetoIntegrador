package com.dhandroid2022.projetointegrador.ui.ui.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.data.ComicModel
import com.dhandroid2022.projetointegrador.data.HeroesBuilder
import com.dhandroid2022.projetointegrador.Adapter.HeroesListAdapter
import com.dhandroid2022.projetointegrador.data.HeroDBMock

class ComicsListFragment : Fragment(R.layout.fragment_comics_list) {

    companion object {
        fun create() = HeroesListFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Essa lista de quadrinhos de teste é somente pra ter algo para criar o herói, alteramos depois
        var comicListTest = listOf(ComicModel("teste"), ComicModel("teste"))

        val recyclerView: RecyclerView = view.findViewById(R.id.heroes_list_recyclerview)
        val recyclerViewAdapter = HeroesListAdapter(this.requireContext(), HeroDBMock.heroesList)
        recyclerView.adapter = recyclerViewAdapter

    }
}

