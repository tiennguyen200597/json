package com.app.json

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class QuestionService {
    @SerializedName("question")
    @Expose
    var question: List<Question> = ArrayList()

}