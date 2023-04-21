package com.jworld.androidbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jworld.network.reqres.datasource.UserNetworkDataSource
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            val dataSource : UserNetworkDataSource = UserNetworkDataSource()
            dataSource.getUsers2()
//            Log.d("yong1234","result : $result")

//            for(data in result){
//                Log.d("yong1234","id : ${data.id}")
//                Log.d("yong1234","avatar : ${data.avatar}")
//                Log.d("yong1234","first_name : ${data.first_name}")
//                Log.d("yong1234","last_name : ${data.last_name}")
//            }

        }
    }
}
