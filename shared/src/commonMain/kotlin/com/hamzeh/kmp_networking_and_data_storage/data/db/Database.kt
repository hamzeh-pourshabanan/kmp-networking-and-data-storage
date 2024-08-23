package com.hamzeh.kmp_networking_and_data_storage.data.db

import androidx.room.ConstructedBy
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.hamzeh.kmp_networking_and_data_storage.data.db.dao.SpaceXDao
import com.hamzeh.kmp_networking_and_data_storage.data.dto.RocketLaunch
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.hamzeh.kmp_networking_and_data_storage.data.db.entity.RocketLaunchEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO


@androidx.room.Database(entities = [RocketLaunchEntity::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class Database : RoomDatabase() {
    abstract fun getDao(): SpaceXDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<Database>

fun getRoomDatabase(
    builder: RoomDatabase.Builder<Database>
): Database {
    return builder
        .fallbackToDestructiveMigrationOnDowngrade(true)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}