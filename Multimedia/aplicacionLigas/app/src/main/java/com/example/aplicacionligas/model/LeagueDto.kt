package com.example.aplicacionligas.model

data class LeagueDto(
    val idLeague: String,
    val strLeague: String,
    val strSport: String,
    val strLeagueAlternate: String?
)

data class AllLeaguesResponse(
    val leagues: List<LeagueDto>
)
