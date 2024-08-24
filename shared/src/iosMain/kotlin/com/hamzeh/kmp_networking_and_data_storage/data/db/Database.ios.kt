package com.hamzeh.kmp_networking_and_data_storage.data.db

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory

actual class RoomBuilder {
    actual fun builder(): RoomDatabase.Builder<Database> {
        val dbFilePath = NSHomeDirectory() + "/${DATABASE_NAME}"
        return Room.databaseBuilder<Database>(
            name = dbFilePath,
            factory = { Database::class.instantiateImpl() }
        ).setDriver(BundledSQLiteDriver())
    }
}