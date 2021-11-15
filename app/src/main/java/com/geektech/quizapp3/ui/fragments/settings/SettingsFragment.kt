package com.geektech.quizapp3.ui.fragments.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geektech.quizapp3.R
import com.geektech.quizapp3.base.BaseFragment
import com.geektech.quizapp3.databinding.FragmentSettingsBinding

class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {

    override fun setUI() {
    }

    override fun initListeners() {
    }

    override fun setupObservers() {
    }

    override fun inflateViewBinding(): FragmentSettingsBinding {
        return FragmentSettingsBinding.inflate(layoutInflater)
    }


}