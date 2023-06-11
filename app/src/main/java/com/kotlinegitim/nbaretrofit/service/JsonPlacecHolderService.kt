package com.kotlinegitim.nbaretrofit.service

import com.kotlinegitim.nbaretrofit.Comments
import com.kotlinegitim.nbaretrofit.Post
import com.kotlinegitim.nbaretrofit.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JsonPlacecHolderService {

    @GET("users")
    fun allUsers(): Call<List<Users>>

    @GET("posts")
    fun allPost(): Call<List<Post>>

    @GET("posts")
    fun specialPost(@Query("userId") userId: Long): Call<List<Post>>

    @GET("posts/{limit}/comments")
    fun getComment(@Path("limit") limit: Long): Call<List<Comments>>



}