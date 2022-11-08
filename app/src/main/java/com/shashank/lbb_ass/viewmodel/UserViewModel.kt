package com.shashank.lbb_ass.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.shashank.lbb_ass.Database.UserDatabase
import com.shashank.lbb_ass.Entity.User
import com.shashank.lbb_ass.repository.UserRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) :AndroidViewModel(application) {
    val repository : UserRepository
    val allUser :LiveData<List<User>>

    init {
        val dao = UserDatabase.getDatabase(application).userDao()
        repository= UserRepository(dao)
        allUser = repository.allUser
    }

    fun insertUser(user: User) =viewModelScope.launch ( Dispatchers.IO){
        repository.insert(user)
    }


}