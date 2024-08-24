package com.hamzeh.kmp_networking_and_data_storage.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hamzeh.kmp_networking_and_data_storage.data.db.entity.RocketLaunchEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SpaceXDao {

    @Query("SELECT * FROM rocket_launches")
    fun getAllLaunches(): Flow<List<RocketLaunchEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllLaunches(launches: List<RocketLaunchEntity>)

}