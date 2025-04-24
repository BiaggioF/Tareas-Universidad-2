package com.example.aplicacionligas.util

import androidx.annotation.DrawableRes
import com.example.aplicacionligas.R
import com.example.aplicacionligas.model.TeamDto

@DrawableRes
fun getLocalBadgeRes(team: TeamDto): Int = when (team.strTeam.lowercase()) {
    "ac milan"     -> R.drawable.milan
    "atalanta bc",
    "atalanta"     -> R.drawable.atalanta
    "bologna"      -> R.drawable.bologna
    "cagliari"      -> R.drawable.cagliari
    "como"          -> R.drawable.como
    else           -> R.drawable.ic_placeholder
}

