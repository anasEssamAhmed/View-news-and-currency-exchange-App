package com.offersonlineworld.uigandroid2project.photo_card

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.offersonlineworld.uigandroid2project.R
import kotlinx.android.synthetic.main.photo_card.view.*

class adapter_photo(var data : ArrayList<dataphoto>) : RecyclerView.Adapter<adapter_photo.viewholder>() {
    class viewholder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var photo = itemView.imageViewResult
        var id_user = itemView.textIDResult4
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.photo_card , parent , false)
        return viewholder(root)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        var dataS = data.get(position)
        holder.id_user.text =  "ID : " + dataS.id.toString()
        holder.photo.load(dataS.uri)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}