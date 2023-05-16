package com.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.volie.indescribablerecipes.databinding.FragmentBookmarkBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookmarkFragment : Fragment() {
    private var _mBinding: FragmentBookmarkBinding? = null
    private val mBinding get() = _mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mBinding = FragmentBookmarkBinding.inflate(
            inflater, container, false
        )
        return mBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _mBinding = null
    }
}