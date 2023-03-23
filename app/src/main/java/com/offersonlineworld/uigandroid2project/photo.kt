package com.offersonlineworld.uigandroid2project

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.offersonlineworld.uigandroid2project.photo_card.adapter_photo
import com.offersonlineworld.uigandroid2project.photo_card.dataphoto
import com.offersonlineworld.volley_assignment.singltone
import kotlinx.android.synthetic.main.fragment_photo.*


class photo : Fragment() {
    var data = ArrayList<dataphoto>()
    var adapterPhoto : adapter_photo? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layout = GridLayoutManager(activity , 2 , GridLayoutManager.VERTICAL , false)
        adapterPhoto = adapter_photo(data)
        getOData()
        rec_photo.apply {
            rec_photo.layoutManager = layout
            rec_photo.adapter = adapterPhoto
        }

    }
    fun getOData() {
        var uri = "https://jsonplaceholder.typicode.com/photos"
        var JsonObject = JsonArrayRequest(
            Request.Method.GET, uri, null,
            { res ->
                for (i in 0 until res.length()){
                    val objectJson = res.getJSONObject(i)
                    val id = objectJson.getInt("id")
                    val uri2 = objectJson.getString("url")
                    Log.d("sqqsaw" , uri2)
                    val s = dataphoto(id , uri2)
                    data.add(s)
                    adapterPhoto!!.notifyDataSetChanged()
                }
            }, { err ->
                Log.d("aaa" , "Error in the Json")
            })
        singltone.getInstance()!!.addToRequestQueue(JsonObject)
    }
}