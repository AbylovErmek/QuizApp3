package com.geektech.quizapp3.ui.fragments.history

import androidx.fragment.app.viewModels
import com.geektech.quizapp3.base.BaseFragment
import com.geektech.quizapp3.databinding.FragmentHistoryBinding
import com.geektech.quizapp3.ui.fragments.main.MainViewModel

class HistoryFragment : BaseFragment<FragmentHistoryBinding>() {

    private val viewModel by viewModels<MainViewModel>()

    override fun setUI() {

    }

    override fun initListeners() {
        binding.btnPlus.setOnClickListener {
            viewModel.setCount()
        }
    }

    override fun setupObservers() {
        viewModel.getCounter().observe(viewLifecycleOwner) {
            binding.tvCounter.text = it.toString()
        }
    }

    override fun inflateViewBinding(): FragmentHistoryBinding {
        return FragmentHistoryBinding.inflate(layoutInflater)
    }
}