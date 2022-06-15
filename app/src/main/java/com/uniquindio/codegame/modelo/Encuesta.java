package com.uniquindio.codegame.modelo;

public class Encuesta {

    private String nombreUser;
    private int respuesta_01;
    private int respuesta_02;
    private int respuesta_03;

    public Encuesta() {
    }

    public Encuesta(String nombreUser, int respuesta_01, int respuesta_02, int respuesta_03) {
        this.nombreUser = nombreUser;
        this.respuesta_01 = respuesta_01;
        this.respuesta_02 = respuesta_02;
        this.respuesta_03 = respuesta_03;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public int getRespuesta_01() {
        return respuesta_01;
    }

    public void setRespuesta_01(int respuesta_01) {
        this.respuesta_01 = respuesta_01;
    }

    public int getRespuesta_02() {
        return respuesta_02;
    }

    public void setRespuesta_02(int respuesta_02) {
        this.respuesta_02 = respuesta_02;
    }

    public int getRespuesta_03() {
        return respuesta_03;
    }

    public void setRespuesta_03(int respuesta_03) {
        this.respuesta_03 = respuesta_03;
    }
}
