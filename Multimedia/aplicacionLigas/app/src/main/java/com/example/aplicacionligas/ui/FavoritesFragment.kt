package com.example.aplicacionligas.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionligas.R
import com.example.aplicacionligas.adapter.TeamAdapter
import com.example.aplicacionligas.model.TeamDto
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FavoritesFragment : Fragment() {

    private lateinit var db: FirebaseFirestore
    private lateinit var auth: FirebaseAuth

    // Obtenemos el UID del usuario logueado
    private val userId: String
        get() = auth.currentUser!!.uid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializamos Auth y Firestore
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()
        // Si quieres tener un menú en este fragment:
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_favorites, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
                view.findViewById<Button>(R.id.btnBack)
            .setOnClickListener{
                findNavController().navigateUp()
            }
        loadFavorites(view)
    }

    private fun loadFavorites(root: View) {
        // Leemos todos los documentos de users/{uid}/favorites
        db.collection("users")
            .document(userId)
            .collection("favorites")
            .get()
            .addOnSuccessListener { snap ->
                // Convertimos cada documento a TeamDto
                val favs = snap.toObjects(TeamDto::class.java)
                setupRecycler(root, favs)
            }
            .addOnFailureListener { e ->
                Toast.makeText(
                    requireContext(),
                    "Error cargando favoritos: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
    }

    private fun setupRecycler(root: View, teams: List<TeamDto>) {
        val rv = root.findViewById<RecyclerView>(R.id.rvFavorites)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = TeamAdapter(teams) { team, isFav ->
            // En la lista de favoritos, si el usuario desmarca (isFav == false)
            // borramos el documento de Firestore y recargamos la lista
            if (!isFav) removeFavorite(team)
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
                // Refrescamos la lista tras la eliminación
                view?.let { loadFavorites(it) }
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
