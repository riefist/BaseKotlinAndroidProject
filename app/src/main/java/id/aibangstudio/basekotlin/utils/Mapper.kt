package id.aibangstudio.basekotlin.utils

import id.aibangstudio.basekotlin.data.remote.response.TeamModel
import id.aibangstudio.basekotlin.domain.Team

fun mapToDomain(team: TeamModel) : Team {
    return Team(
        teamId = team.idTeam,
        teamName = team.strTeam,
        teamDescription = team.strDescriptionEN,
        teamLogo = team.strTeamBadge,
        teamStadiumName = team.strStadium
    )
}

fun mapToListDomain(teams: List<TeamModel>) : List<Team> {
    val listDomain = mutableListOf<Team>()
    teams.map { listDomain.add(mapToDomain(it)) }
    return listDomain
}