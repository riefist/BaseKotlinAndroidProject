package id.aibangstudio.basekotlin.data.repository

import id.aibangstudio.basekotlin.data.db.dao.TeamDao
import id.aibangstudio.basekotlin.data.remote.service.TeamService
import id.aibangstudio.basekotlin.domain.entity.Team
import id.aibangstudio.basekotlin.domain.repository.TeamRepository
import io.reactivex.Single

class TeamRepositoryImpl(
    private val teamService: TeamService,
    private val teamDao: TeamDao
) : TeamRepository {

    override fun getTeams(league: String): Single<List<Team>> {
        return teamService.getAllTeams(league)
            .map { it.teams.map { team -> team.toEntity() } }
    }
}