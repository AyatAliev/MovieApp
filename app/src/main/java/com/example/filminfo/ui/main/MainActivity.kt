package com.example.filminfo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.filminfo.R
import com.example.filminfo.core.ui.BaseActivity
import com.example.filminfo.databinding.ActivityMainBinding
import com.example.filminfo.extentions.visible
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val viewModel: MainViewModel by viewModel()

    private var currentNavController: NavController? = null

    private val navigationListener =
        NavController.OnDestinationChangedListener { controller, destination, arguments ->

            when (destination.id) {
                R.id.navigation_home -> viewBinding.navViewLayout.visible = true
                R.id.navigation_profile -> viewBinding.navViewLayout.visible = false
                else -> viewBinding.navViewLayout.visible = false
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initNavigationMenu()

    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    private fun initNavigationMenu() {

        val navController = findNavController(R.id.nav_host_fragment)

        viewBinding.navView.setupWithNavController(navController)

        currentNavController = navController
    }

    override fun onBackPressed() {
        if (currentNavController?.navigateUp() == false) {
            super.onBackPressed()
        }
    }

    override fun onResume() {
        super.onResume()
        currentNavController?.addOnDestinationChangedListener(navigationListener)
    }

    override fun onPause() {
        currentNavController?.removeOnDestinationChangedListener(navigationListener)
        super.onPause()
    }

}