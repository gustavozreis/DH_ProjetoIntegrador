package com.dhandroid2022.projetointegrador.ui.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dhandroid2022.projetointegrador.ui.Adapter.HeroesListAdapter
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.data.comicDTO.ComicDTO
import com.dhandroid2022.projetointegrador.data.heroDTO.HeroDTO
import com.dhandroid2022.projetointegrador.data.repositories.HeroRepository
import com.dhandroid2022.projetointegrador.databinding.FragmentHeroesListBinding
import com.dhandroid2022.projetointegrador.ui.ViewModels.HeroesFragmentViewModel
import kotlinx.coroutines.launch

class HeroesListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private val viewModel: HeroesFragmentViewModel by viewModels()

    private var _binding: FragmentHeroesListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHeroesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpBinding()
        setUpObservers()

    }

    private fun setUpBinding() {
        recyclerView = binding.heroesListRecyclerview
    }

    private fun setUpObservers() {
        viewModel.heroesList.observe(this.viewLifecycleOwner) { heroListLiveData ->
            val heroList = mutableListOf<HeroDTO>()
            for (hero in heroListLiveData) {
                heroList.add(hero)
            }

            val recyclerViewAdapter = HeroesListAdapter(this.context, heroList, findNavController())
            recyclerView.adapter = recyclerViewAdapter
        }
    }
}