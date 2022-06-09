package com.example.wyklad12_widget

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import com.example.wyklad12_widget.photos2


interface PiscumService {

    @GET("v2/list")

    fun getPhotos(): Deferred<Response<photos2>>


}