package com.kotlinegitim.nbaretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.kotlinegitim.nbaretrofit.client.ApiClient
import com.kotlinegitim.nbaretrofit.customadaptors.UserListviewAdaptor
import com.kotlinegitim.nbaretrofit.service.JsonPlacecHolderService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    var post = mutableListOf<Post>()
    var Users = mutableListOf<Users>()
    lateinit var Service : JsonPlacecHolderService
    lateinit var userListview : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        userListview = findViewById(R.id.users)
        Service = ApiClient.getClient().create(JsonPlacecHolderService::class.java)

        val adaptor = UserListviewAdaptor(this,R.layout.users_custom_layout,Users)


        Service.allUsers().enqueue(object : Callback<List<Users>>{
            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {

                val users = response.body()

                if (users != null){

                    for (user in users){

                        Users.add(user)

                    }

                    userListview.adapter = adaptor
                    adaptor.notifyDataSetChanged()
                }



            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
               println("Not yet implemented")
            }


        })




    /*nbaService.allPost().enqueue(object : Callback<List<Post>>{
            override fun onResponse(
                call: Call<List<Post>>,
                response: Response<List<Post>>
            ) {

                var posts = response.body()

                if (posts != null){


                    for(post in posts){

                        println("post:${post.title}")


                    }
                }

            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                println("Not yet implemented")
            }

        })*/


      /* */

       /*nbaService.getComment(1).enqueue(object : Callback<List<Comments>>{
            override fun onResponse(
                call: Call<List<Comments>>,
                response: Response<List<Comments>>
            ) {

                var comments = response.body()
                if (comments != null){

                    for(comment in comments){

                        println("post:${comment.email}")
                        println("body:${comment.name}")

                    }
                }
            }

            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
                println("Not yet implemented")
            }

        })*/


    }
}