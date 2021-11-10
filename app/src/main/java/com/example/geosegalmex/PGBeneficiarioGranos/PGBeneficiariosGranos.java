package com.example.geosegalmex.PGBeneficiarioGranos;

import androidx.appcompat.app.AppCompatActivity;

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

import com.example.geosegalmex.General;
import com.example.geosegalmex.Georeferencia.GeoreferenciaActivity;
import com.example.geosegalmex.PGBeneficiarioLeche.PGBeneficiarioLeche;
import com.example.geosegalmex.R;

import java.util.Calendar;
import java.util.regex.Pattern;

public class PGBeneficiariosGranos extends AppCompatActivity {

 TextView textFecha;
 int dia, mes, anio;
 EditText  pgbt2, pgbt3, pgbt4, pgbt5, pgbt6, pgbt7, pgbt8, pgbt9, pgbt10, pgbt13, pgbt14, pgbt15, pgbt16, pgbt17, pgbt20, pgbt21, pgbt22, pgbt23, pgbt24, pgbt25, pgbt26, pgbt27, pgbt28, pgbt29, pgbt30;
 RadioButton pgbr1, pgbr2, pgbr3, pgbr4, pgbr5, pgbr6, pgbr7, pgbr8, pgbr9, pgbr10, pgbr11, pgbr12, pgbr13, pgbr14, pgbr15, pgbr16,pgbr18, pgbr19,pgbr21, pgbr22, pgbr23, pgbr24, pgbr25, pgbr26, pgbr27, pgbr28, pgbr29, pgbr30, pgbr31, pgbr32, pgbr33, pgbr34, pgbr35, pgbr36, pgbr37, pgbr38, pgbr39, pgbr40, pgbr41, pgbr42, pgbr43, pgbr44, pgbr45, pgbr46, pgbr47, pgbr48, pgbr49, pgbr50, pgbr51, pgbr52, pgbr68, pgbr69, pgbr70, pgbr71, pgbr72, pgbr73, pgbr74, pgbr75, pgbr76, pgbr77, pgbr78, pgbr79, pgbr80, pgbr81, pgbr82, pgbr83, pgbr84, pgbr85, pgbr86, pgbr87, pgbr88;
 Spinner pgbs1, pgbs2, pgbs3, pgbs4;
 CheckBox pgbc1, pgbc2, pgbc3, pgbc4, pgbc5, pgbc6, pgbc7, pgbc8, pgbc9, pgbc10, pgbc11, pgbc12, pgbc13, pgbc14, pgbc15, pgbc16, pgbc17, pgbc18, pgbc19;
 Button btnSiguiente;

 PGB_granos_model model;

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

 String cveedo2 = "";
 String nomedo2 = "";
 String cvemun2 = "";
 String nommun2 = "";
 int[] idmunicipios2 = {R.array.Aguascalientes2021, R.array.BajaCalifornia2021, R.array.BajaCaliforniaSur2021, R.array.Campeche2021, R.array.CoahuiladeZaragoza2021, R.array.Colima2021, R.array.Chiapas2021, R.array.Chihuahua2021, R.array.CiudaddeMéxico2021
         , R.array.Durango2021, R.array.Guanajuato2021, R.array.Guerrero2021, R.array.Hidalgo2021, R.array.Jalisco2021, R.array.México2021, R.array.MichoacándeOcampo2021, R.array.Morelos2021, R.array.Nayarit2021, R.array.NuevoLeón2021, R.array.Oaxaca2021
         , R.array.Puebla2021, R.array.Querétaro2021, R.array.QuintanaRoo2021, R.array.SanLuisPotosí2021, R.array.Sinaloa2021, R.array.Sonora2021, R.array.Tabasco2021, R.array.Tamaulipas2021, R.array.Tlaxcala2021, R.array.VeracruzdeIgnaciodelaLlave2021
         , R.array.Yucatán2021, R.array.Zacatecas2021};
 int[] idcvemunicipios2 = {R.array.cveAguascalientes2021, R.array.cveBajaCalifornia2021, R.array.cveBajaCaliforniaSur2021, R.array.cveCampeche2021, R.array.cveCoahuiladeZaragoza2021, R.array.cveColima2021, R.array.cveChiapas2021, R.array.cveChihuahua2021, R.array.cveCiudaddeMéxico2021
         , R.array.cveDurango2021, R.array.cveGuanajuato2021, R.array.cveGuerrero2021, R.array.cveHidalgo2021, R.array.cveJalisco2021, R.array.cveMéxico2021, R.array.cveMichoacándeOcampo2021, R.array.cveMorelos2021, R.array.cveNayarit2021, R.array.cveNuevoLeón2021, R.array.cveOaxaca2021
         , R.array.cvePuebla2021, R.array.cveQuerétaro2021, R.array.cveQuintanaRoo2021, R.array.cveSanLuisPotosí2021, R.array.cveSinaloa2021, R.array.cveSonora2021, R.array.cveTabasco2021, R.array.cveTamaulipas2021, R.array.cveTlaxcala2021, R.array.cveVeracruzdeIgnaciodelaLlave2021
         , R.array.cveYucatán2021, R.array.cveZacatecas2021
 };
 String[] municipios2;
 String[] cvemunicipios2;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_pgbeneficiarios_granos);

  textFecha=(TextView)findViewById(R.id.pg_leche_txtFecha);
  pgbt2 = (EditText)findViewById(R.id.pre_garan_granos_txt2);
  pgbt3 = (EditText)findViewById(R.id.pre_garan_granos_txt3);
  pgbt4 = (EditText)findViewById(R.id.pre_garan_granos_txt4);
  pgbt5 = (EditText)findViewById(R.id.pre_garan_granos_txt5);

  //proyecto
  pgbt6 = (EditText)findViewById(R.id.pre_garan_granos_txt6);
  pgbt7 = (EditText)findViewById(R.id.pre_garan_granos_txt7);
  pgbt8 = (EditText)findViewById(R.id.pre_garan_granos_txt8);
  pgbt9 = (EditText)findViewById(R.id.pre_garan_granos_txt9);
  pgbt10 = (EditText)findViewById(R.id.pre_garan_granos_txt10);

  pgbs1 = (Spinner)findViewById(R.id.pgb_o_spiEstado);
  pgbs2 = (Spinner)findViewById(R.id.pgb_o_spiMunicipio);


  //Dirección producción
  pgbt13 = (EditText)findViewById(R.id.pre_garan_granos_txt13);
  pgbt14 = (EditText)findViewById(R.id.pre_garan_granos_txt14);
  pgbt15 = (EditText)findViewById(R.id.pre_garan_granos_txt15);
  pgbt16 = (EditText)findViewById(R.id.pre_garan_granos_txt16);
  pgbt17 = (EditText)findViewById(R.id.pre_garan_granos_txt17);

  pgbs3 = (Spinner)findViewById(R.id.pgb_o_spiEstado2);

  pgbs4 = (Spinner)findViewById(R.id.pgb_o_spiMunicipio2);

  //sexo
  pgbr1 = (RadioButton)findViewById(R.id.pre_garan_granos_ra2_1);
  pgbr2 = (RadioButton)findViewById(R.id.pre_garan_granos_ra2_2);
  pgbt20 = (EditText)findViewById(R.id.pre_garan_granos_txt20);

  pgbr3 = (RadioButton)findViewById(R.id.pre_garan_granos_ra3);
  pgbr4 = (RadioButton)findViewById(R.id.pre_garan_granos_ra4);

  //ESTUDIOS
  pgbr5 = (RadioButton)findViewById(R.id.pre_garan_granos_ra5);
  pgbr6 = (RadioButton)findViewById(R.id.pre_garan_granos_ra6);
  pgbr7 = (RadioButton)findViewById(R.id.pre_garan_granos_ra7);
  pgbr8 = (RadioButton)findViewById(R.id.pre_garan_granos_ra8);
  pgbr9 = (RadioButton)findViewById(R.id.pre_garan_granos_ra9);
  pgbr10 = (RadioButton)findViewById(R.id.pre_garan_granos_ra10);
  pgbr11 = (RadioButton)findViewById(R.id.pre_garan_granos_ra11);
  pgbr12 = (RadioButton)findViewById(R.id.pre_garan_granos_ra12);
  pgbr13 = (RadioButton)findViewById(R.id.pre_garan_granos_ra13);
  pgbr14 = (RadioButton)findViewById(R.id.pre_garan_granos_ra14);
  pgbr15 = (RadioButton)findViewById(R.id.pre_garan_granos_ra15);
  pgbr16 = (RadioButton)findViewById(R.id.pre_garan_granos_ra16);

  pgbt21 = (EditText)findViewById(R.id.pre_garan_granos_txt21);

  //Producto
  pgbr18 = (RadioButton)findViewById(R.id.pre_garan_granos_ra18);
  pgbr19 = (RadioButton)findViewById(R.id.pre_garan_granos_ra19);

  pgbt22 = (EditText)findViewById(R.id.pre_garan_granos_tx22);
  pgbt23 = (EditText)findViewById(R.id.pre_garan_granos_tx23);
  pgbt24 = (EditText)findViewById(R.id.pre_garan_granos_tx24);

  //info. apoyo
  pgbc1 = (CheckBox)findViewById(R.id.pre_garan_granos_ch1);
  pgbc2 = (CheckBox)findViewById(R.id.pre_garan_granos_ch2);
  pgbc3 = (CheckBox)findViewById(R.id.pre_garan_granos_ch3);
  pgbc4 = (CheckBox)findViewById(R.id.pre_garan_granos_ch4);
  pgbc5 = (CheckBox)findViewById(R.id.pre_garan_granos_ch5);
  pgbc6 = (CheckBox)findViewById(R.id.pre_garan_granos_ch6);
  pgbc7 = (CheckBox)findViewById(R.id.pre_garan_granos_ch7);
  pgbc8 = (CheckBox)findViewById(R.id.pre_garan_granos_ch8);
  pgbc9 = (CheckBox)findViewById(R.id.pre_garan_granos_ch9);
  pgbc10 = (CheckBox)findViewById(R.id.pre_garan_granos_ch10);


  pgbr21 = (RadioButton)findViewById(R.id.pre_garan_granos_ra21);
  pgbr22 = (RadioButton)findViewById(R.id.pre_garan_granos_ra22);

  pgbr23 = (RadioButton)findViewById(R.id.pre_garan_granos_ra23);
  pgbr24 = (RadioButton)findViewById(R.id.pre_garan_granos_ra24);

  pgbr25 = (RadioButton)findViewById(R.id.pre_garan_granos_ra25);
  pgbr26 = (RadioButton)findViewById(R.id.pre_garan_granos_ra26);

  pgbr27 = (RadioButton)findViewById(R.id.pre_garan_granos_ra27);
  pgbr28 = (RadioButton)findViewById(R.id.pre_garan_granos_ra28);

  pgbr29 = (RadioButton)findViewById(R.id.pre_garan_granos_ra29);
  pgbr30 = (RadioButton)findViewById(R.id.pre_garan_granos_ra30);

  pgbr31 = (RadioButton)findViewById(R.id.pre_garan_granos_ra31);
  pgbr32 = (RadioButton)findViewById(R.id.pre_garan_granos_ra32);

  pgbr33 = (RadioButton)findViewById(R.id.pre_garan_granos_ra33);
  pgbr34 = (RadioButton)findViewById(R.id.pre_garan_granos_ra34);

  pgbr35 = (RadioButton)findViewById(R.id.pre_garan_granos_ra35);
  pgbr36 = (RadioButton)findViewById(R.id.pre_garan_granos_ra36);

  pgbr37 = (RadioButton)findViewById(R.id.pre_garan_granos_ra37);
  pgbr38 = (RadioButton)findViewById(R.id.pre_garan_granos_ra38);

  pgbr39 = (RadioButton)findViewById(R.id.pre_garan_granos_ra39);
  pgbr40 = (RadioButton)findViewById(R.id.pre_garan_granos_ra40);

  pgbr41 = (RadioButton)findViewById(R.id.pre_garan_granos_ra41);
  pgbr42 = (RadioButton)findViewById(R.id.pre_garan_granos_ra42);

  pgbr43 = (RadioButton)findViewById(R.id.pre_garan_granos_ra43);
  pgbr44 = (RadioButton)findViewById(R.id.pre_garan_granos_ra44);

  pgbr45 = (RadioButton)findViewById(R.id.pre_garan_granos_ra45);
  pgbr46 = (RadioButton)findViewById(R.id.pre_garan_granos_ra46);

  pgbr47 = (RadioButton)findViewById(R.id.pre_garan_granos_ra47);
  pgbr48 = (RadioButton)findViewById(R.id.pre_garan_granos_ra48);

  pgbr49 = (RadioButton)findViewById(R.id.pre_garan_granos_ra49);
  pgbr50 = (RadioButton)findViewById(R.id.pre_garan_granos_ra50);

  pgbr51 = (RadioButton)findViewById(R.id.pre_garan_granos_ra51);
  pgbr52 = (RadioButton)findViewById(R.id.pre_garan_granos_ra52);

  pgbr68 = (RadioButton)findViewById(R.id.pre_garan_granos_ra68);
  pgbr69 = (RadioButton)findViewById(R.id.pre_garan_granos_ra69);
  pgbr70 = (RadioButton)findViewById(R.id.pre_garan_granos_ra70);
  pgbr71 = (RadioButton)findViewById(R.id.pre_garan_granos_ra71);
  pgbr72 = (RadioButton)findViewById(R.id.pre_garan_granos_ra72);
  pgbr73 = (RadioButton)findViewById(R.id.pre_garan_granos_ra73);
  pgbr74 = (RadioButton)findViewById(R.id.pre_garan_granos_ra74);
  pgbr75 = (RadioButton)findViewById(R.id.pre_garan_granos_ra75);
  pgbr76 = (RadioButton)findViewById(R.id.pre_garan_granos_ra76);
  pgbr77 = (RadioButton)findViewById(R.id.pre_garan_granos_ra77);
  pgbr78 = (RadioButton)findViewById(R.id.pre_garan_granos_ra78);
  pgbr79 = (RadioButton)findViewById(R.id.pre_garan_granos_ra79);
  pgbr80 = (RadioButton)findViewById(R.id.pre_garan_granos_ra80);
  pgbr81 = (RadioButton)findViewById(R.id.pre_garan_granos_ra81);
  pgbr82 = (RadioButton)findViewById(R.id.pre_garan_granos_ra82);
  pgbr83 = (RadioButton)findViewById(R.id.pre_garan_granos_ra83);
  pgbr84 = (RadioButton)findViewById(R.id.pre_garan_granos_ra84);
  pgbr85 = (RadioButton)findViewById(R.id.pre_garan_granos_ra85);
  pgbr86 = (RadioButton)findViewById(R.id.pre_garan_granos_ra86);
  pgbr87 = (RadioButton)findViewById(R.id.pre_garan_granos_ra87);
  pgbr88 = (RadioButton)findViewById(R.id.pre_garan_granos_ra88);

  pgbc11 = (CheckBox)findViewById(R.id.pre_garan_granos_ch11);
  pgbc12 = (CheckBox)findViewById(R.id.pre_garan_granos_ch12);
  pgbc13 = (CheckBox)findViewById(R.id.pre_garan_granos_ch13);
  pgbc14 = (CheckBox)findViewById(R.id.pre_garan_granos_ch14);
  pgbc15 = (CheckBox)findViewById(R.id.pre_garan_granos_ch15);
  pgbc16 = (CheckBox)findViewById(R.id.pre_garan_granos_ch16);
  pgbc17 = (CheckBox)findViewById(R.id.pre_garan_granos_ch17);
  pgbc18 = (CheckBox)findViewById(R.id.pre_garan_granos_ch18);
  pgbc19 = (CheckBox)findViewById(R.id.pre_garan_granos_ch19);

  pgbt25 = (EditText)findViewById(R.id.pre_garan_granos_tx25);

  pgbt26 = (EditText)findViewById(R.id.pre_garan_granos_txt26);
  pgbt27 = (EditText)findViewById(R.id.pre_garan_granos_txt27);
  pgbt28 = (EditText)findViewById(R.id.pre_garan_granos_txt28);
  pgbt29 = (EditText)findViewById(R.id.pre_garan_granos_txt29);

  btnSiguiente = findViewById(R.id.pre_garan_granos_sig);
  pgbt21.setVisibility(View.GONE);
  pgbt25.setVisibility(View.GONE);
  //pgbr68.setEnabled(false);
  //pgbr69.setEnabled(false);
  //pgbr70.setEnabled(false);


  muestrafecha();

  pgbs1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
   public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
    String[] estados = getResources().getStringArray(R.array.Estados2021);
    String[] cveestados = getResources().getStringArray(R.array.cveEstados2021);

    cveedo = cveestados[position];
    nomedo = estados[position];

    municipios = getResources().getStringArray(idmunicipios[position]);
    cvemunicipios = getResources().getStringArray(idcvemunicipios[position]);

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(PGBeneficiariosGranos.this, android.R.layout.simple_spinner_item, municipios);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    pgbs2.setAdapter(adapter);
    pgbs2.setEnabled(true);
   }
   public void onNothingSelected(AdapterView<?> adapterView) {
    return;
   }
  });

  pgbs2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
   public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
    nommun = municipios[position];
    cvemun = cvemunicipios[position];
   }
   public void onNothingSelected(AdapterView<?> adapterView) {
    return;
   }
  });

  pgbs3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
   public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
    String[] estados2 = getResources().getStringArray(R.array.Estados2021);
    String[] cveestados2 = getResources().getStringArray(R.array.cveEstados2021);

    cveedo2 = cveestados2[position];
    nomedo2 = estados2[position];

    municipios2 = getResources().getStringArray(idmunicipios2[position]);
    cvemunicipios2 = getResources().getStringArray(idcvemunicipios2[position]);

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(PGBeneficiariosGranos.this, android.R.layout.simple_spinner_item, municipios2);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    pgbs4.setAdapter(adapter);
    pgbs4.setEnabled(true);
   }
   public void onNothingSelected(AdapterView<?> adapterView) {
    return;
   }
  });

  pgbs4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
   public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
    nommun2 = municipios2[position];
    cvemun2 = cvemunicipios2[position];
   }
   public void onNothingSelected(AdapterView<?> adapterView) {
    return;
   }
  });


  RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radg1);
  radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
  {
   public void onCheckedChanged(RadioGroup group, int checkedId) {
    // checkedId is the RadioButton selected
    if(pgbr16.isChecked()==true){
     pgbt21.setVisibility(View.VISIBLE);
    }else{
     pgbt21.setVisibility(View.GONE);
    }
   }
  });

  pgbc19.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
   @Override
   public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
     if(pgbc19.isChecked()==true){
      pgbt25.setVisibility(View.VISIBLE);
     }else{
      pgbt25.setVisibility(View.GONE);
      pgbt25.setText("");
     }
    }
   }
  );




  btnSiguiente.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {

    if (validar()){
     String folio = General.Foliocuestion;

     General.fechaenc = textFecha.getText().toString();
     String claveEdo = cveedo;
     String nomEdo = nomedo;
     String claveMun = cvemun;
     String nomMun = nommun;
     String claveEdo2 = cveedo2;
     String nomEdo2 = nomedo2;
     String claveMun2 = cvemun2;
     String nomMun2 = nommun2;

     String pgbtt2 = pgbt2.getText().toString();
     String pgbtt3 = pgbt3.getText().toString();
     String pgbtt4 = pgbt4.getText().toString();
     String pgbtt5 = pgbt5.getText().toString();
     String pgbtt6 = pgbt6.getText().toString();
     String pgbtt7 = pgbt7.getText().toString();
     String pgbtt8 = pgbt8.getText().toString();
     String pgbtt9 = pgbt9.getText().toString();
     String pgbtt10 = pgbt10.getText().toString();
     String pgbtt13 = pgbt13.getText().toString();
     String pgbtt14= pgbt14.getText().toString();
     String pgbtt15 = pgbt15.getText().toString();
     String pgbtt16 = pgbt16.getText().toString();
     String pgbtt17 = pgbt17.getText().toString();
     String nomedo = pgbs1.getSelectedItem().toString();
     String nommun = pgbs2.getSelectedItem().toString();
     String pgr1 = obtenerRadio(pgbr1, pgbr2);
     String pgbtt20 = pgbt20.getText().toString();
     String pgr2 = obtenerRadio(pgbr3, pgbr4);
     String pgr3 = obtenerRadioo(pgbr5,pgbr6,pgbr7,pgbr8,pgbr9, pgbr10, pgbr11, pgbr12, pgbr13, pgbr14, pgbr15, pgbr16);
     String pgbtt21 = pgbt21.getText().toString();
     String pgr4 = obtenerRadio(pgbr18, pgbr19);
     //cantidad kg
     String pgbtt22 = pgbt22.getText().toString();
     String pgbtt23 = pgbt23.getText().toString();
     String pgbtt24 = pgbt24.getText().toString();
     String pgapoyo1 = apoyo1();
     String pgapoyo2 = apoyo2();
     String pgapoyo3 = apoyo3();
     String pgapoyo4 = apoyo4();
     String pgapoyo5 = apoyo5();
     String pgapoyo6 = apoyo6();
     String pgapoyo7 = apoyo7();
     String pgapoyo8 = apoyo8();
     String pgapoyo9 = apoyo9();
     String pgapoyo10 = apoyo10();
     //Documentación que entrego
     String pgr5 = obtenerRadio(pgbr21, pgbr22);
     String pgr6 = obtenerRadio(pgbr23, pgbr24);
     String pgr7 = obtenerRadio(pgbr25, pgbr26);
     String pgr8 = obtenerRadio(pgbr27, pgbr28);
     String pgr9 = obtenerRadio(pgbr29, pgbr30);
     String pgr10 = obtenerRadio(pgbr31, pgbr32);
     String pgr11 = obtenerRadio(pgbr33, pgbr34);
     String pgr12 = obtenerRadio(pgbr35, pgbr36);
     String pgr13 = obtenerRadio(pgbr37, pgbr38);
     String pgr14 = obtenerRadio(pgbr39, pgbr40);
     String pgr15 = obtenerRadio(pgbr41, pgbr42);
     String pgr16 = obtenerRadio(pgbr43, pgbr44);
     String pgr17 = obtenerRadio(pgbr45, pgbr46);
     String pgr18 = obtenerRadio(pgbr47, pgbr48);
     String pgr19 = obtenerRadio(pgbr49, pgbr50);
     String pgr20 = obtenerRadio(pgbr51, pgbr52);
     String pgr26 = obtenerRadioooo(pgbr68, pgbr69, pgbr70);
     String pgr27 = obtenerRadioooo(pgbr71, pgbr72, pgbr73);
     String pgr28 = obtenerRadioooo(pgbr74, pgbr75, pgbr76);
     String pgr29 = obtenerRadioooo(pgbr77, pgbr78, pgbr79);
     String pgr30 = obtenerRadioooo(pgbr80, pgbr81, pgbr82);
     String pgr31 = obtenerRadioooo(pgbr83, pgbr84, pgbr85);
     String pgr32 = obtenerRadioooo(pgbr86, pgbr87, pgbr88);

     //REquisitos
     String pgre1 = pgreq1();
     String pgre2 = pgreq2();
     String pgre3 = pgreq3();
     String pgre4 = pgreq4();
     String pgre5 = pgreq5();
     String pgre6 = pgreq6();
     String pgre7 = pgreq7();
     String pgre8 = pgreq8();
     String pgre9 = pgreq9();
     //otro
     String pgbtt25 = pgbt25.getText().toString();

     //abiertas
     String pgbtt26 = pgbt26.getText().toString();
     String pgbtt27 = pgbt27.getText().toString();
     String pgbtt28 = pgbt28.getText().toString();
     String pgbtt29 = pgbt29.getText().toString();

     String f1 = General.Foto1;
     String f2 = General.Foto2;

     model = new PGB_granos_model(folio, General.fechaenc, pgbtt2, pgbtt3, pgbtt4, pgbtt5, pgbtt6, pgbtt7, pgbtt8, pgbtt9, pgbtt10, nomedo, cveedo, nommun, cvemun, pgbtt13, pgbtt14, pgbtt15, pgbtt16, pgbtt17, nomedo2, cveedo2, nommun2, cvemun2, pgr1, pgbtt20, pgr2, pgr3, pgbtt21, pgr4, pgbtt22, pgbtt23, pgbtt24, pgapoyo1, pgapoyo2, pgapoyo3, pgapoyo4, pgapoyo5, pgapoyo6, pgapoyo7,pgapoyo8, pgapoyo9, pgapoyo10, pgr5, pgr6, pgr7, pgr8, pgr9, pgr10, pgr11, pgr12, pgr13, pgr14, pgr15, pgr16, pgr17, pgr18, pgr19, pgr20, pgr26, pgr27, pgr28, pgr29, pgr30, pgr31, pgr32, pgre1, pgre2, pgre3, pgre4, pgre5, pgre6, pgre7, pgre8, pgre9, pgbtt25, pgbtt26, pgbtt27, pgbtt28, pgbtt29, f1, f2, "", "");
     Intent in = new Intent(PGBeneficiariosGranos.this, GeoreferenciaActivity.class);
     in.putExtra("model", model);
     startActivity(in);

    }
    else{
     Toast.makeText(getApplicationContext(), "Faltan respuestas",Toast.LENGTH_SHORT).show();
    }
   }
  });





//finaliza el oncreate
 }

 public String obtenerRadio(RadioButton rbtt1, RadioButton rbtt2){
  //, RadioButton rbtt3, RadioButton rbtt4, RadioButton rbtt5, RadioButton rbtt6, RadioButton rbtt7, RadioButton rbtt8, RadioButton rbtt9, RadioButton rbtt10, RadioButton rbtt11){
  String respuesta = "";
  if (rbtt1.isChecked()==true){
   respuesta = rbtt1.getText().toString();
  }
  else if (rbtt2.isChecked()==true){
   respuesta = rbtt2.getText().toString();
  }
  return respuesta;
 }


 public String obtenerRadioo(RadioButton rbtt5, RadioButton rbtt6, RadioButton rbtt7, RadioButton rbtt8, RadioButton rbtt9, RadioButton rbtt10, RadioButton rbtt11, RadioButton rbtt12, RadioButton rbtt13, RadioButton rbtt14, RadioButton rbtt15, RadioButton rbtt16){

  String respuesta = "";
  if (rbtt5.isChecked()==true){
   respuesta = rbtt5.getText().toString();
  }
  else if (rbtt6.isChecked()==true){
   respuesta = rbtt6.getText().toString();
  }
  else if (rbtt7.isChecked()==true){
   respuesta = rbtt7.getText().toString();
  }
  else if (rbtt8.isChecked()==true){
   respuesta = rbtt8.getText().toString();
  }
  else if (rbtt9.isChecked()==true){
   respuesta = rbtt9.getText().toString();
  }
  else if (rbtt10.isChecked()==true){
   respuesta = rbtt10.getText().toString();
  }
  else if (rbtt11.isChecked()==true){
   respuesta = rbtt11.getText().toString();
  }
  else if (rbtt12.isChecked()==true){
   respuesta = rbtt12.getText().toString();
  }
  else if (rbtt13.isChecked()==true){
   respuesta = rbtt13.getText().toString();
  }
  else if (rbtt13.isChecked()==true){
   respuesta = rbtt14.getText().toString();
  }
  else if (rbtt13.isChecked()==true){
   respuesta = rbtt15.getText().toString();
  }
  else if (rbtt13.isChecked()==true){
   respuesta = rbtt16.getText().toString();
  }

  return respuesta;
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


 public String obtenerRadiooo(RadioButton rbtt18, RadioButton rbtt19, RadioButton rbtt20, RadioButton rbtt21){

  String respuesta = "";
  if (rbtt18.isChecked()==true){
   respuesta = rbtt18.getText().toString();
  }
  else if (rbtt19.isChecked()==true){
   respuesta = rbtt19.getText().toString();
  }
  else if (rbtt20.isChecked()==true){
   respuesta = rbtt20.getText().toString();
  }
  else if (rbtt21.isChecked()==true){
   respuesta = rbtt21.getText().toString();
  }
  return respuesta;
 }

 public String obtenerRadioooo(RadioButton rbtt22, RadioButton rbtt23, RadioButton rbtt24){

  String respuesta = "";
  if (rbtt22.isChecked()==true){
   respuesta = rbtt22.getText().toString();
  }
  else if (rbtt23.isChecked()==true){
   respuesta = rbtt23.getText().toString();
  }
  else if (rbtt24.isChecked()==true){
   respuesta = rbtt24.getText().toString();
  }
  return respuesta;
 }

 public boolean validar() {
  boolean retorno = true;

  if (pgbt2.getText().toString().isEmpty()){
   pgbt2.setError("No puede quedar vacío");
   retorno = false;
  }
  else if (pgbt3.getText().toString().isEmpty()){
   pgbt3.setError("No puede quedar vacío");
   retorno = false;
  }
  else if (pgbt4.getText().toString().isEmpty()){
   pgbt4.setError("No puede quedar vacío");
   retorno = false;
  }
  else if (pgbt5.getText().toString().isEmpty()){
   pgbt5.setError("No puede quedar vacío");
   retorno = false;
  }
  else if(!validarCURP(pgbt5.getText().toString())){
   pgbt5.setError("CURP invalido");
   retorno=false;
  }
  else if (pgbt6.getText().toString().isEmpty()){
   pgbt6.setError("No puede quedar vacío");
   retorno = false;
  }
  else if (pgbt9.getText().toString().isEmpty()){
   pgbt9.setError("No puede quedar vacío");
   retorno = false;
  }

  else if (pgbt13.getText().toString().isEmpty()){
   pgbt13.setError("No puede quedar vacío");
   retorno = false;
  }
  else if (pgbt16.getText().toString().isEmpty()){
   pgbt16.setError("No puede quedar vacío");
   retorno = false;
  }
  else if (pgbt17.getText().toString().isEmpty()){
   pgbt17.setError("No puede quedar vacío");
   retorno = false;
  }

  else if (!pgbr1.isChecked() && !pgbr2.isChecked()) {
   pgbr2.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr3.isChecked() && !pgbr4.isChecked()) {
   pgbr4.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr5.isChecked() && !pgbr6.isChecked() && !pgbr7.isChecked() && !pgbr8.isChecked() && !pgbr9.isChecked() && !pgbr10.isChecked() && !pgbr11.isChecked() && !pgbr12.isChecked() && !pgbr13.isChecked() && !pgbr14.isChecked() && !pgbr15.isChecked() && !pgbr16.isChecked()) {
   pgbr16.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr18.isChecked() && !pgbr19.isChecked()){
   pgbr19.setError("Debes seleccionar una opción");
   retorno = false;
  }

  else if (!pgbc1.isChecked() && !pgbc2.isChecked() && !pgbc3.isChecked() && !pgbc4.isChecked() && !pgbc5.isChecked() && !pgbc6.isChecked() && !pgbc7.isChecked() && !pgbc8.isChecked() && !pgbc9.isChecked() && !pgbc10.isChecked()){
   pgbc10.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr21.isChecked() && !pgbr22.isChecked()) {
   pgbr22.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr23.isChecked() && !pgbr24.isChecked()) {
   pgbr24.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr25.isChecked() && !pgbr26.isChecked()) {
   pgbr26.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr27.isChecked() && !pgbr28.isChecked()) {
   pgbr28.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr29.isChecked() && !pgbr30.isChecked()) {
   pgbr30.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr31.isChecked() && !pgbr32.isChecked()) {
   pgbr32.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr33.isChecked() && !pgbr34.isChecked()) {
   pgbr34.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr35.isChecked() && !pgbr36.isChecked()) {
   pgbr36.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr37.isChecked() && !pgbr38.isChecked()) {
   pgbr38.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr39.isChecked() && !pgbr40.isChecked()) {
   pgbr40.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr41.isChecked() && !pgbr42.isChecked()) {
   pgbr42.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr43.isChecked() && !pgbr44.isChecked()) {
   pgbr44.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr45.isChecked() && !pgbr46.isChecked()) {
   pgbr46.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr47.isChecked() && !pgbr48.isChecked()) {
   pgbr48.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr49.isChecked() && !pgbr50.isChecked()) {
   pgbr50.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr51.isChecked() && !pgbr52.isChecked()) {
   pgbr52.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr68.isChecked() && !pgbr69.isChecked() && !pgbr70.isChecked()) {
   pgbr70.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr71.isChecked() && !pgbr72.isChecked() && !pgbr73.isChecked()) {
   pgbr73.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr74.isChecked() && !pgbr75.isChecked() && !pgbr76.isChecked()) {
   pgbr76.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr77.isChecked() && !pgbr78.isChecked() && !pgbr79.isChecked()) {
   pgbr79.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr80.isChecked() && !pgbr81.isChecked() && !pgbr82.isChecked()) {
   pgbr82.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr83.isChecked() && !pgbr84.isChecked() && !pgbr85.isChecked()) {
   pgbr85.setError("Debes seleccionar una opción");
   retorno = false;
  }
  else if (!pgbr86.isChecked() && !pgbr87.isChecked() && !pgbr88.isChecked()) {
   pgbr88.setError("Debes seleccionar una opción");
   retorno = false;
  }

  return retorno;
 }


 public String apoyo1(){
  String resultado1 = "";
  if (pgbc1.isChecked()){
   resultado1 = "X";
  }
  return resultado1;
 }

 public String apoyo2(){
  String resultado2 = "";
  if (pgbc2.isChecked()){
   resultado2 = "X";
  }
  return resultado2;
 }

 public String apoyo3(){
  String resultado3 = "";
  if (pgbc3.isChecked()){
   resultado3 = "X";
  }
  return resultado3;
 }

 public String apoyo4(){
  String resultado4 = "";
  if (pgbc4.isChecked()){
   resultado4 = "X";
  }
  return resultado4;
 }

 public String apoyo5(){
  String resultado5 = "";
  if (pgbc5.isChecked()){
   resultado5 = "X";
  }
  return resultado5;
 }

 public String apoyo6(){
  String resultado6 = "";
  if (pgbc6.isChecked()){
   resultado6 = "X";
  }
  return resultado6;
 }

 public String apoyo7(){
  String resultado7 = "";
  if (pgbc7.isChecked()){
   resultado7 = "X";
  }
  return resultado7;
 }

 public String apoyo8(){
  String resultado8 = "";
  if (pgbc8.isChecked()){
   resultado8 = "X";
  }
  return resultado8;
 }

 public String apoyo9(){
  String resultado9 = "";
  if (pgbc9.isChecked()){
   resultado9 = "X";
  }
  return resultado9;
 }

 public String apoyo10(){
  String resultado10 = "";
  if (pgbc10.isChecked()){
   resultado10 = "X";
  }
  return resultado10;
 }


 public String pgreq1(){
  String resultado11 = "";
  if (pgbc11.isChecked()){
   resultado11 = "X";
  }
  return resultado11;
 }

 public String pgreq2(){
  String resultado12 = "";
  if (pgbc12.isChecked()){
   resultado12 = "X";
  }
  return resultado12;
 }

 public String pgreq3(){
  String resultado13 = "";
  if (pgbc13.isChecked()){
   resultado13 = "X";
  }
  return resultado13;
 }

 public String pgreq4(){
  String resultado14 = "";
  if (pgbc14.isChecked()){
   resultado14 = "X";
  }
  return resultado14;
 }

 public String pgreq5(){
  String resultado15 = "";
  if (pgbc15.isChecked()){
   resultado15 = "X";
  }
  return resultado15;
 }

 public String pgreq6(){
  String resultado16 = "";
  if (pgbc16.isChecked()){
   resultado16 = "X";
  }
  return resultado16;
 }

 public String pgreq7(){
  String resultado17 = "";
  if (pgbc17.isChecked()){
   resultado17 = "X";
  }
  return resultado17;
 }

 public String pgreq8(){
  String resultado18 = "";
  if (pgbc18.isChecked()){
   resultado18 = "X";
  }
  return resultado18;
 }

 public String pgreq9(){
  String resultado19 = "";
  if (pgbc19.isChecked()){
   resultado19 = "X";
  }
  return resultado19;
 }

 public void muestrafecha(){
  Calendar fecha = Calendar.getInstance();
  dia = fecha.get(Calendar.DAY_OF_MONTH);
  mes = fecha.get(Calendar.MONTH);
  anio = fecha.get(Calendar.YEAR);
  textFecha.setText(""+dia+"/"+(mes+1)+"/"+anio);
 }








 @Override
 public void onBackPressed() {

 }
}