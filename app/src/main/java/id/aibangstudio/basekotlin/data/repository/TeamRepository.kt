package id.aibangstudio.basekotlin.data.repository

import io.reactivex.Single
import id.aibangstudio.basekotlin.domain.Team

interface TeamRepository {

    fun getTeams(league: String) : Single<List<Team>>

}