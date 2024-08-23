package com.hamzeh.kmp_networking_and_data_storage.data.db

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.hamzeh.kmp_networking_and_data_storage.data.sources.room.Database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

fun getRoomDatabase(
    builder: RoomDatabase.Builder<Database>
): Database {
    return builder
        .fallbackToDestructiveMigrationOnDowngrade(true)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}