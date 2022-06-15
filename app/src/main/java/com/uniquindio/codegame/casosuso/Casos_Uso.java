package com.uniquindio.codegame.casosuso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.uniquindio.codegame.presentacion.EncuestaActivity;
import com.uniquindio.codegame.presentacion.EstadisticasActivity;
import com.uniquindio.codegame.presentacion.JugadoresActivity;
import com.uniquindio.codegame.presentacion.MainActivity;
import com.uniquindio.codegame.presentacion.Nivel_1;
import com.uniquindio.codegame.presentacion.Nivel_2;
import com.uniquindio.codegame.presentacion.Nivel_3;
import com.uniquindio.codegame.presentacion.Nivel_4;
import com.uniquindio.codegame.presentacion.Nivel_5;
import com.uniquindio.codegame.R;
import com.uniquindio.codegame.presentacion.RegistroActivity;
import com.uniquindio.codegame.presentacion.ResultadosActivity;
import com.uniquindio.codegame.modelo.Usuario;
import com.uniquindio.codegame.presentacion.ventana_info;
import com.uniquindio.codegame.presentacion.ventana_menu;

import java.util.Timer;
import java.util.TimerTask;

public class Casos_Uso {
    /**Actividad del contexto*/
    private Activity actividad;

    /**Animaciones Transiciones entre actividades*/
    public static int zoomIn = R.anim.zoom_in;
    public static int zoomOut = R.anim.zoom_out;



    public Casos_Uso (Activity actividad){
        this.actividad = actividad;
    }

    /**Seccion niveles */
    /**
     * Caso de Uso que se encarga de adaptar
     * y lanzar la ventana de informacion
     */
    public void mostrarVentana(String mensaje01, String tryAgain, int cod){

        Intent i = new Intent(actividad, ventana_info.class);
      //parametros

        i.putExtra("mensaje", mensaje01);
        i.putExtra("try", tryAgain);
        i.putExtra("codigo", cod);
        actividad.startActivity(i);
        actividad.overridePendingTransition(zoomIn,0);


    }


    public void lanzarNivel1(Usuario usuario){


        Intent i= new Intent(actividad, Nivel_1.class);

        Bundle bundle=new Bundle();
        bundle.putSerializable("user", usuario);
        i.putExtras(bundle);
        i.putExtra("user", usuario);


        actividad.startActivity(i);
        actividad.overridePendingTransition(zoomIn,0);


        final Handler handler = new Handler();
        Timer t3 = new Timer();
        t3.schedule(new TimerTask() {
            public void run() {

                handler.post(new Runnable() {
                    public void run() {

                        actividad.finish();

                    }
                });
            }
        }, 1000);


    }

    public void lanzarNivel2(Usuario usuario){


        Intent i= new Intent(actividad, Nivel_2.class);

        Bundle bundle=new Bundle();
        bundle.putSerializable("user", usuario);
        i.putExtras(bundle);
        i.putExtra("user", usuario);

        actividad.startActivity(i);
        actividad.overridePendingTransition(zoomIn,0);


        final Handler handler = new Handler();
        Timer t3 = new Timer();
        t3.schedule(new TimerTask() {
            public void run() {

                handler.post(new Runnable() {
                    public void run() {
                        actividad.finish();
                    }
                });
            }
        }, 1000);


    }

    public void lanzarNivel3(Usuario usuario){


        Intent i= new Intent(actividad, Nivel_3.class);

        Bundle bundle=new Bundle();
        bundle.putSerializable("user", usuario);
        i.putExtras(bundle);
        i.putExtra("user", usuario);

        actividad.startActivity(i);
        actividad.overridePendingTransition(zoomIn,0);
        // actividad.finish();

        final Handler handler = new Handler();
        Timer t3 = new Timer();
        t3.schedule(new TimerTask() {
            public void run() {

                handler.post(new Runnable() {
                    public void run() {

                        actividad.finish();

                    }
                });
            }
        }, 1000);


    }


    public void lanzarNivel4(Usuario usuario){


        Intent i= new Intent(actividad, Nivel_4.class);

        Bundle bundle=new Bundle();
        bundle.putSerializable("user", usuario);
        i.putExtras(bundle);
        i.putExtra("user", usuario);

        actividad.startActivity(i);
        actividad.overridePendingTransition(zoomIn,0);

        final Handler handler = new Handler();
        Timer t3 = new Timer();
        t3.schedule(new TimerTask() {
            public void run() {

                handler.post(new Runnable() {
                    public void run() {

                        actividad.finish();

                    }
                });
            }
        }, 1000);


    }

    public void lanzarNivel5(Usuario usuario){


        Intent i= new Intent(actividad, Nivel_5.class);

        Bundle bundle=new Bundle();
        bundle.putSerializable("user", usuario);
        i.putExtras(bundle);
        i.putExtra("user", usuario);

        actividad.startActivity(i);
        actividad.overridePendingTransition(zoomIn,0);

        final Handler handler = new Handler();
        Timer t3 = new Timer();
        t3.schedule(new TimerTask() {
            public void run() {

                handler.post(new Runnable() {
                    public void run() {

                        actividad.finish();

                    }
                });
            }
        }, 1000);


    }

    public void lanzarResultados(Usuario usuario){


        Intent i= new Intent(actividad, ResultadosActivity.class);

        Bundle bundle=new Bundle();
        bundle.putSerializable("user", usuario);
        i.putExtras(bundle);
        i.putExtra("user", usuario);

        actividad.startActivity(i);
        actividad.overridePendingTransition(zoomIn,0);

        final Handler handler = new Handler();
        Timer t3 = new Timer();
        t3.schedule(new TimerTask() {
            public void run() {

                handler.post(new Runnable() {
                    public void run() {

                        actividad.finish();

                    }
                });
            }
        }, 1000);


    }

    public void lanzarMain(){


        Intent i= new Intent(actividad, MainActivity.class);
        actividad.startActivity(i);
        actividad.overridePendingTransition(zoomIn,0);

        final Handler handler = new Handler();
        Timer t3 = new Timer();
        t3.schedule(new TimerTask() {
            public void run() {

                handler.post(new Runnable() {
                    public void run() {

                        actividad.finish();

                    }
                });
            }
        }, 2000);


    }

    public void lanzarEncuesta(Usuario usuario){


        Intent i= new Intent(actividad, EncuestaActivity.class);

        Bundle bundle=new Bundle();
        bundle.putSerializable("user", usuario);
        i.putExtras(bundle);
        i.putExtra("user", usuario);


        actividad.startActivity(i);
        actividad.overridePendingTransition(zoomIn,0);


        final Handler handler = new Handler();
        Timer t3 = new Timer();
        t3.schedule(new TimerTask() {
            public void run() {

                handler.post(new Runnable() {
                    public void run() {

                        actividad.finish();

                    }
                });
            }
        }, 1000);


    }
    /**Seccion Main */
    public void lanzarInicio(){
        Intent i= new Intent(actividad, RegistroActivity.class);
        actividad.startActivity(i);
        actividad.overridePendingTransition(zoomIn,0);
    }

    public void lanzarMenu(){
        Intent i= new Intent(actividad, ventana_menu.class);
        actividad.startActivity(i);
        actividad.overridePendingTransition(zoomIn,0);
    }

    /** Seccion menu */
    public void mostrarjugadores(){
        Intent i= new Intent(actividad, JugadoresActivity.class);
        actividad.startActivity(i);
        actividad.overridePendingTransition(zoomIn,0);
    }

    public void mostrarEstadisticas(){
        Intent i= new Intent(actividad, EstadisticasActivity.class);
        actividad.startActivity(i);
        actividad.overridePendingTransition(zoomIn,0);
    }






}
