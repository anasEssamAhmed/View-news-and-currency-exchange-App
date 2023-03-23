package com.offersonlineworld.uigandroid2project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.offersonlineworld.uigandroid2project.comment.adapterComment
import com.offersonlineworld.uigandroid2project.comment.dataComment
import com.offersonlineworld.volley_assignment.singltone
import kotlinx.android.synthetic.main.activity_commtent.*

class Commtent : AppCompatActivity() {
    var data = ArrayList<dataComment>()
    var adapter_comment : adapterComment ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commtent)
        var id_user = intent.getIntExtra("postID" , 0)
        Log.d("qqq" , id_user.toString())
        getData(id_user)
        var layout = LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false)
        adapter_comment = adapterComment(data)
        rec_Comment.layoutManager = layout
        rec_Comment.adapter = adapter_comment

    }
    fun getData(id  : Int){
        var uri = "https://jsonplaceholder.typicode.com/comments?postId=$id"
        var json = JsonArrayRequest(Request.Method.GET , uri , null ,
            {res ->
                for (i in 0 until res.length()){
                    val i = res.getJSONObject(i)
                    var id = i.getInt("id")
                    var name = i.getString("name")
                    var email = i.getString("email")
                    var body = i.getString("body")
                    var s = dataComment(id , name , email , body)
                    data.add(s)
                    adapter_comment!!.notifyDataSetChanged()
                }
            } ,
            {err ->
                Log.d("aaa" , "Json is error")
            })
        singltone.getInstance()!!.addToRequestQueue(json)
    }
}