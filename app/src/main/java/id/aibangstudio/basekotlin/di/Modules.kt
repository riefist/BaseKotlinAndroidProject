package id.aibangstudio.basekotlin.di

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import id.aibangstudio.basekotlin.data.db.AppDatabase
import id.aibangstudio.basekotlin.data.remote.createWebService
import id.aibangstudio.basekotlin.data.remote.provideOkHttpClient
import id.aibangstudio.basekotlin.data.pref.PreferencesHelper
import id.aibangstudio.basekotlin.data.remote.service.MusicService
import id.aibangstudio.basekotlin.data.repository.TeamRepository
import id.aibangstudio.basekotlin.data.repository.TeamRepositoryImpl
import id.aibangstudio.basekotlin.data.remote.service.TeamService
import id.aibangstudio.basekotlin.presentation.main.MainViewModel
import id.aibangstudio.momakan.utils.scheduler.AppSchedulerProvider
import id.aibangstudio.momakan.utils.scheduler.SchedulerProvider

val appModule = module {
    single { provideOkHttpClient() }
    single { createWebService<TeamService>(get()) }
    single { createWebService<MusicService>(get()) }

    single { PreferencesHelper(androidContext()) }

    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "app-database").build()
    }

    single { AppSchedulerProvider() as SchedulerProvider }

}

val dataModule = module {
    single { get<AppDatabase>().teamDao() }
    single { TeamRepositoryImpl(get(), get()) as TeamRepository }

    viewModel { MainViewModel(get(), get()) }
}

val myAppModule = listOf(appModule, dataModule)