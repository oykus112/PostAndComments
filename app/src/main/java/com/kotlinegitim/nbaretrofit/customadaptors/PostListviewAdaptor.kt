package com.kotlinegitim.nbaretrofit.customadaptors

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.kotlinegitim.nbaretrofit.CommentsActivity
import com.kotlinegitim.nbaretrofit.Post
import com.kotlinegitim.nbaretrofit.R

class PostListviewAdaptor(private val context: Activity,private  val resource: Int, private  val objects: MutableList<Post>) :
    ArrayAdapter<Post>(context, resource, objects) {

    lateinit var title : TextView
    lateinit var body : TextView

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        val root = context.layoutInflater.inflate(resource,null,true)

        val posts = objects.get(position)


        title = root.findViewById(R.id.title)
        body = root.findViewById(R.id.body)


        title.text = posts.title
        //body.text = posts.body


        root.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, CommentsActivity::class.java)


                intent.putExtra("id", posts.id )
                intent.putExtra("postbody", posts.body)
                intent.putExtra("title",posts.title)

                context.startActivity(intent)

            }
        })

        return root
    }
}