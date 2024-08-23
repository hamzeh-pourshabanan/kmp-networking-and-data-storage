package com.hamzeh.kmp_networking_and_data_storage.data.sources.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hamzeh.kmp_networking_and_data_storage.entity.RocketLaunch

@Dao
interface SpaceXDao {

    @Query("SELECT * FROM launches")
    suspend fun getAllLaunches(): List<RocketLaunch>

    @Insert
    suspend fun insertAllLaunches(launches: List<RocketLaunch>)

}