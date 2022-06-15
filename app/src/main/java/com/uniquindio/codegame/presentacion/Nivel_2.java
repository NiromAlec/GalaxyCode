package com.uniquindio.codegame.presentacion;

import static android.view.View.GONE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.uniquindio.codegame.R;
import com.uniquindio.codegame.casosuso.Casos_Uso;
import com.uniquindio.codegame.modelo.Usuario;

import java.util.Timer;
import java.util.TimerTask;

public class Nivel_2 extends AppCompatActivity {

    /**Animaciones de la matriz*/
    // FILA (0)
    LottieAnimationView hero_00;
    LottieAnimationView hero_01;
    LottieAnimationView hero_02;
    LottieAnimationView hero_03;
    LottieAnimationView hero_04;
    LottieAnimationView hero_05;
    // FILA (1)
    LottieAnimationView hero_10;
    LottieAnimationView hero_11;
    LottieAnimationView hero_12;
    LottieAnimationView hero_13;
    LottieAnimationView hero_14;
    LottieAnimationView hero_15;
    // FILA (2)
    LottieAnimationView hero_20;
    LottieAnimationView hero_21;
    LottieAnimationView hero_22;
    LottieAnimationView hero_23;
    LottieAnimationView hero_24;
    LottieAnimationView hero_25;
    // FILA (3)
    LottieAnimationView hero_30;
    LottieAnimationView hero_31;
    LottieAnimationView hero_32;
    LottieAnimationView hero_33;
    LottieAnimationView hero_34;
    LottieAnimationView hero_35;
    // FILA (4)
    LottieAnimationView hero_40;
    LottieAnimationView hero_41;
    LottieAnimationView hero_42;
    LottieAnimationView hero_43;
    LottieAnimationView hero_44;
    LottieAnimationView hero_45;
    // FILA (5)
    LottieAnimationView hero_50;
    LottieAnimationView hero_51;
    LottieAnimationView hero_52;
    LottieAnimationView hero_53;
    LottieAnimationView hero_54;
    LottieAnimationView hero_55;

    LottieAnimationView hero_Aux;
    LottieAnimationView hero_Aux02;

    TextView sentencias;
    private Casos_Uso casos_uso;
    /** Constantes de dialogo*/
    static final String mensaje01="No te alcanzó para \n llegar al Destino";
    static final String tryAgain="Respuesta Incorrecta";
    static final String mensaje02="FUERA DEL LIMITE";
    static final String mensaje03="Respuesta Correcta!";
    static final String mensaje04="No puedes pisar Lava";
    Usuario user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel2);

        /** Mensaje tutorial sobre el nivel*/
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_nv2,null);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

        casos_uso=new Casos_Uso(this);

        Bundle objetoUser=getIntent().getExtras();

        user=null;
        if(objetoUser!=null){
            user=(Usuario) objetoUser.getSerializable("user");

        }

        /**
         * conexion parte logica con la interfaz nivel 1
         */
        sentencias=findViewById(R.id.listaSecuencias);
        //FILA(0)
        hero_00=(LottieAnimationView) findViewById(R.id.cero);
        hero_01=(LottieAnimationView) findViewById(R.id.uno);
        hero_02=(LottieAnimationView) findViewById(R.id.dos);
        hero_03=(LottieAnimationView) findViewById(R.id.tres);
        hero_04=(LottieAnimationView) findViewById(R.id.cuatro);
        hero_05=(LottieAnimationView) findViewById(R.id.cinco);
        //FILA(1)
        hero_10=(LottieAnimationView) findViewById(R.id.seis);
        hero_11=(LottieAnimationView) findViewById(R.id.siete);
        hero_12=(LottieAnimationView) findViewById(R.id.ocho);
        hero_13=(LottieAnimationView) findViewById(R.id.nueve);
        hero_14=(LottieAnimationView) findViewById(R.id.diez);
        hero_15=(LottieAnimationView) findViewById(R.id.once);
        //FILA(2)
        hero_20=(LottieAnimationView) findViewById(R.id.doce);
        hero_21=(LottieAnimationView) findViewById(R.id.trece);
        hero_22=(LottieAnimationView) findViewById(R.id.catorce);
        hero_23=(LottieAnimationView) findViewById(R.id.quince);
        hero_24=(LottieAnimationView) findViewById(R.id.diezseis);
        hero_25=(LottieAnimationView) findViewById(R.id.diezsiete);
        //FILA(3)
        hero_30=(LottieAnimationView) findViewById(R.id.diezocho);
        hero_31=(LottieAnimationView) findViewById(R.id.dieznueve);
        hero_32=(LottieAnimationView) findViewById(R.id.veinte);
        hero_33=(LottieAnimationView) findViewById(R.id.veinteuno);
        hero_34=(LottieAnimationView) findViewById(R.id.veintedos);
        hero_35=(LottieAnimationView) findViewById(R.id.veintetres);
        //FILA(4)
        hero_40=(LottieAnimationView) findViewById(R.id.veintecuatro);
        hero_41=(LottieAnimationView) findViewById(R.id.veintecinco);
        hero_42=(LottieAnimationView) findViewById(R.id.veinteseis);
        hero_43=(LottieAnimationView) findViewById(R.id.veintesiete);
        hero_44=(LottieAnimationView) findViewById(R.id.veinteocho);
        hero_45=(LottieAnimationView) findViewById(R.id.veintenueve);
        //FILA(4)
        hero_50=(LottieAnimationView) findViewById(R.id.treinta);
        hero_51=(LottieAnimationView) findViewById(R.id.treintauno);
        hero_52=(LottieAnimationView) findViewById(R.id.treintados);
        hero_53=(LottieAnimationView) findViewById(R.id.treintatres);
        hero_54=(LottieAnimationView) findViewById(R.id.treintacuatro);
        hero_55=(LottieAnimationView) findViewById(R.id.treintacinco);

        /**
         * Play a la animacion principal
         */
        hero_05.setVisibility(View.VISIBLE);
        hero_05.playAnimation();
        hero_50.setVisibility(View.VISIBLE);
        hero_50.playAnimation();




    }

    /**
     * Metodo que se invoca al dar clic
     * en el boton PLAY
     */
    public void onClick(View view) {


        if(sentencias.getText().toString().equals("")){
            Toast.makeText(Nivel_2.this, "Ingresa el Recorrido", Toast.LENGTH_SHORT).show();
        }else{
            restaurar();

            int posInicial=0;
            int posInicial2=5;


            /**
             * Creacion de la matriz y
             * variables que se usaran en el
             * recorrido del personaje
             */

            int matriz01[][] = {{ 0, 0, 3, 0, 0, 1},
                                { 3, 0, 0, 0, 0, 0},
                                { 0, 0, 3, 0, 0, 0},
                                { 0, 0, 3, 0, 3, 0},
                                { 0, 0, 0, 0, 0, 0},
                                { 2, 0, 0, 3, 0, 0 }};
            String cadenaDeDirecciones="";
            cadenaDeDirecciones=sentencias.getText().toString();
            String[] arrayDirecciones = cadenaDeDirecciones.split("-");
            moverPersonaje(matriz01,posInicial, posInicial2,arrayDirecciones,0);
            sentencias.setText("");

        }

    }



    public int moverPersonaje(int matriz[][], int posInicial, int posInicial2, String [] arrayDirecciones, int linea){
        if(matriz[posInicial][posInicial2] == 2) {

            /**El puntaje del jugador aumenta 1 y
             * se establece el estado del nivel */
            user.setPuntaje(user.getPuntaje()+1);
            user.setNv2(true);

            final Handler handlerr = new Handler();
            Timer t2 = new Timer();
            t2.schedule(new TimerTask() {
                public void run() {
                    handlerr.post(new Runnable() {
                        public void run() {
                            casos_uso.mostrarVentana(mensaje03,"",3);
                        }
                    });
                }
            }, 900*linea);

            /** Se lanza el siguiente  nivel*/

            final Handler handler = new Handler();
            Timer t3 = new Timer();
            t3.schedule(new TimerTask() {
                public void run() {

                    handlerr.post(new Runnable() {
                        public void run() {

                            casos_uso.lanzarNivel3(user);

                        }
                    });
                }
            }, 1200*linea);
            return 1;
        }

        if(matriz[posInicial][posInicial2] == 3) {
            final Handler handlerr = new Handler();
            Timer t2 = new Timer();
            t2.schedule(new TimerTask() {
                public void run() {

                    handlerr.post(new Runnable() {
                        public void run() {

                            casos_uso.mostrarVentana(mensaje04,tryAgain,4);
                            restaurar();
                        }
                    });
                }
            }, 900*linea);

            /** Se lanza el siguiente  nivel*/

            final Handler handler = new Handler();
            Timer t3 = new Timer();
            t3.schedule(new TimerTask() {
                public void run() {

                    handlerr.post(new Runnable() {
                        public void run() {
                            casos_uso.lanzarNivel3(user);
                        }
                    });
                }
            }, 1200*linea);
            return 1;
        }

        if(linea>=arrayDirecciones.length) {

            final Handler handlerr = new Handler();
            Timer t2 = new Timer();
            t2.schedule(new TimerTask() {
                public void run() {

                    handlerr.post(new Runnable() {
                        public void run() {
                            casos_uso.mostrarVentana(mensaje01,tryAgain,1);
                            restaurar();
                        }
                    });
                }
            }, 900*linea);

            /** Se lanza el siguiente  nivel*/

            final Handler handler = new Handler();
            Timer t3 = new Timer();
            t3.schedule(new TimerTask() {
                public void run() {

                    handlerr.post(new Runnable() {
                        public void run() {

                            casos_uso.lanzarNivel3(user);

                        }
                    });
                }
            }, 1200*linea);


            return 1;
        }

        if(arrayDirecciones[linea].equals("Arriba") ) {

            /**
             * para subir se le resta uno a la posicion fila
             * y la posicion columna se mantiene
             */
            final int g=posInicial;
            final int h=posInicial2;

            int i=posInicial-1;
            int j=posInicial2;

            if(i<0 ) {
                //al retornar 1 la recursividad se detiene y se restaura lo dibujado en la matriz
                final Handler handlerr = new Handler();
                Timer t2 = new Timer();
                t2.schedule(new TimerTask() {
                    public void run() {

                        handlerr.post(new Runnable() {
                            public void run() {
                                casos_uso.mostrarVentana(mensaje02,tryAgain,2);
                                restaurar();
                            }
                        });
                    }
                }, 900*linea);

                /** Se lanza el siguiente  nivel*/

                final Handler handler = new Handler();
                Timer t3 = new Timer();
                t3.schedule(new TimerTask() {
                    public void run() {

                        handlerr.post(new Runnable() {
                            public void run() {

                                casos_uso.lanzarNivel3(user);

                            }
                        });
                    }
                }, 1200*linea);

                return 1;
            }else {

                final Handler handlerr = new Handler();
                Timer t2 = new Timer();
                t2.schedule(new TimerTask() {
                    public void run() {
                        handlerr.post(new Runnable() {
                            public void run() {
                                String id=g+""+h;
                                int idInt = Integer.parseInt(id);
                                hero_Aux=findViewById(seleccionarPersonaje(idInt));
                                hero_Aux.setVisibility(GONE);
                                String id2=i+""+j;
                                int idInt2 = Integer.parseInt(id2);
                                hero_Aux02=findViewById(seleccionarPersonaje(idInt2));
                                hero_Aux02.setVisibility(View.VISIBLE);
                                hero_Aux02.playAnimation();
                            }
                        });
                    }
                }, 1000*linea);

                posInicial=i;
                posInicial2=j;
                return moverPersonaje(matriz, posInicial, posInicial2, arrayDirecciones, linea+1);
            }


        }

        /**
         * ABAJO
         * verifica la posicion abajo y la imprime
         */
        if(arrayDirecciones[linea].equals("Abajo") ) {

            /**
             * para bajar se le suma uno a la posicion fila
             * y la posicion columna se mantiene
             */
            final int g=posInicial;
            final int h=posInicial2;

            int i=posInicial+1;
            int j=posInicial2;

            if(i>=matriz.length ) {
                final Handler handlerr = new Handler();
                Timer t2 = new Timer();
                t2.schedule(new TimerTask() {
                    public void run() {

                        handlerr.post(new Runnable() {
                            public void run() {
                                casos_uso.mostrarVentana(mensaje02,tryAgain,2);
                                restaurar();
                            }
                        });
                    }
                }, 900*linea);

                /** Se lanza el siguiente  nivel*/

                final Handler handler = new Handler();
                Timer t3 = new Timer();
                t3.schedule(new TimerTask() {
                    public void run() {

                        handlerr.post(new Runnable() {
                            public void run() {

                                casos_uso.lanzarNivel3(user);

                            }
                        });
                    }
                }, 1200*linea);

                //al retornar 1 la recursividad se detiene
                return 1;
            }else {
                /**
                 * cambio de animacion segun la posicion en la matriz
                 */

                final Handler handlerr = new Handler();
                Timer t2 = new Timer();
                t2.schedule(new TimerTask() {
                    public void run() {
                        handlerr.post(new Runnable() {
                            public void run() {
                                String id=g+""+h;
                                int idInt = Integer.parseInt(id);
                                hero_Aux=findViewById(seleccionarPersonaje(idInt));
                                hero_Aux.setVisibility(GONE);
                                String id2=i+""+j;
                                int idInt2 = Integer.parseInt(id2);
                                hero_Aux02=findViewById(seleccionarPersonaje(idInt2));
                                hero_Aux02.setVisibility(View.VISIBLE);
                                hero_Aux02.playAnimation();
                            }
                        });
                    }
                }, 1000*linea);



                posInicial=i;
                posInicial2=j;
                return moverPersonaje(matriz, posInicial, posInicial2, arrayDirecciones, linea+1);
            }

        }

        /**
         * IZQUIERDA
         * verifica la posicion izquierda y la imprime
         */
        if(arrayDirecciones[linea].equals("Izquierda") ) {

            /**
             * para mover a la izquierda se le resta uno a
             * la posicion columna
             * y la posicion fila se mantiene
             */
            final int g=posInicial;
            final int h=posInicial2;

            int i=posInicial;
            int j=posInicial2-1;

            if(j<0 ) {
                final Handler handlerr = new Handler();
                Timer t2 = new Timer();
                t2.schedule(new TimerTask() {
                    public void run() {

                        handlerr.post(new Runnable() {
                            public void run() {
                                casos_uso.mostrarVentana(mensaje02,tryAgain,2);
                                restaurar();

                            }
                        });
                    }
                }, 900*linea);

                /** Se lanza el siguiente  nivel*/

                final Handler handler = new Handler();
                Timer t3 = new Timer();
                t3.schedule(new TimerTask() {
                    public void run() {

                        handlerr.post(new Runnable() {
                            public void run() {

                                casos_uso.lanzarNivel3(user);

                            }
                        });
                    }
                }, 1200*linea);
                //al retornar 1 la recursividad se detiene
                return 1;
            }else {

                final Handler handlerr = new Handler();
                Timer t2 = new Timer();
                t2.schedule(new TimerTask() {
                    public void run() {
                        handlerr.post(new Runnable() {
                            public void run() {
                                String id=g+""+h;
                                int idInt = Integer.parseInt(id);
                                hero_Aux=findViewById(seleccionarPersonaje(idInt));
                                hero_Aux.setVisibility(GONE);
                                String id2=i+""+j;
                                int idInt2 = Integer.parseInt(id2);
                                hero_Aux02=findViewById(seleccionarPersonaje(idInt2));
                                hero_Aux02.setVisibility(View.VISIBLE);
                                hero_Aux02.playAnimation();
                            }
                        });
                    }
                }, 1000*linea);

                posInicial=i;
                posInicial2=j;
                return moverPersonaje(matriz, posInicial, posInicial2, arrayDirecciones, linea+1);
            }

        }

        /**
         * DERECHA
         * verifica la posicion derecha y la imprime
         */
        if(arrayDirecciones[linea].equals("Derecha") ) {

            /**
             * para mover a la derecha se le suma uno a
             * la posicion columna
             * y la posicion fila se mantiene
             */
            final int g=posInicial;
            final int h=posInicial2;

            int i=posInicial;
            int j=posInicial2+1;

            if(j>=matriz[0].length ) {
                final Handler handlerr = new Handler();
                Timer t2 = new Timer();
                t2.schedule(new TimerTask() {
                    public void run() {

                        handlerr.post(new Runnable() {
                            public void run() {
                                casos_uso.mostrarVentana(mensaje02,tryAgain,2);

                                restaurar();

                            }
                        });
                    }
                }, 900*linea);

                /** Se lanza el siguiente  nivel*/

                final Handler handler = new Handler();
                Timer t3 = new Timer();
                t3.schedule(new TimerTask() {
                    public void run() {

                        handlerr.post(new Runnable() {
                            public void run() {

                                casos_uso.lanzarNivel3(user);

                            }
                        });
                    }
                }, 1200*linea);
                //al retornar 1 la recursividad se detiene
                return 1;
            }else {

                /**
                 * cambio de animacion segun la posicion en la matriz
                 */

                final Handler handlerr = new Handler();
                Timer t2 = new Timer();
                t2.schedule(new TimerTask() {
                    public void run() {
                        handlerr.post(new Runnable() {
                            public void run() {
                                String id=g+""+h;
                                int idInt = Integer.parseInt(id);
                                hero_Aux=findViewById(seleccionarPersonaje(idInt));
                                hero_Aux.setVisibility(GONE);
                                String id2=i+""+j;
                                int idInt2 = Integer.parseInt(id2);
                                hero_Aux02=findViewById(seleccionarPersonaje(idInt2));
                                hero_Aux02.setVisibility(View.VISIBLE);
                                hero_Aux02.playAnimation();
                            }
                        });
                    }
                }, 1000*linea);

                posInicial=i;
                posInicial2=j;
                return moverPersonaje(matriz, posInicial, posInicial2, arrayDirecciones, linea+1);
            }

        }



        if(moverPersonaje(matriz, posInicial, posInicial2, arrayDirecciones, linea+1)==1) {

            return 1;
        }

        return moverPersonaje(matriz, posInicial, posInicial2,  arrayDirecciones, linea+1);

    }


    public int seleccionarPersonaje(int posicion){
        int id= R.id.uno;
        switch (posicion){

            case 00: id= R.id.cero;
                break;
            case 01: id=R.id.uno;
                break;
            case 02: id= R.id.dos;
                break;
            case 03: id=R.id.tres;
                break;
            case 04: id=R.id.cuatro;
                break;
            case 05: id=R.id.cinco;
                break;

            case 10: id=R.id.seis;
                break;
            case 11: id= R.id.siete;
                break;
            case 12: id=R.id.ocho;
                break;
            case 13: id= R.id.nueve;
                break;
            case 14: id=R.id.diez;
                break;
            case 15: id=R.id.once;
                break;

            case 20: id=R.id.doce;
                break;
            case 21: id=R.id.trece;
                break;
            case 22: id= R.id.catorce;
                break;
            case 23: id=R.id.quince;
                break;
            case 24: id= R.id.diezseis;
                break;
            case 25: id=R.id.diezsiete;
                break;

            case 30: id=R.id.diezocho;
                break;
            case 31: id=R.id.dieznueve;
                break;
            case 32: id= R.id.veinte;
                break;
            case 33: id=R.id.veinteuno;
                break;
            case 34: id= R.id.veintedos;
                break;
            case 35: id=R.id.veintetres;
                break;

            case 40: id=R.id.veintecuatro;
                break;
            case 41: id=R.id.veintecinco;
                break;
            case 42: id=R.id.veinteseis;
                break;
            case 43: id=R.id.veintesiete;
                break;
            case 44: id=R.id.veinteocho;
                break;
            case 45: id=R.id.veintenueve;
                break;

            case 50: id=R.id.treinta;
                break;
            case 51: id=R.id.treintauno;
                break;
            case 52: id=R.id.treintados;
                break;
            case 53: id=R.id.treintatres;
                break;
            case 54: id=R.id.treintacuatro;
                break;
            case 55: id=R.id.treintacinco;
                break;


        }

        return id;

    }

    public void restaurar(){
        hero_00.setVisibility(GONE);
        hero_01.setVisibility(GONE);
        hero_02.setVisibility(GONE);
        hero_03.setVisibility(GONE);
        hero_04.setVisibility(GONE);
        hero_05.setVisibility(View.VISIBLE);
        //FILA(1)
        hero_10.setVisibility(GONE);
        hero_11.setVisibility(GONE);
        hero_12.setVisibility(GONE);
        hero_13.setVisibility(GONE);
        hero_14.setVisibility(GONE);
        hero_15.setVisibility(GONE);
        //FILA(2)
        hero_20.setVisibility(GONE);
        hero_21.setVisibility(GONE);
        hero_22.setVisibility(GONE);
        hero_23.setVisibility(GONE);
        hero_24.setVisibility(GONE);
        hero_25.setVisibility(GONE);
        //FILA(3)
        hero_30.setVisibility(GONE);
        hero_31.setVisibility(GONE);
        hero_32.setVisibility(GONE);
        hero_33.setVisibility(GONE);
        hero_34.setVisibility(GONE);
        hero_35.setVisibility(GONE);
        //FILA(4)
        hero_40.setVisibility(GONE);
        hero_41.setVisibility(GONE);
        hero_42.setVisibility(GONE);
        hero_43.setVisibility(GONE);
        hero_44.setVisibility(GONE);
        hero_45.setVisibility(GONE);
        //FILA(4)
        //hero_50.setVisibility(GONE);
        hero_51.setVisibility(GONE);
        hero_52.setVisibility(GONE);
        hero_53.setVisibility(GONE);
        hero_54.setVisibility(GONE);
        hero_55.setVisibility(GONE);
    }

    public void btn_left(View view){

        String cadena=sentencias.getText().toString();
        cadena+="Izquierda-";

        sentencias.setText(cadena);

    }

    public void btn_right(View view){
        String cadena=sentencias.getText().toString();
        cadena+="Derecha-";
        sentencias.setText(cadena);

    }

    public void btn_up(View view){

        String cadena=sentencias.getText().toString();
        cadena+="Arriba-";

        sentencias.setText(cadena);

    }

    public void btn_down(View view){
        String cadena=sentencias.getText().toString();
        cadena+="Abajo-";
        sentencias.setText(cadena);

    }

    /**Metodo encargado de limpiar los pasos
     * ingresados por el usuario */
    public void limpiarPasos(View view){
        sentencias.setText("");
    }

    /** Mensaje tutorial sobre el nivel*/
    public void mostrarTutorial2(View view){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_nv2,null);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }


    @Override
    public void onBackPressed(){

    }


    // SimpleTask simpleTask = new SimpleTask();
    //  simpleTask.execute();
    //mover1();
    // mover2();
}