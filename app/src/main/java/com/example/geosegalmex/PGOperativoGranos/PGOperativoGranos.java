package com.example.geosegalmex.PGOperativoGranos;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Georeferencia.GeoreferenciaActivity;
import com.example.geosegalmex.PGOperativoEstimulos.PGOperativoEstimulos;
import com.example.geosegalmex.PGOperativoEstimulos.PGOperativoEstimulos_Model;
import com.example.geosegalmex.R;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class PGOperativoGranos extends AppCompatActivity {

    int dia, mes, anio;
    TextView textFecha;
    EditText nomcentro, numcentro, localidad, calle, cp;
    Spinner spi_edo, spi_mun;
    RadioButton si, no, na, si2, no2, na2, si3, no3, na3, si6, no6, na6, si7, no7, na7, si8, no8, na8, si9, no9, na9, si10, no10, na10, si11, no11, na11;
    EditText ed1, ed2, ed3, ed5, ed6, ed7, ed8, ed9, ed10, ed11, ed12;
    CheckBox cuatroa, cuatrob, cuatroc, cuatrod, cincoa, cincob, cincoc, cincod, cincoe, cincof;
    Button avanzar;
    PGOperativoGranos_Model model;

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
        setContentView(R.layout.activity_pgoperativo_granos);

        Declaracion();
        muestrafecha();

        spi_edo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String[] estados = getResources().getStringArray(R.array.Estados2021);
                String[] cveestados = getResources().getStringArray(R.array.cveEstados2021);

                cveedo = cveestados[position];
                nomedo = estados[position];

                municipios = getResources().getStringArray(idmunicipios[position]);
                cvemunicipios = getResources().getStringArray(idcvemunicipios[position]);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(PGOperativoGranos.this, android.R.layout.simple_spinner_item, municipios);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spi_mun.setAdapter(adapter);
                spi_mun.setEnabled(true);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        spi_mun.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                nommun = municipios[position];
                cvemun = cvemunicipios[position];
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        //Funcion para ocultar y mostrar las Observaciones en cada pregunta
        eventos();

        avanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validar()){

                    String fol = General.Foliocuestion;
                    General.fechaenc = textFecha.getText().toString();
                    String nomven = nomcentro.getText().toString();
                    String cveven = numcentro.getText().toString();
                    String loc = localidad.getText().toString();
                    String call = calle.getText().toString();
                    String codp = cp.getText().toString();
                    String uno = obtenerResultado(si, no, na);
                    String unoObs = ed1.getText().toString();
                    String dos = obtenerResultado(si2, no2, na2);
                    String dosObs = ed2.getText().toString();
                    String tres = obtenerResultado(si3, no3, na3);
                    String tresObs = ed3.getText().toString();
                    String cuatroA = (cuatroa.isChecked())? "1" : "";
                    String cuatroB = (cuatrob.isChecked())? "1" : "";
                    String cuatroC = (cuatroc.isChecked())? "1" : "";
                    String cuatroD = (cuatrod.isChecked())? "1" : "";
                    String cincoA = (cincoa.isChecked())? "1" : "";
                    String cincoB = (cincob.isChecked())? "1" : "";
                    String cincoC = (cincoc.isChecked())? "1" : "";
                    String cincoD = (cincod.isChecked())? "1" : "";
                    String cincoE = (cincoe.isChecked())? "1" : "";
                    String cincoF = (cincof.isChecked())? "1" : "";
                    String cincoObs = ed5.getText().toString();
                    String seis = obtenerResultado(si6, no6, na6);
                    String seisObs = ed6.getText().toString();
                    String siete = obtenerResultado(si7, no7, na7);
                    String sieteObs = ed7.getText().toString();
                    String ocho = obtenerResultado(si8, no8, na8);
                    String ochoObs = ed8.getText().toString();
                    String nueve = obtenerResultado(si9, no9, na9);
                    String nueveObs = ed9.getText().toString();
                    String diez = obtenerResultado(si10, no10, na10);
                    String diezObs = ed10.getText().toString();
                    String once = obtenerResultado(si11, no11, na11);
                    String onceObs = ed11.getText().toString();
                    String doce = ed12.getText().toString();

                    String f1 = General.Foto1;
                    String f2 = General.Foto2;

                    model = new PGOperativoGranos_Model(fol, General.fechaenc, cveven, nomven, cveedo, nomedo, cvemun,  nommun, "", loc, call, codp, uno, unoObs, dos, dosObs, tres, tresObs, cuatroA, cuatroB,
                            cuatroC, cuatroD, cincoA, cincoB, cincoC, cincoD, cincoE, cincoF, cincoObs, seis, seisObs, siete, sieteObs, ocho, ochoObs, nueve, nueveObs, diez, diezObs, once, onceObs,
                            doce, f1, f2, "", "");
                    Intent in = new Intent(PGOperativoGranos.this, GeoreferenciaActivity.class);
                    in.putExtra("model", model);
                    startActivity(in);
                    /*Toast.makeText(getApplicationContext(), "Folio: " + model.getFolio() + "\n Fecha: " + model.getFecha() + "\n cveven: " + model.getCveventanilla() + "\n nomven: " + model.getVentanilla()
                            + "\n CveEdo: " + model.getCveestado() + "\n Edo: " + model.getEstado() + "\n CveMun: " + model.getCvemunicipio() + "\n Mun: " + model.getMunicipio()
                            + "\n loc: " + model.getLocalidad() + "\n calle: " + model.getCalle()  + "\n Cp: " + model.getCp() + "\n Uno: " + model.getUno() + "\n UnoObs: " + model.getUnosobs()
                            + "\n Dos: " + model.getDos() + "\n DosObs: " + model.getDosobs() + "\n Tres: " + model.getTres() + "\n TresObs: " + model.getTresobs()
                            + "\n Cuatroa: " + model.getCuatroa() + "\n Cuatrob: " + model.getCuatrob() + "\n Cuatroc: " + model.getCuatroc() + "\n Cuatrod: " + model.getCuatrod()
                            + "\n Cincoa: " + model.getCincoa() + "\n Cincob: " + model.getCincob() + "\n Cincoc: " + model.getCincoc() + "\n Cincod: " + model.getCincod() + "\n Cincoe: " + model.getCincoe()
                            + "\n Cincof: " + model.getCincof() + "\n CincoObs: " + model.getCincoobs()
                            + "\n Seis: " + model.getSeis() + "\n SeisObs: " + model.getSeisobs() + "\n Siete: " + model.getSiete() + "\n SieteObs: " + model.getSieteobs()
                            + "\n Ocho: " + model.getOcho() + "\n Ochoobs: " + model.getOchoobs() + "\n Nueve: " + model.getNueve() + "\n NueveObs: " + model.getNueveobs()
                            + "\n Diez: " + model.getDiez() + "\n DiezObs: " + model.getDiezobs() + "\n Once: " + model.getOnce() + "\n OnceObs: " + model.getOnceobs() + "\n Doce: " + model.getDoce()
                            + "\n F1: " + model.getFoto1() + "\n F2: " + model.getFoto2(),Toast.LENGTH_SHORT).show();*/
                }
                else{
                    Toast.makeText(getApplicationContext(), "Faltan respuestas",Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

    protected void Declaracion(){
        textFecha = (TextView)findViewById(R.id.pasl_o_txtFecha);
        nomcentro = (EditText)findViewById(R.id.pre_garan_txt3);
        numcentro = (EditText)findViewById(R.id.pre_garan_txt4);
        spi_edo = (Spinner)findViewById(R.id.pre_garan_spin1);
        spi_mun = (Spinner)findViewById(R.id.pre_garan_spin2);
        localidad = (EditText)findViewById(R.id.pg_granos_txtLocalidad);
        calle = (EditText)findViewById(R.id.pre_garan_txt5);
        cp = (EditText)findViewById(R.id.pre_garan_txt6);
        si = (RadioButton)findViewById(R.id.pre_garan_ra1);
        no = (RadioButton)findViewById(R.id.pre_garan_ra2);
        na = (RadioButton)findViewById(R.id.pre_garan_ra3);
        si2 = (RadioButton)findViewById(R.id.pre_garan_ra4);
        no2 = (RadioButton)findViewById(R.id.pre_garan_ra5);
        na2 = (RadioButton)findViewById(R.id.pre_garan_ra6);
        si3 = (RadioButton)findViewById(R.id.pre_garan_ra7);
        no3 = (RadioButton)findViewById(R.id.pre_garan_ra8);
        na3 = (RadioButton)findViewById(R.id.pre_garan_ra9);
        si6 = (RadioButton)findViewById(R.id.pre_garan_ra10);
        no6 = (RadioButton)findViewById(R.id.pre_garan_ra11);
        na6 = (RadioButton)findViewById(R.id.pre_garan_ra12);
        si7 = (RadioButton)findViewById(R.id.pre_garan_ra13);
        no7 = (RadioButton)findViewById(R.id.pre_garan_ra14);
        na7 = (RadioButton)findViewById(R.id.pre_garan_ra15);
        si8 = (RadioButton)findViewById(R.id.pre_garan_ra16);
        no8 = (RadioButton)findViewById(R.id.pre_garan_ra17);
        na8 = (RadioButton)findViewById(R.id.pre_garan_ra18);
        si9 = (RadioButton)findViewById(R.id.pre_garan_ra19);
        no9 = (RadioButton)findViewById(R.id.pre_garan_ra20);
        na9 = (RadioButton)findViewById(R.id.pre_garan_ra21);
        si10 = (RadioButton)findViewById(R.id.pre_garan_ra22);
        no10 = (RadioButton)findViewById(R.id.pre_garan_ra23);
        na10 = (RadioButton)findViewById(R.id.pre_garan_ra24);
        si11 = (RadioButton)findViewById(R.id.pre_garan_ra25);
        no11 = (RadioButton)findViewById(R.id.pre_garan_ra26);
        na11 = (RadioButton)findViewById(R.id.pre_garan_ra27);
        ed1 = (EditText)findViewById(R.id.pre_garan_txt7);
        ed2 = (EditText)findViewById(R.id.pre_garan_txt8);
        ed3 = (EditText)findViewById(R.id.pre_garan_txt9);
        ed5 = (EditText)findViewById(R.id.pre_garan_txt10);
        ed6 = (EditText)findViewById(R.id.pre_garan_txt11);
        ed7 = (EditText)findViewById(R.id.pre_garan_txt12);
        ed8 = (EditText)findViewById(R.id.pre_garan_txt13);
        ed9 = (EditText)findViewById(R.id.pre_garan_txt14);
        ed10 = (EditText)findViewById(R.id.pre_garan_txt15);
        ed11 = (EditText)findViewById(R.id.pre_garan_txt16);
        ed12 = (EditText)findViewById(R.id.pre_garan_txt17);
        cuatroa = (CheckBox)findViewById(R.id.pre_garan_ch1);
        cuatrob = (CheckBox)findViewById(R.id.pre_garan_ch2);
        cuatroc = (CheckBox)findViewById(R.id.pre_garan_ch3);
        cuatrod = (CheckBox)findViewById(R.id.pre_garan_ch4);
        cincoa = (CheckBox)findViewById(R.id.pre_garan_ch5);
        cincob = (CheckBox)findViewById(R.id.pre_garan_ch6);
        cincoc = (CheckBox)findViewById(R.id.pre_garan_ch7);
        cincod = (CheckBox)findViewById(R.id.pre_garan_ch8);
        cincoe = (CheckBox)findViewById(R.id.pre_garan_ch9);
        cincof = (CheckBox)findViewById(R.id.pre_garan_ch10);
        avanzar = findViewById(R.id.pre_garan_sig);

    }

    //Metodo para extraer la fecha actual
    public void muestrafecha(){
        Calendar fecha = Calendar.getInstance();
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        mes = fecha.get(Calendar.MONTH);
        anio = fecha.get(Calendar.YEAR);
        textFecha.setText(""+dia+"/"+(mes+1)+"/"+anio);
    }

    public String obtenerResultado(RadioButton rb1, RadioButton rb2, RadioButton rb3){
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

        if(nomcentro.getText().toString().isEmpty()){
            nomcentro.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(numcentro.getText().toString().isEmpty()){
            numcentro.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(spi_edo.getSelectedItem().toString().equals("") || cveedo.equals("") || nomedo.equals("")){
            TextView errorText = (TextView)spi_edo.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(spi_mun.getSelectedItem().toString().equals("") || cvemun.equals("") || nommun.equals("")){
            TextView errorText = (TextView)spi_mun.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(localidad.getText().toString().isEmpty()){
            localidad.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(calle.getText().toString().isEmpty()){
            calle.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(cp.getText().toString().isEmpty()){
            cp.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!si.isChecked() && !no.isChecked() && !na.isChecked()){
            si.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si2.isChecked() && !no2.isChecked() && !na2.isChecked()){
            si2.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si3.isChecked() && !no3.isChecked() && !na3.isChecked()){
            si3.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if (!cuatroa.isChecked() && !cuatrob.isChecked() && !cuatroc.isChecked() && !cuatrod.isChecked()) {
            cuatroa.setError("Debes seleccionar almenos una opción");
            retorno = false;
        }
        else if (!cincoa.isChecked() && !cincob.isChecked() && !cincoc.isChecked() && !cincod.isChecked() && !cincoe.isChecked() && !cincof.isChecked()) {
            cincoa.setError("Debes seleccionar almenos una opción");
            retorno = false;
        }
        else if(cincof.isChecked() && ed5.getText().toString().isEmpty()){
            ed5.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!si6.isChecked() && !no6.isChecked() && !na6.isChecked()){
            si6.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si7.isChecked() && !no7.isChecked() && !na7.isChecked()){
            si7.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si8.isChecked() && !no8.isChecked() && !na8.isChecked()){
            si8.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si9.isChecked() && !no9.isChecked() && !na9.isChecked()){
            si9.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si10.isChecked() && !no10.isChecked() && !na10.isChecked()){
            si10.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si11.isChecked() && !no11.isChecked() && !na11.isChecked()){
            si11.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(ed12.getText().toString().isEmpty()){
            ed12.setError("No puede quedar vacio");
            retorno=false;
        }

        return retorno;
    }

    public void eventos(){
        findViewById(R.id.pre_garan_ch10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cincof.isChecked()==true){
                    ed5.setVisibility(View.VISIBLE);
                }else{
                    ed5.setVisibility(View.GONE);
                    ed5.setText("");
                }
            }
        });

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(si.isChecked()==true || na.isChecked()==true){
                    ed1.setVisibility(View.GONE);
                    ed1.setText("");
                }else{
                    ed1.setVisibility(View.VISIBLE);
                }
            }
        });

        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.rg2);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(si2.isChecked()==true || na2.isChecked()==true){
                    ed2.setVisibility(View.GONE);
                    ed2.setText("");
                }else{
                    ed2.setVisibility(View.VISIBLE);
                }
            }
        });

        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.rg3);
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(si3.isChecked()==true || na3.isChecked()==true){
                    ed3.setVisibility(View.GONE);
                    ed3.setText("");
                }else{
                    ed3.setVisibility(View.VISIBLE);
                }
            }
        });

        RadioGroup radioGroup6 = (RadioGroup) findViewById(R.id.rg6);
        radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(si6.isChecked()==true || na6.isChecked()==true){
                    ed6.setVisibility(View.GONE);
                    ed6.setText("");
                }else{
                    ed6.setVisibility(View.VISIBLE);
                }
            }
        });

        RadioGroup radioGroup7 = (RadioGroup) findViewById(R.id.rg7);
        radioGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(si7.isChecked()==true || na7.isChecked()==true){
                    ed7.setVisibility(View.GONE);
                    ed7.setText("");
                }else{
                    ed7.setVisibility(View.VISIBLE);
                }
            }
        });

        RadioGroup radioGroup8 = (RadioGroup) findViewById(R.id.rg8);
        radioGroup8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(si8.isChecked()==true || na8.isChecked()==true){
                    ed8.setVisibility(View.GONE);
                    ed8.setText("");
                }else{
                    ed8.setVisibility(View.VISIBLE);
                }
            }
        });

        RadioGroup radioGroup9 = (RadioGroup) findViewById(R.id.rg9);
        radioGroup9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(si9.isChecked()==true || na9.isChecked()==true){
                    ed9.setVisibility(View.GONE);
                    ed9.setText("");
                }else{
                    ed9.setVisibility(View.VISIBLE);
                }
            }
        });

        RadioGroup radioGroup10 = (RadioGroup) findViewById(R.id.rg10);
        radioGroup10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(si10.isChecked()==true || na10.isChecked()==true){
                    ed10.setVisibility(View.GONE);
                    ed10.setText("");
                }else{
                    ed10.setVisibility(View.VISIBLE);
                }
            }
        });

        RadioGroup radioGroup11 = (RadioGroup) findViewById(R.id.rg11);
        radioGroup11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(si11.isChecked()==true || na11.isChecked()==true){
                    ed11.setVisibility(View.GONE);
                    ed11.setText("");
                }else{
                    ed11.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {

    }

}
