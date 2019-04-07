package com.app.json

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class BaseWatch {
    @SerializedName("watches")
    @Expose
    var watches: List<Watch> = ArrayList()

  /*  fun getWatches(): List<Watch> {
        return watches
    }

    fun setWatches(watches: List<Watch>) {
        this.watches = watches
    }*/
}