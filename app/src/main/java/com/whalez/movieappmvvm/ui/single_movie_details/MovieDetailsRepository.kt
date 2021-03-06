package com.whalez.movieappmvvm.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.whalez.movieappmvvm.data.api.TheMovieDBInterface
import com.whalez.movieappmvvm.data.repository.MovieDetailsNetworkDataSource
import com.whalez.movieappmvvm.data.repository.NetworkState
import com.whalez.movieappmvvm.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository(private val apiService: TheMovieDBInterface) {

    private lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails(
        compositeDisposable: CompositeDisposable,
        movieId: Int
    ): LiveData<MovieDetails> {
        movieDetailsNetworkDataSource =
            MovieDetailsNetworkDataSource(apiService, compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }
}