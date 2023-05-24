package com.kotlinegitim.nbaretrofit.customadaptors

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.kotlinegitim.nbaretrofit.CommentDetail
import com.kotlinegitim.nbaretrofit.Comments
import com.kotlinegitim.nbaretrofit.CommentsActivity
import com.kotlinegitim.nbaretrofit.R

class CommentCustomAdaptor(private val context: Activity, private val resource: Int, private val objects: MutableList<Comments>) :
    ArrayAdapter<Comments>(context, resource, objects) {

    lateinit var comment : TextView

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var root = context.layoutInflater.inflate(resource, null,true)

        comment = root.findViewById(R.id.comment_text)

        var comments = objects.get(position)

        comment.text = comments.name

        root.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, CommentDetail::class.java)


                intent.putExtra("email",comments.email)
                intent.putExtra("commentname", comments.name)
                intent.putExtra("comment_body", comments.body )


                context.startActivity(intent)

            }
        })

        return root







    }
}