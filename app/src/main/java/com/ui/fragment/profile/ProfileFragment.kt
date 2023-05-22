package com.ui.fragment.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.ui.adapter.ViewPagerAdapter
import com.volie.indescribablerecipes.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {
    private var _mBinding: FragmentProfileBinding? = null
    private val mBinding get() = _mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mBinding = FragmentProfileBinding.inflate(inflater, container, false)
        setupViewPager()
        return mBinding.root
    }

    private fun setupViewPager() {
        val pages = listOf(
            ProfileRecipesFragment(),
            ProfileAboutFragment()
        )

        val adapter = ViewPagerAdapter(
            requireActivity(),
            pages
        )

        with(mBinding) {
            viewPagerProfile.adapter = adapter
            TabLayoutMediator(
                tabLayoutProfile,
                viewPagerProfile
            ) { tab, position ->
                when (position) {
                    0 -> tab.text = "Recipes"
                    1 -> tab.text = "About"
                }
            }.attach()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _mBinding = null
    }
}