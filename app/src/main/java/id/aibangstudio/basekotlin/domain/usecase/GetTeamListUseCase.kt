package id.aibangstudio.basekotlin.domain.usecase

import id.aibangstudio.basekotlin.core.scheduler.SchedulerProvider
import id.aibangstudio.basekotlin.core.usecase.SingleUseCase
import id.aibangstudio.basekotlin.domain.entity.Team
import id.aibangstudio.basekotlin.domain.repository.TeamRepository
import io.reactivex.Single

class GetTeamListUseCase(
    private val mTeamRepository: TeamRepository,
    mSchedulerProvider: SchedulerProvider
): SingleUseCase<List<Team>, String>(mSchedulerProvider) {

    override fun execute(params: String?): Single<List<Team>> {
        requireNotNull(params, { "params can't be null" })
        return mTeamRepository.getTeams(params)
    }
}