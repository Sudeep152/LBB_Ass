package com.shashank.lbb_ass.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.shashank.lbb_ass.Converters
import com.shashank.lbb_ass.Dao.UserDao
import com.shashank.lbb_ass.Entity.User


@Database(entities = arrayOf(User::class),version = 1,exportSchema = false)
@TypeConverters(Converters::class)
abstract class UserDatabase:RoomDatabase()  {

    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: UserDatabase? = null


        fun getDatabase(
            context: Context
        ): UserDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }


    }
}