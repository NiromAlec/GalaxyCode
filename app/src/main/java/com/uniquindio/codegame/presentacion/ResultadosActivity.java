package com.uniquindio.codegame.presentacion;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.uniquindio.codegame.R;
import com.uniquindio.codegame.casosuso.Casos_Uso;
import com.uniquindio.codegame.modelo.Nivel;
import com.uniquindio.codegame.modelo.Usuario;

import java.util.Timer;
import java.util.TimerTask;

public class ResultadosActivity extends AppCompatActivity {

    Usuario user;
    TextView nombre;
    TextView nv_1;
    TextView nv_2;
    TextView nv_3;
    TextView nv_4;
    TextView nv_5;
    TextView total;
    Button button;
    private ProgressBar cargando;
    LinearLayout linearLayout;

    private FirebaseFirestore db;
    private Casos_Uso casos_uso;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        db = FirebaseFirestore.getInstance();
        casos_uso=new Casos_Uso(this);
        button=findViewById(R.id.btn_responder);

        Bundle objetoUser=getIntent().getExtras();
        user=null;
        if(objetoUser!=null){
            user=(Usuario) objetoUser.getSerializable("user");

        }



        cargando= findViewById(R.id.cargandoResul);
        linearLayout=findViewById(R.id.layoutResultado);
        nombre=findViewById(R.id.txv_nombreUser);
        nombre.setText(user.getNombre());
        nv_1=findViewById(R.id.resul_nv1);
        nv_2=findViewById(R.id.resul_nv2);
        nv_3=findViewById(R.id.resul_nv3);
        nv_4=findViewById(R.id.resul_nv4);
        nv_5=findViewById(R.id.resul_nv5);
        total=findViewById(R.id.total);


        /** se actualiza en la bases de datos el usuario */
        db.collection("users").document(user.getNombre()).set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "DocumentSnapshot successfully written!");

                final Handler handlerr = new Handler();
                Timer t2 = new Timer();
                t2.schedule(new TimerTask() {
                    public void run() {

                        handlerr.post(new Runnable() {
                            public void run() {

                                mostrarResultados();

                            }
                        });
                    }
                }, 3000);



            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error writing document", e);
                cargando.setVisibility(View.GONE);

            }
        });


    }


    public void mostrarResultados(){
        cargando.setVisibility(View.GONE);
        linearLayout.setVisibility(View.VISIBLE);
        button.setVisibility(View.VISIBLE);

        /** Se estable que niveles se gano y cuales no*/

        /** NIVEL 1*/
        if(user.isNv1()){
            nv_1.setText("Nivel 1:   Ganado!");


        }else{
            nv_1.setText("Nivel 1:   Perdido");
        }

        /** NIVEL 2*/
        if(user.isNv2()){
            nv_2.setText("Nivel 2:   Ganado!");


        }else{
            nv_2.setText("Nivel 2:   Perdido");
        }

        /** NIVEL 3*/
        if(user.isNv3()){
            nv_3.setText("Nivel 3:   Ganado!");


        }else{
            nv_3.setText("Nivel 3:   Perdido");
        }

        /** NIVEL 4*/
        if(user.isNv4()){
            nv_4.setText("Nivel 4:   Ganado!");


        }else{
            nv_4.setText("Nivel 4:   Perdido");
        }

        /** NIVEL 5*/
        if(user.isNv5()){
            nv_5.setText("Nivel 5:   Ganado!");


        }else{
            nv_5.setText("Nivel 5:   Perdido");
        }

        total.setText("Total:   "+user.getPuntaje()+" / 5");


    }

    public void lanzarEncuesta(View view){
        casos_uso.lanzarEncuesta(user);
    }



    @Override
    public void onBackPressed(){
        //casos_uso.lanzarMain();
    }

    public void volverMain(View view){
        casos_uso.lanzarMain();
    }
}