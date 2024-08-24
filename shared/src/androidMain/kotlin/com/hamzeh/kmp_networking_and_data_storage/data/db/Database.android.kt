package com.hamzeh.kmp_networking_and_data_storage.data.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import java.io.File

actual class RoomBuilder(
    private val appContext: Context
) {
    actual fun builder(): RoomDatabase.Builder<Database> {
        val appContext = appContext.applicationContext
        val dbFile = appContext.getDatabasePath(DATABASE_NAME)
        return Room.databaseBuilder<Database>(
            context = appContext,
            name = dbFile.absolutePath
        ).setDriver(BundledSQLiteDriver())
    }
}