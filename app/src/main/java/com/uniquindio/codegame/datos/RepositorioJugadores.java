package com.uniquindio.codegame.datos;

import com.uniquindio.codegame.modelo.Usuario;

public interface RepositorioJugadores {

    Usuario obtenerJugador(int id);
    int tamaño();

}
