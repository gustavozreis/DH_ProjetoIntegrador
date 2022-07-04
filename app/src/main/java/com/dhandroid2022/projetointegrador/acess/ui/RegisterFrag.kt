package com.dhandroid2022.projetointegrador.acess.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.acess.viewmodel.RegisterViewModel
import com.dhandroid2022.projetointegrador.acess.data.Result
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegisterFrag:Fragment(R.layout.register_frag){

    private val viewModel: RegisterViewModel by viewModels()

    private lateinit var clContent: ConstraintLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var tilEmail: TextInputLayout
    private lateinit var etEmail: TextInputEditText
    private lateinit var tilPassword: TextInputLayout
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnRegister: MaterialButton


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setupListeners()
        setupObserver()
    }

    private fun initViews(view: View) {
        clContent = view.findViewById(R.id.register_content)
        progressBar = view.findViewById(R.id.register_progress)
        tilEmail = view.findViewById(R.id.til_login_email)
        etEmail = view.findViewById(R.id.et_email)
        tilPassword = view.findViewById(R.id.til_login_password)
        etPassword = view.findViewById(R.id.et_password)
        btnRegister = view.findViewById(R.id.btn_register)

    }

    private fun setupListeners() {
        btnRegister.setOnClickListener {
            clearErrors()
            val email = etEmail.text.toString()
            val pwd = etPassword.text.toString()
            if (viewModel.isValidEmail(email).not()) {
                showInvalidEmailError()
                return@setOnClickListener
            } else if (viewModel.isValidPassword(pwd).not()) {
                showInvalidPasswordError()
                return@setOnClickListener
            }
            viewModel.doRegister(email, pwd)
        }

    }

    private fun clearErrors() {
        tilEmail.error = null
        tilPassword.error = null
    }

    private fun showInvalidEmailError() {
        tilEmail.error = EMAIL_ERROR_MSG
    }

    private fun showInvalidPasswordError() {
        tilPassword.error = PASSWORD_ERROR_MSG
    }

    private fun setupObserver() {
        viewModel.registerLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Result.Loading -> showLoading()
                is Result.Error -> showError()
                is Result.Success<*> -> showSuccess()
            }
        }
    }

    private fun showLoading() {
        progressBar.isVisible = true
        clContent.isVisible = false
    }

    private fun showError() {
        showContent()
        Toast.makeText(
            requireContext(),
            GENERIC_ERROR_MSG,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun showContent() {
        progressBar.isVisible = false
        clContent.isVisible = true
    }

    private fun showSuccess() {
        showContent()
        btnRegister.isEnabled = false
        tilEmail.isEnabled = false
        tilPassword.isEnabled = false
        Toast.makeText(
            requireContext(),
            SUCCESS_MSG,
            Toast.LENGTH_SHORT
        ).show()
    }

    companion object {
        private const val SUCCESS_MSG = "Usuario cadastrado com sucesso!"
        private const val GENERIC_ERROR_MSG = "Algo deu errado,tente novamente."
        private const val EMAIL_ERROR_MSG = "E-mail invalido."
        private const val PASSWORD_ERROR_MSG = "A senha tem que ter 8 caracteres."
    }
}