package com.dhandroid2022.projetointegrador.data.utils

sealed class ApiResult<out R> {
    object Loading : ApiResult<Nothing>()
    data class Success<out T>(val data: T) : ApiResult<T>()
    object Error : ApiResult<Nothing>()
}