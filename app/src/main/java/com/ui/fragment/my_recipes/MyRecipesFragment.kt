package com.ui.fragment.my_recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.ui.adapter.ViewPagerAdapter
import com.volie.indescribablerecipes.databinding.FragmentMyRecipesBinding

class MyRecipesFragment : Fragment() {
    private var _mBinding: FragmentMyRecipesBinding? = null
    private val mBinding get() = _mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mBinding = FragmentMyRecipesBinding.inflate(inflater, container, false)
        setupViewPager()
        return mBinding.root
    }

    private fun setupViewPager() {
        val pages = listOf(
            MyDraftRecipesFragment(),
            MyPublishedRecipesFragment()
        )

        with(mBinding) {
            val adapter = ViewPagerAdapter(requireActivity(), pages)
            viewPagerMyRecipes.adapter = adapter
            TabLayoutMediator(
                tabLayoutMeyRecipes,
                viewPagerMyRecipes
            ) { tab, position ->
                when (position) {
                    0 -> tab.text = "Draft"
                    1 -> tab.text = "Published"
                }
            }.attach()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _mBinding = null
    }
}