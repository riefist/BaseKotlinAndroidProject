package thortechasia.android.basekotlin.di

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import thortechasia.android.basekotlin.data.db.AppDatabase
import thortechasia.android.basekotlin.data.remote.createWebService
import thortechasia.android.basekotlin.data.remote.provideOkHttpClient
import thortechasia.android.basekotlin.data.pref.PreferencesHelper
import thortechasia.android.basekotlin.data.repository.TeamRepository
import thortechasia.android.basekotlin.data.repository.TeamRepositoryImpl
import thortechasia.android.basekotlin.data.remote.service.TeamService
import thortechasia.android.basekotlin.presentation.main.MainViewModel
import thortechasia.android.momakan.utils.scheduler.AppSchedulerProvider
import thortechasia.android.momakan.utils.scheduler.SchedulerProvider

val appModule = module {
    single { provideOkHttpClient() }
    single { createWebService<TeamService>(get()) }

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