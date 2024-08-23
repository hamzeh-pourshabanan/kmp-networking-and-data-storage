package com.hamzeh.kmp_networking_and_data_storage.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hamzeh.kmp_networking_and_data_storage.data.db.entity.RocketLaunchEntity

@Dao
interface SpaceXDao {

    @Query("SELECT * FROM rocket_launches")
    suspend fun getAllLaunches(): List<RocketLaunchEntity>

    @Insert
    suspend fun insertAllLaunches(launches: List<RocketLaunchEntity>)

}