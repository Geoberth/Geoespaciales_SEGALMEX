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

public class PecuarioOvinos extends AppCompatActivity {

    private String TIPORAZAOVINO = null;
    private String OTROTIPORAZAOVINO = null;

    //Spinner
    Spinner razaPredominaOvino;

    //TextView
    TextView txtOvinorazapredominaotro;

    //EditText
    EditText edtOvinorazapredominaotro;


    //Botones
    Button btnPecuovinos;

    //BASE DE DATOS
    private DatabaseHelper baseBD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pecuario_ovinos);

        //Spinner
        razaPredominaOvino = (Spinner)findViewById(R.id.idSpinovinorazapredomina);

        //TextView
        txtOvinorazapredominaotro = (TextView)findViewById(R.id.txtOvinorazapredominaotro);

        //EditText
        edtOvinorazapredominaotro = (EditText)findViewById(R.id.edtOvinorazapredominaotro);

        //Boton
        btnPecuovinos = (Button)findViewById(R.id.pecuario_next_ovinos);



        ////////////////////////////////////////////////////////////////////////////////////
        razaPredominaOvino.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        txtOvinorazapredominaotro.setVisibility(View.GONE);
                        edtOvinorazapredominaotro.setVisibility(View.GONE);

                        break;

                    case 12:
                        txtOvinorazapredominaotro.setVisibility(View.VISIBLE);
                        edtOvinorazapredominaotro.setVisibility(View.VISIBLE);

                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        //BD
        baseBD         = new DatabaseHelper(this);



        btnPecuovinos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean validaOvino = validaExisteovino();

                if(!validaOvino){

                    GlobalPecuario.TIPORAZAOVINO = TIPORAZAOVINO;
                    GlobalPecuario.OTROTIPORAZAOVINO = OTROTIPORAZAOVINO;



                    agregarPecubovinoupf(); // Agregar a la base de datos



                    Toast.makeText(getApplicationContext(), "Agregado correctamente ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(PecuarioOvinos.this, PecuarioCaprinos.class));
                    finish();
                }else{

                    Toast.makeText(getApplicationContext(), "Faltan datos de tipo de raza Ovino", Toast.LENGTH_SHORT).show();
                }





            }
        });
    }



    //INSERCION DE DATOS
    public void agregarPecubovinoupf(){



        addPecuovino();

    }




    ///Agregar pecuario ovino

    private void addPecuovino(){
        boolean insertarData = baseBD.addRazaovinos();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }





    public Boolean validaExisteovino(){
        TIPORAZAOVINO = razaPredominaOvino.getSelectedItem().toString();

        if(TIPORAZAOVINO.isEmpty()){
            return true;
        }else if(!TIPORAZAOVINO.isEmpty()){

            OTROTIPORAZAOVINO = edtOvinorazapredominaotro.getText().toString();
            return false;
        }
        return false;

    }



    @Override
    public void onBackPressed() {

    }

}
