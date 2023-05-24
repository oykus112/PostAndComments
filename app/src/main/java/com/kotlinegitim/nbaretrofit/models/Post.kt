package com.kotlinegitim.nbaretrofit



data class Post (
    val userId: Long,
    val id: Long,
    val title: String,
    val body: String,

)

data class Comments(  val postID: Long,
                      val id: Long,
                      val name: String,
                      val email: String,
                      val body: String)



data class AllStars(val GameID:String,
                    val StartPeriod:String,
                    val EndPeriod:String,
                    val StartRange:String,
                    val EndRange:String,
                    val RangeType:String )

