package id.aibangstudio.basekotlin.data.remote.service

import id.aibangstudio.basekotlin.data.remote.response.TeamResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TeamService {

    @GET("search_all_teams.php")
    suspend fun getAllTeams(@Query("l") league: String) : TeamResponse

}