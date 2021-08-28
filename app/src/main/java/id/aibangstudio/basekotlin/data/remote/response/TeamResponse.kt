package id.aibangstudio.basekotlin.data.remote.response

import id.aibangstudio.basekotlin.domain.entity.Team


data class TeamResponse(
    val teams: List<TeamModel>
)

data class TeamModel(
    val idLeague: String,
    val idSoccerXML: String,
    val idTeam: String,
    val intFormedYear: String,
    val intLoved: Any,
    val intStadiumCapacity: String,
    val strAlternate: String,
    val strCountry: String,
    val strDescriptionCN: Any,
    val strDescriptionDE: Any,
    val strDescriptionEN: String,
    val strDescriptionES: Any,
    val strDescriptionFR: Any,
    val strDescriptionHU: Any,
    val strDescriptionIL: Any,
    val strDescriptionIT: Any,
    val strDescriptionJP: Any,
    val strDescriptionNL: Any,
    val strDescriptionNO: Any,
    val strDescriptionPL: Any,
    val strDescriptionPT: Any,
    val strDescriptionRU: Any,
    val strDescriptionSE: Any,
    val strDivision: Any,
    val strFacebook: String,
    val strGender: String,
    val strInstagram: String,
    val strKeywords: String,
    val strLeague: String,
    val strLocked: String,
    val strManager: String,
    val strRSS: String,
    val strSport: String,
    val strStadium: String,
    val strStadiumDescription: String,
    val strStadiumLocation: String,
    val strStadiumThumb: String,
    val strTeam: String,
    val strTeamBadge: String,
    val strTeamBanner: String,
    val strTeamFanart1: String,
    val strTeamFanart2: String,
    val strTeamFanart3: String,
    val strTeamFanart4: String,
    val strTeamJersey: String,
    val strTeamLogo: String,
    val strTeamShort: Any,
    val strTwitter: String,
    val strWebsite: String,
    val strYoutube: String
){
    fun toEntity() = Team(
        teamId = idTeam,
        teamName = strTeam,
        teamDescription = strDescriptionEN,
        teamLogo = strTeamBadge,
        teamStadiumName = strStadium
    )
}