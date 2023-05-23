package com.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ui.adapter.HomeRVAdapter
import com.util.Status
import com.volie.indescribablerecipes.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _mBinding: FragmentHomeBinding? = null
    private val mBinding get() = _mBinding!!
    private val mViewModel: HomeViewModel by viewModels()
    private val mAdapter = HomeRVAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.rvRecentRecipes.adapter = mAdapter
        mViewModel.getRandomRecipes()
        observeLiveData()

        mBinding.ivNotification.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToNotificationFragment()
            findNavController().navigate(action)
        }
    }

    private fun observeLiveData() {
        mViewModel.recipes.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { data ->
                        mBinding.progressBarRecentRecipes.visibility = View.GONE
                        mAdapter.submitList(data.recipes)
                    }
                }

                Status.ERROR -> {

                }

                Status.LOADING -> {
                    mBinding.progressBarRecentRecipes.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _mBinding = null
    }
}