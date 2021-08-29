package id.aibangstudio.basekotlin.presentation.main

import id.aibangstudio.basekotlin.domain.entity.Team

sealed class MainViewState {
    data class Success(val teams: List<Team>): MainViewState()
    object Loading: MainViewState()
    data class Error(val message: String): MainViewState()
}
