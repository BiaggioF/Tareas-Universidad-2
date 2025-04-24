// app/src/main/java/com/example/aplicacionligas/ui/RegisterFragment.kt
package com.example.aplicacionligas.ui

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.example.aplicacionligas.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterFragment: Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_register, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()
        db   = FirebaseFirestore.getInstance()

        // Botón Atrás en el fragment
        view.findViewById<Button>(R.id.btnBack).setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        view.findViewById<Button>(R.id.btnBack).setOnClickListener {
            findNavController().popBackStack()
        }

        val etName  = view.findViewById<TextInputEditText>(R.id.etName)
        val etAge   = view.findViewById<TextInputEditText>(R.id.etAge)
        val etEmail = view.findViewById<TextInputEditText>(R.id.etEmail)
        val etPass  = view.findViewById<TextInputEditText>(R.id.etPassword)
        val btnDo   = view.findViewById<Button>(R.id.btnDoRegister)

        btnDo.setOnClickListener {
            val name = etName.text.toString().trim()
            val age  = etAge.text.toString().trim().toIntOrNull()
            val email= etEmail.text.toString().trim()
            val pass = etPass.text.toString().trim()
            if (name.isEmpty() || age == null || email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(requireContext(), "Rellena todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            auth.createUserWithEmailAndPassword(email, pass)
                .addOnSuccessListener {
                    val uid = auth.currentUser!!.uid
                    db.collection("users").document(uid)
                        .set(mapOf("name" to name,"age" to age, "email" to email))
                        .addOnSuccessListener {
                            Toast.makeText(requireContext(),
                                "✅ Registro completo", Toast.LENGTH_SHORT).show()
                            // Vuelve a LoginFragment:
                            parentFragmentManager.popBackStack()
                        }
                        .addOnFailureListener {
                            Toast.makeText(requireContext(),
                                "Perfil no guardado: ${it.message}", Toast.LENGTH_LONG).show()
                        }
                }
                .addOnFailureListener {
                    Toast.makeText(requireContext(),
                        "Error registro: ${it.message}", Toast.LENGTH_LONG).show()
                }
        }
    }
}
