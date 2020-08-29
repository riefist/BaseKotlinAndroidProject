package id.aibangstudio.basekotlin.data.remote.service

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import id.aibangstudio.basekotlin.data.remote.response.TeamResponse

interface TeamService {

    @GET("search_all_teams.php")
    fun getAllTeams(@Query("l") league: String) : Single<TeamResponse>

}