package id.aibangstudio.basekotlin.presentation.main

import androidx.lifecycle.MutableLiveData
import id.aibangstudio.basekotlin.data.repository.TeamRepository
import id.aibangstudio.basekotlin.domain.Team
import id.aibangstudio.basekotlin.presentation.base.BaseViewModel
import id.aibangstudio.basekotlin.utils.UiState
import id.aibangstudio.momakan.utils.scheduler.SchedulerProvider
import id.aibangstudio.momakan.utils.scheduler.with

class MainViewModel(
    val teamRepository: TeamRepository,
    val schedulerProvider: SchedulerProvider
) : BaseViewModel() {

    val teamState = MutableLiveData<UiState<List<Team>>>()

    fun getTeams(league: String) {
        teamState.value = UiState.Loading()
        compositeDisposable.add(teamRepository.getTeams(league)
            .with(schedulerProvider)
            .subscribe({
                teamState.value = UiState.Success(it)
            }, this::onError)
        )
    }

    override fun onError(error: Throwable) {
        teamState.value = UiState.Error(error)
    }

}