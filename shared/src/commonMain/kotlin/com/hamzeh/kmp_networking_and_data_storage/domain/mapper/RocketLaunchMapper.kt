package com.hamzeh.kmp_networking_and_data_storage.domain.mapper

import com.hamzeh.kmp_networking_and_data_storage.data.db.entity.RocketLaunchEntity
import com.hamzeh.kmp_networking_and_data_storage.data.dto.RocketLaunch
import com.hamzeh.kmp_networking_and_data_storage.domain.model.RocketLaunchDomainModel

fun RocketLaunch.toEntity(): RocketLaunchEntity = RocketLaunchEntity(
    flightNumber = flightNumber,
    missionName = missionName,
    launchDate = launchDate,
    details = details,
    launchSuccess = launchSuccess,
    patchSmall = links.patch?.small
)

fun List<RocketLaunch>.toEntity(): List<RocketLaunchEntity> = map { it.toEntity() }

fun RocketLaunchEntity.toDomainModel(): RocketLaunchDomainModel = RocketLaunchDomainModel(
    flightNumber = flightNumber,
    missionName = missionName,
    launchDate = launchDate,
    launchSuccess = launchSuccess,
    patchSmall = patchSmall
)