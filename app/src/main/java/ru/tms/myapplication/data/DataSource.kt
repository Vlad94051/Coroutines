package ru.tms.myapplication.data

import ru.tms.myapplication.domain.NewsInteractor

class DataSource: NewsInteractor {
    override suspend fun loadNews(topic: String?): List<News> {
        TODO("Not yet implemented")
    }
}
