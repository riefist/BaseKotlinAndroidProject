package id.aibangstudio.basekotlin.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.aibangstudio.basekotlin.domain.entity.Team
import id.aibangstudio.basekotlin.domain.usecase.GetTeamListUseCase
import id.aibangstudio.basekotlin.presentation.base.BaseViewModel
import id.aibangstudio.basekotlin.utils.UiState

class MainViewModel(
    private val mGetTeamListUseCase: GetTeamListUseCase
) : BaseViewModel() {

    private val _state = MutableLiveData<UiState<List<Team>>>()
    val teamState: LiveData<UiState<List<Team>>> = _state

    fun getTeams(league: String) {
        _state.value = UiState.Loading()
        compositeDisposable.add(
            mGetTeamListUseCase(league)
                .subscribe({
                    _state.value = UiState.Success(it)
                }, this::onError)
        )
    }

    override fun onError(error: Throwable) {
        _state.value = UiState.Error(error)
    }

}