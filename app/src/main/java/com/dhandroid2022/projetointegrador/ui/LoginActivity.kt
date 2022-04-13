package com.dhandroid2022.projetointegrador.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.ui.mainmenu.HomeActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEntrar: Button = findViewById(R.id.btn_entrar)
        btnEntrar.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}