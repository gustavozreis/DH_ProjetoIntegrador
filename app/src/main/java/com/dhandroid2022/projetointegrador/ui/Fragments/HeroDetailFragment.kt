package com.dhandroid2022.projetointegrador.ui.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.dhandroid2022.projetointegrador.R

class HeroDetailFragment : Fragment(R.layout.fragment_hero_detail) {

    private lateinit var heroThumbnailView: ImageView
    private lateinit var heroNameView: TextView

    private lateinit var heroName: String
    private lateinit var heroThumbUrl: String

    private val args: HeroDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpArgs()
        setUpBindings()
        changeHeroDetails()
    }

    private fun setUpArgs() {
        heroName = args.heroName
        heroThumbUrl = args.heroThumbUrl
    }

    private fun changeHeroDetails() {
            Glide.with(this)
                .load(heroThumbUrl)
                .into(heroThumbnailView)

        heroNameView.text = heroName
    }

    private fun setUpBindings() {
        heroThumbnailView = requireView().findViewById(R.id.imageview_hero_thumbnail)
        heroNameView = requireView().findViewById(R.id.textview_hero_name)
    }

}