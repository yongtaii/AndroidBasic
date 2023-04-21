package com.jworld.androidbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jworld.core.data.user.repository.NetworkUserRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var networkUserRepository: NetworkUserRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {

            val userList = networkUserRepository.getUserList()
            Log.d("yong1234","userList size : ${userList.size}")

            for(data in userList){
                Log.d("yong1234","id : ${data.id}")
                Log.d("yong1234","fname : ${data.firstName}")
                Log.d("yong1234","lname : ${data.lastName}")
            }

        }
    }
}
