package com.dhandroid2022.projetointegrador.ui.Home.ComicDetails

import android.app.SearchManager
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.dhandroid2022.projetointegrador.R

class ComicDetailsFragment : Fragment(R.layout.fragment_comic_detail) {

    private lateinit var ivComicImage: ImageView
    private lateinit var ivComicTitle: TextView
    private lateinit var btnSearch: Button
    private lateinit var btnDownload: Button

    private var comicTitle: String? = null
    private var comicThumbnailUrl: String? = null
    private var comicId: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupArgs()
        setupBindings()
        changeComicDetails()
        setupListeners()

    }

    private fun changeComicDetails() {
        ivComicTitle.text = comicTitle
        Glide.with(requireContext())
            .load(comicThumbnailUrl)
            .into(ivComicImage)
    }

    private fun setupBindings() {
        ivComicImage = requireView().findViewById(R.id.iv_comicImg)
        ivComicTitle = requireView().findViewById(R.id.tv_comicName)
        btnSearch = requireView().findViewById(R.id.btn_search_comic)
        btnDownload = requireView().findViewById(R.id.btn_download)
    }

    private fun setupArgs() {

        val args2 = arguments?.let {
            ComicDetailsFragmentArgs.fromBundle(it)
        }
        comicTitle = args2?.comicTitle
        comicThumbnailUrl = args2?.comicThumbUrl
        comicId = args2?.comicId
    }

    private fun setupListeners() {
        btnSearch.setOnClickListener {
            val intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, comicTitle)
            startActivity(intent)
        }

        btnDownload.setOnClickListener {
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.marvel.unlimited")))
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.marvel.unlimited")))
            }
        }
    }
}

