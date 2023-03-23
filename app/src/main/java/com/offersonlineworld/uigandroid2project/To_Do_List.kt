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
import com.offersonlineworld.uigandroid2project.toDoList.adapter
import com.offersonlineworld.uigandroid2project.toDoList.data
import com.offersonlineworld.volley_assignment.singltone
import kotlinx.android.synthetic.main.fragment_to_do_list.*

class To_Do_List : Fragment() {
    var ArrayData = ArrayList<data>()
    var adapter_recyler: adapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_to_do_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        adapter_recyler = adapter(ArrayData)
        rec_adpter("https://jsonplaceholder.typicode.com/todos")
        rec_Post.apply {
            rec_Post.layoutManager = layoutManager
            rec_Post.adapter = adapter_recyler
        }
    }
    fun rec_adpter(uri: String) {
        var jsonArray = JsonArrayRequest(Request.Method.GET, uri, null ,
            { response ->
                for (i in 0 until response.length()) {
                    var jsonObject = response.getJSONObject(i)
                    var id = jsonObject.getInt("id")
                    var title = jsonObject.getString("title")
                    var complete = jsonObject.getBoolean("completed")
                    var a = data(id , title , complete)
                    ArrayData.add(a)
                    adapter_recyler!!.notifyDataSetChanged()
                }
            },
            { error ->
                Log.d("aaa" , "Error in the Json")
            })
        singltone.getInstance()!!.addToRequestQueue(jsonArray)
    }
}