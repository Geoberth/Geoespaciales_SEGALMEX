package com.example.geosegalmex.PGBeneficiariosGranosIncentivos;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Georeferencia.GeoreferenciaActivity;
import com.example.geosegalmex.PGBeneficiarioGranos.PGB_granos_model;
import com.example.geosegalmex.PGBeneficiarioGranos.PGBeneficiariosGranos;
import com.example.geosegalmex.R;

import android.content.Intent;
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

public class PGBeneficiariosGranosIncentivos extends AppCompatActivity {

    TextView textFecha, pgbs3_1_1, pgbs4_1_2, pgbs3_2_1, pgbs4_2_2, pgbs3_3_1, pgbs4_3_2, pgbs3_4_1, pgbs4_4_2;
    int dia, mes, anio;
    EditText pgbt2, pgbt3, pgbt4, pgbt5, pgbt6, pgbt7, pgbt8, pgbt9, pgbt10, pgbt13, pgbt14, pgbt15, pgbt16, pgbt17, pgbt20, pgbt21, pgbt22, pgbt23, pgbt24, pgbt25, pgbt26, pgbt27, pgbt28, pgbt29, pgbt30;
    RadioButton pgbr1, pgbr2, pgbr3, pgbr4, pgbr5, pgbr6, pgbr7, pgbr8, pgbr9, pgbr10, pgbr11, pgbr12, pgbr13, pgbr14, pgbr15, pgbr16,pgbr18, pgbr19, pgbr19_1, pgbr21, pgbr22, pgbr23, pgbr24, pgbr25, pgbr26, pgbr27, pgbr28, pgbr29, pgbr30, pgbr31, pgbr32, pgbr33, pgbr34, pgbr35, pgbr36, pgbr37, pgbr38, pgbr39, pgbr40, pgbr41, pgbr42, pgbr43, pgbr44, pgbr45, pgbr46, pgbr45_1, pgbr46_1, pgbr49, pgbr50, pgbr51, pgbr52, pgbr68, pgbr69, pgbr70, pgbr71, pgbr72, pgbr73, pgbr74, pgbr75, pgbr76, pgbr77, pgbr78, pgbr79, pgbr80, pgbr81, pgbr82, pgbr83, pgbr84, pgbr85, pgbr86, pgbr87, pgbr88;
    RadioButton pgbr51_1,pgbr52_1,pgbr51_2,pgbr52_2,pgbr51_3,pgbr52_3,pgbr51_4,pgbr52_4, parrad11,parrad22,parrad33,parrad44,parrad55;
    Spinner pgbs1, pgbs2, pgbs3, pgbs4, pgbs3_1, pgbs4_1, pgbs3_2, pgbs4_2, pgbs3_3, pgbs4_3, pgbs3_4, pgbs4_4;
    CheckBox pgbc1, pgbc2, pgbc3, pgbc4, pgbc5, pgbc6, pgbc8, pgbc10, pgbc11, pgbc12, pgbc13, pgbc14, pgbc15, pgbc16, pgbc17, pgbc18, pgbc19, pgbc20;
    Button btnSiguiente;

    PGBeneficiariosGranosIncentivos_Model model;

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

    EditText etcveedo, etcvemun, etcveedo2, etcvemun2;

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

    String cveedo3 = "";
    String nomedo3 = "";
    String cvemun3 = "";
    String nommun3 = "";
    int[] idmunicipios3 = {R.array.Aguascalientes2021, R.array.BajaCalifornia2021, R.array.BajaCaliforniaSur2021, R.array.Campeche2021, R.array.CoahuiladeZaragoza2021, R.array.Colima2021, R.array.Chiapas2021, R.array.Chihuahua2021, R.array.CiudaddeMéxico2021
            , R.array.Durango2021, R.array.Guanajuato2021, R.array.Guerrero2021, R.array.Hidalgo2021, R.array.Jalisco2021, R.array.México2021, R.array.MichoacándeOcampo2021, R.array.Morelos2021, R.array.Nayarit2021, R.array.NuevoLeón2021, R.array.Oaxaca2021
            , R.array.Puebla2021, R.array.Querétaro2021, R.array.QuintanaRoo2021, R.array.SanLuisPotosí2021, R.array.Sinaloa2021, R.array.Sonora2021, R.array.Tabasco2021, R.array.Tamaulipas2021, R.array.Tlaxcala2021, R.array.VeracruzdeIgnaciodelaLlave2021
            , R.array.Yucatán2021, R.array.Zacatecas2021};
    int[] idcvemunicipios3 = {R.array.cveAguascalientes2021, R.array.cveBajaCalifornia2021, R.array.cveBajaCaliforniaSur2021, R.array.cveCampeche2021, R.array.cveCoahuiladeZaragoza2021, R.array.cveColima2021, R.array.cveChiapas2021, R.array.cveChihuahua2021, R.array.cveCiudaddeMéxico2021
            , R.array.cveDurango2021, R.array.cveGuanajuato2021, R.array.cveGuerrero2021, R.array.cveHidalgo2021, R.array.cveJalisco2021, R.array.cveMéxico2021, R.array.cveMichoacándeOcampo2021, R.array.cveMorelos2021, R.array.cveNayarit2021, R.array.cveNuevoLeón2021, R.array.cveOaxaca2021
            , R.array.cvePuebla2021, R.array.cveQuerétaro2021, R.array.cveQuintanaRoo2021, R.array.cveSanLuisPotosí2021, R.array.cveSinaloa2021, R.array.cveSonora2021, R.array.cveTabasco2021, R.array.cveTamaulipas2021, R.array.cveTlaxcala2021, R.array.cveVeracruzdeIgnaciodelaLlave2021
            , R.array.cveYucatán2021, R.array.cveZacatecas2021
    };
    String[] municipios3;
    String[] cvemunicipios3;

    String cveedo4 = "";
    String nomedo4 = "";
    String cvemun4 = "";
    String nommun4 = "";
    int[] idmunicipios4 = {R.array.Aguascalientes2021, R.array.BajaCalifornia2021, R.array.BajaCaliforniaSur2021, R.array.Campeche2021, R.array.CoahuiladeZaragoza2021, R.array.Colima2021, R.array.Chiapas2021, R.array.Chihuahua2021, R.array.CiudaddeMéxico2021
            , R.array.Durango2021, R.array.Guanajuato2021, R.array.Guerrero2021, R.array.Hidalgo2021, R.array.Jalisco2021, R.array.México2021, R.array.MichoacándeOcampo2021, R.array.Morelos2021, R.array.Nayarit2021, R.array.NuevoLeón2021, R.array.Oaxaca2021
            , R.array.Puebla2021, R.array.Querétaro2021, R.array.QuintanaRoo2021, R.array.SanLuisPotosí2021, R.array.Sinaloa2021, R.array.Sonora2021, R.array.Tabasco2021, R.array.Tamaulipas2021, R.array.Tlaxcala2021, R.array.VeracruzdeIgnaciodelaLlave2021
            , R.array.Yucatán2021, R.array.Zacatecas2021};
    int[] idcvemunicipios4 = {R.array.cveAguascalientes2021, R.array.cveBajaCalifornia2021, R.array.cveBajaCaliforniaSur2021, R.array.cveCampeche2021, R.array.cveCoahuiladeZaragoza2021, R.array.cveColima2021, R.array.cveChiapas2021, R.array.cveChihuahua2021, R.array.cveCiudaddeMéxico2021
            , R.array.cveDurango2021, R.array.cveGuanajuato2021, R.array.cveGuerrero2021, R.array.cveHidalgo2021, R.array.cveJalisco2021, R.array.cveMéxico2021, R.array.cveMichoacándeOcampo2021, R.array.cveMorelos2021, R.array.cveNayarit2021, R.array.cveNuevoLeón2021, R.array.cveOaxaca2021
            , R.array.cvePuebla2021, R.array.cveQuerétaro2021, R.array.cveQuintanaRoo2021, R.array.cveSanLuisPotosí2021, R.array.cveSinaloa2021, R.array.cveSonora2021, R.array.cveTabasco2021, R.array.cveTamaulipas2021, R.array.cveTlaxcala2021, R.array.cveVeracruzdeIgnaciodelaLlave2021
            , R.array.cveYucatán2021, R.array.cveZacatecas2021
    };
    String[] municipios4;
    String[] cvemunicipios4;

    String cveedo5 = "";
    String nomedo5 = "";
    String cvemun5 = "";
    String nommun5 = "";
    int[] idmunicipios5 = {R.array.Aguascalientes2021, R.array.BajaCalifornia2021, R.array.BajaCaliforniaSur2021, R.array.Campeche2021, R.array.CoahuiladeZaragoza2021, R.array.Colima2021, R.array.Chiapas2021, R.array.Chihuahua2021, R.array.CiudaddeMéxico2021
            , R.array.Durango2021, R.array.Guanajuato2021, R.array.Guerrero2021, R.array.Hidalgo2021, R.array.Jalisco2021, R.array.México2021, R.array.MichoacándeOcampo2021, R.array.Morelos2021, R.array.Nayarit2021, R.array.NuevoLeón2021, R.array.Oaxaca2021
            , R.array.Puebla2021, R.array.Querétaro2021, R.array.QuintanaRoo2021, R.array.SanLuisPotosí2021, R.array.Sinaloa2021, R.array.Sonora2021, R.array.Tabasco2021, R.array.Tamaulipas2021, R.array.Tlaxcala2021, R.array.VeracruzdeIgnaciodelaLlave2021
            , R.array.Yucatán2021, R.array.Zacatecas2021};
    int[] idcvemunicipios5 = {R.array.cveAguascalientes2021, R.array.cveBajaCalifornia2021, R.array.cveBajaCaliforniaSur2021, R.array.cveCampeche2021, R.array.cveCoahuiladeZaragoza2021, R.array.cveColima2021, R.array.cveChiapas2021, R.array.cveChihuahua2021, R.array.cveCiudaddeMéxico2021
            , R.array.cveDurango2021, R.array.cveGuanajuato2021, R.array.cveGuerrero2021, R.array.cveHidalgo2021, R.array.cveJalisco2021, R.array.cveMéxico2021, R.array.cveMichoacándeOcampo2021, R.array.cveMorelos2021, R.array.cveNayarit2021, R.array.cveNuevoLeón2021, R.array.cveOaxaca2021
            , R.array.cvePuebla2021, R.array.cveQuerétaro2021, R.array.cveQuintanaRoo2021, R.array.cveSanLuisPotosí2021, R.array.cveSinaloa2021, R.array.cveSonora2021, R.array.cveTabasco2021, R.array.cveTamaulipas2021, R.array.cveTlaxcala2021, R.array.cveVeracruzdeIgnaciodelaLlave2021
            , R.array.cveYucatán2021, R.array.cveZacatecas2021
    };
    String[] municipios5;
    String[] cvemunicipios5;

    String cveedo6 = "";
    String nomedo6 = "";
    String cvemun6 = "";
    String nommun6 = "";
    int[] idmunicipios6 = {R.array.Aguascalientes2021, R.array.BajaCalifornia2021, R.array.BajaCaliforniaSur2021, R.array.Campeche2021, R.array.CoahuiladeZaragoza2021, R.array.Colima2021, R.array.Chiapas2021, R.array.Chihuahua2021, R.array.CiudaddeMéxico2021
            , R.array.Durango2021, R.array.Guanajuato2021, R.array.Guerrero2021, R.array.Hidalgo2021, R.array.Jalisco2021, R.array.México2021, R.array.MichoacándeOcampo2021, R.array.Morelos2021, R.array.Nayarit2021, R.array.NuevoLeón2021, R.array.Oaxaca2021
            , R.array.Puebla2021, R.array.Querétaro2021, R.array.QuintanaRoo2021, R.array.SanLuisPotosí2021, R.array.Sinaloa2021, R.array.Sonora2021, R.array.Tabasco2021, R.array.Tamaulipas2021, R.array.Tlaxcala2021, R.array.VeracruzdeIgnaciodelaLlave2021
            , R.array.Yucatán2021, R.array.Zacatecas2021};
    int[] idcvemunicipios6 = {R.array.cveAguascalientes2021, R.array.cveBajaCalifornia2021, R.array.cveBajaCaliforniaSur2021, R.array.cveCampeche2021, R.array.cveCoahuiladeZaragoza2021, R.array.cveColima2021, R.array.cveChiapas2021, R.array.cveChihuahua2021, R.array.cveCiudaddeMéxico2021
            , R.array.cveDurango2021, R.array.cveGuanajuato2021, R.array.cveGuerrero2021, R.array.cveHidalgo2021, R.array.cveJalisco2021, R.array.cveMéxico2021, R.array.cveMichoacándeOcampo2021, R.array.cveMorelos2021, R.array.cveNayarit2021, R.array.cveNuevoLeón2021, R.array.cveOaxaca2021
            , R.array.cvePuebla2021, R.array.cveQuerétaro2021, R.array.cveQuintanaRoo2021, R.array.cveSanLuisPotosí2021, R.array.cveSinaloa2021, R.array.cveSonora2021, R.array.cveTabasco2021, R.array.cveTamaulipas2021, R.array.cveTlaxcala2021, R.array.cveVeracruzdeIgnaciodelaLlave2021
            , R.array.cveYucatán2021, R.array.cveZacatecas2021
    };
    String[] municipios6;
    String[] cvemunicipios6;
    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgbeneficiarios_granos_incentivos);

        etcveedo = (EditText)findViewById(R.id.dospgb_o_cveedo);
        etcvemun = (EditText)findViewById(R.id.dospgb_o_cvemun);
        etcveedo2 = (EditText)findViewById(R.id.dospgb_o_cveedo2);
        etcvemun2 = (EditText)findViewById(R.id.dospgb_o_cvemun2);


        textFecha=(TextView)findViewById(R.id.dospg_leche_txtFecha);
        pgbt2 = (EditText)findViewById(R.id.dospre_garan_granos_txt2);
        pgbt3 = (EditText)findViewById(R.id.dospre_garan_granos_txt3);
        pgbt4 = (EditText)findViewById(R.id.dospre_garan_granos_txt4);
        pgbt5 = (EditText)findViewById(R.id.dospre_garan_granos_txt5);

        //proyecto
        pgbt6 = (EditText)findViewById(R.id.dospre_garan_granos_txt6);
        pgbt7 = (EditText)findViewById(R.id.dospre_garan_granos_txt7);
        pgbt8 = (EditText)findViewById(R.id.dospre_garan_granos_txt8);
        pgbt9 = (EditText)findViewById(R.id.dospre_garan_granos_txt9);
        pgbt10 = (EditText)findViewById(R.id.dospre_garan_granos_txt10);

        pgbs1 = (Spinner)findViewById(R.id.dospgb_o_spiEstado);
        pgbs2 = (Spinner)findViewById(R.id.dospgb_o_spiMunicipio);


        //Dirección producción
        pgbt16 = (EditText)findViewById(R.id.dospre_garan_granos_txt16);
        pgbt17 = (EditText)findViewById(R.id.dospre_garan_granos_txt17);

        pgbs3 = (Spinner)findViewById(R.id.dospgb_o_spiEstado2);

        pgbs4 = (Spinner)findViewById(R.id.dospgb_o_spiMunicipio2);

        parrad11 = (RadioButton)findViewById(R.id.parrad1);
        parrad22 = (RadioButton)findViewById(R.id.parrad2);
        parrad33 = (RadioButton)findViewById(R.id.parrad3);
        parrad44 = (RadioButton)findViewById(R.id.parrad4);
        parrad55 = (RadioButton)findViewById(R.id.parrad5);

        pgbs3_1 = (Spinner)findViewById(R.id.dospgb_o_spiEstado3);
        pgbs4_1 = (Spinner)findViewById(R.id.dospgb_o_spiMunicipio3);
        pgbs3_1_1 = (TextView)findViewById(R.id.dospgb_o_spiEstado3_1);
        pgbs4_1_2 = (TextView)findViewById(R.id.dospgb_o_spiEstado3_2);

        pgbs3_2 = (Spinner)findViewById(R.id.dospgb_o_spiEstado4);
        pgbs4_2 = (Spinner)findViewById(R.id.dospgb_o_spiMunicipio4);
        pgbs3_2_1 = (TextView)findViewById(R.id.dospgb_o_spiEstado4_1);
        pgbs4_2_2 = (TextView)findViewById(R.id.dospgb_o_spiEstado4_2);

        pgbs3_3 = (Spinner)findViewById(R.id.dospgb_o_spiEstado5);
        pgbs4_3 = (Spinner)findViewById(R.id.dospgb_o_spiMunicipio5);
        pgbs3_3_1 = (TextView)findViewById(R.id.dospgb_o_spiEstado5_1);
        pgbs4_3_2 = (TextView)findViewById(R.id.dospgb_o_spiEstado5_2);

        pgbs3_4 = (Spinner)findViewById(R.id.dospgb_o_spiEstado6);
        pgbs4_4 = (Spinner)findViewById(R.id.dospgb_o_spiMunicipio6);
        pgbs3_4_1 = (TextView)findViewById(R.id.dospgb_o_spiEstado6_1);
        pgbs4_4_2 = (TextView)findViewById(R.id.dospgb_o_spiEstado6_2);

        //sexo
        pgbr1 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra2_1);
        pgbr2 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra2_2);
        pgbt20 = (EditText)findViewById(R.id.dospre_garan_granos_txt20);

        pgbr3 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra3);
        pgbr4 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra4);

        //ESTUDIOS
        pgbr5 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra5);
        pgbr6 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra6);
        pgbr7 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra7);
        pgbr8 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra8);
        pgbr9 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra9);
        pgbr10 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra10);
        pgbr11 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra11);
        pgbr12 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra12);
        pgbr13 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra13);
        pgbr14 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra14);
        pgbr15 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra15);
        pgbr16 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra16);

        pgbt21 = (EditText)findViewById(R.id.dospre_garan_granos_txt21);

        //Producto
        pgbr18 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra18);
        pgbr19 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra19);
        pgbr19_1 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra19_1);

        pgbt22 = (EditText)findViewById(R.id.dospre_garan_granos_tx22);

        //info. apoyo
        pgbc1 = (CheckBox)findViewById(R.id.dospre_garan_granos_ch1);
        pgbc2 = (CheckBox)findViewById(R.id.dospre_garan_granos_ch2);
        pgbc3 = (CheckBox)findViewById(R.id.dospre_garan_granos_ch3);
        pgbc4 = (CheckBox)findViewById(R.id.dospre_garan_granos_ch4);
        pgbc5 = (CheckBox)findViewById(R.id.dospre_garan_granos_ch5);
        pgbc6 = (CheckBox)findViewById(R.id.dospre_garan_granos_ch6);
        pgbc8 = (CheckBox)findViewById(R.id.dospre_garan_granos_ch8);
        pgbc10 = (CheckBox)findViewById(R.id.dospre_garan_granos_ch10);


        pgbr21 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra21);
        pgbr22 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra22);

        pgbr23 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra23);
        pgbr24 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra24);

        pgbr25 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra25);
        pgbr26 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra26);

        pgbr27 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra27);
        pgbr28 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra28);

        pgbr29 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra29);
        pgbr30 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra30);

        pgbr31 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra31);
        pgbr32 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra32);

        pgbr33 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra33);
        pgbr34 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra34);

        pgbr35 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra35);
        pgbr36 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra36);

        pgbr37 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra37);
        pgbr38 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra38);

        pgbr39 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra39);
        pgbr40 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra40);

        pgbr41 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra41);
        pgbr42 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra42);

        pgbr43 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra43);
        pgbr44 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra44);

        pgbr45 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra45);
        pgbr46 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra46);

        pgbr45_1 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra45_1);
        pgbr46_1 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra46_1);

        pgbr51 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra51);
        pgbr52 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra52);
        pgbr51_1 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra51_1);
        pgbr52_1 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra52_1);
        pgbr51_2 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra51_2);
        pgbr52_2 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra52_2);
        pgbr51_3 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra51_3);
        pgbr52_3 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra52_3);
        pgbr51_4 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra51_4);
        pgbr52_4 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra52_4);

        pgbr68 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra68);
        pgbr69 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra69);
        pgbr70 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra70);
        pgbr71 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra71);
        pgbr72 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra72);
        pgbr73 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra73);
        pgbr74 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra74);
        pgbr75 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra75);
        pgbr76 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra76);
        pgbr77 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra77);
        pgbr78 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra78);
        pgbr79 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra79);
        pgbr80 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra80);
        pgbr81 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra81);
        pgbr82 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra82);
        pgbr83 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra83);
        pgbr84 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra84);
        pgbr85 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra85);
        pgbr86 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra86);
        pgbr87 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra87);
        pgbr88 = (RadioButton)findViewById(R.id.dospre_garan_granos_ra88);

        pgbc11 = (CheckBox)findViewById(R.id.dospre_garan_granos_ch11);
        pgbc12 = (CheckBox)findViewById(R.id.dospre_garan_granos_ch12);
        pgbc13 = (CheckBox)findViewById(R.id.dospre_garan_granos_ch13);
        pgbc14 = (CheckBox)findViewById(R.id.dospre_garan_granos_ch14);
        pgbc15 = (CheckBox)findViewById(R.id.dospre_garan_granos_ch15);
        pgbc16 = (CheckBox)findViewById(R.id.dospre_garan_granos_ch16);
        pgbc17 = (CheckBox)findViewById(R.id.dospre_garan_granos_ch17);
        pgbc18 = (CheckBox)findViewById(R.id.dospre_garan_granos_ch18);
        pgbc20 = (CheckBox)findViewById(R.id.dospre_garan_granos_ch20);
        pgbc19 = (CheckBox)findViewById(R.id.dospre_garan_granos_ch19);

        pgbt25 = (EditText)findViewById(R.id.dospre_garan_granos_tx25);

        pgbt26 = (EditText)findViewById(R.id.dospre_garan_granos_txt26);
        pgbt27 = (EditText)findViewById(R.id.dospre_garan_granos_txt27);
        pgbt28 = (EditText)findViewById(R.id.dospre_garan_granos_txt28);
        pgbt29 = (EditText)findViewById(R.id.dospre_garan_granos_txt29);

        btnSiguiente = findViewById(R.id.dospre_garan_granos_sig);
        pgbt21.setVisibility(View.GONE);
        pgbt25.setVisibility(View.GONE);

        muestrafecha();
        pgbs3_1.setVisibility(View.GONE);
        pgbs4_1.setVisibility(View.GONE);
        pgbs3_1_1.setVisibility(View.GONE);
        pgbs4_1_2.setVisibility(View.GONE);
        pgbs3_2.setVisibility(View.GONE);
        pgbs4_2.setVisibility(View.GONE);
        pgbs3_2_1.setVisibility(View.GONE);
        pgbs4_2_2.setVisibility(View.GONE);
        pgbs3_3.setVisibility(View.GONE);
        pgbs4_3.setVisibility(View.GONE);
        pgbs3_3_1.setVisibility(View.GONE);
        pgbs4_3_2.setVisibility(View.GONE);
        pgbs3_4.setVisibility(View.GONE);
        pgbs4_4.setVisibility(View.GONE);
        pgbs3_4_1.setVisibility(View.GONE);
        pgbs4_4_2.setVisibility(View.GONE);

        pgbs1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String[] estados = getResources().getStringArray(R.array.Estados2021);
                String[] cveestados = getResources().getStringArray(R.array.cveEstados2021);

                cveedo = cveestados[position];
                nomedo = estados[position];
                etcveedo.setText(cveedo);

                municipios = getResources().getStringArray(idmunicipios[position]);
                cvemunicipios = getResources().getStringArray(idcvemunicipios[position]);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(PGBeneficiariosGranosIncentivos.this, android.R.layout.simple_spinner_item, municipios);
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
                etcvemun.setText(cvemun);
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
                etcveedo2.setText(cveedo2);

                municipios2 = getResources().getStringArray(idmunicipios2[position]);
                cvemunicipios2 = getResources().getStringArray(idcvemunicipios2[position]);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(PGBeneficiariosGranosIncentivos.this, android.R.layout.simple_spinner_item, municipios2);
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
                etcvemun2.setText(cvemun2);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });





        pgbs3_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String[] estados3 = getResources().getStringArray(R.array.Estados2021);
                String[] cveestados3 = getResources().getStringArray(R.array.cveEstados2021);

                cveedo3 = cveestados3[position];
                nomedo3 = estados3[position];

                municipios3 = getResources().getStringArray(idmunicipios3[position]);
                cvemunicipios3 = getResources().getStringArray(idcvemunicipios3[position]);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(PGBeneficiariosGranosIncentivos.this, android.R.layout.simple_spinner_item, municipios3);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                pgbs4_1.setAdapter(adapter);
                pgbs4_1.setEnabled(true);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        pgbs4_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                nommun3 = municipios3[position];
                cvemun3 = cvemunicipios3[position];
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        pgbs3_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String[] estados4 = getResources().getStringArray(R.array.Estados2021);
                String[] cveestados4 = getResources().getStringArray(R.array.cveEstados2021);

                cveedo4 = cveestados4[position];
                nomedo4 = estados4[position];

                municipios4 = getResources().getStringArray(idmunicipios4[position]);
                cvemunicipios4 = getResources().getStringArray(idcvemunicipios4[position]);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(PGBeneficiariosGranosIncentivos.this, android.R.layout.simple_spinner_item, municipios4);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                pgbs4_2.setAdapter(adapter);
                pgbs4_2.setEnabled(true);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        pgbs4_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                nommun4 = municipios4[position];
                cvemun4 = cvemunicipios4[position];
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        pgbs3_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String[] estados5 = getResources().getStringArray(R.array.Estados2021);
                String[] cveestados5 = getResources().getStringArray(R.array.cveEstados2021);

                cveedo5 = cveestados5[position];
                nomedo5 = estados5[position];

                municipios5 = getResources().getStringArray(idmunicipios5[position]);
                cvemunicipios5 = getResources().getStringArray(idcvemunicipios5[position]);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(PGBeneficiariosGranosIncentivos.this, android.R.layout.simple_spinner_item, municipios5);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                pgbs4_3.setAdapter(adapter);
                pgbs4_3.setEnabled(true);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        pgbs4_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                nommun5 = municipios5[position];
                cvemun5 = cvemunicipios5[position];
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        pgbs3_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String[] estados6 = getResources().getStringArray(R.array.Estados2021);
                String[] cveestados6 = getResources().getStringArray(R.array.cveEstados2021);

                cveedo6 = cveestados6[position];
                nomedo6 = estados6[position];

                municipios6 = getResources().getStringArray(idmunicipios6[position]);
                cvemunicipios6 = getResources().getStringArray(idcvemunicipios6[position]);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(PGBeneficiariosGranosIncentivos.this, android.R.layout.simple_spinner_item, municipios6);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                pgbs4_4.setAdapter(adapter);
                pgbs4_4.setEnabled(true);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        pgbs4_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                nommun6 = municipios6[position];
                cvemun6 = cvemunicipios6[position];
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });




        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.dosradg1);
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

        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.group7_1);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(parrad11.isChecked()==true){
                    pgbs3_1.setVisibility(View.GONE);
                    pgbs4_1.setVisibility(View.GONE);
                    pgbs3_1_1.setVisibility(View.GONE);
                    pgbs4_1_2.setVisibility(View.GONE);

                    pgbs3_2.setVisibility(View.GONE);
                    pgbs4_2.setVisibility(View.GONE);
                    pgbs3_2_1.setVisibility(View.GONE);
                    pgbs4_2_2.setVisibility(View.GONE);

                    pgbs3_3.setVisibility(View.GONE);
                    pgbs4_3.setVisibility(View.GONE);
                    pgbs3_3_1.setVisibility(View.GONE);
                    pgbs4_3_2.setVisibility(View.GONE);

                    pgbs3_4.setVisibility(View.GONE);
                    pgbs4_4.setVisibility(View.GONE);
                    pgbs3_4_1.setVisibility(View.GONE);
                    pgbs4_4_2.setVisibility(View.GONE);
                }
                else if(parrad22.isChecked()==true){
                    pgbs3_1.setVisibility(View.VISIBLE);
                    pgbs4_1.setVisibility(View.VISIBLE);
                    pgbs3_1_1.setVisibility(View.VISIBLE);
                    pgbs4_1_2.setVisibility(View.VISIBLE);

                    pgbs3_2.setVisibility(View.GONE);
                    pgbs4_2.setVisibility(View.GONE);
                    pgbs3_2_1.setVisibility(View.GONE);
                    pgbs4_2_2.setVisibility(View.GONE);

                    pgbs3_3.setVisibility(View.GONE);
                    pgbs4_3.setVisibility(View.GONE);
                    pgbs3_3_1.setVisibility(View.GONE);
                    pgbs4_3_2.setVisibility(View.GONE);

                    pgbs3_4.setVisibility(View.GONE);
                    pgbs4_4.setVisibility(View.GONE);
                    pgbs3_4_1.setVisibility(View.GONE);
                    pgbs4_4_2.setVisibility(View.GONE);
                }
                else if(parrad33.isChecked()==true){
                    pgbs3_1.setVisibility(View.VISIBLE);
                    pgbs4_1.setVisibility(View.VISIBLE);
                    pgbs3_1_1.setVisibility(View.VISIBLE);
                    pgbs4_1_2.setVisibility(View.VISIBLE);

                    pgbs3_2.setVisibility(View.VISIBLE);
                    pgbs4_2.setVisibility(View.VISIBLE);
                    pgbs3_2_1.setVisibility(View.VISIBLE);
                    pgbs4_2_2.setVisibility(View.VISIBLE);

                    pgbs3_3.setVisibility(View.GONE);
                    pgbs4_3.setVisibility(View.GONE);
                    pgbs3_3_1.setVisibility(View.GONE);
                    pgbs4_3_2.setVisibility(View.GONE);

                    pgbs3_4.setVisibility(View.GONE);
                    pgbs4_4.setVisibility(View.GONE);
                    pgbs3_4_1.setVisibility(View.GONE);
                    pgbs4_4_2.setVisibility(View.GONE);
                }
                else if(parrad44.isChecked()==true){
                    pgbs3_1.setVisibility(View.VISIBLE);
                    pgbs4_1.setVisibility(View.VISIBLE);
                    pgbs3_1_1.setVisibility(View.VISIBLE);
                    pgbs4_1_2.setVisibility(View.VISIBLE);

                    pgbs3_2.setVisibility(View.VISIBLE);
                    pgbs4_2.setVisibility(View.VISIBLE);
                    pgbs3_2_1.setVisibility(View.VISIBLE);
                    pgbs4_2_2.setVisibility(View.VISIBLE);

                    pgbs3_3.setVisibility(View.VISIBLE);
                    pgbs4_3.setVisibility(View.VISIBLE);
                    pgbs3_3_1.setVisibility(View.VISIBLE);
                    pgbs4_3_2.setVisibility(View.VISIBLE);

                    pgbs3_4.setVisibility(View.GONE);
                    pgbs4_4.setVisibility(View.GONE);
                    pgbs3_4_1.setVisibility(View.GONE);
                    pgbs4_4_2.setVisibility(View.GONE);

                }
                else if(parrad55.isChecked()==true){
                    pgbs3_1.setVisibility(View.VISIBLE);
                    pgbs4_1.setVisibility(View.VISIBLE);
                    pgbs3_1_1.setVisibility(View.VISIBLE);
                    pgbs4_1_2.setVisibility(View.VISIBLE);

                    pgbs3_2.setVisibility(View.VISIBLE);
                    pgbs4_2.setVisibility(View.VISIBLE);
                    pgbs3_2_1.setVisibility(View.VISIBLE);
                    pgbs4_2_2.setVisibility(View.VISIBLE);

                    pgbs3_3.setVisibility(View.VISIBLE);
                    pgbs4_3.setVisibility(View.VISIBLE);
                    pgbs3_3_1.setVisibility(View.VISIBLE);
                    pgbs4_3_2.setVisibility(View.VISIBLE);

                    pgbs3_4.setVisibility(View.VISIBLE);
                    pgbs4_4.setVisibility(View.VISIBLE);
                    pgbs3_4_1.setVisibility(View.VISIBLE);
                    pgbs4_4_2.setVisibility(View.VISIBLE);
                }
            }
        });


        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validar()){
                    String folio = General.Foliocuestion;
                    General.fechaenc = textFecha.getText().toString();
                    String nom = pgbt2.getText().toString();
                    String apa = pgbt3.getText().toString();
                    String ama = pgbt4.getText().toString();
                    String curp = pgbt5.getText().toString();
                    String calle = pgbt6.getText().toString();
                    String ext = pgbt7.getText().toString();
                    String inte = pgbt8.getText().toString();
                    String col = pgbt9.getText().toString();
                    String cp = pgbt10.getText().toString();
                    String claveEdo = cveedo;
                    String nomEdo = nomedo;
                    String claveMun = cvemun;
                    String nomMun = nommun;
                    String col2 = pgbt16.getText().toString();
                    String cp2 = pgbt17.getText().toString();
                    String claveEdo2 = cveedo2;
                    String nomEdo2 = nomedo2;
                    String claveMun2 = cvemun2;
                    String nomMun2 = nommun2;

                    String nomEdo3 = nomedo3;
                    String nomMun3 = nommun3;
                    String nomEdo4 = nomedo4;
                    String nomMun4 = nommun4;
                    String nomEdo5 = nomedo5;
                    String nomMun5 = nommun5;
                    String nomEdo6 = nomedo6;
                    String nomMun6 = nommun6;

                    if(parrad11.isChecked()==true){
                        nomEdo3 = "";
                        nomMun3 = "";
                        nomEdo4 = "";
                        nomMun4 = "";
                        nomEdo5 = "";
                        nomMun5 = "";
                        nomEdo6 = "";
                        nomMun6 = "";
                    }
                    else if(parrad22.isChecked()==true){
                        nomEdo4 = "";
                        nomMun4 = "";
                        nomEdo5 = "";
                        nomMun5 = "";
                        nomEdo6 = "";
                        nomMun6 = "";
                    }
                    else if(parrad33.isChecked()==true){
                        nomEdo5 = "";
                        nomMun5 = "";
                        nomEdo6 = "";
                        nomMun6 = "";
                    }
                    else if(parrad44.isChecked()==true){
                        nomEdo6 = "";
                        nomMun6 = "";
                    }
                    else if(parrad55.isChecked()==true){
                        nomEdo3 = nomedo3;
                        nomMun3 = nommun3;
                        nomEdo4 = nomedo4;
                        nomMun4 = nommun4;
                        nomEdo5 = nomedo5;
                        nomMun5 = nommun5;
                        nomEdo6 = nomedo6;
                        nomMun6 = nommun6;
                    }

                    String sexo = obtenerResultado(pgbr1,pgbr2);
                    String edad = pgbt20.getText().toString();
                    String leer = obtenerResultado(pgbr3,pgbr4);
                    String ult1 = obtenerResultado12(pgbr5,pgbr6,pgbr7,pgbr8,pgbr9,pgbr10,pgbr11,pgbr12,pgbr13,pgbr14,pgbr15,pgbr16);
                    String ultotro = (pgbr16.isChecked())? pgbt21.getText().toString() : "";
                    String prod = obtenerResultado3(pgbr18, pgbr19, pgbr19_1);
                    String peso = pgbt22.getText().toString();
                    String inf1 = (pgbc1.isChecked())? "X" : "";
                    String inf2 = (pgbc2.isChecked())? "X" : "";
                    String inf3 = (pgbc3.isChecked())? "X" : "";
                    String inf4 = (pgbc4.isChecked())? "X" : "";
                    String inf5 = (pgbc5.isChecked())? "X" : "";
                    String inf6 = (pgbc6.isChecked())? "X" : "";
                    String inf8 = (pgbc8.isChecked())? "X" : "";
                    String inf9 = (pgbc10.isChecked())? "X" : "";
                    String docine = obtenerResultado(pgbr21,pgbr22);
                    String doccurp = obtenerResultado(pgbr23,pgbr24);
                    String docclabe = obtenerResultado(pgbr25,pgbr26);
                    String docfol = obtenerResultado(pgbr27,pgbr28);
                    String docren = obtenerResultado(pgbr29,pgbr30);
                    String seis_1 = obtenerResultado(pgbr31,pgbr32);
                    String seis_2 = obtenerResultado(pgbr33,pgbr34);
                    String seis_3 = obtenerResultado(pgbr35,pgbr36);
                    String seis_4 = obtenerResultado(pgbr37,pgbr38);
                    String seis_5 = obtenerResultado(pgbr39,pgbr40);
                    String seis_6 = obtenerResultado(pgbr41,pgbr42);
                    String seis_7 = obtenerResultado(pgbr43,pgbr44);
                    String seis_8 = obtenerResultado(pgbr45,pgbr46);

                    String seis_9 = obtenerResultado(pgbr45_1,pgbr46_1);

                    String siete_1 = obtenerResultado(pgbr51,pgbr52);
                    String siete_2 = obtenerResultado(pgbr51_1,pgbr52_1);
                    String siete_3 = obtenerResultado(pgbr51_2,pgbr52_2);
                    String siete_4 = obtenerResultado(pgbr51_3,pgbr52_3);
                    String siete_5 = obtenerResultado(pgbr51_4,pgbr52_4);
                    String ocho_1 = obtenerResultado3(pgbr68,pgbr69,pgbr70);
                    String ocho_2 = obtenerResultado3(pgbr71,pgbr72,pgbr73);
                    String ocho_3 = obtenerResultado3(pgbr74,pgbr75,pgbr76);
                    String ocho_4 = obtenerResultado3(pgbr77,pgbr78,pgbr79);
                    String ocho_5 = obtenerResultado3(pgbr80,pgbr81,pgbr82);
                    String ocho_6 = obtenerResultado3(pgbr83,pgbr84,pgbr85);
                    String ocho_7 = obtenerResultado3(pgbr86,pgbr87,pgbr88);
                    String nueve1 = (pgbc11.isChecked())? "X" : "";
                    String nueve2 = (pgbc12.isChecked())? "X" : "";
                    String nueve3 = (pgbc13.isChecked())? "X" : "";
                    String nueve4 = (pgbc14.isChecked())? "X" : "";
                    String nueve5 = (pgbc15.isChecked())? "X" : "";
                    String nueve6 = (pgbc16.isChecked())? "X" : "";
                    String nueve7 = (pgbc17.isChecked())? "X" : "";
                    String nueve8 = (pgbc18.isChecked())? "X" : "";
                    String nueve10 = (pgbc20.isChecked())? "X" : "";
                    String nueve9 = (pgbc19.isChecked())? "X" : "";
                    String nueveotro =  (pgbc19.isChecked())? pgbt25.getText().toString() : "";
                    String diez = pgbt26.getText().toString();
                    String once = pgbt27.getText().toString();
                    String doce = pgbt28.getText().toString();
                    String trece = pgbt29.getText().toString();
                    String f1 = General.Foto1;
                    String f2 = General.Foto2;

                    model = new PGBeneficiariosGranosIncentivos_Model(folio, General.fechaenc,nom,apa,ama,curp,calle,ext,inte,col,cp,claveEdo,nomEdo,claveMun,nomMun,col2,cp2,claveEdo2,nomEdo2,claveMun2,nomMun2,nomEdo3,nomMun3,nomEdo4,nomMun4,nomEdo5,nomMun5,nomEdo6,nomMun6,sexo,edad,leer,ult1,ultotro,prod,peso,inf1,inf2,inf3,inf4,inf5,inf6,inf8,inf9,docine,doccurp
                            ,docclabe,docfol,docren,seis_1,seis_2,seis_3,seis_4,seis_5,seis_6,seis_7,seis_8,seis_9,siete_1,siete_2,siete_3,siete_4,siete_5,ocho_1,ocho_2,ocho_3,ocho_4,ocho_5,ocho_6,ocho_7,nueve1,nueve2,nueve3,nueve4,nueve5,nueve6,nueve7,nueve8,nueve10,nueve9,nueveotro
                            ,diez,once,doce,trece, f1, f2, "", "");

                    Intent in = new Intent(PGBeneficiariosGranosIncentivos.this, GeoreferenciaActivity.class);
                    in.putExtra("model", model);
                    startActivity(in);

                }
                else{
                    Toast.makeText(getApplicationContext(), "Faltan respuestas",Toast.LENGTH_SHORT).show();
                }
            }
        });

        
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

        if(pgbt2.getText().toString().isEmpty()){
            pgbt2.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgbt3.getText().toString().isEmpty()){
            pgbt3.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgbt4.getText().toString().isEmpty()){
            pgbt4.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgbt5.getText().toString().isEmpty()){
            pgbt5.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!validarCURP(pgbt5.getText().toString())){
            pgbt5.setError("CURP invalido");
            retorno=false;
        }
        else if(pgbt6.getText().toString().isEmpty()){
            pgbt6.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgbt9.getText().toString().isEmpty()){
            pgbt9.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgbt10.getText().toString().isEmpty()){
            pgbt10.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgbt16.getText().toString().isEmpty()){
            pgbt16.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgbt17.getText().toString().isEmpty()){
            pgbt17.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!pgbr1.isChecked() && !pgbr2.isChecked()){
            pgbr1.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(pgbt20.getText().toString().isEmpty()){
            pgbt20.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!pgbr3.isChecked() && !pgbr4.isChecked()){
            pgbr3.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr5.isChecked() && !pgbr6.isChecked()&& !pgbr7.isChecked()&& !pgbr8.isChecked()&& !pgbr9.isChecked()&& !pgbr10.isChecked()&& !pgbr11.isChecked()&& !pgbr12.isChecked()&& !pgbr13.isChecked()&& !pgbr14.isChecked()&& !pgbr15.isChecked()&& !pgbr16.isChecked()){
            pgbr5.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(pgbr16.isChecked() && pgbt21.getText().toString().isEmpty()){
            pgbt21.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!pgbr18.isChecked() && !pgbr19.isChecked() && !pgbr19_1.isChecked()){
            pgbr18.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(pgbt22.getText().toString().isEmpty()){
            pgbt22.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!pgbc1.isChecked() && !pgbc2.isChecked() && !pgbc3.isChecked() && !pgbc4.isChecked() && !pgbc5.isChecked() && !pgbc6.isChecked() && !pgbc8.isChecked() && !pgbc10.isChecked()){
            pgbc1.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr21.isChecked() && !pgbr22.isChecked()){
            pgbr21.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr23.isChecked() && !pgbr24.isChecked()){
            pgbr23.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr25.isChecked() && !pgbr26.isChecked()){
            pgbr25.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr27.isChecked() && !pgbr28.isChecked()){
            pgbr27.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr29.isChecked() && !pgbr30.isChecked()){
            pgbr29.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr31.isChecked() && !pgbr32.isChecked()){
            pgbr31.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr33.isChecked() && !pgbr34.isChecked()){
            pgbr33.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr35.isChecked() && !pgbr36.isChecked()){
            pgbr35.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr37.isChecked() && !pgbr38.isChecked()){
            pgbr37.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr39.isChecked() && !pgbr40.isChecked()){
            pgbr39.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr41.isChecked() && !pgbr42.isChecked()){
            pgbr41.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr43.isChecked() && !pgbr44.isChecked()){
            pgbr43.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr45.isChecked() && !pgbr46.isChecked()){
            pgbr45.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr45_1.isChecked() && !pgbr46_1.isChecked()){
            pgbr45_1.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr51.isChecked() && !pgbr52.isChecked()){
            pgbr51.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr51_1.isChecked() && !pgbr52_1.isChecked()){
            pgbr51_1.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr51_2.isChecked() && !pgbr52_2.isChecked()){
            pgbr51_2.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr51_3.isChecked() && !pgbr52_3.isChecked()){
            pgbr51_3.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr51_4.isChecked() && !pgbr52_4.isChecked()){
            pgbr51_4.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr68.isChecked() && !pgbr69.isChecked() && !pgbr70.isChecked()){
            pgbr68.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr71.isChecked() && !pgbr72.isChecked() && !pgbr73.isChecked()){
            pgbr71.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr74.isChecked() && !pgbr75.isChecked() && !pgbr76.isChecked()){
            pgbr74.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr77.isChecked() && !pgbr78.isChecked() && !pgbr79.isChecked()){
            pgbr77.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr80.isChecked() && !pgbr81.isChecked() && !pgbr82.isChecked()){
            pgbr80.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr83.isChecked() && !pgbr84.isChecked() && !pgbr85.isChecked()){
            pgbr83.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbr86.isChecked() && !pgbr87.isChecked() && !pgbr88.isChecked()){
            pgbr86.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!pgbc11.isChecked() && !pgbc12.isChecked() && !pgbc13.isChecked() && !pgbc14.isChecked() && !pgbc15.isChecked() && !pgbc16.isChecked() && !pgbc17.isChecked() && !pgbc18.isChecked() && !pgbc19.isChecked() && !pgbc20.isChecked()){
            pgbc11.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(pgbc19.isChecked() && pgbt25.getText().toString().isEmpty()){
            pgbt25.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgbt26.getText().toString().isEmpty()){
            pgbt26.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgbt27.getText().toString().isEmpty()){
            pgbt27.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgbt28.getText().toString().isEmpty()){
            pgbt28.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(pgbt29.getText().toString().isEmpty()){
            pgbt29.setError("No puede quedar vacio");
            retorno=false;
        }


        return retorno;
    }

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

    @Override
    public void onBackPressed() {

    }

}