package com.example.geosegalmex.PGBeneficiarioLeche;

import androidx.appcompat.app.AppCompatActivity;


import com.example.geosegalmex.General;
import com.example.geosegalmex.Georeferencia.GeoreferenciaActivity;
import com.example.geosegalmex.PGOperativoLeche.PGOperativoLeche;
import com.example.geosegalmex.PGOperativoLeche.PGOperativoLeche_Model;
import com.example.geosegalmex.R;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Pattern;

public class PGBeneficiarioLeche extends AppCompatActivity {

    int dia, mes, anio;
    PGBeneficiarioLeche_Model model;
    TextView textFecha;
    EditText fec, pgblt2, pgblt3, pgblt4, pgblt5, pgblt6, pgblt7, pgblt8, pgblt9, pgblt10, pgblt11, pgblt12, pgblt13, pgblt14, pgblt15, pgblt16, pgblt17, pgblt18, pgblt19, pgblt20, pgblt21, pgblt22, pgblt23, pgblt24, pgblt25, pgblt26, pgblt27, pgblt28 ;
    RadioButton pgblr1, pgblr2, pgblr3, pgblr4, pgblr5, pgblr6, pgblr7, pgblr8, pgblr9, pgblr10, pgblr11, pgblr12, pgblr13, pgblr14, pgblr15, pgblr16, pgblr17, pgblr18, pgblr19, pgblr20, pgblr21, pgblr22, pgblr23, pgblr24, pgblr25, pgblr26, pgblr27, pgblr28, pgblr29, pgblr30, pgblr31, pgblr32, pgblr33, pgblr34, pgblr35, pgblr36, pgblr37, pgblr38, pgblr39, pgblr40, pgblr41, pgblr42, pgblr43, pgblr44, pgblr45, pgblr46, pgblr47, pgblr48, pgblr49, pgblr50, pgblr51, pgblr52, pgblr53, pgblr54, pgblr55, pgblr56, pgblr57, pgblr58, pgblr59, pgblr60, pgblr61, pgblr62, pgblr63, pgblr64, pgblr65, pgblr66, pgblr67, pgblr68, pgblr69;
    Spinner pgbls1, pgbls2, pgbls3, pgbls4;
    CheckBox pgblc1, pgblc2, pgblc3, pgblc4, pgblc5, pgblc6, pgblc7, pgblc8, pgblc9, pgblc10, pgblc11, pgblc12, pgblc13, pgblc14, pgblc15, pgblc16, pgblc17;
    Button btnSiguiente;
    RadioButton rd1, rd2, rd3;

    String cveedo = "";
    String nomedo = "";
    String cvemun = "";
    String nommun = "";
    int[] idmunicipios = {R.array.Aguascalientes2021, R.array.BajaCalifornia2021, R.array.BajaCaliforniaSur2021, R.array.Campeche2021, R.array.CoahuiladeZaragoza2021, R.array.Colima2021, R.array.Chiapas2021, R.array.Chihuahua2021, R.array.CiudaddeMéxico2021
            , R.array.Durango2021, R.array.Guanajuato2021, R.array.Guerrero2021, R.array.Hidalgo2021, R.array.Jalisco2021, R.array.México2021, R.array.MichoacándeOcampo2021, R.array.Morelos2021, R.array.Nayarit2021, R.array.NuevoLeón2021, R.array.Oaxaca2021
            , R.array.Puebla2021, R.array.Querétaro2021, R.array.QuintanaRoo2021, R.array.SanLuisPotosí2021, R.array.Sinaloa2021, R.array.Sonora2021, R.array.Tabasco2021, R.array.Tamaulipas2021, R.array.Tlaxcala2021, R.array.VeracruzdeIgnaciodelaLlave2021
            , R.array.Yucatán2021, R.array.Zacatecas2021};
    int[] idcvemunicipios = {R.array.cveAguascalientes2021, R.array.cveBajaCalifornia2021, R.array.cveBajaCaliforniaSur2021, R.array.cveCampeche2021, R.array.cveCoahuiladeZaragoza2021, R.array.cveColima2021, R.array.cveChiapas2021, R.array.cveChihuahua2021, R.array.cveCiudaddeMéxico2021
            , R.array.cveDurango2021, R.array.cveGuanajuato2021, R.array.cveGuerrero2021, R.array.cveHidalgo2021, R.array.cveJalisco2021, R.array.cveMéxico2021, R.array.cveMichoacándeOcampo2021, R.array.cveMorelos2021, R.array.cveNayarit2021, R.array.cveNuevoLeón2021, R.array.cveOaxaca2021
            , R.array.cvePuebla2021, R.array.cveQuerétaro2021, R.array.cveQuintanaRoo2021, R.array.cveSanLuisPotosí2021, R.array.cveSinaloa2021, R.array.cveSonora2021, R.array.cveTabasco2021, R.array.cveTamaulipas2021, R.array.cveTlaxcala2021, R.array.cveVeracruzdeIgnaciodelaLlave2021
            , R.array.cveYucatán2021, R.array.cveZacatecas2021
    };
    String[] municipios;
    String[] cvemunicipios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgbeneficiario_leche);

        Declaracion();
        muestrafecha();


        pgbls1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String[] estados = getResources().getStringArray(R.array.Estados2021);
                String[] cveestados = getResources().getStringArray(R.array.cveEstados2021);

                cveedo = cveestados[position];
                nomedo = estados[position];

                municipios = getResources().getStringArray(idmunicipios[position]);
                cvemunicipios = getResources().getStringArray(idcvemunicipios[position]);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(PGBeneficiarioLeche.this, android.R.layout.simple_spinner_item, municipios);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                pgbls2.setAdapter(adapter);
                pgbls2.setEnabled(true);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        pgbls2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                nommun = municipios[position];
                cvemun = cvemunicipios[position];
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validar()){
                    String fol = General.Foliocuestion;
                    General.fechaenc = textFecha.getText().toString();
                    String nom = pgblt2.getText().toString();
                    String pat = pgblt3.getText().toString();
                    String mat = pgblt4.getText().toString();
                    String curp = pgblt5.getText().toString();
                    String calle = pgblt6.getText().toString();
                    String ext = pgblt7.getText().toString();
                    String inte = pgblt8.getText().toString();
                    String col = pgblt9.getText().toString();
                    String cp = pgblt10.getText().toString();
                    String sexo = obtenerResultado(pgblr1, pgblr2);
                    String edad = pgblt20.getText().toString();
                    String leer = obtenerResultado(pgblr3, pgblr4);
                    String nivel = obtenerResultado12(pgblr5, pgblr6, pgblr7, pgblr8, pgblr9, pgblr10, pgblr11, pgblr12, pgblr13, pgblr14, pgblr15, pgblr16);
                    String nivelotro = pgblt21.getText().toString();
                    String producto = obtenerResultado(pgblr17, pgblr18);
                    String volumen = pgblt22.getText().toString();
                    String cabezas = pgblt23.getText().toString();
                    String vacas = obtenerResultado3(rd1, rd2,rd3);
                    String apoyoa = (pgblc1.isChecked())? "1" : "";
                    String apoyob = (pgblc2.isChecked())? "1" : "";
                    String apoyoc = (pgblc3.isChecked())? "1" : "";
                    String apoyod = (pgblc4.isChecked())? "1" : "";
                    String apoyoe = (pgblc5.isChecked())? "1" : "";
                    String apoyof = (pgblc6.isChecked())? "1" : "";
                    String apoyog = (pgblc7.isChecked())? "1" : "";
                    String apoyoh = (pgblc8.isChecked())? "1" : "";
                    String docine = obtenerResultado(pgblr19, pgblr20);
                    String doccurp = obtenerResultado(pgblr21, pgblr22);
                    String docclabe = obtenerResultado(pgblr23, pgblr24);
                    String docfolio = obtenerResultado(pgblr25, pgblr26);
                    String op1 = obtenerResultado(pgblr27, pgblr28);
                    String op2 = obtenerResultado(pgblr29, pgblr30);
                    String op3 = obtenerResultado(pgblr31, pgblr32);
                    String op4 = obtenerResultado(pgblr33, pgblr34);
                    String op5 = obtenerResultado(pgblr35, pgblr36);
                    String op6 = obtenerResultado(pgblr37, pgblr38);
                    String op7 = obtenerResultado(pgblr39, pgblr40);
                    String op8 = obtenerResultado(pgblr41, pgblr42);
                    String op9 = obtenerResultado(pgblr43, pgblr44);
                    String op10 = obtenerResultado(pgblr45, pgblr46);
                    String op11 = obtenerResultado(pgblr47, pgblr48);
                    String reac1 = obtenerResultado3(pgblr49, pgblr50, pgblr51);
                    String reac2 = obtenerResultado3(pgblr52, pgblr53, pgblr54);
                    String reac3 = obtenerResultado3(pgblr55, pgblr56, pgblr57);
                    String reac4 = obtenerResultado3(pgblr58, pgblr59, pgblr60);
                    String reac5 = obtenerResultado3(pgblr61, pgblr62, pgblr63);
                    String reac6 = obtenerResultado3(pgblr64, pgblr65, pgblr66);
                    String reac7 = obtenerResultado3(pgblr67, pgblr68, pgblr69);
                    String react8a = (pgblc9.isChecked())? "1" : "";
                    String react8b = (pgblc10.isChecked())? "1" : "";
                    String react8c = (pgblc11.isChecked())? "1" : "";
                    String react8d = (pgblc12.isChecked())? "1" : "";
                    String react8e = (pgblc13.isChecked())? "1" : "";
                    String react8f = (pgblc14.isChecked())? "1" : "";
                    String react8g = (pgblc15.isChecked())? "1" : "";
                    String react8h = (pgblc16.isChecked())? "1" : "";
                    String react8i = (pgblc17.isChecked())? "1" : "";
                    String react8otro = pgblt24.getText().toString();
                    String reac9 = pgblt25.getText().toString();
                    String reac10 = pgblt26.getText().toString();
                    String reac11 = pgblt27.getText().toString();
                    String reac12 = pgblt28.getText().toString();


                    String f1 = General.Foto1;
                    String f2 = General.Foto2;

                    model = new PGBeneficiarioLeche_Model(fol, General.fechaenc, nom, pat, mat, curp,calle, ext, inte, cveedo, nomedo, cvemun,  nommun, "", col, cp, sexo, edad, leer, nivel, nivelotro, producto, volumen,
                            cabezas, vacas, apoyoa, apoyob, apoyoc, apoyod, apoyoe, apoyof, apoyog, apoyoh, docine, doccurp, docclabe, docfolio, op1, op2, op3, op4, op5, op6, op7, op8, op9, op10, op11, reac1, reac2, reac3, reac4,
                            reac5, reac6, reac7, react8a, react8b, react8c, react8d, react8e, react8f, react8g, react8h, react8i, react8otro, reac9, reac10, reac11, reac12, f1, f2, "", "");

                    Intent in = new Intent(PGBeneficiarioLeche.this, GeoreferenciaActivity.class);
                    in.putExtra("model", model);
                    startActivity(in);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Faltan respuestas",Toast.LENGTH_SHORT).show();
                }

            }
        });

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.RG1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(pgblr16.isChecked()==true){
                    pgblt21.setVisibility(View.VISIBLE);

                }else{
                    pgblt21.setVisibility(View.GONE);
                    pgblt21.setText("");
                }
            }
        });

        pgblc17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                               @Override
                                               public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                                   if(pgblc17.isChecked()==true){
                                                       pgblt24.setVisibility(View.VISIBLE);
                                                   }else{
                                                       pgblt24.setVisibility(View.GONE);
                                                       pgblt24.setText("");
                                                   }
                                               }
                                           }
        );


    }

    public void Declaracion(){

        textFecha=(TextView)findViewById(R.id.pg_leche_txtFecha);

        //Datos del productor

        pgblt2 = (EditText)findViewById(R.id.pre_garan_leche_txt2);
        pgblt3 = (EditText)findViewById(R.id.pre_garan_leche_txt3);
        pgblt4 = (EditText)findViewById(R.id.pre_garan_leche_txt4);
        pgblt5 = (EditText)findViewById(R.id.pre_garan_leche_txt5);

        //Direccion del beneficiario
        pgblt6 = (EditText)findViewById(R.id.pre_garan_leche_txt6);
        pgblt7 = (EditText)findViewById(R.id.pre_garan_leche_txt7);
        pgblt8 = (EditText)findViewById(R.id.pre_garan_leche_txt8);
        pgblt9 = (EditText)findViewById(R.id.pre_garan_leche_txt9);
        pgblt10 = (EditText)findViewById(R.id.pre_garan_leche_txt10);

        pgbls1 = (Spinner)findViewById(R.id.pre_garan_leche_spin1); //Estado

        pgbls2 = (Spinner)findViewById(R.id.pre_garan_leche_spin2); //Municipio

        //INFORMACION SOCIOECONOMICA

        //SEXO
        pgblr1 = (RadioButton)findViewById(R.id.pre_garan_leche_ra1);
        pgblr2 = (RadioButton)findViewById(R.id.pre_garan_leche_ra2);

        pgblt20 = (EditText)findViewById(R.id.pre_garan_leche_txt20);

        pgblr3 = (RadioButton)findViewById(R.id.pre_garan_leche_ra3);
        pgblr4 = (RadioButton)findViewById(R.id.pre_garan_leche_ra4);

        pgblr5 = (RadioButton)findViewById(R.id.pre_garan_leche_ra5);
        pgblr6 = (RadioButton)findViewById(R.id.pre_garan_leche_ra6);
        pgblr7 = (RadioButton)findViewById(R.id.pre_garan_leche_ra7);
        pgblr8 = (RadioButton)findViewById(R.id.pre_garan_leche_ra8);
        pgblr9 = (RadioButton)findViewById(R.id.pre_garan_leche_ra9);
        pgblr10 = (RadioButton)findViewById(R.id.pre_garan_leche_ra10);
        pgblr11 = (RadioButton)findViewById(R.id.pre_garan_leche_ra11);
        pgblr12 = (RadioButton)findViewById(R.id.pre_garan_leche_ra12);
        pgblr13 = (RadioButton)findViewById(R.id.pre_garan_leche_ra13);
        pgblr14 = (RadioButton)findViewById(R.id.pre_garan_leche_ra14);
        pgblr15 = (RadioButton)findViewById(R.id.pre_garan_leche_ra15);
        pgblr16 = (RadioButton)findViewById(R.id.pre_garan_leche_ra16);

        pgblt21 = (EditText)findViewById(R.id.pre_garan_leche_txt21);

        //INFORMACIÓN DE ACOPIO

        pgblr17 = (RadioButton)findViewById(R.id.pre_garan_leche_ra17);
        pgblr18 = (RadioButton)findViewById(R.id.pre_garan_leche_ra18);

        pgblt22 = (EditText)findViewById(R.id.pre_garan_leche_txt22);
        pgblt23 = (EditText)findViewById(R.id.pre_garan_leche_txt23);

        rd1 = (RadioButton)findViewById(R.id.pg_bene_ra1);
        rd2 = (RadioButton)findViewById(R.id.pg_bene_ra2);
        rd3 = (RadioButton)findViewById(R.id.pg_bene_ra3);

        pgblc1 = (CheckBox)findViewById(R.id.pre_garan_leche_ch1);
        pgblc2 = (CheckBox)findViewById(R.id.pre_garan_leche_ch2);
        pgblc3 = (CheckBox)findViewById(R.id.pre_garan_leche_ch3);
        pgblc4 = (CheckBox)findViewById(R.id.pre_garan_leche_ch4);
        pgblc5 = (CheckBox)findViewById(R.id.pre_garan_leche_ch5);
        pgblc6 = (CheckBox)findViewById(R.id.pre_garan_leche_ch6);
        pgblc7 = (CheckBox)findViewById(R.id.pre_garan_leche_ch7);
        pgblc8 = (CheckBox)findViewById(R.id.pre_garan_leche_ch8);

        pgblr19 = (RadioButton)findViewById(R.id.pre_garan_leche_ra19);
        pgblr20 = (RadioButton)findViewById(R.id.pre_garan_leche_ra20);

        pgblr21 = (RadioButton)findViewById(R.id.pre_garan_leche_ra21);
        pgblr22 = (RadioButton)findViewById(R.id.pre_garan_leche_ra22);

        pgblr23 = (RadioButton)findViewById(R.id.pre_garan_leche_ra23);
        pgblr24 = (RadioButton)findViewById(R.id.pre_garan_leche_ra24);

        pgblr25 = (RadioButton)findViewById(R.id.pre_garan_leche_ra25);
        pgblr26 = (RadioButton)findViewById(R.id.pre_garan_leche_ra26);

        pgblr27 = (RadioButton)findViewById(R.id.pre_garan_leche_ra27);
        pgblr28 = (RadioButton)findViewById(R.id.pre_garan_leche_ra28);

        pgblr29 = (RadioButton)findViewById(R.id.pre_garan_leche_ra29);
        pgblr30 = (RadioButton)findViewById(R.id.pre_garan_leche_ra30);

        pgblr31 = (RadioButton)findViewById(R.id.pre_garan_leche_ra31);
        pgblr32 = (RadioButton)findViewById(R.id.pre_garan_leche_ra32);

        pgblr33 = (RadioButton)findViewById(R.id.pre_garan_leche_ra33);
        pgblr34 = (RadioButton)findViewById(R.id.pre_garan_leche_ra34);

        pgblr35 = (RadioButton)findViewById(R.id.pre_garan_leche_ra35);
        pgblr36 = (RadioButton)findViewById(R.id.pre_garan_leche_ra36);

        pgblr37 = (RadioButton)findViewById(R.id.pre_garan_leche_ra37);
        pgblr38 = (RadioButton)findViewById(R.id.pre_garan_leche_ra38);

        pgblr39 = (RadioButton)findViewById(R.id.pre_garan_leche_ra39);
        pgblr40 = (RadioButton)findViewById(R.id.pre_garan_leche_ra40);

        pgblr41 = (RadioButton)findViewById(R.id.pre_garan_leche_ra41);
        pgblr42 = (RadioButton)findViewById(R.id.pre_garan_leche_ra42);

        pgblr43 = (RadioButton)findViewById(R.id.pre_garan_leche_ra43);
        pgblr44 = (RadioButton)findViewById(R.id.pre_garan_leche_ra44);

        pgblr45 = (RadioButton)findViewById(R.id.pre_garan_leche_ra45);
        pgblr46 = (RadioButton)findViewById(R.id.pre_garan_leche_ra46);

        pgblr47 = (RadioButton)findViewById(R.id.pre_garan_leche_ra47);
        pgblr48 = (RadioButton)findViewById(R.id.pre_garan_leche_ra48);

        //ENCUESTA DE OPINION

        pgblr49 = (RadioButton)findViewById(R.id.pre_garan_leche_ra49);
        pgblr50 = (RadioButton)findViewById(R.id.pre_garan_leche_ra50);
        pgblr51 = (RadioButton)findViewById(R.id.pre_garan_leche_ra51);

        pgblr52 = (RadioButton)findViewById(R.id.pre_garan_leche_ra52);
        pgblr53 = (RadioButton)findViewById(R.id.pre_garan_leche_ra53);
        pgblr54 = (RadioButton)findViewById(R.id.pre_garan_leche_ra54);

        pgblr55 = (RadioButton)findViewById(R.id.pre_garan_leche_ra55);
        pgblr56 = (RadioButton)findViewById(R.id.pre_garan_leche_ra56);
        pgblr57 = (RadioButton)findViewById(R.id.pre_garan_leche_ra57);

        pgblr58 = (RadioButton)findViewById(R.id.pre_garan_leche_ra58);
        pgblr59 = (RadioButton)findViewById(R.id.pre_garan_leche_ra59);
        pgblr60 = (RadioButton)findViewById(R.id.pre_garan_leche_ra60);

        pgblr61 = (RadioButton)findViewById(R.id.pre_garan_leche_ra61);
        pgblr62 = (RadioButton)findViewById(R.id.pre_garan_leche_ra62);
        pgblr63 = (RadioButton)findViewById(R.id.pre_garan_leche_ra63);

        pgblr64 = (RadioButton)findViewById(R.id.pre_garan_leche_ra64);
        pgblr65 = (RadioButton)findViewById(R.id.pre_garan_leche_ra65);
        pgblr66 = (RadioButton)findViewById(R.id.pre_garan_leche_ra66);

        pgblr67 = (RadioButton)findViewById(R.id.pre_garan_leche_ra67);
        pgblr68 = (RadioButton)findViewById(R.id.pre_garan_leche_ra68);
        pgblr69 = (RadioButton)findViewById(R.id.pre_garan_leche_ra69);

        pgblc9 = (CheckBox)findViewById(R.id.pre_garan_leche_ch9);
        pgblc10 = (CheckBox)findViewById(R.id.pre_garan_leche_ch10);
        pgblc11 = (CheckBox)findViewById(R.id.pre_garan_leche_ch11);
        pgblc12 = (CheckBox)findViewById(R.id.pre_garan_leche_ch12);
        pgblc13 = (CheckBox)findViewById(R.id.pre_garan_leche_ch13);
        pgblc14 = (CheckBox)findViewById(R.id.pre_garan_leche_ch14);
        pgblc15 = (CheckBox)findViewById(R.id.pre_garan_leche_ch15);
        pgblc16 = (CheckBox)findViewById(R.id.pre_garan_leche_ch16);
        pgblc17 = (CheckBox)findViewById(R.id.pre_garan_leche_ch17);

        pgblt24 = (EditText)findViewById(R.id.pre_garan_leche_txt24);
        pgblt25 = (EditText)findViewById(R.id.pre_garan_leche_txt25);
        pgblt26 = (EditText)findViewById(R.id.pre_garan_leche_txt26);
        pgblt27 = (EditText)findViewById(R.id.pre_garan_leche_txt27);
        pgblt28 = (EditText)findViewById(R.id.pre_garan_leche_txt28);

        btnSiguiente = findViewById(R.id.pre_garan_leche_sig);
    }

    //Metodo para extraer la fecha actual
    public void muestrafecha(){
        Calendar fecha = Calendar.getInstance();
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        mes = fecha.get(Calendar.MONTH);
        anio = fecha.get(Calendar.YEAR);
        textFecha.setText(""+dia+"/"+(mes+1)+"/"+anio);
    }

    public String obtenerResultado(RadioButton rb1, RadioButton rb2){
        String respuesta = "";
        if (rb1.isChecked()==true){
            respuesta = rb1.getText().toString();
        }
        else if (rb2.isChecked()==true){
            respuesta = rb2.getText().toString();
        }
        return  respuesta;
    }

    public String obtenerResultado3(RadioButton rb1, RadioButton rb2, RadioButton rb3){
        String respuesta = "";
        if (rb1.isChecked()==true){
            respuesta = rb1.getText().toString();
        }
        else if (rb2.isChecked()==true){
            respuesta = rb2.getText().toString();
        }
        else if (rb3.isChecked()==true){
            respuesta = rb3.getText().toString();
        }
        return  respuesta;
    }

    public String obtenerResultado12(RadioButton rb1, RadioButton rb2, RadioButton rb3, RadioButton rb4, RadioButton rb5, RadioButton rb6, RadioButton rb7, RadioButton rb8, RadioButton rb9, RadioButton rb10, RadioButton rb11, RadioButton rb12){
        String respuesta = "";
        if (rb1.isChecked()==true){
            respuesta = rb1.getText().toString();
        }
        else if (rb2.isChecked()==true){
            respuesta = rb2.getText().toString();
        }
        else if (rb3.isChecked()==true){
            respuesta = rb3.getText().toString();
        }
        else if (rb4.isChecked()==true){
            respuesta = rb4.getText().toString();
        }
        else if (rb5.isChecked()==true){
            respuesta = rb5.getText().toString();
        }
        else if (rb6.isChecked()==true){
            respuesta = rb6.getText().toString();
        }
        else if (rb7.isChecked()==true){
            respuesta = rb7.getText().toString();
        }
        else if (rb8.isChecked()==true){
            respuesta = rb8.getText().toString();
        }
        else if (rb9.isChecked()==true){
            respuesta = rb9.getText().toString();
        }
        else if (rb10.isChecked()==true){
            respuesta = rb10.getText().toString();
        }
        else if (rb11.isChecked()==true){
            respuesta = rb11.getText().toString();
        }
        else if (rb12.isChecked()==true){
            respuesta = rb12.getText().toString();
        }
        return  respuesta;
    }

    public boolean validarCURP(String curp)
    { String regex =
            "[A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}" +
                    "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])" +
                    "[HM]{1}" +
                    "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)" +
                    "[B-DF-HJ-NP-TV-Z]{3}" +
                    "[0-9A-Z]{1}[0-9]{1}$";

        Pattern patron = Pattern.compile(regex);
        if(!patron.matcher(curp).matches())
        { return false;
        }else
        { return true;
        }
    }

    public boolean validar(){
        boolean retorno=true;

        if(pgblt2.getText().toString().isEmpty()){
            pgblt2.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgblt3.getText().toString().isEmpty()){
            pgblt3.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgblt4.getText().toString().isEmpty()){
            pgblt4.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgblt5.getText().toString().isEmpty()){
            pgblt5.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!validarCURP(pgblt5.getText().toString())){
            pgblt5.setError("CURP invalido");
            retorno=false;
        }
        else if(pgblt6.getText().toString().isEmpty()){
            pgblt6.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgblt9.getText().toString().isEmpty()){
            pgblt9.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgblt10.getText().toString().isEmpty()){
            pgblt10.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!pgblr1.isChecked() && !pgblr2.isChecked()){
            pgblr1.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(pgblt20.getText().toString().isEmpty()){
            pgblt20.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!pgblr3.isChecked() && !pgblr4.isChecked()){
            pgblr3.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr5.isChecked() && !pgblr6.isChecked() && !pgblr7.isChecked() && !pgblr8.isChecked() && !pgblr9.isChecked() && !pgblr10.isChecked() && !pgblr11.isChecked() && !pgblr12.isChecked() && !pgblr13.isChecked() && !pgblr14.isChecked() && !pgblr15.isChecked() && !pgblr16.isChecked()){
            pgblr5.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(pgblr16.isChecked() && pgblt21.getText().toString().isEmpty()){
            pgblt21.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!pgblr17.isChecked() && !pgblr18.isChecked()){
            pgblr17.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(pgblt22.getText().toString().isEmpty()){
            pgblt22.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgblt23.getText().toString().isEmpty()){
            pgblt23.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!rd1.isChecked() && !rd2.isChecked() && !rd3.isChecked()){
            rd1.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if (!pgblc1.isChecked() && !pgblc2.isChecked() && !pgblc3.isChecked() && !pgblc4.isChecked() && !pgblc5.isChecked() && !pgblc6.isChecked() && !pgblc7.isChecked() && !pgblc8.isChecked()) {
            pgblc1.setError("Debes seleccionar almenos una opción");
            retorno = false;
        }
        else if(!pgblr19.isChecked() && !pgblr20.isChecked()){
            pgblr19.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr21.isChecked() && !pgblr22.isChecked()){
            pgblr21.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr23.isChecked() && !pgblr24.isChecked()){
            pgblr23.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr25.isChecked() && !pgblr26.isChecked()){
            pgblr25.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr27.isChecked() && !pgblr28.isChecked()){
            pgblr27.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr29.isChecked() && !pgblr30.isChecked()){
            pgblr29.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr31.isChecked() && !pgblr32.isChecked()){
            pgblr31.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr33.isChecked() && !pgblr34.isChecked()){
            pgblr33.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr35.isChecked() && !pgblr36.isChecked()){
            pgblr35.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr37.isChecked() && !pgblr38.isChecked()){
            pgblr37.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr39.isChecked() && !pgblr40.isChecked()){
            pgblr39.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr41.isChecked() && !pgblr42.isChecked()){
            pgblr41.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr43.isChecked() && !pgblr44.isChecked()){
            pgblr43.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr45.isChecked() && !pgblr46.isChecked()){
            pgblr45.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr47.isChecked() && !pgblr48.isChecked()){
            pgblr47.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr49.isChecked() && !pgblr50.isChecked() && !pgblr51.isChecked()){
            pgblr49.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr52.isChecked() && !pgblr53.isChecked() && !pgblr54.isChecked()){
            pgblr52.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr55.isChecked() && !pgblr56.isChecked() && !pgblr57.isChecked()){
            pgblr55.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr58.isChecked() && !pgblr59.isChecked() && !pgblr60.isChecked()){
            pgblr58.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr61.isChecked() && !pgblr62.isChecked() && !pgblr63.isChecked()){
            pgblr61.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr64.isChecked() && !pgblr65.isChecked() && !pgblr66.isChecked()){
            pgblr64.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgblr67.isChecked() && !pgblr68.isChecked() && !pgblr69.isChecked()){
            pgblr67.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if (!pgblc9.isChecked() && !pgblc10.isChecked() && !pgblc11.isChecked() && !pgblc12.isChecked() && !pgblc13.isChecked() && !pgblc14.isChecked() && !pgblc15.isChecked() && !pgblc16.isChecked() && !pgblc17.isChecked()) {
            pgblc9.setError("Debes seleccionar almenos una opción");
            retorno = false;
        }
        else if(pgblc17.isChecked() && pgblt24.getText().toString().isEmpty()){
            pgblt24.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgblt25.getText().toString().isEmpty()){
            pgblt25.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgblt26.getText().toString().isEmpty()){
            pgblt26.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgblt27.getText().toString().isEmpty()){
            pgblt27.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgblt28.getText().toString().isEmpty()){
            pgblt28.setError("No puede quedar vacio");
            retorno=false;
        }
        return retorno;
    }


    @Override
    public void onBackPressed() {

    }

}