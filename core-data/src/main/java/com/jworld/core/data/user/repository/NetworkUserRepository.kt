package com.jworld.core.data.user.repository

import com.jworld.core.common.di.ApplicationScope
import com.jworld.core.common.di.DefaultDispatcher
import com.jworld.core.data.common.NetworkException
import com.jworld.core.data.user.model.User
import com.jworld.core.data.user.model.toExternal
import com.jworld.network.reqres.UserNetworkDataSource
import com.jworld.network.reqres.model.UsersResponse
import com.jworld.network.util.NetworkConstants
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

// 범위지정을 안하면 요청할때마다 새 인스턴스를 만든다
class NetworkUserRepository @Inject constructor(
    private val userNetworkDataSource : UserNetworkDataSource,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
    @ApplicationScope private val scope: CoroutineScope,
) : UserRepository {

    override val userList: Flow<List<User>>

    override suspend fun updateUserList() {

        return withContext(dispatcher) {
            val result = userNetworkDataSource.getUsers()
            if(result.code == NetworkConstants.RESULT_SUCCESS_RECEIVE_DATA){
                val resultData = userNetworkDataSource.getUsers().result as UsersResponse
                resultData.data.toExternal()
            }else{
                throw NetworkException(result.message)
            }
        }
    }

    override suspend fun getUserList() : List<User> {

        return withContext(dispatcher) {
            val result = userNetworkDataSource.getUsers()
            if(result.code == NetworkConstants.RESULT_SUCCESS_RECEIVE_DATA){
                val resultData = userNetworkDataSource.getUsers().result as UsersResponse
                resultData.data.toExternal()
            }else{
                throw NetworkException(result.message)
            }
        }
    }

}