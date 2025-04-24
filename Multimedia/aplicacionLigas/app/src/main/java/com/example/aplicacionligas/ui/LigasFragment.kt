package com.example.aplicacionligas.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionligas.R
import com.example.aplicacionligas.adapter.LeagueAdapter
import com.example.aplicacionligas.model.AllLeaguesResponse
import com.example.aplicacionligas.network.RetrofitClient
import com.example.aplicacionligas.model.LeagueDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LigasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_ligas, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // 1) Lanza la llamada a la API
        RetrofitClient.api.getAllLeagues().enqueue(object : Callback<AllLeaguesResponse> {
            override fun onResponse(
                call: Call<AllLeaguesResponse>,
                response: Response<AllLeaguesResponse>
            ) {
                if (response.isSuccessful) {
                    val all = response.body()?.leagues ?: emptyList()
                    // 2) Filtra solo las de fútbol (strSport == "Soccer")
                    val soccerLeagues = all.filter { it.strSport.equals("Soccer", true) }
                    setupRecyclerView(soccerLeagues)
                } else {
                    Toast.makeText(requireContext(),
                        "Error al cargar ligas: ${response.code()}",
                        Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<AllLeaguesResponse>, t: Throwable) {
                Toast.makeText(requireContext(),
                    "Fallo red: ${t.message}",
                    Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun setupRecyclerView(leagues: List<LeagueDto>) {
        val rvLigas = view?.findViewById<RecyclerView>(R.id.rvLigas)
        if (rvLigas != null) {
            rvLigas.layoutManager = LinearLayoutManager(context)
        }
        if (rvLigas != null) {
            rvLigas.adapter = LeagueAdapter(leagues) { league ->
                findNavController().navigate(
                    R.id.action_ligasFragment_to_teamsFragment,
                    bundleOf("leagueName" to league.strLeague)
                )
            }
        }
    }
}