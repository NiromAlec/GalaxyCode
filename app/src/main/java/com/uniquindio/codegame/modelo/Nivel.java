package com.uniquindio.codegame.modelo;



public class Nivel  {

  private String nombreNivel="";
  private int numeroGanadores=0;
  private int numeroPerdedores=0;

    public Nivel() {
    }

    public Nivel(String nombreNivel, int numeroGanadores, int numeroPerdedores) {
        this.nombreNivel = nombreNivel;
        this.numeroGanadores = numeroGanadores;
        this.numeroPerdedores = numeroPerdedores;
    }

    public void setNombreNivel(String nombreNivel) {
        this.nombreNivel = nombreNivel;
    }

    public void setNumeroGanadores(int numeroGanadores) {
        this.numeroGanadores = numeroGanadores;
    }

    public void setNumeroPerdedores(int numeroPerdedores) {
        this.numeroPerdedores = numeroPerdedores;
    }

    public String getNombreNivel() {
        return nombreNivel;
    }

    public int getNumeroGanadores() {
        return numeroGanadores;
    }

    public int getNumeroPerdedores() {
        return numeroPerdedores;
    }
}
