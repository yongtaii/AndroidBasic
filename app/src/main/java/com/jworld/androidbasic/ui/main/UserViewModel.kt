package com.jworld.androidbasic.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jworld.core.data.user.model.User
import com.jworld.core.data.user.repository.NetworkUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val networkUserRepository: NetworkUserRepository
) : ViewModel() {

    private val _userListLiveData = MutableLiveData<List<User>>()
    var userListLiveData: LiveData<List<User>> = _userListLiveData

    init {
        getUserList()
    }

    fun getUserList() {

        viewModelScope.launch {
            val userResponse = networkUserRepository.getUserList()
            if(userResponse.isSuccess){
                val userListData = userResponse.result as List<User>
                _userListLiveData.value = userListData
            }else{


            }
        }

    }

}