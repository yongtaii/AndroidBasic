package com.jworld.network.util

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.ConnectionPool
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal object NetworkApiCreator {
    private val TAG = NetworkApiCreator::class.java.simpleName
    private const val TIMEOUT: Long = 60000L
    private val TIMEUNIT: TimeUnit = TimeUnit.MILLISECONDS

    /**
     * Gson 객체 생성시 null field 가 무시되지 않은채로 API 호출
     */
    @JvmStatic
    fun createRetrofitByObservable(sessionOptions: SessionOptions, isDebug: Boolean = false): Retrofit {
        val interceptors = listOf(sessionOptions.getTokenInterceptor(), sessionOptions.getInterceptor())

        return Retrofit.Builder()
            .baseUrl(sessionOptions.sessionUrl)
            .client(createHttpClient(interceptors, isDebug))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
            .build()
    }

    private fun createHttpClient(interceptors: List<Interceptor>, isDebug: Boolean): OkHttpClient {
        return with(OkHttpClient.Builder()) {
            for(interceptor in interceptors) {
                addInterceptor(interceptor)
            }
            addInterceptor(createHttpLoggingInterceptor())
//            if (isDebug) {
//                setUnsafeOkHttpClient(this)
//            }
            connectionPool(getConnectionPool())
            connectTimeout(TIMEOUT, TIMEUNIT)
            writeTimeout(TIMEOUT, TIMEUNIT)
            readTimeout(TIMEOUT, TIMEUNIT)
        }.build()
    }


    // 통신 로깅용 Interceptor 생성
    private fun createHttpLoggingInterceptor(): Interceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor { message -> Log.d(TAG, message) }

        //통신로그를 확인하기 위한 부분, debug build 에서는 body 전체를, release build 에서는 로그를 전혀 찍지 않는다.
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    // Connection Pool 생성
    private fun getConnectionPool() : ConnectionPool = ConnectionPool(5, 20, TimeUnit.NANOSECONDS)




}