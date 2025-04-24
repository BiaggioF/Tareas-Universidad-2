package com.example.aplicacionligas.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionligas.R
import com.example.aplicacionligas.adapter.TeamAdapter
import com.example.aplicacionligas.model.TeamDto
import com.example.aplicacionligas.model.TeamsResponse
import com.example.aplicacionligas.network.RetrofitClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamsFragment : Fragment() {
    private lateinit var db: FirebaseFirestore
    private lateinit var auth: FirebaseAuth

    private val userId: String
        get() = auth.currentUser!!.uid

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val leagueName = arguments?.getString("leagueName") ?: return

        RetrofitClient.api.getTeamsByLeague(leagueName)
            .enqueue(object : Callback<TeamsResponse> {
                override fun onResponse(
                    call: Call<TeamsResponse>,
                    response: Response<TeamsResponse>
                ) {
                    if (response.isSuccessful) {
                        val teams = response.body()?.teams ?: emptyList()
                        setupRecycler(view, teams.take(5))
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Error al cargar equipos: ${response.code()}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(call: Call<TeamsResponse>, t: Throwable) {
                    Toast.makeText(
                        requireContext(),
                        "Fallo red: ${t.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }

    private fun setupRecycler(root: View, teams: List<TeamDto>) {
        val rv = root.findViewById<RecyclerView>(R.id.rvTeams)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = TeamAdapter(teams) { team, isFav ->
            if (isFav) addFavorite(team)
            else removeFavorite(team)
        }
    }

    private fun addFavorite(team: TeamDto) {
        db.collection("users")
            .document(userId)
            .collection("favorites")
            .document(team.idTeam)
            .set(team)
            .addOnSuccessListener {
                Toast.makeText(
                    requireContext(),
                    "${team.strTeam} añadido a favoritos",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(
                    requireContext(),
                    "Error guardando favorito: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
    }

    private fun removeFavorite(team: TeamDto) {
        db.collection("users")
            .document(userId)
            .collection("favorites")
            .document(team.idTeam)
            .delete()
            .addOnSuccessListener {
                Toast.makeText(
                    requireContext(),
                    "${team.strTeam} eliminado de favoritos",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(
                    requireContext(),
                    "Error borrando favorito: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
    }
}
