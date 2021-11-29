package ug.sharma.takeaway.api

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import ug.sharma.takeaway.model.ResponseDTO

interface Apiclient {
    //BASE_URL:- https://api.themoviedb.org/3/discover/movie?api_key=4cf44f2b03fd3637d33997a7071aa0b5&primary_release_date.lte=2016-12-31&sort_by=release_date.desc&page=1
    //https://api.themoviedb.org/3/movie/popular?api_key=328c283cd27bd1877d9080ccb1604c91
    @GET("people")
    fun getdata(@Query("page")pg:Int): Observable <ResponseDTO>
}