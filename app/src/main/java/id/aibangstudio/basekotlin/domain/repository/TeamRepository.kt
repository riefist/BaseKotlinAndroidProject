package id.aibangstudio.basekotlin.domain.repository

import id.aibangstudio.basekotlin.core.Either
import id.aibangstudio.basekotlin.core.exceptions.Failure
import id.aibangstudio.basekotlin.domain.entity.Team

interface TeamRepository {

    suspend fun getTeams(league: String): Either<Failure, List<Team>>

}