package com.example.geosegalmex.Productor;

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

import com.example.geosegalmex.General;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

import java.util.Calendar;

//import com.example.geoespaciales.bd.BasedeDatos;

public class ProductorInfo extends AppCompatActivity {

    private int dia, mes, anio, hora, minutos, segundos;


    String foli;


    //Objetos
    //Global objGlobal;
    private DatabaseHelper baseBD;


    //Variables locales para pasar la recoleccion de informacion primera vista
    private String NOMBREPROD = null;
    private String APPATERNO = null;
    private String APMATERNO = null;

    private String SEXOPRODUCTOR = null;
    private String EDADPROD = null;


    //private String SITUACIONEST = null;

    private String SITUACUPF = null;
    private String PUEBLOORIG = null;
    private String CUALPUEBORIG = null;
    private String LENGUAORIG = null;
    private String CUALLENGORIG = null;
    private String SITESTUDIOS = null;

    private String LEEPROD = null;
    private String ESCRIBEPROD = null;




    private String FECHAENC = null; //Texto
    private String FOLIOENC = null;




    //TextView
    TextView textFecha;
    TextView textFolio;


    TextView textSituacestudios;
    TextView txtPuebloori;
    TextView txtLenguaord;


    //Spinner
    //Spinner comboEstados;
    //Spinner comboMunaguasc;
    Spinner miembroUpf;
    Spinner gradosEstudio;
    Spinner puebloOriginario;
    Spinner lenguaOriginario;


    //RadioButton
    RadioButton radioCompleto;
    RadioButton radioIncompleto;

    //RadioButton radioPuebloorig;
    //RadioButton radioNopuebloorig;

    //RadioButton radioLenguaorig;
    //RadioButton radioNolenguaorig;

    //RadioButton radioSexomasc;
    //RadioButton radioSexofem;


    //EditText
    EditText edtNombre;
    EditText edtAppaterno;
    EditText edtApmaterno;
    EditText edtEdad;



    //Boton
    Button btnProdeconom;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productor_info);

        //TextView
        textFecha = (TextView)findViewById(R.id.textFecha);
        textFolio = (TextView) findViewById(R.id.textFolio);
        textSituacestudios = (TextView) findViewById(R.id.textSituacestudios);
        txtPuebloori = (TextView) findViewById(R.id.txtPuebloori);
        txtLenguaord = (TextView) findViewById(R.id.txtLenguaord);




        //RadioButoon
        radioCompleto = (RadioButton)findViewById(R.id.radioCompleto);
        radioIncompleto = (RadioButton)findViewById(R.id.radioIncompleto);

        //radioPuebloorig = (RadioButton)findViewById(R.id.radioPueblo);
        //radioNopuebloorig = (RadioButton)findViewById(R.id.radioNopueblo);

        //radioLenguaorig = (RadioButton)findViewById(R.id.radioLengua);
        //radioNolenguaorig = (RadioButton)findViewById(R.id.radioNolengua);

        //radioSexomasc = (RadioButton)findViewById(R.id.radioSexomasc);
        //radioSexofem = (RadioButton)findViewById(R.id.radioSexofem);




        //comboEstados = (Spinner)findViewById(R.id.idSpinEstados);

        //Objeto
        //objGlobal = (Global)getApplicationContext();



        //EditText
        edtNombre = (EditText)findViewById(R.id.edtNombre);
        edtAppaterno = (EditText)findViewById(R.id.edtAppaterno);
        edtApmaterno = (EditText)findViewById(R.id.edtApmaterno);
        edtEdad = (EditText)findViewById(R.id.edtEdad);



        //Spinner
        //comboMunaguasc = (Spinner)findViewById(R.id.idSpinMunaguasc);
        miembroUpf = (Spinner)findViewById(R.id.idSprelacupfint);
        gradosEstudio = (Spinner)findViewById(R.id.idSpgradoest);


        puebloOriginario = (Spinner)findViewById(R.id.idSppueblorig);
        lenguaOriginario = (Spinner)findViewById(R.id.isSpinLengorig);



        //Boton
        btnProdeconom = (Button)findViewById(R.id.btnAgrproda);

        //BD
        baseBD         = new DatabaseHelper(this);




        //Inicialización de métodos
        muestrafecha();
        obtenFolio();

        //generaIdProductor();


        gradosEstudio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                switch (position) {
                    case 0:
                        textSituacestudios.setVisibility(View.GONE);
                        radioCompleto.setVisibility(View.GONE);
                        radioIncompleto.setVisibility(View.GONE);

                        break;


                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        textSituacestudios.setVisibility(View.VISIBLE);
                        radioCompleto.setVisibility(View.VISIBLE);
                        radioIncompleto.setVisibility(View.VISIBLE);

                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        btnProdeconom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //Boolean valorProductor = false;
                //Boolean valorProductor = nombProd();
                Boolean valorUPF =validaResponsableupf();
                Boolean validaProductor = validaNombProd();
                Boolean valEdad = validadEdad();
                Boolean valPuebloorig = validaPuebloori();
                Boolean validaLengori = validaLenguaori();


                if(!valorUPF && !validaProductor && !valEdad){
                    General.Productorresponsableupf = SITUACUPF;
                    General.ProductorRelacionUpf = miembroUpf.getSelectedItem().toString();

                    //Datos del productor
                    General.NombreProductor = NOMBREPROD;
                    General.AppaternoProductor = APPATERNO;
                    General.ApmaternoProductor = APMATERNO;
                    General.ProductorSexo = SEXOPRODUCTOR;
                    General.ProductorEdad = EDADPROD;
                    General.ProductorLeer = LEEPROD;
                    General.ProductorEscribir = ESCRIBEPROD;

                    General.GradoEstudios = gradosEstudio.getSelectedItem().toString();
                    General.SituacionEstudios = SITESTUDIOS;


                    General.PuebloOriginario = PUEBLOORIG;

                    cualPuebloorig();
                    General.CualPuebloOriginario = CUALPUEBORIG;


                    General.LenguaOriginaria = LENGUAORIG;

                    cualLenguaorig();
                    General.CualLenguaOriginaria = CUALLENGORIG;


                    //sexo = General.ProductorSexo;
                    //sabeLeer = General.ProductorLeer;
                    //sabeEscribir = General.ProductorEscribir;

                    //situacionEstudios = General.SituacionEstudios;
                    //puebloOri = General.PuebloOriginario;

                    //lenguaOri = General.LenguaOriginaria;

                    //guardarValoresProductor();

                    Toast.makeText(getApplicationContext(), "Agregados correctamente ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ProductorInfo.this, ProductorEconom.class));

                    finish();

                }
                else{

                    Toast.makeText(getApplicationContext(), "Faltan datos del productor", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }

    //Metodo para cachar los valores
    private void guardarValoresProductor(){
        //int idproductor =Integer.parseInt(General.Foliocuestion)+100;
        //folioEncuesta = General.Foliocuestion;
        General.ProductorRelacionUpf = miembroUpf.getSelectedItem().toString();

        //Datos del productor

        General.ProductorEdad = edtEdad.getText().toString();
        //sexo = General.ProductorSexo;
        //sabeLeer = General.ProductorLeer;
        //sabeEscribir = General.ProductorEscribir;
        General.GradoEstudios = gradosEstudio.getSelectedItem().toString();
        //situacionEstudios = General.SituacionEstudios;
        //puebloOri = General.PuebloOriginario;
        General.CualPuebloOriginario = puebloOriginario.getSelectedItem().toString();
        //lenguaOri = General.LenguaOriginaria;
        General.CualLenguaOriginaria = lenguaOriginario.getSelectedItem().toString();


        addProductorInfo();

    }



    private void addProductorInfo(){
        boolean insertarData = baseBD.addProductorInformac();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }


    //Metodo para extraer la fecha actual
    public void muestrafecha(){
        Calendar fecha = Calendar.getInstance();
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        mes = fecha.get(Calendar.MONTH);
        anio = fecha.get(Calendar.YEAR);
        textFecha.setText(dia+"/"+(mes+1)+"/"+anio);
    }


    //Metodo para el folio
    public void obtenFolio(){

        foli = General.Foliocuestion;
        //System.out.println("Folio " +foli);
        textFolio.setText(foli);

        /*
       String cveMunicipio = objGlobal.municipio;



        Calendar fecha = Calendar.getInstance();
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        mes = fecha.get(Calendar.MONTH);
        anio = fecha.get(Calendar.YEAR);

        String an = String.valueOf(anio);
        String anior = an.substring(2,4);

        hora = fecha.get(Calendar.HOUR_OF_DAY);
        minutos = fecha.get(Calendar.MINUTE);
        segundos = fecha.get(Calendar.SECOND);



       foli = "DR" +"01"+cveMunicipio+dia+(mes+1)+anior+hora+minutos+segundos;
       textFolio.setText(foli);
       objGlobal.setFoliocuestion(foli);*/

    }


    public void clickPuebloOriginario(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioPueblo:
                if (checked) {
                    txtPuebloori.setVisibility(View.VISIBLE);
                    puebloOriginario.setVisibility(View.VISIBLE);
                    PUEBLOORIG = "Sí";
                }

                break;

            case R.id.radioNopueblo:
                if (checked) {
                    txtPuebloori.setVisibility(View.GONE);
                    puebloOriginario.setVisibility(View.GONE);
                    PUEBLOORIG = "No";
                }
                break;

        }

    }




    public void clickLenguaOriginario(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioLengua:
                if (checked) {
                    txtLenguaord.setVisibility(View.VISIBLE);
                    lenguaOriginario.setVisibility(View.VISIBLE);
                    //General.LenguaOriginaria = radioLenguaorig.getText().toString();
                    LENGUAORIG = "Sí";
                }
                break;

            case R.id.radioNolengua:
                if (checked) {
                    txtLenguaord.setVisibility(View.GONE);
                    lenguaOriginario.setVisibility(View.GONE);
                    //General.LenguaOriginaria = radioNolenguaorig.getText().toString();
                    LENGUAORIG = "No";
                }
                break;

        }

    }


    /*
    private Boolean validaProductor(){
        if(edtNombre.getText().toString().isEmpty()
                || edtAppaterno.getText().toString().isEmpty()
                || edtApmaterno.getText().toString().isEmpty()){

            return true;
        }
        return false;
    }*/

    public void clickSituacionEstudios(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioCompleto:
                if (checked) {
                    //General.SituacionEstudios = radioCompleto.getText().toString();
                    SITESTUDIOS = "Completo";
                }
                break;

            case R.id.radioIncompleto:
                if (checked) {
                    SITESTUDIOS = "Trunco";
                }
                break;

        }

    }


    public void onProductorupf(View v){

        boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId()){

            case R.id.radioSiresponsableupf:
                if (checked) {
                    //General.ProductorUpfradio = "Sí";
                    SITUACUPF = "Sí";
                }
                break;



            case R.id.radioNoresponsableupf:
                if (checked) {
                    //General.ProductorUpfradio = "No";
                    SITUACUPF = "No";
                }
                break;
        }
    }



    public void onProductorsexo(View view){

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioSexomasc:
                if (checked) {

                    SEXOPRODUCTOR = "Masculino";
                }
                break;

            case R.id.radioSexofem:
                if (checked) {

                    SEXOPRODUCTOR = "Femenino";
                }
                break;

        }
    }


    public void onProductorLeer(View v){
        boolean checked = ((RadioButton) v).isChecked();

        switch (v.getId()){

            case R.id.radioLee:
                if (checked) {
                    //General.ProductorLeer = "Sí";
                    LEEPROD = "Sí";
                }
                break;



            case R.id.radioNolee:
                if (checked) {
                    //General.ProductorLeer = "No";
                    LEEPROD = "No";
                }
                break;
        }
    }




    public void onProductorEscribir(View v){
        boolean checked = ((RadioButton) v).isChecked();

        switch (v.getId()){

            case R.id.radioEscrib:
                if (checked) {
                    //General.ProductorEscribir = "Sí";
                    ESCRIBEPROD = "Sí";
                }
                break;



            case R.id.radioNoescrib:
                if (checked) {
                    General.ProductorEscribir = "No";
                    ESCRIBEPROD = "No";
                }
                break;
        }
    }






    private Boolean validaResponsableupf(){
        if (SITUACUPF == null) {
            return true;
        } else if(SITUACUPF != null){

            return false;
        }
        return false;
    }


    private Boolean validaNombProd(){
        if(edtNombre.getText().toString().isEmpty() || edtAppaterno.getText().toString().isEmpty()){
            return true;
        }else if(!edtNombre.getText().toString().isEmpty() || !edtApmaterno.getText().toString().isEmpty()){
            NOMBREPROD = edtNombre.getText().toString();
            APPATERNO = edtAppaterno.getText().toString();
            APMATERNO = edtApmaterno.getText().toString();

            return false;
        }
        return false;
    }


    private Boolean validadEdad(){
        if(edtEdad.getText().toString().isEmpty()){
            return true;
        }else if(!edtEdad.getText().toString().isEmpty()){
            EDADPROD = edtEdad.getText().toString();

            return false;
        }
        return false;
    }


    private Boolean validaPuebloori(){
        if(PUEBLOORIG == null){
            return true;

        }else if(PUEBLOORIG != null){
            return false;
        }
        return false;
    }




    private void cualPuebloorig(){
        if(PUEBLOORIG == "Sí"){
            CUALPUEBORIG =  puebloOriginario.getSelectedItem().toString();
        }else{
            CUALPUEBORIG = null;
        }

    }





    private Boolean validaLenguaori(){
        if(LENGUAORIG == null){
            return true;

        }else if(LENGUAORIG != null){
            return false;
        }
        return false;
    }

    private void cualLenguaorig(){
        if(LENGUAORIG == "Sí"){
            CUALLENGORIG =  lenguaOriginario.getSelectedItem().toString();
        }else{
            CUALLENGORIG = null;
        }

    }




    /*
    //FOLIO DE PRUEBA
    public void generaIdProductor(){

        String foliop = "";
        String cveMunicipio = General.Municipioaguasc;



        Calendar fecha = Calendar.getInstance();
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        mes = fecha.get(Calendar.MONTH);
        anio = fecha.get(Calendar.YEAR);

        String an = String.valueOf(anio);
        String anior = an.substring(2,4);

        hora = fecha.get(Calendar.HOUR_OF_DAY);
        minutos = fecha.get(Calendar.MINUTE);
        segundos = fecha.get(Calendar.SECOND);


        foliop = anior+hora+minutos+segundos+1;
        folioprod = Integer.parseInt(foliop);
        //General.Idproductor = folioprod;


    }
    */


    @Override
    public void onBackPressed() {

    }
}
