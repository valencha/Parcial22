package icesi.dmi.com.parcial2;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db;
    Button btn1,btn2, btn3, btn4,btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3= findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);


        db= FirebaseDatabase.getInstance();



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //crear Ramas para base de datos
                db.getReference().child("calificaciones").child("pelicula1").push().setValue("1");
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //crear Ramas para base de datos
                db.getReference().child("calificaciones").child("pelicula1").push().setValue("2");
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //crear Ramas para base de datos
                db.getReference().child("calificaciones").child("pelicula1").push().setValue("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //crear Ramas para base de datos
                db.getReference().child("calificaciones").child("pelicula1").push().setValue("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //crear Ramas para base de datos
                db.getReference().child("calificaciones").child("pelicula1").push().setValue("5");
            }
        });





        db.getReference().child("calificaciones").child("pelicula1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                //Devuelve el número de calificaciones
                String cantidad= "Calificacion promedio ("+dataSnapshot.getChildrenCount()+")";


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        db.getReference().child("calificaciones").child("pelicula1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                float a;
                float b;
                a=0;
                b=0;
                float sumatoria;
                sumatoria=0;

                float total = (float) dataSnapshot.getChildrenCount();
                //Devuelve el número de calificaciones


                TextView tv_promedio = findViewById(R.id.tv_promedio1);


                for (DataSnapshot dato: dataSnapshot.getChildren()){




                    String calificacion= dato.getValue(String.class);
                    int cali = Integer.parseInt(calificacion);



                    if( calificacion.equals("1")){
                        a= cali;
                    }
                    if( calificacion.equals("2")){
                        b=cali ;
                    }
                    sumatoria = a+b;

                }

                float promedio= sumatoria/total;

                String cal = Float.toString(promedio);


                tv_promedio.setText(cal);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }
}
