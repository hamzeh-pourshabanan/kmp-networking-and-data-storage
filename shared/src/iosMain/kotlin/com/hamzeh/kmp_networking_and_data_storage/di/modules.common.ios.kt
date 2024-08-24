package com.hamzeh.kmp_networking_and_data_storage.di

import androidx.room.RoomDatabase
import com.hamzeh.kmp_networking_and_data_storage.data.db.Database
import com.hamzeh.kmp_networking_and_data_storage.data.db.RoomBuilder
import com.hamzeh.kmp_networking_and_data_storage.domain.viewmodels.RocketLaunchViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {

        single<RoomDatabase.Builder<Database>> { RoomBuilder().builder() }
        factory { RocketLaunchViewModel(get(), get()) }
    }