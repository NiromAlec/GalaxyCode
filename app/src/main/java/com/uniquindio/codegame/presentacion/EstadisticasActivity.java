package com.uniquindio.codegame.presentacion;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import static android.content.ContentValues.TAG;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.uniquindio.codegame.R;

import org.w3c.dom.Text;

public class EstadisticasActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    TextView numUsuarios;
    /** elementos UI de Estadisticas promedio por nivel*/
    TextView txv_nv1;
    TextView txv_nv2;
    TextView txv_nv3;
    TextView txv_nv4;
    TextView txv_nv5;
    /** elementos UI de Estadisticas  por nivel*/
    TextView txv_estad_nv1;
    TextView txv_estad_nv2;
    TextView txv_estad_nv3;
    TextView txv_estad_nv4;
    TextView txv_estad_nv5;
    TextView txv_estad_nv1_p;
    TextView txv_estad_nv2_p;
    TextView txv_estad_nv3_p;
    TextView txv_estad_nv4_p;
    TextView txv_estad_nv5_p;
    /** elementos UI de estadisticas de la encuesta*/
    TextView txv_p1_0;
    TextView txv_p2_0;
    TextView txv_p3_0;

    TextView txv_p1_1;
    TextView txv_p2_1;
    TextView txv_p3_1;

    TextView txv_p1_2;
    TextView txv_p2_2;
    TextView txv_p3_2;

    TextView txv_p1_3;
    TextView txv_p2_3;
    TextView txv_p3_3;

    TextView txv_p1_4;
    TextView txv_p2_4;
    TextView txv_p3_4;

    TextView txv_p1_5;
    TextView txv_p2_5;
    TextView txv_p3_5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        db = FirebaseFirestore.getInstance();
        numUsuarios=findViewById(R.id.numUsarios);

        txv_nv1=findViewById(R.id.resul_nv1_promedio);
        txv_nv2=findViewById(R.id.resul_nv2_promedio);
        txv_nv3=findViewById(R.id.resul_nv3_promedio);
        txv_nv4=findViewById(R.id.resul_nv4_promedio);
        txv_nv5=findViewById(R.id.resul_nv5_promedio);

        txv_estad_nv1=findViewById(R.id.resul_nv1xnivel);
        txv_estad_nv2=findViewById(R.id.resul_nv2xnivel);
        txv_estad_nv3=findViewById(R.id.resul_nv3xnivel);
        txv_estad_nv4=findViewById(R.id.resul_nv4xnivel);
        txv_estad_nv5=findViewById(R.id.resul_nv5xnivel);
        txv_estad_nv1_p=findViewById(R.id.resul_nv1xnivel_p);
        txv_estad_nv2_p=findViewById(R.id.resul_nv2xnivel_p);
        txv_estad_nv3_p=findViewById(R.id.resul_nv3xnivel_p);
        txv_estad_nv4_p=findViewById(R.id.resul_nv4xnivel_p);
        txv_estad_nv5_p=findViewById(R.id.resul_nv5xnivel_p);

        txv_p1_0=findViewById(R.id.txv_p1_0);
        txv_p2_0=findViewById(R.id.txv_p2_0);
        txv_p3_0=findViewById(R.id.txv_p3_0);

        txv_p1_1=findViewById(R.id.txv_p1_1);
        txv_p2_1=findViewById(R.id.txv_p2_1);
        txv_p3_1=findViewById(R.id.txv_p3_1);

        txv_p1_2=findViewById(R.id.txv_p1_2);
        txv_p2_2=findViewById(R.id.txv_p2_2);
        txv_p3_2=findViewById(R.id.txv_p3_2);

        txv_p1_3=findViewById(R.id.txv_p1_3);
        txv_p2_3=findViewById(R.id.txv_p2_3);
        txv_p3_3=findViewById(R.id.txv_p3_3);

        txv_p1_4=findViewById(R.id.txv_p1_4);
        txv_p2_4=findViewById(R.id.txv_p2_4);
        txv_p3_4=findViewById(R.id.txv_p3_4);

        txv_p1_5=findViewById(R.id.txv_p1_5);
        txv_p2_5=findViewById(R.id.txv_p2_5);
        txv_p3_5=findViewById(R.id.txv_p3_5);


        /** calcula el total de usuarios e
         * invoca los metodos que calculan
         * las demás estadisticas*/
        calcularTotalUsuarios();



    }

    private void calcularTotalUsuarios() {
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int numeroUsuarios=0;
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                numeroUsuarios++;

                            }
                            /** Numero de usuarios */
                            numUsuarios.setText(""+numeroUsuarios);

                            /** Invocaciones al metodo que hace una consulta a la base de datos
                             *  y trae la cantidad de veces que se ganó un nivel promedio de cada nivel
                             * */
                            calcularEstadisticasNivel(numeroUsuarios,"nv1",true,txv_nv1,"Nivel 1:","Ganaron");
                            calcularEstadisticasNivel(numeroUsuarios,"nv2",true,txv_nv2,"Nivel 2:","Ganaron");
                            calcularEstadisticasNivel(numeroUsuarios,"nv3",true,txv_nv3,"Nivel 3:","Ganaron");
                            calcularEstadisticasNivel(numeroUsuarios,"nv4",true,txv_nv4,"Nivel 4:","Ganaron");
                            calcularEstadisticasNivel(numeroUsuarios,"nv5",true,txv_nv5,"Nivel 5:","Ganaron");

                            /** Invocaciones al metodo que hace una consulta a la base de datos
                             *  y trae la cantidad de veces que se ganó y perdió un nivel
                             * */
                            calcularEstadisticasNivel(numeroUsuarios,"nv1",true,txv_estad_nv1,"Nivel 1:","Ganaron");
                            calcularEstadisticasNivel(numeroUsuarios,"nv1",false,txv_estad_nv1_p,"Nivel 1:","Perdieron");
                            calcularEstadisticasNivel(numeroUsuarios,"nv2",true,txv_estad_nv2,"Nivel 2:","Ganaron");
                            calcularEstadisticasNivel(numeroUsuarios,"nv2",false,txv_estad_nv2_p,"Nivel 2:","Perdieron");
                            calcularEstadisticasNivel(numeroUsuarios,"nv3",true,txv_estad_nv3,"Nivel 3:","Ganaron");
                            calcularEstadisticasNivel(numeroUsuarios,"nv3",false,txv_estad_nv3_p,"Nivel 3:","Perdieron");
                            calcularEstadisticasNivel(numeroUsuarios,"nv4",true,txv_estad_nv4,"Nivel 4:","Ganaron");
                            calcularEstadisticasNivel(numeroUsuarios,"nv4",false,txv_estad_nv4_p,"Nivel 4:","Perdieron");
                            calcularEstadisticasNivel(numeroUsuarios,"nv5",true,txv_estad_nv5,"Nivel 5:","Ganaron");
                            calcularEstadisticasNivel(numeroUsuarios,"nv5",false,txv_estad_nv5_p,"Nivel 5:","Perdieron");

                            /**
                             * Invocaciones al metodo que realiza un consulta a la base de datos para calcular
                             * promedio de cada respuesta de cada pregunta de la encuesta
                             */
                            calcularEstadisticasEncuesta(numeroUsuarios, "respuesta_01", 0,txv_p1_0);
                            calcularEstadisticasEncuesta(numeroUsuarios, "respuesta_02",0, txv_p2_0);
                            calcularEstadisticasEncuesta(numeroUsuarios, "respuesta_03",0, txv_p3_0);

                            calcularEstadisticasEncuesta(numeroUsuarios, "respuesta_01",1, txv_p1_1);
                            calcularEstadisticasEncuesta(numeroUsuarios, "respuesta_02",1, txv_p2_1);
                            calcularEstadisticasEncuesta(numeroUsuarios, "respuesta_03", 1,txv_p3_1);

                            calcularEstadisticasEncuesta(numeroUsuarios, "respuesta_01",2, txv_p1_2);
                            calcularEstadisticasEncuesta(numeroUsuarios, "respuesta_02",2, txv_p2_2);
                            calcularEstadisticasEncuesta(numeroUsuarios, "respuesta_03", 2,txv_p3_2);

                            calcularEstadisticasEncuesta(numeroUsuarios, "respuesta_01",3, txv_p1_3);
                            calcularEstadisticasEncuesta(numeroUsuarios, "respuesta_02",3, txv_p2_3);
                            calcularEstadisticasEncuesta(numeroUsuarios, "respuesta_03", 3,txv_p3_3);

                            calcularEstadisticasEncuesta(numeroUsuarios, "respuesta_01",4, txv_p1_4);
                            calcularEstadisticasEncuesta(numeroUsuarios, "respuesta_02",4, txv_p2_4);
                            calcularEstadisticasEncuesta(numeroUsuarios, "respuesta_03", 4,txv_p3_4);

                            calcularEstadisticasEncuesta(numeroUsuarios, "respuesta_01",5, txv_p1_5);
                            calcularEstadisticasEncuesta(numeroUsuarios, "respuesta_02",5, txv_p2_5);
                            calcularEstadisticasEncuesta(numeroUsuarios, "respuesta_03", 5,txv_p3_5);

                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });

    }


    /**
     * Metodo que realiza una consulta a la base de datos y
     * muestra los datos en los textview correspondientes
     * @param numeroUsuarios
     * @param nv
     * @param estado
     * @param txv
     * @param label
     * @param label2
     */
    public void calcularEstadisticasNivel(int numeroUsuarios, String nv, boolean estado, TextView txv, String label, String label2){

        db.collection("users")
                .whereEqualTo(nv, estado)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int numeroGanadores=0;
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                numeroGanadores++;

                            }
                            txv.setText(label+"       "+numeroGanadores+" / "+numeroUsuarios+"  "+label2);


                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

    /**
     * Realiza una consulta a la bases de datos y
     * muestra los datos en los textview correspondientes
     * @param numeroUsuarios
     * @param respuesta
     * @param txv
     */
    public void calcularEstadisticasEncuesta(int numeroUsuarios, String respuesta,int escala, TextView txv){

        db.collection("encuestas")
                .whereEqualTo(respuesta, escala)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int numero=0;
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                numero++;

                            }
                            txv.setText(numero+"/"+numeroUsuarios);


                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
    }




//896523

}