package com.hamzeh.kmp_networking_and_data_storage.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rocket_launches")
data class RocketLaunchEntity(
    @PrimaryKey val flightNumber: Int,
    val missionName: String,
    val launchDate: String,
    val details: String?,
    val launchSuccess: Boolean?,
    val patchSmall: String?,
)