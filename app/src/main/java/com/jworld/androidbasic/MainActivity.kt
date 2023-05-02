package com.jworld.androidbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jworld.core.data.user.model.User
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

            val resultData = networkUserRepository.getUserList()
            Log.d("yong1234","isSuccess : ${resultData.isSuccess}")
            Log.d("yong1234","errorCode : ${resultData.errorCode}")
            Log.d("yong1234","errorMsg : ${resultData.errorMsg}")

            val result = resultData.result as List<User>?

            if (result != null) {
                for(data in result){
                    Log.d("yong1234","id : ${data.id}")
                    Log.d("yong1234","fname : ${data.firstName}")
                    Log.d("yong1234","lname : ${data.lastName}")
                }
            }

        }
    }
}
