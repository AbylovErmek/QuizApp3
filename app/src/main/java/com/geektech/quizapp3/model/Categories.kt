package com.geektech.quizapp3.model

import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("trivia_categories")
    var triviaCategories: ArrayList<TriviaCategory>?
)

data class TriviaCategory(
    var id: Int?,
    var name: String?
)