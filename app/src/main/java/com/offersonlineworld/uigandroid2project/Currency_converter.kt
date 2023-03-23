package com.offersonlineworld.uigandroid2project

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.offersonlineworld.volley_assignment.singltone
import kotlinx.android.synthetic.main.fragment_currency_converter.*

class Currency_converter : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_currency_converter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnConvert.setOnClickListener {
            val From = spinnerFrom.selectedItem.toString()
            val To = spinnerTo.selectedItem.toString()
            convert_currency(From , To)
            Log.d("SSS", From)
            Log.d("SSS", To)
        }
    }

    fun convert_currency(From: String, To: String) {
        var uri = "https://free.currconv.com/api/v7/convert?q=$From" + "_$To&compact=ultra&apiKey=90b95b8f7243c8fef8ce"
        var jsonObject = JsonObjectRequest(Request.Method.GET, uri, null,
            { res ->
                val i = res.getDouble(From + "_$To")
                Log.d("SSS" , i.toString())
                val inputUser = enterAmount.text.toString().toDouble()
                Log.d("SSS" , inputUser.toString())
                val sum = i * inputUser
                Log.d("SSS" , sum.toString())
                result.text = "Result = $sum"
            }, { err ->
                Log.d("SSS", "Error of the json Currency Convert")
            })
        singltone.getInstance()!!.addToRequestQueue(jsonObject)
    }
}