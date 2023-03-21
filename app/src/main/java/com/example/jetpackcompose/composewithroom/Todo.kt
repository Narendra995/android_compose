package com.example.jetpackcompose.composewithroom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todoTable")
data class Todo(
    val name:String,
    val mobile:String
){
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}