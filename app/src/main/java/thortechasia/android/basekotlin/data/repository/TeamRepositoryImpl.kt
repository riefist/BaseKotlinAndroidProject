package thortechasia.android.basekotlin.data.repository

import io.reactivex.Single
import thortechasia.android.basekotlin.data.db.dao.TeamDao
import thortechasia.android.basekotlin.data.remote.service.TeamService
import thortechasia.android.basekotlin.domain.Team
import thortechasia.android.basekotlin.utils.mapToListDomain

class TeamRepositoryImpl(val teamService: TeamService,
                         val teamDao: TeamDao) : TeamRepository{

    override fun getTeams(league: String): Single<List<Team>> {
        return teamService.getAllTeams(league)
            .map { mapToListDomain(it.teams) }
    }
}