package com.hamzeh.kmp_networking_and_data_storage.data.sources.room

import androidx.room.ConstructedBy
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.hamzeh.kmp_networking_and_data_storage.data.sources.room.dao.SpaceXDao
import com.hamzeh.kmp_networking_and_data_storage.entity.RocketLaunch

@androidx.room.Database(entities = [RocketLaunch::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class Database : RoomDatabase() {
    abstract fun getDao(): SpaceXDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<Database>