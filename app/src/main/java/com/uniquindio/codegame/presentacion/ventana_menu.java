package com.uniquindio.codegame.presentacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.uniquindio.codegame.R;
import com.uniquindio.codegame.casosuso.Casos_Uso;
import com.uniquindio.codegame.presentacion.JugadoresActivity;

public class ventana_menu extends AppCompatActivity {

    LottieAnimationView monsterA;
    public static int zoomIn = R.anim.zoom_in;
    public static int zoomOut = R.anim.zoom_out;
    private Casos_Uso casos_uso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_menu);
        casos_uso=new Casos_Uso(this);

        monsterA=findViewById(R.id.monsterMenu);
        monsterA.playAnimation();
    }

    public void mostrarjugadores(View view){

        casos_uso.mostrarjugadores();


    }

    public void mostrarEstadisticas(View view){

      casos_uso.mostrarEstadisticas();


    }

    public void volver (View view){
        finish();

    }
}