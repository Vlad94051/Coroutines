package ru.tms.myapplication.domain

import ru.tms.myapplication.data.News

interface NewsInteractor {
    suspend fun loadNews(topic: String?): List<News>
}