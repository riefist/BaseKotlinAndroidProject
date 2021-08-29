package id.aibangstudio.basekotlin.data.repository

import id.aibangstudio.basekotlin.core.Either
import id.aibangstudio.basekotlin.core.exceptions.Failure
import id.aibangstudio.basekotlin.data.local.db.dao.TeamDao
import id.aibangstudio.basekotlin.data.remote.service.TeamService
import id.aibangstudio.basekotlin.domain.entity.Team
import id.aibangstudio.basekotlin.domain.repository.TeamRepository

class TeamRepositoryImpl(
    private val teamService: TeamService,
    private val teamDao: TeamDao
) : TeamRepository {

    override suspend fun getTeams(league: String): Either<Failure, List<Team>> {
        return try {
            val result = teamService.getAllTeams(league)

            Either.Right(result.teams.map { it.toEntity() })
        } catch (e: Exception){
            Either.Left(Failure.ServerError("error: ${e.localizedMessage}"))
        }
    }


}