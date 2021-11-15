package com.geektech.quizapp3.ui.fragments.main

import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import com.geektech.quizapp3.R
import com.geektech.quizapp3.base.BaseFragment
import com.geektech.quizapp3.databinding.FragmentMainBinding
import com.geektech.quizapp3.model.TriviaCategory
import com.google.android.material.slider.Slider

class MainFragment : BaseFragment<FragmentMainBinding>() {

    private val viewModel by viewModels<MainViewModel>()
    private val category = arrayListOf<String>()

    override fun setUI() {

        ArrayAdapter.createFromResource(
            requireContext(), R.array.difficulty_array, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spDifficulty.adapter = adapter

        }

        binding.slider.addOnChangeListener(Slider.OnChangeListener { _, value, _ ->
            run {
                binding.tvQuestionsCount.text = value.toInt().toString()
            }
        })
    }

    override fun setupObservers() {
        viewModel.getCategories().observe(viewLifecycleOwner) {
            createSpinner(it?.triviaCategories)
        }
    }

    private fun createSpinner(triviaCategories: ArrayList<TriviaCategory>?) {

        category.add(0, getString(R.string.all))
        triviaCategories?.forEach {
            category.add(0, it.name.toString())
        }
        category.reverse()
        val spinnerAdapter = ArrayAdapter(
            requireContext(), android.R.layout.simple_spinner_dropdown_item, category
        )
        binding.spCategory.adapter = spinnerAdapter
    }

    override fun initListeners() {
    }

    override fun inflateViewBinding(): FragmentMainBinding {
        return FragmentMainBinding.inflate(layoutInflater)
    }

}