package com.example.movie.ui.home

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.databinding.ItemPopularMovieBinding
import com.example.movie.extentions.fetchDrawable
import com.example.movie.extentions.loadImage
import com.example.movie.models.Result
import com.example.movie.utils.Utils
import kotlin.collections.ArrayList

class HomeAdapter(
    private var list: ArrayList<Result>,
    private val clickListener: (address: Result) -> Unit
) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemPopularMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])

        holder.itemView.setOnClickListener {
            clickListener(list[position])
        }
    }

    fun setMovie(list: ArrayList<Result>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(  private val containerView: ItemPopularMovieBinding): RecyclerView.ViewHolder(containerView.root) {

        var progress = 0

        fun onBind(item: Result) {

            containerView.itemIvMain.loadImage(item.posterPath)

            containerView.itemTvTitle.text = item.originalTitle
            containerView.itemTvDate.text = Utils.parseDateToddMMyyyy(item.releaseDate.toString())

            containerView.itemTvPopularity.text = StringBuffer("${item.voteAverage?.times(10)?.toInt()}%")

            item.voteAverage?.times(10)?.toInt()?.let { value -> raisingProgressBar(containerView.itemPbPopularity, value) }

        }

        private fun raisingProgressBar(progressBar: ProgressBar, value: Int) {

            Handler(Looper.getMainLooper()).postDelayed({
                progress++

                progressBar.progress = progress

                when(progress) {
                    30 -> progressBar.progressDrawable = itemView.context.fetchDrawable(R.drawable.pb_popularity_yellow)
                    60 -> progressBar.progressDrawable = itemView.context.fetchDrawable(R.drawable.pb_popularity_green)
                }

                if (progress < value) {
                    raisingProgressBar(progressBar,value)
                }

            }, 100)

        }
    }
}