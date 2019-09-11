package thortechasia.android.basekotlin.data.repository

import io.reactivex.Single
import thortechasia.android.basekotlin.domain.Team

interface TeamRepository {

    fun getTeams(league: String) : Single<List<Team>>

}