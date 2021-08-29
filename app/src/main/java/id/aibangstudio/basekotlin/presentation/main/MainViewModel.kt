package id.aibangstudio.basekotlin.presentation.main

import androidx.lifecycle.viewModelScope
import id.aibangstudio.basekotlin.core.base.BaseViewModel
import id.aibangstudio.basekotlin.core.exceptions.Failure
import id.aibangstudio.basekotlin.domain.usecase.GetTeamListUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val mGetTeamListUseCase: GetTeamListUseCase
) : BaseViewModel<MainViewState>() {

    fun getTeams(league: String){
        uiState.postValue(MainViewState.Loading)
        viewModelScope.launch {
            val result = mGetTeamListUseCase.execute(GetTeamListUseCase.Params(league))
            result.fold(::handleError) {
                uiState.postValue(MainViewState.Success(it))
            }
        }
    }

    override fun handleError(failure: Failure) {
        when (failure) {
            is Failure.ServerError -> {
                uiState.postValue(MainViewState.Error("server error : ${failure.message}"))
            }
        }
    }

}