package com.example.aplicacionligas

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.firebase.FirebaseApp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Carga el layout XML con Toolbar + NavHost
        setContentView(R.layout.activity_main)

        // Inicializa Firebase
        FirebaseApp.initializeApp(this)

        // Asigna el Toolbar como tu ActionBar
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Infla tu menú (home / favoritos / salir)
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Recupera el NavController
        val navController = findNavController(R.id.nav_host_fragment)
        return when (item.itemId) {
            R.id.nav_home -> {
                // Vuelve al inicio de tu grafo (loginFragment o ligasFragment según tu nav_graph)
                navController.popBackStack(
                    navController.graph.startDestinationId, false
                )
                true
            }
            R.id.nav_favorites -> {
                // Navega al fragment de favoritos
                navController.navigate(R.id.favoritesFragment)
                true
            }
            R.id.action_exit -> {
                // Salir de la aplicación
                finishAffinity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
