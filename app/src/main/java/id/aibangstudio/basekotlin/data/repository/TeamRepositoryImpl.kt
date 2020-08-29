package id.aibangstudio.basekotlin.data.repository

import io.reactivex.Single
import id.aibangstudio.basekotlin.data.db.dao.TeamDao
import id.aibangstudio.basekotlin.data.remote.service.TeamService
import id.aibangstudio.basekotlin.domain.Team
import id.aibangstudio.basekotlin.utils.mapToListDomain

class TeamRepositoryImpl(val teamService: TeamService,
                         val teamDao: TeamDao) : TeamRepository{

    override fun getTeams(league: String): Single<List<Team>> {
        return teamService.getAllTeams(league)
            .map { mapToListDomain(it.teams) }
    }
}