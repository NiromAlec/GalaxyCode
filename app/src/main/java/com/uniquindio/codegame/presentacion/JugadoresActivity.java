package com.uniquindio.codegame.presentacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.uniquindio.codegame.R;
import com.uniquindio.codegame.modelo.Usuario;
import com.uniquindio.codegame.modelo.AdaptadorJugadores;


public class JugadoresActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    AdaptadorJugadores adaptadorJugadores;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugadores);

        recyclerView= findViewById(R.id.listReciclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        firebaseFirestore= FirebaseFirestore.getInstance();

        /** Consulta a la base de datos de los usuarios ordenados
         *  de mayor a menor segun su puntaje en el test*/
        Query query = firebaseFirestore.collection("users").orderBy("puntaje", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<Usuario> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Usuario>().setQuery(query, Usuario.class).build();

        adaptadorJugadores = new AdaptadorJugadores(firestoreRecyclerOptions);
        adaptadorJugadores.notifyDataSetChanged();
        recyclerView.setAdapter(adaptadorJugadores);

    }

    @Override
    protected  void onStart(){
        super.onStart();
        adaptadorJugadores.startListening();
    }

    @Override
    protected void onStop(){
        super.onStop();
        adaptadorJugadores.stopListening();
    }

}