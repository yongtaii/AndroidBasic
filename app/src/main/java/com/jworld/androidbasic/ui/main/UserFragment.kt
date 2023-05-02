package com.jworld.androidbasic.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.jworld.androidbasic.BR
import com.jworld.androidbasic.R
import com.jworld.androidbasic.databinding.FragmentUserBinding
import com.jworld.androidbasic.databinding.ItemUserBinding
import com.jworld.androidbasic.ui.component.GeneralBindAdapter
import com.jworld.core.data.user.model.User
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class UserFragment : Fragment() {

    private lateinit var binding : FragmentUserBinding
//    private lateinit var viewModel : UserViewModel

    /**
     * by viewModels() 코드로 아래 코드를 대체
     * viewModel = ViewModelProvider(this)[UserViewModel::class.java]
     * */
    val viewModel: UserViewModel by viewModels()

    private val adapter : GeneralBindAdapter<User, ItemUserBinding> = GeneralBindAdapter<User, ItemUserBinding>(
        R.layout.item_user,
        BR.model,
        BR.position
    )


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        initViewModel()
        initView()
        return binding.root
    }
    private fun initView(){
        binding.viewModel = viewModel
        initUserListView()
    }

    private fun initViewModel() {
        // 임시로 ViewModel 초기화 안되게 막기
//        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        setViewModelObserver()
    }

    private fun setViewModelObserver(){
//        viewModel.userListLiveData.observe(viewLifecycleOwner, this::onPrev)
    }

    private fun initUserListView() {
        binding.cargoRecyclerview.adapter = adapter
    }


}