package com.uniquindio.codegame.presentacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.uniquindio.codegame.R;
import com.uniquindio.codegame.casosuso.Casos_Uso;

public class MainActivity extends AppCompatActivity {

    public static int zoomIn = R.anim.zoom_in;
    public static int zoomOut = R.anim.zoom_out;
    LottieAnimationView hero;
    private Casos_Uso casos_uso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_CodeGame);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        casos_uso=new Casos_Uso(this);
        hero=findViewById(R.id.hero);
        hero.playAnimation();



    }

    public void iniciar(View view){

       casos_uso.lanzarInicio();


    }

    public void menu(View view){

        casos_uso.lanzarMenu();



    }
}