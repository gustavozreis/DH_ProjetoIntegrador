package com.dhandroid2022.projetointegrador.ui.Home.Favorites.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.data.favorites.FavoriteHero
import com.dhandroid2022.projetointegrador.data.favorites.FavoritesApplication
import com.dhandroid2022.projetointegrador.ui.Home.Favorites.viewmodel.FavoritesFragmentViewModel
import com.dhandroid2022.projetointegrador.ui.Home.Favorites.viewmodel.FavoritesFragmentViewModelFactory
import com.dhandroid2022.projetointegrador.ui.Home.HeroDetails.viewmodel.HeroDetailsFragmentViewModel
import com.dhandroid2022.projetointegrador.ui.Home.HeroDetails.viewmodel.HeroDetailsFragmentViewModelFactory

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    private lateinit var rvFavList: RecyclerView
    private var favList: MutableList<FavoriteHero> = mutableListOf()

    private val viewModel: FavoritesFragmentViewModel by activityViewModels {
        FavoritesFragmentViewModelFactory(
            (activity?.application as FavoritesApplication).database.favoriteHeroDao()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favList = viewModel.favoritesList.value!!
        setupBindings()
        setupRecyclerView(favList)
        setupObservers()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getFavoritesList()
    }

    private fun setupBindings() {
        rvFavList = requireView().findViewById(R.id.rv_favlist)
    }

    private fun setupObservers() {
        viewModel.favoritesList.observe(this.viewLifecycleOwner) { vmFavList ->
            favList = vmFavList
            setupRecyclerView(favList)
        }
    }

    private fun setupRecyclerView(list: MutableList<FavoriteHero>) {
        val rvAdapter = FavoritesFragmentAdapter(requireContext(), list, findNavController())
        rvFavList.adapter = rvAdapter
    }





}