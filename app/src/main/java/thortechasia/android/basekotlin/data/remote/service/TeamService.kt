package thortechasia.android.basekotlin.data.remote.service

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import thortechasia.android.basekotlin.data.remote.response.TeamResponse

interface TeamService {

    @GET("search_all_teams.php")
    fun getAllTeams(@Query("l") league: String) : Single<TeamResponse>

}