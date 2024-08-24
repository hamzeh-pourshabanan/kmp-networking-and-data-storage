package com.hamzeh.kmp_networking_and_data_storage.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hamzeh.kmp_networking_and_data_storage.data.db.Database


fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<Database> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("my_room.db")
    return Room.databaseBuilder<Database>(
        context = appContext,
        name = dbFile.absolutePath
    )
}