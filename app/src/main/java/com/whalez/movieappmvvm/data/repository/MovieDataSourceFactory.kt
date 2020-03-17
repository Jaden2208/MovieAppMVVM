package com.whalez.movieappmvvm.data.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.whalez.movieappmvvm.data.api.TheMovieDBInterface
import com.whalez.movieappmvvm.data.vo.Movie
import io.reactivex.disposables.CompositeDisposable

class MovieDataSourceFactory(
    private val apiService: TheMovieDBInterface,
    private val compositeDisposable: CompositeDisposable
) : DataSource.Factory<Int, Movie>() {

    val moviesLiveDataSource = MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(apiService, compositeDisposable)
        return movieDataSource
    }
}