package com.dhandroid2022.projetointegrador.ui.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.ui.Activities.HomeActivity

class Login_frag : Fragment(R.layout.login_frag) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnEntrar = view.findViewById<Button>(R.id.btn_entrar)
        btnEntrar.setOnClickListener {
            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)
        }
        val esqueceuSenha = view.findViewById<TextView>(R.id.textViewEsqueceuSenha)
        esqueceuSenha.setOnClickListener {
            Toast.makeText(requireContext(), "Devo uma recuperação de senha", Toast.LENGTH_SHORT).show()
        }
        val gLogin = view.findViewById<ImageView>(R.id.imageViewGoogle)
        gLogin.setOnClickListener {
            Toast.makeText(requireContext(), "Devo um Login com Google", Toast.LENGTH_SHORT).show()
        }
        val faceLogin = view.findViewById<ImageView>(R.id.imageViewFace)
        faceLogin.setOnClickListener {
            Toast.makeText(requireContext(), "Devo um Login com Facebook", Toast.LENGTH_SHORT).show()
        }
    }
}