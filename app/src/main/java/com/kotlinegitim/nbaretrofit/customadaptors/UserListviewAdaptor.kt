package com.kotlinegitim.nbaretrofit.customadaptors

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.kotlinegitim.nbaretrofit.Posts
import com.kotlinegitim.nbaretrofit.R
import com.kotlinegitim.nbaretrofit.Users

class UserListviewAdaptor(private val context: Activity, private val resource: Int, private val objects: MutableList<Users>) :
    ArrayAdapter<Users>(context, resource, objects) {

    lateinit var name : TextView
    lateinit var username : TextView




    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val root = context.layoutInflater.inflate(resource,null,true)

        var users = objects.get(position)


        name = root.findViewById(R.id.username)
        username = root.findViewById(R.id.usersurname)


        name.text = users.name
        username.text ="NickName : "+ users.username


        root.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, Posts::class.java)


                intent.putExtra("id", users.id )

                context.startActivity(intent)

            }
        })

        return root
    }
}