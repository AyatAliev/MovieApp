package com.example.filminfo.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.filminfo.R
import com.example.filminfo.core.ui.BaseFragment
import com.example.filminfo.databinding.FragmentHomeBinding
import com.example.filminfo.databinding.FragmentProfileBinding
import com.example.filminfo.ui.home.HomeFragmentDirections
import com.example.filminfo.ui.home.HomeViewModel
import com.example.filminfo.ui.widgets.MainToolbar
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.view_toolbar.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment<ProfileViewModel, FragmentProfileBinding>() {

    override val viewModel: ProfileViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentProfileBinding {

        val vb = FragmentProfileBinding.inflate(inflater, container, false)

        return vb

    }

    override fun bindViewBinding(view: View): FragmentProfileBinding {
        return FragmentProfileBinding.bind(view)
    }

    override fun initView() {
        super.initView()
        viewBinding.toolBar.bind(leftActionButton = MainToolbar.ActionInfo(
            iconRes = R.drawable.ic_arrow_back_white,
            onClick = { requireActivity().onBackPressed() }
        ))
    }
}