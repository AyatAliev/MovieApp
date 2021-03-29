package com.example.filminfo.ui.home

import Articles
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.filminfo.R
import com.example.filminfo.extentions.inflate
import com.example.filminfo.extentions.loadUrl

class HomeAdapter(
    private var list: ArrayList<Articles>
) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(parent.inflate(R.layout.item_film))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    fun setNews(list: ArrayList<Articles>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(private val containerView: View): RecyclerView.ViewHolder(containerView) {

        fun onBind(item: Articles) {
        val imgHome = containerView.findViewById<ImageView>(R.id.mh_image)
        val tvTitle = containerView.findViewById<TextView>(R.id.mh_text_title)
        val tvDesc = containerView.findViewById<TextView>(R.id.mh_text_desc)

            imgHome.loadUrl(containerView.context,item.urlToImage)
            tvTitle.text = item.title
            tvDesc.text = item.description
        }
    }
}