package com.example.getdataapi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


class MainActivity : AppCompatActivity() {

    lateinit var  getDataText : TextView
    lateinit var getDataButton : Button
    lateinit var  getDataSearchButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        getDataSearchButton = findViewById(R.id.getDataSearchButton)
        getDataButton = findViewById(R.id.getDataButton)
        getDataText = findViewById(R.id.getDataText)

        getDataButton.setOnClickListener{
            val queue = Volley.newRequestQueue(this)
            val url = "https://www.omdbapi.com/?apikey=dad2aa7f&t=lord"
            val stringRequest  = StringRequest(
                Request.Method.GET, url,
                Response.Listener <String> { response ->
                    Toast.makeText(applicationContext, response. toString(), Toast.LENGTH_SHORT).show()
                },
                Response.ErrorListener { err ->
                    Toast.makeText(applicationContext, err.toString(), Toast.LENGTH_SHORT).show()
                })
            queue.add(stringRequest)
        }

        getDataSearchButton.setOnClickListener{

            val queue = Volley.newRequestQueue(this)
            val url = "https://www.omdbapi.com/?apikey=dad2aa7f&t=" + getDataText.getText().toString()
            val stringRequest  = StringRequest(
                Request.Method.GET, url,
                Response.Listener <String> { response ->
                    Toast.makeText(applicationContext, response.toString(), Toast.LENGTH_SHORT).show()
                },
                Response.ErrorListener { err ->
                    Toast.makeText(applicationContext, err.toString(), Toast.LENGTH_SHORT).show()
                })
            queue.add(stringRequest)
        }

        }

    }

