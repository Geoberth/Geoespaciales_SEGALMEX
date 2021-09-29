package com.example.geosegalmex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.geosegalmex.drawer.DrawerActivity;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

public class Principal extends AppCompatActivity {
   // BasedeDatos bd = new BasedeDatos(this, "cuestionario.db", null, 1);

    public static int checkUser;
    public static String userId = null;
    EditText edtusuario, edtcontrasena;
    Button btnIngresar;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        edtusuario = (EditText) findViewById(R.id.txtUsuario);
        edtcontrasena = (EditText) findViewById(R.id.txtContrasena);
        btnIngresar = (Button)findViewById(R.id.btnIngresar);

        db                  = new DatabaseHelper(getBaseContext());

        /*
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DrawerActivity.class);
                startActivity(i);
            }
        });


         */

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Principal.this, DrawerActivity.class));
//                consultaUsuarios(usuario, pass);
            /*
                if(usuario.equals("siap2019") && pass.equals("siap2019")){
                    startActivity(new Intent(Principal.this, DrawerActivity.class));
                }
                else{
                    Toast.makeText(getApplicationContext(),"Usuario Incorrecto", Toast.LENGTH_SHORT).show();
                }


             */
            }
        });

        /*

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Cursor cursor = bd.ConsultarUsuPas(edtusuario.getText().toString(), edtcontrasena.getText().toString());

                    if(cursor.getCount()>0){
                        Intent i = new Intent(getApplicationContext(), DrawerActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(getApplicationContext(), "Usuario y/o contraseña Incorrectos", Toast.LENGTH_LONG).show();
                    }

                    cursor.close();
                    bd.close();


                }catch (SQLException e){
                    e.printStackTrace();
                }


            }
        });

         */
    }

    private void verificaUsuario(String usuario, String pass) {
        if(usuario.equals("siap2019") && pass.equals("siap2019")){
            checkUser = 1;
            startActivity(new Intent(Principal.this, DrawerActivity.class));
        } else if (usuario != "siap2019" && pass != "siap2019"){
            consultaUsuarios(usuario, pass);
            //Toast.makeText(getApplicationContext(),"Usuario Incorrecto", Toast.LENGTH_SHORT).show();
        }
    }

    private void consultaUsuarios(String usuario, String pass) {
        //boolean insertarData = db.getUser(usuario, pass);
        String insertarData = db.getUser(usuario, pass);
        //if(insertarData == true) {
        if(usuario.equals("siap") && pass.equals("123")){
          /*  Log.e("=====>", insertarData);
            userId = insertarData;
            */
            checkUser = 2;
            Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Principal.this, DrawerActivity.class));
        }else{
            Toast.makeText(this, "Verifique su usuario y/o contraseña", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {

    }
}
