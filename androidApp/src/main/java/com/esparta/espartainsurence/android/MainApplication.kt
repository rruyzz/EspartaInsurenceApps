package com.esparta.espartainsurence.android

import android.app.Application
import com.esparta.espartainsurence.android.document.DocumentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                listOf(
                    viewModelsModule,
                )
            )
        }
    }

    private val viewModelsModule = module {
        viewModel { DocumentViewModel() }
    }
}