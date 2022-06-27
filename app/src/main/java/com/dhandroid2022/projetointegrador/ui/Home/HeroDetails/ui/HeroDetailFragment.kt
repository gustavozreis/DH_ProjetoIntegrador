package com.dhandroid2022.projetointegrador.ui.Home.HeroDetails.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.data.comicDTO.ComicDTO
import com.dhandroid2022.projetointegrador.data.favorites.FavoriteHero
import com.dhandroid2022.projetointegrador.data.favorites.FavoritesApplication
import com.dhandroid2022.projetointegrador.ui.Home.HeroDetails.viewmodel.HeroDetailsFragmentViewModel
import com.dhandroid2022.projetointegrador.ui.Home.HeroDetails.viewmodel.HeroDetailsFragmentViewModelFactory

class HeroDetailFragment : Fragment(R.layout.fragment_hero_detail) {

    private lateinit var heroThumbnailView: ImageView
    private lateinit var heroNameView: TextView
    private lateinit var heroDescriptionView: TextView
    private lateinit var addToFavoritesBtn: Button

    private lateinit var heroName: String
    private lateinit var heroThumbUrl: String
    private lateinit var heroID: String
    private lateinit var heroDescription: String

    private var comicList: MutableList<ComicDTO> = mutableListOf()
    private lateinit var comicsRecyclerView: RecyclerView

    private val viewModel: HeroDetailsFragmentViewModel by activityViewModels {
        HeroDetailsFragmentViewModelFactory(
            (activity?.application as FavoritesApplication).database.favoriteHeroDao()
        )
    }

    private var favList: MutableList<FavoriteHero> = mutableListOf<FavoriteHero>()

    private val args: com.dhandroid2022.projetointegrador.ui.Home.HeroDetails.ui.HeroDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpArgs()
        setUpBindings()
        setUpObserver()
        getHeroDetails(heroID)
        changeHeroDetails()
        sendHeroIdToViewModel(heroID)
        setUpFavButton(addToFavoritesBtn)
        //setUpComicRecyclerView()
    }

    private fun getHeroDetails(heroID: String) {
        viewModel.getHeroDetails(heroID)
    }

    private fun setUpObserver() {

        viewModel.comicList.observe(this.viewLifecycleOwner) { vmComicList ->
            for (comic in vmComicList) {
                comicList.add(comic)
            }
            setUpComicRecyclerView(comicList)
        }
        favList = viewModel.favoritesList.value!!
        viewModel.favoritesList.observe(this.viewLifecycleOwner) { favListLD ->
            favList = favListLD
            setUpFavButton(addToFavoritesBtn)
        }
    }

    private fun sendHeroIdToViewModel(heroID: String) {
        viewModel.getComicList(heroID)
    }

    private fun setUpComicRecyclerView(list: MutableList<ComicDTO>) {
        val rvAdapter = HeroDetailFragmentAdapter(requireContext(), list, findNavController())
        comicsRecyclerView.adapter = rvAdapter
    }

    private fun setUpArgs() {
        heroName = args.heroName
        heroThumbUrl = args.heroThumbUrl
        heroID = args.heroID
        heroDescription = args.heroDescription
    }

    private fun changeHeroDetails() {
        Glide.with(this)
            .load(heroThumbUrl)
            .into(heroThumbnailView)

        heroNameView.text = heroName
        if(heroDescription != "") {
            heroDescriptionView.text = heroDescription
        } else {
            heroDescriptionView.text = "Sem descrição."
        }

    }

    private fun setUpBindings() {
        heroThumbnailView = requireView().findViewById(R.id.imageview_hero_thumbnail)
        heroNameView = requireView().findViewById(R.id.textview_hero_name)
        heroDescriptionView = requireView().findViewById(R.id.textview_hero_description)
        comicsRecyclerView = requireView().findViewById(R.id.rv_comic_list)
        addToFavoritesBtn = requireView().findViewById(R.id.btn_favorite)
    }

    private fun addToFavorites() {
        viewModel.addToFavorites(heroID, heroName, heroThumbUrl)
    }

    private fun removeFromFavorites() {
        viewModel.removeFromFavorites(heroID)
    }

    private fun setUpFavButton(favButton: Button) {
        val tempList = mutableListOf<String>()
        for (favHero in favList) {
            tempList.add(favHero.id.toString())
            if (tempList.contains(heroID)){
                favButton.text = "REMOVER DOS FAVORITOS"
            } else {
                favButton.text = "ADICIONAR AOS FAVORITOS"
            }
        }
        favButton.setOnClickListener {
            var tempList2 = mutableListOf<String>()
            for (favHero in favList) {
                tempList2.add(favHero.id.toString())
            }
            if (tempList2.contains(heroID)){
                removeFromFavorites()
                favButton.text = "ADICIONAR AOS FAVORITOS"
            } else {
                addToFavorites()
                favButton.text = "REMOVER DOS FAVORITOS"
            }


        }


    }
}