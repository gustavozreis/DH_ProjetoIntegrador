package com.dhandroid2022.projetointegrador.ui.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.data.HeroDBMock

class HeroDetailActivity : AppCompatActivity() {

    private lateinit var heroThumbnail: ImageView
    private lateinit var heroName: TextView
    private lateinit var heroDescription: TextView

    private var heroId: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_detail)

        heroId = intent.getIntExtra("hero_id", 1)

        heroThumbnail = findViewById(R.id.imageview_hero_thumbnail)
        heroName = findViewById(R.id.textview_hero_name)
        heroDescription = findViewById(R.id.textview_hero_description)

        getHeroFromDatabase()

    }

    override fun onBackPressed() {
        finish()
    }

    private fun getHeroFromDatabase() {
        var heroId = heroId
        for (hero in HeroDBMock.heroesList) {
            if(hero.charId == heroId) {
                heroThumbnail.setImageResource(hero.charThumbnail)
                heroName.text = hero.charName
                heroDescription.text = hero.charDescription
            }
        }
    }
}