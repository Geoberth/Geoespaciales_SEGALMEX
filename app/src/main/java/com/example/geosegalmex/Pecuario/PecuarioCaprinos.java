package com.example.geosegalmex.Pecuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.Pecuario.GlobalPecuario.GlobalPecuario;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

public class PecuarioCaprinos extends AppCompatActivity {

    //VARIABLES LOCALES PARA ALMACENAR LA INFORMACION
    private String TIPORAZACAPRINO = null;
    private String OTROTIPORAZACAPRINO = null;


    //Botones
    Button btnPecucaprinos;

    //Spinner
    Spinner razaCaprinopredomina;


    //TextView
    TextView txtCaprinorazapredominaotro;

    //EditText
    EditText edtCaprinorazapredominaotro;



    //BASE DE DATOS
    private DatabaseHelper baseBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pecuario_caprinos);

        //Botones
        btnPecucaprinos = (Button)findViewById(R.id.pecuario_next_caprino);

        //Spinner
        razaCaprinopredomina = (Spinner)findViewById(R.id.idSpincaprinorazapredomina);

        //TextView
        txtCaprinorazapredominaotro = (TextView)findViewById(R.id.txtCaprinorazapredominaotro);


        //EditText
        edtCaprinorazapredominaotro = (EditText)findViewById(R.id.edtCaprinorazapredominaotro);




        ////////////////////////////////////////////////////////////////////////////////////
        razaCaprinopredomina.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                switch (position) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        txtCaprinorazapredominaotro.setVisibility(View.GONE);
                        edtCaprinorazapredominaotro.setVisibility(View.GONE);

                        break;

                    case 8:
                        txtCaprinorazapredominaotro.setVisibility(View.VISIBLE);
                        edtCaprinorazapredominaotro.setVisibility(View.VISIBLE);

                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //BD
        baseBD         = new DatabaseHelper(this);




        btnPecucaprinos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean validaCaprino = validaExistecaprino();

                if(!validaCaprino){

                    GlobalPecuario.TIPORAZACAPRINO = TIPORAZACAPRINO;
                    GlobalPecuario.OTROTIPORAZACAPRINO = OTROTIPORAZACAPRINO;

                    agregarPecucaprinoupf(); // Agregar a la base de datos

                    Toast.makeText(getApplicationContext(), "Agregado correctamente ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(PecuarioCaprinos.this, EstructuraDelHato.class));
                    finish();
                }else{

                    Toast.makeText(getApplicationContext(), "Faltan datos de tipo de raza Caprino", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    //INSERCION DE DATOS
    public void agregarPecucaprinoupf(){



        addPecucaprino();

    }




    ///Agregar pecuario caprino

    private void addPecucaprino(){
        boolean insertarData = baseBD.addRazacaprinos();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }






    //Validar existencia de caprino
    public Boolean validaExistecaprino(){
        TIPORAZACAPRINO = razaCaprinopredomina.getSelectedItem().toString();

        if(TIPORAZACAPRINO.isEmpty()){
            return true;
        }else if(!TIPORAZACAPRINO.isEmpty()){

            OTROTIPORAZACAPRINO = edtCaprinorazapredominaotro.getText().toString();
            return false;
        }
        return false;

    }



    @Override
    public void onBackPressed() {

    }

}
