package com.jworld.androidbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.jworld.network.reqres.datasource.ReqresNetworkDataSource
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            val dataSource : ReqresNetworkDataSource = ReqresNetworkDataSource()
            val result = dataSource.getUsers()
            for(data in result){
                Log.d("yong1234","id : ${data.id}")
                Log.d("yong1234","avatar : ${data.avatar}")
                Log.d("yong1234","first_name : ${data.first_name}")
                Log.d("yong1234","last_name : ${data.last_name}")
            }

        }
    }
}
