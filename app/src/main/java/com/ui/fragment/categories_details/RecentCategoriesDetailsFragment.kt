package com.ui.fragment.categories_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.volie.indescribablerecipes.databinding.FragmentRecentCategoriesDetailsBinding

class RecentCategoriesDetailsFragment : Fragment() {
    private var _mBinding: FragmentRecentCategoriesDetailsBinding? = null
    private val mBinding get() = _mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mBinding = FragmentRecentCategoriesDetailsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _mBinding = null
    }
}