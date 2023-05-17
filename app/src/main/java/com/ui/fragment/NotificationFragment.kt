package com.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.ui.adapter.ViewPagerAdapter
import com.volie.indescribablerecipes.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {
    private var _mBinding: FragmentNotificationBinding? = null
    private val mBinding get() = _mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mBinding = FragmentNotificationBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()

        mBinding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setupViewPager() {
        val pages = listOf(
            NotificationGeneralFragment(),
            NotificationSystemFragment()
        )

        val adapter = ViewPagerAdapter(requireActivity(), pages)
        mBinding.viewPagerNotification.adapter = adapter
        TabLayoutMediator(
            mBinding.tabLayoutNotification,
            mBinding.viewPagerNotification
        ) { tab, position ->
            when (position) {
                0 -> tab.text = "General"
                1 -> tab.text = "System"
            }
        }.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        _mBinding = null
    }
}