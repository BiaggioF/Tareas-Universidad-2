package com.example.aplicacionligas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aplicacionligas.R
import com.example.aplicacionligas.model.TeamDto
import com.example.aplicacionligas.util.getLocalBadgeRes

class TeamAdapter(
    private val items: List<TeamDto>,
    private val onFavoriteToggle: (TeamDto, Boolean) -> Unit
) : RecyclerView.Adapter<TeamAdapter.VH>() {

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val ivBadge: ImageView = view.findViewById(R.id.ivBadge)
        val tvName: TextView = view.findViewById(R.id.tvTeamName)
        val btnFav: ImageButton = view.findViewById(R.id.btnFavorite)

        fun bind(team: TeamDto) {
            tvName.text = team.strTeam
            Glide.with(itemView)
                .load(team.strTeamBadge)
                .placeholder(R.drawable.ic_placeholder)
                .into(ivBadge)

            var isFav = false
            btnFav.setImageResource(
                if (isFav) R.drawable.ic_favorite else R.drawable.ic_favorite_border
            )

            btnFav.setOnClickListener {
                isFav = !isFav
                btnFav.setImageResource(
                    if (isFav) R.drawable.ic_favorite else R.drawable.ic_favorite_border
                )
                onFavoriteToggle(team, isFav)
            }
            val badgeUrl = team.strTeamBadge
            if (!badgeUrl.isNullOrEmpty()) {
                Glide.with(itemView).load(badgeUrl)
                    .placeholder(R.drawable.ic_placeholder)
                    .into(ivBadge)
            } else {
                Glide.with(itemView)
                    .load(getLocalBadgeRes(team))
                    .into(ivBadge)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_team, parent, false)
        return VH(v)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])
    }
}
