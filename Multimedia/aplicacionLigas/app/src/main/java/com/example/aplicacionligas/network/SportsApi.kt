package com.example.aplicacionligas.network

import com.example.aplicacionligas.model.AllLeaguesResponse
import com.example.aplicacionligas.model.TeamsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SportsApi {
    // Test API key=3, endpoint V1:
    @GET("api/v1/json/3/all_leagues.php")
    fun getAllLeagues(): Call<AllLeaguesResponse>
    @GET("api/v1/json/3/search_all_teams.php")
    fun getTeamsByLeague(@Query("l") leagueName: String): Call<TeamsResponse>
}