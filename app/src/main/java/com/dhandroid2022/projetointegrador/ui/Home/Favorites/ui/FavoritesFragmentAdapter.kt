package com.dhandroid2022.projetointegrador.ui.Home.Favorites.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.data.favorites.FavoriteHero
import com.dhandroid2022.projetointegrador.ui.Home.HeroList.ui.HeroesListAdapter
import com.dhandroid2022.projetointegrador.ui.Home.HomeFragmentDirections

class FavoritesFragmentAdapter(
    private val context: Context,
    private val favList: MutableList<FavoriteHero>,
    private val navController: NavController
    )  :
    RecyclerView.Adapter<FavoritesFragmentAdapter.FavoritesViewHolder>(){

        inner class FavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val heroName: TextView = itemView.findViewById(R.id.heroes_list_item_name)
            val heroThumbnail: ImageView = itemView.findViewById(R.id.heroes_list_item_thumbnail)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val layoutInflater = LayoutInflater.from(context).inflate(R.layout.fragment_favorites_list_item, parent, false)
        return FavoritesViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        val heroName = favList[position].name
        val heroID = favList[position].id
        val heroDescription = favList[position].description

        val thumbnailUrl: String = favList[position].thumbUrl

        holder.heroName.text = heroName
        insertImageFromUrl(thumbnailUrl, holder.heroThumbnail)

        holder.heroThumbnail.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToHeroDetailFragment(
                thumbnailUrl,
                heroName,
                heroID.toString(),
                heroDescription,
            )
            navController.navigate(action)
        }
    }

    override fun getItemCount(): Int = favList.size

    private fun insertImageFromUrl(url: String, view: ImageView) {
        Glide.with(context)
            .load(url)
            .into(view)
    }
}