package com.shashank.lbb_ass.Entity

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(
    val firstName:String,val lastName:String,
  val profilePhoto:Bitmap
    ) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}