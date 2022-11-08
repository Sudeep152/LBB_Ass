package com.shashank.lbb_ass.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.shashank.lbb_ass.Entity.User


@Dao
interface UserDao {


    @Query("SELECT * FROM User ORDER BY id ASC ")
    fun getUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: User)




}