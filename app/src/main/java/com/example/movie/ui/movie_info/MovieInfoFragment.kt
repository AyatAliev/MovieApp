package com.example.movie.ui.movie_info

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.movie.R
import com.example.movie.core.netwrok.result.Status
import com.example.movie.core.ui.BaseFragment
import com.example.movie.databinding.FragmentMovieInfoBinding
import com.example.movie.extentions.fetchDrawable
import com.example.movie.extentions.loadImage
import com.example.movie.extentions.visible
import com.example.movie.models.MovieInfo
import com.example.movie.utils.Toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieInfoFragment : BaseFragment<MovieInfoViewModel, FragmentMovieInfoBinding>() {

    override val viewModel: MovieInfoViewModel by viewModel()

    private val args: MovieInfoFragmentArgs by navArgs()
    private lateinit var movieInfo: MovieInfo
    private var progress = 0

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentMovieInfoBinding {
        return FragmentMovieInfoBinding.inflate(inflater, container, false)
    }

    override fun bindViewBinding(view: View): FragmentMovieInfoBinding {
        return FragmentMovieInfoBinding.bind(view)
    }

    override fun initView() {
        super.initView()

        viewModel.getInfoMovie(args.movieId)
    }

    override fun initViewModel() {
        super.initViewModel()

        viewModel.isLoading.observe(viewLifecycleOwner, {
            viewBinding.progressBar.visible = it
        })

        viewModel.getInfoMovie.observe(viewLifecycleOwner,{ response ->

            when(response.status) {
                Status.LOADING -> { viewModel.isLoading.postValue(true) }

                Status.ERROR -> {
                    response.message?.let { message -> Toast.show(requireActivity(), message) }
                    viewModel.isLoading.postValue(false)
                }

                Status.SUCCESS -> {
                    if (response.data != null) {
                        movieInfo = response.data
                        setUI()
                    }
                    viewModel.isLoading.postValue(false)
                }
            }
        })
    }

    private fun setUI() {
        viewBinding.ivMovie.loadImage(movieInfo.posterPath)

        viewBinding.tvTitle.text = movieInfo.title
        viewBinding.tvDesc.text = movieInfo.overview

        viewBinding.tvPopularity.text = StringBuffer("${movieInfo.voteAverage?.times(10)?.toInt().toString()}%")
        raisingProgressBar()
    }

    private fun raisingProgressBar() {

        Handler(Looper.getMainLooper()).postDelayed({
            progress++

            viewBinding.pbPopularity.progress = progress

            when(progress) {
                30 -> viewBinding.pbPopularity.progressDrawable = context?.fetchDrawable(R.drawable.pb_popularity_yellow)
                60 -> viewBinding.pbPopularity.progressDrawable = context?.fetchDrawable(R.drawable.pb_popularity_green)
            }

            if (progress < movieInfo.voteAverage?.times(10)?.toInt()!!) {
                raisingProgressBar()
            }

        }, 100)

    }

}