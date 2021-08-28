package id.aibangstudio.basekotlin.di

import androidx.room.Room
import id.aibangstudio.basekotlin.data.db.AppDatabase
import id.aibangstudio.basekotlin.data.pref.PreferencesHelper
import id.aibangstudio.basekotlin.data.remote.createWebService
import id.aibangstudio.basekotlin.data.remote.provideOkHttpClient
import id.aibangstudio.basekotlin.data.remote.service.TeamService
import id.aibangstudio.basekotlin.domain.repository.TeamRepository
import id.aibangstudio.basekotlin.data.repository.TeamRepositoryImpl
import id.aibangstudio.basekotlin.presentation.main.MainViewModel
import id.aibangstudio.basekotlin.core.scheduler.AppSchedulerProvider
import id.aibangstudio.basekotlin.core.scheduler.SchedulerProvider
import id.aibangstudio.basekotlin.domain.usecase.GetTeamListUseCase
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { provideOkHttpClient() }
    single { createWebService<TeamService>(get()) }

    single { PreferencesHelper(androidContext()) }

    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "app-database").build()
    }

    single<SchedulerProvider> { AppSchedulerProvider() }

}

val dataModule = module {
    single { get<AppDatabase>().teamDao() }
    single<TeamRepository> { TeamRepositoryImpl(get(), get()) }
}

val useCaseModule = module {
    single { GetTeamListUseCase(get(), get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val myAppModule = listOf(appModule, dataModule, viewModelModule, useCaseModule)