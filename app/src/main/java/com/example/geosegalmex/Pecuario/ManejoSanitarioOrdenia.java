package com.example.geosegalmex.Pecuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.IdentificacionCuestionario;
import com.example.geosegalmex.Pecuario.GlobalPecuario.GlobalPecuario;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

public class ManejoSanitarioOrdenia extends AppCompatActivity {

    //Pecuario Manejo sanitario ordeña
    private String MANEJOSANDIAMAS = null;
    private String MANEJOSANEDTMAS = null;
    private String MANEJOSANCOSTPR = null;

    private String MANEJOSANLAVUBR = null;
    private String MANEJOSANSECDES = null;
    private String MANEJOSANDESPUN = null;
    private String MANEJOSANUSOSEL = null;
    private String MANEJOSANAPLANT = null;
    private String MANEJOSANOTRORD = null;
    private String MANEJOSANEDTOOR = null;
    private String MANEJOSANNINORD = null;
    private String MANEJOSANCOSTOR = null;



    //EditText
    EditText edtPecuariosanitarioordeniaotro;
    EditText edtPecuariosanitarioordeniacosto;
    EditText edtPecuariosanitarioordeniaotrohig;
    EditText edtPecuariosanitarioordeniacostohig;

    //Boton
    Button btnPecusanordenia;


    //BASE DE DATOS
    private DatabaseHelper baseBD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manejo_sanitario_ordenia);

        //EditText
        edtPecuariosanitarioordeniaotro = (EditText)findViewById(R.id.edtPecuariosanitarioordeniaotro);
        edtPecuariosanitarioordeniacosto = (EditText)findViewById(R.id.edtPecuariosanitarioordeniacosto);
        edtPecuariosanitarioordeniaotrohig = (EditText)findViewById(R.id.edtPecuariosanitarioordeniaotrohig);
        edtPecuariosanitarioordeniacostohig = (EditText)findViewById(R.id.edtPecuariosanitarioordeniacostohig);

        //Boton
        btnPecusanordenia = (Button)findViewById(R.id.pecuario_next_sanitario_ordenia);


        //BD
        baseBD         = new DatabaseHelper(this);


        btnPecusanordenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                GlobalPecuario.MANEJOSANDIAMAS = MANEJOSANDIAMAS;
                obtenerValorotromastitis();
                GlobalPecuario.MANEJOSANEDTMAS = MANEJOSANEDTMAS;
                GlobalPecuario.MANEJOSANCOSTPR = MANEJOSANCOSTPR;


                GlobalPecuario.MANEJOSANLAVUBR = MANEJOSANLAVUBR;
                GlobalPecuario.MANEJOSANSECDES = MANEJOSANSECDES;
                GlobalPecuario.MANEJOSANDESPUN = MANEJOSANDESPUN;
                GlobalPecuario.MANEJOSANUSOSEL = MANEJOSANUSOSEL;
                GlobalPecuario.MANEJOSANAPLANT = MANEJOSANAPLANT;
                GlobalPecuario.MANEJOSANOTRORD = MANEJOSANOTRORD;
                obtenerValorpracthigiene();
                GlobalPecuario.MANEJOSANEDTOOR = MANEJOSANEDTOOR;
                GlobalPecuario.MANEJOSANNINORD = MANEJOSANNINORD;
                GlobalPecuario.MANEJOSANCOSTOR = MANEJOSANCOSTOR;


                agregaManejosanordenia();
                Toast.makeText(getApplicationContext(), "Agregado correctamente ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ManejoSanitarioOrdenia.this, IdentificacionCuestionario.class));
                finish();
            }
        });
    }



    //INSERCION DE DATOS
    public void agregaManejosanordenia(){

        addManejosanordenia();

    }




    ///Agregar manejo de agostadero

    private void addManejosanordenia(){
        boolean insertarData = baseBD.addPecumanejordenia();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }



    //Metodo DIAGNOSTICO DE MASTITIS
    public void clickdiagnostmastitis(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioPecuariosanitarioordeniapruecal:
                if (checked) {
                    edtPecuariosanitarioordeniaotro.setVisibility(View.GONE);
                    MANEJOSANDIAMAS = "Prueba de California";

                }

                break;


            case R.id.radioPecuariosanitarioordeniapruefondnegro:
                if (checked) {
                    edtPecuariosanitarioordeniaotro.setVisibility(View.GONE);
                    MANEJOSANDIAMAS = "Prueba de fondo negro";

                }

                break;



            case R.id.radioPecuariosanitarioordeniaotro:
                if (checked) {
                    edtPecuariosanitarioordeniaotro.setVisibility(View.VISIBLE);
                    MANEJOSANDIAMAS = "Otro(especificar)";

                }

                break;




            case R.id.radioPecuariosanitarioordenianinguna:
                if (checked) {
                    edtPecuariosanitarioordeniaotro.setVisibility(View.GONE);
                    MANEJOSANDIAMAS = "Ninguna";

                }

                break;


        }

    }



    public void obtenerValorotromastitis(){


        if(!edtPecuariosanitarioordeniaotro.getText().toString().isEmpty()){
            MANEJOSANEDTMAS = edtPecuariosanitarioordeniaotro.getText().toString();
        } else{
            MANEJOSANEDTMAS = null;
        }

        if(!edtPecuariosanitarioordeniacosto.getText().toString().isEmpty()){
            MANEJOSANCOSTPR = edtPecuariosanitarioordeniacosto.getText().toString();
        } else{
            MANEJOSANCOSTPR = null;
        }
    }






    //Metodo practicas de higiene durante la ordeña
    public void clickpracthigieneordenia(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkPecuariosanitarioordenialavubre:
                if (checked) {

                    MANEJOSANLAVUBR = "Lavado de ubre y pezones";

                }else{
                    MANEJOSANLAVUBR = null;
                }

                break;


            case R.id.checkPecuariosanitarioordeniasecmatdes:
                if (checked) {

                    MANEJOSANSECDES = "Secado con material desechable individual";

                }else{
                    MANEJOSANSECDES = null;
                }

                break;



            case R.id.checkPecuariosanitarioordeniadespunte:
                if (checked) {

                    MANEJOSANDESPUN = "Despunte";

                }else{
                    MANEJOSANDESPUN = null;
                }

                break;




            case R.id.checkPecuariosanitarioordeniausosella:
                if (checked) {

                    MANEJOSANUSOSEL = "Uso de selladores";

                }else{
                    MANEJOSANUSOSEL = null;
                }

                break;




            case R.id.checkPecuariosanitarioordeniaaplicacantibio:
                if (checked) {

                    MANEJOSANAPLANT = "Aplicación de antibiótico intramamario al momento del secado";

                }else{
                    MANEJOSANAPLANT = null;
                }

                break;




            case R.id.checkPecuariosanitarioordeniaotrohig:
                if (checked) {

                    edtPecuariosanitarioordeniaotrohig.setVisibility(View.VISIBLE);
                    MANEJOSANOTRORD = "Otro (especificar)";

                }else{
                    edtPecuariosanitarioordeniaotrohig.setVisibility(View.GONE);
                    MANEJOSANOTRORD = null;
                }

                break;




            case R.id.checkPecuariosanitarioordeniahigninguna:
                if (checked) {

                    MANEJOSANNINORD = "Ninguna";

                }else{

                    MANEJOSANNINORD = null;
                }

                break;


        }

    }




    public void obtenerValorpracthigiene(){


        if(!edtPecuariosanitarioordeniaotrohig.getText().toString().isEmpty()){
            MANEJOSANEDTOOR = edtPecuariosanitarioordeniaotrohig.getText().toString();
        } else{
            MANEJOSANEDTOOR = null;
        }

        if(!edtPecuariosanitarioordeniacostohig.getText().toString().isEmpty()){
            MANEJOSANCOSTOR = edtPecuariosanitarioordeniacostohig.getText().toString();
        } else{
            MANEJOSANCOSTOR = null;
        }
    }


    @Override
    public void onBackPressed() {

    }

}
