package com.example.jetpackcompose.composewithroom.dipendencyinject

import android.app.Application
import androidx.room.Room
import com.example.jetpackcompose.composewithroom.Todo
import com.example.jetpackcompose.composewithroom.TodoDao
import com.example.jetpackcompose.composewithroom.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object DatabaseModule {

    @Provides
    @Singleton
    fun prodieaDatabase(application: Application):TodoDatabase=
        Room.databaseBuilder(application,TodoDatabase::class.java,"TodoDatabase")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
        fun providesDao(db:TodoDatabase):TodoDao=db.getDao()

}