package com.offersonlineworld.uigandroid2project.comment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.offersonlineworld.uigandroid2project.R
import kotlinx.android.synthetic.main.comment_card.view.*

class adapterComment(var data : ArrayList<dataComment>) : RecyclerView.Adapter<adapterComment.viewHolder>() {
    class viewHolder(var itemView : View) : RecyclerView.ViewHolder(itemView) {
        var id_user = itemView.textIdResult3
        var name_user = itemView.textNameResult
        var email = itemView.textEmailResult
        var body = itemView.textBodyResult1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.comment_card , parent , false)
        return viewHolder(root)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var dataS = data.get(position)
        holder.id_user.text = dataS.postId.toString()
        holder.name_user.text = dataS.name
        holder.email.text = dataS.email
        holder.body.text = dataS.body
    }

    override fun getItemCount(): Int {
        return data.size
    }
}