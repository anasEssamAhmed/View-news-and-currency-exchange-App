package com.offersonlineworld.uigandroid2project.posts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.offersonlineworld.uigandroid2project.Commtent
import com.offersonlineworld.uigandroid2project.R
import kotlinx.android.synthetic.main.posts_card.view.*

class adapterPost( var context: Context , var data : ArrayList<dataPost>) : RecyclerView.Adapter<adapterPost.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var id_user = itemView.textIdResult2
        var title = itemView.textTitleResult2
        var body = itemView.textBodyResult
        var btn = itemView.btnShowComments
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.posts_card , parent  , false)
        return ViewHolder(root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       var dataS = data.get(position)
        holder.id_user.text = dataS.id.toString()
        holder.title.text = dataS.title
        holder.body.text = dataS.body
        holder.btn.setOnClickListener {
            var i = Intent(context , Commtent :: class.java)
            i.putExtra("postID" , dataS.id)
            context.startActivity(i)

        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}