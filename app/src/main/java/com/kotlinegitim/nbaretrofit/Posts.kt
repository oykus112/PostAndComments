package com.kotlinegitim.nbaretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.kotlinegitim.nbaretrofit.client.ApiClient
import com.kotlinegitim.nbaretrofit.customadaptors.PostListviewAdaptor
import com.kotlinegitim.nbaretrofit.service.JsonPlacecHolderService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Posts : AppCompatActivity() {

    lateinit var nbaService : JsonPlacecHolderService
    var posts_list = mutableListOf<Post>()
    lateinit var postListview : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)


        var id = intent.getLongExtra("id",0)

        println(id)
        postListview = findViewById(R.id.posts)

        nbaService = ApiClient.getClient().create(JsonPlacecHolderService::class.java)

        val adaptor = PostListviewAdaptor(this,R.layout.posts_custom_layout,posts_list)

        nbaService.specialPost(id).enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {

                var posts = response.body()

                if (posts != null){

                    for(post in posts){

                        posts_list.add(post)
                        println(post)

                        postListview.adapter = adaptor
                        adaptor.notifyDataSetChanged()
                    }
                }


            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                println("Not yet implemented")
            }

        })
    }
}