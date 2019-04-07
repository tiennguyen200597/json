package com.app.json

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.google.gson.Gson
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    private val JSON_FILE_ANDROID_WEAR = "androidwear.json"
    private val JSON_FILE = "question.json"
    private val TAG = "MainActivity"
    val charset: Charset = Charsets.UTF_8

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.d(TAG, "tesst" + getWatchesData().toString())
        Log.d(TAG, "tien" + getData().toString())

    }


    /* Convert JSON String to BaseWatch Model via GSON */
    fun getWatchesData(): List<Watch> {
        val jsonString = getAssetsJSON(JSON_FILE_ANDROID_WEAR)
        Log.d(TAG, "Json: " + jsonString!!)
        val gson = Gson()
        val baseWatch = gson.fromJson(jsonString, BaseWatch::class.java)
        return baseWatch.watches
    }

    fun getData(): List<Question> {
        val jsonString = getAssetsJSON(JSON_FILE)
        Log.d(TAG, "Json: " + jsonString!!)
        val gson = Gson()
        val base = gson.fromJson(jsonString, QuestionService::class.java)
        return base.question
    }
    /* Get File in Assets Folder */
    fun getAssetsJSON(fileName: String): String? {
        var json: String? = null
        try {
            val inputStream = this.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)

        } catch (e: IOException) {
            e.printStackTrace()
        }

        return json
    }
}
