package com.dhandroid2022.projetointegrador.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.data.Hero

class HeroesListAdapter(val context: Context, val heroesList: List<Hero>)
    : RecyclerView.Adapter<HeroesListAdapter.HeroViewHolder>() {

    inner class HeroViewHolder(itemView: View)  : RecyclerView.ViewHolder(itemView) {
        val heroName: TextView = itemView.findViewById(R.id.heroes_list_item_name)
        val heroThumbnail: ImageView = itemView.findViewById(R.id.heroes_list_item_thumbnail)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): HeroViewHolder {
        val layoutInflater = LayoutInflater.from(context).inflate(R.layout.fragment_heroes_list_item, parent, false)
        return HeroViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.heroName.text = heroesList[position].charName
        holder.heroThumbnail.setImageResource(heroesList[position].charThumbnail)
    }

    override fun getItemCount(): Int {
        return heroesList.size
    }

}