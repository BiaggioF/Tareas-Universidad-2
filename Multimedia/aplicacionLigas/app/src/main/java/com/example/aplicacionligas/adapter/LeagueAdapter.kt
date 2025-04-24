package com.example.aplicacionligas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionligas.R
import com.example.aplicacionligas.model.LeagueDto

class LeagueAdapter(
    private val items: List<LeagueDto>,
    private val onClick: (LeagueDto) -> Unit
) : RecyclerView.Adapter<LeagueAdapter.VH>() {

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        private val tvName: TextView = view.findViewById(R.id.tvLeagueName)

        init {
            view.setOnClickListener {

                val league = items[bindingAdapterPosition]
                onClick(league)
            }
        }

        fun bind(league: LeagueDto) {
            tvName.text = league.strLeague
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_league, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])
    }
}
