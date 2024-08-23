package com.hamzeh.kmp_networking_and_data_storage.domain.model

data class RocketLaunchDomainModel(
    val flightNumber: Int,
    val missionName: String,
    val launchDate: String,
    val launchSuccess: Boolean?,
    val patchSmall: String?,
)
