package com.example.geosegalmex.Productor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.General;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

public class ProductorEconom extends AppCompatActivity {

    //variables locales para almacenar la informacion de forma local
    private String ACTCOMERCIO = null;
    private String ACTTRANSFORMACION = null;
    private String ACTAGRICULTURA = null;
    private String ACTGANADERIA = null;
    private String ACTPESCA = null;
    private String ACTMINERIA = null;
    private String ACTAPICULTURA = null;
    private String ACTMANUFACTURARTE = null;
    private String ACTSERVPERSONALES = null;
    private String ACTCONSTRUCCION = null;
    private String ACTEDUCACION = null;
    private String ACTTURISMO = null;
    private String ACTSERVPROF = null;
    private String ACTTRANSPORTE = null;
    private String ACTGOBIERNO = null;
    private String ACTOTRO = null;
    private String ACTEDTOTRO = null;


    private String MATVIVPARED = null;
    private String MARVIVPOTRO = null;
    private String MATVIVTECHO = null;
    private String MATVIVTECOTRO = null;
    private String MATVIVPISO = null;
    private String MATVIVPISOTRO = null;
    private String TIENECOCINA = null;
    private String CUANTOSCUARTOS = null;
    private String BANIOLETRINA = null;
    private String SERVDRENAJE = null;
    private String SERVTELEFONO = null;
    private String SERVAGUA = null;
    private String SERVINTERNET = null;
    private String SERVELECTRICIDAD = null;


    private DatabaseHelper baseBD;

    //TextView
    TextView textOtraactind;
    TextView txtOtropared;
    TextView txtLamOtro;
    TextView txtOtropiso;


    //RadioButon
    RadioButton radioMaderapard;
    RadioButton radioBlockpard;
    RadioButton radioAdobepard;
    RadioButton radioOtropard;


    //EditText
    EditText edtOtraactind;
    EditText edtOtromatpared;
    EditText edtOtrotec;
    EditText edtOtropiso;
    EditText edtCantidadcuartos;


    //Spiners
    Spinner materialTecho;
    Spinner materialPiso;

    //Botones
    Button btnFamilia;

    //CheckBox
    CheckBox checkComercio;
    CheckBox checkTransformac;
    CheckBox checkAgricultura;
    CheckBox checkGanaderia;
    CheckBox checkPesca;
    CheckBox checkMineria;
    CheckBox checkApicultura;
    CheckBox checkManufact;
    CheckBox checkServicpers;
    CheckBox checkConstruccion;
    CheckBox checkEdusalud;
    CheckBox checkTurismo;
    CheckBox checkServicprof;
    CheckBox checkTransp;
    CheckBox checkGobierno;
    CheckBox checkOtroactind;

    //Variable contador
    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productor_econom);

        //CheckBox
        checkComercio = (CheckBox)findViewById(R.id.checkComercio);
        checkTransformac = (CheckBox)findViewById(R.id.checkTransformac);
        checkAgricultura = (CheckBox)findViewById(R.id.checkAgricultura);
        checkGanaderia = (CheckBox)findViewById(R.id.checkGanaderia);
        checkPesca = (CheckBox)findViewById(R.id.checkPesca);
        checkMineria = (CheckBox)findViewById(R.id.checkMineria);
        checkApicultura = (CheckBox)findViewById(R.id.checkApicultura);
        checkManufact = (CheckBox)findViewById(R.id.checkManufact);
        checkServicpers = (CheckBox)findViewById(R.id.checkServicpers);
        checkConstruccion = (CheckBox)findViewById(R.id.checkConstruccion);
        checkEdusalud = (CheckBox)findViewById(R.id.checkEdusalud);
        checkTurismo = (CheckBox)findViewById(R.id.checkTurismo);
        checkServicprof = (CheckBox)findViewById(R.id.checkServicprof);
        checkTransp = (CheckBox)findViewById(R.id.checkTransp);
        checkGobierno = (CheckBox)findViewById(R.id.checkGobierno);
        checkOtroactind = (CheckBox)findViewById(R.id.checkOtroactind);


        //Botones
        btnFamilia = (Button) findViewById(R.id.btnAgrfamilia);

        //TextView
        textOtraactind = (TextView) findViewById(R.id.textOtraactind);
        txtOtropared = (TextView) findViewById(R.id.txtOtropared);
        txtLamOtro = (TextView) findViewById(R.id.txtLamOtro);
        txtOtropiso = (TextView) findViewById(R.id.txtOtropiso);


        //EditText
        edtOtraactind = (EditText) findViewById(R.id.edtOtraactind);
        edtOtromatpared = (EditText) findViewById(R.id.edtOtromatpared);
        edtOtrotec = (EditText) findViewById(R.id.edtOtrotec);
        edtOtropiso = (EditText) findViewById(R.id.edtOtropiso);
        edtCantidadcuartos = (EditText)findViewById(R.id.edtCantidadcuartos);


        //Radio
        radioMaderapard = (RadioButton)findViewById(R.id.radioMaderapard);
        radioBlockpard = (RadioButton)findViewById(R.id.radioBlockpard);
        radioAdobepard = (RadioButton)findViewById(R.id.radioAdobepard);
        radioOtropard = (RadioButton)findViewById(R.id.radioOtropard);


        //Spinner
        materialTecho = (Spinner)findViewById(R.id.idSpinMattecho);
        materialPiso = (Spinner)findViewById(R.id.idSpinMatpiso);




        //BD
        baseBD         = new DatabaseHelper(this);




        //validaciones spinners para mostrar u ocultar valores
        materialTecho.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                switch (position) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        txtLamOtro.setVisibility(View.GONE);
                        edtOtrotec.setVisibility(View.GONE);

                        break;

                    case 6:
                        txtLamOtro.setVisibility(View.VISIBLE);
                        edtOtrotec.setVisibility(View.VISIBLE);

                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });







        materialPiso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                switch (position) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        txtOtropiso.setVisibility(View.GONE);
                        edtOtropiso.setVisibility(View.GONE);

                        break;

                    case 4:
                        txtOtropiso.setVisibility(View.VISIBLE);
                        edtOtropiso.setVisibility(View.VISIBLE);

                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        btnFamilia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ACTEDTOTRO = edtOtraactind.getText().toString();

                MATVIVTECHO = materialTecho.getSelectedItem().toString();
                MATVIVPISO = materialPiso.getSelectedItem().toString();

                Boolean valorMatPared = validaMaterialpared();
                Boolean validaCocina = validaCocina();
                Boolean validaCantcuartos = cantidadCuartos();


                if(!valorMatPared && !validaCocina && !validaCantcuartos){

                    General.ACTCOMERCIO = ACTCOMERCIO;
                    General.ACTTRANSFORMACION = ACTTRANSFORMACION;
                    General.ACTAGRICULTURA = ACTAGRICULTURA;
                    General.ACTGANADERIA = ACTGANADERIA;
                    General.ACTPESCA = ACTPESCA;
                    General.ACTMINERIA = ACTMINERIA;
                    General.ACTAPICULTURA = ACTAPICULTURA;
                    General.ACTMANUFACTURARTE = ACTMANUFACTURARTE;
                    General.ACTSERVPERSONALES = ACTSERVPERSONALES;
                    General.ACTCONSTRUCCION = ACTCONSTRUCCION;
                    General.ACTEDUCACION = ACTEDUCACION;
                    General.ACTTURISMO = ACTTURISMO;
                    General.ACTSERVPROF = ACTSERVPROF;
                    General.ACTTRANSPORTE = ACTTRANSPORTE;
                    General.ACTGOBIERNO = ACTGOBIERNO;
                    General.ACTOTRO = ACTOTRO;
                    General.ACTEDTOTRO = ACTEDTOTRO;

                    General.MaterialViviendaPared = MATVIVPARED;
                    otroParedmaterial();
                    General.MaterialViviendaParedOtro = MARVIVPOTRO;
                    General.MaterialViviendaTecho = MATVIVTECHO;
                    otroTechomaterial();
                    General.MaterialViviendaTechootro = MATVIVTECOTRO;
                    General.MaterialViviendaPiso = MATVIVPISO;
                    otroPisoMaterial();
                    General.MaterialViviendaPisootro = MATVIVPISOTRO;
                    General.ViviendaCocina = TIENECOCINA;
                    General.CantidadCuartos = CUANTOSCUARTOS;
                    General.CuentaBanio = BANIOLETRINA;
                    General.ViviendaServicioDrenaje = SERVDRENAJE;
                    General.ViviendaServicioTelefono = SERVTELEFONO;
                    General.ViviendaServicioAgua = SERVAGUA;
                    General.ViviendaServicioInternet = SERVINTERNET;
                    General.ViviendaServicioElectricidad = SERVELECTRICIDAD;



                    //agregarInformacproductor();
                    Toast.makeText(getApplicationContext(), "Agregados correctamente ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ProductorEconom.this, ProductorFamilia.class));
                    finish();

                }else{

                    Toast.makeText(getApplicationContext(), "Faltan datos del productor", Toast.LENGTH_SHORT).show();
                }


            }
        });





    }




    public void clickActividadesrealizar(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkComercio:
                if (checked) {
                    contador = contador + 1;
                    System.out.println(contador);
                    textOtraactind.setVisibility(View.GONE);
                    edtOtraactind.setVisibility(View.GONE);
                    ACTCOMERCIO = "Comercio";


                    if (contador < 4){
                        checkComercio.setChecked(true);
                    }

                }
                else{
                    //textOtraactind.setVisibility(View.GONE);
                    //edtOtraactind.setVisibility(View.GONE);
                    ACTCOMERCIO = null;



                }
                break;



            case R.id.checkTransformac:
                if (checked) {
                    contador = contador + 1;
                    System.out.println(contador);
                    textOtraactind.setVisibility(View.GONE);
                    edtOtraactind.setVisibility(View.GONE);
                    ACTTRANSFORMACION = "Transformación";


                    if (contador < 4) {
                        checkTransformac.setChecked(true);
                    }


                }
                else{
                    //textOtraactind.setVisibility(View.GONE);
                    //edtOtraactind.setVisibility(View.GONE);
                    ACTTRANSFORMACION = null;

                }
                break;



            case R.id.checkAgricultura:
                if (checked) {
                    contador = contador + 1;
                    System.out.println(contador);
                    textOtraactind.setVisibility(View.GONE);
                    edtOtraactind.setVisibility(View.GONE);
                    ACTAGRICULTURA = "Agricultura";


                    if (contador < 4) {
                        checkAgricultura.setChecked(true);
                    }


                }
                else{
                    //textOtraactind.setVisibility(View.GONE);
                    //edtOtraactind.setVisibility(View.GONE);
                    ACTAGRICULTURA = null;


                }
                break;



            case R.id.checkGanaderia:
                if (checked) {
                    contador = contador + 1;
                    System.out.println(contador);
                    textOtraactind.setVisibility(View.GONE);
                    edtOtraactind.setVisibility(View.GONE);
                    ACTGANADERIA = "Ganadería";


                    if (contador < 4) {
                        checkGanaderia.setChecked(true);
                    }


                }
                else{
                    //textOtraactind.setVisibility(View.GONE);
                    //edtOtraactind.setVisibility(View.GONE);
                    ACTGANADERIA = null;


                }
                break;




            case R.id.checkPesca:
                if (checked) {
                    contador = contador + 1;
                    System.out.println(contador);
                    textOtraactind.setVisibility(View.GONE);
                    edtOtraactind.setVisibility(View.GONE);
                    ACTPESCA = "Pesca";


                    if (contador < 4) {
                        checkPesca.setChecked(true);
                    }


                }
                else{
                    //textOtraactind.setVisibility(View.GONE);
                    //edtOtraactind.setVisibility(View.GONE);
                    ACTPESCA = null;


                }
                break;




            case R.id.checkMineria:
                if (checked) {
                    contador = contador + 1;
                    System.out.println(contador);
                    textOtraactind.setVisibility(View.GONE);
                    edtOtraactind.setVisibility(View.GONE);
                    ACTMINERIA = "Minería";


                    if (contador < 4) {
                        checkMineria.setChecked(true);
                    }


                }
                else{
                    //textOtraactind.setVisibility(View.GONE);
                    //edtOtraactind.setVisibility(View.GONE);
                    ACTMINERIA = null;


                }
                break;



            case R.id.checkApicultura:
                if (checked) {
                    contador = contador + 1;
                    System.out.println(contador);
                    textOtraactind.setVisibility(View.GONE);
                    edtOtraactind.setVisibility(View.GONE);
                    ACTAPICULTURA = "Apicultura";


                    if (contador < 4) {
                        checkApicultura.setChecked(true);
                    }


                }
                else{
                    //textOtraactind.setVisibility(View.GONE);
                    //edtOtraactind.setVisibility(View.GONE);
                    ACTAPICULTURA = null;


                }
                break;




            case R.id.checkManufact:
                if (checked) {
                    contador = contador + 1;
                    System.out.println(contador);
                    textOtraactind.setVisibility(View.GONE);
                    edtOtraactind.setVisibility(View.GONE);
                    ACTMANUFACTURARTE = "Manufactura artesanal";


                    if (contador < 4) {
                        checkManufact.setChecked(true);
                    }


                }
                else{
                    //textOtraactind.setVisibility(View.GONE);
                    //edtOtraactind.setVisibility(View.GONE);
                    ACTMANUFACTURARTE = null;


                }
                break;




            case R.id.checkServicpers:
                if (checked) {
                    contador = contador + 1;
                    System.out.println(contador);
                    textOtraactind.setVisibility(View.GONE);
                    edtOtraactind.setVisibility(View.GONE);
                    ACTSERVPERSONALES = "Servicios personales";


                    if (contador < 4) {
                        checkServicpers.setChecked(true);
                    }


                }
                else{
                    //textOtraactind.setVisibility(View.GONE);
                    //edtOtraactind.setVisibility(View.GONE);
                    ACTSERVPERSONALES = null;


                }
                break;





            case R.id.checkConstruccion:
                if (checked) {
                    contador = contador + 1;
                    System.out.println(contador);
                    textOtraactind.setVisibility(View.GONE);
                    edtOtraactind.setVisibility(View.GONE);
                    ACTCONSTRUCCION = "Construcción";


                    if (contador < 4) {
                        checkConstruccion.setChecked(true);
                    }


                }
                else{
                    //textOtraactind.setVisibility(View.GONE);
                    //edtOtraactind.setVisibility(View.GONE);
                    ACTCONSTRUCCION = null;


                }
                break;



            case R.id.checkEdusalud:
                if (checked) {
                    contador = contador + 1;
                    System.out.println(contador);
                    textOtraactind.setVisibility(View.GONE);
                    edtOtraactind.setVisibility(View.GONE);
                    ACTEDUCACION = "Educación y salud";


                    if (contador < 4) {
                        checkEdusalud.setChecked(true);
                    }


                }
                else{
                    //textOtraactind.setVisibility(View.GONE);
                    //edtOtraactind.setVisibility(View.GONE);
                    ACTEDUCACION = null;


                }
                break;



            case R.id.checkTurismo:
                if (checked) {
                    contador = contador + 1;
                    System.out.println(contador);
                    textOtraactind.setVisibility(View.GONE);
                    edtOtraactind.setVisibility(View.GONE);
                    ACTTURISMO = "Turismo";


                    if (contador < 4) {
                        checkTurismo.setChecked(true);
                    }


                }
                else{
                    //textOtraactind.setVisibility(View.GONE);
                    //edtOtraactind.setVisibility(View.GONE);
                    ACTTURISMO = null;

                }
                break;




            case R.id.checkServicprof:
                if (checked) {
                    contador = contador + 1;
                    System.out.println(contador);
                    textOtraactind.setVisibility(View.GONE);
                    edtOtraactind.setVisibility(View.GONE);
                    ACTSERVPROF = "Servicios profesionales";


                    if (contador < 4) {
                        checkServicprof.setChecked(true);
                    }


                }
                else{
                    //textOtraactind.setVisibility(View.GONE);
                    //edtOtraactind.setVisibility(View.GONE);
                    ACTSERVPROF = null;

                }
                break;




            case R.id.checkTransp:
                if (checked) {
                    contador = contador + 1;
                    System.out.println(contador);
                    textOtraactind.setVisibility(View.GONE);
                    edtOtraactind.setVisibility(View.GONE);
                    ACTTRANSPORTE = "Transporte";


                    if (contador < 4) {
                        checkTransp.setChecked(true);
                    }


                }
                else{
                    //textOtraactind.setVisibility(View.GONE);
                    //edtOtraactind.setVisibility(View.GONE);
                    ACTTRANSPORTE = null;

                }
                break;




            case R.id.checkGobierno:
                if (checked) {
                    contador = contador + 1;
                    System.out.println(contador);
                    textOtraactind.setVisibility(View.GONE);
                    edtOtraactind.setVisibility(View.GONE);
                    ACTGOBIERNO = "Gobierno";


                    if (contador < 4) {
                        checkGobierno.setChecked(true);
                    }


                }
                else{
                    //textOtraactind.setVisibility(View.GONE);
                    //edtOtraactind.setVisibility(View.GONE);
                    ACTGOBIERNO = null;

                }
                break;





            case R.id.checkOtroactind:
                if (checked) {
                    contador = contador + 1;
                    System.out.println(contador);
                    textOtraactind.setVisibility(View.VISIBLE);
                    edtOtraactind.setVisibility(View.VISIBLE);
                    ACTOTRO = "Otro";


                    if (contador < 4) {
                        checkOtroactind.setChecked(true);
                    }


                }
                else{
                    textOtraactind.setVisibility(View.GONE);
                    edtOtraactind.setVisibility(View.GONE);
                    ACTOTRO = null;


                }
                break;

        }

    }












    //Seleccion de material de pared
    public void clickMaterialpared(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioMaderapard:
                if (checked) {
                    txtOtropared.setVisibility(View.GONE);
                    edtOtromatpared.setVisibility(View.GONE);

                    MATVIVPARED = radioMaderapard.getText().toString();

                }

                break;



            case R.id.radioBlockpard:
                if (checked) {
                    txtOtropared.setVisibility(View.GONE);
                    edtOtromatpared.setVisibility(View.GONE);
                    MATVIVPARED = radioBlockpard.getText().toString();

                }

                break;



            case R.id.radioAdobepard:
                if (checked) {
                    txtOtropared.setVisibility(View.GONE);
                    edtOtromatpared.setVisibility(View.GONE);
                    MATVIVPARED = radioAdobepard.getText().toString();

                }

                break;



            case R.id.radioOtropard:
                if (checked) {
                    txtOtropared.setVisibility(View.VISIBLE);
                    edtOtromatpared.setVisibility(View.VISIBLE);
                    MATVIVPARED = radioOtropard.getText().toString();

                }

                break;


        }

    }


    public Boolean validaMaterialpared(){
        if(MATVIVPARED == null){
            return true;

        }else if(MATVIVPARED != null){
            return false;
        }
        return false;
    }



    public void otroParedmaterial(){
        if(MATVIVPARED.equals("Otro")){
            MARVIVPOTRO = edtOtromatpared.getText().toString();
        }else {
            MARVIVPOTRO = null;
        }
    }



    public void otroTechomaterial(){
        if(materialTecho.getSelectedItem().toString().equals("Otro material")){
            MATVIVTECOTRO = edtOtrotec.getText().toString();
        }else {
            MATVIVTECOTRO = null;
        }

    }


    public void otroPisoMaterial(){
        if(materialPiso.getSelectedItem().toString().equals("Otro material")){
            MATVIVPISOTRO = edtOtropiso.getText().toString();
        }else {
            MATVIVPISOTRO = null;
        }

    }



    //Metodo para saber si cuenta con cocina
    public void clickCocina(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioCocina:
                if (checked) {
                    TIENECOCINA = "Sí";

                }

                break;



            case R.id.radioNococina:
                if (checked) {
                    TIENECOCINA = "No";

                }

                break;


        }

    }



    //METODO DE VALIDACION COCINA
    public Boolean validaCocina(){
        if(TIENECOCINA == null){

            return true;
        } else if (TIENECOCINA != null){

            return false;
        }
        return false;
    }



    //Valida cuartos
    public Boolean cantidadCuartos(){
        if (edtCantidadcuartos.getText().toString().isEmpty()){
            return true;
        } else if(!edtCantidadcuartos.getText().toString().isEmpty()){
            CUANTOSCUARTOS = edtCantidadcuartos.getText().toString();

            return false;

        }

        return false;
    }




    //Metodo para saber si cuenta con baño-letrina
    public void clickBanioletrina(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioBanio:
                if (checked) {
                    BANIOLETRINA = "Baño";

                }

                break;



            case R.id.radioLetrina:
                if (checked) {
                    BANIOLETRINA = "Letrina";

                }

                break;


        }

    }





    //Metodo posibles servicios en el hogar

    public void clickServiciosvivienda(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkServdrenaje:
                if (checked) {
                    SERVDRENAJE = "Drenaje";

                } else {
                    SERVDRENAJE = null;
                }
                break;


            case R.id.checkServteleffijo:
                if (checked) {
                    SERVTELEFONO = "Teléfono fijo";

                } else {
                    SERVTELEFONO = null;
                }
                break;


            case R.id.checkServaguapot:
                if (checked) {
                    SERVAGUA = "Agua potable";

                } else {
                    SERVAGUA = null;
                }
                break;


            case R.id.checkServinternet:
                if (checked) {
                    SERVINTERNET = "Internet";

                } else {
                    SERVINTERNET = null;
                }
                break;


            case R.id.checkServelect:
                if (checked) {
                    SERVELECTRICIDAD = "Electricidad";

                } else {
                    SERVELECTRICIDAD = null;
                }
                break;
        }
    }


    @Override
    public void onBackPressed() {

    }
}
