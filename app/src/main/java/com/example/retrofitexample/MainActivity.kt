package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val quotesAPI=RetrofitHelper.getInstance().create(QuotesApi::class.java)
        GlobalScope.launch {
            val result =   quotesAPI.getQuotes(1)
            result?.let {
                val quotelist=result.body()
                quotelist?.let {
                    it.results.forEach{
                        Log.d("CHEEZYCODE",it.content)
                    }
                }
            }
        }
    }
}