package com.example.quiz12maktab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.quiz12maktab.databinding.ActivityMainBinding

import retrofit2.Call
import retrofit2.Callback


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val url="https://api.github.com/users/MENasri23"
//        val client = OkHttpClient()
//        val request=Request.Builder().url(url).build()
//        val response=client.newCall(request).execute()
//        binding.txtMessage.text=response.body().toString()

        val apiService=ApiService.create().getMessage()
        apiService.enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: retrofit2.Response<User>) {
                    binding.txtMessage.text= response.body()?.toString() ?: ""
                    Glide.with(applicationContext)
                        .load(response.body()?.avatar_url)
                        .into(binding.imgProfile)

            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}