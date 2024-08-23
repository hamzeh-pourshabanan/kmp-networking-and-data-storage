package com.hamzeh.kmp_networking_and_data_storage.db

import androidx.room.Room
import androidx.room.RoomDatabase
import com.hamzeh.kmp_networking_and_data_storage.data.db.Database
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

fun getDatabaseBuilder(): RoomDatabase.Builder<Database> {
    val dbFilePath = documentDirectory() + "/my_room.db"
    return Room.databaseBuilder<Database>(
        name = dbFilePath,
    )
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}