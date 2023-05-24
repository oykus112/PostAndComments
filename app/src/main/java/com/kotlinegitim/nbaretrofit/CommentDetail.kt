package com.kotlinegitim.nbaretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView

class CommentDetail : AppCompatActivity() {

    lateinit var comment_bodys:TextView
    lateinit var Email:TextView
    lateinit var CommentName:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment_detail)


        var body_comment = intent.getStringExtra("comment_body")
        var commentname = intent.getStringExtra("commentname")
        var email = intent.getStringExtra("email")

        comment_bodys = findViewById(R.id.commentdetail)
        Email = findViewById(R.id.email)
        CommentName = findViewById(R.id.commentname)

        comment_bodys.text = body_comment
        comment_bodys.movementMethod = ScrollingMovementMethod()

        Email.text = email
        CommentName.text = commentname
    }
}