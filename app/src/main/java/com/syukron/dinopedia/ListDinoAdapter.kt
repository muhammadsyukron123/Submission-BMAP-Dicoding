package com.syukron.dinopedia

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListDinoAdapter(val listDino: ArrayList<Dino>) : RecyclerView.Adapter<ListDinoAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_dino, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDino.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val dino = listDino[position]

        Glide.with(holder.itemView.context)
            .load(dino.photo)
            .apply(RequestOptions().override(80,80))
            .into(holder.imgPicture)

        holder.tvName.text = dino.name
        holder.tvDetail.text = dino.detail

        val mycontext = holder.itemView.context

        holder.itemView.setOnClickListener{
            val dinoDetailMove = Intent(mycontext, DetailActivity::class.java)
            dinoDetailMove.putExtra(DetailActivity.EXTRA_PHOTO, dino.photo)
            dinoDetailMove.putExtra(DetailActivity.EXTRA_NAME, dino.name)
            dinoDetailMove.putExtra(DetailActivity.EXTRA_INFO, dino.detail)

            mycontext.startActivity(dinoDetailMove)
        }
    }



    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_itemName)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_itemDetail)
        var imgPicture: ImageView = itemView.findViewById(R.id.img_itemPicture)
    }

}