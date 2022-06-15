package com.uniquindio.codegame.presentacion;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.uniquindio.codegame.R;
import com.uniquindio.codegame.casosuso.Casos_Uso;
import com.uniquindio.codegame.modelo.Encuesta;
import com.uniquindio.codegame.modelo.Usuario;

import java.util.Timer;
import java.util.TimerTask;

public class EncuestaActivity extends AppCompatActivity {

    Encuesta encuesta;
    Usuario user;
    private Casos_Uso casos_uso;
    private ProgressBar cargando;
    private FirebaseFirestore db;
    /** RadioButtons correspondientes a la pregunta 1 */
    RadioButton pregunta_01_R_0;
    RadioButton pregunta_01_R_1;
    RadioButton pregunta_01_R_2;
    RadioButton pregunta_01_R_3;
    RadioButton pregunta_01_R_4;
    RadioButton pregunta_01_R_5;
    /** RadioButtons correspondientes a la pregunta 2 */
    RadioButton pregunta_02_R_0;
    RadioButton pregunta_02_R_1;
    RadioButton pregunta_02_R_2;
    RadioButton pregunta_02_R_3;
    RadioButton pregunta_02_R_4;
    RadioButton pregunta_02_R_5;
    /** RadioButtons correspondientes a la pregunta 3 */
    RadioButton pregunta_03_R_0;
    RadioButton pregunta_03_R_1;
    RadioButton pregunta_03_R_2;
    RadioButton pregunta_03_R_3;
    RadioButton pregunta_03_R_4;
    RadioButton pregunta_03_R_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        casos_uso=new Casos_Uso(this);
        cargando= findViewById(R.id.cargando_encuesta);
        db = FirebaseFirestore.getInstance();
        Bundle objetoUser=getIntent().getExtras();
        user=null;
        if(objetoUser!=null){
            user=(Usuario) objetoUser.getSerializable("user");

        }

        pregunta_01_R_0=findViewById(R.id.pregunta_01_R_0);
        pregunta_01_R_1=findViewById(R.id.pregunta_01_R_1);
        pregunta_01_R_2=findViewById(R.id.pregunta_01_R_2);
        pregunta_01_R_3=findViewById(R.id.pregunta_01_R_3);
        pregunta_01_R_4=findViewById(R.id.pregunta_01_R_4);
        pregunta_01_R_5=findViewById(R.id.pregunta_01_R_5);

        pregunta_02_R_0=findViewById(R.id.pregunta_02_R_0);
        pregunta_02_R_1=findViewById(R.id.pregunta_02_R_1);
        pregunta_02_R_2=findViewById(R.id.pregunta_02_R_2);
        pregunta_02_R_3=findViewById(R.id.pregunta_02_R_3);
        pregunta_02_R_4=findViewById(R.id.pregunta_02_R_4);
        pregunta_02_R_5=findViewById(R.id.pregunta_02_R_5);

        pregunta_03_R_0=findViewById(R.id.pregunta_03_R_0);
        pregunta_03_R_1=findViewById(R.id.pregunta_03_R_1);
        pregunta_03_R_2=findViewById(R.id.pregunta_03_R_2);
        pregunta_03_R_3=findViewById(R.id.pregunta_03_R_3);
        pregunta_03_R_4=findViewById(R.id.pregunta_03_R_4);
        pregunta_03_R_5=findViewById(R.id.pregunta_03_R_5);




    }

    public void enviarDatos(View view){

        cargando.setVisibility(View.VISIBLE);




        /** se crea una encuenta y se llena segun los
         *  datos ingresados por el usuario
         **/
        encuesta=new Encuesta();
        encuesta.setNombreUser(user.getNombre());

        /**
         * seccion pregunta 1
         */

        if(pregunta_01_R_0.isChecked()){
            encuesta.setRespuesta_01(0);
        }else if(pregunta_01_R_1.isChecked()){
            encuesta.setRespuesta_01(1);
        }else if(pregunta_01_R_2.isChecked()){
            encuesta.setRespuesta_01(2);
        }else if(pregunta_01_R_3.isChecked()){
            encuesta.setRespuesta_01(3);
        }else if(pregunta_01_R_4.isChecked()){
            encuesta.setRespuesta_01(4);
        }else if(pregunta_01_R_5.isChecked()){
            encuesta.setRespuesta_01(5);
        }else{
            /** se envia un datos por si no se ingresa uno*/
            encuesta.setRespuesta_01(3);
        }


        /**
         * seccion pregunta 2
         */
        if(pregunta_02_R_0.isChecked()){
            encuesta.setRespuesta_02(0);
        }else if(pregunta_02_R_1.isChecked()){
            encuesta.setRespuesta_02(1);
        }else if(pregunta_02_R_2.isChecked()){
            encuesta.setRespuesta_02(2);
        }else if(pregunta_02_R_3.isChecked()){
            encuesta.setRespuesta_02(3);
        }else if(pregunta_02_R_4.isChecked()){
            encuesta.setRespuesta_02(4);
        }else if(pregunta_02_R_5.isChecked()){
            encuesta.setRespuesta_02(5);
        }else{
            /** se envia un datos por si no se ingresa uno*/
            encuesta.setRespuesta_02(3);
        }

        /**
         * seccion pregunnta 3
         */
        if(pregunta_03_R_0.isChecked()){
            encuesta.setRespuesta_03(0);
        }else if(pregunta_03_R_1.isChecked()){
            encuesta.setRespuesta_03(1);
        }else if(pregunta_03_R_2.isChecked()){
            encuesta.setRespuesta_03(2);
        }else if(pregunta_03_R_3.isChecked()){
            encuesta.setRespuesta_03(3);
        }else if(pregunta_03_R_4.isChecked()){
            encuesta.setRespuesta_03(4);
        }else if(pregunta_03_R_5.isChecked()){
            encuesta.setRespuesta_03(5);
        }else{
            /** se envia un datos por si no se ingresa uno*/
            encuesta.setRespuesta_03(3);
        }
        /** Se sube la encuesta a la base de datos*/

        final Handler handler = new Handler();
        Timer t3 = new Timer();
        t3.schedule(new TimerTask() {
            public void run() {

                handler.post(new Runnable() {
                    public void run() {

                        db.collection("encuestas").document(user.getNombre()).set(encuesta).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully written!");
                                cargando.setVisibility(View.GONE);
                                Toast.makeText(EncuestaActivity.this, "Encuesta enviada con exito!", Toast.LENGTH_SHORT).show();
                                casos_uso.lanzarMain();



                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                                cargando.setVisibility(View.GONE);
                                Toast.makeText(EncuestaActivity.this, "No se pudo enviar la encuesta", Toast.LENGTH_SHORT).show();

                            }
                        });

                    }
                });
            }
        }, 2000);


    }
}