package ru.tms.myapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import ru.tms.myapplication.data.DataSource
import ru.tms.myapplication.data.News
import ru.tms.myapplication.domain.NewsInteractor

class MainViewModel(
        private val newsInteractor: NewsInteractor = DataSource()
) : ViewModel() {

    val news: LiveData<List<News>> get() = _news
    private val _news = MutableLiveData<List<News>>()

    fun loadNews() {
        val result = viewModelScope.async {
            val theme1 = async(Dispatchers.IO) { newsInteractor.loadNews("theme1") }
            val theme2 = async { newsInteractor.loadNews("theme2") }
            val theme3 = async { newsInteractor.loadNews("theme3") }

            val result1 = theme1.await()
            val result2 = theme2.await()
            val result3 = theme3.await()

            return@async result1 + result2 + result3
        }
    }
}