package com.example.noticias_mvvm.provider

import com.example.noticias_mvvm.model.NewsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//API KEY
private const val API_KEY = "bc08fd27ec2f4a269978722825ab5b88"

//Mandar a llamar la Rest Api
//Peticiones que convierte en Json los datos
interface NewsProvider {
    //Peticion GET
    //Ruta de la API
    @GET("top-headLines?apikey=$API_KEY")
    //Variable country es un parametro con la cual se usa query
    //regresa una lista Response
    suspend fun topHeadLines(@Query("country")country: String): Response<NewsApiResponse>
}