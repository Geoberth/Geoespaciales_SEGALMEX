package com.example.geosegalmex.Pecuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.Pecuario.GlobalPecuario.GlobalPecuario;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

public class PecuarioInicio extends AppCompatActivity {


    //Variables locales para guardar los datos
    private String TIPORAZABOVINO = null;
    private String RAZAPURA = null;
    private String RAZAPURAOTRO = null;
    private String RAZACRUZA = null;
    private String RAZACRUZAOTRO = null;


    //Variable con dato que no va a la base de datos
    private String RAZAPURABAND = null;



    //TextView
    TextView txtBovinoeuropeootro;

    TextView txtBovinosintetotro;

    TextView txtBovinocebuotro;

    TextView txtBovinocruzasotro;



    //Checkbox
    RadioButton bovinoEuropeas;
    RadioButton bovinoSinteticas;
    RadioButton bovinoCebu;


    //EditText
    //EditText edtPecubovinocruza;
    //EditText edtPecubovinorazapura;

    EditText edtBovinoeuropeootro;

    EditText edtBovinosintetotro;

    EditText edtBovinocebuotro;

    EditText edtBovinocruzasotro;





    //Spinners
    Spinner spinBovinoeuropeo;
    Spinner spinBovsintetica;
    Spinner spinBovinocebu;
    Spinner spinBovinocruzas;

    //idSpinbovinoeuropeo
    //idSpinbovinosintet
    //idSpinbovinocebu
    //idSpinbovinocruzas

    //Buttons
    Button btnPecuinicio;




    //BASE DE DATOS
    private DatabaseHelper baseBD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pecuario_inicio);

        //TextView
        txtBovinoeuropeootro = (TextView)findViewById(R.id.txtBovinoeuropeootro);

        txtBovinosintetotro = (TextView)findViewById(R.id.txtBovinosintetotro);

        txtBovinocebuotro = (TextView)findViewById(R.id.txtBovinocebuotro);

        txtBovinocruzasotro = (TextView)findViewById(R.id.txtBovinocruzasotro);


        //EditText
        //edtPecubovinocruza = (EditText)findViewById(R.id.edtPecubovinocruza);
        //edtPecubovinorazapura = (EditText)findViewById(R.id.edtPecubovinorazapura);

        edtBovinoeuropeootro = (EditText)findViewById(R.id.edtBovinoeuropeootro);

        edtBovinosintetotro = (EditText)findViewById(R.id.edtBovinosintetotro);

        edtBovinocebuotro = (EditText)findViewById(R.id.edtBovinocebuotro);

        edtBovinocruzasotro = (EditText)findViewById(R.id.edtBovinocruzasotro);

        //Spinner
        spinBovinoeuropeo = (Spinner)findViewById(R.id.idSpinbovinoeuropeo);
        spinBovsintetica = (Spinner)findViewById(R.id.idSpinbovinosintet);
        spinBovinocebu = (Spinner)findViewById(R.id.idSpinbovinocebu);
        spinBovinocruzas = (Spinner)findViewById(R.id.idSpinbovinocruzas);


        //Checkbox
        bovinoEuropeas = (RadioButton) findViewById(R.id.bovinoEuropeas);
        bovinoSinteticas = (RadioButton) findViewById(R.id.bovinoSinteticas);
        bovinoCebu = (RadioButton) findViewById(R.id.bovinoCebu);


        //Button
        btnPecuinicio = (Button)findViewById(R.id.apicola_next_manejo);




        ////////////////////////////////////////////////////////////////////////////////////
        spinBovinoeuropeo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                    case 12:
                    case 13:
                        txtBovinoeuropeootro.setVisibility(View.GONE);
                        edtBovinoeuropeootro.setVisibility(View.GONE);

                        break;

                    case 14:
                        txtBovinoeuropeootro.setVisibility(View.VISIBLE);
                        edtBovinoeuropeootro.setVisibility(View.VISIBLE);

                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        ////////////////////////////////////////////////////////////////////
        spinBovsintetica.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                        txtBovinosintetotro.setVisibility(View.GONE);
                        edtBovinosintetotro.setVisibility(View.GONE);

                        break;

                    case 9:
                        txtBovinosintetotro.setVisibility(View.VISIBLE);
                        edtBovinosintetotro.setVisibility(View.VISIBLE);

                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        ////////////////////////////////////////////////////////////////////
        spinBovinocebu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                switch (position) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        txtBovinocebuotro.setVisibility(View.GONE);
                        edtBovinocebuotro.setVisibility(View.GONE);

                        break;

                    case 6:
                        txtBovinocebuotro.setVisibility(View.VISIBLE);
                        edtBovinocebuotro.setVisibility(View.VISIBLE);

                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        ////////////////////////////////////////////////////////////////////
        spinBovinocruzas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                switch (position) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        txtBovinocruzasotro.setVisibility(View.GONE);
                        edtBovinocruzasotro.setVisibility(View.GONE);

                        break;

                    case 6:
                        txtBovinocruzasotro.setVisibility(View.VISIBLE);
                        edtBovinocruzasotro.setVisibility(View.VISIBLE);

                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        //BD
        baseBD         = new DatabaseHelper(this);





        btnPecuinicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean validaRazabov = validaRazabovino();


         //       if(!validaRazabov){

                    obtenerValorraza();

                    //validaOtrasituacion();



                    GlobalPecuario.TIPORAZABOVINO = TIPORAZABOVINO;
                    GlobalPecuario.RAZAPURA = RAZAPURA;
                    GlobalPecuario.RAZAPURAOTRO = RAZAPURAOTRO;
                    GlobalPecuario.RAZACRUZA = RAZACRUZA;
                    GlobalPecuario.RAZACRUZAOTRO = RAZACRUZAOTRO;

                    //agregarInformacproductor();
                    agregarPecubovinoupf();

                    Toast.makeText(getApplicationContext(), "Agregado correctamente ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(PecuarioInicio.this, PecuarioOvinos.class));
                    finish();

        //        }else{

        //            Toast.makeText(getApplicationContext(), "Faltan datos de tipo de raza bovino", Toast.LENGTH_SHORT).show();
        //        }



            }
        });
    }



    //INSERCION DE DATOS
    public void agregarPecubovinoupf(){



        addPecubovino();

    }




    ///Agregar el pecuario bovino

    private void addPecubovino(){
        boolean insertarData = baseBD.addRazabovinos();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }











    /////////////////////////////////////////////////////////////////
    //Seleccion de tipo de raza bovino
    public void clickTiporazabovino(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioPecubovinocriollo:
                if (checked) {
                    bovinoEuropeas.setVisibility(View.GONE);
                    spinBovinoeuropeo.setVisibility(View.GONE);
                    txtBovinoeuropeootro.setVisibility(View.GONE);
                    edtBovinoeuropeootro.setVisibility(View.GONE);


                    bovinoSinteticas.setVisibility(View.GONE);
                    spinBovsintetica.setVisibility(View.GONE);
                    txtBovinosintetotro.setVisibility(View.GONE);
                    edtBovinosintetotro.setVisibility(View.GONE);

                    bovinoCebu.setVisibility(View.GONE);
                    spinBovinocebu.setVisibility(View.GONE);
                    txtBovinocebuotro.setVisibility(View.GONE);
                    edtBovinocebuotro.setVisibility(View.GONE);

                    spinBovinocruzas.setVisibility(View.GONE);
                    txtBovinocruzasotro.setVisibility(View.GONE);
                    edtBovinocruzasotro.setVisibility(View.GONE);

                    TIPORAZABOVINO = "Criollo";
                }

                break;




            case R.id.radioPecubovinorazapura:
                if (checked) {
                    bovinoEuropeas.setVisibility(View.VISIBLE);
                    spinBovinoeuropeo.setVisibility(View.GONE);
                    txtBovinoeuropeootro.setVisibility(View.GONE);
                    edtBovinoeuropeootro.setVisibility(View.GONE);


                    bovinoSinteticas.setVisibility(View.VISIBLE);
                    spinBovsintetica.setVisibility(View.GONE);
                    txtBovinosintetotro.setVisibility(View.GONE);
                    edtBovinosintetotro.setVisibility(View.GONE);


                    bovinoCebu.setVisibility(View.VISIBLE);
                    spinBovinocebu.setVisibility(View.GONE);
                    txtBovinocebuotro.setVisibility(View.GONE);
                    edtBovinocebuotro.setVisibility(View.GONE);


                    spinBovinocruzas.setVisibility(View.GONE);
                    txtBovinocruzasotro.setVisibility(View.GONE);
                    edtBovinocruzasotro.setVisibility(View.GONE);

                    TIPORAZABOVINO = "Raza pura";
                }

                break;




            case R.id.radioPecubovinocruza:
                if (checked) {
                    bovinoEuropeas.setVisibility(View.GONE);
                    spinBovinoeuropeo.setVisibility(View.GONE);
                    txtBovinoeuropeootro.setVisibility(View.GONE);
                    edtBovinoeuropeootro.setVisibility(View.GONE);


                    bovinoSinteticas.setVisibility(View.GONE);
                    spinBovsintetica.setVisibility(View.GONE);
                    txtBovinosintetotro.setVisibility(View.GONE);
                    edtBovinosintetotro.setVisibility(View.GONE);


                    bovinoCebu.setVisibility(View.GONE);
                    spinBovinocebu.setVisibility(View.GONE);
                    txtBovinocebuotro.setVisibility(View.GONE);
                    edtBovinocebuotro.setVisibility(View.GONE);


                    spinBovinocruzas.setVisibility(View.VISIBLE);
                    txtBovinocruzasotro.setVisibility(View.GONE);
                    edtBovinocruzasotro.setVisibility(View.GONE);


                    TIPORAZABOVINO = "Cruza";
                }

                break;





        }
    }






    //Seleccion de catalogo razas bovino
    public void clickCatalogorazasbovinos(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.bovinoEuropeas:
                if (checked) {
                    spinBovinoeuropeo.setVisibility(View.VISIBLE);
                    //txtBovinoeuropeootro.setVisibility(View.GONE);
                    //edtBovinoeuropeootro.setVisibility(View.GONE);


                    spinBovsintetica.setVisibility(View.GONE);
                    txtBovinosintetotro.setVisibility(View.GONE);
                    edtBovinosintetotro.setVisibility(View.GONE);

                    spinBovinocebu.setVisibility(View.GONE);
                    txtBovinocebuotro.setVisibility(View.GONE);
                    edtBovinocebuotro.setVisibility(View.GONE);
                    RAZAPURABAND = "Europeas";
                }

                break;




            case R.id.bovinoSinteticas:
                if (checked) {
                    spinBovinoeuropeo.setVisibility(View.GONE);
                    txtBovinoeuropeootro.setVisibility(View.GONE);
                    edtBovinoeuropeootro.setVisibility(View.GONE);

                    spinBovsintetica.setVisibility(View.VISIBLE);
                    //txtBovinosintetotro.setVisibility(View.GONE);
                    //edtBovinosintetotro.setVisibility(View.GONE);

                    spinBovinocebu.setVisibility(View.GONE);
                    txtBovinocebuotro.setVisibility(View.GONE);
                    edtBovinocebuotro.setVisibility(View.GONE);
                    RAZAPURABAND = "Sintéticas";
                }

                break;



            case R.id.bovinoCebu:
                if (checked) {
                    spinBovinoeuropeo.setVisibility(View.GONE);
                    txtBovinoeuropeootro.setVisibility(View.GONE);
                    edtBovinoeuropeootro.setVisibility(View.GONE);

                    spinBovsintetica.setVisibility(View.GONE);
                    txtBovinosintetotro.setVisibility(View.GONE);
                    edtBovinosintetotro.setVisibility(View.GONE);

                    spinBovinocebu.setVisibility(View.VISIBLE);
                    //txtBovinocebuotro.setVisibility(View.GONE);
                    //edtBovinocebuotro.setVisibility(View.GONE);
                    RAZAPURABAND = "Cebú";
                }

                break;

        }
    }




    //METODO DE VALIDACION RAZA BOVINA upf
    public Boolean validaRazabovino(){
        if(TIPORAZABOVINO == null){

            return true;
        } else if (TIPORAZABOVINO != null){

            return false;
        }
        return false;
    }



    private void obtenerValorraza(){

        if (TIPORAZABOVINO == "Criollo"){
            RAZAPURA = null;
            RAZAPURAOTRO = null;
            RAZACRUZA = null;
            RAZACRUZAOTRO = null;

        } else if(TIPORAZABOVINO == "Raza pura"){

            if (RAZAPURABAND == "Europeas"){
                RAZAPURA = spinBovinoeuropeo.getSelectedItem().toString();

                if (RAZAPURA.equals("Otra Europea")){
                    RAZAPURAOTRO = edtBovinoeuropeootro.getText().toString();
                }

            }

            else if (RAZAPURABAND == "Sintéticas"){
                RAZAPURA = spinBovsintetica.getSelectedItem().toString();

                if (RAZAPURA.equals("Otra Sintética")){
                    RAZAPURAOTRO = edtBovinosintetotro.getText().toString();
                }

            }

            else if (RAZAPURABAND == "Cebú"){
                RAZAPURA = spinBovinocebu.getSelectedItem().toString();

                if (RAZAPURA.equals("Otra Cebú")){
                    RAZAPURAOTRO = edtBovinocebuotro.getText().toString();
                }



            }

        }else if(TIPORAZABOVINO == "Cruza"){
            RAZACRUZA = spinBovinocruzas.getSelectedItem().toString();

            if(RAZACRUZA.equals("Otra Cruza")){
                RAZACRUZAOTRO = edtBovinocruzasotro.getText().toString();
            }

        }

    }


    @Override
    public void onBackPressed() {

    }


}
