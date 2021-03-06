package com.dhandroid2022.projetointegrador.acess.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dhandroid2022.projetointegrador.R
import com.dhandroid2022.projetointegrador.acess.data.Result
import com.dhandroid2022.projetointegrador.acess.viewmodel.LoginViewModel
import com.dhandroid2022.projetointegrador.ui.Home.HomeActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginFrag : Fragment(R.layout.login_frag) {

    private val viewModel: LoginViewModel by viewModels()

    private lateinit var clContent: ConstraintLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var tilEmail: TextInputLayout
    private lateinit var etEmail: TextInputEditText
    private lateinit var tilPassword: TextInputLayout
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnLogin: MaterialButton
    private lateinit var googleLogin: ImageView
    private lateinit var faceLogin: ImageView
    private lateinit var anonimo: EditText


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        setupListeners()
        setupObserver()
    }

    override fun onResume() {
        super.onResume()
        clearErrors()
    }

    private fun initViews(view: View) {
        clContent = view.findViewById(R.id.login_content)
        progressBar = view.findViewById(R.id.login_progress)
        tilEmail = view.findViewById(R.id.til_login_email)
        etEmail = view.findViewById(R.id.et_email)
        tilPassword = view.findViewById(R.id.til_login_password)
        etPassword = view.findViewById(R.id.et_password)
        btnLogin = view.findViewById(R.id.btn_login)


    }

    private fun setupListeners() {
        btnLogin.setOnClickListener {
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
            viewModel.doLogin(email, pwd)
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
        viewModel.loginLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Result.Loading -> showLoading()
                is Result.Error -> showLoginError()
                is Result.Success -> accessMainApp()
            }
        }
    }

    private fun showLoading() {
        progressBar.isVisible = true
        clContent.isVisible = false
    }

    private fun showLoginError() {
        progressBar.isVisible = false
        clContent.isVisible = true
        Toast.makeText(
            requireContext(),
            GENERIC_ERROR_MSG,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun accessMainApp() {
        val intent = Intent(requireContext(), HomeActivity::class.java)
        startActivity(intent)
    }
    companion object {
        private const val EMAIL_ERROR_MSG = "O Email n??o ?? Valido."
        private const val PASSWORD_ERROR_MSG = "A senha tem que ter 8 carateres."
        private const val GENERIC_ERROR_MSG = "Algo deu errado, tente novamente."
    }
}