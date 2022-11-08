package com.shashank.lbb_ass.repository

import androidx.lifecycle.LiveData
import com.shashank.lbb_ass.Dao.UserDao
import com.shashank.lbb_ass.Entity.User


class UserRepository(private val dao: UserDao) {

    val allUser:LiveData<List<User>> =dao.getUsers()


    suspend fun  insert(user: User){
        dao.insert(user)
    }




}