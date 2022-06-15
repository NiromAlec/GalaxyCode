package com.uniquindio.codegame.presentacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.uniquindio.codegame.R;

public class ventana_info extends AppCompatActivity {

    LottieAnimationView animation;
    TextView mensaje_txv;
    TextView tryAgain_txv;
    public static int color = R.color.Icono02;
    public static int colorWinner =R.color.yellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_info2);

        mensaje_txv=findViewById(R.id.mensaje);
        tryAgain_txv=findViewById(R.id.tryAgain);

        /**
         * Se recibe y guarda los datos enviados de la anterior actividad
         * para ser usuados
         */
        Bundle extras = getIntent().getExtras();

        String mensaje= extras.getString("mensaje");
        String tryAgain= extras.getString("try");
        int cod = extras.getInt("codigo");

        mensaje_txv.setText(mensaje);
        tryAgain_txv.setText(tryAgain);

        /** serie de condicionales que segun el codigo que fue recibido
         *  se establece una animacion personalizada segun el contexto */
        /**falta camino*/
        if(cod==1){
            animation= findViewById(R.id.cry_animation);
            animation.setVisibility(View.VISIBLE);
            animation.playAnimation();
        }
        /**Fuera de limite*/
        if(cod==2){
            mensaje_txv.setTextColor(getResources().getColor(color));
            animation= findViewById(R.id.error_animation);
            animation.setVisibility(View.VISIBLE);
            animation.playAnimation();
        }
        /**Ganador */
        if(cod==3){
            mensaje_txv.setTextColor(getResources().getColor(colorWinner));
            animation= findViewById(R.id.winnerastro_animation);
            animation.setVisibility(View.VISIBLE);
            animation.playAnimation();

        }
        /**Lava*/
        if(cod==4){
            mensaje_txv.setTextColor(getResources().getColor(colorWinner));
            animation= findViewById(R.id.cry_animation);
            animation.setVisibility(View.VISIBLE);
            animation.playAnimation();
        }



    }
}