package com.example.geosegalmex;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.Georeferencia.GeoreferenciaActivity;
import com.example.geosegalmex.Pecuario.PecuarioInicio;
import com.example.geosegalmex.Productor.ProductorInfo;
import com.example.geosegalmex.apicola.ApicolaInicio;
import com.example.geosegalmex.caracterizacion.ciclo_carac;
import com.example.geosegalmex.drawer.fragment_drawer.bdmunicipios.ModelMunicipios;
import com.example.geosegalmex.drawer.fragment_drawer.bdmunicipios.UtilidadesEdoMunicipios;
import com.example.geosegalmex.frutales.frutales_1;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.hortalizas;
import com.example.geosegalmex.unidadcomercializacion.comercializacion_1;
import com.example.geosegalmex.unidadproduccion.UnidadProduccion;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class IdentificacionCuestionario extends AppCompatActivity {


    private int dia, mes, anio, hora, minutos, segundos;
    private int clEntidad = 0;
    private int clMunicipio = 0;
    private String estadopr = null;
    private String municipio = null;


    TextView textFecha, textHora;
    Button btIrproductor;
    Button botnGoe;
    Button uniProduccion;
    Button caracteriza;
    Button horta;
    Button infraes;
    Button fruta, come, api, pecu;
    ArrayList<ModelMunicipios> datosAzureArrayList;
    ArrayList<String> listaTempMunicipio;
    Spinner municipioProductor;



    //-----------------------------------------
    String foli;
    int bandera = 0;


    private int idcapturista = 0, idproductor = 0;


    //TextView
    TextView textMuestrafolio;
    TextView textFolio;
    TextView textEstado;
    TextView text_estatus;
    TextView text_mod_uso;
    TextView text_cober;
    TextView text_cober2;
    TextView text_cober3;
    TextView text_moda;
    TextView text_observ;
    TextView text_Titulo;
    TextView txtcultivo_esti;
    TextView txtmodalidad_esti;
    TextView txtaltura_esti;
    TextView txtsiniestro_esti;
    TextView txtsuelo_esti;
    TextView txtpredio_esti;
    TextView txtvariedad_esti;
    TextView txtmaleza_esti;
    TextView txtfeno_esti;
    TextView txtcult_esti;
    TextView txtasocia_esti;
    TextView txtasocia_esti2;
    TextView txtnorte_esti;
    TextView txtsur_esti;
    TextView txteste_esti;
    TextView txtoeste_esti;

    //Spinner
    Spinner municipiosag;
    Spinner spi_edo;
    Spinner spi_mun;
    Spinner spi_estatus;
    Spinner spi_mod_uso;
    Spinner spi_cober; //Activo-Agricola
    Spinner spi_cober2; //Activo-Pastos
    Spinner spi_cober3; //Baja
    Spinner spi_moda;
    Spinner spicultivo_esti;
    Spinner spimodalidad_esti;
    Spinner spisiniestro_esti;
    Spinner spisuelo_esti;
    Spinner spipredio_esti;
    Spinner spimaleza_esti;
    Spinner spifeno_esti;
    Spinner spinorte_esti;
    Spinner spisur_esti;
    Spinner spieste_esti;
    Spinner spioeste_esti;

    //EditTex
    EditText editLocalid;
    EditText editProye;
    EditText editcober;
    EditText editObser;
    EditText otro_cultivo_esti;
    EditText editaltura_esti;
    EditText otro_siniestro_esti;
    EditText editvariedad_esti;
    EditText editcult_esti;
    EditText editasocia_esti;
    EditText editasocia_esti2;
    EditText otro_norte_esti;
    EditText otro_sur_esti;
    EditText otro_este_esti;
    EditText otro_oeste_esti;


    // Botones
    //Button btIrproductor;

    //BaseDeDatos
    private DatabaseHelper baseBD;
    private DatabaseHelper bd;
    private String obtMunSect;

    //Cnt Encuesta
    EditText edtCntEncFol;
    Button btnCntEncFol;
    Button btnCntEncFolNext;
    String getCntEncFoli;
    Boolean checkOtrEncs = false;

    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identificacion_cuestionario);


        baseBD                  = new DatabaseHelper(this);
        bd                  = new DatabaseHelper(this);
        datosAzureArrayList = new ArrayList<>();
        listaTempMunicipio = new ArrayList<>();

        textFecha = (TextView)findViewById(R.id.textFecha);
        textHora = (TextView)findViewById(R.id.txtHora);
        btIrproductor = (Button) findViewById(R.id.btnIrprod);
        botnGoe = findViewById(R.id.btnGeoloc);
        uniProduccion = findViewById(R.id.btn_uni_pro);
        caracteriza = findViewById(R.id.btn_caracterizacion_pro);
        horta = findViewById(R.id.btn_hortalizas_pro);
        infraes = findViewById(R.id.btn_infraestructura_pro);
        fruta = findViewById(R.id.btn_frutales_pro);
        come = findViewById(R.id.btn_comercializacion_pro);
        api = findViewById(R.id.btn_apicola_pro);
        pecu = findViewById(R.id.btn_pecuario_pro);
        edtCntEncFol = findViewById(R.id.ed_cnt_enc_fol);
        btnCntEncFol = findViewById(R.id.btn_cnt_enc_fol);
        btnCntEncFolNext = findViewById(R.id.btn_cnt_enc_fol_next);


        btnCntEncFol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCntEncFol.setEnabled(true);
                btnCntEncFolNext.setEnabled(true);
            }
        });

        btnCntEncFolNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtCntEncFol.getText().toString().isEmpty()) {
                    getCntEncFoli = edtCntEncFol.getText().toString();
                    General.Foliocuestion = getCntEncFoli;
                    checkOtrEncs = true;
                    textMuestrafolio.setText(General.Foliocuestion);
                }
                edtCntEncFol.setText("");
                edtCntEncFol.setEnabled(false);
                btnCntEncFolNext.setEnabled(false);

            }
        });


        //---------------------------------------------------
        //Objeto
        //objGlob = (Global)getApplicationContext();
        //obGeneral = new General();

        //BD
      //  baseBD         = new DatabaseHelper(this);

        //TextView
        textMuestrafolio = (TextView)findViewById(R.id.textMuestrafolio);
        text_estatus = (TextView)findViewById(R.id.txtestatus);
        text_mod_uso = (TextView)findViewById(R.id.txtmoduso);
        text_cober = (TextView)findViewById(R.id.txtcobertura);
        text_cober2 = (TextView)findViewById(R.id.txtcobertura2);
        text_cober3 = (TextView)findViewById(R.id.txtcobertura3);
        text_moda = (TextView)findViewById(R.id.txtmodalidad);
        text_observ = (TextView)findViewById(R.id.textView4);
        text_Titulo = (TextView)findViewById(R.id.textTitulo);

        txtcultivo_esti = (TextView)findViewById(R.id.txtcultivo_esti);
        txtmodalidad_esti = (TextView)findViewById(R.id.txtmodalidad_esti);
        txtaltura_esti = (TextView)findViewById(R.id.txtaltura_esti);
        txtsiniestro_esti = (TextView)findViewById(R.id.txtsiniestro_esti);
        txtsuelo_esti = (TextView)findViewById(R.id.txtsuelo_esti);
        txtpredio_esti = (TextView)findViewById(R.id.txtpredio_esti);
        txtvariedad_esti = (TextView)findViewById(R.id.txtvariedad_esti);
        txtmaleza_esti = (TextView)findViewById(R.id.txtmaleza_esti);
        txtfeno_esti = (TextView)findViewById(R.id.txtfeno_esti);
        txtcult_esti = (TextView)findViewById(R.id.txtcult_esti);
        txtasocia_esti = (TextView)findViewById(R.id.txtasocia_esti);
        txtasocia_esti2 = (TextView)findViewById(R.id.txtasocia_esti2);
        txtnorte_esti = (TextView)findViewById(R.id.txtnorte_esti);
        txtsur_esti = (TextView)findViewById(R.id.txtsur_esti);
        txteste_esti = (TextView)findViewById(R.id.txteste_esti);
        txtoeste_esti = (TextView)findViewById(R.id.txtoeste_esti);

        //Spinner
        spi_edo = (Spinner)findViewById(R.id.spi_edo);
        spi_mun = (Spinner)findViewById(R.id.spi_mun);
        municipioProductor  = findViewById(R.id.spi_mun);
        spi_estatus= (Spinner)findViewById(R.id.spiestatus);
        spi_mod_uso= (Spinner)findViewById(R.id.spimoduso);
        spi_cober= (Spinner)findViewById(R.id.spicobertura);
        spi_cober2= (Spinner)findViewById(R.id.spicobertura2);
        spi_cober3= (Spinner)findViewById(R.id.spicobertura3);
        spi_moda= (Spinner)findViewById(R.id.spimodalidad);

        spicultivo_esti = (Spinner)findViewById(R.id.spicultivo_esti);
        spimodalidad_esti = (Spinner)findViewById(R.id.spimodalidad_esti);
        spisiniestro_esti = (Spinner)findViewById(R.id.spisiniestro_esti);
        spisuelo_esti = (Spinner)findViewById(R.id.spisuelo_esti);
        spipredio_esti = (Spinner)findViewById(R.id.spipredio_esti);
        spimaleza_esti = (Spinner)findViewById(R.id.spimaleza_esti);
        spifeno_esti = (Spinner)findViewById(R.id.spifeno_esti);
        spinorte_esti = (Spinner)findViewById(R.id.spinorte_esti);
        spisur_esti = (Spinner)findViewById(R.id.spisur_esti);
        spieste_esti = (Spinner)findViewById(R.id.spieste_esti);
        spioeste_esti = (Spinner)findViewById(R.id.spioeste_esti);

        //EditText
        editLocalid = (EditText)findViewById(R.id.editLocalid);
        editProye = (EditText)findViewById(R.id.edProyec);
        editcober = (EditText)findViewById(R.id.ediotracober);
        editObser = (EditText)findViewById(R.id.observa);

        otro_cultivo_esti = (EditText)findViewById(R.id.otro_cultivo_esti);
        editaltura_esti = (EditText)findViewById(R.id.editaltura_esti);
        otro_siniestro_esti = (EditText)findViewById(R.id.otro_siniestro_esti);
        editvariedad_esti = (EditText)findViewById(R.id.editvariedad_esti);
        editcult_esti = (EditText)findViewById(R.id.editcult_esti);
        editasocia_esti = (EditText)findViewById(R.id.editasocia_esti);
        editasocia_esti2 = (EditText)findViewById(R.id.editasocia_esti2);
        otro_norte_esti = (EditText)findViewById(R.id.otro_norte_esti);
        otro_sur_esti = (EditText)findViewById(R.id.otro_sur_esti);
        otro_este_esti = (EditText)findViewById(R.id.otro_este_esti);
        otro_oeste_esti = (EditText)findViewById(R.id.otro_oeste_esti);

        muestrafecha();
        muestrahora();
        //+++++++++++++++++++++++++++++++++++++++++++++++Tipo de Proyecto+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        if(General.Proyecto.equals("Frontera Agrícola")){
            text_Titulo.setText("Proyecto: FRONTERA AGRÍCOLA");
            txtcultivo_esti.setVisibility(View.GONE);
            txtmodalidad_esti.setVisibility(View.GONE);
            txtaltura_esti.setVisibility(View.GONE);
            txtsiniestro_esti.setVisibility(View.GONE);
            txtsuelo_esti.setVisibility(View.GONE);
            txtpredio_esti.setVisibility(View.GONE);
            txtvariedad_esti.setVisibility(View.GONE);
            txtmaleza_esti.setVisibility(View.GONE);
            txtfeno_esti.setVisibility(View.GONE);
            txtcult_esti.setVisibility(View.GONE);
            txtasocia_esti.setVisibility(View.GONE);
            txtasocia_esti2.setVisibility(View.GONE);
            txtnorte_esti.setVisibility(View.GONE);
            txtsur_esti.setVisibility(View.GONE);
            txteste_esti.setVisibility(View.GONE);
            txtoeste_esti.setVisibility(View.GONE);
            spicultivo_esti.setVisibility(View.GONE);
            spimodalidad_esti.setVisibility(View.GONE);
            spisiniestro_esti.setVisibility(View.GONE);
            spisuelo_esti.setVisibility(View.GONE);
            spipredio_esti.setVisibility(View.GONE);
            spimaleza_esti.setVisibility(View.GONE);
            spifeno_esti.setVisibility(View.GONE);
            spinorte_esti.setVisibility(View.GONE);
            spisur_esti.setVisibility(View.GONE);
            spieste_esti.setVisibility(View.GONE);
            spioeste_esti.setVisibility(View.GONE);
            otro_cultivo_esti.setVisibility(View.GONE);
            editaltura_esti.setVisibility(View.GONE);
            otro_siniestro_esti.setVisibility(View.GONE);
            editvariedad_esti.setVisibility(View.GONE);
            editcult_esti.setVisibility(View.GONE);
            editasocia_esti.setVisibility(View.GONE);
            editasocia_esti2.setVisibility(View.GONE);
            otro_norte_esti.setVisibility(View.GONE);
            otro_sur_esti.setVisibility(View.GONE);
            otro_este_esti.setVisibility(View.GONE);
            otro_oeste_esti.setVisibility(View.GONE);
        }
        else if (General.Proyecto.equals("Estimación de Superficie Agrícola"))
        {
            text_Titulo.setText("Proyecto: ESTIMACÍON DE SUPERFICIE AGRÍCOLA");
            text_estatus.setVisibility(View.GONE);
            text_mod_uso.setVisibility(View.GONE);
            text_cober.setVisibility(View.GONE);
            text_cober2.setVisibility(View.GONE);
            text_cober3.setVisibility(View.GONE);
            text_moda.setVisibility(View.GONE);
            spi_estatus.setVisibility(View.GONE);
            spi_mod_uso.setVisibility(View.GONE);
            spi_cober.setVisibility(View.GONE);
            spi_cober2.setVisibility(View.GONE);
            spi_cober3.setVisibility(View.GONE);
            spi_moda.setVisibility(View.GONE);
            editcober.setVisibility(View.GONE);
        }
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //+++++++++++++++++++++++++++++++++++++++++++++++Validaciones Frontera++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        spi_estatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        text_mod_uso.setVisibility(View.VISIBLE);
                        spi_mod_uso.setVisibility(View.VISIBLE);
                        text_cober.setVisibility(View.VISIBLE);
                        spi_cober.setVisibility(View.VISIBLE);
                        text_moda.setVisibility(View.VISIBLE);
                        spi_moda.setVisibility(View.VISIBLE);
                        text_cober3.setVisibility(View.GONE);
                        spi_cober3.setVisibility(View.GONE);
                        bandera = 0;
                        break;
                    case 2:
                        text_cober3.setVisibility(View.VISIBLE);
                        spi_cober3.setVisibility(View.VISIBLE);
                        text_mod_uso.setVisibility(View.GONE);
                        spi_mod_uso.setVisibility(View.GONE);
                        text_cober.setVisibility(View.GONE);
                        spi_cober.setVisibility(View.GONE);
                        text_cober2.setVisibility(View.GONE);
                        spi_cober2.setVisibility(View.GONE);
                        text_moda.setVisibility(View.GONE);
                        spi_moda.setVisibility(View.GONE);
                        bandera = 2;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spi_mod_uso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        text_cober.setVisibility(View.VISIBLE);
                        spi_cober.setVisibility(View.VISIBLE);
                        text_cober2.setVisibility(View.GONE);
                        spi_cober2.setVisibility(View.GONE);
                        bandera = 0;
                        break;
                    case 2:
                        text_cober.setVisibility(View.GONE);
                        spi_cober.setVisibility(View.GONE);
                        text_cober2.setVisibility(View.VISIBLE);
                        spi_cober2.setVisibility(View.VISIBLE);
                        bandera = 1;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spi_cober.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 58:
                        editcober.setVisibility(View.VISIBLE);
                        break;
                    default:
                        editcober.setVisibility(View.GONE);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spi_cober2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 5:
                        editcober.setVisibility(View.VISIBLE);
                        break;
                    default:
                        editcober.setVisibility(View.GONE);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spi_cober3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 26:
                        editcober.setVisibility(View.VISIBLE);
                        break;
                    default:
                        editcober.setVisibility(View.GONE);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //+++++++++++++++++++++++++++++++++++++++++++++++Validaciones Estimacion++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        spicultivo_esti.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 48:
                        otro_cultivo_esti.setVisibility(View.VISIBLE);
                        break;
                    default:
                        otro_cultivo_esti.setVisibility(View.GONE);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spisiniestro_esti.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 8:
                        otro_siniestro_esti.setVisibility(View.VISIBLE);
                        break;
                    default:
                        otro_siniestro_esti.setVisibility(View.GONE);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinorte_esti.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 48:
                        otro_norte_esti.setVisibility(View.VISIBLE);
                        break;
                    default:
                        otro_norte_esti.setVisibility(View.GONE);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spisur_esti.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 48:
                        otro_sur_esti.setVisibility(View.VISIBLE);
                        break;
                    default:
                        otro_sur_esti.setVisibility(View.GONE);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spieste_esti.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 48:
                        otro_este_esti.setVisibility(View.VISIBLE);
                        break;
                    default:
                        otro_este_esti.setVisibility(View.GONE);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spioeste_esti.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 48:
                        otro_oeste_esti.setVisibility(View.VISIBLE);
                        break;
                    default:
                        otro_oeste_esti.setVisibility(View.GONE);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //++++++++++++++++++++++++++ Guardar datos Jun 2021 +++++++++++++++++++++++++++++++++++++++++
        botnGoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                General.fechaenc = textFecha.getText().toString();
                General.horaenc = textHora.getText().toString();
                General.Observa = editObser.getText().toString();

                if(General.Proyecto.equals("Frontera Agrícola")){
                    General.statusenc = spi_estatus.getSelectedItem().toString();
                    if(bandera == 0){
                        General.mod_uso = spi_mod_uso.getSelectedItem().toString();
                        General.Cobertura = spi_cober.getSelectedItem().toString();
                        General.Modalidad = spi_moda.getSelectedItem().toString();
                    }
                    else if (bandera == 1){
                        General.mod_uso = spi_mod_uso.getSelectedItem().toString();
                        General.Cobertura = spi_cober2.getSelectedItem().toString();
                        General.Modalidad = spi_moda.getSelectedItem().toString();
                    }
                    else if (bandera == 2){
                        General.mod_uso = "";
                        General.Cobertura = spi_cober3.getSelectedItem().toString();
                        General.Modalidad = "";
                    }

                    if (editcober.getVisibility()==View.VISIBLE){
                        General.Cobertura = editcober.getText().toString();
                    }

                    if(validar()){
                        /*Toast.makeText(getApplicationContext(), ""+General.Foliocuestion+"-"+General.Proyecto+"-"+General.fechaenc+"-"+General.horaenc+
                                "-"+General.statusenc+"-"+ General.mod_uso+"-"+ General.Cobertura+
                                "-"+General.Modalidad+"-"+General.Observa+"-"+General.cultivo_esti+"-"+ General.modalidad_esti+"-"+General.altura_esti+
                                "-"+General.siniestro_esti+"-"+General.suelo_esti+"-"+General.predio_esti
                                +"-"+General.variedad_esti+"-"+General.maleza_esti+"-"+General.feno_esti+"-"+General.cult_esti
                                +"-"+General.asocia_esti+"-"+General.norte_esti+"-"+General.sur_esti
                                +"-"+General.este_esti+"-"+General.oeste_esti
                                +"-"+General.Observa,Toast.LENGTH_SHORT).show();*/

                        addCuestionario();
                        startActivity(new Intent(IdentificacionCuestionario.this, GeoreferenciaActivity.class));
                    }

                }
                else{
                    General.cultivo_esti = spicultivo_esti.getSelectedItem().toString();
                    if (otro_cultivo_esti.getVisibility()==View.VISIBLE){
                        General.cultivo_esti = otro_cultivo_esti.getText().toString();
                    }
                    General.modalidad_esti = spimodalidad_esti.getSelectedItem().toString();
                    DecimalFormat formato = new DecimalFormat();
                    formato.setMaximumFractionDigits(2);
                    General.altura_esti = editaltura_esti.getText().toString();
                    General.siniestro_esti = spisiniestro_esti.getSelectedItem().toString();
                    if (otro_siniestro_esti.getVisibility()==View.VISIBLE){
                        General.siniestro_esti = otro_siniestro_esti.getText().toString();
                    }
                    General.suelo_esti = spisuelo_esti.getSelectedItem().toString();
                    General.predio_esti = spipredio_esti.getSelectedItem().toString();
                    General.variedad_esti = editvariedad_esti.getText().toString();
                    General.maleza_esti = spimaleza_esti.getSelectedItem().toString();
                    General.feno_esti = spifeno_esti.getSelectedItem().toString();
                    General.cult_esti = editcult_esti.getText().toString();
                    General.asocia_esti = "" + editasocia_esti.getText().toString() + "-" + editasocia_esti2.getText().toString();
                    General.norte_esti  = spinorte_esti.getSelectedItem().toString();
                    if (otro_norte_esti.getVisibility()==View.VISIBLE){
                        General.norte_esti = otro_norte_esti.getText().toString();
                    }
                    General.sur_esti  = spisur_esti.getSelectedItem().toString();
                    if (otro_sur_esti.getVisibility()==View.VISIBLE){
                        General.sur_esti = otro_sur_esti.getText().toString();
                    }
                    General.este_esti  = spieste_esti.getSelectedItem().toString();
                    if (otro_este_esti.getVisibility()==View.VISIBLE){
                        General.este_esti = otro_este_esti.getText().toString();
                    }
                    General.oeste_esti  = spioeste_esti.getSelectedItem().toString();
                    if (otro_oeste_esti.getVisibility()==View.VISIBLE){
                        General.oeste_esti = otro_oeste_esti.getText().toString();
                    }

                    if(validarEst()){
                       /* Toast.makeText(getApplicationContext(), ""+General.Foliocuestion+"-"+General.Proyecto+"-"+General.fechaenc+"-"+General.horaenc+
                                "-"+General.cultivo_esti+"-"+ General.modalidad_esti+"-"+General.altura_esti+
                                "-"+General.siniestro_esti+"-"+General.suelo_esti+"-"+General.predio_esti
                                +"-"+General.variedad_esti+"-"+General.maleza_esti+"-"+General.feno_esti+"-"+General.cult_esti
                                +"-"+General.asocia_esti+"-"+General.norte_esti+"-"+General.sur_esti
                                +"-"+General.este_esti+"-"+General.oeste_esti
                                +"-"+General.Observa+"-"+General.statusenc+"-"+ General.mod_uso+"-"+ General.Cobertura+
                                "-"+General.Modalidad,Toast.LENGTH_SHORT).show();*/
                        addCuestionario();
                        startActivity(new Intent(IdentificacionCuestionario.this, GeoreferenciaActivity.class));
                    }
                }
            }
        });
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //++++++++++++++++++++++++++ 19 Noviembre +++++++++++++++++++++++++++++++++++++++++
        Spinner spinner = (Spinner) findViewById(R.id.spi_edo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.combo_Estados, android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String edoSelec = parent.getSelectedItem().toString();
                //String edoSelec = "Campeche";

                System.out.println(position);
                //    verForEdo(edoSelec);

                if(position !=0) {
                    getMunicipio(edoSelec);
                    listaSpinnerMunicipios();
                    baseBD.close();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        btIrproductor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.out.println("Folio de clase global"+General.Foliocuestion);
                //System.out.println("Folio obtenida en una variable "+foliocuest);

                if (General.Foliocuestion == "" ){
                    Toast.makeText(getApplicationContext(), "No existe ningún folio", Toast.LENGTH_SHORT).show();
                }

                if (editLocalid.getText().toString().isEmpty()){


                    Toast.makeText(getApplicationContext(), "Falta agregar la localidad ", Toast.LENGTH_SHORT).show();


                }else{

                    //municipiosag.setClickable(false);
                    //editLocalid.setEnabled(false);


                    //foliocuest = General.Foliocuestion;
                    //entidadfed =  textEstado.getText().toString();
                    //cveentidad = "01";
                    //municipio = municipiosag.getSelectedItem().toString();
                    //cvemunicipio = General.Municipioaguasc;


                 /*
                            General.estadopr = estadopr;
                    General.cveEdopr = String.valueOf(clEntidad);
                    General.municipio = municipio;
                    General.cveMunicipio = String.valueOf(clMunicipio);

                    General.localidad = editLocalid.getText().toString();
                    General.fechaenc = textFecha.getText().toString();
                    General.horaenc = textHora.getText().toString();

                    //A VER CHONGUITOS
                    General.Proyecto = editProye.getText().toString();
                    General.Cobertura = String.valueOf(spi_cober);
                    General.OtraCober = editcober.getText().toString();
                    General.Modalidad = String.valueOf(spi_moda);
                    General.Observa = editObser.getText().toString();


                    General.statusenc = "1";
                    //municipiosag.setClickable(false);
                    editLocalid.setEnabled(false);
                    btIrproductor.setEnabled(false);
                    spi_edo.setClickable(false);
                    spi_mun.setClickable(false);

                    //guardarDatos();
                    addCuestionario();



                    Toast.makeText(getApplicationContext(), "Se agrego correctamente", Toast.LENGTH_SHORT).show();
                    */
                    startActivity(new Intent(IdentificacionCuestionario.this, ProductorInfo.class));
                }
            }
        });


        caracteriza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                General.banderaFolio = true;
                startActivity(new Intent(IdentificacionCuestionario.this, ciclo_carac.class));
            }
        });
        horta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                General.banderaFolio = true;
                startActivity(new Intent(IdentificacionCuestionario.this, hortalizas.class));
            }
        });
        infraes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                General.banderaFolio = true;
                startActivity(new Intent(IdentificacionCuestionario.this, infraestructura_1.class));
            }
        });
        fruta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                General.banderaFolio = true;
                startActivity(new Intent(IdentificacionCuestionario.this, frutales_1.class));
            }
        });
        uniProduccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                General.banderaFolio = true;
                startActivity(new Intent(IdentificacionCuestionario.this, UnidadProduccion.class));
            }
        });
        api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                General.banderaFolio = true;
                startActivity(new Intent(IdentificacionCuestionario.this, ApicolaInicio.class));
            }
        });
        pecu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                General.banderaFolio = true;
                startActivity(new Intent(IdentificacionCuestionario.this, PecuarioInicio.class));
            }
        });
        come.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                General.banderaFolio = true;
                startActivity(new Intent(IdentificacionCuestionario.this, comercializacion_1.class));
            }
        });

        if(checkOtrEncs == false){
        //if(clEntidad != 0){
            //obtenFolio();
        }
    }

    public boolean validar()
    {
        boolean retorno=true;
        if(spi_estatus.getVisibility()==View.VISIBLE && spi_estatus.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spi_estatus.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(spi_mod_uso.getVisibility()==View.VISIBLE && spi_mod_uso.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spi_mod_uso.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else  if(spi_cober.getVisibility()==View.VISIBLE && spi_cober.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spi_cober.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(spi_cober2.getVisibility()==View.VISIBLE && spi_cober2.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spi_cober2.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(spi_cober3.getVisibility()==View.VISIBLE && spi_cober3.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spi_cober3.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(spi_moda.getVisibility()==View.VISIBLE && spi_moda.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spi_moda.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(editcober.getVisibility()==View.VISIBLE && editcober.getText().toString().isEmpty()){
            editcober.setError("No puede quedar vacio");
            retorno=false;
        }
        return retorno;
    }

    public boolean validarEst()
    {
        boolean retorno=true;

        if(otro_cultivo_esti.getVisibility()==View.VISIBLE && otro_cultivo_esti.getText().toString().isEmpty()){
            otro_cultivo_esti.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(spicultivo_esti.getVisibility()==View.VISIBLE && spicultivo_esti.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spicultivo_esti.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(spimodalidad_esti.getVisibility()==View.VISIBLE && spimodalidad_esti.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spimodalidad_esti.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(spisiniestro_esti.getVisibility()==View.VISIBLE && spisiniestro_esti.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spisiniestro_esti.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(spisuelo_esti.getVisibility()==View.VISIBLE && spisuelo_esti.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spisuelo_esti.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(spipredio_esti.getVisibility()==View.VISIBLE && spipredio_esti.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spipredio_esti.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(spimaleza_esti.getVisibility()==View.VISIBLE && spimaleza_esti.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spimaleza_esti.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(spifeno_esti.getVisibility()==View.VISIBLE && spifeno_esti.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spifeno_esti.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(spinorte_esti.getVisibility()==View.VISIBLE && spinorte_esti.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spinorte_esti.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(spisur_esti.getVisibility()==View.VISIBLE && spisur_esti.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spisur_esti.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(spieste_esti.getVisibility()==View.VISIBLE && spieste_esti.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spieste_esti.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(spioeste_esti.getVisibility()==View.VISIBLE && spioeste_esti.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spioeste_esti.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(otro_siniestro_esti.getVisibility()==View.VISIBLE && otro_siniestro_esti.getText().toString().isEmpty()){
            otro_siniestro_esti.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(otro_norte_esti.getVisibility()==View.VISIBLE && otro_norte_esti.getText().toString().isEmpty()){
            otro_norte_esti.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(otro_sur_esti.getVisibility()==View.VISIBLE && otro_sur_esti.getText().toString().isEmpty()){
            otro_sur_esti.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(otro_este_esti.getVisibility()==View.VISIBLE && otro_este_esti.getText().toString().isEmpty()){
            otro_este_esti.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(otro_oeste_esti.getVisibility()==View.VISIBLE && otro_oeste_esti.getText().toString().isEmpty()){
            otro_oeste_esti.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(editaltura_esti.getText().toString().isEmpty()){
            editaltura_esti.setError("No puede quedar vacio");
            retorno=false;
        }
        /*
        else if(editvariedad_esti.getText().toString().isEmpty()){
            editvariedad_esti.setError("No puede quedar vacio");
            retorno=false;
        }
         */
        else if(editcult_esti.getText().toString().isEmpty()){
            editcult_esti.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(editasocia_esti.getText().toString().isEmpty()){
            editasocia_esti.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(editasocia_esti2.getText().toString().isEmpty()){
            editasocia_esti2.setError("No puede quedar vacio");
         retorno=false;
        }
        else if(Float.parseFloat(editaltura_esti.getText().toString()) > 5.00 && spimodalidad_esti.getSelectedItem().toString().equals("Riego") ){
            editaltura_esti.setError("La altura no puede pasar los 5 metros");
            retorno=false;
        }
        else if(Float.parseFloat(editaltura_esti.getText().toString()) > 5.00 && spimodalidad_esti.getSelectedItem().toString().equals("Temporal") ){
            editaltura_esti.setError("La altura no puede pasar los 5 metros");
            retorno=false;
        }
        else if(Integer.parseInt(editasocia_esti2.getText().toString()) > Integer.parseInt(editasocia_esti.getText().toString())){
            editasocia_esti2.setError("No puede ser mayor");
            retorno=false;
        }
        else if((Integer.parseInt(editasocia_esti2.getText().toString()) + Integer.parseInt(editasocia_esti.getText().toString())) != 100){
            editasocia_esti2.setError("La suma debe de ser 100");
            retorno=false;
        }

        return retorno;
    }

    private void getMunicipio(String getEdo){
        datosAzureArrayList.clear();
        //Cursor cursor = baseBD.getListaMunicipios(getEdo);
        //cursor.close();
        cursor = baseBD.getListaMunicipios(getEdo);
        if (cursor.moveToFirst()) {
            do {
                ModelMunicipios name = new ModelMunicipios(
                        cursor.getInt(cursor.getColumnIndex(UtilidadesEdoMunicipios.COLUMN_CVE_ENT)),
                        cursor.getInt(cursor.getColumnIndex(UtilidadesEdoMunicipios.COLUMN_CVE_MUN)),
                        cursor.getInt(cursor.getColumnIndex(UtilidadesEdoMunicipios.COLUMN_CVEGEO)),
                        cursor.getString(cursor.getColumnIndex(UtilidadesEdoMunicipios.COLUMN_NOM_ENT)),
                        cursor.getString(cursor.getColumnIndex(UtilidadesEdoMunicipios.COLUMN_NOM_MUN))

                );
                datosAzureArrayList.add(name);
            } while (cursor.moveToNext());
           // cursor.close();

        }
        obtenerListaMunicipio();

    }

    private void obtenerListaMunicipio() {
        listaTempMunicipio = new ArrayList<String>();
        listaTempMunicipio.add("Seleccione");

        for(int i= 0; i < datosAzureArrayList.size(); i++ ){
            //listaTempMunicipio.add(datosAzureArrayList.get(i).getCOLUMN_CVE_ENT()+ "-" + datosAzureArrayList.get(i).getFechaEspecta());
            //listaTempMunicipio.add(datosAzureArrayList.get(i).getCOLUMN_CVE_ENT()+ "-" + datosAzureArrayList.get(i).getFechaEspecta());
            //listaTempMunicipio.add(String.valueOf(datosAzureArrayList.get(i).getCOLUMN_CVE_ENT()));
            listaTempMunicipio.add(datosAzureArrayList.get(i).getNOM_MUN());
            System.out.println(datosAzureArrayList.get(i).getNOM_MUN());
        }

        //listaSpinnerMunicipios();
    }

    private void listaSpinnerMunicipios() {
        Spinner spinnermunS = (Spinner) findViewById(R.id.spi_mun);
        ArrayAdapter<CharSequence> adapterMun = new ArrayAdapter(this,android.R.layout.simple_spinner_item, listaTempMunicipio);
        spinnermunS.setAdapter(adapterMun);

        spinnermunS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long idl) {
                String munSelec = parent.getSelectedItem().toString();
                obtenerValorFolio(munSelec);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void obtenerValorFolio(String munSelec) {
        for (int i = 0; i < datosAzureArrayList.size(); i++){
            if(datosAzureArrayList.get(i).getNOM_MUN() == munSelec){
                int claveMun = datosAzureArrayList.get(i).getCOLUMN_CVE_MUN();

                String nombMun = datosAzureArrayList.get(i).getNOM_MUN();

                int claveEnt = datosAzureArrayList.get(i).getCOLUMN_CVE_ENT();

                String nombEsta = datosAzureArrayList.get(i).getCOLUMN_NOM_ENT();

                System.out.println("Entidad:" + claveEnt + "Municipio:" + claveMun);
                clEntidad = claveEnt;
                clMunicipio = claveMun;

                estadopr = nombEsta;
                municipio = nombMun;
               // obtenFolio();
            }
        }

    }


    private void verForEdo(String edoSelec) {
        switch (edoSelec) {
            case "ESTADO DE MÉXICO":
                municipioSpinner("estado_Mexico");
                General.estadopr = "ESTADO DE MÉXICO";

                break;
            case "CHIHUAHUA":
                municipioSpinner("estado_chihuahua");
                General.estadopr = "CHIHUAHUA";
                General.cveEdopr = "02";
                break;
            case "JALISCO":
                municipioSpinner("estado_Jalisco");
                General.estadopr = "JALISCO";
                General.cveEdopr = "03";
                break;
            case "SONORA":
                municipioSpinner("estado_sonora");
                General.estadopr = "SONORA";
                General.cveEdopr = "04";
                break;
            case "TAMAULIPAS":
                municipioSpinner("estado_tamaulipas");
                General.estadopr = "TAMAULIPAS";
                General.cveEdopr = "05";
                break;
            case "OAXACA":
                General.estadopr = "OAXACA";
                General.cveEdopr = "05";
                municipioSpinner("estado_oaxaca");
                break;
            case "VERACRUZ":
                municipioSpinner("estado_veracruz");
                General.estadopr = "VERACRUZ";
                General.cveEdopr = "06";
                break;
            case "YUCATÁN":
                municipioSpinner("estado_yucatan");
                General.estadopr = "YUCATÁN";
                General.cveEdopr = "07";
                break;
        }
    }

    private void municipioSpinner(String estado_de_mxico) {
        String edtMex = estado_de_mxico;

        Spinner spinnermun = (Spinner) findViewById(R.id.spi_mun);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,getResources().getIdentifier(edtMex,"array",getBaseContext().getPackageName()), android.R.layout.simple_spinner_item);

        spinnermun.setAdapter(adapter);
        spinnermun.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String municipioSelec = parent.getSelectedItem().toString();
                //obtMunSect = municipioSelec;

                //    verForEdo(edoSelec);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void addCuestionario(){
        boolean insertarData = baseBD.addCuestionario();
        if(insertarData == true) {
            Toast.makeText(this, "Encuesta guardada correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Error al guardar", Toast.LENGTH_LONG).show();
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

    /*
    public void muestrahora(){
        Calendar fecha = Calendar.getInstance();
        hora = fecha.get(Calendar.HOUR_OF_DAY);
        minutos = fecha.get(Calendar.MINUTE);
        segundos = fecha.get(Calendar.SECOND);

        if(minutos < 10){
            String min = "0" + minutos;
            textHora.setText(hora+":"+min+":"+segundos);
        }else
            textHora.setText(hora+":"+minutos+":"+segundos);
    }
*/

    public void muestrahora(){
        Calendar fecha = Calendar.getInstance();
        hora = fecha.get(Calendar.HOUR_OF_DAY);
        minutos = fecha.get(Calendar.MINUTE);
        segundos = fecha.get(Calendar.SECOND);

        String hor;

        if (hora < 10) {
            hor = "0" + hora;
        }else
            hor = "" + hora;


        if(minutos < 10 ){
            String min = "0" + minutos;
            if (segundos < 10){
                String seg = "0" + segundos;
                textHora.setText(hor+":"+min+":"+seg);
            }else
                textHora.setText(hor+":"+min+":"+segundos);
        }else
        if (segundos < 10) {
            String seg = "0" + segundos;
            textHora.setText(hor + ":" + minutos + ":" + seg);
        }else
            textHora.setText(hor+":"+minutos+":"+segundos);
    }



    public void obtenFolio(){

        //String cveMunicipio = General.Municipioaguasc;



        Calendar fecha = Calendar.getInstance();
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        mes = fecha.get(Calendar.MONTH);
        anio = fecha.get(Calendar.YEAR);

        String an = String.valueOf(anio);
        String anior = an.substring(2,4);

        hora = fecha.get(Calendar.HOUR_OF_DAY);
        minutos = fecha.get(Calendar.MINUTE);
        segundos = fecha.get(Calendar.SECOND);


        if(General.banderaFolio == false){
            //foli = "DR" +"01"+"777"+dia+(mes+1)+anior+hora+minutos+segundos;
            foli = "AP" +dia+(mes+1)+anior+hora+minutos+segundos;
            textMuestrafolio.setText(foli);
            General.Foliocuestion = foli;
         //   General.banderaFolio = true;

            System.out.println("Folio1 ==>>" + General.Foliocuestion.toString());

        }
        else{
            textMuestrafolio.setText(General.Foliocuestion);
            System.out.println("Folio2 ==>>" + General.Foliocuestion.toString());
            Toast.makeText(getApplicationContext(), "ID generado", Toast.LENGTH_SHORT).show();


        }



    }



    @Override
    public void onBackPressed() {

    }

}
