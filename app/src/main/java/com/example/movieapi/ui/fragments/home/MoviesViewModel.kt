package com.example.movieapi.ui.fragments.home

import androidx.lifecycle.*
import com.example.movieapi.data.CoroutinesObject
import com.example.movieapi.repositries.MoviesRepository
import com.example.movieapi.model.MovieModel
import kotlinx.coroutines.Job

class MoviesViewModel(private val repository: MoviesRepository) : ViewModel() {

    private lateinit var job: Job

    private val _moviesMutableLiveData = MutableLiveData<List<MovieModel>>()

    val movies: LiveData<List<MovieModel>> = _moviesMutableLiveData


    fun getMovies() {
        job = CoroutinesObject.ConvertIOToMain(
            { repository.getMovies() },
            { _moviesMutableLiveData.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }

}
