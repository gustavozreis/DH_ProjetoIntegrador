package com.dhandroid2022.projetointegrador.data

import android.util.Log
import com.dhandroid2022.projetointegrador.data.comicDTO.ComicAPI
import com.dhandroid2022.projetointegrador.data.heroDTO.HeroAPI
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://gateway.marvel.com/v1/public/"

private val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss-SSSS").create()

private val interceptor = HttpLoggingInterceptor {
    Log.d("RETROFIT_CLIENT", it)
}.apply { level = HttpLoggingInterceptor.Level.BODY }

private val client = OkHttpClient.Builder()
    .addInterceptor(interceptor)
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(client)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()

val heroAPI: HeroAPI = retrofit.create(HeroAPI::class.java)
val comicAPI: ComicAPI = retrofit.create(ComicAPI::class.java)