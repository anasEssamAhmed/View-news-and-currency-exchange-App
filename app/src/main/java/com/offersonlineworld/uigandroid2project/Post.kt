package com.offersonlineworld.uigandroid2project

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.offersonlineworld.uigandroid2project.posts.adapterPost
import com.offersonlineworld.uigandroid2project.posts.dataPost
import com.offersonlineworld.volley_assignment.singltone
import kotlinx.android.synthetic.main.fragment_post.*

class Post : Fragment() {
    var data = ArrayList<dataPost>()
    var adapterPost2 : adapterPost? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layout = LinearLayoutManager(activity , LinearLayoutManager.VERTICAL , false)
        adapterPost2 = activity?.let { adapterPost(it, data) }
        getOData()
        rec_posts.apply {
            rec_posts.layoutManager = layout
            rec_posts.adapter = adapterPost2
        }
    }

    fun getOData() {
        var uri: String = "https://jsonplaceholder.typicode.com/posts"
        var JsonObject = JsonArrayRequest(Request.Method.GET, uri, null,
            { res ->
                for (i in 0 until res.length()){
                    var objectJson = res.getJSONObject(i)
                    var id = objectJson.getInt("id")
                    var title = objectJson.getString("title")
                    var body = objectJson.getString("body")
                    var s = dataPost(id , title , body)
                    data.add(s)
                    adapterPost2!!.notifyDataSetChanged()
                }
            }, { err ->
                Log.d("aaa" , "Error in the Json")
            })
        singltone.getInstance()!!.addToRequestQueue(JsonObject)
    }
}