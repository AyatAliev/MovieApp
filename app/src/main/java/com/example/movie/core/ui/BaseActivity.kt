package com.example.movie.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<out VM : BaseViewModel, VB : ViewBinding> : AppCompatActivity() {

    protected abstract val viewModel: VM
    protected lateinit var viewBinding: VB

    protected abstract fun inflateViewBinding(inflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = inflateViewBinding(LayoutInflater.from(this))
        setContentView(viewBinding.root)

        initViewModel()
        initView()
        initListeners()
    }

    open fun initViewModel() {}
    open fun initView() {}
    open fun initListeners() {}

}
