package com.offersonlineworld.volley_assignment

import android.app.Application
import android.text.TextUtils
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class singltone() : Application() {
    val TAG = "aaa"
    var requestQuene : RequestQueue ? = null
    companion object {
        private var instance : singltone? = null
        fun getInstance() : singltone? {
            return instance
        }

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
    fun getRequestQueue(): RequestQueue? {
        if (requestQuene == null){
            requestQuene = Volley.newRequestQueue(this)
        }
        return requestQuene
    }
    fun <T> addToRequestQueue(request : Request<T>){
        request.tag = TAG
        getRequestQueue()!!.add(request)
    }
    fun <T> addToRequestQueue(request : Request<T> , Tag:String){
        request.tag = if (TextUtils.isEmpty(Tag)) TAG else Tag
        getRequestQueue()!!.add(request)
    }
    fun cancelRequest(tag : Any?){
        if (requestQuene != null){
            requestQuene!!.cancelAll(tag)
        }
    }

}