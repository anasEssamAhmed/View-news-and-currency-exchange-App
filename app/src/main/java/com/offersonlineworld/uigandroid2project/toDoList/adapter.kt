package com.offersonlineworld.uigandroid2project.toDoList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.offersonlineworld.uigandroid2project.R
import kotlinx.android.synthetic.main.to_do_list_card_view.view.*

class adapter(var dataNew:ArrayList<data>) : RecyclerView.Adapter<adapter.viewHoleder>() {
    class viewHoleder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id_user = itemView.textIdResult
        var title = itemView.textTitleResult
        var image = itemView.imageView
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHoleder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.to_do_list_card_view , parent , false)
        return viewHoleder(root)
    }
    override fun onBindViewHolder(holder: viewHoleder, position: Int) {
        var dataS = dataNew.get(position)
        holder.id_user.text = dataS.id.toString()
        holder.title.text = dataS.title
        if (dataS.completed == true) {
            holder.image.setImageResource(R.drawable.completed)
        } else {
            holder.image.setImageResource(R.drawable.not_completed)
        }
    }

    override fun getItemCount(): Int {
         return dataNew.size
    }
}