package com.geektech.quizapp3.model

import com.google.gson.annotations.SerializedName

data class MainResponse<T>(
    @SerializedName("response_code")
    var responseCode: Int?,
    var results: List<T>?
)

data class Result(
    var category: String?,
    @SerializedName("correct_answer")
    var correctAnswer: String?,
    var difficulty: String?,
    @SerializedName("incorrect_answers")
    var incorrectAnswers: List<String?>?,
    var question: String?,
    var type: String?
)