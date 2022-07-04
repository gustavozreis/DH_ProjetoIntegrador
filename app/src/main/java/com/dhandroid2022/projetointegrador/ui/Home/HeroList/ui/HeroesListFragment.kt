package com.dhandroid2022.projetointegrador.ui.Home.HeroList.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.data.heroDTO.HeroDTO
import com.dhandroid2022.projetointegrador.databinding.FragmentHeroesListBinding
import com.dhandroid2022.projetointegrador.ui.Home.HeroList.viewmodel.HeroesListFragmentViewModel

class HeroesListFragment : Fragment(R.layout.fragment_heroes_list) {

    private lateinit var recyclerView: RecyclerView

    private val viewModel: HeroesListFragmentViewModel by viewModels()

    private var _binding: FragmentHeroesListBinding? = null
    private val binding get() = _binding!!

    private var heroList: MutableList<HeroDTO> = mutableListOf()

    private var fragOffset = 100
    private var offsetCheck = 0

    private var rvAdapter: HeroesListAdapter? = null

    private var isLoading = false

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

        setUpAdapter()
        setUpObservers()
        setUpBinding()
        setUpRecyclerView()

    }

    private fun setUpBinding() {
        recyclerView = binding.heroesListRecyclerview
    }

    private fun setUpObservers() {
        viewModel.heroesToAdd.observe(this.viewLifecycleOwner) { heroListLiveData ->
            val heroList = mutableListOf<HeroDTO>()
            for (hero in heroListLiveData) {
                heroList.add(hero)
            }
            rvAdapter?.addData(heroList)
        }

        viewModel.offset.observe(this.viewLifecycleOwner) { vmOffset ->
            fragOffset = vmOffset
        }

        viewModel.isLoading.observe(this.viewLifecycleOwner) { isLoadingLiveData ->
            isLoading = isLoadingLiveData
        }
    }

    private fun setUpAdapter() {
        rvAdapter = HeroesListAdapter(this.context, heroList, findNavController())
    }

    private fun setUpRecyclerView() {
        recyclerView.apply {
            this.adapter = rvAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val target = recyclerView.layoutManager as GridLayoutManager?
                    val totalItemCount = target!!.itemCount
                    val lastVisible = target.findLastVisibleItemPosition()
                    val lastItem = lastVisible +5 >= totalItemCount

                    if (totalItemCount > 0 && lastItem){
                        if(fragOffset <= 1500 && !isLoading)
                            viewModel.getHeroes()
                            offsetCheck += 100
                    }


                }
            })
        }
    }
}