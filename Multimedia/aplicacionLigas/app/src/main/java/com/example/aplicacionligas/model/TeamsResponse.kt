// app/src/main/java/com/example/aplicacionligas/model/TeamsResponse.kt
package com.example.aplicacionligas.model

import com.google.firebase.firestore.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

@IgnoreExtraProperties
data class TeamsResponse(
    @SerializedName("teams")
    val teams: List<TeamDto> = emptyList()
)
