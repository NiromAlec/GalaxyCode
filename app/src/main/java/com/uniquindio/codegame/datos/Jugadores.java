package com.uniquindio.codegame.datos;

import com.uniquindio.codegame.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Jugadores implements RepositorioJugadores{

    protected List misJugadores;


    public Jugadores() {
        misJugadores = new ArrayList<Jugadores>();
        añadirEjemplos();
    }
    public void añadir(Usuario usuario){
        misJugadores.add(usuario);
    }
    public int tamaño(){
        return misJugadores.size();
    }

    public void obtenerUsuarios(){

    }




    @Override
    public Usuario obtenerJugador(int id) {
        return (Usuario) misJugadores.get(id) ;
    }

    private void añadirEjemplos() {


    }
}
