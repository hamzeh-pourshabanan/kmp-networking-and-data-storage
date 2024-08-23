package com.hamzeh.kmp_networking_and_data_storage.unit.data.network

import com.hamzeh.kmp_networking_and_data_storage.JsonLoader
import com.hamzeh.kmp_networking_and_data_storage.data.dto.RocketLaunch

object FakeRocketLaunchResponse {
    fun getFakeRocketLaunchResponse(): List<RocketLaunch> {
        return JsonLoader.load<List<RocketLaunch>>("launches.json")
    }
}