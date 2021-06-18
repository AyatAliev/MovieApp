package com.example.movie.ui.main

import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.movie.R
import com.example.movie.core.ui.BaseActivity
import com.example.movie.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val viewModel: MainViewModel by viewModel()
    private var navController: NavController? = null

    override fun initView() {
        super.initView()

        initDrawerMenu()
    }

    private fun initDrawerMenu() {

        val nc = findNavController(R.id.nav_host_fragment)
        navController = nc
    }

    override fun onBackPressed() {
        if (navController?.navigateUp() == false) {
            super.onBackPressed()
        }
    }

        override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
            return ActivityMainBinding.inflate(inflater)
        }
    }