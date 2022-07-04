package com.dhandroid2022.projetointegrador.acess.data

sealed class Result<out R> {
    object Loading : Result<Nothing>()
    data class Success<out T>(val data: T) : Result<T>()
    object Error : Result<Nothing>()
}