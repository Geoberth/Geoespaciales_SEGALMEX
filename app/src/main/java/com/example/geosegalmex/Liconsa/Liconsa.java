package com.example.geosegalmex.Liconsa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Georeferencia.GeoreferenciaActivity;
import com.example.geosegalmex.PARBeneficiario.PARBeneficiario;
import com.example.geosegalmex.PARBeneficiario.PARBeneficiario_Model;
import com.example.geosegalmex.PGBeneficiarioLeche.PGBeneficiarioLeche;
import com.example.geosegalmex.PGBeneficiarioLeche.PGBeneficiarioLeche_Model;
import com.example.geosegalmex.PGBeneficiariosGranosIncentivos.PGBeneficiariosGranosIncentivos;
import com.example.geosegalmex.R;

import java.util.Calendar;
import java.util.regex.Pattern;

public class Liconsa extends AppCompatActivity {
    EditText especifique, ernplpt1, ernplpt2, ernplpt3, ernplpt4, ernplpt5, ernplpt6, ernplpt7, ernplpt9, ernplpt10, ernplpt11, ernplpt12, ernplpt13, ernplpt14, ernplpt15, ernplpt16, ernplpt17, ernplpt18, ernplpt19, ernplpt20, ernplpt21, ernplpt22, ernplpt23, ernplpt24, ernplpt25, ernplpt26, ernplpt27, ernplpt28, ernplpt29, ernplpt30, ernplpt31, ernplpt32, ernplpt33, ernplpt34, ernplpt35, ernplpt36, ernplpt37, ernplpt38, ernplpt39, ernplpt40, ernplpt41, ernplpt42, ernplpt43, ernplpt44, ernplpt45, ernplpt46, ernplpt47, ernplpt48, ernplpt49, ernplpt50, ernplpt51, ernplpt52, ernplpt53, ernplpt54;
    RadioButton ernplpr1, ernplpr2, ernplpr3, ernplpr4, type1, type2, type3, ernplpr8, ernplpr9, ernplpr10, ernplpr11, ernplpr12, ernplpr13, ernplpr14, ernplpr15, ernplpr16, ernplpr17, ernplpr18, ernplpr19, ernplpr20, ernplpr21, ernplpr22, ernplpr23, ernplpr24, ernplpr25, ernplpr26, ernplpr27, ernplpr28, ernplpr29, ernplpr30, ernplpr31, ernplpr32, ernplpr33, ernplpr34, ernplpr35, ernplpr36, ernplpr37, ernplpr38, ernplpr39, ernplpr40, ernplpr41, ernplpr42, ernplpr43, ernplpr44, ernplpr45, ernplpr46, ernplpr47, ernplpr48, ernplpr49, ernplpr50, ernplpr51, ernplpr52, ernplpr53, ernplpr54, ernplpr55, ernplpr56, ernplpr57, ernplpr58, ernplpr59, ernplpr60, ernplpr61, ernplpr62, ernplpr63, ernplpr64, ernplpr65, ernplpr66, ernplpr67, ernplpr68, ernplpr69, ernplpr70, ernplpr71, ernplpr72;
    Spinner ernplps1, ernplps2, spn, ernplpt8, spmes, spdia, spaño, spmes2, spdia2, spaño2,ernplps4, ernplps3;
    CheckBox ernplpc1, ernplpc2, ernplpc3;
    Button btnSiguiente;
    LinearLayout ll1, ll2;
    TextView tv1, tv2;
    EditText rnplup1,rnplup2,rnplup3,rnplup4,rnplup5,rnplup6,rnplup7;

    Calendar c, c2;
    DatePickerDialog dpd, dpd2;
    Liconsa_Model model;

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
        setContentView(R.layout.activity_liconsa);

        Declaracion();
        Eventos();
        ernplpt40.setVisibility(View.GONE);
        ernplpt26.setVisibility(View.GONE);
        ernplpt25.setVisibility(View.GONE);
        ernplpt24.setVisibility(View.GONE);
        ll1.setVisibility(View.GONE);
        ll2.setVisibility(View.GONE);
        ernplpt51.setVisibility(View.GONE);
        ernplpt52.setVisibility(View.GONE);
        ernplpt53.setVisibility(View.GONE);


        ernplps1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String[] estados = getResources().getStringArray(R.array.Estados2021);
                String[] cveestados = getResources().getStringArray(R.array.cveEstados2021);

                cveedo = cveestados[position];
                nomedo = estados[position];

                municipios = getResources().getStringArray(idmunicipios[position]);
                cvemunicipios = getResources().getStringArray(idcvemunicipios[position]);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Liconsa.this, android.R.layout.simple_spinner_item, municipios);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                ernplps2.setAdapter(adapter);
                ernplps2.setEnabled(true);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        ernplps2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                nommun = municipios[position];
                cvemun = cvemunicipios[position];
                //Toast.makeText(getApplicationContext(), "cveEdo: " + cveedo + "\n Edo: " + nomedo + "\n cveMun: " + nommun + "\n Mun: " + cvemun,Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        ernplps3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String[] estados2 = getResources().getStringArray(R.array.Estados2021);
                String[] cveestados2 = getResources().getStringArray(R.array.cveEstados2021);

                cveedo2 = cveestados2[position];
                nomedo2 = estados2[position];

                municipios2 = getResources().getStringArray(idmunicipios2[position]);
                cvemunicipios2 = getResources().getStringArray(idcvemunicipios2[position]);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Liconsa.this, android.R.layout.simple_spinner_item, municipios2);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                ernplps4.setAdapter(adapter);
                ernplps4.setEnabled(true);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        ernplps4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                nommun2 = municipios2[position];
                cvemun2 = cvemunicipios2[position];
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
                    String nom = ernplpt1.getText().toString();
                    String app= ernplpt2.getText().toString();
                    String apm = ernplpt3.getText().toString();
                    String nac = ernplpt4.getText().toString();
                    String sexo = obtenerResultado(ernplpr1, ernplpr2);
                    String nacion = ernplpt5.getText().toString();
                    String curp = ernplpt6.getText().toString();
                    String rfc = ernplpt7.getText().toString();
                    String tipoide = (ernplpt8.getSelectedItem().toString().equals("Otro"))? "Otro: " + especifique.getText().toString() : ernplpt8.getSelectedItem().toString() ;
                    String numide = ernplpt9.getText().toString();
                    String email = ernplpt10.getText().toString();
                    String tel = ernplpt11.getText().toString();
                    String tipotel = obtenerResultado3(type1, type2, type3);
                    String calle = ernplpt12.getText().toString();
                    String ext = ernplpt13.getText().toString();
                    String inte = ernplpt14.getText().toString();
                    String cp = ernplpt16.getText().toString();
                    String cveEdo = cveedo;
                    String Edo = nomedo;
                    String cveMun = cvemun;
                    String Mun = nommun;
                    String cveLoc = "";
                    String localidad = ernplpt15.getText().toString();
                    String colonia = rnplup7.getText().toString();
                    String tipoasen = (ernplpr3.isChecked()==true || ernplpr4.isChecked()==true)? obtenerResultado(ernplpr3, ernplpr4) : "" ;
                    String nomasen = ernplpt19.getText().toString();
                    String cveasen = ernplpt20.getText().toString();
                    String vialidad = ernplpt21.getText().toString();
                    String tipovialidad = spn.getSelectedItem().toString();

                    String calleup = rnplup1.getText().toString();
                    String extup = rnplup3.getText().toString();
                    String intup = rnplup2.getText().toString();
                    String cveLocup = "";
                    String desclocup = rnplup4.getText().toString();
                    String colup = rnplup5.getText().toString();
                    String cpup = rnplup6.getText().toString();
                    String cveEdoup = cveedo2;
                    String Edoup = nomedo2;
                    String cveMunup = cvemun2;
                    String Munup = nommun2;

                    String asociacion = obtenerResultado(ernplpr25, ernplpr26);
                    String nomaso = (ernplpr25.isChecked()==true)? ernplpt24.getText().toString() : "" ;
                    String regimen = obtenerResultado3(ernplpr27, ernplpr28, ernplpr29);
                    String discapacidad = obtenerResultado(ernplpr30, ernplpr31);
                    String nomdiscapacidad = (ernplpr30.isChecked()==true)? ernplpt25.getText().toString() : "" ;
                    String indigena = obtenerResultado(ernplpr32, ernplpr33);
                    String declaindigena = (ernplpr32.isChecked()==true)? ernplpt26.getText().toString() : "" ;
                    String estatus = obtenerResultado(ernplpr34, ernplpr35);
                    String upp = ernplpt27.getText().toString();
                    String p1 = ernplpt28.getText().toString();
                    String p2 = ernplpt29.getText().toString();
                    String p3 = ernplpt30.getText().toString();
                    String p4 = ernplpt31.getText().toString();
                    String p5 = ernplpt32.getText().toString();
                    String p6 = ernplpt33.getText().toString();
                    String p7 = ernplpt34.getText().toString();
                    String p8 = ernplpt35.getText().toString();
                    String p9 = ernplpt36.getText().toString();
                    String p9_1 = obtenerResultado(ernplpr36, ernplpr37);
                    String p9_2 = ernplpt37.getText().toString();
                    String p10 = ernplpt38.getText().toString();
                    String p10_1 = ernplpt39.getText().toString();
                    String p11 = obtenerResultado(ernplpr38, ernplpr39);
                    String p12_1 = obtenerResultado(ernplpr40, ernplpr41);
                    String p12_2 = obtenerResultado(ernplpr42, ernplpr43);
                    String p12_3 = obtenerResultado(ernplpr44, ernplpr45);
                    String p12_4 = obtenerResultado(ernplpr46, ernplpr47);
                    String p12_4otros = (ernplpr46.isChecked()==true)? ernplpt40.getText().toString() : "" ;
                    String p13 = obtenerResultado(ernplpr48, ernplpr49);
                    String p13_1 = (ernplpr48.isChecked()==true)? ernplpt41.getText().toString() : "" ;
                    String p13_2 = (ernplpr48.isChecked()==true)? ernplpt42.getText().toString() : "" ;
                    String p13_3 = (ernplpr48.isChecked()==true)? ernplpt43.getText().toString() : "" ;
                    String p13_4 = (ernplpr48.isChecked()==true)? ernplpt44.getText().toString() : "" ;
                    String p13_5 = (ernplpr48.isChecked()==true)? ernplpt45.getText().toString() : "" ;
                    String p14 = obtenerResultado(ernplpr50, ernplpr51);
                    String p14_1 = (ernplpr50.isChecked()==true)? ernplpt46.getText().toString() : "" ;
                    String p14_2 = (ernplpr50.isChecked()==true)? ernplpt47.getText().toString() : "" ;
                    String p14_3 = (ernplpr50.isChecked()==true)? ernplpt48.getText().toString() : "" ;
                    String p14_4 = (ernplpr50.isChecked()==true)? ernplpt49.getText().toString() : "" ;
                    String p14_5 = (ernplpr50.isChecked()==true)? ernplpt50.getText().toString() : "" ;
                    String p15_1 = obtenerResultado(ernplpr52, ernplpr53);
                    String p15_2 = obtenerResultado(ernplpr54, ernplpr55);
                    String p15_3 = obtenerResultado(ernplpr56, ernplpr57);
                    String p15_4 = obtenerResultado(ernplpr58, ernplpr59);
                    String p15_4otros = (ernplpr58.isChecked()==true)? ernplpt51.getText().toString() : "" ;
                    String p16 = obtenerResultado(ernplpr60, ernplpr61);
                    String p16_registro = (ernplpr60.isChecked()==true)? ernplpt52.getText().toString() : "" ;
                    String p17 = obtenerResultado(ernplpr62, ernplpr63);
                    String p17_registro = (ernplpr62.isChecked()==true)? ernplpt53.getText().toString() : "" ;
                    String p18 = obtenerResultado(ernplpr64, ernplpr65);
                    String p19 = obtenerResultado(ernplpr66, ernplpr67);
                    String p20 = obtenerResultado3(ernplpr68, ernplpr69, ernplpr70);
                    String observaciones = ernplpt54.getText().toString();

                    String f1 = General.Foto1;
                    String f2 = General.Foto2;
                    String f3 = General.Foto3;

                    model = new Liconsa_Model(fol, nom,app,apm,nac,sexo,nacion,curp,rfc,tipoide,numide,email,tel,tipotel,calle,ext,inte,cp,cveEdo,Edo,cveMun,Mun,cveLoc,localidad,colonia,tipoasen,nomasen,cveasen,vialidad,tipovialidad,
                            calleup,extup,intup,cveLocup,desclocup,colup,cpup,cveEdoup,Edoup,cveMunup,Munup,asociacion,nomaso,regimen,
                            discapacidad,nomdiscapacidad,indigena,declaindigena,estatus,upp,p1,p2,p3,p4,p5,p6,p7,p8,p9,p9_1,p9_2,p10,p10_1,p11,p12_1,p12_2,p12_3,p12_4,p12_4otros,p13,p13_1,p13_2,p13_3,p13_4,p13_5,p14,p14_1,p14_2,
                            p14_3,p14_4,p14_5,p15_1,p15_2,p15_3,p15_4,p15_4otros,p16,p16_registro,p17,p17_registro,p18,p19,p20,observaciones, f1, f2, f3, "", "");

                    Intent in = new Intent(Liconsa.this, GeoreferenciaActivity.class);
                    in.putExtra("model", model);
                    startActivity(in);

                }
                else{
                    Toast.makeText(getApplicationContext(), "Faltan respuestas",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    public void Declaracion(){
        ll1 = (LinearLayout) findViewById(R.id.ll1);
        ll2 = (LinearLayout) findViewById(R.id.ll2);

        tv1 = (TextView) findViewById(R.id.TV1);
        tv2 = (TextView) findViewById(R.id.TV2);

        especifique = (EditText)findViewById(R.id.docespecifique);
        spdia = (Spinner) findViewById(R.id.spdia);
        spmes = (Spinner) findViewById(R.id.spmes);
        spaño = (Spinner) findViewById(R.id.spaño);

        spdia2 = (Spinner) findViewById(R.id.spdia2);
        spmes2 = (Spinner) findViewById(R.id.spmes2);
        spaño2 = (Spinner) findViewById(R.id.spaño2);

        //INFORMACION PERSONAL

        ernplpt1 = (EditText)findViewById(R.id.ernpl_prod_txt1);
        ernplpt2 = (EditText)findViewById(R.id.ernpl_prod_txt2);
        ernplpt3 = (EditText)findViewById(R.id.ernpl_prod_txt3);
        ernplpt4 = (EditText)findViewById(R.id.ernpl_prod_txt4);

        //Sexo
        ernplpr1 = (RadioButton)findViewById(R.id.ernpl_prod_ra1);
        ernplpr2 = (RadioButton)findViewById(R.id.ernpl_prod_ra2);

        ernplpt5 = (EditText)findViewById(R.id.ernpl_prod_txt5);
        ernplpt6 = (EditText)findViewById(R.id.ernpl_prod_txt6);
        ernplpt7 = (EditText)findViewById(R.id.ernpl_prod_txt7);
        ernplpt8 = (Spinner)findViewById(R.id.ernpl_prod_txt8);
        ernplpt9 = (EditText)findViewById(R.id.ernpl_prod_txt9);
        ernplpt10 = (EditText)findViewById(R.id.ernpl_prod_txt10);
        ernplpt11 = (EditText)findViewById(R.id.ernpl_prod_txt11);

        type1 = (RadioButton)findViewById(R.id.par_ben_ra1);
        type2 = (RadioButton)findViewById(R.id.par_ben_ra2);
        type3 = (RadioButton)findViewById(R.id.par_ben_ra3);


        //DATOS DE DOMICILIO

        ernplpt12 = (EditText)findViewById(R.id.ernpl_prod_txt12);
        ernplpt13 = (EditText)findViewById(R.id.ernpl_prod_txt13);
        ernplpt14 = (EditText)findViewById(R.id.ernpl_prod_txt14);
        ernplpt15 = (EditText)findViewById(R.id.ernpl_prod_txt15);
        ernplpt16 = (EditText)findViewById(R.id.ernpl_prod_txt16);

        ernplps1 = (Spinner) findViewById(R.id.ernpl_prod_spin1); //ENTIDAD FEDERATIVA

        ernplps2 = (Spinner) findViewById(R.id.ernpl_prod_spin2); //MUNICIPIO

        ernplpr3 = (RadioButton)findViewById(R.id.ernpl_prod_ra3);
        ernplpr4 = (RadioButton)findViewById(R.id.ernpl_prod_ra4);

        ernplpt19 = (EditText)findViewById(R.id.ernpl_prod_txt19);
        ernplpt20 = (EditText)findViewById(R.id.ernpl_prod_txt20);
        ernplpt21 = (EditText)findViewById(R.id.ernpl_prod_txt21);

        spn = (Spinner) findViewById(R.id.par_ben_spin2);


        //DATOS DE CARACTERIZACION

        ernplpr25 = (RadioButton)findViewById(R.id.ernpl_prod_ra25);
        ernplpr26 = (RadioButton)findViewById(R.id.ernpl_prod_ra26);
        ernplpt24 = (EditText)findViewById(R.id.ernpl_prod_txt24);

        ernplpr27 = (RadioButton)findViewById(R.id.ernpl_prod_ra27);
        ernplpr28 = (RadioButton)findViewById(R.id.ernpl_prod_ra28);
        ernplpr29 = (RadioButton)findViewById(R.id.ernpl_prod_ra29);

        ernplpr30 = (RadioButton)findViewById(R.id.ernpl_prod_ra30);
        ernplpr31 = (RadioButton)findViewById(R.id.ernpl_prod_ra31);
        ernplpt25 = (EditText)findViewById(R.id.ernpl_prod_txt25);

        ernplpr32 = (RadioButton)findViewById(R.id.ernpl_prod_ra32);
        ernplpr33 = (RadioButton)findViewById(R.id.ernpl_prod_ra33);
        ernplpt26 = (EditText)findViewById(R.id.ernpl_prod_txt26);

        //DATOS DE PRODUCCIÓN (EXISTENCIAS, PRODUCCIÓN EQUIPO E INSTALACIONES)

        ernplpr34 = (RadioButton)findViewById(R.id.ernpl_prod_ra34);
        ernplpr35 = (RadioButton)findViewById(R.id.ernpl_prod_ra35);
        ernplpt27 = (EditText)findViewById(R.id.ernpl_prod_txt27);

        //EXISTENCIAS
        ernplpt28 = (EditText)findViewById(R.id.ernpl_prod_txt28);
        ernplpt29 = (EditText)findViewById(R.id.ernpl_prod_txt29);
        ernplpt30 = (EditText)findViewById(R.id.ernpl_prod_txt30);
        ernplpt31 = (EditText)findViewById(R.id.ernpl_prod_txt31);

        //PRODUCCION
        ernplpt32 = (EditText)findViewById(R.id.ernpl_prod_txt32);
        ernplpt33 = (EditText)findViewById(R.id.ernpl_prod_txt33);
        ernplpt34 = (EditText)findViewById(R.id.ernpl_prod_txt34);
        ernplpt35 = (EditText)findViewById(R.id.ernpl_prod_txt35);
        ernplpt36 = (EditText)findViewById(R.id.ernpl_prod_txt36);

        ernplpr36 = (RadioButton)findViewById(R.id.ernpl_prod_ra36);
        ernplpr37 = (RadioButton)findViewById(R.id.ernpl_prod_ra37);

        ernplpt37 = (EditText)findViewById(R.id.ernpl_prod_txt37);
        ernplpt38 = (EditText)findViewById(R.id.ernpl_prod_txt38);
        ernplpt39 = (EditText)findViewById(R.id.ernpl_prod_txt39);

        ernplpr38 = (RadioButton)findViewById(R.id.ernpl_prod_ra38);
        ernplpr39 = (RadioButton)findViewById(R.id.ernpl_prod_ra39);

        ernplpr40 = (RadioButton)findViewById(R.id.ernpl_prod_ra40);
        ernplpr41 = (RadioButton)findViewById(R.id.ernpl_prod_ra41);
        ernplpr42 = (RadioButton)findViewById(R.id.ernpl_prod_ra42);
        ernplpr43 = (RadioButton)findViewById(R.id.ernpl_prod_ra43);
        ernplpr44 = (RadioButton)findViewById(R.id.ernpl_prod_ra44);
        ernplpr45 = (RadioButton)findViewById(R.id.ernpl_prod_ra45);
        ernplpr46 = (RadioButton)findViewById(R.id.ernpl_prod_ra46);
        ernplpr47 = (RadioButton)findViewById(R.id.ernpl_prod_ra47);
        ernplpt40 = (EditText)findViewById(R.id.ernpl_prod_txt40);

        ernplpr48 = (RadioButton)findViewById(R.id.ernpl_prod_ra48);
        ernplpr49 = (RadioButton)findViewById(R.id.ernpl_prod_ra49);

        //SALAS
        ernplpt41 = (EditText)findViewById(R.id.ernpl_prod_txt41);
        ernplpt42 = (EditText)findViewById(R.id.ernpl_prod_txt42);
        ernplpt43 = (EditText)findViewById(R.id.ernpl_prod_txt43);
        ernplpt44 = (EditText)findViewById(R.id.ernpl_prod_txt44);
        ernplpt45 = (EditText)findViewById(R.id.ernpl_prod_txt45);

        ernplpr50 = (RadioButton)findViewById(R.id.ernpl_prod_ra50);
        ernplpr51 = (RadioButton)findViewById(R.id.ernpl_prod_ra51);

        //TANQUES
        ernplpt46 = (EditText)findViewById(R.id.ernpl_prod_txt46);
        ernplpt47 = (EditText)findViewById(R.id.ernpl_prod_txt47);
        ernplpt48 = (EditText)findViewById(R.id.ernpl_prod_txt48);
        ernplpt49 = (EditText)findViewById(R.id.ernpl_prod_txt49);
        ernplpt50 = (EditText)findViewById(R.id.ernpl_prod_txt50);

        ernplpr52 = (RadioButton)findViewById(R.id.ernpl_prod_ra52);
        ernplpr53 = (RadioButton)findViewById(R.id.ernpl_prod_ra53);
        ernplpr54 = (RadioButton)findViewById(R.id.ernpl_prod_ra54);
        ernplpr55 = (RadioButton)findViewById(R.id.ernpl_prod_ra55);
        ernplpr56 = (RadioButton)findViewById(R.id.ernpl_prod_ra56);
        ernplpr57 = (RadioButton)findViewById(R.id.ernpl_prod_ra57);
        ernplpr58 = (RadioButton)findViewById(R.id.ernpl_prod_ra58);
        ernplpr59 = (RadioButton)findViewById(R.id.ernpl_prod_ra59);
        ernplpt51 = (EditText)findViewById(R.id.ernpl_prod_txt51);

        //REGISTROS Y CERTIFICACIONES DEL PRODUCTOR

        ernplpr60 = (RadioButton)findViewById(R.id.ernpl_prod_ra60);
        ernplpr61 = (RadioButton)findViewById(R.id.ernpl_prod_ra61);
        ernplpt52 = (EditText)findViewById(R.id.ernpl_prod_txt52);

        ernplpr62 = (RadioButton)findViewById(R.id.ernpl_prod_ra62);
        ernplpr63 = (RadioButton)findViewById(R.id.ernpl_prod_ra63);
        ernplpt53 = (EditText)findViewById(R.id.ernpl_prod_txt53);

        ernplpr64 = (RadioButton)findViewById(R.id.ernpl_prod_ra64);
        ernplpr65 = (RadioButton)findViewById(R.id.ernpl_prod_ra65);

        ernplpr66 = (RadioButton)findViewById(R.id.ernpl_prod_ra66);
        ernplpr67 = (RadioButton)findViewById(R.id.ernpl_prod_ra67);

        ernplpr68 = (RadioButton)findViewById(R.id.ernpl_prod_ra68);
        ernplpr69 = (RadioButton)findViewById(R.id.ernpl_prod_ra69);
        ernplpr70 = (RadioButton)findViewById(R.id.ernpl_prod_ra70);
        ernplpt54 = (EditText)findViewById(R.id.ernpl_prod_txt54);
        btnSiguiente = (Button)findViewById(R.id.ernpl_prod_sig);


        rnplup1 = (EditText)findViewById(R.id.ernpl_1001);
        rnplup2 = (EditText)findViewById(R.id.ernpl_1002);
        rnplup3 = (EditText)findViewById(R.id.ernpl_1003);
        rnplup4 = (EditText)findViewById(R.id.ernpl_1004);
        rnplup5 = (EditText)findViewById(R.id.ernpl_1005);
        rnplup7 = (EditText)findViewById(R.id.ernpl_1005_1);
        rnplup6 = (EditText)findViewById(R.id.ernpl_1006);
        ernplps3 = (Spinner) findViewById(R.id.ernpl_prod_spin3); //ENTIDAD FEDERATIVA
        ernplps4 = (Spinner) findViewById(R.id.ernpl_prod_spin4); //MUNICIPIO

    }

    public void Eventos(){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.ernpl_prod_ra21);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(ernplpr25.isChecked()==true){
                    ernplpt24.setVisibility(View.VISIBLE);
                }else{
                    ernplpt24.setVisibility(View.GONE);
                    ernplpt24.setText("");
                }
            }
        });

        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.ernpl_prod_rg);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(ernplpr30.isChecked()==true){
                    ernplpt25.setVisibility(View.VISIBLE);
                }else{
                    ernplpt25.setVisibility(View.GONE);
                    ernplpt25.setText("");
                }
            }
        });

        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.rglengua);
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(ernplpr32.isChecked()==true){
                    ernplpt26.setVisibility(View.VISIBLE);
                }else{
                    ernplpt26.setVisibility(View.GONE);
                    ernplpt26.setText("");
                }
            }
        });

        RadioGroup radioGroup4 = (RadioGroup) findViewById(R.id.rg3);
        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(ernplpr46.isChecked()==true){
                    ernplpt40.setVisibility(View.VISIBLE);
                }else{
                    ernplpt40.setVisibility(View.GONE);
                    ernplpt40.setText("");
                }
            }
        });

        RadioGroup radioGroup5 = (RadioGroup) findViewById(R.id.rg13);
        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(ernplpr48.isChecked()==true){
                    ll1.setVisibility(View.VISIBLE);
                }else{
                    ll1.setVisibility(View.GONE);
                }
            }
        });

        RadioGroup radioGroup6 = (RadioGroup) findViewById(R.id.rg14);
        radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(ernplpr50.isChecked()==true){
                    ll2.setVisibility(View.VISIBLE);
                }else{
                    ll2.setVisibility(View.GONE);
                }
            }
        });

        RadioGroup radioGroup7 = (RadioGroup) findViewById(R.id.rg4);
        radioGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(ernplpr58.isChecked()==true){
                    ernplpt51.setVisibility(View.VISIBLE);
                }else{
                    ernplpt51.setVisibility(View.GONE);
                    ernplpt51.setText("");
                }
            }
        });

        RadioGroup radioGroup8 = (RadioGroup) findViewById(R.id.rg5);
        radioGroup8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(ernplpr60.isChecked()==true){
                    ernplpt52.setVisibility(View.VISIBLE);
                }else{
                    ernplpt52.setVisibility(View.GONE);
                    ernplpt52.setText("");
                }
            }
        });

        RadioGroup radioGroup9 = (RadioGroup) findViewById(R.id.rg6);
        radioGroup9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(ernplpr62.isChecked()==true){
                    ernplpt53.setVisibility(View.VISIBLE);
                }else{
                    ernplpt53.setVisibility(View.GONE);
                    ernplpt53.setText("");
                }
            }
        });

        ernplpt8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 6:
                        especifique.setVisibility(View.VISIBLE);
                        break;
                    default:
                        especifique.setVisibility(View.GONE);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spdia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ernplpt4.setText(spdia.getSelectedItem().toString() + "/" + spmes.getSelectedItem().toString() + "/" + spaño.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spmes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ernplpt4.setText(spdia.getSelectedItem().toString() + "/" + spmes.getSelectedItem().toString() + "/" + spaño.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spaño.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ernplpt4.setText(spdia.getSelectedItem().toString() + "/" + spmes.getSelectedItem().toString() + "/" + spaño.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spdia2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ernplpt37.setText(spdia2.getSelectedItem().toString() + "/" + spmes2.getSelectedItem().toString() + "/" + spaño2.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spmes2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ernplpt37.setText(spdia2.getSelectedItem().toString() + "/" + spmes2.getSelectedItem().toString() + "/" + spaño2.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spaño2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ernplpt37.setText(spdia2.getSelectedItem().toString() + "/" + spmes2.getSelectedItem().toString() + "/" + spaño2.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ernplpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(Liconsa.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        ernplpt4.setText(mDay +"/"+ (mMonth+1) +"/"+ mYear);
                    }
                }, year, month, day);
                dpd.show();
            }
        });

        ernplpt37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c2 = Calendar.getInstance();
                int day2 = c2.get(Calendar.DAY_OF_MONTH);
                int month2 = c2.get(Calendar.MONTH);
                int year2 = c2.get(Calendar.YEAR);

                dpd2 = new DatePickerDialog(Liconsa.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear2, int mMonth2, int mDay2) {
                        ernplpt37.setText(mDay2 +"/"+ (mMonth2+1) +"/"+ mYear2);
                    }
                }, year2, month2, day2);
                dpd2.show();
            }
        });

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ernplpt6.setText("AAAA990131MDFZZZ00");
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ernplpt7.setText("AAAA990131ZZ9");
            }
        });




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

    public boolean validar(){
        boolean retorno=true;
        if(ernplpt1.getText().toString().isEmpty()) {
            ernplpt1.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(ernplpt2.getText().toString().isEmpty()) {
            ernplpt2.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(ernplpt3.getText().toString().isEmpty()) {
            ernplpt3.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(ernplpt4.getText().toString().isEmpty()) {
            ernplpt4.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(!ernplpr1.isChecked() && !ernplpr2.isChecked()){
            ernplpr1.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(ernplpt5.getText().toString().isEmpty()) {
            ernplpt5.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(ernplpt6.getText().toString().isEmpty()) {
            ernplpt6.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(!validarCURP(ernplpt6.getText().toString())){
            ernplpt6.setError("CURP invalido");
            retorno=false;
        }
        else if(ernplpt7.getText().toString().isEmpty()) {
            ernplpt7.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(!validarRFC(ernplpt7.getText().toString())){
            ernplpt7.setError("RFC invalido");
            retorno=false;
        }
        else if(ernplpt8.getSelectedItem().toString().equals("Otro") && especifique.getText().toString().isEmpty()){
            especifique.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(ernplpt9.getText().toString().isEmpty()) {
            ernplpt9.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(ernplpt12.getText().toString().isEmpty()) {
            ernplpt12.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(ernplpt16.getText().toString().isEmpty()) {
            ernplpt16.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(ernplpt15.getText().toString().isEmpty()) {
            ernplpt15.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(rnplup7.getText().toString().isEmpty()) {
            rnplup7.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(rnplup1.getText().toString().isEmpty()) {
            rnplup1.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(rnplup4.getText().toString().isEmpty()) {
            rnplup4.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(rnplup5.getText().toString().isEmpty()) {
            rnplup5.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(rnplup6.getText().toString().isEmpty()) {
            rnplup6.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(!ernplpr25.isChecked() && !ernplpr26.isChecked()){
            ernplpr25.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(ernplpr25.isChecked() && ernplpt24.getText().toString().isEmpty()){
            ernplpt24.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!ernplpr27.isChecked() && !ernplpr28.isChecked() && !ernplpr29.isChecked()){
            ernplpr27.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!ernplpr30.isChecked() && !ernplpr31.isChecked()){
            ernplpr30.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(ernplpr30.isChecked() && ernplpt25.getText().toString().isEmpty()){
            ernplpt25.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!ernplpr32.isChecked() && !ernplpr33.isChecked()){
            ernplpr32.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(ernplpr32.isChecked() && ernplpt26.getText().toString().isEmpty()){
            ernplpt26.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!ernplpr34.isChecked() && !ernplpr35.isChecked()){
            ernplpr34.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(ernplpt27.getText().toString().isEmpty()) {
            ernplpt27.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(ernplpt28.getText().toString().isEmpty()) {
            ernplpt28.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(ernplpt29.getText().toString().isEmpty()) {
            ernplpt29.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(ernplpt30.getText().toString().isEmpty()) {
            ernplpt30.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(ernplpt31.getText().toString().isEmpty()) {
            ernplpt31.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(ernplpt32.getText().toString().isEmpty()) {
            ernplpt32.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(ernplpt33.getText().toString().isEmpty()) {
            ernplpt33.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(ernplpt34.getText().toString().isEmpty()) {
            ernplpt34.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(ernplpt35.getText().toString().isEmpty()) {
            ernplpt35.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(ernplpt36.getText().toString().isEmpty()) {
            ernplpt36.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(!ernplpr36.isChecked() && !ernplpr37.isChecked()){
            ernplpr36.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(ernplpt37.getText().toString().isEmpty()) {
            ernplpt37.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(ernplpt38.getText().toString().isEmpty()) {
            ernplpt38.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(ernplpt39.getText().toString().isEmpty()) {
            ernplpt39.setError("No puede quedar vacio");
            retorno = false;
        }
        else if(!ernplpr38.isChecked() && !ernplpr39.isChecked()){
            ernplpr38.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!ernplpr40.isChecked() && !ernplpr41.isChecked()){
            ernplpr40.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!ernplpr42.isChecked() && !ernplpr43.isChecked()){
            ernplpr42.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!ernplpr44.isChecked() && !ernplpr45.isChecked()){
            ernplpr44.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!ernplpr46.isChecked() && !ernplpr47.isChecked()){
            ernplpr46.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(ernplpr46.isChecked() && ernplpt40.getText().toString().isEmpty()){
            ernplpt40.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!ernplpr48.isChecked() && !ernplpr49.isChecked()){
            ernplpr48.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!ernplpr50.isChecked() && !ernplpr51.isChecked()){
            ernplpr50.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!ernplpr52.isChecked() && !ernplpr53.isChecked()){
            ernplpr52.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!ernplpr54.isChecked() && !ernplpr55.isChecked()){
            ernplpr54.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!ernplpr56.isChecked() && !ernplpr57.isChecked()){
            ernplpr56.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!ernplpr58.isChecked() && !ernplpr59.isChecked()){
            ernplpr58.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!ernplpr64.isChecked() && !ernplpr65.isChecked()){
            ernplpr64.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!ernplpr66.isChecked() && !ernplpr67.isChecked()){
            ernplpr66.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!ernplpr68.isChecked() && !ernplpr69.isChecked() && !ernplpr70.isChecked()){
            ernplpr68.setError("Debes seleccionar una opción");
            retorno=false;
        }

        return retorno;
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

    public boolean validarRFC(String rfc)
    { String regex =
            "[A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}" +
                    "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])" +
                    "[0-9A-Z]{3}$";

        Pattern patron = Pattern.compile(regex);
        if(!patron.matcher(rfc).matches())
        { return false;
        }else
        { return true;
        }
    }

    @Override
    public void onBackPressed() {

    }
}