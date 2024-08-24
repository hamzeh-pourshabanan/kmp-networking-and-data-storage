package com.hamzeh.kmp_networking_and_data_storage.di

import androidx.lifecycle.ViewModel
import com.hamzeh.kmp_networking_and_data_storage.domain.usecase.getLaunches.GetLaunchesUseCase
import com.hamzeh.kmp_networking_and_data_storage.domain.usecase.refreshLaunches.RefreshRocketLaunchesUseCase
import com.hamzeh.kmp_networking_and_data_storage.domain.viewmodels.RocketLaunchViewModel

class AndroidRocketLaunchViewModel(
    getLaunchesUseCase: GetLaunchesUseCase,
    refreshRocketLaunchesUseCase: RefreshRocketLaunchesUseCase
) : ViewModel() {

    val rocketLaunchesUiState = RocketLaunchViewModel(
        getLaunchesUseCase,
        refreshRocketLaunchesUseCase
    ).rocketLaunchesUiState

}