package com.example.noticias_mvvm.model

data class News (
    var title: String,
    var content: String?,
    var author: String?,
    var url: String,
    var urlToImage: String,
        )