package com.example.geosegalmex.Productor;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.General;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

public class IntegranteFamilia extends AppCompatActivity {

    //Variables locales Integrante-Familia
    private static String SEXOINTEGRANTE = null;
    private static String EDADINTEGRANTE = null;
    private static String LEESCRIBIRINT = null;
    private static String NIVESTUDIOSINT = null;
    private static String SITESTUDIOINT = null;
    private static String HABLALENGORIGINT = null;
    private static String CUALLENGORIGINT = null;
    private static String PARTICIPAUPF = null;
    private static String DEDICAINTEGRANTE = null;
    private static String INGRESOINTEGRANTE = null;
    private static String OTROINGRESOINT = null;


    private DatabaseHelper baseBD;

    //EditText
    EditText edtEdadInt;
    EditText edtIngresointupf;
    EditText edtOtroingintupf;

    //TextView
    TextView txtLenguaordint;


    //Spinner
    Spinner gradoEstudiosintegrante;
    Spinner lenguaOrig;


    //LinearLayout
    LinearLayout linSituacestudios;





    Button btnGuardarintegrante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integrante_familia);


        //Button
        btnGuardarintegrante = (Button)findViewById(R.id.btnGuardarInt);


        //TextView
        txtLenguaordint = (TextView)findViewById(R.id.txtLenguaordint);


        //EditText
        edtEdadInt = (EditText)findViewById(R.id.edtEdadInt);
        edtIngresointupf = (EditText)findViewById(R.id.edtIngresointupf);
        edtOtroingintupf = (EditText)findViewById(R.id.edtOtroingintupf);


        //Spinner
        gradoEstudiosintegrante = (Spinner)findViewById(R.id.idSpgradoestint);
        lenguaOrig = (Spinner)findViewById(R.id.isSpinLengorigint);

        //LinearLayout
        linSituacestudios = (LinearLayout)findViewById(R.id.linSituacestudios);



        //BD
        baseBD         = new DatabaseHelper(this);


        gradoEstudiosintegrante.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                switch (position) {
                    case 0:
                        linSituacestudios.setVisibility(View.GONE);

                        break;

                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:

                        linSituacestudios.setVisibility(View.VISIBLE);

                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        btnGuardarintegrante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                NIVESTUDIOSINT = gradoEstudiosintegrante.getSelectedItem().toString();

                Boolean valorSex = validaSexointeg();
                Boolean valorEdad = validaEdadint();
                Boolean validaleng = validaLenguaorint();
                //Boolean valorIngreso = validaIngmensual();


                if(!valorSex && !valorEdad){

                    General.SEXOINTEGRANTE = SEXOINTEGRANTE;
                    General.EDADINTEGRANTE = EDADINTEGRANTE;
                    General.LEESCRIBIRINT = LEESCRIBIRINT;
                    General.NIVESTUDIOSINT = NIVESTUDIOSINT;
                    General.SITESTUDIOINT = SITESTUDIOINT;

                    General.HABLALENGORIG = HABLALENGORIGINT;

                    cualLenguaorigint();

                    General.CUALLENGORIG = CUALLENGORIGINT;
                    General.PARTICIPAUPF = PARTICIPAUPF;
                    General.DEDICAINTEGRANTE = DEDICAINTEGRANTE;

                    validaIngmensual();
                    General.INGRESOINTEGRANTE = INGRESOINTEGRANTE;
                    validaOtroingmensual();
                    General.OTROINGRESOINT = OTROINGRESOINT;



                    agregarInformacintegrante();

                    Toast.makeText(getApplicationContext(), "Agregado integrante correctamente ", Toast.LENGTH_SHORT).show();
                    finish();
                    //startActivity(new Intent(IntegranteFamilia.this, ProductorFamilia.class));

                }
                else{

                    Toast.makeText(getApplicationContext(), "Faltan datos del productor", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }



    //Metodos de insertar
    public void agregarInformacintegrante(){

        //General.MaterialViviendaParedOtro = edtOtromatpared.getText().toString();

        addProductorIntegrante();

    }




    ///Agregar el productor

    private void addProductorIntegrante(){
        boolean insertarData = baseBD.addIntegranteFamilia();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }







    ///////////////////////////////////////////////////////////////////////////////
    public void clickSexointegrante(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioSexmasc:
                if (checked) {
                    SEXOINTEGRANTE = "Masculino";

                }

                break;


            case R.id.radioSexfem:
                if (checked) {
                    SEXOINTEGRANTE = "Femenino";

                }

                break;
        }
    }




    //METODO DE VALIDACION SEXO INTEGRANTE
    private Boolean validaSexointeg(){
        if(SEXOINTEGRANTE == null){

            return true;
        } else if (SEXOINTEGRANTE != null){

            return false;
        }
        return false;
    }




    //METODO DE VALIDACION EDAD INTEGRANTE
    private Boolean validaEdadint(){
        if(edtEdadInt.getText().toString().isEmpty()){

            return true;
        } else if (!edtEdadInt.getText().toString().isEmpty()){

            EDADINTEGRANTE = edtEdadInt.getText().toString();

            return false;
        }
        return false;
    }




    //RarioButton de sabe leer y escribir?
    public void clickLeerescribir(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioLeeint:
                if (checked) {
                    LEESCRIBIRINT = "Sí";

                }

                break;


            case R.id.radioNoleeint:
                if (checked) {
                    LEESCRIBIRINT = "No";

                }

                break;
        }
    }





    //RarioButton de situacion de estudios completo o trunco?
    public void clickSituacionestudios(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioCompletoint:
                if (checked) {
                    SITESTUDIOINT = "Completo";

                }

                break;


            case R.id.radioIncompletoint:
                if (checked) {
                    SITESTUDIOINT = "Trunco";

                }

                break;
        }
    }






    //RadioButton habla lengua originaria?
    public void clickHablalenguaorig(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioLenguaint:
                if (checked) {
                    txtLenguaordint.setVisibility(View.VISIBLE);
                    lenguaOrig.setVisibility(View.VISIBLE);
                    HABLALENGORIGINT = "Sí";

                }

                break;


            case R.id.radioNolenguaint:
                if (checked) {
                    txtLenguaordint.setVisibility(View.GONE);
                    lenguaOrig.setVisibility(View.GONE);
                    HABLALENGORIGINT = "No";

                }

                break;
        }
    }


    private Boolean validaLenguaorint(){
        if(HABLALENGORIGINT == null){
            return true;

        }else if(HABLALENGORIGINT != null){
            return false;
        }
        return false;
    }


    private void cualLenguaorigint(){
        if(HABLALENGORIGINT == "Sí"){

            CUALLENGORIGINT =  lenguaOrig.getSelectedItem().toString();
        }else{
            CUALLENGORIGINT = null;
        }

    }







    //RadioButton participa en actividades upf
    public void clickParticipacionupf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioParticipaInt:
                if (checked) {
                    PARTICIPAUPF = "Sí";

                }

                break;


            case R.id.radioNoparticipaint:
                if (checked) {
                    PARTICIPAUPF = "No";

                }

                break;
        }
    }




    //RadioButton participa en actividades upf
    public void clickDedicaintegrante(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioEstudiaint:
                if (checked) {
                    DEDICAINTEGRANTE = "Estudia";

                }

                break;


            case R.id.radioTrabajaint:
                if (checked) {
                    DEDICAINTEGRANTE = "Trabaja";

                }

                break;


            case R.id.radioNoaplicaint:
                if (checked) {
                    DEDICAINTEGRANTE = "No aplica";

                }

                break;
        }
    }



    //METODO DE VALIDA INGRESO MENSUAL
    private void validaIngmensual(){
        if(edtIngresointupf.getText().toString().isEmpty()){

            INGRESOINTEGRANTE = null;

        } else if (!edtIngresointupf.getText().toString().isEmpty()){

            INGRESOINTEGRANTE = edtIngresointupf.getText().toString();

        }
    }




    //METODO DE VALIDA OTRO INGRESO
    private void validaOtroingmensual(){
        if(edtOtroingintupf.getText().toString().isEmpty()){

            OTROINGRESOINT = null;

        } else if (!edtOtroingintupf.getText().toString().isEmpty()){

            OTROINGRESOINT = edtOtroingintupf.getText().toString();

        }
    }

}
