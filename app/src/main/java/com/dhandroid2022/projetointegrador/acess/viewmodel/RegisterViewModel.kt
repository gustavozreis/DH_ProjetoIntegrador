package com.dhandroid2022.projetointegrador.acess.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhandroid2022.projetointegrador.acess.StringUtils
import com.dhandroid2022.projetointegrador.acess.data.Result
import com.dhandroid2022.projetointegrador.acess.data.UserRepository
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    private val userRepository = UserRepository()

    private val _registerLiveData = MutableLiveData<Result<Unit>>()
    val registerLiveData: LiveData<Result<Unit>> = _registerLiveData

    fun doRegister(
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            _registerLiveData.value = Result.Loading

            userRepository.register(email, password).addOnCompleteListener { task ->
                _registerLiveData.value = if (task.isSuccessful) {
                    Result.Success(data = Unit)
                } else {
                    Result.Error
                }
            }
        }
    }

    fun isValidEmail(givenEmail: String): Boolean = StringUtils.isValidEmail(givenEmail)

    fun isValidPassword(givenPassword: String): Boolean = StringUtils.isValidPassword(givenPassword)
}