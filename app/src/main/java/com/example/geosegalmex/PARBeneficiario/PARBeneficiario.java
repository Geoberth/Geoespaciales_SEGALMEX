package com.example.geosegalmex.PARBeneficiario;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Georeferencia.GeoreferenciaActivity;
import com.example.geosegalmex.PAROperativo.PAR_operativo_model;
import com.example.geosegalmex.PAROperativo.PARoperativoBD;
import com.example.geosegalmex.R;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PARBeneficiario extends AppCompatActivity {


    int dia, mes, anio;
    PARBeneficiario_Model model;

    EditText fec, parbt2, parbt3, parbt4, parbt5, parbt6, parbt7;
    RadioButton parbr1, parbr2, parbr3, parbr4, parbr5, parbr6, parbr7, parbr8, parbr9, parbr10, parbr11, parbr12, parbr13, parbr14, parbr15, parbr16, parbr17, parbr18, parbr19, parbr20, parbr21, parbr22, parbr23, parbr24, parbr25, parbr26, parbr27, parbr28, parbr29, parbr30, parbr31, parbr32, parbr33, parbr34, parbr35, parbr36, parbr37, parbr38, parbr39, parbr40, parbr41, parbr42, parbr43, parbr44, parbr45, parbr46, parbr47, parbr48, parbr49, parbr50, parbr51, parbr52, parbr53, parbr54;
    Spinner parbs1, parbs2, folios;
    EditText parbs3, parbt23, parbt27;
    TextView textFecha, tv3;
    CheckBox parbc1, parbc2, parbc3, parbc4, parbc5, parbc6, parbc7, parbc8, parbc9, parbc10, parbc11, parbc12, parbc13, parbc14, parbc15, parbc16, parbc17, parbc18, parbc19, parbc20, parbc21, parbc22, parbc23, parbc24, parbc25, parbc26, parbc27, parbc28, parbc29, parbc30, parbc31, parbc32, parbc33, parbc34, parbc35, parbc36, parbc37, parbc38, parbc39, parbc40, parbc41, parbc42, parbc43, parbc44, parbc45, parbc46, parbc47, parbc48, parbc49, parbc50, parbc51, parbc52, parbc53, parbc54, parbc55, parbc56, parbc57, parbc58, parbc59, parbc60, parbc61, parbc62, parbc63, parbc64, parbc65, parbc66, parbc67, parbc68, parbc69, parbc70, parbc71, parbc72, parbc73, parbc74, parbc75, parbc76, parbc77, parbc78, parbc79, parbc80, parbc81, parbc82, parbc83, parbc84, parbc85, parbc86, parbc87, parbc88, parbc89, parbc90, parbc91, parbc92, parbc93, parbc94, parbc95, parbc96, parbc97, parbc98, parbc99, parbc100, parbc101, parbc102, parbc103, parbc104, parbc105, parbc106, parbc107, parbc108, parbc109, parbc110, parbc111, parbc112, parbc113, parbc114, parbc115, parbc116, parbc117, parbc118, parbc119, parbc120, parbc121, parbc122, parbc123, parbc124, parbc125, parbc126, parbc127, parbc128, parbc129, parbc130, parbc131, parbc132, parbc133, parbc134, parbc135, parbc136, parbc137, parbc138, parbc139, parbc140, parbc141, parbc142, parbc143, parbc144, parbc145, parbc146, parbc147, parbc148, parbc149, parbc150, parbc151, parbc152, parbc153, parbc154, parbc155, parbc156, parbc157, parbc158, parbc159, parbc160, parbc161, parbc162, parbc163, parbc164, parbc165, parbc166, parbc167, parbc168, parbc169, parbc170, parbc171, parbc172, parbc173, parbc174, parbc175, parbc176, parbc177, parbc178, parbc179, parbc180, parbc181, parbc182, parbc183, parbc184, parbc185, parbc186, parbc187, parbc188, parbc189, parbc190, parbc191, parbc192, parbc193, parbc194, parbc195, parbc196, parbc197, parbc198, parbc199, parbc200, parbc201, parbc202, parbc203, parbc204, parbc205, parbc206, parbc207, parbc208, parbc209, parbc210, parbc211, parbc212, parbc213, parbc214, parbc215, parbc216, parbc217, parbc218, parbc219, parbc220, parbc221, parbc222, parbc223, parbc224, parbc225, parbc226, parbc227, parbc228, parbc229, parbc230, parbc231, parbc232, parbc233, parbc234, parbc235, parbc236, parbc237, parbc238, parbc239, parbc240, parbc241, parbc242, parbc243, parbc244, parbc245, parbc246;
    CheckBox parbc47_1,parbc47_2,parbc47_3,parbc47_4,parbc47_5,parbc47_6,parbc47_7,parbc47_8,parbc47_9,parbc47_10,parbc47_11,parbc47_12,parbc47_13,parbc47_14,parbc47_15,parbc47_16,parbc47_17,parbc47_18,parbc47_19,parbc47_20
            ,parbc47_21,parbc47_22,parbc47_23,parbc47_24,parbc47_25,parbc47_26,parbc47_27,parbc47_28,parbc47_29,parbc47_30,parbc47_31,parbc47_32,parbc47_33,parbc47_34,parbc47_35,parbc47_36,parbc47_37,parbc47_38,parbc47_39
            ,parbc47_40,parbc47_41,parbc47_42,parbc47_43,parbc47_44,parbc47_45,parbc47_46,parbc47_47,parbc47_48,parbc47_49,parbc47_50,parbc47_51,parbc47_52,parbc47_53,parbc47_54,parbc47_55,parbc47_56,parbc47_57
            ,parbc9_1,parbc9_2,parbc9_3,parbc9_4,parbc9_5,parbc9_6,parbc9_7,parbc9_8,parbc9_9,parbc9_10,parbc9_11,parbc9_12,parbc9_13,parbc9_14,parbc9_15,parbc9_16,parbc9_17,parbc9_18
            ,parbc9_19,parbc9_20,parbc9_21,parbc9_22,parbc9_23,parbc9_24,parbc9_25,parbc9_26,parbc9_27,parbc9_28,parbc9_29,parbc9_30,parbc9_31,parbc9_32,parbc9_33,parbc9_34
            ,parbc9_35,parbc9_36,parbc9_37,parbc9_38,parbc9_39,parbc9_40,parbc9_41,parbc9_42,parbc9_43,parbc9_44,parbc9_45,parbc9_46,parbc9_47,parbc9_48,parbc9_49,parbc9_50
            ,parbc9_51,parbc9_52,parbc9_53,parbc9_54,parbc9_55,parbc9_56,parbc9_57,parbc236_1,parbc236_2,parbc236_3,parbc236_4,parbc236_5,parbc236_6,parbc236_7,parbc236_8,parbc236_9,parbc236_10,parbc236_11,parbc236_12,parbc236_13,parbc236_14,parbc236_15,parbc236_16,parbc236_17,parbc236_18,parbc236_19,parbc236_20,parbc236_21,parbc236_22
            ,parbc236_23,parbc236_24,parbc236_25,parbc236_26,parbc236_27,parbc236_28,parbc236_29,parbc236_30,parbc236_31,parbc236_32,parbc236_33,parbc236_34,parbc236_35,parbc236_36,parbc236_37,parbc236_38,parbc236_39,parbc236_40,parbc236_41,parbc236_42,parbc236_43,parbc236_44,parbc236_45,parbc236_46,parbc236_47,parbc236_48,parbc236_49,parbc236_50,parbc236_51,parbc236_52,parbc236_53,parbc236_54
            ,parbc236_55,parbc236_56,parbc236_57;
    Button btnSiguiente;
    int bandera = 0, bandera2 = 0, bandera3 = 0, bandera4 = 0;
    GridLayout cinco, siete, ocho, diesinueve, dos, combo19;
    LinearLayout trece, diesiciete;
    RadioButton parbr198, parbr199;
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
        setContentView(R.layout.activity_parbeneficiario);

        Declaracion();
        cinco.setVisibility(View.GONE);
        siete.setVisibility(View.GONE);
        trece.setVisibility(View.GONE);
        diesiciete.setVisibility(View.GONE);
        parbt23.setVisibility(View.GONE);
        parbt5.setVisibility(View.GONE);
        parbt6.setVisibility(View.GONE);



        muestrafecha();
        Eventos();

        parbs1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String[] estados = getResources().getStringArray(R.array.Estados2021);
                String[] cveestados = getResources().getStringArray(R.array.cveEstados2021);

                cveedo = cveestados[position];
                nomedo = estados[position];

                municipios = getResources().getStringArray(idmunicipios[position]);
                cvemunicipios = getResources().getStringArray(idcvemunicipios[position]);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(PARBeneficiario.this, android.R.layout.simple_spinner_item, municipios);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                parbs2.setAdapter(adapter);
                parbs2.setEnabled(true);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        parbs2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                nommun = municipios[position];
                cvemun = cvemunicipios[position];
                //Toast.makeText(getApplicationContext(), "cveEdo: " + cveedo + "\n Edo: " + nomedo + "\n cveMun: " + nommun + "\n Mun: " + cvemun,Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validar()){
                    String folop = folios.getSelectedItem().toString();
                    String fol = General.Foliocuestion;
                    General.fechaenc = textFecha.getText().toString();
                    String cveEdo = cveedo;
                    String Edo = nomedo;
                    String cveMun = cvemun;
                    String Mun = nommun;
                    String cveLoc = "";
                    String Loc = parbs3.getText().toString();
                    String sexo = obtenerResultado(parbr1, parbr2);
                    String edad = parbt3.getText().toString();
                    String uno = obtenerResultado(parbr3, parbr4);
                    String dos = Resultado2();
                    String tres = obtenerResultado(parbr5, parbr6);
                    String cuatro = obtenerResultado3(parbr7, parbr8, parbr9);
                    String cinco = obtenerResultado(parbr10, parbr11);
                    String cincocuales = (parbr10.isChecked()==true)? Resultado5() : "" ;
                    String seis = obtenerResultado3(parbr12, parbr13, parbr14);
                    String siete = obtenerResultado(parbr15, parbr16);
                    String sietecuales = (parbr16.isChecked()==true)? Resultado7() : "" ;
                    String ocho = Resultado8();
                    String nueve = obtenerResultado(parbr19, parbr20);
                    String diez = obtenerResultado(parbr21, parbr22);
                    String once = obtenerResultado(parbr23, parbr24);
                    String doce = obtenerResultado(parbr25, parbr26);
                    String trece = obtenerResultado(parbr27, parbr28);
                    String trececuales = (parbr27.isChecked()==true)? Resultado13() : "" ;
                    String catorce = Resultado14();
                    String quince = obtenerResultado6(parbr29, parbr30, parbr31, parbr32, parbr33, parbr34);
                    String dieciseis = obtenerResultado4(parbr35, parbr36, parbr37, parbr38);
                    String diecisiete = obtenerResultado(parbr39, parbr40);
                    String cuales17 = (parbr39.isChecked()==true)? Resultado17() : "" ;
                    String dieciocho = obtenerResultado(parbr41, parbr42);
                    String diecinueve = obtenerResultado(parbr43, parbr44);
                    String cuales19 = (parbr43.isChecked()==true)? Resultado19() : "" ;
                    String veinte = obtenerResultado(parbr45, parbr46);
                    String ventiuno = obtenerResultado3(parbr47, parbr48, parbr49);
                    String ventidos = obtenerResultado3(parbr50, parbr51, parbr52);
                    String ventitres = obtenerResultado(parbr53, parbr54);
                    String explique23 = (parbr54.isChecked()==true)? parbt23.getText().toString() : "" ;
                    String venticuatro = obtenerResultado(parbr198, parbr199);
                    String venticinco = Resultado25();
                    String otro25 = parbt5.getText().toString();
                    String ventiseis = Resultado26();
                    String otro26 = parbt6.getText().toString();
                    String ventisiete = parbt27.getText().toString();
                    String f1 = General.Foto1;
                    String f2 = General.Foto2;

                    model = new PARBeneficiario_Model(folop, fol, General.fechaenc, cveEdo, Edo, cveMun, Mun, cveLoc, Loc, sexo, edad, uno, dos, tres, cuatro, cinco, cincocuales, seis, siete, sietecuales,
                            ocho, nueve, diez, once, doce, trece, trececuales, catorce, quince, dieciseis, diecisiete, cuales17, dieciocho, diecinueve, cuales19, veinte, ventiuno, ventidos, ventitres,
                            explique23, venticuatro, venticinco, otro25, ventiseis, otro26, ventisiete, f1, f2, "", "");

                    Intent in = new Intent(PARBeneficiario.this, GeoreferenciaActivity.class);
                    in.putExtra("model", model);
                    startActivity(in);

                }
                else{
                    Toast.makeText(getApplicationContext(), "Faltan respuestas",Toast.LENGTH_SHORT).show();
                }
            }
        });


        //LISTADO OPERARIOS
        ArrayList<String> listapersonas;
        ArrayList<PARBeneficiario_Model> folioslist;

        PARoperativoBD db = new PARoperativoBD(PARBeneficiario.this);
        List<PAR_operativo_model> everyone = db.getEveryone();

        ArrayList<String> Miarreglo = new ArrayList<>();

        for(int i=0; i<everyone.size(); i++){
            Miarreglo.add(everyone.get(i).getFolio());
        }

        folios = (Spinner)findViewById(R.id.sp1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(PARBeneficiario.this, android.R.layout.simple_spinner_item, Miarreglo);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        folios.setAdapter(adapter2);
        folios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv3.setText("Entidad: " + everyone.get(position).getNoment() + "\nMunicipio: " + everyone.get(position).getNommun() + "\nNombre: " + everyone.get(position).getParnom() + " " + everyone.get(position).getParape());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });




    }



    public void Declaracion(){

        tv3 = (TextView)findViewById(R.id.tv3);


        siete=(GridLayout)findViewById(R.id.combo7);
        ocho=(GridLayout)findViewById(R.id.combo8);
        diesinueve=(GridLayout)findViewById(R.id.combo19);
        trece=(LinearLayout) findViewById(R.id.combo13);
        diesiciete=(LinearLayout)findViewById(R.id.combo17);
        cinco=(GridLayout)findViewById(R.id.combo5);
        dos=(GridLayout)findViewById(R.id.combo2);
        combo19=(GridLayout)findViewById(R.id.combo19);
        textFecha=(TextView)findViewById(R.id.pasl_o_txtFecha);

        //DATOS DE LA TIENDA DICONSA (PRE-LLENADO)

        parbs1=(Spinner)findViewById(R.id.par_ben_spin1); //Estado
        parbs2=(Spinner)findViewById(R.id.par_ben_spin2); //Municipio
        parbs3=(EditText)findViewById(R.id.par_ben_spin3); //Localidad/colonia

        //Sexo
        parbr1=(RadioButton)findViewById(R.id.par_ben_ra1);
        parbr2=(RadioButton)findViewById(R.id.par_ben_ra2);

        //Edad
        parbt3=(EditText)findViewById(R.id.par_ben_txt3);

        //PREGUNTAS PARA CONSUMIDORES SOBRE LA OPERACIÓN DE LAS TIENDAS

        parbr3=(RadioButton)findViewById(R.id.par_ben_ra3);
        parbr4=(RadioButton)findViewById(R.id.par_ben_ra4);

        //2. ¿Cuáles son los tres productos que usted compra con mayor frecuencia en la tienda?

        //Checkboxes de productos con marca
        parbc1=(CheckBox)findViewById(R.id.par_ben_ch1);
        parbc2=(CheckBox)findViewById(R.id.par_ben_ch2);
        parbc3=(CheckBox)findViewById(R.id.par_ben_ch3);
        parbc4=(CheckBox)findViewById(R.id.par_ben_ch4);
        parbc5=(CheckBox)findViewById(R.id.par_ben_ch5);
        parbc6=(CheckBox)findViewById(R.id.par_ben_ch6);
        parbc7=(CheckBox)findViewById(R.id.par_ben_ch7);
        parbc8=(CheckBox)findViewById(R.id.par_ben_ch8);
        parbc9=(CheckBox)findViewById(R.id.par_ben_ch9);
        parbc10=(CheckBox)findViewById(R.id.par_ben_ch10);
        parbc11=(CheckBox)findViewById(R.id.par_ben_ch11);
        parbc12=(CheckBox)findViewById(R.id.par_ben_ch12);
        parbc13=(CheckBox)findViewById(R.id.par_ben_ch13);
        parbc14=(CheckBox)findViewById(R.id.par_ben_ch14);
        parbc15=(CheckBox)findViewById(R.id.par_ben_ch15);
        parbc16=(CheckBox)findViewById(R.id.par_ben_ch16);
        parbc17=(CheckBox)findViewById(R.id.par_ben_ch17);
        parbc18=(CheckBox)findViewById(R.id.par_ben_ch18);
        parbc19=(CheckBox)findViewById(R.id.par_ben_ch19);
        parbc20=(CheckBox)findViewById(R.id.par_ben_ch20);
        parbc21=(CheckBox)findViewById(R.id.par_ben_ch21);
        parbc22=(CheckBox)findViewById(R.id.par_ben_ch22);
        parbc23=(CheckBox)findViewById(R.id.par_ben_ch23);
        parbc24=(CheckBox)findViewById(R.id.par_ben_ch24);
        parbc25=(CheckBox)findViewById(R.id.par_ben_ch25);
        parbc26=(CheckBox)findViewById(R.id.par_ben_ch26);
        parbc27=(CheckBox)findViewById(R.id.par_ben_ch27);
        parbc28=(CheckBox)findViewById(R.id.par_ben_ch28);
        parbc29=(CheckBox)findViewById(R.id.par_ben_ch29);
        parbc30=(CheckBox)findViewById(R.id.par_ben_ch30);
        parbc31=(CheckBox)findViewById(R.id.par_ben_ch31);
        parbc32=(CheckBox)findViewById(R.id.par_ben_ch32);
        parbc33=(CheckBox)findViewById(R.id.par_ben_ch33);
        parbc34=(CheckBox)findViewById(R.id.par_ben_ch34);
        parbc35=(CheckBox)findViewById(R.id.par_ben_ch35);
        parbc36=(CheckBox)findViewById(R.id.par_ben_ch36);
        parbc37=(CheckBox)findViewById(R.id.par_ben_ch37);
        parbc38=(CheckBox)findViewById(R.id.par_ben_ch38);
        parbc39=(CheckBox)findViewById(R.id.par_ben_ch39);
        parbc40=(CheckBox)findViewById(R.id.par_ben_ch40);
        parbc41=(CheckBox)findViewById(R.id.par_ben_ch41);
        parbc42=(CheckBox)findViewById(R.id.par_ben_ch42);
        parbc43=(CheckBox)findViewById(R.id.par_ben_ch43);
        parbc44=(CheckBox)findViewById(R.id.par_ben_ch44);
        parbc45=(CheckBox)findViewById(R.id.par_ben_ch45);
        parbc46=(CheckBox)findViewById(R.id.par_ben_ch46);
        parbc47=(CheckBox)findViewById(R.id.par_ben_ch47);
        parbc47_1=(CheckBox)findViewById(R.id.par_ben_ch47_1);
        parbc47_2=(CheckBox)findViewById(R.id.par_ben_ch47_2);
        parbc47_3=(CheckBox)findViewById(R.id.par_ben_ch47_3);
        parbc47_4=(CheckBox)findViewById(R.id.par_ben_ch47_4);
        parbc47_5=(CheckBox)findViewById(R.id.par_ben_ch47_5);
        parbc47_6=(CheckBox)findViewById(R.id.par_ben_ch47_6);
        parbc47_7=(CheckBox)findViewById(R.id.par_ben_ch47_7);
        parbc47_8=(CheckBox)findViewById(R.id.par_ben_ch47_8);
        parbc47_9=(CheckBox)findViewById(R.id.par_ben_ch47_9);
        parbc47_10=(CheckBox)findViewById(R.id.par_ben_ch47_10);
        parbc47_11=(CheckBox)findViewById(R.id.par_ben_ch47_11);
        parbc47_12=(CheckBox)findViewById(R.id.par_ben_ch47_12);
        parbc47_13=(CheckBox)findViewById(R.id.par_ben_ch47_13);
        parbc47_14=(CheckBox)findViewById(R.id.par_ben_ch47_14);
        parbc47_15=(CheckBox)findViewById(R.id.par_ben_ch47_15);
        parbc47_16=(CheckBox)findViewById(R.id.par_ben_ch47_16);
        parbc47_17=(CheckBox)findViewById(R.id.par_ben_ch47_17);
        parbc47_18=(CheckBox)findViewById(R.id.par_ben_ch47_18);
        parbc47_19=(CheckBox)findViewById(R.id.par_ben_ch47_19);
        parbc47_20=(CheckBox)findViewById(R.id.par_ben_ch47_20);
        parbc47_21=(CheckBox)findViewById(R.id.par_ben_ch47_21);
        parbc47_22=(CheckBox)findViewById(R.id.par_ben_ch47_22);
        parbc47_23=(CheckBox)findViewById(R.id.par_ben_ch47_23);
        parbc47_24=(CheckBox)findViewById(R.id.par_ben_ch47_24);
        parbc47_25=(CheckBox)findViewById(R.id.par_ben_ch47_25);
        parbc47_26=(CheckBox)findViewById(R.id.par_ben_ch47_26);
        parbc47_27=(CheckBox)findViewById(R.id.par_ben_ch47_27);
        parbc47_28=(CheckBox)findViewById(R.id.par_ben_ch47_28);
        parbc47_29=(CheckBox)findViewById(R.id.par_ben_ch47_29);
        parbc47_30=(CheckBox)findViewById(R.id.par_ben_ch47_30);
        parbc47_31=(CheckBox)findViewById(R.id.par_ben_ch47_31);
        parbc47_32=(CheckBox)findViewById(R.id.par_ben_ch47_32);
        parbc47_33=(CheckBox)findViewById(R.id.par_ben_ch47_33);
        parbc47_34=(CheckBox)findViewById(R.id.par_ben_ch47_34);
        parbc47_35=(CheckBox)findViewById(R.id.par_ben_ch47_35);
        parbc47_36=(CheckBox)findViewById(R.id.par_ben_ch47_36);
        parbc47_37=(CheckBox)findViewById(R.id.par_ben_ch47_37);
        parbc47_38=(CheckBox)findViewById(R.id.par_ben_ch47_38);
        parbc47_39=(CheckBox)findViewById(R.id.par_ben_ch47_39);
        parbc47_40=(CheckBox)findViewById(R.id.par_ben_ch47_40);
        parbc47_41=(CheckBox)findViewById(R.id.par_ben_ch47_41);
        parbc47_42=(CheckBox)findViewById(R.id.par_ben_ch47_42);
        parbc47_43=(CheckBox)findViewById(R.id.par_ben_ch47_43);
        parbc47_44=(CheckBox)findViewById(R.id.par_ben_ch47_44);
        parbc47_45=(CheckBox)findViewById(R.id.par_ben_ch47_45);
        parbc47_46=(CheckBox)findViewById(R.id.par_ben_ch47_46);
        parbc47_47=(CheckBox)findViewById(R.id.par_ben_ch47_47);
        parbc47_48=(CheckBox)findViewById(R.id.par_ben_ch47_48);
        parbc47_49=(CheckBox)findViewById(R.id.par_ben_ch47_49);
        parbc47_50=(CheckBox)findViewById(R.id.par_ben_ch47_50);
        parbc47_51=(CheckBox)findViewById(R.id.par_ben_ch47_51);
        parbc47_52=(CheckBox)findViewById(R.id.par_ben_ch47_52);
        parbc47_53=(CheckBox)findViewById(R.id.par_ben_ch47_53);
        parbc47_54=(CheckBox)findViewById(R.id.par_ben_ch47_54);
        parbc47_55=(CheckBox)findViewById(R.id.par_ben_ch47_55);
        parbc47_56=(CheckBox)findViewById(R.id.par_ben_ch47_56);
        parbc47_57=(CheckBox)findViewById(R.id.par_ben_ch47_57);



        //Fin checkboxes

        parbr5=(RadioButton)findViewById(R.id.par_ben_ra5);
        parbr6=(RadioButton)findViewById(R.id.par_ben_ra6);
        parbr7=(RadioButton)findViewById(R.id.par_ben_ra7);
        parbr8=(RadioButton)findViewById(R.id.par_ben_ra8);
        parbr9=(RadioButton)findViewById(R.id.par_ben_ra9);
        parbr10=(RadioButton)findViewById(R.id.par_ben_ra10);
        parbr11=(RadioButton)findViewById(R.id.par_ben_ra11);

        //5. ¿Compra usted productos SEGALMEX?

        //Checkboxes de productos con marca
        parbc48=(CheckBox)findViewById(R.id.par_ben_ch48);
        parbc49=(CheckBox)findViewById(R.id.par_ben_ch49);
        parbc50=(CheckBox)findViewById(R.id.par_ben_ch50);
        parbc51=(CheckBox)findViewById(R.id.par_ben_ch51);
        parbc52=(CheckBox)findViewById(R.id.par_ben_ch52);
        parbc53=(CheckBox)findViewById(R.id.par_ben_ch53);
        parbc54=(CheckBox)findViewById(R.id.par_ben_ch54);
        parbc55=(CheckBox)findViewById(R.id.par_ben_ch55);
        parbc56=(CheckBox)findViewById(R.id.par_ben_ch56);
        parbc57=(CheckBox)findViewById(R.id.par_ben_ch57);
        parbc58=(CheckBox)findViewById(R.id.par_ben_ch58);
        parbc59=(CheckBox)findViewById(R.id.par_ben_ch59);
        parbc60=(CheckBox)findViewById(R.id.par_ben_ch60);
        parbc61=(CheckBox)findViewById(R.id.par_ben_ch61);
        parbc62=(CheckBox)findViewById(R.id.par_ben_ch62);
        parbc63=(CheckBox)findViewById(R.id.par_ben_ch63);
        parbc64=(CheckBox)findViewById(R.id.par_ben_ch64);
        parbc65=(CheckBox)findViewById(R.id.par_ben_ch65);
        parbc66=(CheckBox)findViewById(R.id.par_ben_ch66);
        parbc67=(CheckBox)findViewById(R.id.par_ben_ch67);
        parbc68=(CheckBox)findViewById(R.id.par_ben_ch68);
        parbc69=(CheckBox)findViewById(R.id.par_ben_ch69);
        parbc70=(CheckBox)findViewById(R.id.par_ben_ch70);
        parbc71=(CheckBox)findViewById(R.id.par_ben_ch71);
        parbc72=(CheckBox)findViewById(R.id.par_ben_ch72);
        parbc73=(CheckBox)findViewById(R.id.par_ben_ch73);
        parbc74=(CheckBox)findViewById(R.id.par_ben_ch74);
        parbc75=(CheckBox)findViewById(R.id.par_ben_ch75);
        parbc76=(CheckBox)findViewById(R.id.par_ben_ch76);
        parbc77=(CheckBox)findViewById(R.id.par_ben_ch77);
        parbc78=(CheckBox)findViewById(R.id.par_ben_ch78);
        parbc79=(CheckBox)findViewById(R.id.par_ben_ch79);
        parbc80=(CheckBox)findViewById(R.id.par_ben_ch80);
        parbc81=(CheckBox)findViewById(R.id.par_ben_ch81);
        parbc82=(CheckBox)findViewById(R.id.par_ben_ch82);
        parbc83=(CheckBox)findViewById(R.id.par_ben_ch83);
        parbc84=(CheckBox)findViewById(R.id.par_ben_ch84);
        parbc85=(CheckBox)findViewById(R.id.par_ben_ch85);
        parbc86=(CheckBox)findViewById(R.id.par_ben_ch86);
        parbc87=(CheckBox)findViewById(R.id.par_ben_ch87);
        parbc88=(CheckBox)findViewById(R.id.par_ben_ch88);
        parbc89=(CheckBox)findViewById(R.id.par_ben_ch89);
        parbc90=(CheckBox)findViewById(R.id.par_ben_ch90);
        parbc91=(CheckBox)findViewById(R.id.par_ben_ch91);
        parbc92=(CheckBox)findViewById(R.id.par_ben_ch92);
        parbc93=(CheckBox)findViewById(R.id.par_ben_ch93);
        parbc94=(CheckBox)findViewById(R.id.par_ben_ch94);
        //Fin checkboxes

        parbr12=(RadioButton)findViewById(R.id.par_ben_ra12);
        parbr13=(RadioButton)findViewById(R.id.par_ben_ra13);
        parbr14=(RadioButton)findViewById(R.id.par_ben_ra14);
        parbr15=(RadioButton)findViewById(R.id.par_ben_ra15);
        parbr16=(RadioButton)findViewById(R.id.par_ben_ra16);

        //7. ¿Hay algún producto que con frecuencia haga falta en la tienda?

        //Checkboxes de productos con marca
        parbc95=(CheckBox)findViewById(R.id.par_ben_ch95);
        parbc96=(CheckBox)findViewById(R.id.par_ben_ch96);
        parbc97=(CheckBox)findViewById(R.id.par_ben_ch97);
        parbc98=(CheckBox)findViewById(R.id.par_ben_ch98);
        parbc99=(CheckBox)findViewById(R.id.par_ben_ch99);

        parbc9_1=(CheckBox)findViewById(R.id.par_ben_ch99_1);
        parbc9_2=(CheckBox)findViewById(R.id.par_ben_ch99_2);
        parbc9_3=(CheckBox)findViewById(R.id.par_ben_ch99_3);
        parbc9_4=(CheckBox)findViewById(R.id.par_ben_ch99_4);
        parbc9_5=(CheckBox)findViewById(R.id.par_ben_ch99_5);
        parbc9_6=(CheckBox)findViewById(R.id.par_ben_ch99_6);
        parbc9_7=(CheckBox)findViewById(R.id.par_ben_ch99_7);
        parbc9_8=(CheckBox)findViewById(R.id.par_ben_ch99_8);
        parbc9_9=(CheckBox)findViewById(R.id.par_ben_ch99_9);
        parbc9_10=(CheckBox)findViewById(R.id.par_ben_ch99_10);
        parbc9_11=(CheckBox)findViewById(R.id.par_ben_ch99_11);
        parbc9_12=(CheckBox)findViewById(R.id.par_ben_ch99_12);
        parbc9_13=(CheckBox)findViewById(R.id.par_ben_ch99_13);
        parbc9_14=(CheckBox)findViewById(R.id.par_ben_ch99_14);
        parbc9_15=(CheckBox)findViewById(R.id.par_ben_ch99_15);
        parbc9_16=(CheckBox)findViewById(R.id.par_ben_ch99_16);
        parbc9_17=(CheckBox)findViewById(R.id.par_ben_ch99_17);
        parbc9_18=(CheckBox)findViewById(R.id.par_ben_ch99_18);
        parbc9_19=(CheckBox)findViewById(R.id.par_ben_ch99_19);
        parbc9_20=(CheckBox)findViewById(R.id.par_ben_ch99_20);
        parbc9_21=(CheckBox)findViewById(R.id.par_ben_ch99_21);
        parbc9_22=(CheckBox)findViewById(R.id.par_ben_ch99_22);
        parbc9_23=(CheckBox)findViewById(R.id.par_ben_ch99_23);
        parbc9_24=(CheckBox)findViewById(R.id.par_ben_ch99_24);
        parbc9_25=(CheckBox)findViewById(R.id.par_ben_ch99_25);
        parbc9_26=(CheckBox)findViewById(R.id.par_ben_ch99_26);
        parbc9_27=(CheckBox)findViewById(R.id.par_ben_ch99_27);
        parbc9_28=(CheckBox)findViewById(R.id.par_ben_ch99_28);
        parbc9_29=(CheckBox)findViewById(R.id.par_ben_ch99_29);
        parbc9_30=(CheckBox)findViewById(R.id.par_ben_ch99_30);
        parbc9_31=(CheckBox)findViewById(R.id.par_ben_ch99_31);
        parbc9_32=(CheckBox)findViewById(R.id.par_ben_ch99_32);
        parbc9_33=(CheckBox)findViewById(R.id.par_ben_ch99_33);
        parbc9_34=(CheckBox)findViewById(R.id.par_ben_ch99_34);
        parbc9_35=(CheckBox)findViewById(R.id.par_ben_ch99_35);
        parbc9_36=(CheckBox)findViewById(R.id.par_ben_ch99_36);
        parbc9_37=(CheckBox)findViewById(R.id.par_ben_ch99_37);
        parbc9_38=(CheckBox)findViewById(R.id.par_ben_ch99_38);
        parbc9_39=(CheckBox)findViewById(R.id.par_ben_ch99_39);
        parbc9_40=(CheckBox)findViewById(R.id.par_ben_ch99_40);
        parbc9_41=(CheckBox)findViewById(R.id.par_ben_ch99_41);
        parbc9_42=(CheckBox)findViewById(R.id.par_ben_ch99_42);
        parbc9_43=(CheckBox)findViewById(R.id.par_ben_ch99_43);
        parbc9_44=(CheckBox)findViewById(R.id.par_ben_ch99_44);
        parbc9_45=(CheckBox)findViewById(R.id.par_ben_ch99_45);
        parbc9_46=(CheckBox)findViewById(R.id.par_ben_ch99_46);
        parbc9_47=(CheckBox)findViewById(R.id.par_ben_ch99_47);
        parbc9_48=(CheckBox)findViewById(R.id.par_ben_ch99_48);
        parbc9_49=(CheckBox)findViewById(R.id.par_ben_ch99_49);
        parbc9_50=(CheckBox)findViewById(R.id.par_ben_ch99_50);
        parbc9_51=(CheckBox)findViewById(R.id.par_ben_ch99_51);
        parbc9_52=(CheckBox)findViewById(R.id.par_ben_ch99_52);
        parbc9_53=(CheckBox)findViewById(R.id.par_ben_ch99_53);
        parbc9_54=(CheckBox)findViewById(R.id.par_ben_ch99_54);
        parbc9_55=(CheckBox)findViewById(R.id.par_ben_ch99_55);
        parbc9_56=(CheckBox)findViewById(R.id.par_ben_ch99_56);
        parbc9_57=(CheckBox)findViewById(R.id.par_ben_ch99_57);


        //8. ¿Cuáles son los productos de la canasta básica de DICONSA que busca y no encuentra en la tienda?

        //Checkboxes de productos sin marca
        parbc142=(CheckBox)findViewById(R.id.par_ben_ch142);
        parbc143=(CheckBox)findViewById(R.id.par_ben_ch143);
        parbc144=(CheckBox)findViewById(R.id.par_ben_ch144);
        parbc145=(CheckBox)findViewById(R.id.par_ben_ch145);
        parbc146=(CheckBox)findViewById(R.id.par_ben_ch146);
        parbc147=(CheckBox)findViewById(R.id.par_ben_ch147);
        parbc148=(CheckBox)findViewById(R.id.par_ben_ch148);
        parbc149=(CheckBox)findViewById(R.id.par_ben_ch149);
        parbc150=(CheckBox)findViewById(R.id.par_ben_ch150);
        parbc151=(CheckBox)findViewById(R.id.par_ben_ch151);
        parbc152=(CheckBox)findViewById(R.id.par_ben_ch152);
        parbc153=(CheckBox)findViewById(R.id.par_ben_ch153);
        parbc154=(CheckBox)findViewById(R.id.par_ben_ch154);
        parbc155=(CheckBox)findViewById(R.id.par_ben_ch155);
        parbc156=(CheckBox)findViewById(R.id.par_ben_ch156);
        parbc157=(CheckBox)findViewById(R.id.par_ben_ch157);
        parbc158=(CheckBox)findViewById(R.id.par_ben_ch158);
        parbc159=(CheckBox)findViewById(R.id.par_ben_ch159);
        parbc160=(CheckBox)findViewById(R.id.par_ben_ch160);
        parbc161=(CheckBox)findViewById(R.id.par_ben_ch161);
        parbc162=(CheckBox)findViewById(R.id.par_ben_ch162);
        parbc163=(CheckBox)findViewById(R.id.par_ben_ch163);
        parbc164=(CheckBox)findViewById(R.id.par_ben_ch164);
        parbc165=(CheckBox)findViewById(R.id.par_ben_ch165);
        parbc166=(CheckBox)findViewById(R.id.par_ben_ch166);
        parbc167=(CheckBox)findViewById(R.id.par_ben_ch167);
        parbc168=(CheckBox)findViewById(R.id.par_ben_ch168);
        parbc169=(CheckBox)findViewById(R.id.par_ben_ch169);
        //Fin checkboxes

        parbr19=(RadioButton)findViewById(R.id.par_ben_ra19);
        parbr20=(RadioButton)findViewById(R.id.par_ben_ra20);
        parbr21=(RadioButton)findViewById(R.id.par_ben_ra21);
        parbr22=(RadioButton)findViewById(R.id.par_ben_ra22);
        parbr23=(RadioButton)findViewById(R.id.par_ben_ra23);
        parbr24=(RadioButton)findViewById(R.id.par_ben_ra24);
        parbr25=(RadioButton)findViewById(R.id.par_ben_ra25);
        parbr26=(RadioButton)findViewById(R.id.par_ben_ra26);
        parbr27=(RadioButton)findViewById(R.id.par_ben_ra27);
        parbr28=(RadioButton)findViewById(R.id.par_ben_ra28);

        parbc170=(CheckBox)findViewById(R.id.par_ben_ch170);
        parbc171=(CheckBox)findViewById(R.id.par_ben_ch171);
        parbc172=(CheckBox)findViewById(R.id.par_ben_ch172);
        parbc173=(CheckBox)findViewById(R.id.par_ben_ch173);
        parbc174=(CheckBox)findViewById(R.id.par_ben_ch174);
        parbc175=(CheckBox)findViewById(R.id.par_ben_ch175);
        parbc176=(CheckBox)findViewById(R.id.par_ben_ch176);
        parbc177=(CheckBox)findViewById(R.id.par_ben_ch177);
        parbc178=(CheckBox)findViewById(R.id.par_ben_ch178);
        parbc179=(CheckBox)findViewById(R.id.par_ben_ch179);
        parbc180=(CheckBox)findViewById(R.id.par_ben_ch180);
        parbc181=(CheckBox)findViewById(R.id.par_ben_ch181);
        parbc182=(CheckBox)findViewById(R.id.par_ben_ch182);
        parbc183=(CheckBox)findViewById(R.id.par_ben_ch183);
        parbc184=(CheckBox)findViewById(R.id.par_ben_ch184);
        parbc185=(CheckBox)findViewById(R.id.par_ben_ch185);

        parbr29=(RadioButton)findViewById(R.id.par_ben_ra29);
        parbr30=(RadioButton)findViewById(R.id.par_ben_ra30);
        parbr31=(RadioButton)findViewById(R.id.par_ben_ra31);
        parbr32=(RadioButton)findViewById(R.id.par_ben_ra32);
        parbr33=(RadioButton)findViewById(R.id.par_ben_ra33);
        parbr34=(RadioButton)findViewById(R.id.par_ben_ra34);
        parbr35=(RadioButton)findViewById(R.id.par_ben_ra35);
        parbr36=(RadioButton)findViewById(R.id.par_ben_ra36);
        parbr37=(RadioButton)findViewById(R.id.par_ben_ra37);
        parbr38=(RadioButton)findViewById(R.id.par_ben_ra38);
        parbr39=(RadioButton)findViewById(R.id.par_ben_ra39);
        parbr40=(RadioButton)findViewById(R.id.par_ben_ra40);

        parbc186=(CheckBox)findViewById(R.id.par_ben_ch186);
        parbc187=(CheckBox)findViewById(R.id.par_ben_ch187);
        parbc188=(CheckBox)findViewById(R.id.par_ben_ch188);
        parbc189=(CheckBox)findViewById(R.id.par_ben_ch189);

        parbr41=(RadioButton)findViewById(R.id.par_ben_ra41);
        parbr42=(RadioButton)findViewById(R.id.par_ben_ra42);

        //ENCUESTA DE OPINION

        //19. ¿Los productos de la canasta básica DICONSA han tenido efectos favorables en la nutrición de las personas de su familia?

        parbr43=(RadioButton)findViewById(R.id.par_ben_ra43);
        parbr44=(RadioButton)findViewById(R.id.par_ben_ra44);

        //Checkboxes de productos con marca
        parbc190=(CheckBox)findViewById(R.id.par_ben_ch190);
        parbc191=(CheckBox)findViewById(R.id.par_ben_ch191);
        parbc192=(CheckBox)findViewById(R.id.par_ben_ch192);
        parbc193=(CheckBox)findViewById(R.id.par_ben_ch193);
        parbc194=(CheckBox)findViewById(R.id.par_ben_ch194);
        parbc195=(CheckBox)findViewById(R.id.par_ben_ch195);
        parbc196=(CheckBox)findViewById(R.id.par_ben_ch196);
        parbc197=(CheckBox)findViewById(R.id.par_ben_ch197);
        parbc198=(CheckBox)findViewById(R.id.par_ben_ch198);
        parbc199=(CheckBox)findViewById(R.id.par_ben_ch199);
        parbc200=(CheckBox)findViewById(R.id.par_ben_ch200);
        parbc201=(CheckBox)findViewById(R.id.par_ben_ch201);
        parbc202=(CheckBox)findViewById(R.id.par_ben_ch202);
        parbc203=(CheckBox)findViewById(R.id.par_ben_ch203);
        parbc204=(CheckBox)findViewById(R.id.par_ben_ch204);
        parbc205=(CheckBox)findViewById(R.id.par_ben_ch205);
        parbc206=(CheckBox)findViewById(R.id.par_ben_ch206);
        parbc207=(CheckBox)findViewById(R.id.par_ben_ch207);
        parbc208=(CheckBox)findViewById(R.id.par_ben_ch208);
        parbc209=(CheckBox)findViewById(R.id.par_ben_ch209);
        parbc210=(CheckBox)findViewById(R.id.par_ben_ch210);
        parbc211=(CheckBox)findViewById(R.id.par_ben_ch211);
        parbc212=(CheckBox)findViewById(R.id.par_ben_ch212);
        parbc213=(CheckBox)findViewById(R.id.par_ben_ch213);
        parbc214=(CheckBox)findViewById(R.id.par_ben_ch214);
        parbc215=(CheckBox)findViewById(R.id.par_ben_ch215);
        parbc216=(CheckBox)findViewById(R.id.par_ben_ch216);
        parbc217=(CheckBox)findViewById(R.id.par_ben_ch217);
        parbc218=(CheckBox)findViewById(R.id.par_ben_ch218);
        parbc219=(CheckBox)findViewById(R.id.par_ben_ch219);
        parbc220=(CheckBox)findViewById(R.id.par_ben_ch220);
        parbc221=(CheckBox)findViewById(R.id.par_ben_ch221);
        parbc222=(CheckBox)findViewById(R.id.par_ben_ch222);
        parbc223=(CheckBox)findViewById(R.id.par_ben_ch223);
        parbc224=(CheckBox)findViewById(R.id.par_ben_ch224);
        parbc225=(CheckBox)findViewById(R.id.par_ben_ch225);
        parbc226=(CheckBox)findViewById(R.id.par_ben_ch226);
        parbc227=(CheckBox)findViewById(R.id.par_ben_ch227);
        parbc228=(CheckBox)findViewById(R.id.par_ben_ch228);
        parbc229=(CheckBox)findViewById(R.id.par_ben_ch229);
        parbc230=(CheckBox)findViewById(R.id.par_ben_ch230);
        parbc231=(CheckBox)findViewById(R.id.par_ben_ch231);
        parbc232=(CheckBox)findViewById(R.id.par_ben_ch232);
        parbc233=(CheckBox)findViewById(R.id.par_ben_ch233);
        parbc234=(CheckBox)findViewById(R.id.par_ben_ch234);
        parbc235=(CheckBox)findViewById(R.id.par_ben_ch235);
        parbc236=(CheckBox)findViewById(R.id.par_ben_ch236);

        parbc236_1=(CheckBox)findViewById(R.id.par_ben_ch236_1);
        parbc236_2=(CheckBox)findViewById(R.id.par_ben_ch236_2);
        parbc236_3=(CheckBox)findViewById(R.id.par_ben_ch236_3);
        parbc236_4=(CheckBox)findViewById(R.id.par_ben_ch236_4);
        parbc236_5=(CheckBox)findViewById(R.id.par_ben_ch236_5);
        parbc236_6=(CheckBox)findViewById(R.id.par_ben_ch236_6);
        parbc236_7=(CheckBox)findViewById(R.id.par_ben_ch236_7);
        parbc236_8=(CheckBox)findViewById(R.id.par_ben_ch236_8);
        parbc236_9=(CheckBox)findViewById(R.id.par_ben_ch236_9);
        parbc236_10=(CheckBox)findViewById(R.id.par_ben_ch236_10);
        parbc236_11=(CheckBox)findViewById(R.id.par_ben_ch236_11);
        parbc236_12=(CheckBox)findViewById(R.id.par_ben_ch236_12);
        parbc236_13=(CheckBox)findViewById(R.id.par_ben_ch236_13);
        parbc236_14=(CheckBox)findViewById(R.id.par_ben_ch236_14);
        parbc236_15=(CheckBox)findViewById(R.id.par_ben_ch236_15);
        parbc236_16=(CheckBox)findViewById(R.id.par_ben_ch236_16);
        parbc236_17=(CheckBox)findViewById(R.id.par_ben_ch236_17);
        parbc236_18=(CheckBox)findViewById(R.id.par_ben_ch236_18);
        parbc236_19=(CheckBox)findViewById(R.id.par_ben_ch236_19);
        parbc236_20=(CheckBox)findViewById(R.id.par_ben_ch236_20);
        parbc236_21=(CheckBox)findViewById(R.id.par_ben_ch236_21);
        parbc236_22=(CheckBox)findViewById(R.id.par_ben_ch236_22);
        parbc236_23=(CheckBox)findViewById(R.id.par_ben_ch236_23);
        parbc236_24=(CheckBox)findViewById(R.id.par_ben_ch236_24);
        parbc236_25=(CheckBox)findViewById(R.id.par_ben_ch236_25);
        parbc236_26=(CheckBox)findViewById(R.id.par_ben_ch236_26);
        parbc236_27=(CheckBox)findViewById(R.id.par_ben_ch236_27);
        parbc236_28=(CheckBox)findViewById(R.id.par_ben_ch236_28);
        parbc236_29=(CheckBox)findViewById(R.id.par_ben_ch236_29);
        parbc236_30=(CheckBox)findViewById(R.id.par_ben_ch236_30);
        parbc236_31=(CheckBox)findViewById(R.id.par_ben_ch236_31);
        parbc236_32=(CheckBox)findViewById(R.id.par_ben_ch236_32);
        parbc236_33=(CheckBox)findViewById(R.id.par_ben_ch236_33);
        parbc236_34=(CheckBox)findViewById(R.id.par_ben_ch236_34);
        parbc236_35=(CheckBox)findViewById(R.id.par_ben_ch236_35);
        parbc236_36=(CheckBox)findViewById(R.id.par_ben_ch236_36);
        parbc236_37=(CheckBox)findViewById(R.id.par_ben_ch236_37);
        parbc236_38=(CheckBox)findViewById(R.id.par_ben_ch236_38);
        parbc236_39=(CheckBox)findViewById(R.id.par_ben_ch236_39);
        parbc236_40=(CheckBox)findViewById(R.id.par_ben_ch236_40);
        parbc236_41=(CheckBox)findViewById(R.id.par_ben_ch236_41);
        parbc236_42=(CheckBox)findViewById(R.id.par_ben_ch236_42);
        parbc236_43=(CheckBox)findViewById(R.id.par_ben_ch236_43);
        parbc236_44=(CheckBox)findViewById(R.id.par_ben_ch236_44);
        parbc236_45=(CheckBox)findViewById(R.id.par_ben_ch236_45);
        parbc236_46=(CheckBox)findViewById(R.id.par_ben_ch236_46);
        parbc236_47=(CheckBox)findViewById(R.id.par_ben_ch236_47);
        parbc236_48=(CheckBox)findViewById(R.id.par_ben_ch236_48);
        parbc236_49=(CheckBox)findViewById(R.id.par_ben_ch236_49);
        parbc236_50=(CheckBox)findViewById(R.id.par_ben_ch236_50);
        parbc236_51=(CheckBox)findViewById(R.id.par_ben_ch236_51);
        parbc236_52=(CheckBox)findViewById(R.id.par_ben_ch236_52);
        parbc236_53=(CheckBox)findViewById(R.id.par_ben_ch236_53);
        parbc236_54=(CheckBox)findViewById(R.id.par_ben_ch236_54);
        parbc236_55=(CheckBox)findViewById(R.id.par_ben_ch236_55);
        parbc236_56=(CheckBox)findViewById(R.id.par_ben_ch236_56);
        parbc236_57=(CheckBox)findViewById(R.id.par_ben_ch236_57);
        //Fin checkboxes

        parbr45=(RadioButton)findViewById(R.id.par_ben_ra45);
        parbr46=(RadioButton)findViewById(R.id.par_ben_ra46);
        parbr47=(RadioButton)findViewById(R.id.par_ben_ra47);
        parbr48=(RadioButton)findViewById(R.id.par_ben_ra48);
        parbr49=(RadioButton)findViewById(R.id.par_ben_ra49);
        parbr50=(RadioButton)findViewById(R.id.par_ben_ra50);
        parbr51=(RadioButton)findViewById(R.id.par_ben_ra51);
        parbr52=(RadioButton)findViewById(R.id.par_ben_ra52);
        parbr53=(RadioButton)findViewById(R.id.par_ben_ra53);
        parbr54=(RadioButton)findViewById(R.id.par_ben_ra54);

        parbc237=(CheckBox)findViewById(R.id.par_ben_ch237);
        parbc238=(CheckBox)findViewById(R.id.par_ben_ch238);
        parbc239=(CheckBox)findViewById(R.id.par_ben_ch239);
        parbc240=(CheckBox)findViewById(R.id.par_ben_ch240);
        parbc241=(CheckBox)findViewById(R.id.par_ben_ch241);

        parbt5=(EditText)findViewById(R.id.par_ben_txt5);

        parbc242=(CheckBox)findViewById(R.id.par_ben_ch242);
        parbc243=(CheckBox)findViewById(R.id.par_ben_ch243);
        parbc244=(CheckBox)findViewById(R.id.par_ben_ch244);
        parbc245=(CheckBox)findViewById(R.id.par_ben_ch245);
        parbc246=(CheckBox)findViewById(R.id.par_ben_ch246);

        parbt6=(EditText)findViewById(R.id.par_ben_txt6);

        parbt23=(EditText)findViewById(R.id.et23explique);
        parbr198=(RadioButton)findViewById(R.id.par_ben_ra198);
        parbr199=(RadioButton)findViewById(R.id.par_ben_ra199);
        parbt27=(EditText)findViewById(R.id.et27);

        //BOTON SIGUIENTE

        btnSiguiente = findViewById(R.id.par_ben_sig);

    }






    //Metodo para extraer la fecha actual
    public void muestrafecha(){
        Calendar fecha = Calendar.getInstance();
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        mes = fecha.get(Calendar.MONTH);
        anio = fecha.get(Calendar.YEAR);
        textFecha.setText(""+dia+"/"+(mes+1)+"/"+anio);
    }

    public void Eventos(){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio5);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(parbr10.isChecked()==true){
                    cinco.setVisibility(View.VISIBLE);
                }else{
                    cinco.setVisibility(View.GONE);
                }
            }
        });

        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radio7);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(parbr16.isChecked()==true){
                    siete.setVisibility(View.VISIBLE);
                }else{
                    siete.setVisibility(View.GONE);
                }
            }
        });

        RadioGroup radioGroup4 = (RadioGroup) findViewById(R.id.radio13);
        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(parbr27.isChecked()==true){
                    trece.setVisibility(View.VISIBLE);
                }else{
                    trece.setVisibility(View.GONE);
                }
            }
        });

        RadioGroup radioGroup5 = (RadioGroup) findViewById(R.id.radio17);
        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(parbr39.isChecked()==true){
                    diesiciete.setVisibility(View.VISIBLE);
                }else{
                    diesiciete.setVisibility(View.GONE);
                }
            }
        });

        RadioGroup radioGroup6 = (RadioGroup) findViewById(R.id.radio23);
        radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(parbr54.isChecked()==true){
                    parbt23.setVisibility(View.VISIBLE);
                }else{
                    parbt23.setVisibility(View.GONE);
                }
            }
        });

        parbc241.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                @Override
                                                public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                                    if(parbc241.isChecked()==true){
                                                        parbt5.setVisibility(View.VISIBLE);
                                                    }else{
                                                        parbt5.setVisibility(View.GONE);
                                                        parbt5.setText("");
                                                    }
                                                }
                                            }
        );

        parbc246.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                @Override
                                                public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                                    if(parbc246.isChecked()==true){
                                                        parbt6.setVisibility(View.VISIBLE);
                                                    }else{
                                                        parbt6.setVisibility(View.GONE);
                                                        parbt6.setText("");
                                                    }
                                                }
                                            }
        );

        RadioGroup radioGroup7 = (RadioGroup) findViewById(R.id.radio19);
        radioGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(parbr44.isChecked()==true){
                    combo19.setVisibility(View.GONE);
                }else{
                    combo19.setVisibility(View.VISIBLE);
                }
            }
        });



    }

    public void itemClicked(View v) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()){
            bandera = bandera + 1;
        }
        else{
            bandera = bandera - 1;
        }

        if(bandera >= 3){
            if(parbc1.isChecked()){parbc1.setEnabled(true);}else{parbc1.setEnabled(false);}
            if(parbc2.isChecked()){parbc2.setEnabled(true);}else{parbc2.setEnabled(false);}
            if(parbc3.isChecked()){parbc3.setEnabled(true);}else{parbc3.setEnabled(false);}
            if(parbc4.isChecked()){parbc4.setEnabled(true);}else{parbc4.setEnabled(false);}
            if(parbc5.isChecked()){parbc5.setEnabled(true);}else{parbc5.setEnabled(false);}
            if(parbc6.isChecked()){parbc6.setEnabled(true);}else{parbc6.setEnabled(false);}
            if(parbc7.isChecked()){parbc7.setEnabled(true);}else{parbc7.setEnabled(false);}
            if(parbc8.isChecked()){parbc8.setEnabled(true);}else{parbc8.setEnabled(false);}
            if(parbc9.isChecked()){parbc9.setEnabled(true);}else{parbc9.setEnabled(false);}
            if(parbc10.isChecked()){parbc10.setEnabled(true);}else{parbc10.setEnabled(false);}
            if(parbc11.isChecked()){parbc11.setEnabled(true);}else{parbc11.setEnabled(false);}
            if(parbc12.isChecked()){parbc12.setEnabled(true);}else{parbc12.setEnabled(false);}
            if(parbc13.isChecked()){parbc13.setEnabled(true);}else{parbc13.setEnabled(false);}
            if(parbc14.isChecked()){parbc14.setEnabled(true);}else{parbc14.setEnabled(false);}
            if(parbc15.isChecked()){parbc15.setEnabled(true);}else{parbc15.setEnabled(false);}
            if(parbc16.isChecked()){parbc16.setEnabled(true);}else{parbc16.setEnabled(false);}
            if(parbc17.isChecked()){parbc17.setEnabled(true);}else{parbc17.setEnabled(false);}
            if(parbc18.isChecked()){parbc18.setEnabled(true);}else{parbc18.setEnabled(false);}
            if(parbc19.isChecked()){parbc19.setEnabled(true);}else{parbc19.setEnabled(false);}
            if(parbc20.isChecked()){parbc20.setEnabled(true);}else{parbc20.setEnabled(false);}
            if(parbc21.isChecked()){parbc21.setEnabled(true);}else{parbc21.setEnabled(false);}
            if(parbc22.isChecked()){parbc22.setEnabled(true);}else{parbc22.setEnabled(false);}
            if(parbc23.isChecked()){parbc23.setEnabled(true);}else{parbc23.setEnabled(false);}
            if(parbc24.isChecked()){parbc24.setEnabled(true);}else{parbc24.setEnabled(false);}
            if(parbc25.isChecked()){parbc25.setEnabled(true);}else{parbc25.setEnabled(false);}
            if(parbc26.isChecked()){parbc26.setEnabled(true);}else{parbc26.setEnabled(false);}
            if(parbc27.isChecked()){parbc27.setEnabled(true);}else{parbc27.setEnabled(false);}
            if(parbc28.isChecked()){parbc28.setEnabled(true);}else{parbc28.setEnabled(false);}
            if(parbc29.isChecked()){parbc29.setEnabled(true);}else{parbc29.setEnabled(false);}
            if(parbc30.isChecked()){parbc30.setEnabled(true);}else{parbc30.setEnabled(false);}
            if(parbc31.isChecked()){parbc31.setEnabled(true);}else{parbc31.setEnabled(false);}
            if(parbc32.isChecked()){parbc32.setEnabled(true);}else{parbc32.setEnabled(false);}
            if(parbc33.isChecked()){parbc33.setEnabled(true);}else{parbc33.setEnabled(false);}
            if(parbc34.isChecked()){parbc34.setEnabled(true);}else{parbc34.setEnabled(false);}
            if(parbc35.isChecked()){parbc35.setEnabled(true);}else{parbc35.setEnabled(false);}
            if(parbc36.isChecked()){parbc36.setEnabled(true);}else{parbc36.setEnabled(false);}
            if(parbc37.isChecked()){parbc37.setEnabled(true);}else{parbc37.setEnabled(false);}
            if(parbc38.isChecked()){parbc38.setEnabled(true);}else{parbc38.setEnabled(false);}
            if(parbc39.isChecked()){parbc39.setEnabled(true);}else{parbc39.setEnabled(false);}
            if(parbc40.isChecked()){parbc40.setEnabled(true);}else{parbc40.setEnabled(false);}
            if(parbc41.isChecked()){parbc41.setEnabled(true);}else{parbc41.setEnabled(false);}
            if(parbc42.isChecked()){parbc42.setEnabled(true);}else{parbc42.setEnabled(false);}
            if(parbc43.isChecked()){parbc43.setEnabled(true);}else{parbc43.setEnabled(false);}
            if(parbc44.isChecked()){parbc44.setEnabled(true);}else{parbc44.setEnabled(false);}
            if(parbc45.isChecked()){parbc45.setEnabled(true);}else{parbc45.setEnabled(false);}
            if(parbc46.isChecked()){parbc46.setEnabled(true);}else{parbc46.setEnabled(false);}
            if(parbc47.isChecked()){parbc47.setEnabled(true);}else{parbc47.setEnabled(false);}
            if(parbc47_1.isChecked()){parbc47_1.setEnabled(true);}else{parbc47_1.setEnabled(false);}
            if(parbc47_2.isChecked()){parbc47_2.setEnabled(true);}else{parbc47_2.setEnabled(false);}
            if(parbc47_3.isChecked()){parbc47_3.setEnabled(true);}else{parbc47_3.setEnabled(false);}
            if(parbc47_4.isChecked()){parbc47_4.setEnabled(true);}else{parbc47_4.setEnabled(false);}
            if(parbc47_5.isChecked()){parbc47_5.setEnabled(true);}else{parbc47_5.setEnabled(false);}
            if(parbc47_6.isChecked()){parbc47_6.setEnabled(true);}else{parbc47_6.setEnabled(false);}
            if(parbc47_7.isChecked()){parbc47_7.setEnabled(true);}else{parbc47_7.setEnabled(false);}
            if(parbc47_8.isChecked()){parbc47_8.setEnabled(true);}else{parbc47_8.setEnabled(false);}
            if(parbc47_9.isChecked()){parbc47_9.setEnabled(true);}else{parbc47_9.setEnabled(false);}
            if(parbc47_10.isChecked()){parbc47_10.setEnabled(true);}else{parbc47_10.setEnabled(false);}
            if(parbc47_11.isChecked()){parbc47_11.setEnabled(true);}else{parbc47_11.setEnabled(false);}
            if(parbc47_12.isChecked()){parbc47_12.setEnabled(true);}else{parbc47_12.setEnabled(false);}
            if(parbc47_13.isChecked()){parbc47_13.setEnabled(true);}else{parbc47_13.setEnabled(false);}
            if(parbc47_14.isChecked()){parbc47_14.setEnabled(true);}else{parbc47_14.setEnabled(false);}
            if(parbc47_15.isChecked()){parbc47_15.setEnabled(true);}else{parbc47_15.setEnabled(false);}
            if(parbc47_16.isChecked()){parbc47_16.setEnabled(true);}else{parbc47_16.setEnabled(false);}
            if(parbc47_17.isChecked()){parbc47_17.setEnabled(true);}else{parbc47_17.setEnabled(false);}
            if(parbc47_18.isChecked()){parbc47_18.setEnabled(true);}else{parbc47_18.setEnabled(false);}
            if(parbc47_19.isChecked()){parbc47_19.setEnabled(true);}else{parbc47_19.setEnabled(false);}
            if(parbc47_20.isChecked()){parbc47_20.setEnabled(true);}else{parbc47_20.setEnabled(false);}
            if(parbc47_21.isChecked()){parbc47_21.setEnabled(true);}else{parbc47_21.setEnabled(false);}
            if(parbc47_22.isChecked()){parbc47_22.setEnabled(true);}else{parbc47_22.setEnabled(false);}
            if(parbc47_23.isChecked()){parbc47_23.setEnabled(true);}else{parbc47_23.setEnabled(false);}
            if(parbc47_24.isChecked()){parbc47_24.setEnabled(true);}else{parbc47_24.setEnabled(false);}
            if(parbc47_25.isChecked()){parbc47_25.setEnabled(true);}else{parbc47_25.setEnabled(false);}
            if(parbc47_26.isChecked()){parbc47_26.setEnabled(true);}else{parbc47_26.setEnabled(false);}
            if(parbc47_27.isChecked()){parbc47_27.setEnabled(true);}else{parbc47_27.setEnabled(false);}
            if(parbc47_28.isChecked()){parbc47_28.setEnabled(true);}else{parbc47_28.setEnabled(false);}
            if(parbc47_29.isChecked()){parbc47_29.setEnabled(true);}else{parbc47_29.setEnabled(false);}
            if(parbc47_30.isChecked()){parbc47_30.setEnabled(true);}else{parbc47_30.setEnabled(false);}
            if(parbc47_31.isChecked()){parbc47_31.setEnabled(true);}else{parbc47_31.setEnabled(false);}
            if(parbc47_32.isChecked()){parbc47_32.setEnabled(true);}else{parbc47_32.setEnabled(false);}
            if(parbc47_33.isChecked()){parbc47_33.setEnabled(true);}else{parbc47_33.setEnabled(false);}
            if(parbc47_34.isChecked()){parbc47_34.setEnabled(true);}else{parbc47_34.setEnabled(false);}
            if(parbc47_35.isChecked()){parbc47_35.setEnabled(true);}else{parbc47_35.setEnabled(false);}
            if(parbc47_36.isChecked()){parbc47_36.setEnabled(true);}else{parbc47_36.setEnabled(false);}
            if(parbc47_37.isChecked()){parbc47_37.setEnabled(true);}else{parbc47_37.setEnabled(false);}
            if(parbc47_38.isChecked()){parbc47_38.setEnabled(true);}else{parbc47_38.setEnabled(false);}
            if(parbc47_39.isChecked()){parbc47_39.setEnabled(true);}else{parbc47_39.setEnabled(false);}
            if(parbc47_40.isChecked()){parbc47_40.setEnabled(true);}else{parbc47_40.setEnabled(false);}
            if(parbc47_41.isChecked()){parbc47_41.setEnabled(true);}else{parbc47_41.setEnabled(false);}
            if(parbc47_42.isChecked()){parbc47_42.setEnabled(true);}else{parbc47_42.setEnabled(false);}
            if(parbc47_43.isChecked()){parbc47_43.setEnabled(true);}else{parbc47_43.setEnabled(false);}
            if(parbc47_44.isChecked()){parbc47_44.setEnabled(true);}else{parbc47_44.setEnabled(false);}
            if(parbc47_45.isChecked()){parbc47_45.setEnabled(true);}else{parbc47_45.setEnabled(false);}
            if(parbc47_46.isChecked()){parbc47_46.setEnabled(true);}else{parbc47_46.setEnabled(false);}
            if(parbc47_47.isChecked()){parbc47_47.setEnabled(true);}else{parbc47_47.setEnabled(false);}
            if(parbc47_48.isChecked()){parbc47_48.setEnabled(true);}else{parbc47_48.setEnabled(false);}
            if(parbc47_49.isChecked()){parbc47_49.setEnabled(true);}else{parbc47_49.setEnabled(false);}
            if(parbc47_50.isChecked()){parbc47_50.setEnabled(true);}else{parbc47_50.setEnabled(false);}
            if(parbc47_51.isChecked()){parbc47_51.setEnabled(true);}else{parbc47_51.setEnabled(false);}
            if(parbc47_52.isChecked()){parbc47_52.setEnabled(true);}else{parbc47_52.setEnabled(false);}
            if(parbc47_53.isChecked()){parbc47_53.setEnabled(true);}else{parbc47_53.setEnabled(false);}
            if(parbc47_54.isChecked()){parbc47_54.setEnabled(true);}else{parbc47_54.setEnabled(false);}
            if(parbc47_55.isChecked()){parbc47_55.setEnabled(true);}else{parbc47_55.setEnabled(false);}
            if(parbc47_56.isChecked()){parbc47_56.setEnabled(true);}else{parbc47_56.setEnabled(false);}
            if(parbc47_57.isChecked()){parbc47_57.setEnabled(true);}else{parbc47_57.setEnabled(false);}
        }
        else{
            parbc1.setEnabled(true);
            parbc2.setEnabled(true);
            parbc3.setEnabled(true);
            parbc4.setEnabled(true);
            parbc5.setEnabled(true);
            parbc6.setEnabled(true);
            parbc7.setEnabled(true);
            parbc8.setEnabled(true);
            parbc9.setEnabled(true);
            parbc10.setEnabled(true);
            parbc11.setEnabled(true);
            parbc12.setEnabled(true);
            parbc13.setEnabled(true);
            parbc14.setEnabled(true);
            parbc15.setEnabled(true);
            parbc16.setEnabled(true);
            parbc17.setEnabled(true);
            parbc18.setEnabled(true);
            parbc19.setEnabled(true);
            parbc20.setEnabled(true);
            parbc21.setEnabled(true);
            parbc22.setEnabled(true);
            parbc23.setEnabled(true);
            parbc24.setEnabled(true);
            parbc25.setEnabled(true);
            parbc26.setEnabled(true);
            parbc27.setEnabled(true);
            parbc28.setEnabled(true);
            parbc29.setEnabled(true);
            parbc30.setEnabled(true);
            parbc31.setEnabled(true);
            parbc32.setEnabled(true);
            parbc33.setEnabled(true);
            parbc34.setEnabled(true);
            parbc35.setEnabled(true);
            parbc36.setEnabled(true);
            parbc37.setEnabled(true);
            parbc38.setEnabled(true);
            parbc39.setEnabled(true);
            parbc40.setEnabled(true);
            parbc41.setEnabled(true);
            parbc42.setEnabled(true);
            parbc43.setEnabled(true);
            parbc44.setEnabled(true);
            parbc45.setEnabled(true);
            parbc46.setEnabled(true);
            parbc47.setEnabled(true);
            parbc47_1.setEnabled(true);
            parbc47_2.setEnabled(true);
            parbc47_3.setEnabled(true);
            parbc47_4.setEnabled(true);
            parbc47_5.setEnabled(true);
            parbc47_6.setEnabled(true);
            parbc47_7.setEnabled(true);
            parbc47_8.setEnabled(true);
            parbc47_9.setEnabled(true);
            parbc47_10.setEnabled(true);
            parbc47_11.setEnabled(true);
            parbc47_12.setEnabled(true);
            parbc47_13.setEnabled(true);
            parbc47_14.setEnabled(true);
            parbc47_15.setEnabled(true);
            parbc47_16.setEnabled(true);
            parbc47_17.setEnabled(true);
            parbc47_18.setEnabled(true);
            parbc47_19.setEnabled(true);
            parbc47_20.setEnabled(true);
            parbc47_21.setEnabled(true);
            parbc47_22.setEnabled(true);
            parbc47_23.setEnabled(true);
            parbc47_24.setEnabled(true);
            parbc47_25.setEnabled(true);
            parbc47_26.setEnabled(true);
            parbc47_27.setEnabled(true);
            parbc47_28.setEnabled(true);
            parbc47_29.setEnabled(true);
            parbc47_30.setEnabled(true);
            parbc47_31.setEnabled(true);
            parbc47_32.setEnabled(true);
            parbc47_33.setEnabled(true);
            parbc47_34.setEnabled(true);
            parbc47_35.setEnabled(true);
            parbc47_36.setEnabled(true);
            parbc47_37.setEnabled(true);
            parbc47_38.setEnabled(true);
            parbc47_39.setEnabled(true);
            parbc47_40.setEnabled(true);
            parbc47_41.setEnabled(true);
            parbc47_42.setEnabled(true);
            parbc47_43.setEnabled(true);
            parbc47_44.setEnabled(true);
            parbc47_45.setEnabled(true);
            parbc47_46.setEnabled(true);
            parbc47_47.setEnabled(true);
            parbc47_48.setEnabled(true);
            parbc47_49.setEnabled(true);
            parbc47_50.setEnabled(true);
            parbc47_51.setEnabled(true);
            parbc47_52.setEnabled(true);
            parbc47_53.setEnabled(true);
            parbc47_54.setEnabled(true);
            parbc47_55.setEnabled(true);
            parbc47_56.setEnabled(true);
            parbc47_57.setEnabled(true);
        }


    }

    public void itemClicked2(View v) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()){
            bandera2 = bandera2 + 1;
        }
        else{
            bandera2 = bandera2 - 1;
        }

        if(bandera2 >= 3){
            if(parbc53.isChecked()){parbc53.setEnabled(true);}else{parbc53.setEnabled(false);}
            if(parbc54.isChecked()){parbc54.setEnabled(true);}else{parbc54.setEnabled(false);}
            if(parbc55.isChecked()){parbc55.setEnabled(true);}else{parbc55.setEnabled(false);}
            if(parbc56.isChecked()){parbc56.setEnabled(true);}else{parbc56.setEnabled(false);}
            if(parbc57.isChecked()){parbc57.setEnabled(true);}else{parbc57.setEnabled(false);}
            if(parbc58.isChecked()){parbc58.setEnabled(true);}else{parbc58.setEnabled(false);}
            if(parbc59.isChecked()){parbc59.setEnabled(true);}else{parbc59.setEnabled(false);}
            if(parbc60.isChecked()){parbc60.setEnabled(true);}else{parbc60.setEnabled(false);}
            if(parbc61.isChecked()){parbc61.setEnabled(true);}else{parbc61.setEnabled(false);}
            if(parbc62.isChecked()){parbc62.setEnabled(true);}else{parbc62.setEnabled(false);}
            if(parbc63.isChecked()){parbc63.setEnabled(true);}else{parbc63.setEnabled(false);}
            if(parbc64.isChecked()){parbc64.setEnabled(true);}else{parbc64.setEnabled(false);}
            if(parbc65.isChecked()){parbc65.setEnabled(true);}else{parbc65.setEnabled(false);}
            if(parbc66.isChecked()){parbc66.setEnabled(true);}else{parbc66.setEnabled(false);}
            if(parbc67.isChecked()){parbc67.setEnabled(true);}else{parbc67.setEnabled(false);}
            if(parbc68.isChecked()){parbc68.setEnabled(true);}else{parbc68.setEnabled(false);}
            if(parbc69.isChecked()){parbc69.setEnabled(true);}else{parbc69.setEnabled(false);}
            if(parbc70.isChecked()){parbc70.setEnabled(true);}else{parbc70.setEnabled(false);}
            if(parbc71.isChecked()){parbc71.setEnabled(true);}else{parbc71.setEnabled(false);}
            if(parbc72.isChecked()){parbc72.setEnabled(true);}else{parbc72.setEnabled(false);}
            if(parbc73.isChecked()){parbc73.setEnabled(true);}else{parbc73.setEnabled(false);}
            if(parbc74.isChecked()){parbc74.setEnabled(true);}else{parbc74.setEnabled(false);}
            if(parbc75.isChecked()){parbc75.setEnabled(true);}else{parbc75.setEnabled(false);}
            if(parbc76.isChecked()){parbc76.setEnabled(true);}else{parbc76.setEnabled(false);}
            if(parbc77.isChecked()){parbc77.setEnabled(true);}else{parbc77.setEnabled(false);}
            if(parbc78.isChecked()){parbc78.setEnabled(true);}else{parbc78.setEnabled(false);}
            if(parbc79.isChecked()){parbc79.setEnabled(true);}else{parbc79.setEnabled(false);}
            if(parbc80.isChecked()){parbc80.setEnabled(true);}else{parbc80.setEnabled(false);}
            if(parbc81.isChecked()){parbc81.setEnabled(true);}else{parbc81.setEnabled(false);}
            if(parbc82.isChecked()){parbc82.setEnabled(true);}else{parbc82.setEnabled(false);}
            if(parbc83.isChecked()){parbc83.setEnabled(true);}else{parbc83.setEnabled(false);}
            if(parbc84.isChecked()){parbc84.setEnabled(true);}else{parbc84.setEnabled(false);}
            if(parbc85.isChecked()){parbc85.setEnabled(true);}else{parbc85.setEnabled(false);}
            if(parbc86.isChecked()){parbc86.setEnabled(true);}else{parbc86.setEnabled(false);}
            if(parbc87.isChecked()){parbc87.setEnabled(true);}else{parbc87.setEnabled(false);}
            if(parbc88.isChecked()){parbc88.setEnabled(true);}else{parbc88.setEnabled(false);}
            if(parbc89.isChecked()){parbc89.setEnabled(true);}else{parbc89.setEnabled(false);}
            if(parbc90.isChecked()){parbc90.setEnabled(true);}else{parbc90.setEnabled(false);}
            if(parbc91.isChecked()){parbc91.setEnabled(true);}else{parbc91.setEnabled(false);}
            if(parbc92.isChecked()){parbc92.setEnabled(true);}else{parbc92.setEnabled(false);}
            if(parbc93.isChecked()){parbc93.setEnabled(true);}else{parbc93.setEnabled(false);}
            if(parbc94.isChecked()){parbc94.setEnabled(true);}else{parbc94.setEnabled(false);}
            if(parbc95.isChecked()){parbc95.setEnabled(true);}else{parbc95.setEnabled(false);}
            if(parbc96.isChecked()){parbc96.setEnabled(true);}else{parbc96.setEnabled(false);}
            if(parbc97.isChecked()){parbc97.setEnabled(true);}else{parbc97.setEnabled(false);}
            if(parbc98.isChecked()){parbc98.setEnabled(true);}else{parbc98.setEnabled(false);}
            if(parbc99.isChecked()){parbc99.setEnabled(true);}else{parbc99.setEnabled(false);}
            if(parbc9_1.isChecked()){parbc9_1.setEnabled(true);}else{parbc9_1.setEnabled(false);}
            if(parbc9_2.isChecked()){parbc9_2.setEnabled(true);}else{parbc9_2.setEnabled(false);}
            if(parbc9_3.isChecked()){parbc9_3.setEnabled(true);}else{parbc9_3.setEnabled(false);}
            if(parbc9_4.isChecked()){parbc9_4.setEnabled(true);}else{parbc9_4.setEnabled(false);}
            if(parbc9_5.isChecked()){parbc9_5.setEnabled(true);}else{parbc9_5.setEnabled(false);}
            if(parbc9_6.isChecked()){parbc9_6.setEnabled(true);}else{parbc9_6.setEnabled(false);}
            if(parbc9_7.isChecked()){parbc9_7.setEnabled(true);}else{parbc9_7.setEnabled(false);}
            if(parbc9_8.isChecked()){parbc9_8.setEnabled(true);}else{parbc9_8.setEnabled(false);}
            if(parbc9_9.isChecked()){parbc9_9.setEnabled(true);}else{parbc9_9.setEnabled(false);}
            if(parbc9_10.isChecked()){parbc9_10.setEnabled(true);}else{parbc9_10.setEnabled(false);}
            if(parbc9_11.isChecked()){parbc9_11.setEnabled(true);}else{parbc9_11.setEnabled(false);}
            if(parbc9_12.isChecked()){parbc9_12.setEnabled(true);}else{parbc9_12.setEnabled(false);}
            if(parbc9_13.isChecked()){parbc9_13.setEnabled(true);}else{parbc9_13.setEnabled(false);}
            if(parbc9_14.isChecked()){parbc9_14.setEnabled(true);}else{parbc9_14.setEnabled(false);}
            if(parbc9_15.isChecked()){parbc9_15.setEnabled(true);}else{parbc9_15.setEnabled(false);}
            if(parbc9_16.isChecked()){parbc9_16.setEnabled(true);}else{parbc9_16.setEnabled(false);}
            if(parbc9_17.isChecked()){parbc9_17.setEnabled(true);}else{parbc9_17.setEnabled(false);}
            if(parbc9_18.isChecked()){parbc9_18.setEnabled(true);}else{parbc9_18.setEnabled(false);}
            if(parbc9_19.isChecked()){parbc9_19.setEnabled(true);}else{parbc9_19.setEnabled(false);}
            if(parbc9_20.isChecked()){parbc9_20.setEnabled(true);}else{parbc9_20.setEnabled(false);}
            if(parbc9_21.isChecked()){parbc9_21.setEnabled(true);}else{parbc9_21.setEnabled(false);}
            if(parbc9_22.isChecked()){parbc9_22.setEnabled(true);}else{parbc9_22.setEnabled(false);}
            if(parbc9_23.isChecked()){parbc9_23.setEnabled(true);}else{parbc9_23.setEnabled(false);}
            if(parbc9_24.isChecked()){parbc9_24.setEnabled(true);}else{parbc9_24.setEnabled(false);}
            if(parbc9_25.isChecked()){parbc9_25.setEnabled(true);}else{parbc9_25.setEnabled(false);}
            if(parbc9_26.isChecked()){parbc9_26.setEnabled(true);}else{parbc9_26.setEnabled(false);}
            if(parbc9_27.isChecked()){parbc9_27.setEnabled(true);}else{parbc9_27.setEnabled(false);}
            if(parbc9_28.isChecked()){parbc9_28.setEnabled(true);}else{parbc9_28.setEnabled(false);}
            if(parbc9_29.isChecked()){parbc9_29.setEnabled(true);}else{parbc9_29.setEnabled(false);}
            if(parbc9_30.isChecked()){parbc9_30.setEnabled(true);}else{parbc9_30.setEnabled(false);}
            if(parbc9_31.isChecked()){parbc9_31.setEnabled(true);}else{parbc9_31.setEnabled(false);}
            if(parbc9_32.isChecked()){parbc9_32.setEnabled(true);}else{parbc9_32.setEnabled(false);}
            if(parbc9_33.isChecked()){parbc9_33.setEnabled(true);}else{parbc9_33.setEnabled(false);}
            if(parbc9_34.isChecked()){parbc9_34.setEnabled(true);}else{parbc9_34.setEnabled(false);}
            if(parbc9_35.isChecked()){parbc9_35.setEnabled(true);}else{parbc9_35.setEnabled(false);}
            if(parbc9_36.isChecked()){parbc9_36.setEnabled(true);}else{parbc9_36.setEnabled(false);}
            if(parbc9_37.isChecked()){parbc9_37.setEnabled(true);}else{parbc9_37.setEnabled(false);}
            if(parbc9_38.isChecked()){parbc9_38.setEnabled(true);}else{parbc9_38.setEnabled(false);}
            if(parbc9_39.isChecked()){parbc9_39.setEnabled(true);}else{parbc9_39.setEnabled(false);}
            if(parbc9_40.isChecked()){parbc9_40.setEnabled(true);}else{parbc9_40.setEnabled(false);}
            if(parbc9_41.isChecked()){parbc9_41.setEnabled(true);}else{parbc9_41.setEnabled(false);}
            if(parbc9_42.isChecked()){parbc9_42.setEnabled(true);}else{parbc9_42.setEnabled(false);}
            if(parbc9_43.isChecked()){parbc9_43.setEnabled(true);}else{parbc9_43.setEnabled(false);}
            if(parbc9_44.isChecked()){parbc9_44.setEnabled(true);}else{parbc9_44.setEnabled(false);}
            if(parbc9_45.isChecked()){parbc9_45.setEnabled(true);}else{parbc9_45.setEnabled(false);}
            if(parbc9_46.isChecked()){parbc9_46.setEnabled(true);}else{parbc9_46.setEnabled(false);}
            if(parbc9_47.isChecked()){parbc9_47.setEnabled(true);}else{parbc9_47.setEnabled(false);}
            if(parbc9_48.isChecked()){parbc9_48.setEnabled(true);}else{parbc9_48.setEnabled(false);}
            if(parbc9_49.isChecked()){parbc9_49.setEnabled(true);}else{parbc9_49.setEnabled(false);}
            if(parbc9_50.isChecked()){parbc9_50.setEnabled(true);}else{parbc9_50.setEnabled(false);}
            if(parbc9_51.isChecked()){parbc9_51.setEnabled(true);}else{parbc9_51.setEnabled(false);}
            if(parbc9_52.isChecked()){parbc9_52.setEnabled(true);}else{parbc9_52.setEnabled(false);}
            if(parbc9_53.isChecked()){parbc9_53.setEnabled(true);}else{parbc9_53.setEnabled(false);}
            if(parbc9_54.isChecked()){parbc9_54.setEnabled(true);}else{parbc9_54.setEnabled(false);}
            if(parbc9_55.isChecked()){parbc9_55.setEnabled(true);}else{parbc9_55.setEnabled(false);}
            if(parbc9_56.isChecked()){parbc9_56.setEnabled(true);}else{parbc9_56.setEnabled(false);}
            if(parbc9_57.isChecked()){parbc9_57.setEnabled(true);}else{parbc9_57.setEnabled(false);}
        }
        else{
            parbc53.setEnabled(true);
            parbc54.setEnabled(true);
            parbc55.setEnabled(true);
            parbc56.setEnabled(true);
            parbc57.setEnabled(true);
            parbc58.setEnabled(true);
            parbc59.setEnabled(true);
            parbc60.setEnabled(true);
            parbc61.setEnabled(true);
            parbc62.setEnabled(true);
            parbc63.setEnabled(true);
            parbc64.setEnabled(true);
            parbc65.setEnabled(true);
            parbc66.setEnabled(true);
            parbc67.setEnabled(true);
            parbc68.setEnabled(true);
            parbc69.setEnabled(true);
            parbc70.setEnabled(true);
            parbc71.setEnabled(true);
            parbc72.setEnabled(true);
            parbc73.setEnabled(true);
            parbc74.setEnabled(true);
            parbc75.setEnabled(true);
            parbc76.setEnabled(true);
            parbc77.setEnabled(true);
            parbc78.setEnabled(true);
            parbc79.setEnabled(true);
            parbc80.setEnabled(true);
            parbc81.setEnabled(true);
            parbc82.setEnabled(true);
            parbc83.setEnabled(true);
            parbc84.setEnabled(true);
            parbc85.setEnabled(true);
            parbc86.setEnabled(true);
            parbc87.setEnabled(true);
            parbc88.setEnabled(true);
            parbc89.setEnabled(true);
            parbc90.setEnabled(true);
            parbc91.setEnabled(true);
            parbc92.setEnabled(true);
            parbc93.setEnabled(true);
            parbc94.setEnabled(true);
            parbc95.setEnabled(true);
            parbc96.setEnabled(true);
            parbc97.setEnabled(true);
            parbc98.setEnabled(true);
            parbc99.setEnabled(true);
            parbc9_1.setEnabled(true);
            parbc9_2.setEnabled(true);
            parbc9_3.setEnabled(true);
            parbc9_4.setEnabled(true);
            parbc9_5.setEnabled(true);
            parbc9_6.setEnabled(true);
            parbc9_7.setEnabled(true);
            parbc9_8.setEnabled(true);
            parbc9_9.setEnabled(true);
            parbc9_10.setEnabled(true);
            parbc9_11.setEnabled(true);
            parbc9_12.setEnabled(true);
            parbc9_13.setEnabled(true);
            parbc9_14.setEnabled(true);
            parbc9_15.setEnabled(true);
            parbc9_16.setEnabled(true);
            parbc9_17.setEnabled(true);
            parbc9_18.setEnabled(true);
            parbc9_19.setEnabled(true);
            parbc9_20.setEnabled(true);
            parbc9_21.setEnabled(true);
            parbc9_22.setEnabled(true);
            parbc9_23.setEnabled(true);
            parbc9_24.setEnabled(true);
            parbc9_25.setEnabled(true);
            parbc9_26.setEnabled(true);
            parbc9_27.setEnabled(true);
            parbc9_28.setEnabled(true);
            parbc9_29.setEnabled(true);
            parbc9_30.setEnabled(true);
            parbc9_31.setEnabled(true);
            parbc9_32.setEnabled(true);
            parbc9_33.setEnabled(true);
            parbc9_34.setEnabled(true);
            parbc9_35.setEnabled(true);
            parbc9_36.setEnabled(true);
            parbc9_37.setEnabled(true);
            parbc9_38.setEnabled(true);
            parbc9_39.setEnabled(true);
            parbc9_40.setEnabled(true);
            parbc9_41.setEnabled(true);
            parbc9_42.setEnabled(true);
            parbc9_43.setEnabled(true);
            parbc9_44.setEnabled(true);
            parbc9_45.setEnabled(true);
            parbc9_46.setEnabled(true);
            parbc9_47.setEnabled(true);
            parbc9_48.setEnabled(true);
            parbc9_49.setEnabled(true);
            parbc9_50.setEnabled(true);
            parbc9_51.setEnabled(true);
            parbc9_52.setEnabled(true);
            parbc9_53.setEnabled(true);
            parbc9_54.setEnabled(true);
            parbc9_55.setEnabled(true);
            parbc9_56.setEnabled(true);
            parbc9_57.setEnabled(true);
        }

    }

    public void itemClicked3(View v) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()){
            bandera3 = bandera3 + 1;
        }
        else{
            bandera3 = bandera3 - 1;
        }

        if(bandera3 >= 3){
            if(parbc142.isChecked()){parbc142.setEnabled(true);}else{parbc142.setEnabled(false);}
            if(parbc143.isChecked()){parbc143.setEnabled(true);}else{parbc143.setEnabled(false);}
            if(parbc144.isChecked()){parbc144.setEnabled(true);}else{parbc144.setEnabled(false);}
            if(parbc145.isChecked()){parbc145.setEnabled(true);}else{parbc145.setEnabled(false);}
            if(parbc146.isChecked()){parbc146.setEnabled(true);}else{parbc146.setEnabled(false);}
            if(parbc147.isChecked()){parbc147.setEnabled(true);}else{parbc147.setEnabled(false);}
            if(parbc148.isChecked()){parbc148.setEnabled(true);}else{parbc148.setEnabled(false);}
            if(parbc149.isChecked()){parbc149.setEnabled(true);}else{parbc149.setEnabled(false);}
            if(parbc150.isChecked()){parbc150.setEnabled(true);}else{parbc150.setEnabled(false);}
            if(parbc151.isChecked()){parbc151.setEnabled(true);}else{parbc151.setEnabled(false);}
            if(parbc152.isChecked()){parbc152.setEnabled(true);}else{parbc152.setEnabled(false);}
            if(parbc153.isChecked()){parbc153.setEnabled(true);}else{parbc153.setEnabled(false);}
            if(parbc154.isChecked()){parbc154.setEnabled(true);}else{parbc154.setEnabled(false);}
            if(parbc155.isChecked()){parbc155.setEnabled(true);}else{parbc155.setEnabled(false);}
            if(parbc156.isChecked()){parbc156.setEnabled(true);}else{parbc156.setEnabled(false);}
            if(parbc157.isChecked()){parbc157.setEnabled(true);}else{parbc157.setEnabled(false);}
            if(parbc158.isChecked()){parbc158.setEnabled(true);}else{parbc158.setEnabled(false);}
            if(parbc159.isChecked()){parbc159.setEnabled(true);}else{parbc159.setEnabled(false);}
            if(parbc160.isChecked()){parbc160.setEnabled(true);}else{parbc160.setEnabled(false);}
            if(parbc161.isChecked()){parbc161.setEnabled(true);}else{parbc161.setEnabled(false);}
            if(parbc162.isChecked()){parbc162.setEnabled(true);}else{parbc162.setEnabled(false);}
            if(parbc163.isChecked()){parbc163.setEnabled(true);}else{parbc163.setEnabled(false);}
            if(parbc164.isChecked()){parbc164.setEnabled(true);}else{parbc164.setEnabled(false);}
            if(parbc165.isChecked()){parbc165.setEnabled(true);}else{parbc165.setEnabled(false);}
            if(parbc166.isChecked()){parbc166.setEnabled(true);}else{parbc166.setEnabled(false);}
            if(parbc167.isChecked()){parbc167.setEnabled(true);}else{parbc167.setEnabled(false);}
            if(parbc168.isChecked()){parbc168.setEnabled(true);}else{parbc168.setEnabled(false);}
            if(parbc169.isChecked()){parbc169.setEnabled(true);}else{parbc169.setEnabled(false);}
        }
        else{
            parbc142.setEnabled(true);
            parbc143.setEnabled(true);
            parbc144.setEnabled(true);
            parbc145.setEnabled(true);
            parbc146.setEnabled(true);
            parbc147.setEnabled(true);
            parbc148.setEnabled(true);
            parbc149.setEnabled(true);
            parbc150.setEnabled(true);
            parbc151.setEnabled(true);
            parbc152.setEnabled(true);
            parbc153.setEnabled(true);
            parbc154.setEnabled(true);
            parbc155.setEnabled(true);
            parbc156.setEnabled(true);
            parbc157.setEnabled(true);
            parbc158.setEnabled(true);
            parbc159.setEnabled(true);
            parbc160.setEnabled(true);
            parbc161.setEnabled(true);
            parbc162.setEnabled(true);
            parbc163.setEnabled(true);
            parbc164.setEnabled(true);
            parbc165.setEnabled(true);
            parbc166.setEnabled(true);
            parbc167.setEnabled(true);
            parbc168.setEnabled(true);
            parbc169.setEnabled(true);

        }

    }

    public void itemClicked4(View v) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()){
            bandera4 = bandera4 + 1;
        }
        else{
            bandera4 = bandera4 - 1;
        }

        if(bandera4 >= 3){
            if(parbc190.isChecked()){parbc190.setEnabled(true);}else{parbc190.setEnabled(false);}
            if(parbc191.isChecked()){parbc191.setEnabled(true);}else{parbc191.setEnabled(false);}
            if(parbc192.isChecked()){parbc192.setEnabled(true);}else{parbc192.setEnabled(false);}
            if(parbc193.isChecked()){parbc193.setEnabled(true);}else{parbc193.setEnabled(false);}
            if(parbc194.isChecked()){parbc194.setEnabled(true);}else{parbc194.setEnabled(false);}
            if(parbc195.isChecked()){parbc195.setEnabled(true);}else{parbc195.setEnabled(false);}
            if(parbc196.isChecked()){parbc196.setEnabled(true);}else{parbc196.setEnabled(false);}
            if(parbc197.isChecked()){parbc197.setEnabled(true);}else{parbc197.setEnabled(false);}
            if(parbc198.isChecked()){parbc198.setEnabled(true);}else{parbc198.setEnabled(false);}
            if(parbc199.isChecked()){parbc199.setEnabled(true);}else{parbc199.setEnabled(false);}
            if(parbc200.isChecked()){parbc200.setEnabled(true);}else{parbc200.setEnabled(false);}
            if(parbc201.isChecked()){parbc201.setEnabled(true);}else{parbc201.setEnabled(false);}
            if(parbc202.isChecked()){parbc202.setEnabled(true);}else{parbc202.setEnabled(false);}
            if(parbc203.isChecked()){parbc203.setEnabled(true);}else{parbc203.setEnabled(false);}
            if(parbc204.isChecked()){parbc204.setEnabled(true);}else{parbc204.setEnabled(false);}
            if(parbc205.isChecked()){parbc205.setEnabled(true);}else{parbc205.setEnabled(false);}
            if(parbc206.isChecked()){parbc206.setEnabled(true);}else{parbc206.setEnabled(false);}
            if(parbc207.isChecked()){parbc207.setEnabled(true);}else{parbc207.setEnabled(false);}
            if(parbc208.isChecked()){parbc208.setEnabled(true);}else{parbc208.setEnabled(false);}
            if(parbc209.isChecked()){parbc209.setEnabled(true);}else{parbc209.setEnabled(false);}
            if(parbc210.isChecked()){parbc210.setEnabled(true);}else{parbc210.setEnabled(false);}
            if(parbc211.isChecked()){parbc211.setEnabled(true);}else{parbc211.setEnabled(false);}
            if(parbc212.isChecked()){parbc212.setEnabled(true);}else{parbc212.setEnabled(false);}
            if(parbc213.isChecked()){parbc213.setEnabled(true);}else{parbc213.setEnabled(false);}
            if(parbc214.isChecked()){parbc214.setEnabled(true);}else{parbc214.setEnabled(false);}
            if(parbc215.isChecked()){parbc215.setEnabled(true);}else{parbc215.setEnabled(false);}
            if(parbc216.isChecked()){parbc216.setEnabled(true);}else{parbc216.setEnabled(false);}
            if(parbc217.isChecked()){parbc217.setEnabled(true);}else{parbc217.setEnabled(false);}
            if(parbc218.isChecked()){parbc218.setEnabled(true);}else{parbc218.setEnabled(false);}
            if(parbc219.isChecked()){parbc219.setEnabled(true);}else{parbc219.setEnabled(false);}
            if(parbc220.isChecked()){parbc220.setEnabled(true);}else{parbc220.setEnabled(false);}
            if(parbc221.isChecked()){parbc221.setEnabled(true);}else{parbc221.setEnabled(false);}
            if(parbc222.isChecked()){parbc222.setEnabled(true);}else{parbc222.setEnabled(false);}
            if(parbc223.isChecked()){parbc223.setEnabled(true);}else{parbc223.setEnabled(false);}
            if(parbc224.isChecked()){parbc224.setEnabled(true);}else{parbc224.setEnabled(false);}
            if(parbc225.isChecked()){parbc225.setEnabled(true);}else{parbc225.setEnabled(false);}
            if(parbc226.isChecked()){parbc226.setEnabled(true);}else{parbc226.setEnabled(false);}
            if(parbc227.isChecked()){parbc227.setEnabled(true);}else{parbc227.setEnabled(false);}
            if(parbc228.isChecked()){parbc228.setEnabled(true);}else{parbc228.setEnabled(false);}
            if(parbc229.isChecked()){parbc229.setEnabled(true);}else{parbc229.setEnabled(false);}
            if(parbc230.isChecked()){parbc230.setEnabled(true);}else{parbc230.setEnabled(false);}
            if(parbc231.isChecked()){parbc231.setEnabled(true);}else{parbc231.setEnabled(false);}
            if(parbc232.isChecked()){parbc232.setEnabled(true);}else{parbc232.setEnabled(false);}
            if(parbc233.isChecked()){parbc233.setEnabled(true);}else{parbc233.setEnabled(false);}
            if(parbc234.isChecked()){parbc234.setEnabled(true);}else{parbc234.setEnabled(false);}
            if(parbc235.isChecked()){parbc235.setEnabled(true);}else{parbc235.setEnabled(false);}
            if(parbc236.isChecked()){parbc236.setEnabled(true);}else{parbc236.setEnabled(false);}
            if(parbc236_1.isChecked()){parbc236_1.setEnabled(true);}else{parbc236_1.setEnabled(false);}
            if(parbc236_2.isChecked()){parbc236_2.setEnabled(true);}else{parbc236_2.setEnabled(false);}
            if(parbc236_3.isChecked()){parbc236_3.setEnabled(true);}else{parbc236_3.setEnabled(false);}
            if(parbc236_4.isChecked()){parbc236_4.setEnabled(true);}else{parbc236_4.setEnabled(false);}
            if(parbc236_5.isChecked()){parbc236_5.setEnabled(true);}else{parbc236_5.setEnabled(false);}
            if(parbc236_6.isChecked()){parbc236_6.setEnabled(true);}else{parbc236_6.setEnabled(false);}
            if(parbc236_7.isChecked()){parbc236_7.setEnabled(true);}else{parbc236_7.setEnabled(false);}
            if(parbc236_8.isChecked()){parbc236_8.setEnabled(true);}else{parbc236_8.setEnabled(false);}
            if(parbc236_9.isChecked()){parbc236_9.setEnabled(true);}else{parbc236_9.setEnabled(false);}
            if(parbc236_10.isChecked()){parbc236_10.setEnabled(true);}else{parbc236_10.setEnabled(false);}
            if(parbc236_11.isChecked()){parbc236_11.setEnabled(true);}else{parbc236_11.setEnabled(false);}
            if(parbc236_12.isChecked()){parbc236_12.setEnabled(true);}else{parbc236_12.setEnabled(false);}
            if(parbc236_13.isChecked()){parbc236_13.setEnabled(true);}else{parbc236_13.setEnabled(false);}
            if(parbc236_14.isChecked()){parbc236_14.setEnabled(true);}else{parbc236_14.setEnabled(false);}
            if(parbc236_15.isChecked()){parbc236_15.setEnabled(true);}else{parbc236_15.setEnabled(false);}
            if(parbc236_16.isChecked()){parbc236_16.setEnabled(true);}else{parbc236_16.setEnabled(false);}
            if(parbc236_17.isChecked()){parbc236_17.setEnabled(true);}else{parbc236_17.setEnabled(false);}
            if(parbc236_18.isChecked()){parbc236_18.setEnabled(true);}else{parbc236_18.setEnabled(false);}
            if(parbc236_19.isChecked()){parbc236_19.setEnabled(true);}else{parbc236_19.setEnabled(false);}
            if(parbc236_20.isChecked()){parbc236_20.setEnabled(true);}else{parbc236_20.setEnabled(false);}
            if(parbc236_21.isChecked()){parbc236_21.setEnabled(true);}else{parbc236_21.setEnabled(false);}
            if(parbc236_22.isChecked()){parbc236_22.setEnabled(true);}else{parbc236_22.setEnabled(false);}
            if(parbc236_23.isChecked()){parbc236_23.setEnabled(true);}else{parbc236_23.setEnabled(false);}
            if(parbc236_24.isChecked()){parbc236_24.setEnabled(true);}else{parbc236_24.setEnabled(false);}
            if(parbc236_25.isChecked()){parbc236_25.setEnabled(true);}else{parbc236_25.setEnabled(false);}
            if(parbc236_26.isChecked()){parbc236_26.setEnabled(true);}else{parbc236_26.setEnabled(false);}
            if(parbc236_27.isChecked()){parbc236_27.setEnabled(true);}else{parbc236_27.setEnabled(false);}
            if(parbc236_28.isChecked()){parbc236_28.setEnabled(true);}else{parbc236_28.setEnabled(false);}
            if(parbc236_29.isChecked()){parbc236_29.setEnabled(true);}else{parbc236_29.setEnabled(false);}
            if(parbc236_30.isChecked()){parbc236_30.setEnabled(true);}else{parbc236_30.setEnabled(false);}
            if(parbc236_31.isChecked()){parbc236_31.setEnabled(true);}else{parbc236_31.setEnabled(false);}
            if(parbc236_32.isChecked()){parbc236_32.setEnabled(true);}else{parbc236_32.setEnabled(false);}
            if(parbc236_33.isChecked()){parbc236_33.setEnabled(true);}else{parbc236_33.setEnabled(false);}
            if(parbc236_34.isChecked()){parbc236_34.setEnabled(true);}else{parbc236_34.setEnabled(false);}
            if(parbc236_35.isChecked()){parbc236_35.setEnabled(true);}else{parbc236_35.setEnabled(false);}
            if(parbc236_36.isChecked()){parbc236_36.setEnabled(true);}else{parbc236_36.setEnabled(false);}
            if(parbc236_37.isChecked()){parbc236_37.setEnabled(true);}else{parbc236_37.setEnabled(false);}
            if(parbc236_38.isChecked()){parbc236_38.setEnabled(true);}else{parbc236_38.setEnabled(false);}
            if(parbc236_39.isChecked()){parbc236_39.setEnabled(true);}else{parbc236_39.setEnabled(false);}
            if(parbc236_40.isChecked()){parbc236_40.setEnabled(true);}else{parbc236_40.setEnabled(false);}
            if(parbc236_41.isChecked()){parbc236_41.setEnabled(true);}else{parbc236_41.setEnabled(false);}
            if(parbc236_42.isChecked()){parbc236_42.setEnabled(true);}else{parbc236_42.setEnabled(false);}
            if(parbc236_43.isChecked()){parbc236_43.setEnabled(true);}else{parbc236_43.setEnabled(false);}
            if(parbc236_44.isChecked()){parbc236_44.setEnabled(true);}else{parbc236_44.setEnabled(false);}
            if(parbc236_45.isChecked()){parbc236_45.setEnabled(true);}else{parbc236_45.setEnabled(false);}
            if(parbc236_46.isChecked()){parbc236_46.setEnabled(true);}else{parbc236_46.setEnabled(false);}
            if(parbc236_47.isChecked()){parbc236_47.setEnabled(true);}else{parbc236_47.setEnabled(false);}
            if(parbc236_48.isChecked()){parbc236_48.setEnabled(true);}else{parbc236_48.setEnabled(false);}
            if(parbc236_49.isChecked()){parbc236_49.setEnabled(true);}else{parbc236_49.setEnabled(false);}
            if(parbc236_50.isChecked()){parbc236_50.setEnabled(true);}else{parbc236_50.setEnabled(false);}
            if(parbc236_51.isChecked()){parbc236_51.setEnabled(true);}else{parbc236_51.setEnabled(false);}
            if(parbc236_52.isChecked()){parbc236_52.setEnabled(true);}else{parbc236_52.setEnabled(false);}
            if(parbc236_53.isChecked()){parbc236_53.setEnabled(true);}else{parbc236_53.setEnabled(false);}
            if(parbc236_54.isChecked()){parbc236_54.setEnabled(true);}else{parbc236_54.setEnabled(false);}
            if(parbc236_55.isChecked()){parbc236_55.setEnabled(true);}else{parbc236_55.setEnabled(false);}
            if(parbc236_56.isChecked()){parbc236_56.setEnabled(true);}else{parbc236_56.setEnabled(false);}
            if(parbc236_57.isChecked()){parbc236_57.setEnabled(true);}else{parbc236_57.setEnabled(false);}
        }
        else {
            parbc190.setEnabled(true);
            parbc191.setEnabled(true);
            parbc192.setEnabled(true);
            parbc193.setEnabled(true);
            parbc194.setEnabled(true);
            parbc195.setEnabled(true);
            parbc196.setEnabled(true);
            parbc197.setEnabled(true);
            parbc198.setEnabled(true);
            parbc199.setEnabled(true);
            parbc200.setEnabled(true);
            parbc201.setEnabled(true);
            parbc202.setEnabled(true);
            parbc203.setEnabled(true);
            parbc204.setEnabled(true);
            parbc205.setEnabled(true);
            parbc206.setEnabled(true);
            parbc207.setEnabled(true);
            parbc208.setEnabled(true);
            parbc209.setEnabled(true);
            parbc210.setEnabled(true);
            parbc211.setEnabled(true);
            parbc212.setEnabled(true);
            parbc213.setEnabled(true);
            parbc214.setEnabled(true);
            parbc215.setEnabled(true);
            parbc216.setEnabled(true);
            parbc217.setEnabled(true);
            parbc218.setEnabled(true);
            parbc219.setEnabled(true);
            parbc220.setEnabled(true);
            parbc221.setEnabled(true);
            parbc222.setEnabled(true);
            parbc223.setEnabled(true);
            parbc224.setEnabled(true);
            parbc225.setEnabled(true);
            parbc226.setEnabled(true);
            parbc227.setEnabled(true);
            parbc228.setEnabled(true);
            parbc229.setEnabled(true);
            parbc230.setEnabled(true);
            parbc231.setEnabled(true);
            parbc232.setEnabled(true);
            parbc233.setEnabled(true);
            parbc234.setEnabled(true);
            parbc235.setEnabled(true);
            parbc236.setEnabled(true);
            parbc236_1.setEnabled(true);
            parbc236_2.setEnabled(true);
            parbc236_3.setEnabled(true);
            parbc236_4.setEnabled(true);
            parbc236_5.setEnabled(true);
            parbc236_6.setEnabled(true);
            parbc236_7.setEnabled(true);
            parbc236_8.setEnabled(true);
            parbc236_9.setEnabled(true);
            parbc236_10.setEnabled(true);
            parbc236_11.setEnabled(true);
            parbc236_12.setEnabled(true);
            parbc236_13.setEnabled(true);
            parbc236_14.setEnabled(true);
            parbc236_15.setEnabled(true);
            parbc236_16.setEnabled(true);
            parbc236_17.setEnabled(true);
            parbc236_18.setEnabled(true);
            parbc236_19.setEnabled(true);
            parbc236_20.setEnabled(true);
            parbc236_21.setEnabled(true);
            parbc236_22.setEnabled(true);
            parbc236_23.setEnabled(true);
            parbc236_24.setEnabled(true);
            parbc236_25.setEnabled(true);
            parbc236_26.setEnabled(true);
            parbc236_27.setEnabled(true);
            parbc236_28.setEnabled(true);
            parbc236_29.setEnabled(true);
            parbc236_30.setEnabled(true);
            parbc236_31.setEnabled(true);
            parbc236_32.setEnabled(true);
            parbc236_33.setEnabled(true);
            parbc236_34.setEnabled(true);
            parbc236_35.setEnabled(true);
            parbc236_36.setEnabled(true);
            parbc236_37.setEnabled(true);
            parbc236_38.setEnabled(true);
            parbc236_39.setEnabled(true);
            parbc236_40.setEnabled(true);
            parbc236_41.setEnabled(true);
            parbc236_42.setEnabled(true);
            parbc236_43.setEnabled(true);
            parbc236_44.setEnabled(true);
            parbc236_45.setEnabled(true);
            parbc236_46.setEnabled(true);
            parbc236_47.setEnabled(true);
            parbc236_48.setEnabled(true);
            parbc236_49.setEnabled(true);
            parbc236_50.setEnabled(true);
            parbc236_51.setEnabled(true);
            parbc236_52.setEnabled(true);
            parbc236_53.setEnabled(true);
            parbc236_54.setEnabled(true);
            parbc236_55.setEnabled(true);
            parbc236_56.setEnabled(true);
            parbc236_57.setEnabled(true);
        }
    }

    public boolean validar(){
        boolean retorno=true;

        if(parbs3.getText().toString().isEmpty()){
            parbs3.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!parbr1.isChecked() && !parbr2.isChecked()){
            parbr1.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(parbt3.getText().toString().isEmpty()){
            parbt3.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(Integer.parseInt(parbt3.getText().toString()) <= 9){
            parbt3.setError("No puede ser menor de 10 años");
            retorno=false;
        }
        else if(!parbr3.isChecked() && !parbr4.isChecked()){
            parbr3.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(Validar_2() == 0){
            parbc1.setError("Debe seleccionar almenos una opción");
            retorno=false;
        }
        else if(!parbr5.isChecked() && !parbr6.isChecked()){
            parbr5.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!parbr7.isChecked() && !parbr8.isChecked() && !parbr9.isChecked()){
            parbr7.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!parbr10.isChecked() && !parbr11.isChecked()){
            parbr10.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(parbr10.isChecked() && Validar_5()==0){
            parbc48.setError("Debe seleccionar almenos una opción");
            retorno=false;
        }
        else if(!parbr12.isChecked() && !parbr13.isChecked() && !parbr14.isChecked()){
            parbr12.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!parbr15.isChecked() && !parbr16.isChecked()){
            parbr15.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(parbr16.isChecked() && Validar_7()==0){
            parbc53.setError("Debe seleccionar almenos una opción");
            retorno=false;
        }
        else if(Validar_8() == 0){
            parbc142.setError("Debe seleccionar almenos una opción");
            retorno=false;
        }
        else if(!parbr19.isChecked() && !parbr20.isChecked()){
            parbr19.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!parbr21.isChecked() && !parbr22.isChecked()){
            parbr21.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!parbr23.isChecked() && !parbr24.isChecked()){
            parbr23.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!parbr25.isChecked() && !parbr26.isChecked()){
            parbr25.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!parbr27.isChecked() && !parbr28.isChecked()){
            parbr27.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(parbr27.isChecked() && Validar_13()==0){
            parbc170.setError("Debe seleccionar almenos una opción");
            retorno=false;
        }
        else if(Validar_14() == 0){
            parbc179.setError("Debe seleccionar almenos una opción");
            retorno=false;
        }
        else if(!parbr29.isChecked() && !parbr30.isChecked() && !parbr31.isChecked() && !parbr32.isChecked() && !parbr33.isChecked() && !parbr34.isChecked()){
            parbr29.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!parbr35.isChecked() && !parbr36.isChecked() && !parbr37.isChecked() && !parbr38.isChecked()){
            parbr35.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!parbr39.isChecked() && !parbr40.isChecked()){
            parbr39.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(parbr39.isChecked() && Validar_17()==0){
            parbc186.setError("Debe seleccionar almenos una opción");
            retorno=false;
        }
        else if(!parbr41.isChecked() && !parbr42.isChecked()){
            parbr41.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!parbr43.isChecked() && !parbr44.isChecked()){
            parbr43.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(parbr43.isChecked() && Validar_19() == 0){
            parbc190.setError("Debe seleccionar almenos una opción");
            retorno=false;
        }
        else if(!parbr45.isChecked() && !parbr46.isChecked()){
            parbr45.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!parbr47.isChecked() && !parbr48.isChecked() && !parbr49.isChecked()){
            parbr47.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!parbr50.isChecked() && !parbr51.isChecked() && !parbr52.isChecked()){
            parbr50.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!parbr53.isChecked() && !parbr54.isChecked()){
            parbr53.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(parbr54.isChecked() && parbt23.getText().toString().isEmpty()){
            parbt23.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!parbr198.isChecked() && !parbr199.isChecked()){
            parbr198.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(Validar_25() == 0){
            parbc237.setError("Debe seleccionar almenos una opción");
            retorno=false;
        }
        else if(parbc241.isChecked() && parbt5.getText().toString().isEmpty()){
            parbt5.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(Validar_26() == 0){
            parbc242.setError("Debe seleccionar almenos una opción");
            retorno=false;
        }
        else if(parbc246.isChecked() && parbt6.getText().toString().isEmpty()){
            parbt6.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(parbt27.getText().toString().isEmpty()){
            parbt27.setError("No puede quedar vacio");
            retorno=false;
        }

        return retorno;
    }

    public int Validar_2(){
        int count=0;

        if(parbc1.isChecked()){count = count + 1;}
        if(parbc2.isChecked()){count = count + 1;}
        if(parbc3.isChecked()){count = count + 1;}
        if(parbc4.isChecked()){count = count + 1;}
        if(parbc5.isChecked()){count = count + 1;}
        if(parbc6.isChecked()){count = count + 1;}
        if(parbc7.isChecked()){count = count + 1;}
        if(parbc8.isChecked()){count = count + 1;}
        if(parbc9.isChecked()){count = count + 1;}
        if(parbc10.isChecked()){count = count + 1;}
        if(parbc11.isChecked()){count = count + 1;}
        if(parbc12.isChecked()){count = count + 1;}
        if(parbc13.isChecked()){count = count + 1;}
        if(parbc14.isChecked()){count = count + 1;}
        if(parbc15.isChecked()){count = count + 1;}
        if(parbc16.isChecked()){count = count + 1;}
        if(parbc17.isChecked()){count = count + 1;}
        if(parbc18.isChecked()){count = count + 1;}
        if(parbc19.isChecked()){count = count + 1;}
        if(parbc20.isChecked()){count = count + 1;}
        if(parbc21.isChecked()){count = count + 1;}
        if(parbc22.isChecked()){count = count + 1;}
        if(parbc23.isChecked()){count = count + 1;}
        if(parbc24.isChecked()){count = count + 1;}
        if(parbc25.isChecked()){count = count + 1;}
        if(parbc26.isChecked()){count = count + 1;}
        if(parbc27.isChecked()){count = count + 1;}
        if(parbc28.isChecked()){count = count + 1;}
        if(parbc29.isChecked()){count = count + 1;}
        if(parbc30.isChecked()){count = count + 1;}
        if(parbc31.isChecked()){count = count + 1;}
        if(parbc32.isChecked()){count = count + 1;}
        if(parbc33.isChecked()){count = count + 1;}
        if(parbc34.isChecked()){count = count + 1;}
        if(parbc35.isChecked()){count = count + 1;}
        if(parbc36.isChecked()){count = count + 1;}
        if(parbc37.isChecked()){count = count + 1;}
        if(parbc38.isChecked()){count = count + 1;}
        if(parbc39.isChecked()){count = count + 1;}
        if(parbc40.isChecked()){count = count + 1;}
        if(parbc41.isChecked()){count = count + 1;}
        if(parbc42.isChecked()){count = count + 1;}
        if(parbc43.isChecked()){count = count + 1;}
        if(parbc44.isChecked()){count = count + 1;}
        if(parbc45.isChecked()){count = count + 1;}
        if(parbc46.isChecked()){count = count + 1;}
        if(parbc47.isChecked()){count = count + 1;}
        if(parbc47_1.isChecked()){count = count + 1;}
        if(parbc47_2.isChecked()){count = count + 1;}
        if(parbc47_3.isChecked()){count = count + 1;}
        if(parbc47_4.isChecked()){count = count + 1;}
        if(parbc47_5.isChecked()){count = count + 1;}
        if(parbc47_6.isChecked()){count = count + 1;}
        if(parbc47_7.isChecked()){count = count + 1;}
        if(parbc47_8.isChecked()){count = count + 1;}
        if(parbc47_9.isChecked()){count = count + 1;}
        if(parbc47_10.isChecked()){count = count + 1;}
        if(parbc47_11.isChecked()){count = count + 1;}
        if(parbc47_12.isChecked()){count = count + 1;}
        if(parbc47_13.isChecked()){count = count + 1;}
        if(parbc47_14.isChecked()){count = count + 1;}
        if(parbc47_15.isChecked()){count = count + 1;}
        if(parbc47_16.isChecked()){count = count + 1;}
        if(parbc47_17.isChecked()){count = count + 1;}
        if(parbc47_18.isChecked()){count = count + 1;}
        if(parbc47_19.isChecked()){count = count + 1;}
        if(parbc47_20.isChecked()){count = count + 1;}
        if(parbc47_21.isChecked()){count = count + 1;}
        if(parbc47_22.isChecked()){count = count + 1;}
        if(parbc47_23.isChecked()){count = count + 1;}
        if(parbc47_24.isChecked()){count = count + 1;}
        if(parbc47_25.isChecked()){count = count + 1;}
        if(parbc47_26.isChecked()){count = count + 1;}
        if(parbc47_27.isChecked()){count = count + 1;}
        if(parbc47_28.isChecked()){count = count + 1;}
        if(parbc47_29.isChecked()){count = count + 1;}
        if(parbc47_30.isChecked()){count = count + 1;}
        if(parbc47_31.isChecked()){count = count + 1;}
        if(parbc47_32.isChecked()){count = count + 1;}
        if(parbc47_33.isChecked()){count = count + 1;}
        if(parbc47_34.isChecked()){count = count + 1;}
        if(parbc47_35.isChecked()){count = count + 1;}
        if(parbc47_36.isChecked()){count = count + 1;}
        if(parbc47_37.isChecked()){count = count + 1;}
        if(parbc47_38.isChecked()){count = count + 1;}
        if(parbc47_39.isChecked()){count = count + 1;}
        if(parbc47_40.isChecked()){count = count + 1;}
        if(parbc47_41.isChecked()){count = count + 1;}
        if(parbc47_42.isChecked()){count = count + 1;}
        if(parbc47_43.isChecked()){count = count + 1;}
        if(parbc47_44.isChecked()){count = count + 1;}
        if(parbc47_45.isChecked()){count = count + 1;}
        if(parbc47_46.isChecked()){count = count + 1;}
        if(parbc47_47.isChecked()){count = count + 1;}
        if(parbc47_48.isChecked()){count = count + 1;}
        if(parbc47_49.isChecked()){count = count + 1;}
        if(parbc47_50.isChecked()){count = count + 1;}
        if(parbc47_51.isChecked()){count = count + 1;}
        if(parbc47_52.isChecked()){count = count + 1;}
        if(parbc47_53.isChecked()){count = count + 1;}
        if(parbc47_54.isChecked()){count = count + 1;}
        if(parbc47_55.isChecked()){count = count + 1;}
        if(parbc47_56.isChecked()){count = count + 1;}
        if(parbc47_57.isChecked()){count = count + 1;}


        return count;
    }

    public int Validar_5(){
        int count=0;

        if(parbc48.isChecked()){count = count + 1;}
        if(parbc49.isChecked()){count = count + 1;}
        if(parbc50.isChecked()){count = count + 1;}
        if(parbc51.isChecked()){count = count + 1;}
        if(parbc52.isChecked()){count = count + 1;}

        return count;
    }

    public int Validar_7(){
        int count=0;

        if(parbc53.isChecked()){count = count + 1;}
        if(parbc54.isChecked()){count = count + 1;}
        if(parbc55.isChecked()){count = count + 1;}
        if(parbc56.isChecked()){count = count + 1;}
        if(parbc57.isChecked()){count = count + 1;}
        if(parbc58.isChecked()){count = count + 1;}
        if(parbc59.isChecked()){count = count + 1;}
        if(parbc60.isChecked()){count = count + 1;}
        if(parbc61.isChecked()){count = count + 1;}
        if(parbc62.isChecked()){count = count + 1;}
        if(parbc63.isChecked()){count = count + 1;}
        if(parbc64.isChecked()){count = count + 1;}
        if(parbc65.isChecked()){count = count + 1;}
        if(parbc66.isChecked()){count = count + 1;}
        if(parbc67.isChecked()){count = count + 1;}
        if(parbc68.isChecked()){count = count + 1;}
        if(parbc69.isChecked()){count = count + 1;}
        if(parbc70.isChecked()){count = count + 1;}
        if(parbc71.isChecked()){count = count + 1;}
        if(parbc72.isChecked()){count = count + 1;}
        if(parbc73.isChecked()){count = count + 1;}
        if(parbc74.isChecked()){count = count + 1;}
        if(parbc75.isChecked()){count = count + 1;}
        if(parbc76.isChecked()){count = count + 1;}
        if(parbc77.isChecked()){count = count + 1;}
        if(parbc78.isChecked()){count = count + 1;}
        if(parbc79.isChecked()){count = count + 1;}
        if(parbc80.isChecked()){count = count + 1;}
        if(parbc81.isChecked()){count = count + 1;}
        if(parbc82.isChecked()){count = count + 1;}
        if(parbc83.isChecked()){count = count + 1;}
        if(parbc84.isChecked()){count = count + 1;}
        if(parbc85.isChecked()){count = count + 1;}
        if(parbc86.isChecked()){count = count + 1;}
        if(parbc87.isChecked()){count = count + 1;}
        if(parbc88.isChecked()){count = count + 1;}
        if(parbc89.isChecked()){count = count + 1;}
        if(parbc90.isChecked()){count = count + 1;}
        if(parbc91.isChecked()){count = count + 1;}
        if(parbc92.isChecked()){count = count + 1;}
        if(parbc93.isChecked()){count = count + 1;}
        if(parbc94.isChecked()){count = count + 1;}
        if(parbc95.isChecked()){count = count + 1;}
        if(parbc96.isChecked()){count = count + 1;}
        if(parbc97.isChecked()){count = count + 1;}
        if(parbc98.isChecked()){count = count + 1;}
        if(parbc99.isChecked()){count = count + 1;}
        if(parbc9_1.isChecked()){count = count + 1;}
        if(parbc9_2.isChecked()){count = count + 1;}
        if(parbc9_3.isChecked()){count = count + 1;}
        if(parbc9_4.isChecked()){count = count + 1;}
        if(parbc9_5.isChecked()){count = count + 1;}
        if(parbc9_6.isChecked()){count = count + 1;}
        if(parbc9_7.isChecked()){count = count + 1;}
        if(parbc9_8.isChecked()){count = count + 1;}
        if(parbc9_9.isChecked()){count = count + 1;}
        if(parbc9_10.isChecked()){count = count + 1;}
        if(parbc9_11.isChecked()){count = count + 1;}
        if(parbc9_12.isChecked()){count = count + 1;}
        if(parbc9_13.isChecked()){count = count + 1;}
        if(parbc9_14.isChecked()){count = count + 1;}
        if(parbc9_15.isChecked()){count = count + 1;}
        if(parbc9_16.isChecked()){count = count + 1;}
        if(parbc9_17.isChecked()){count = count + 1;}
        if(parbc9_18.isChecked()){count = count + 1;}
        if(parbc9_19.isChecked()){count = count + 1;}
        if(parbc9_20.isChecked()){count = count + 1;}
        if(parbc9_21.isChecked()){count = count + 1;}
        if(parbc9_22.isChecked()){count = count + 1;}
        if(parbc9_23.isChecked()){count = count + 1;}
        if(parbc9_24.isChecked()){count = count + 1;}
        if(parbc9_25.isChecked()){count = count + 1;}
        if(parbc9_26.isChecked()){count = count + 1;}
        if(parbc9_27.isChecked()){count = count + 1;}
        if(parbc9_28.isChecked()){count = count + 1;}
        if(parbc9_29.isChecked()){count = count + 1;}
        if(parbc9_30.isChecked()){count = count + 1;}
        if(parbc9_31.isChecked()){count = count + 1;}
        if(parbc9_32.isChecked()){count = count + 1;}
        if(parbc9_33.isChecked()){count = count + 1;}
        if(parbc9_34.isChecked()){count = count + 1;}
        if(parbc9_35.isChecked()){count = count + 1;}
        if(parbc9_36.isChecked()){count = count + 1;}
        if(parbc9_37.isChecked()){count = count + 1;}
        if(parbc9_38.isChecked()){count = count + 1;}
        if(parbc9_39.isChecked()){count = count + 1;}
        if(parbc9_40.isChecked()){count = count + 1;}
        if(parbc9_41.isChecked()){count = count + 1;}
        if(parbc9_42.isChecked()){count = count + 1;}
        if(parbc9_43.isChecked()){count = count + 1;}
        if(parbc9_44.isChecked()){count = count + 1;}
        if(parbc9_45.isChecked()){count = count + 1;}
        if(parbc9_46.isChecked()){count = count + 1;}
        if(parbc9_47.isChecked()){count = count + 1;}
        if(parbc9_48.isChecked()){count = count + 1;}
        if(parbc9_49.isChecked()){count = count + 1;}
        if(parbc9_50.isChecked()){count = count + 1;}
        if(parbc9_51.isChecked()){count = count + 1;}
        if(parbc9_52.isChecked()){count = count + 1;}
        if(parbc9_53.isChecked()){count = count + 1;}
        if(parbc9_54.isChecked()){count = count + 1;}
        if(parbc9_55.isChecked()){count = count + 1;}
        if(parbc9_56.isChecked()){count = count + 1;}
        if(parbc9_57.isChecked()){count = count + 1;}

        return count;
    }

    public int Validar_8(){
        int count=0;

        if(parbc142.isChecked()){count = count + 1;}
        if(parbc143.isChecked()){count = count + 1;}
        if(parbc144.isChecked()){count = count + 1;}
        if(parbc145.isChecked()){count = count + 1;}
        if(parbc146.isChecked()){count = count + 1;}
        if(parbc147.isChecked()){count = count + 1;}
        if(parbc148.isChecked()){count = count + 1;}
        if(parbc149.isChecked()){count = count + 1;}
        if(parbc150.isChecked()){count = count + 1;}
        if(parbc151.isChecked()){count = count + 1;}
        if(parbc152.isChecked()){count = count + 1;}
        if(parbc153.isChecked()){count = count + 1;}
        if(parbc154.isChecked()){count = count + 1;}
        if(parbc155.isChecked()){count = count + 1;}
        if(parbc156.isChecked()){count = count + 1;}
        if(parbc157.isChecked()){count = count + 1;}
        if(parbc158.isChecked()){count = count + 1;}
        if(parbc159.isChecked()){count = count + 1;}
        if(parbc160.isChecked()){count = count + 1;}
        if(parbc161.isChecked()){count = count + 1;}
        if(parbc162.isChecked()){count = count + 1;}
        if(parbc163.isChecked()){count = count + 1;}
        if(parbc164.isChecked()){count = count + 1;}
        if(parbc165.isChecked()){count = count + 1;}
        if(parbc166.isChecked()){count = count + 1;}
        if(parbc167.isChecked()){count = count + 1;}
        if(parbc168.isChecked()){count = count + 1;}
        if(parbc169.isChecked()){count = count + 1;}

        return count;
    }

    public int Validar_13(){
        int count=0;

        if(parbc170.isChecked()){count = count + 1;}
        if(parbc171.isChecked()){count = count + 1;}
        if(parbc172.isChecked()){count = count + 1;}
        if(parbc173.isChecked()){count = count + 1;}
        if(parbc174.isChecked()){count = count + 1;}
        if(parbc175.isChecked()){count = count + 1;}
        if(parbc176.isChecked()){count = count + 1;}
        if(parbc177.isChecked()){count = count + 1;}
        if(parbc178.isChecked()){count = count + 1;}

        return count;
    }

    public int Validar_14(){
        int count=0;

        if(parbc179.isChecked()){count = count + 1;}
        if(parbc180.isChecked()){count = count + 1;}
        if(parbc181.isChecked()){count = count + 1;}
        if(parbc182.isChecked()){count = count + 1;}
        if(parbc183.isChecked()){count = count + 1;}
        if(parbc184.isChecked()){count = count + 1;}
        if(parbc185.isChecked()){count = count + 1;}

        return count;
    }

    public int Validar_17(){
        int count=0;

        if(parbc186.isChecked()){count = count + 1;}
        if(parbc187.isChecked()){count = count + 1;}
        if(parbc188.isChecked()){count = count + 1;}
        if(parbc189.isChecked()){count = count + 1;}

        return count;
    }

    public int Validar_19(){
        int count=0;

        if(parbc190.isChecked()){count = count + 1;}
        if(parbc191.isChecked()){count = count + 1;}
        if(parbc192.isChecked()){count = count + 1;}
        if(parbc193.isChecked()){count = count + 1;}
        if(parbc194.isChecked()){count = count + 1;}
        if(parbc195.isChecked()){count = count + 1;}
        if(parbc196.isChecked()){count = count + 1;}
        if(parbc197.isChecked()){count = count + 1;}
        if(parbc198.isChecked()){count = count + 1;}
        if(parbc199.isChecked()){count = count + 1;}
        if(parbc200.isChecked()){count = count + 1;}
        if(parbc201.isChecked()){count = count + 1;}
        if(parbc202.isChecked()){count = count + 1;}
        if(parbc203.isChecked()){count = count + 1;}
        if(parbc204.isChecked()){count = count + 1;}
        if(parbc205.isChecked()){count = count + 1;}
        if(parbc206.isChecked()){count = count + 1;}
        if(parbc207.isChecked()){count = count + 1;}
        if(parbc208.isChecked()){count = count + 1;}
        if(parbc209.isChecked()){count = count + 1;}
        if(parbc210.isChecked()){count = count + 1;}
        if(parbc211.isChecked()){count = count + 1;}
        if(parbc212.isChecked()){count = count + 1;}
        if(parbc213.isChecked()){count = count + 1;}
        if(parbc214.isChecked()){count = count + 1;}
        if(parbc215.isChecked()){count = count + 1;}
        if(parbc216.isChecked()){count = count + 1;}
        if(parbc217.isChecked()){count = count + 1;}
        if(parbc218.isChecked()){count = count + 1;}
        if(parbc219.isChecked()){count = count + 1;}
        if(parbc220.isChecked()){count = count + 1;}
        if(parbc221.isChecked()){count = count + 1;}
        if(parbc222.isChecked()){count = count + 1;}
        if(parbc223.isChecked()){count = count + 1;}
        if(parbc224.isChecked()){count = count + 1;}
        if(parbc225.isChecked()){count = count + 1;}
        if(parbc226.isChecked()){count = count + 1;}
        if(parbc227.isChecked()){count = count + 1;}
        if(parbc228.isChecked()){count = count + 1;}
        if(parbc229.isChecked()){count = count + 1;}
        if(parbc230.isChecked()){count = count + 1;}
        if(parbc231.isChecked()){count = count + 1;}
        if(parbc232.isChecked()){count = count + 1;}
        if(parbc233.isChecked()){count = count + 1;}
        if(parbc234.isChecked()){count = count + 1;}
        if(parbc235.isChecked()){count = count + 1;}
        if(parbc236.isChecked()){count = count + 1;}
        if(parbc236_1.isChecked()){count = count + 1;}
        if(parbc236_2.isChecked()){count = count + 1;}
        if(parbc236_3.isChecked()){count = count + 1;}
        if(parbc236_4.isChecked()){count = count + 1;}
        if(parbc236_5.isChecked()){count = count + 1;}
        if(parbc236_6.isChecked()){count = count + 1;}
        if(parbc236_7.isChecked()){count = count + 1;}
        if(parbc236_8.isChecked()){count = count + 1;}
        if(parbc236_9.isChecked()){count = count + 1;}
        if(parbc236_10.isChecked()){count = count + 1;}
        if(parbc236_11.isChecked()){count = count + 1;}
        if(parbc236_12.isChecked()){count = count + 1;}
        if(parbc236_13.isChecked()){count = count + 1;}
        if(parbc236_14.isChecked()){count = count + 1;}
        if(parbc236_15.isChecked()){count = count + 1;}
        if(parbc236_16.isChecked()){count = count + 1;}
        if(parbc236_17.isChecked()){count = count + 1;}
        if(parbc236_18.isChecked()){count = count + 1;}
        if(parbc236_19.isChecked()){count = count + 1;}
        if(parbc236_20.isChecked()){count = count + 1;}
        if(parbc236_21.isChecked()){count = count + 1;}
        if(parbc236_22.isChecked()){count = count + 1;}
        if(parbc236_23.isChecked()){count = count + 1;}
        if(parbc236_24.isChecked()){count = count + 1;}
        if(parbc236_25.isChecked()){count = count + 1;}
        if(parbc236_26.isChecked()){count = count + 1;}
        if(parbc236_27.isChecked()){count = count + 1;}
        if(parbc236_28.isChecked()){count = count + 1;}
        if(parbc236_29.isChecked()){count = count + 1;}
        if(parbc236_30.isChecked()){count = count + 1;}
        if(parbc236_31.isChecked()){count = count + 1;}
        if(parbc236_32.isChecked()){count = count + 1;}
        if(parbc236_33.isChecked()){count = count + 1;}
        if(parbc236_34.isChecked()){count = count + 1;}
        if(parbc236_35.isChecked()){count = count + 1;}
        if(parbc236_36.isChecked()){count = count + 1;}
        if(parbc236_37.isChecked()){count = count + 1;}
        if(parbc236_38.isChecked()){count = count + 1;}
        if(parbc236_39.isChecked()){count = count + 1;}
        if(parbc236_40.isChecked()){count = count + 1;}
        if(parbc236_41.isChecked()){count = count + 1;}
        if(parbc236_42.isChecked()){count = count + 1;}
        if(parbc236_43.isChecked()){count = count + 1;}
        if(parbc236_44.isChecked()){count = count + 1;}
        if(parbc236_45.isChecked()){count = count + 1;}
        if(parbc236_46.isChecked()){count = count + 1;}
        if(parbc236_47.isChecked()){count = count + 1;}
        if(parbc236_48.isChecked()){count = count + 1;}
        if(parbc236_49.isChecked()){count = count + 1;}
        if(parbc236_50.isChecked()){count = count + 1;}
        if(parbc236_51.isChecked()){count = count + 1;}
        if(parbc236_52.isChecked()){count = count + 1;}
        if(parbc236_53.isChecked()){count = count + 1;}
        if(parbc236_54.isChecked()){count = count + 1;}
        if(parbc236_55.isChecked()){count = count + 1;}
        if(parbc236_56.isChecked()){count = count + 1;}
        if(parbc236_57.isChecked()){count = count + 1;}

        return count;
    }

    public int Validar_25(){
        int count=0;

        if(parbc237.isChecked()){count = count + 1;}
        if(parbc238.isChecked()){count = count + 1;}
        if(parbc239.isChecked()){count = count + 1;}
        if(parbc240.isChecked()){count = count + 1;}
        if(parbc241.isChecked()){count = count + 1;}

        return count;
    }

    public int Validar_26(){
        int count=0;
        if(parbc242.isChecked()){count = count + 1;}
        if(parbc243.isChecked()){count = count + 1;}
        if(parbc244.isChecked()){count = count + 1;}
        if(parbc245.isChecked()){count = count + 1;}
        if(parbc246.isChecked()){count = count + 1;}

        return count;
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

    public String obtenerResultado4(RadioButton rb1, RadioButton rb2, RadioButton rb3, RadioButton rb4){
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
        return  respuesta;
    }

    public String obtenerResultado6(RadioButton rb1, RadioButton rb2, RadioButton rb3, RadioButton rb4, RadioButton rb5, RadioButton rb6){
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
        return  respuesta;
    }

    public String Resultado2(){
        String cadena="";
        String resultado="  ";
        if(parbc1.isChecked()){cadena += "" + parbc1.getText().toString() + "-";}
        if(parbc2.isChecked()){cadena += "" + parbc2.getText().toString() + "-";}
        if(parbc3.isChecked()){cadena += "" + parbc3.getText().toString() + "-";}
        if(parbc4.isChecked()){cadena += "" + parbc4.getText().toString() + "-";}
        if(parbc5.isChecked()){cadena += "" + parbc5.getText().toString() + "-";}
        if(parbc6.isChecked()){cadena += "" + parbc6.getText().toString() + "-";}
        if(parbc7.isChecked()){cadena += "" + parbc7.getText().toString() + "-";}
        if(parbc8.isChecked()){cadena += "" + parbc8.getText().toString() + "-";}
        if(parbc9.isChecked()){cadena += "" + parbc9.getText().toString() + "-";}
        if(parbc10.isChecked()){cadena += "" + parbc10.getText().toString() + "-";}
        if(parbc11.isChecked()){cadena += "" + parbc11.getText().toString() + "-";}
        if(parbc12.isChecked()){cadena += "" + parbc12.getText().toString() + "-";}
        if(parbc13.isChecked()){cadena += "" + parbc13.getText().toString() + "-";}
        if(parbc14.isChecked()){cadena += "" + parbc14.getText().toString() + "-";}
        if(parbc15.isChecked()){cadena += "" + parbc15.getText().toString() + "-";}
        if(parbc16.isChecked()){cadena += "" + parbc16.getText().toString() + "-";}
        if(parbc17.isChecked()){cadena += "" + parbc17.getText().toString() + "-";}
        if(parbc18.isChecked()){cadena += "" + parbc18.getText().toString() + "-";}
        if(parbc19.isChecked()){cadena += "" + parbc19.getText().toString() + "-";}
        if(parbc20.isChecked()){cadena += "" + parbc20.getText().toString() + "-";}
        if(parbc21.isChecked()){cadena += "" + parbc21.getText().toString() + "-";}
        if(parbc22.isChecked()){cadena += "" + parbc22.getText().toString() + "-";}
        if(parbc23.isChecked()){cadena += "" + parbc23.getText().toString() + "-";}
        if(parbc24.isChecked()){cadena += "" + parbc24.getText().toString() + "-";}
        if(parbc25.isChecked()){cadena += "" + parbc25.getText().toString() + "-";}
        if(parbc26.isChecked()){cadena += "" + parbc26.getText().toString() + "-";}
        if(parbc27.isChecked()){cadena += "" + parbc27.getText().toString() + "-";}
        if(parbc28.isChecked()){cadena += "" + parbc28.getText().toString() + "-";}
        if(parbc29.isChecked()){cadena += "" + parbc29.getText().toString() + "-";}
        if(parbc30.isChecked()){cadena += "" + parbc30.getText().toString() + "-";}
        if(parbc31.isChecked()){cadena += "" + parbc31.getText().toString() + "-";}
        if(parbc32.isChecked()){cadena += "" + parbc32.getText().toString() + "-";}
        if(parbc33.isChecked()){cadena += "" + parbc33.getText().toString() + "-";}
        if(parbc34.isChecked()){cadena += "" + parbc34.getText().toString() + "-";}
        if(parbc35.isChecked()){cadena += "" + parbc35.getText().toString() + "-";}
        if(parbc36.isChecked()){cadena += "" + parbc36.getText().toString() + "-";}
        if(parbc37.isChecked()){cadena += "" + parbc37.getText().toString() + "-";}
        if(parbc38.isChecked()){cadena += "" + parbc38.getText().toString() + "-";}
        if(parbc39.isChecked()){cadena += "" + parbc39.getText().toString() + "-";}
        if(parbc40.isChecked()){cadena += "" + parbc40.getText().toString() + "-";}
        if(parbc41.isChecked()){cadena += "" + parbc41.getText().toString() + "-";}
        if(parbc42.isChecked()){cadena += "" + parbc42.getText().toString() + "-";}
        if(parbc43.isChecked()){cadena += "" + parbc43.getText().toString() + "-";}
        if(parbc44.isChecked()){cadena += "" + parbc44.getText().toString() + "-";}
        if(parbc45.isChecked()){cadena += "" + parbc45.getText().toString() + "-";}
        if(parbc46.isChecked()){cadena += "" + parbc46.getText().toString() + "-";}
        if(parbc47.isChecked()){cadena += "" + parbc47.getText().toString() + "-";}
        if(parbc47_1.isChecked()){cadena += "" + parbc47_1.getText().toString() + "-";}
        if(parbc47_2.isChecked()){cadena += "" + parbc47_2.getText().toString() + "-";}
        if(parbc47_3.isChecked()){cadena += "" + parbc47_3.getText().toString() + "-";}
        if(parbc47_4.isChecked()){cadena += "" + parbc47_4.getText().toString() + "-";}
        if(parbc47_5.isChecked()){cadena += "" + parbc47_5.getText().toString() + "-";}
        if(parbc47_6.isChecked()){cadena += "" + parbc47_6.getText().toString() + "-";}
        if(parbc47_7.isChecked()){cadena += "" + parbc47_7.getText().toString() + "-";}
        if(parbc47_8.isChecked()){cadena += "" + parbc47_8.getText().toString() + "-";}
        if(parbc47_9.isChecked()){cadena += "" + parbc47_9.getText().toString() + "-";}
        if(parbc47_10.isChecked()){cadena += "" + parbc47_10.getText().toString() + "-";}
        if(parbc47_11.isChecked()){cadena += "" + parbc47_11.getText().toString() + "-";}
        if(parbc47_12.isChecked()){cadena += "" + parbc47_12.getText().toString() + "-";}
        if(parbc47_13.isChecked()){cadena += "" + parbc47_13.getText().toString() + "-";}
        if(parbc47_14.isChecked()){cadena += "" + parbc47_14.getText().toString() + "-";}
        if(parbc47_15.isChecked()){cadena += "" + parbc47_15.getText().toString() + "-";}
        if(parbc47_16.isChecked()){cadena += "" + parbc47_16.getText().toString() + "-";}
        if(parbc47_17.isChecked()){cadena += "" + parbc47_17.getText().toString() + "-";}
        if(parbc47_18.isChecked()){cadena += "" + parbc47_18.getText().toString() + "-";}
        if(parbc47_19.isChecked()){cadena += "" + parbc47_19.getText().toString() + "-";}
        if(parbc47_20.isChecked()){cadena += "" + parbc47_20.getText().toString() + "-";}
        if(parbc47_21.isChecked()){cadena += "" + parbc47_21.getText().toString() + "-";}
        if(parbc47_22.isChecked()){cadena += "" + parbc47_22.getText().toString() + "-";}
        if(parbc47_23.isChecked()){cadena += "" + parbc47_23.getText().toString() + "-";}
        if(parbc47_24.isChecked()){cadena += "" + parbc47_24.getText().toString() + "-";}
        if(parbc47_25.isChecked()){cadena += "" + parbc47_25.getText().toString() + "-";}
        if(parbc47_26.isChecked()){cadena += "" + parbc47_26.getText().toString() + "-";}
        if(parbc47_27.isChecked()){cadena += "" + parbc47_27.getText().toString() + "-";}
        if(parbc47_28.isChecked()){cadena += "" + parbc47_28.getText().toString() + "-";}
        if(parbc47_29.isChecked()){cadena += "" + parbc47_29.getText().toString() + "-";}
        if(parbc47_30.isChecked()){cadena += "" + parbc47_30.getText().toString() + "-";}
        if(parbc47_31.isChecked()){cadena += "" + parbc47_31.getText().toString() + "-";}
        if(parbc47_32.isChecked()){cadena += "" + parbc47_32.getText().toString() + "-";}
        if(parbc47_33.isChecked()){cadena += "" + parbc47_33.getText().toString() + "-";}
        if(parbc47_34.isChecked()){cadena += "" + parbc47_34.getText().toString() + "-";}
        if(parbc47_35.isChecked()){cadena += "" + parbc47_35.getText().toString() + "-";}
        if(parbc47_36.isChecked()){cadena += "" + parbc47_36.getText().toString() + "-";}
        if(parbc47_37.isChecked()){cadena += "" + parbc47_37.getText().toString() + "-";}
        if(parbc47_38.isChecked()){cadena += "" + parbc47_38.getText().toString() + "-";}
        if(parbc47_39.isChecked()){cadena += "" + parbc47_39.getText().toString() + "-";}
        if(parbc47_40.isChecked()){cadena += "" + parbc47_40.getText().toString() + "-";}
        if(parbc47_41.isChecked()){cadena += "" + parbc47_41.getText().toString() + "-";}
        if(parbc47_42.isChecked()){cadena += "" + parbc47_42.getText().toString() + "-";}
        if(parbc47_43.isChecked()){cadena += "" + parbc47_43.getText().toString() + "-";}
        if(parbc47_44.isChecked()){cadena += "" + parbc47_44.getText().toString() + "-";}
        if(parbc47_45.isChecked()){cadena += "" + parbc47_45.getText().toString() + "-";}
        if(parbc47_46.isChecked()){cadena += "" + parbc47_46.getText().toString() + "-";}
        if(parbc47_47.isChecked()){cadena += "" + parbc47_47.getText().toString() + "-";}
        if(parbc47_48.isChecked()){cadena += "" + parbc47_48.getText().toString() + "-";}
        if(parbc47_49.isChecked()){cadena += "" + parbc47_49.getText().toString() + "-";}
        if(parbc47_50.isChecked()){cadena += "" + parbc47_50.getText().toString() + "-";}
        if(parbc47_51.isChecked()){cadena += "" + parbc47_51.getText().toString() + "-";}
        if(parbc47_52.isChecked()){cadena += "" + parbc47_52.getText().toString() + "-";}
        if(parbc47_53.isChecked()){cadena += "" + parbc47_53.getText().toString() + "-";}
        if(parbc47_54.isChecked()){cadena += "" + parbc47_54.getText().toString() + "-";}
        if(parbc47_55.isChecked()){cadena += "" + parbc47_55.getText().toString() + "-";}
        if(parbc47_56.isChecked()){cadena += "" + parbc47_56.getText().toString() + "-";}
        if(parbc47_57.isChecked()){cadena += "" + parbc47_57.getText().toString() + "-";}




        resultado = cadena.substring(0, cadena.length()-1);
        return resultado;
    }

    public String Resultado5(){
        String cadena="";
        String resultado="  ";
        if(parbc48.isChecked()){cadena += "" + parbc48.getText().toString() + "-";}
        if(parbc49.isChecked()){cadena += "" + parbc49.getText().toString() + "-";}
        if(parbc50.isChecked()){cadena += "" + parbc50.getText().toString() + "-";}
        if(parbc51.isChecked()){cadena += "" + parbc51.getText().toString() + "-";}
        if(parbc52.isChecked()){cadena += "" + parbc52.getText().toString() + "-";}
        resultado = cadena.substring(0, cadena.length()-1);
        return resultado;
    }

    public String Resultado7(){
        String cadena="";
        String resultado="  ";
        if(parbc53.isChecked()){cadena += "" + parbc53.getText().toString() + "-";}
        if(parbc54.isChecked()){cadena += "" + parbc54.getText().toString() + "-";}
        if(parbc55.isChecked()){cadena += "" + parbc55.getText().toString() + "-";}
        if(parbc56.isChecked()){cadena += "" + parbc56.getText().toString() + "-";}
        if(parbc57.isChecked()){cadena += "" + parbc57.getText().toString() + "-";}
        if(parbc58.isChecked()){cadena += "" + parbc58.getText().toString() + "-";}
        if(parbc59.isChecked()){cadena += "" + parbc59.getText().toString() + "-";}
        if(parbc60.isChecked()){cadena += "" + parbc60.getText().toString() + "-";}
        if(parbc61.isChecked()){cadena += "" + parbc61.getText().toString() + "-";}
        if(parbc62.isChecked()){cadena += "" + parbc62.getText().toString() + "-";}
        if(parbc63.isChecked()){cadena += "" + parbc63.getText().toString() + "-";}
        if(parbc64.isChecked()){cadena += "" + parbc64.getText().toString() + "-";}
        if(parbc65.isChecked()){cadena += "" + parbc65.getText().toString() + "-";}
        if(parbc66.isChecked()){cadena += "" + parbc66.getText().toString() + "-";}
        if(parbc67.isChecked()){cadena += "" + parbc67.getText().toString() + "-";}
        if(parbc68.isChecked()){cadena += "" + parbc68.getText().toString() + "-";}
        if(parbc69.isChecked()){cadena += "" + parbc69.getText().toString() + "-";}
        if(parbc70.isChecked()){cadena += "" + parbc70.getText().toString() + "-";}
        if(parbc71.isChecked()){cadena += "" + parbc71.getText().toString() + "-";}
        if(parbc72.isChecked()){cadena += "" + parbc72.getText().toString() + "-";}
        if(parbc73.isChecked()){cadena += "" + parbc73.getText().toString() + "-";}
        if(parbc74.isChecked()){cadena += "" + parbc74.getText().toString() + "-";}
        if(parbc75.isChecked()){cadena += "" + parbc75.getText().toString() + "-";}
        if(parbc76.isChecked()){cadena += "" + parbc76.getText().toString() + "-";}
        if(parbc77.isChecked()){cadena += "" + parbc77.getText().toString() + "-";}
        if(parbc78.isChecked()){cadena += "" + parbc78.getText().toString() + "-";}
        if(parbc79.isChecked()){cadena += "" + parbc79.getText().toString() + "-";}
        if(parbc80.isChecked()){cadena += "" + parbc80.getText().toString() + "-";}
        if(parbc81.isChecked()){cadena += "" + parbc81.getText().toString() + "-";}
        if(parbc82.isChecked()){cadena += "" + parbc82.getText().toString() + "-";}
        if(parbc83.isChecked()){cadena += "" + parbc83.getText().toString() + "-";}
        if(parbc84.isChecked()){cadena += "" + parbc84.getText().toString() + "-";}
        if(parbc85.isChecked()){cadena += "" + parbc85.getText().toString() + "-";}
        if(parbc86.isChecked()){cadena += "" + parbc86.getText().toString() + "-";}
        if(parbc87.isChecked()){cadena += "" + parbc87.getText().toString() + "-";}
        if(parbc88.isChecked()){cadena += "" + parbc88.getText().toString() + "-";}
        if(parbc89.isChecked()){cadena += "" + parbc89.getText().toString() + "-";}
        if(parbc90.isChecked()){cadena += "" + parbc90.getText().toString() + "-";}
        if(parbc91.isChecked()){cadena += "" + parbc91.getText().toString() + "-";}
        if(parbc92.isChecked()){cadena += "" + parbc92.getText().toString() + "-";}
        if(parbc93.isChecked()){cadena += "" + parbc93.getText().toString() + "-";}
        if(parbc94.isChecked()){cadena += "" + parbc94.getText().toString() + "-";}
        if(parbc95.isChecked()){cadena += "" + parbc95.getText().toString() + "-";}
        if(parbc96.isChecked()){cadena += "" + parbc96.getText().toString() + "-";}
        if(parbc97.isChecked()){cadena += "" + parbc97.getText().toString() + "-";}
        if(parbc98.isChecked()){cadena += "" + parbc98.getText().toString() + "-";}
        if(parbc99.isChecked()){cadena += "" + parbc99.getText().toString() + "-";}
        if(parbc9_1.isChecked()){cadena += "" + parbc9_1.getText().toString() + "-";}
        if(parbc9_2.isChecked()){cadena += "" + parbc9_2.getText().toString() + "-";}
        if(parbc9_3.isChecked()){cadena += "" + parbc9_3.getText().toString() + "-";}
        if(parbc9_4.isChecked()){cadena += "" + parbc9_4.getText().toString() + "-";}
        if(parbc9_5.isChecked()){cadena += "" + parbc9_5.getText().toString() + "-";}
        if(parbc9_6.isChecked()){cadena += "" + parbc9_6.getText().toString() + "-";}
        if(parbc9_7.isChecked()){cadena += "" + parbc9_7.getText().toString() + "-";}
        if(parbc9_8.isChecked()){cadena += "" + parbc9_8.getText().toString() + "-";}
        if(parbc9_9.isChecked()){cadena += "" + parbc9_9.getText().toString() + "-";}
        if(parbc9_10.isChecked()){cadena += "" + parbc9_10.getText().toString() + "-";}
        if(parbc9_11.isChecked()){cadena += "" + parbc9_11.getText().toString() + "-";}
        if(parbc9_12.isChecked()){cadena += "" + parbc9_12.getText().toString() + "-";}
        if(parbc9_13.isChecked()){cadena += "" + parbc9_13.getText().toString() + "-";}
        if(parbc9_14.isChecked()){cadena += "" + parbc9_14.getText().toString() + "-";}
        if(parbc9_15.isChecked()){cadena += "" + parbc9_15.getText().toString() + "-";}
        if(parbc9_16.isChecked()){cadena += "" + parbc9_16.getText().toString() + "-";}
        if(parbc9_17.isChecked()){cadena += "" + parbc9_17.getText().toString() + "-";}
        if(parbc9_18.isChecked()){cadena += "" + parbc9_18.getText().toString() + "-";}
        if(parbc9_19.isChecked()){cadena += "" + parbc9_19.getText().toString() + "-";}
        if(parbc9_20.isChecked()){cadena += "" + parbc9_20.getText().toString() + "-";}
        if(parbc9_21.isChecked()){cadena += "" + parbc9_21.getText().toString() + "-";}
        if(parbc9_22.isChecked()){cadena += "" + parbc9_22.getText().toString() + "-";}
        if(parbc9_23.isChecked()){cadena += "" + parbc9_23.getText().toString() + "-";}
        if(parbc9_24.isChecked()){cadena += "" + parbc9_24.getText().toString() + "-";}
        if(parbc9_25.isChecked()){cadena += "" + parbc9_25.getText().toString() + "-";}
        if(parbc9_26.isChecked()){cadena += "" + parbc9_26.getText().toString() + "-";}
        if(parbc9_27.isChecked()){cadena += "" + parbc9_27.getText().toString() + "-";}
        if(parbc9_28.isChecked()){cadena += "" + parbc9_28.getText().toString() + "-";}
        if(parbc9_29.isChecked()){cadena += "" + parbc9_29.getText().toString() + "-";}
        if(parbc9_30.isChecked()){cadena += "" + parbc9_30.getText().toString() + "-";}
        if(parbc9_31.isChecked()){cadena += "" + parbc9_31.getText().toString() + "-";}
        if(parbc9_32.isChecked()){cadena += "" + parbc9_32.getText().toString() + "-";}
        if(parbc9_33.isChecked()){cadena += "" + parbc9_33.getText().toString() + "-";}
        if(parbc9_34.isChecked()){cadena += "" + parbc9_34.getText().toString() + "-";}
        if(parbc9_35.isChecked()){cadena += "" + parbc9_35.getText().toString() + "-";}
        if(parbc9_36.isChecked()){cadena += "" + parbc9_36.getText().toString() + "-";}
        if(parbc9_37.isChecked()){cadena += "" + parbc9_37.getText().toString() + "-";}
        if(parbc9_38.isChecked()){cadena += "" + parbc9_38.getText().toString() + "-";}
        if(parbc9_39.isChecked()){cadena += "" + parbc9_39.getText().toString() + "-";}
        if(parbc9_40.isChecked()){cadena += "" + parbc9_40.getText().toString() + "-";}
        if(parbc9_41.isChecked()){cadena += "" + parbc9_41.getText().toString() + "-";}
        if(parbc9_42.isChecked()){cadena += "" + parbc9_42.getText().toString() + "-";}
        if(parbc9_43.isChecked()){cadena += "" + parbc9_43.getText().toString() + "-";}
        if(parbc9_44.isChecked()){cadena += "" + parbc9_44.getText().toString() + "-";}
        if(parbc9_45.isChecked()){cadena += "" + parbc9_45.getText().toString() + "-";}
        if(parbc9_46.isChecked()){cadena += "" + parbc9_46.getText().toString() + "-";}
        if(parbc9_47.isChecked()){cadena += "" + parbc9_47.getText().toString() + "-";}
        if(parbc9_48.isChecked()){cadena += "" + parbc9_48.getText().toString() + "-";}
        if(parbc9_49.isChecked()){cadena += "" + parbc9_49.getText().toString() + "-";}
        if(parbc9_50.isChecked()){cadena += "" + parbc9_50.getText().toString() + "-";}
        if(parbc9_51.isChecked()){cadena += "" + parbc9_51.getText().toString() + "-";}
        if(parbc9_52.isChecked()){cadena += "" + parbc9_52.getText().toString() + "-";}
        if(parbc9_53.isChecked()){cadena += "" + parbc9_53.getText().toString() + "-";}
        if(parbc9_54.isChecked()){cadena += "" + parbc9_54.getText().toString() + "-";}
        if(parbc9_55.isChecked()){cadena += "" + parbc9_55.getText().toString() + "-";}
        if(parbc9_56.isChecked()){cadena += "" + parbc9_56.getText().toString() + "-";}
        if(parbc9_57.isChecked()){cadena += "" + parbc9_57.getText().toString() + "-";}

        resultado = cadena.substring(0, cadena.length()-1);
        return resultado;
    }

    public String Resultado8(){
        String cadena="";
        String resultado="  ";
        if(parbc142.isChecked()){cadena += "" + parbc142.getText().toString() + "-";}
        if(parbc143.isChecked()){cadena += "" + parbc143.getText().toString() + "-";}
        if(parbc144.isChecked()){cadena += "" + parbc144.getText().toString() + "-";}
        if(parbc145.isChecked()){cadena += "" + parbc145.getText().toString() + "-";}
        if(parbc146.isChecked()){cadena += "" + parbc146.getText().toString() + "-";}
        if(parbc147.isChecked()){cadena += "" + parbc147.getText().toString() + "-";}
        if(parbc148.isChecked()){cadena += "" + parbc148.getText().toString() + "-";}
        if(parbc149.isChecked()){cadena += "" + parbc149.getText().toString() + "-";}
        if(parbc150.isChecked()){cadena += "" + parbc150.getText().toString() + "-";}
        if(parbc151.isChecked()){cadena += "" + parbc151.getText().toString() + "-";}
        if(parbc152.isChecked()){cadena += "" + parbc152.getText().toString() + "-";}
        if(parbc153.isChecked()){cadena += "" + parbc153.getText().toString() + "-";}
        if(parbc154.isChecked()){cadena += "" + parbc154.getText().toString() + "-";}
        if(parbc155.isChecked()){cadena += "" + parbc155.getText().toString() + "-";}
        if(parbc156.isChecked()){cadena += "" + parbc156.getText().toString() + "-";}
        if(parbc157.isChecked()){cadena += "" + parbc157.getText().toString() + "-";}
        if(parbc158.isChecked()){cadena += "" + parbc158.getText().toString() + "-";}
        if(parbc159.isChecked()){cadena += "" + parbc159.getText().toString() + "-";}
        if(parbc160.isChecked()){cadena += "" + parbc160.getText().toString() + "-";}
        if(parbc161.isChecked()){cadena += "" + parbc161.getText().toString() + "-";}
        if(parbc162.isChecked()){cadena += "" + parbc162.getText().toString() + "-";}
        if(parbc163.isChecked()){cadena += "" + parbc163.getText().toString() + "-";}
        if(parbc164.isChecked()){cadena += "" + parbc164.getText().toString() + "-";}
        if(parbc165.isChecked()){cadena += "" + parbc165.getText().toString() + "-";}
        if(parbc166.isChecked()){cadena += "" + parbc166.getText().toString() + "-";}
        if(parbc167.isChecked()){cadena += "" + parbc167.getText().toString() + "-";}
        if(parbc168.isChecked()){cadena += "" + parbc168.getText().toString() + "-";}
        if(parbc169.isChecked()){cadena += "" + parbc169.getText().toString() + "-";}
        resultado = cadena.substring(0, cadena.length()-1);
        return resultado;
    }

    public String Resultado13(){
        String cadena="";
        String resultado="  ";
        if(parbc170.isChecked()){cadena += "" + parbc170.getText().toString() + "-";}
        if(parbc171.isChecked()){cadena += "" + parbc171.getText().toString() + "-";}
        if(parbc172.isChecked()){cadena += "" + parbc172.getText().toString() + "-";}
        if(parbc173.isChecked()){cadena += "" + parbc173.getText().toString() + "-";}
        if(parbc174.isChecked()){cadena += "Pago de servicios-";}
        if(parbc175.isChecked()){cadena += "" + parbc175.getText().toString() + "-";}
        if(parbc176.isChecked()){cadena += "" + parbc176.getText().toString() + "-";}
        if(parbc177.isChecked()){cadena += "Papelería-";}
        if(parbc178.isChecked()){cadena += "" + parbc178.getText().toString() + "-";}
        resultado = cadena.substring(0, cadena.length()-1);
        return resultado;
    }

    public String Resultado14(){
        String cadena="";
        String resultado="  ";
        if(parbc179.isChecked()){cadena += "" + parbc179.getText().toString() + "-";}
        if(parbc180.isChecked()){cadena += "Vehículo propio-";}
        if(parbc181.isChecked()){cadena += "Transporte público-";}
        if(parbc182.isChecked()){cadena += "" + parbc182.getText().toString() + "-";}
        if(parbc183.isChecked()){cadena += "" + parbc183.getText().toString() + "-";}
        if(parbc184.isChecked()){cadena += "" + parbc184.getText().toString() + "-";}
        if(parbc185.isChecked()){cadena += "" + parbc185.getText().toString() + "-";}
        resultado = cadena.substring(0, cadena.length()-1);
        return resultado;
    }

    public String Resultado17(){
        String cadena="";
        String resultado="  ";
        if(parbc186.isChecked()){cadena += "" + parbc186.getText().toString() + "-";}
        if(parbc187.isChecked()){cadena += "" + parbc187.getText().toString() + "-";}
        if(parbc188.isChecked()){cadena += "" + parbc188.getText().toString() + "-";}
        if(parbc189.isChecked()){cadena += "" + parbc189.getText().toString() + "-";}
        resultado = cadena.substring(0, cadena.length()-1);
        return resultado;
    }

    public String Resultado19(){
        String cadena="";
        String resultado="  ";
        if(parbc190.isChecked()){cadena += "" + parbc190.getText().toString() + "-";}
        if(parbc191.isChecked()){cadena += "" + parbc191.getText().toString() + "-";}
        if(parbc192.isChecked()){cadena += "" + parbc192.getText().toString() + "-";}
        if(parbc193.isChecked()){cadena += "" + parbc193.getText().toString() + "-";}
        if(parbc194.isChecked()){cadena += "" + parbc194.getText().toString() + "-";}
        if(parbc195.isChecked()){cadena += "" + parbc195.getText().toString() + "-";}
        if(parbc196.isChecked()){cadena += "" + parbc196.getText().toString() + "-";}
        if(parbc197.isChecked()){cadena += "" + parbc197.getText().toString() + "-";}
        if(parbc198.isChecked()){cadena += "" + parbc198.getText().toString() + "-";}
        if(parbc199.isChecked()){cadena += "" + parbc199.getText().toString() + "-";}
        if(parbc200.isChecked()){cadena += "" + parbc200.getText().toString() + "-";}
        if(parbc201.isChecked()){cadena += "" + parbc201.getText().toString() + "-";}
        if(parbc202.isChecked()){cadena += "" + parbc202.getText().toString() + "-";}
        if(parbc203.isChecked()){cadena += "" + parbc203.getText().toString() + "-";}
        if(parbc204.isChecked()){cadena += "" + parbc204.getText().toString() + "-";}
        if(parbc205.isChecked()){cadena += "" + parbc205.getText().toString() + "-";}
        if(parbc206.isChecked()){cadena += "" + parbc206.getText().toString() + "-";}
        if(parbc207.isChecked()){cadena += "" + parbc207.getText().toString() + "-";}
        if(parbc208.isChecked()){cadena += "" + parbc208.getText().toString() + "-";}
        if(parbc209.isChecked()){cadena += "" + parbc209.getText().toString() + "-";}
        if(parbc210.isChecked()){cadena += "" + parbc210.getText().toString() + "-";}
        if(parbc211.isChecked()){cadena += "" + parbc211.getText().toString() + "-";}
        if(parbc212.isChecked()){cadena += "" + parbc212.getText().toString() + "-";}
        if(parbc213.isChecked()){cadena += "" + parbc213.getText().toString() + "-";}
        if(parbc214.isChecked()){cadena += "" + parbc214.getText().toString() + "-";}
        if(parbc215.isChecked()){cadena += "" + parbc215.getText().toString() + "-";}
        if(parbc216.isChecked()){cadena += "" + parbc216.getText().toString() + "-";}
        if(parbc217.isChecked()){cadena += "" + parbc217.getText().toString() + "-";}
        if(parbc218.isChecked()){cadena += "" + parbc218.getText().toString() + "-";}
        if(parbc219.isChecked()){cadena += "" + parbc219.getText().toString() + "-";}
        if(parbc220.isChecked()){cadena += "" + parbc220.getText().toString() + "-";}
        if(parbc221.isChecked()){cadena += "" + parbc221.getText().toString() + "-";}
        if(parbc222.isChecked()){cadena += "" + parbc222.getText().toString() + "-";}
        if(parbc223.isChecked()){cadena += "" + parbc223.getText().toString() + "-";}
        if(parbc224.isChecked()){cadena += "" + parbc224.getText().toString() + "-";}
        if(parbc225.isChecked()){cadena += "" + parbc225.getText().toString() + "-";}
        if(parbc226.isChecked()){cadena += "" + parbc226.getText().toString() + "-";}
        if(parbc227.isChecked()){cadena += "" + parbc227.getText().toString() + "-";}
        if(parbc228.isChecked()){cadena += "" + parbc228.getText().toString() + "-";}
        if(parbc229.isChecked()){cadena += "" + parbc229.getText().toString() + "-";}
        if(parbc230.isChecked()){cadena += "" + parbc230.getText().toString() + "-";}
        if(parbc231.isChecked()){cadena += "" + parbc231.getText().toString() + "-";}
        if(parbc232.isChecked()){cadena += "" + parbc232.getText().toString() + "-";}
        if(parbc233.isChecked()){cadena += "" + parbc233.getText().toString() + "-";}
        if(parbc234.isChecked()){cadena += "" + parbc234.getText().toString() + "-";}
        if(parbc235.isChecked()){cadena += "" + parbc235.getText().toString() + "-";}
        if(parbc236.isChecked()){cadena += "" + parbc236.getText().toString() + "-";}
        if(parbc236_1.isChecked()){cadena += "" + parbc236_1.getText().toString() + "-";}
        if(parbc236_2.isChecked()){cadena += "" + parbc236_2.getText().toString() + "-";}
        if(parbc236_3.isChecked()){cadena += "" + parbc236_3.getText().toString() + "-";}
        if(parbc236_4.isChecked()){cadena += "" + parbc236_4.getText().toString() + "-";}
        if(parbc236_5.isChecked()){cadena += "" + parbc236_5.getText().toString() + "-";}
        if(parbc236_6.isChecked()){cadena += "" + parbc236_6.getText().toString() + "-";}
        if(parbc236_7.isChecked()){cadena += "" + parbc236_7.getText().toString() + "-";}
        if(parbc236_8.isChecked()){cadena += "" + parbc236_8.getText().toString() + "-";}
        if(parbc236_9.isChecked()){cadena += "" + parbc236_9.getText().toString() + "-";}
        if(parbc236_10.isChecked()){cadena += "" + parbc236_10.getText().toString() + "-";}
        if(parbc236_11.isChecked()){cadena += "" + parbc236_11.getText().toString() + "-";}
        if(parbc236_12.isChecked()){cadena += "" + parbc236_12.getText().toString() + "-";}
        if(parbc236_13.isChecked()){cadena += "" + parbc236_13.getText().toString() + "-";}
        if(parbc236_14.isChecked()){cadena += "" + parbc236_14.getText().toString() + "-";}
        if(parbc236_15.isChecked()){cadena += "" + parbc236_15.getText().toString() + "-";}
        if(parbc236_16.isChecked()){cadena += "" + parbc236_16.getText().toString() + "-";}
        if(parbc236_17.isChecked()){cadena += "" + parbc236_17.getText().toString() + "-";}
        if(parbc236_18.isChecked()){cadena += "" + parbc236_18.getText().toString() + "-";}
        if(parbc236_19.isChecked()){cadena += "" + parbc236_19.getText().toString() + "-";}
        if(parbc236_20.isChecked()){cadena += "" + parbc236_20.getText().toString() + "-";}
        if(parbc236_21.isChecked()){cadena += "" + parbc236_21.getText().toString() + "-";}
        if(parbc236_22.isChecked()){cadena += "" + parbc236_22.getText().toString() + "-";}
        if(parbc236_23.isChecked()){cadena += "" + parbc236_23.getText().toString() + "-";}
        if(parbc236_24.isChecked()){cadena += "" + parbc236_24.getText().toString() + "-";}
        if(parbc236_25.isChecked()){cadena += "" + parbc236_25.getText().toString() + "-";}
        if(parbc236_26.isChecked()){cadena += "" + parbc236_26.getText().toString() + "-";}
        if(parbc236_27.isChecked()){cadena += "" + parbc236_27.getText().toString() + "-";}
        if(parbc236_28.isChecked()){cadena += "" + parbc236_28.getText().toString() + "-";}
        if(parbc236_29.isChecked()){cadena += "" + parbc236_29.getText().toString() + "-";}
        if(parbc236_30.isChecked()){cadena += "" + parbc236_30.getText().toString() + "-";}
        if(parbc236_31.isChecked()){cadena += "" + parbc236_31.getText().toString() + "-";}
        if(parbc236_32.isChecked()){cadena += "" + parbc236_32.getText().toString() + "-";}
        if(parbc236_33.isChecked()){cadena += "" + parbc236_33.getText().toString() + "-";}
        if(parbc236_34.isChecked()){cadena += "" + parbc236_34.getText().toString() + "-";}
        if(parbc236_35.isChecked()){cadena += "" + parbc236_35.getText().toString() + "-";}
        if(parbc236_36.isChecked()){cadena += "" + parbc236_36.getText().toString() + "-";}
        if(parbc236_37.isChecked()){cadena += "" + parbc236_37.getText().toString() + "-";}
        if(parbc236_38.isChecked()){cadena += "" + parbc236_38.getText().toString() + "-";}
        if(parbc236_39.isChecked()){cadena += "" + parbc236_39.getText().toString() + "-";}
        if(parbc236_40.isChecked()){cadena += "" + parbc236_40.getText().toString() + "-";}
        if(parbc236_41.isChecked()){cadena += "" + parbc236_41.getText().toString() + "-";}
        if(parbc236_42.isChecked()){cadena += "" + parbc236_42.getText().toString() + "-";}
        if(parbc236_43.isChecked()){cadena += "" + parbc236_43.getText().toString() + "-";}
        if(parbc236_44.isChecked()){cadena += "" + parbc236_44.getText().toString() + "-";}
        if(parbc236_45.isChecked()){cadena += "" + parbc236_45.getText().toString() + "-";}
        if(parbc236_46.isChecked()){cadena += "" + parbc236_46.getText().toString() + "-";}
        if(parbc236_47.isChecked()){cadena += "" + parbc236_47.getText().toString() + "-";}
        if(parbc236_48.isChecked()){cadena += "" + parbc236_48.getText().toString() + "-";}
        if(parbc236_49.isChecked()){cadena += "" + parbc236_49.getText().toString() + "-";}
        if(parbc236_50.isChecked()){cadena += "" + parbc236_50.getText().toString() + "-";}
        if(parbc236_51.isChecked()){cadena += "" + parbc236_51.getText().toString() + "-";}
        if(parbc236_52.isChecked()){cadena += "" + parbc236_52.getText().toString() + "-";}
        if(parbc236_53.isChecked()){cadena += "" + parbc236_53.getText().toString() + "-";}
        if(parbc236_54.isChecked()){cadena += "" + parbc236_54.getText().toString() + "-";}
        if(parbc236_55.isChecked()){cadena += "" + parbc236_55.getText().toString() + "-";}
        if(parbc236_56.isChecked()){cadena += "" + parbc236_56.getText().toString() + "-";}
        if(parbc236_57.isChecked()){cadena += "" + parbc236_57.getText().toString() + "-";}

        resultado = cadena.substring(0, cadena.length()-1);
        return resultado;
    }

    public String Resultado25(){
        String cadena="";
        String resultado="  ";
        if(parbc237.isChecked()){cadena += "" + parbc237.getText().toString() + "-";}
        if(parbc238.isChecked()){cadena += "" + parbc238.getText().toString() + "-";}
        if(parbc239.isChecked()){cadena += "" + parbc239.getText().toString() + "-";}
        if(parbc240.isChecked()){cadena += "" + parbc240.getText().toString() + "-";}
        if(parbc241.isChecked()){cadena += "" + parbc241.getText().toString() + "-";}
        resultado = cadena.substring(0, cadena.length()-1);
        return resultado;
    }

    public String Resultado26(){
        String cadena="";
        String resultado="  ";
        if(parbc242.isChecked()){cadena += "" + parbc242.getText().toString() + "-";}
        if(parbc243.isChecked()){cadena += "" + parbc243.getText().toString() + "-";}
        if(parbc244.isChecked()){cadena += "" + parbc244.getText().toString() + "-";}
        if(parbc245.isChecked()){cadena += "" + parbc245.getText().toString() + "-";}
        if(parbc246.isChecked()){cadena += "" + parbc246.getText().toString() + "-";}
        resultado = cadena.substring(0, cadena.length()-1);
        return resultado;
    }



    @Override
    public void onBackPressed() {

    }

}

