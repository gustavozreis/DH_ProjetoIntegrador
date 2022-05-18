package com.dhandroid2022.projetointegrador.ui.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dhandroid2022.projetointegrador.R

class Sign_in_frag:Fragment(R.layout.sign_in_frag){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSalvar = view.findViewById<Button>(R.id.btn_salvar)
        btnSalvar.setOnClickListener {
            Toast.makeText(requireContext(), "Salvo", Toast.LENGTH_SHORT).show()
        }

    }
}