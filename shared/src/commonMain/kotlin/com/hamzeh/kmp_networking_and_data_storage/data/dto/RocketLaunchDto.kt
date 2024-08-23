package com.hamzeh.kmp_networking_and_data_storage.data.dto

import androidx.room.Entity
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class RocketLaunch(
    @SerialName("flight_number")
    val flightNumber: Int,
    @SerialName("name")
    val missionName: String,
    @SerialName("date_utc")
    val launchDateUTC: String,
    @SerialName("details")
    val details: String?,
    @SerialName("success")
    val launchSuccess: Boolean?,
    @SerialName("links")
    val links: Links
) {
    val launchYear = Instant.parse(launchDateUTC).toLocalDateTime(TimeZone.UTC).year
    val launchMonth = Instant.parse(launchDateUTC).toLocalDateTime(TimeZone.UTC).month
    val launchDay = Instant.parse(launchDateUTC).toLocalDateTime(TimeZone.UTC).dayOfMonth

    val launchDate = "$launchYear-$launchMonth-$launchDay"
}

@Serializable
data class Links(
    @SerialName("patch")
    val patch: Patch?,
    @SerialName("article")
    val article: String?
)

@Serializable
data class Patch(
    @SerialName("small")
    val small: String?,
    @SerialName("large")
    val large: String?
)