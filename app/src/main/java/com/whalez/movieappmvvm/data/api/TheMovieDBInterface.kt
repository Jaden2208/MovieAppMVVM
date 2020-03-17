package com.whalez.movieappmvvm.data.api

import com.whalez.movieappmvvm.data.vo.MovieDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDBInterface {

    // https://api.themoviedb.org/3/movie/popular?api_key=3a1721be25cfab49572c0fa487fa4258
    // https://api.themoviedb.org/3/movie/454626?api_key=3a1721be25cfab49572c0fa487fa4258
    // https://api.themoviedb.org/3/

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>


}