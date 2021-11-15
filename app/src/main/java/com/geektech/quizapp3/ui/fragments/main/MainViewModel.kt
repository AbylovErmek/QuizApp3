package com.geektech.quizapp3.ui.fragments.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.quizapp3.data.remote.RetrofitClient
import com.geektech.quizapp3.model.Categories
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {

    private val apiService = RetrofitClient.provideRetrofit()
    private var counter = MutableLiveData<Int>()
    private var count = 0

    fun setCount() {
        count++
        counter.postValue(count)
    }

    fun getCounter(): MutableLiveData<Int> {
        return counter
    }

    fun getCategories(): LiveData<Categories> {
        val data = MutableLiveData<Categories>()

        apiService.getCategories().enqueue(object : Callback<Categories> {
            override fun onResponse(
                call: Call<Categories>,
                response: Response<Categories>
            ) {
                if (response.isSuccessful && response.body() != null){
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<Categories>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.localizedMessage}" )
            }
        })

        return data
    }

}