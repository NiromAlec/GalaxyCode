package com.uniquindio.codegame.modelo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.uniquindio.codegame.R;
import com.uniquindio.codegame.datos.RepositorioJugadores;

public class AdaptadorJugadores extends FirestoreRecyclerAdapter<Usuario, AdaptadorJugadores.ViewHolder> {

    protected RepositorioJugadores jugadores;
    protected View.OnClickListener onClickListener;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdaptadorJugadores(@NonNull FirestoreRecyclerOptions<Usuario> options) {
        super(options);
    }


    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener=onClickListener;
    }

    public static  class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre;
        public TextView puntaje;


        public ViewHolder(View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.nombreJugador);
            puntaje= itemView.findViewById(R.id.puntaje);


        }

        /*


        public void personaliza(Usuario usuario){
            nombre.setText(usuario.getNombre());



            // icono.setScaleType(ImageView.ScaleType.FIT_END);
        }
        */
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.jugadore_list,viewGroup,false);
      //  v.setOnClickListener(onClickListener);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int posicion, @NonNull Usuario usuario) {
       holder.nombre.setText(usuario.getNombre());
       holder.puntaje.setText("Puntaje :  "+usuario.getPuntaje()+" / "+"5");

    }
/*
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.jugadore_list,parent,false);
        v.setOnClickListener(onClickListener);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int posicion) {
        Usuario usuario=jugadores.obtenerJugador(posicion);
        holder.personaliza(usuario);

    }

    @Override
    public int getItemCount() {
        return jugadores.tamaño();
    }


 */

}
