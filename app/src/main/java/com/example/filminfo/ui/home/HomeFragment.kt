package com.example.filminfo.ui.home

import Articles
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filminfo.core.netwrok.result.Status
import com.example.filminfo.databinding.FragmentHomeBinding
import com.example.filminfo.core.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    private var list: ArrayList<Articles> = arrayListOf()
    private var homeAdapter: HomeAdapter = HomeAdapter(list)
    override val viewModel: HomeViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHomeBinding {

        val vb = FragmentHomeBinding.inflate(inflater, container, false)

        return vb

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

        viewModel.filmInfo.observe(this) {
            when (it.status) {
                Status.ERROR -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                }

                Status.LOADING -> {

                }

                Status.SUCCESS -> {
                    list = it.data?.articles as ArrayList<Articles>
                    homeAdapter.setNews(list)
                }
            }
        }
    }

    override fun initListeners() {
        super.initListeners()

        viewBinding.btnOpenProfile.setOnClickListener {
            navigate(HomeFragmentDirections.actionNavigationHomeToNavigationProfile())

        }
    }

    private fun setUpRecyclerView() {
        viewBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = homeAdapter
        }
    }

}