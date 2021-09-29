package com.example.geosegalmex.Pecuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.Pecuario.GlobalPecuario.GlobalPecuario;
import com.example.geosegalmex.R;

public class PecuarioReproduccionGenetica extends AppCompatActivity {

    //Variables locales
    //Pecuario Reproduccion Genetica
    private String REPRODMONTLIBRE = null;
    private String REPRODMONTCONTRL = null;
    private String REPRODMONTAINSEM = null;
    private String REPRODMONTAINSART = null;
    private String REPRODSINCRHEMBR = null;
    private String REPRODDIAGNGESTAC = null;
    private String REPRODFERTSEMENT = null;
    private String REPRODINSEMINPROD = null;
    private String REPRODOTROESPECIF = null;
    private String REPRODEDTOTROESPEC = null;


    private String REPRPROBPOCPART = null;
    private String REPRPROBHEMBTCAR = null;
    private String REPRPROBABORTOS = null;
    private String REPRPROBCOSTOTEC = null;
    private String REPRPROBCAPACINO = null;
    private String REPRPROBPOCADISP = null;
    private String REPRPROBOTROESPC = null;
    private String REPRPROBOTROEDTESP = null;

    private String REPRGENEVALSEM = null;
    private String REPRGENADAPGAN = null;
    private String REPRGENCAPCRUZ = null;
    private String REPRGENDISPSEM = null;
    private String REPRGENOTROPRO = null;
    private String REPRGENEDTOTRO = null;


    Button btnPecureprodgenetica;

    //EditText
    EditText edtReproductgenpecumontalibre;
    EditText edtReproductgenpecumontacontrolada;
    EditText edtReproductgenpecuinseminacionarta;
    EditText edtReproductgenpecumontaeinseminacionart;
    EditText edtReproductgenpecusincrohermbras;
    EditText edtReproductgenpecudiaggestac;
    EditText edtReproductgenpecuevafertilsemntales;
    EditText edtReproductgenpecuinseminacporproductor;
    EditText edtReproductgenpecuotroespec;
    EditText edtReproductgenpecuotro;

    EditText edtProblemasreproducgeneticaotro;

    EditText edtProblemasreproducgeneticaotrogen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pecuario_reproduccion_genetica);

        //EditText
        edtReproductgenpecumontalibre = (EditText) findViewById(R.id.edtReproductgenpecumontalibre);
        edtReproductgenpecumontacontrolada = (EditText) findViewById(R.id.edtReproductgenpecumontacontrolada);
        edtReproductgenpecuinseminacionarta = (EditText) findViewById(R.id.edtReproductgenpecuinseminacionarta);
        edtReproductgenpecumontaeinseminacionart = (EditText) findViewById(R.id.edtReproductgenpecumontaeinseminacionart);
        edtReproductgenpecusincrohermbras = (EditText) findViewById(R.id.edtReproductgenpecusincrohermbras);
        edtReproductgenpecudiaggestac = (EditText) findViewById(R.id.edtReproductgenpecudiaggestac);
        edtReproductgenpecuevafertilsemntales = (EditText) findViewById(R.id.edtReproductgenpecuevafertilsemntales);
        edtReproductgenpecuinseminacporproductor = (EditText) findViewById(R.id.edtReproductgenpecuinseminacporproductor);
        edtReproductgenpecuotroespec = (EditText) findViewById(R.id.edtReproductgenpecuotroespec);
        edtReproductgenpecuotro = (EditText) findViewById(R.id.edtReproductgenpecuotro);

        edtProblemasreproducgeneticaotro = (EditText) findViewById(R.id.edtProblemasreproducgeneticaotro);

        edtProblemasreproducgeneticaotrogen = (EditText) findViewById(R.id.edtProblemasreproducgeneticaotrogen);




        //Boton
        btnPecureprodgenetica = (Button)findViewById(R.id.pecuario_next_reproduccion_gen);




        btnPecureprodgenetica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                obtenerReproduccgenetica();
                GlobalPecuario.REPRODMONTLIBRE = REPRODMONTLIBRE;
                GlobalPecuario.REPRODMONTCONTRL = REPRODMONTCONTRL;
                GlobalPecuario.REPRODMONTAINSEM = REPRODMONTAINSEM;
                GlobalPecuario.REPRODMONTAINSART = REPRODMONTAINSART;
                GlobalPecuario.REPRODSINCRHEMBR = REPRODSINCRHEMBR;
                GlobalPecuario.REPRODDIAGNGESTAC = REPRODDIAGNGESTAC;
                GlobalPecuario.REPRODFERTSEMENT = REPRODFERTSEMENT;
                GlobalPecuario.REPRODINSEMINPROD = REPRODINSEMINPROD;
                GlobalPecuario.REPRODOTROESPECIF = REPRODOTROESPECIF;
                GlobalPecuario.REPRODEDTOTROESPEC = REPRODEDTOTROESPEC;



                GlobalPecuario.REPRPROBPOCPART = REPRPROBPOCPART;
                GlobalPecuario.REPRPROBHEMBTCAR = REPRPROBHEMBTCAR;
                GlobalPecuario.REPRPROBABORTOS = REPRPROBABORTOS;
                GlobalPecuario.REPRPROBCOSTOTEC = REPRPROBCOSTOTEC;
                GlobalPecuario.REPRPROBCAPACINO = REPRPROBCAPACINO;
                GlobalPecuario.REPRPROBPOCADISP = REPRPROBPOCADISP;
                GlobalPecuario.REPRPROBOTROESPC = REPRPROBOTROESPC;
                obtenerOtroproblemreprod();
                GlobalPecuario.REPRPROBOTROEDTESP = REPRPROBOTROEDTESP;


                GlobalPecuario.REPRGENEVALSEM = REPRGENEVALSEM;
                GlobalPecuario.REPRGENADAPGAN = REPRGENADAPGAN;
                GlobalPecuario.REPRGENCAPCRUZ = REPRGENCAPCRUZ;
                GlobalPecuario.REPRGENDISPSEM = REPRGENDISPSEM;
                GlobalPecuario.REPRGENOTROPRO = REPRGENOTROPRO;
                obtenerOtroproblemgenet();
                GlobalPecuario.REPRGENEDTOTRO = REPRGENEDTOTRO;
                Toast.makeText(getApplicationContext(), "Agregado correctamente ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PecuarioReproduccionGenetica.this, PecuarioParamProdReproductivos.class));
                finish();
            }
        });
    }




    //Metodo de PRACTICAS DE MANEJO REPRODUCTIVO
    public void clickpractmanreproduct(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkReproductgenpecumontalibre:
                if (checked) {
                    edtReproductgenpecumontalibre.setVisibility(View.VISIBLE);

                }else{
                    edtReproductgenpecumontalibre.setVisibility(View.GONE);
                }

                break;


            case R.id.checkReproductgenpecumontacontrolada:
                if (checked) {
                    edtReproductgenpecumontacontrolada.setVisibility(View.VISIBLE);

                }else{
                    edtReproductgenpecumontacontrolada.setVisibility(View.GONE);
                }

                break;


            case R.id.checkReproductgenpecuinseminacionart:
                if (checked) {
                    edtReproductgenpecuinseminacionarta.setVisibility(View.VISIBLE);

                }else{
                    edtReproductgenpecuinseminacionarta.setVisibility(View.GONE);
                }

                break;


            case R.id.checkReproductgenpecumontaeinseminacionart:
                if (checked) {
                    edtReproductgenpecumontaeinseminacionart.setVisibility(View.VISIBLE);

                }else{
                    edtReproductgenpecumontaeinseminacionart.setVisibility(View.GONE);
                }

                break;


            case R.id.checkReproductgenpecusincrohermbras:
                if (checked) {
                    edtReproductgenpecusincrohermbras.setVisibility(View.VISIBLE);

                }else{
                    edtReproductgenpecusincrohermbras.setVisibility(View.GONE);
                }

                break;



            case R.id.checkReproductgenpecudiaggestac:
                if (checked) {
                    edtReproductgenpecudiaggestac.setVisibility(View.VISIBLE);

                }else{
                    edtReproductgenpecudiaggestac.setVisibility(View.GONE);
                }

                break;



            case R.id.checkReproductgenpecuevafertilsemntales:
                if (checked) {
                    edtReproductgenpecuevafertilsemntales.setVisibility(View.VISIBLE);

                }else{
                    edtReproductgenpecuevafertilsemntales.setVisibility(View.GONE);
                }

                break;


            case R.id.checkReproductgenpecuinseminacporproductor:
                if (checked) {
                    edtReproductgenpecuinseminacporproductor.setVisibility(View.VISIBLE);

                }else{
                    edtReproductgenpecuinseminacporproductor.setVisibility(View.GONE);
                }

                break;


            case R.id.checkReproductgenpecuotro:
                if (checked) {
                    edtReproductgenpecuotroespec.setVisibility(View.VISIBLE);
                    edtReproductgenpecuotro.setVisibility(View.VISIBLE);

                }else{
                    edtReproductgenpecuotroespec.setVisibility(View.GONE);
                    edtReproductgenpecuotro.setVisibility(View.GONE);
                }

                break;


        }

    }





    public void obtenerReproduccgenetica(){

        if(!edtReproductgenpecumontalibre.getText().toString().isEmpty()){
            REPRODMONTLIBRE = edtReproductgenpecumontalibre.getText().toString();
        } else{
            REPRODMONTLIBRE = null;
        }


        if(!edtReproductgenpecumontacontrolada.getText().toString().isEmpty()){
            REPRODMONTCONTRL = edtReproductgenpecumontacontrolada.getText().toString();
        } else{
            REPRODMONTCONTRL = null;
        }



        if(!edtReproductgenpecuinseminacionarta.getText().toString().isEmpty()){
            REPRODMONTAINSEM = edtReproductgenpecuinseminacionarta.getText().toString();
        } else{
            REPRODMONTAINSEM = null;
        }


        if(!edtReproductgenpecumontaeinseminacionart.getText().toString().isEmpty()){
            REPRODMONTAINSART = edtReproductgenpecumontaeinseminacionart.getText().toString();
        } else{
            REPRODMONTAINSART = null;
        }



        if(!edtReproductgenpecusincrohermbras.getText().toString().isEmpty()){
            REPRODSINCRHEMBR = edtReproductgenpecusincrohermbras.getText().toString();
        } else{
            REPRODSINCRHEMBR = null;
        }



        if(!edtReproductgenpecudiaggestac.getText().toString().isEmpty()){
            REPRODDIAGNGESTAC = edtReproductgenpecudiaggestac.getText().toString();
        } else{
            REPRODDIAGNGESTAC = null;
        }


        if(!edtReproductgenpecuevafertilsemntales.getText().toString().isEmpty()){
            REPRODFERTSEMENT = edtReproductgenpecuevafertilsemntales.getText().toString();
        } else{
            REPRODFERTSEMENT = null;
        }



        if(!edtReproductgenpecuinseminacporproductor.getText().toString().isEmpty()){
            REPRODINSEMINPROD = edtReproductgenpecuinseminacporproductor.getText().toString();
        } else{
            REPRODINSEMINPROD = null;
        }



        if(!edtReproductgenpecuotroespec.getText().toString().isEmpty()){
            REPRODOTROESPECIF = edtReproductgenpecuotroespec.getText().toString();
        } else{
            REPRODOTROESPECIF = null;
        }



        if(!edtReproductgenpecuotro.getText().toString().isEmpty()){
            REPRODEDTOTROESPEC = edtReproductgenpecuotro.getText().toString();
        } else{
            REPRODEDTOTROESPEC = null;
        }

    }





    //PROBLEMAS AQUEJAN REPRODUCCION Y GENETICA
    public void clickproblrepgenetica(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkProblemasreproducgeneticapocospartos:
                if (checked) {
                    REPRPROBPOCPART = "Pocos partos al año";

                }else{
                    REPRPROBPOCPART = null;
                }

                break;


            case R.id.checkProblemasreproducgeneticahembrasnocargan:
                if (checked) {
                    REPRPROBHEMBTCAR = "Las hembras tardan mucho en cargar después del parto";

                }else{
                    REPRPROBHEMBTCAR = null;
                }

                break;


            case R.id.checkProblemasreproducgeneticaabortos:
                if (checked) {
                    REPRPROBABORTOS = "Abortos";

                }else{
                    REPRPROBABORTOS = null;
                }

                break;


            case R.id.checkProblemasreproducgeneticacostotec:
                if (checked) {
                    REPRPROBCOSTOTEC = "Costo de tecnología (inseminación, etc.)";

                }else{
                    REPRPROBCOSTOTEC = null;
                }

                break;


            case R.id.checkProblemasreproducgeneticanocapacitac:
                if (checked) {
                    REPRPROBCAPACINO = "Capacitación (No tiene o es insuficiente)";
                }else{
                    REPRPROBCAPACINO = null;
                }

                break;



            case R.id.checkProblemasreproducgeneticapocadispon:
                if (checked) {
                    REPRPROBPOCADISP = "Poca disponibilidad de técnicos o expertos ";

                }else{
                    REPRPROBPOCADISP = null;
                }

                break;



            case R.id.checkProblemasreproducgeneticaotro:
                if (checked) {
                    edtProblemasreproducgeneticaotro.setVisibility(View.VISIBLE);
                    REPRPROBOTROESPC = "Otro (especificar)";


                }else{
                    edtProblemasreproducgeneticaotro.setVisibility(View.GONE);
                    REPRPROBOTROESPC = null;
                }

                break;


        }

    }


    public void obtenerOtroproblemreprod(){


        if(!edtProblemasreproducgeneticaotro.getText().toString().isEmpty()){
            REPRPROBOTROEDTESP = edtProblemasreproducgeneticaotro.getText().toString();
        } else{
            REPRPROBOTROEDTESP = null;
        }
    }



    //PROBLEMAS REPRODUCCION GENETICA
    public void clickproblgenetica(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkProblemasreproducgeneticaevaluacsem:
                if (checked) {
                    REPRGENEVALSEM = "Evaluación de sementales";

                }else{
                    REPRGENEVALSEM = null;
                }

                break;


            case R.id.checkProblemasreproducgeneticaadaptganado:
                if (checked) {
                    REPRGENADAPGAN = "Adaptación del ganado";

                }else{
                    REPRGENADAPGAN = null;
                }

                break;


            case R.id.checkProblemasreproducgeneticacapcruzas:
                if (checked) {
                    REPRGENCAPCRUZ = "Capacitación para realizar cruzas";

                }else{
                    REPRGENCAPCRUZ = null;
                }

                break;


            case R.id.checkProblemasreproducgeneticasemcalidad:
                if (checked) {
                    REPRGENDISPSEM = "Disponibilidad de semen de calidad";

                }else{
                    REPRGENDISPSEM = null;
                }

                break;


            case R.id.checkProblemasreproducgeneticaotrogen:
                if (checked) {
                    edtProblemasreproducgeneticaotrogen.setVisibility(View.VISIBLE);
                    REPRGENOTROPRO = "Otro (especificar)";
                }else{
                    edtProblemasreproducgeneticaotrogen.setVisibility(View.GONE);
                    REPRGENOTROPRO = null;
                }

                break;


        }

    }


    public void obtenerOtroproblemgenet(){

        if(!edtProblemasreproducgeneticaotrogen.getText().toString().isEmpty()){
            REPRGENEDTOTRO = edtProblemasreproducgeneticaotrogen.getText().toString();
        } else{
            REPRGENEDTOTRO = null;
        }
    }



    @Override
    public void onBackPressed() {

    }


}
