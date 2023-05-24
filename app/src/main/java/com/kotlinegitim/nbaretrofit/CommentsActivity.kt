package com.kotlinegitim.nbaretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ListView
import android.widget.TextView
import com.kotlinegitim.nbaretrofit.customadaptors.CommentCustomAdaptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {

    lateinit var nbaService : JsonPlacecHolderService

    lateinit var title : TextView
    lateinit var body : TextView
    lateinit var listComments : ListView

    var comments = mutableListOf<Comments>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments2)

        nbaService = ApiClient.getClient().create(JsonPlacecHolderService::class.java)

        var postid = intent.getLongExtra("id",0)
        var title_detail = intent.getStringExtra("title")
        var postbody =intent.getStringExtra("postbody")


        title = findViewById(R.id.title_detail)
        body = findViewById(R.id.body_post)

        listComments = findViewById(R.id.comments)

        var adaptor = CommentCustomAdaptor(this,R.layout.comment_custom_layout,comments)


        nbaService.getComment(postid).enqueue(object : Callback<List<Comments>> {
            override fun onResponse(
                call: Call<List<Comments>>,
                response: Response<List<Comments>>
            ) {

                var comments_data = response.body()
                if (comments_data != null){

                    for(comment in comments_data){

                        comments.add(comment)

                        listComments.adapter = adaptor
                        adaptor.notifyDataSetChanged()

                    }
                }
            }

            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
                println("Not yet implemented")
            }

        })


        title.text = title_detail
        title.movementMethod = ScrollingMovementMethod()

        body.text = postbody
        body.movementMethod = ScrollingMovementMethod()



    }
}