package com.dhandroid2022.projetointegrador.ui.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.data.dto.HeroDTO
import com.dhandroid2022.projetointegrador.ui.Activities.HeroDetailActivity

class HeroesListAdapter(val context: Context, val heroesList: List<HeroDTO>)
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
        holder.heroThumbnail.setOnClickListener {
            val intent = Intent(context, HeroDetailActivity::class.java)
            intent.putExtra("hero_id", heroesList[position].charId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return heroesList.size
    }

}