package com.example.movie.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movie.core.netwrok.result.Status
import com.example.movie.databinding.FragmentHomeBinding
import com.example.movie.core.ui.BaseFragment
import com.example.movie.extentions.visible
import com.example.movie.models.Result
import com.example.movie.utils.Log
import com.example.movie.utils.Toast
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    private var list: ArrayList<Result> = arrayListOf()
    private val adapter by lazy { HomeAdapter(list,this::clickListener) }
    override val viewModel: HomeViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun bindViewBinding(view: View): FragmentHomeBinding {
        return FragmentHomeBinding.bind(view)
    }

    override fun initView() {
        super.initView()
        setUpRecyclerView()
    }

    override fun initViewModel() {
        super.initViewModel()

        viewModel.isLoading.observe(viewLifecycleOwner, {
            viewBinding.progressBar.visible = it
        })

        viewModel.moviePopular.observe(viewLifecycleOwner,{ response ->
            when(response.status) {
                Status.LOADING -> { viewModel.isLoading.postValue(true) }

                Status.ERROR -> {
                    response.message?.let { message -> Toast.show(requireActivity(), message) }
                    viewModel.isLoading.postValue(false)
                }

                Status.SUCCESS -> {
                    adapter.setMovie(response.data?.results as ArrayList<Result>)
                    viewModel.isLoading.postValue(false)
                }
            }
        })

    }

    private fun clickListener(movie: Result) {
        val action = movie.id?.let { movieId -> HomeFragmentDirections.actionMovieInfoFragment(movieId) }
        action?.let { navigate(it) }
    }

    private fun setUpRecyclerView() {
        viewBinding.recyclerView.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = this@HomeFragment.adapter
        }
    }

}