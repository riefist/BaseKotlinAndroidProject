package thortechasia.android.basekotlin.presentation.main

import androidx.lifecycle.MutableLiveData
import thortechasia.android.basekotlin.data.repository.TeamRepository
import thortechasia.android.basekotlin.domain.Team
import thortechasia.android.basekotlin.presentation.base.BaseViewModel
import thortechasia.android.basekotlin.utils.UiState
import thortechasia.android.momakan.utils.scheduler.SchedulerProvider
import thortechasia.android.momakan.utils.scheduler.with

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