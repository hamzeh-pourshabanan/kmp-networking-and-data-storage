package com.hamzeh.kmp_networking_and_data_storage.domain.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamzeh.kmp_networking_and_data_storage.domain.usecase.getLaunches.GetLaunchesUseCase
import com.hamzeh.kmp_networking_and_data_storage.domain.usecase.refreshLaunches.RefreshRocketLaunchesUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class RocketLaunchViewModel(
    getLaunchesUseCase: GetLaunchesUseCase,
    private val refreshRocketLaunchesUseCase: RefreshRocketLaunchesUseCase,
): ViewModel() {
    val rocketLaunchesUiState = getLaunchesUseCase.invoke().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(1000L),
        initialValue = emptyList()
    )

    init {
        refresh()
    }

    private fun refresh() {
        viewModelScope.launch {
            refreshRocketLaunchesUseCase.invoke()
        }
    }
}