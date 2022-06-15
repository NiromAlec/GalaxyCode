package com.uniquindio.codegame.modelo;

import java.io.Serializable;

public class Usuario implements Serializable {

    String nombre;
    boolean nv1=false;
    boolean nv2=false;
    boolean nv3=false;
    boolean nv4=false;
    boolean nv5=false;
    int puntaje=0;

    public Usuario() {
    }

    public Usuario(String nombre, boolean nv1, boolean nv2, boolean nv3, boolean nv4, boolean nv5, int puntaje) {
        this.nombre = nombre;
        this.nv1 = nv1;
        this.nv2 = nv2;
        this.nv3 = nv3;
        this.nv4 = nv4;
        this.nv5 = nv5;
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isNv1() {
        return nv1;
    }

    public void setNv1(boolean nv1) {
        this.nv1 = nv1;
    }

    public boolean isNv2() {
        return nv2;
    }

    public void setNv2(boolean nv2) {
        this.nv2 = nv2;
    }

    public boolean isNv3() {
        return nv3;
    }

    public void setNv3(boolean nv3) {
        this.nv3 = nv3;
    }

    public boolean isNv4() {
        return nv4;
    }

    public void setNv4(boolean nv4) {
        this.nv4 = nv4;
    }

    public boolean isNv5() {
        return nv5;
    }

    public void setNv5(boolean nv5) {
        this.nv5 = nv5;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
