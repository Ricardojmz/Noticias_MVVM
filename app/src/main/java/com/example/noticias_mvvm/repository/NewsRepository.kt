package com.example.noticias_mvvm.repository

import com.example.noticias_mvvm.model.News
import com.example.noticias_mvvm.provider.NewsProvider
import javax.inject.Inject

interface NewsRepository {
    suspend fun getNews(country: String): List<News>
    fun getNew(tirle: String): News
}

//Implemetacion de la interfaz
//Constructor con Inject
class NewsRepositoryImp @Inject constructor(
    //inyectamos al repositorio el provider
    private val newsProvider: NewsProvider
): NewsRepository{

    private var news: List<News> = emptyList()

    override suspend fun getNews(country: String): List<News> {
        val apiResponse = newsProvider.topHeadLines(country).body()
        //si existe un error
        if (apiResponse?.status == "error") {
            when (apiResponse.code) {

                "apiKeyMissing" -> throw MissingApiKeyException()
                "apiKeyInvalid" -> throw ApiKeyInvalidException()
                else -> throw Exception()//Cualquier otro error
            }
        }//Ver si la lista no es null y asigno una lista vacia
        news = apiResponse?.articles ?: emptyList()
        return news
    }
    //Buscar en la lista la noticia con ese titulo
    override fun getNew(title: String): News =
        news.first { it.title == title }

}
//Crear dos exepciones de error para la KEY
class MissingApiKeyException : java.lang.Exception()
class ApiKeyInvalidException : java.lang.Exception()

