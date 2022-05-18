package com.dhandroid2022.projetointegrador.ui.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.dhandroid2022.projetointegrador.ui.Adapter.HeroesListAdapter
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.data.dto.ComicDTO
import com.dhandroid2022.projetointegrador.data.HeroDBMock
import com.dhandroid2022.projetointegrador.data.HeroesBuilder

class HeroesListFragment : Fragment(R.layout.fragment_heroes_list) {

    companion object {
        fun create() = HeroesListFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Essa lista de quadrinhos de teste é somente pra ter algo para criar o herói, alteramos depois
        var comicDTOListTests = listOf(ComicDTO("teste"), ComicDTO("teste"))

        createMockHeroesList(comicDTOListTests)

        val recyclerView: RecyclerView = view.findViewById(R.id.heroes_list_recyclerview)
        val recyclerViewAdapter = HeroesListAdapter(this.requireContext(), HeroDBMock.heroesList)
        recyclerView.adapter = recyclerViewAdapter

    }

    private fun createMockHeroesList(comicDTOListTest: List<ComicDTO>) {
        val heroesBuilder = HeroesBuilder()
        HeroDBMock.createHero(1,
            "Thor",
            "Thor é um personagem fictício que aparece nas histórias em quadrinhos, publicadas pela Marvel Comics, baseadas no deus Thor da Mitologia Nórdica, ele foi criado por Stan Lee e Jack Kirby. Sua principal arma é o martelo Mjonir.",
            comicDTOListTest,
            R.drawable.thor)
        HeroDBMock.createHero(2,
            "Captain America",
            "Thor é um personagem fictício que aparece nas histórias em quadrinhos, publicadas pela Marvel Comics, baseadas no deus Thor da Mitologia Nórdica, ele foi criado por Stan Lee e Jack Kirby. Sua principal arma é o martelo Mjonir.",
            comicDTOListTest,
            R.drawable.captainamerica)
        HeroDBMock.createHero(3,
            "Black Widow",
            "Thor é um personagem fictício que aparece nas histórias em quadrinhos, publicadas pela Marvel Comics, baseadas no deus Thor da Mitologia Nórdica, ele foi criado por Stan Lee e Jack Kirby. Sua principal arma é o martelo Mjonir.",
            comicDTOListTest,
            R.drawable.blackwidow)
        HeroDBMock.createHero(4,
            "Hulk",
            "Thor é um personagem fictício que aparece nas histórias em quadrinhos, publicadas pela Marvel Comics, baseadas no deus Thor da Mitologia Nórdica, ele foi criado por Stan Lee e Jack Kirby. Sua principal arma é o martelo Mjonir.",
            comicDTOListTest,
            R.drawable.hulk)
        HeroDBMock.createHero(5,
            "Spider Man",
            "Thor é um personagem fictício que aparece nas histórias em quadrinhos, publicadas pela Marvel Comics, baseadas no deus Thor da Mitologia Nórdica, ele foi criado por Stan Lee e Jack Kirby. Sua principal arma é o martelo Mjonir.",
            comicDTOListTest,
            R.drawable.spiderman)
        HeroDBMock.createHero(6,
            "Thor",
            "Thor é um personagem fictício que aparece nas histórias em quadrinhos, publicadas pela Marvel Comics, baseadas no deus Thor da Mitologia Nórdica, ele foi criado por Stan Lee e Jack Kirby. Sua principal arma é o martelo Mjonir.",
            comicDTOListTest,
            R.drawable.thor)
        HeroDBMock.createHero(7,
            "Captain America",
            "Thor é um personagem fictício que aparece nas histórias em quadrinhos, publicadas pela Marvel Comics, baseadas no deus Thor da Mitologia Nórdica, ele foi criado por Stan Lee e Jack Kirby. Sua principal arma é o martelo Mjonir.",
            comicDTOListTest,
            R.drawable.captainamerica)
        HeroDBMock.createHero(8,
            "Black Widow",
            "Thor é um personagem fictício que aparece nas histórias em quadrinhos, publicadas pela Marvel Comics, baseadas no deus Thor da Mitologia Nórdica, ele foi criado por Stan Lee e Jack Kirby. Sua principal arma é o martelo Mjonir.",
            comicDTOListTest,
            R.drawable.blackwidow)
        HeroDBMock.createHero(9,
            "Hulk",
            "Thor é um personagem fictício que aparece nas histórias em quadrinhos, publicadas pela Marvel Comics, baseadas no deus Thor da Mitologia Nórdica, ele foi criado por Stan Lee e Jack Kirby. Sua principal arma é o martelo Mjonir.",
            comicDTOListTest,
            R.drawable.hulk)
        HeroDBMock.createHero(10,
            "Spider Man",
            "Thor é um personagem fictício que aparece nas histórias em quadrinhos, publicadas pela Marvel Comics, baseadas no deus Thor da Mitologia Nórdica, ele foi criado por Stan Lee e Jack Kirby. Sua principal arma é o martelo Mjonir.e",
            comicDTOListTest,
            R.drawable.spiderman)
        HeroDBMock.createHero(11,
            "Thor",
            "Thor é um personagem fictício que aparece nas histórias em quadrinhos, publicadas pela Marvel Comics, baseadas no deus Thor da Mitologia Nórdica, ele foi criado por Stan Lee e Jack Kirby. Sua principal arma é o martelo Mjonir.",
            comicDTOListTest,
            R.drawable.thor)
        HeroDBMock.createHero(12,
            "Captain America",
            "Thor é um personagem fictício que aparece nas histórias em quadrinhos, publicadas pela Marvel Comics, baseadas no deus Thor da Mitologia Nórdica, ele foi criado por Stan Lee e Jack Kirby. Sua principal arma é o martelo Mjonir.",
            comicDTOListTest,
            R.drawable.captainamerica)
        HeroDBMock.createHero(13,
            "Black Widow",
            "Thor é um personagem fictício que aparece nas histórias em quadrinhos, publicadas pela Marvel Comics, baseadas no deus Thor da Mitologia Nórdica, ele foi criado por Stan Lee e Jack Kirby. Sua principal arma é o martelo Mjonir.",
            comicDTOListTest,
            R.drawable.blackwidow)
        HeroDBMock.createHero(14,
            "Hulk",
            "Thor é um personagem fictício que aparece nas histórias em quadrinhos, publicadas pela Marvel Comics, baseadas no deus Thor da Mitologia Nórdica, ele foi criado por Stan Lee e Jack Kirby. Sua principal arma é o martelo Mjonir.",
            comicDTOListTest,
            R.drawable.hulk)
        HeroDBMock.createHero(15,
            "Spider Man",
            "Thor é um personagem fictício que aparece nas histórias em quadrinhos, publicadas pela Marvel Comics, baseadas no deus Thor da Mitologia Nórdica, ele foi criado por Stan Lee e Jack Kirby. Sua principal arma é o martelo Mjonir.",
            comicDTOListTest,
            R.drawable.spiderman)
    }

}