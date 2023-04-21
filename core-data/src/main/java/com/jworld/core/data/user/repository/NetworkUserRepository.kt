package com.jworld.core.data.user.repository

import com.jworld.core.common.di.ApplicationScope
import com.jworld.core.common.di.DefaultDispatcher
import com.jworld.core.data.user.model.User
import com.jworld.core.data.user.model.toExternal
import com.jworld.network.reqres.UserNetworkDataSource
import com.jworld.network.reqres.model.UsersResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkUserRepository @Inject constructor(
    private val userNetworkDataSource : UserNetworkDataSource,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
    @ApplicationScope private val scope: CoroutineScope,
) : UserRepository {

    override suspend fun getUserList() : List<User> {

        return withContext(dispatcher) {
            val result = userNetworkDataSource.getUsers().result as UsersResponse
            result.data.toExternal()
        }

//        if(userNetworkDataSource.getUsers().code == NetworkConstants.RESULT_SUCCESS_RECEIVE_DATA){
//
//        }else{
//            //error
//        }



//        return result.run {
//            this::toExternal
//        }
//        return result::toExternal
//        return result.toExternal()
//        return withContext(dispatcher) {
//            val result = userNetworkDataSource.getUsers().result as UsersResponse
//            result::toExternal
//        }
    }

}