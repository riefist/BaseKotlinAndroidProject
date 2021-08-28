package id.aibangstudio.basekotlin.domain.repository

import io.reactivex.Single
import id.aibangstudio.basekotlin.domain.entity.Team

interface TeamRepository {

    fun getTeams(league: String) : Single<List<Team>>

}