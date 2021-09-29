package com.example.geosegalmex.Pecuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.Pecuario.GlobalPecuario.GlobalPecuario;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

public class PecuarioManejoAgostadero extends AppCompatActivity {

    //Variables locales
    //Pecuario Manejo de agostadero tabla
    private String PECUDIVPOTRERO = null;
    private String PECUCERCOELECT = null;
    private String PECUAJUSTCARGA = null;
    private String PECUPASTROTACI = null;
    private String PECUMANEJOEXTE = null;
    private String PECUCONTABREVAD = null;
    private String PECUCANTIDABREV = null;


    private String PECUPRODFORREJ = null;
    private String PECUPRODCONCOM = null;
    private String PECUPRODENSILA = null;
    private String PECUPRODHENOS = null;
    private String PECUPRODMINERAL = null;
    private String PECUPRODGRANOS = null;
    private String PECUPRODUCOTROS = null;
    private String PECUPRODUEDTOTR = null;
    private String PECUPRODUCNINGUN = null;


    private String PECUSEQPROLONG = null;
    private String PECUPOCADISPON = null;
    private String PECUMUYCAROSADQ = null;
    private String PECUPOCOTERRENO = null;
    private String PECUNOCONTRECUR = null;
    private String PECUNOTENERCAPAC = null;
    private String PECUINSUFICMANOB = null;
    private String PECUTIERRAPOCVAL = null;
    private String PECUOTROPROBLEMF = null;
    private String PECUEDTOTPROBLEMF = null;

    private String PECUSUPLCOSTOCONC = null;
    private String PECUSUPLPOCDISPON = null;
    private String PECUSUPLDIETNOBAL = null;
    private String PECUSUPLNOTENCONOC = null;
    private String PECUSUPLMUSCBLANCO = null;
    private String PECUSUPLEMOTRO = null;
    private String PECUEDTSUPLOTROESP = null;



    TextView txtPecuariomanejoagostaderocuentaabrevaderosotro;
    EditText edtPecuariomanejoagostaderocuentaabrevaderosotro;

    EditText edtPecuariomanejoproduceotros;

    EditText edtProblemasforrajesalimentacotro;

    EditText edtProblemasforrajesalimentacsupotro;




    Button btnPecumanejoagosta;
    Button btnPecuadquierealm;


    //BASE DE DATOS
    private DatabaseHelper baseBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pecuario_manejo_agostadero);

        txtPecuariomanejoagostaderocuentaabrevaderosotro =  (TextView) findViewById(R.id.txtPecuariomanejoagostaderocuentaabrevaderosotro);
        edtPecuariomanejoagostaderocuentaabrevaderosotro =  (EditText)findViewById(R.id.edtPecuariomanejoagostaderocuentaabrevaderosotro);


        edtPecuariomanejoproduceotros = (EditText)findViewById(R.id.edtPecuariomanejoproduceotros);

        edtProblemasforrajesalimentacotro = (EditText)findViewById(R.id.edtProblemasforrajesalimentacotro);

        edtProblemasforrajesalimentacsupotro = (EditText)findViewById(R.id.edtProblemasforrajesalimentacsupotro);

        btnPecumanejoagosta = (Button)findViewById(R.id.pecuario_next_manejo_agostadero);
        btnPecuadquierealm = (Button)findViewById(R.id.pecuario_next_adquiere_alimentos);




        //BD
        baseBD         = new DatabaseHelper(this);


        btnPecumanejoagosta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                GlobalPecuario.PECUDIVPOTRERO = PECUDIVPOTRERO;
                GlobalPecuario.PECUCERCOELECT = PECUCERCOELECT;
                GlobalPecuario.PECUAJUSTCARGA = PECUAJUSTCARGA;
                GlobalPecuario.PECUPASTROTACI = PECUPASTROTACI;
                GlobalPecuario.PECUMANEJOEXTE = PECUMANEJOEXTE;
                GlobalPecuario.PECUCONTABREVAD = PECUCONTABREVAD;
                obtenerValoresagralimentos();
                GlobalPecuario.PECUCANTIDABREV = PECUCANTIDABREV;



                GlobalPecuario.PECUPRODFORREJ = PECUPRODFORREJ;
                GlobalPecuario.PECUPRODCONCOM = PECUPRODCONCOM;
                GlobalPecuario.PECUPRODENSILA = PECUPRODENSILA;
                GlobalPecuario.PECUPRODHENOS = PECUPRODHENOS;
                GlobalPecuario.PECUPRODMINERAL = PECUPRODMINERAL;
                GlobalPecuario.PECUPRODGRANOS = PECUPRODGRANOS;
                GlobalPecuario.PECUPRODUCOTROS = PECUPRODUCOTROS;
                GlobalPecuario.PECUPRODUCNINGUN = PECUPRODUCNINGUN;
                obtenerValorproducotroalimento();
                GlobalPecuario.PECUPRODUEDTOTR = PECUPRODUEDTOTR;



                GlobalPecuario.PECUSEQPROLONG = PECUSEQPROLONG;
                GlobalPecuario.PECUPOCADISPON = PECUPOCADISPON;
                GlobalPecuario.PECUMUYCAROSADQ = PECUMUYCAROSADQ;
                GlobalPecuario.PECUPOCOTERRENO = PECUPOCOTERRENO;
                GlobalPecuario.PECUNOCONTRECUR = PECUNOCONTRECUR;
                GlobalPecuario.PECUNOTENERCAPAC = PECUNOTENERCAPAC;
                GlobalPecuario.PECUINSUFICMANOB = PECUINSUFICMANOB;
                GlobalPecuario.PECUTIERRAPOCVAL = PECUTIERRAPOCVAL;
                GlobalPecuario.PECUOTROPROBLEMF = PECUOTROPROBLEMF;
                obtenerEdtotroprobareafor();
                GlobalPecuario.PECUEDTOTPROBLEMF = PECUEDTOTPROBLEMF;



                GlobalPecuario.PECUSUPLCOSTOCONC = PECUSUPLCOSTOCONC;
                GlobalPecuario.PECUSUPLPOCDISPON = PECUSUPLPOCDISPON;
                GlobalPecuario.PECUSUPLDIETNOBAL = PECUSUPLDIETNOBAL;
                GlobalPecuario.PECUSUPLNOTENCONOC = PECUSUPLNOTENCONOC;
                GlobalPecuario.PECUSUPLMUSCBLANCO = PECUSUPLMUSCBLANCO;
                GlobalPecuario.PECUSUPLEMOTRO = PECUSUPLEMOTRO;
                obtenerEdtsuplementocomotro();
                GlobalPecuario.PECUEDTSUPLOTROESP = PECUEDTSUPLOTROESP;



                agregaManejoagostadero();
                Toast.makeText(getApplicationContext(), "Agregado correctamente ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PecuarioManejoAgostadero.this, PecuarioReproduccionGenetica.class));
                finish();
            }
        });




        btnPecuadquierealm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PecuarioManejoAgostadero.this, PecuarioAgregarAlimentos.class));
            }
        });
    }




    //INSERCION DE DATOS
    public void agregaManejoagostadero(){

        addManejoagostadero();

    }




    ///Agregar manejo de agostadero

    private void addManejoagostadero(){
        boolean insertarData = baseBD.addPecumanejoagostadero();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }



    //Metodo division potreros
    public void clickdivisionpotrero(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioPecuariomanejoagostaderodivpotrerossi:
                if (checked) {
                    PECUDIVPOTRERO = "Sí";

                }

                break;


            case R.id.radioPecuariomanejoagostaderodivpotrerosno:
                if (checked) {
                    PECUDIVPOTRERO = "No";

                }

                break;


        }

    }



    //Metodo cerco electrico
    public void clickcercoelectric(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioPecuariomanejoagostaderocercoelectricosi:
                if (checked) {
                    PECUCERCOELECT = "Sí";

                }

                break;


            case R.id.radioPecuariomanejoagostaderocercoelectricono:
                if (checked) {
                    PECUCERCOELECT = "No";

                }

                break;


        }

    }


    //Metodo ajuste de carga
    public void clickajustecarga(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioPecuariomanejoagostaderoajustecargaanimalsi:
                if (checked) {
                    PECUAJUSTCARGA = "Sí";

                }

                break;


            case R.id.radioPecuariomanejoagostaderoajustecargaanimalno:
                if (checked) {
                    PECUAJUSTCARGA = "No";

                }

                break;


        }

    }


    //Metodo pastoreo rotacional
    public void clickpastorrotac(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioPecuariomanejoagostaderopastoreorotacionalsi:
                if (checked) {
                    PECUPASTROTACI = "Sí";

                }

                break;


            case R.id.radioPecuariomanejoagostaderopastoreorotacionalno:
                if (checked) {
                    PECUPASTROTACI = "No";

                }

                break;


        }

    }


    //Metodo manejo extensivo
    public void clickmanejoext(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioPecuariomanejoagostaderomanejoextensivosi:
                if (checked) {
                    PECUMANEJOEXTE = "Sí";

                }

                break;


            case R.id.radioPecuariomanejoagostaderomanejoextensivono:
                if (checked) {
                    PECUMANEJOEXTE = "No";

                }

                break;


        }

    }




    //Metodo cuenta con abrevaderos
    public void clickcontarabrevaderos(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioPecuariomanejoagostaderocuentaabrevaderossi:
                if (checked) {
                    PECUCONTABREVAD = "Sí";
                    txtPecuariomanejoagostaderocuentaabrevaderosotro.setVisibility(View.VISIBLE);
                    edtPecuariomanejoagostaderocuentaabrevaderosotro.setVisibility(View.VISIBLE);

                }

                break;


            case R.id.radioPecuariomanejoagostaderocuentaabrevaderosno:
                if (checked) {
                    PECUCONTABREVAD = "No";
                    txtPecuariomanejoagostaderocuentaabrevaderosotro.setVisibility(View.GONE);
                    edtPecuariomanejoagostaderocuentaabrevaderosotro.setVisibility(View.GONE);

                }

                break;


        }

    }


    public void obtenerValoresagralimentos(){


        if(!edtPecuariomanejoagostaderocuentaabrevaderosotro.getText().toString().isEmpty()){
            PECUCANTIDABREV = edtPecuariomanejoagostaderocuentaabrevaderosotro.getText().toString();
        } else{
            PECUCANTIDABREV = null;
        }
    }



    //Metodo produce alimentos rancho
    public void clickproduceranchoalim(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.chPecuariomanejoproduceforraje:
                if (checked) {
                    PECUPRODFORREJ = "Sí";

                }else{
                    PECUPRODFORREJ = null;
                }

                break;


            case R.id.radioPecuariomanejoproduceconccomerc:
                if (checked) {
                    PECUPRODCONCOM = "Sí";

                }else{
                    PECUPRODCONCOM = null;
                }

                break;



            case R.id.radioPecuariomanejoproduceensilados:
                if (checked) {
                    PECUPRODENSILA = "Sí";

                }else{
                    PECUPRODENSILA = null;
                }

                break;




            case R.id.radioPecuariomanejoproducehenos:
                if (checked) {
                    PECUPRODHENOS = "Sí";

                }else{
                    PECUPRODHENOS = null;
                }

                break;



            case R.id.radioPecuariomanejoproduceminerales:
                if (checked) {
                    PECUPRODMINERAL = "Sí";

                }else{
                    PECUPRODMINERAL = null;
                }

                break;



            case R.id.radioPecuariomanejoproducegranos:
                if (checked) {
                    PECUPRODGRANOS = "Sí";

                }else{
                    PECUPRODGRANOS = null;
                }

                break;



            case R.id.radioPecuariomanejoproduceotros:
                if (checked) {
                    edtPecuariomanejoproduceotros.setVisibility(View.VISIBLE);
                    PECUPRODUCOTROS = "Sí";


                }else{
                    edtPecuariomanejoproduceotros.setVisibility(View.GONE);
                    PECUPRODUCOTROS = null;
                }

                break;




            case R.id.radioPecuariomanejoproducenoproduce:
                if (checked) {
                    PECUPRODUCNINGUN = "Sí";

                }else{
                    PECUPRODUCNINGUN = null;
                }

                break;
        }

    }



    public void obtenerValorproducotroalimento(){

        if(!edtPecuariomanejoproduceotros.getText().toString().isEmpty()){
            PECUPRODUEDTOTR = edtPecuariomanejoproduceotros.getText().toString();
        } else{
            PECUPRODUEDTOTR = null;
        }
    }





    //Metodo Principales problemas area de forrajes
    public void clickproblemareaforrajes(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkProblemasforrajesalimentacsequias:
                if (checked) {
                    PECUSEQPROLONG = "Sí";

                }else{
                    PECUSEQPROLONG = null;
                }

                break;


            case R.id.checkProblemasforrajesalimentacpocadisp:
                if (checked) {
                    PECUPOCADISPON = "Sí";

                }else{
                    PECUPOCADISPON = null;
                }

                break;



            case R.id.checkProblemasforrajesalimentacmuycaros:
                if (checked) {
                    PECUMUYCAROSADQ = "Sí";

                }else{
                    PECUMUYCAROSADQ = null;
                }

                break;




            case R.id.checkProblemasforrajesalimentacpocoterreno:
                if (checked) {
                    PECUPOCOTERRENO = "Sí";

                }else{
                    PECUPOCOTERRENO = null;
                }

                break;



            case R.id.checkProblemasforrajesalimentacnorecursosprod:
                if (checked) {
                    PECUNOCONTRECUR = "Sí";

                }else{
                    PECUNOCONTRECUR = null;
                }

                break;



            case R.id.checkProblemasforrajesalimentacnocapacidad:
                if (checked) {
                    PECUNOTENERCAPAC = "Sí";

                }else{
                    PECUNOTENERCAPAC = null;
                }

                break;



            case R.id.checkProblemasforrajesalimentacinsuficmano:
                if (checked) {

                    PECUINSUFICMANOB = "Sí";


                }else{

                    PECUINSUFICMANOB = null;
                }

                break;




            case R.id.checkProblemasforrajesalimentactierrapoconutric:
                if (checked) {
                    PECUTIERRAPOCVAL = "Sí";

                }else{
                    PECUTIERRAPOCVAL = null;
                }

                break;



            case R.id.checkProblemasforrajesalimentacotro:
                if (checked) {
                    edtProblemasforrajesalimentacotro.setVisibility(View.VISIBLE);
                    PECUOTROPROBLEMF = "Sí";

                }else{
                    edtProblemasforrajesalimentacotro.setVisibility(View.GONE);
                    PECUOTROPROBLEMF = null;
                }

                break;
        }

    }



    public void obtenerEdtotroprobareafor(){

        if(!edtProblemasforrajesalimentacotro.getText().toString().isEmpty()){
            PECUEDTOTPROBLEMF = edtProblemasforrajesalimentacotro.getText().toString();
        } else{
            PECUEDTOTPROBLEMF = null;
        }
    }






    //Metodo Principales problemas area de forrajes
    public void clicksuplementoscomerc(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkProblemasforrajesalimentaccostosconc:
                if (checked) {
                    PECUSUPLCOSTOCONC = "Sí";

                }else{
                    PECUSUPLCOSTOCONC = null;
                }

                break;


            case R.id.checkProblemasforrajesalimentacpocadisponib:
                if (checked) {
                    PECUSUPLPOCDISPON = "Sí";

                }else{
                    PECUSUPLPOCDISPON = null;
                }

                break;



            case R.id.checkProblemasforrajesalimentacnodietas:
                if (checked) {
                    PECUSUPLDIETNOBAL = "Sí";

                }else{
                    PECUSUPLDIETNOBAL = null;
                }

                break;




            case R.id.checkProblemasforrajesalimentacnoconocdietas:
                if (checked) {
                    PECUSUPLNOTENCONOC = "Sí";

                }else{
                    PECUSUPLNOTENCONOC = null;
                }

                break;



            case R.id.checkProblemasforrajesalimentacmusculonlanco:
                if (checked) {
                    PECUSUPLMUSCBLANCO = "Sí";

                }else{
                    PECUSUPLMUSCBLANCO = null;
                }

                break;



            case R.id.checkProblemasforrajesalimentacsupotro:
                if (checked) {
                    edtProblemasforrajesalimentacsupotro.setVisibility(View.VISIBLE);
                    PECUSUPLEMOTRO = "Sí";

                }else{
                    edtProblemasforrajesalimentacsupotro.setVisibility(View.GONE);
                    PECUSUPLEMOTRO = null;
                }

                break;

        }

    }



    public void obtenerEdtsuplementocomotro(){

        if(!edtProblemasforrajesalimentacsupotro.getText().toString().isEmpty()){
            PECUEDTSUPLOTROESP = edtProblemasforrajesalimentacsupotro.getText().toString();
        } else{
            PECUEDTSUPLOTROESP = null;
        }
    }


    @Override
    public void onBackPressed() {

    }


}
