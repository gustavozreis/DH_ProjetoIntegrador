package com.dhandroid2022.projetointegrador.ui.home.comics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.data.Comics
import com.dhandroid2022.projetointegrador.data.HeroesBuilder
import com.dhandroid2022.projetointegrador.ui.home.heroes.HeroesListAdapter
import com.dhandroid2022.projetointegrador.ui.home.heroes.HeroesListFragment

class ComicsListFragment : Fragment(R.layout.fragment_comics_list) {

    companion object {
        fun create() = HeroesListFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Essa lista de quadrinhos de teste é somente pra ter algo para criar o herói, alteramos depois
        var comicListTest = listOf(Comics("teste"), Comics("teste"))

        val heroesBuilder = HeroesBuilder()
        heroesBuilder.createHero("Thor", "teste", comicListTest, R.drawable.thor)
        heroesBuilder.createHero("Captain America","teste", comicListTest, R.drawable.captainamerica)
        heroesBuilder.createHero("Black Widow", "teste", comicListTest, R.drawable.blackwidow)
        heroesBuilder.createHero("Hulk", "teste", comicListTest, R.drawable.hulk)
        heroesBuilder.createHero("Spider Man", "teste", comicListTest, R.drawable.spiderman)
        heroesBuilder.createHero("Thor", "teste", comicListTest, R.drawable.thor)
        heroesBuilder.createHero("Captain America", "teste", comicListTest, R.drawable.captainamerica)
        heroesBuilder.createHero("Black Widow", "teste", comicListTest, R.drawable.blackwidow)
        heroesBuilder.createHero("Hulk", "teste", comicListTest, R.drawable.hulk)
        heroesBuilder.createHero("Spider Man", "teste", comicListTest, R.drawable.spiderman)
        heroesBuilder.createHero("Thor", "teste", comicListTest, R.drawable.thor)
        heroesBuilder.createHero("Captain America", "teste", comicListTest, R.drawable.captainamerica)
        heroesBuilder.createHero("Black Widow", "teste", comicListTest, R.drawable.blackwidow)
        heroesBuilder.createHero("Hulk", "teste", comicListTest, R.drawable.hulk)
        heroesBuilder.createHero("Spider Man", "teste", comicListTest, R.drawable.spiderman)

        val recyclerView: RecyclerView = view.findViewById(R.id.heroes_list_recyclerview)
        val recyclerViewAdapter = HeroesListAdapter(this.requireContext(), heroesBuilder.heroesList)
        recyclerView.adapter = recyclerViewAdapter

    }
}

