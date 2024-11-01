package com.hamzeh.kmp_networking_and_data_storage.di

import android.content.Context
import androidx.room.RoomDatabase
import com.hamzeh.kmp_networking_and_data_storage.PlatformConfig
import com.hamzeh.kmp_networking_and_data_storage.data.db.Database
import com.hamzeh.kmp_networking_and_data_storage.data.db.RoomBuilder
import com.hamzeh.kmp_networking_and_data_storage.domain.viewmodels.RocketLaunchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule = module {
    single<RoomDatabase.Builder<Database>> { RoomBuilder(get<PlatformConfig>().context).builder() }
    viewModel { RocketLaunchViewModel(get(), get()) }
}