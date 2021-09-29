package com.example.geosegalmex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Segunda extends AppCompatActivity {

    Button btProductor, btCuest, btUpf;

    TextView textUsu;


    //Global objLectura;

    //Principal seg = new Principal();
    String usar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);


        //btProductor = (Button) findViewById(R.id.btnAgproductor);
        btCuest = (Button) findViewById(R.id.btnCuestionario);

        //objLectura = (Global)getApplicationContext();
        //textUsu = (TextView)findViewById(R.id.txtUsu);


        //obtenerUsu();
        /*
        btProductor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Segunda.this, ProductorInfo.class));
            }
        });
        */

        btCuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Segunda.this, IdentificacionCuestionario.class));
            }
        });

    }



/*

    public void obtenerUsu(){

        BasedeDatos bd = new BasedeDatos(this, "cuestionario.db", null, 1);
        SQLiteDatabase db = bd.getReadableDatabase();



        Log.i("Segunda clase ", "obtener segunda.class: "+ objLectura.getUsuario());

        //Cursor c = db.rawQuery("SELECT * FROM usuarios WHERE USUARIO = "+objLectura.getUsuario()+ " AND CONTRASENA = " + objLectura.getContrasena(), null);

        Cursor c = db.rawQuery("SELECT NOMBRECAP FROM usuarios WHERE USUARIO = 'siap121' AND CONTRASENA = 'siscam01' " , null);
        Log.i("Recibido ", "obtenerUsu: "+c.getCount());

        if (c != null){
            c.moveToFirst();
            do{
                //Asignar el valor a la variable
                usar = c.getString(c.getColumnIndex("NOMBRECAP"));
            }while(c.moveToNext());
        }
        c.close();
        db.close();

        textUsu.setText("Bienvenido "+usar);

    }

 */

}
