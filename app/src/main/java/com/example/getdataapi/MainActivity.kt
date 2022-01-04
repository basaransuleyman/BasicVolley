package com.example.getdataapi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.getdataapi.databinding.ActivityMainBinding

const val BASE_URL = "https://www.omdbapi.com/?apikey=dad2aa7f&t="

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        getDataFromAPI()
    }

    fun getDataFromAPI() {
        with(_binding){
            btnSearchMovie.setOnClickListener {
                val queue = Volley.newRequestQueue(this@MainActivity)
                val url = BASE_URL + etMovieName.text.toString()
                val stringRequest = StringRequest(Request.Method.GET, url, { response ->
                    Toast.makeText(applicationContext, response.toString(), Toast.LENGTH_SHORT).show()
                }, { err ->
                    Toast.makeText(applicationContext, err.toString(), Toast.LENGTH_SHORT).show()
                })
                queue.add(stringRequest)
            }
        }
    }
}
