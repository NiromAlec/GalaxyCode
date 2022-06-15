package com.uniquindio.codegame.presentacion;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.uniquindio.codegame.R;
import com.uniquindio.codegame.casosuso.Casos_Uso;
import com.uniquindio.codegame.modelo.Nivel;
import com.uniquindio.codegame.modelo.Usuario;

import java.util.Timer;
import java.util.TimerTask;

public class RegistroActivity extends AppCompatActivity {

    private ProgressBar cargando;
    LottieAnimationView astro;
    LottieAnimationView wifi;
    LottieAnimationView nowifi;
    TextInputEditText nombre;
    Animation animation;
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private Usuario usuario;
    private Casos_Uso casos_uso;
    public static int zoomIn = R.anim.zoom_in;

    Nivel nivel=null;
    Nivel nivel2=null;
    Nivel nivel3=null;
    Nivel nivel4=null;
    Nivel nivel5=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        mAuth= FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        casos_uso=new Casos_Uso(this);
        cargando= findViewById(R.id.cargando);
        astro=findViewById(R.id.astro);
        wifi=findViewById(R.id.wifi);
        nowifi=findViewById(R.id.nowifi);
        astro.playAnimation();
        nombre=findViewById(R.id.nombre);
        animation = AnimationUtils.loadAnimation(this,R.anim.zoom_in);





    }

    public void jugar(View view){
        cargando.setVisibility(View.VISIBLE);
        revisarConexion();
        if(nombre.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingresa tu nombre", Toast.LENGTH_SHORT).show();
        }else {

            usuario= new Usuario(nombre.getText().toString(),false, false,false,false,false,0);
            db.collection("users").document(nombre.getText().toString()).set(usuario).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Log.d(TAG, "DocumentSnapshot successfully written!");
                    casos_uso.lanzarNivel1(usuario);


                }
            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error writing document", e);
                            cargando.setVisibility(View.GONE);

                            mensaje();
                        }
                    });


        }

    }

    public void mensaje(){
        Toast.makeText(this, "NO hay conexion", Toast.LENGTH_SHORT).show();
    }

    public void revisarConexion(){
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if(isConnected){
            wifi.startAnimation(animation);
            wifi.setVisibility(View.VISIBLE);
            wifi.playAnimation();
            final Handler handlerr = new Handler();
            Timer t2 = new Timer();
            t2.schedule(new TimerTask() {
                public void run() {

                    handlerr.post(new Runnable() {
                        public void run() {


                            wifi.setVisibility(View.GONE);
                            wifi.pauseAnimation();



                        }
                    });
                }
            }, 5000);
        }else{

            nowifi.setVisibility(View.VISIBLE);
            nowifi.startAnimation(animation);
            nowifi.playAnimation();


            final Handler handlerr = new Handler();
            Timer t2 = new Timer();
            t2.schedule(new TimerTask() {
                public void run() {

                    handlerr.post(new Runnable() {
                        public void run() {


                            nowifi.setVisibility(View.GONE);
                            nowifi.pauseAnimation();



                        }
                    });
                }
            }, 6000);

        }
    }


}