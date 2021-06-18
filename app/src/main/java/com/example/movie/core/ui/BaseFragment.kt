package com.example.movie.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.movie.R

abstract class BaseFragment<VM: BaseViewModel, VB: ViewBinding> : Fragment() {

    protected abstract val viewModel: VM
    protected lateinit var viewBinding: VB
    private var _view: View? = null //cached view

    private var _navController: NavController? = null

    protected abstract fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): VB

    protected abstract fun bindViewBinding(view: View): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (_view == null) {
            viewBinding = inflateViewBinding(inflater, container, savedInstanceState)
            _view = viewBinding.root
        } else {
            viewBinding = bindViewBinding(_view!!)
        }
        return _view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        _navController = navHostFragment.navController

        initView()
        initViewModel()
        initListeners()
    }

    fun navigateUp() {
        hideKeyboard()
        findNavController().navigateUp()
    }

    fun navigate(directions: NavDirections) {
        _navController?.navigate(directions)
    }

    fun currentDestinationId(): Int? {
        return _navController?.currentDestination?.id
    }

    fun hideKeyboard() {
        context?.let {
            val imm = ContextCompat.getSystemService(it, InputMethodManager::class.java)
            imm?.hideSoftInputFromWindow(view?.windowToken, 0)
        }
    }

    open fun initViewModel() {}
    open fun initView() {}
    open fun initListeners() {}
}
