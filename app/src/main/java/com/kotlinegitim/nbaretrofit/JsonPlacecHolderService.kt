package com.kotlinegitim.nbaretrofit

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
   /* @GET("products/search")
    fun allPost(@Query("q") name : String ): Call<List<Product>>*/







}