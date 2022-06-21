package com.dhandroid2022.projetointegrador.ui.Home.HeroDetails.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.ui.Home.HeroDetails.viewmodel.HeroDetailsFragmentViewModel

class HeroDetailFragment : Fragment(R.layout.fragment_hero_detail) {

    private lateinit var heroThumbnailView: ImageView
    private lateinit var heroNameView: TextView
    private lateinit var heroDescriptionView: TextView

    private lateinit var heroName: String
    private lateinit var heroThumbUrl: String
    private lateinit var heroID: String
    private lateinit var heroDescription: String

    private val viewModel: HeroDetailsFragmentViewModel by viewModels()

    private val args: com.dhandroid2022.projetointegrador.ui.Home.HeroDetails.ui.HeroDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpArgs()
        setUpBindings()
        //setUpObserver()
        getHeroDetails(heroID)
        changeHeroDetails()
    }

    private fun getHeroDetails(heroID: String) {
        viewModel.getHeroDetails(heroID)
    }

    private fun setUpObserver() {
        viewModel.hero.observe(this.viewLifecycleOwner) { hero ->
            heroDescriptionView.setText(hero.description)
        }
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
        heroDescriptionView.text = heroDescription
    }

    private fun setUpBindings() {
        heroThumbnailView = requireView().findViewById(R.id.imageview_hero_thumbnail)
        heroNameView = requireView().findViewById(R.id.textview_hero_name)
        heroDescriptionView = requireView().findViewById(R.id.textview_hero_description)
    }

}