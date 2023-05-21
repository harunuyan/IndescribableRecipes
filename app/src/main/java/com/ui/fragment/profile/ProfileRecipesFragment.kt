package com.ui.fragment.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.volie.indescribablerecipes.databinding.FragmentProfileRecipesBinding

class ProfileRecipesFragment : Fragment() {
    private var _mbinding: FragmentProfileRecipesBinding? = null
    private val mBinding get() = _mbinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mbinding = FragmentProfileRecipesBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _mbinding = null
    }
}