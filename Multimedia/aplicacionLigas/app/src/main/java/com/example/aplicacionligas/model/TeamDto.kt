package com.example.aplicacionligas.model

import com.google.firebase.firestore.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

@IgnoreExtraProperties
data class TeamDto(
    @SerializedName("idTeam")
    val idTeam: String = "",
    @SerializedName("strTeam")
    val strTeam: String = "",
    @SerializedName("strTeamBadge")
    val strTeamBadge: String? = null
)
