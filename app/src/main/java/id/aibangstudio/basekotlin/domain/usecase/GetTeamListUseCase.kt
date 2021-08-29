package id.aibangstudio.basekotlin.domain.usecase

import id.aibangstudio.basekotlin.core.Either
import id.aibangstudio.basekotlin.core.base.UseCase
import id.aibangstudio.basekotlin.core.exceptions.Failure
import id.aibangstudio.basekotlin.domain.entity.Team
import id.aibangstudio.basekotlin.domain.repository.TeamRepository

class GetTeamListUseCase(
    private val mTeamRepository: TeamRepository
): UseCase<List<Team>, GetTeamListUseCase.Params>() {

    override suspend fun execute(params: Params): Either<Failure, List<Team>> {
        return mTeamRepository.getTeams(params.leagueString)
    }

    data class Params(
        val leagueString: String
    )

}