package com.geektech.quizapp3.data.remote

import com.geektech.quizapp3.model.Categories
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("api_category.php")
    fun getCategories(): Call<Categories>

}

