package com.example.geosegalmex.PGOperativoLeche;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Georeferencia.GeoreferenciaActivity;
import com.example.geosegalmex.PGOperativoGranos.PGOperativoGranos;
import com.example.geosegalmex.PGOperativoGranos.PGOperativoGranos_Model;
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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class PGOperativoLeche extends AppCompatActivity {

    int dia, mes, anio;
    PGOperativoLeche_Model model;
    TextView textFecha;
    EditText nomcentro, numcentro, localidad, calle, cp;
    Spinner spi_edo, spi_mun;
    RadioButton si, no, si2, no2, si3, no3, si4, no4, si5, no5, si6, no6, si7, no7, si8, no8, si9, no9, si11, no11, si11b, no11b, si12, no12;
    EditText ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8, ed9, ed11, ed11b, ed12, ed13;
    CheckBox dieza, diezb, diezc, diezd, dieze, diezf;
    Button avanzar;

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
        setContentView(R.layout.activity_pgoperativo_leche);

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

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(PGOperativoLeche.this, android.R.layout.simple_spinner_item, municipios);
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

                    String uno = obtenerResultado(si, no);
                    String unoObs = ed1.getText().toString();
                    String dos = obtenerResultado(si2, no2);
                    String dosObs = ed2.getText().toString();
                    String tres = obtenerResultado(si3, no3);
                    String tresObs = ed3.getText().toString();
                    String cuatro = obtenerResultado(si4, no4);
                    String cuatroObs = ed4.getText().toString();
                    String cinco = obtenerResultado(si5, no5);
                    String cincoObs = ed5.getText().toString();
                    String seis = obtenerResultado(si6, no6);
                    String seisObs = ed6.getText().toString();
                    String siete = obtenerResultado(si7, no7);
                    String sieteObs = ed7.getText().toString();
                    String ocho = obtenerResultado(si8, no8);
                    String ochoObs = ed8.getText().toString();
                    String nueve = obtenerResultado(si9, no9);
                    String nueveObs = ed9.getText().toString();
                    String diezA = (dieza.isChecked())? "1" : "";
                    String diezB = (diezb.isChecked())? "1" : "";
                    String diezC = (diezc.isChecked())? "1" : "";
                    String diezD = (diezd.isChecked())? "1" : "";
                    String diezE = (dieze.isChecked())? "1" : "";
                    String diezF = (diezf.isChecked())? "1" : "";
                    String once = obtenerResultado(si11, no11);
                    String onceObs = ed11.getText().toString();
                    String onceb = obtenerResultado(si11b, no11b);
                    String oncebObs = ed11b.getText().toString();
                    String doce = obtenerResultado(si12, no12);
                    String doceObs = ed12.getText().toString();
                    String trece = ed13.getText().toString();
                    String f1 = General.Foto1;
                    String f2 = General.Foto2;

                    model = new PGOperativoLeche_Model(fol, General.fechaenc, cveven, nomven, cveedo, nomedo, cvemun,  nommun, "", loc, call, codp, uno, unoObs, dos, dosObs, tres, tresObs, cuatro, cuatroObs,
                            cinco, cincoObs, seis, seisObs, siete, sieteObs, ocho, ochoObs, nueve, nueveObs, diezA, diezB, diezC, diezD, diezE, diezF, once, onceObs, onceb, oncebObs, doce, doceObs, trece,
                            f1, f2, "", "");

                    Intent in = new Intent(PGOperativoLeche.this, GeoreferenciaActivity.class);
                    in.putExtra("model", model);
                    startActivity(in);
                    /*Toast.makeText(getApplicationContext(), "Folio: " + model.getFolio() + "\n Fecha: " + model.getFecha() + "\n cveven: " + model.getCveventanilla() + "\n nomven: " + model.getVentanilla()
                            + "\n CveEdo: " + model.getCveestado() + "\n Edo: " + model.getEstado() + "\n CveMun: " + model.getCvemunicipio() + "\n Mun: " + model.getMunicipio()
                            + "\n loc: " + model.getLocalidad() + "\n calle: " + model.getCalle()  + "\n Cp: " + model.getCp() + "\n Uno: " + model.getUno() + "\n UnoObs: " + model.getUnosobs()
                            + "\n Dos: " + model.getDos() + "\n DosObs: " + model.getDosobs() + "\n Tres: " + model.getTres() + "\n TresObs: " + model.getTresobs()
                            + "\n Cuatro: " + model.getCuatro() + "\n CuatroObs: " + model.getCuatroobs() + "\n Cinco: " + model.getCinco() + "\n CincoObs: " + model.getCincoobs()
                            + "\n Seis: " + model.getSeis() + "\n SeisObs: " + model.getSeisobs() + "\n Siete: " + model.getSiete() + "\n SieteObs: " + model.getSieteobs()
                            + "\n Ocho: " + model.getOcho() + "\n Ochoobs: " + model.getOchoobs() + "\n Nueve: " + model.getNueve() + "\n NueveObs: " + model.getNueveobs()
                            + "\n Dieza: " + model.getDieza() + "\n Diezb: " + model.getDiezb() + "\n Diezc: " + model.getDiezc() + "\n Diezad: " + model.getDiezd() + "\n Diezae: " + model.getDieze()
                            + "\n Diezaf: " + model.getDiezf() + "\n Once: " + model.getOnce() + "\n OnceObs: " + model.getOnceobs() + "\n Onceb: " + model.getOnceb() + "\n OncebObs: " + model.getOncebobs()
                            + "\n Doce: " + model.getDoce() + "\n DoceObs: " + model.getDoceobs() + "\n Trece: " + model.getTrece() + "\n F1: " + model.getFoto1() + "\n F2: " + model.getFoto2(),Toast.LENGTH_SHORT).show();*/
                }
                else{
                    Toast.makeText(getApplicationContext(), "Faltan respuestas",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    protected void Declaracion(){

        textFecha = (TextView)findViewById(R.id.pg_leche_txtFecha);
        nomcentro = (EditText)findViewById(R.id.pre_garan_txt3);
        numcentro = (EditText)findViewById(R.id.pre_garan_txt4);
        spi_edo = (Spinner)findViewById(R.id.pre_garan_spin1);
        spi_mun = (Spinner)findViewById(R.id.pre_garan_spin2);
        localidad = (EditText)findViewById(R.id.pg_vent_txtLocalidad);
        calle = (EditText)findViewById(R.id.pg_vent_txt5);
        cp = (EditText)findViewById(R.id.pg_vent_txt6);
        si = (RadioButton)findViewById(R.id.pg_vent_ra1);
        no = (RadioButton)findViewById(R.id.pg_vent_ra2);
        si2 = (RadioButton)findViewById(R.id.pg_vent_ra3);
        no2 = (RadioButton)findViewById(R.id.pg_vent_ra4);
        si3 = (RadioButton)findViewById(R.id.pg_vent_ra5);
        no3 = (RadioButton)findViewById(R.id.pg_vent_ra6);
        si4 = (RadioButton)findViewById(R.id.pg_vent_ra7);
        no4 = (RadioButton)findViewById(R.id.pg_vent_ra8);
        si5 = (RadioButton)findViewById(R.id.pg_vent_ra9);
        no5 = (RadioButton)findViewById(R.id.pg_vent_ra10);
        si6 = (RadioButton)findViewById(R.id.pg_vent_ra11);
        no6 = (RadioButton)findViewById(R.id.pg_vent_ra12);
        si7 = (RadioButton)findViewById(R.id.pg_vent_ra13);
        no7 = (RadioButton)findViewById(R.id.pg_vent_ra14);
        si8 = (RadioButton)findViewById(R.id.pg_vent_ra15);
        no8 = (RadioButton)findViewById(R.id.pg_vent_ra16);
        si9 = (RadioButton)findViewById(R.id.pg_vent_ra17);
        no9 = (RadioButton)findViewById(R.id.pg_vent_ra18);
        si11 = (RadioButton)findViewById(R.id.pg_vent_ra19);
        no11 = (RadioButton)findViewById(R.id.pg_vent_ra20);
        si11b = (RadioButton)findViewById(R.id.pg_vent_ra21);
        no11b = (RadioButton)findViewById(R.id.pg_vent_ra22);
        si12 = (RadioButton)findViewById(R.id.pg_vent_ra23);
        no12 = (RadioButton)findViewById(R.id.pg_vent_ra24);
        ed1 = (EditText)findViewById(R.id.pg_vent_txt7);
        ed2 = (EditText)findViewById(R.id.pg_vent_txt8);
        ed3 = (EditText)findViewById(R.id.pg_vent_txt9);
        ed4 = (EditText)findViewById(R.id.pg_vent_txt10);
        ed5 = (EditText)findViewById(R.id.pg_vent_txt11);
        ed6 = (EditText)findViewById(R.id.pg_vent_txt12);
        ed7 = (EditText)findViewById(R.id.pg_vent_txt13);
        ed8 = (EditText)findViewById(R.id.pg_vent_txt14);
        ed9 = (EditText)findViewById(R.id.pg_vent_txt15);
        ed11 = (EditText)findViewById(R.id.pg_vent_txt16);
        ed11b = (EditText)findViewById(R.id.pg_vent_txt17);
        ed12 = (EditText)findViewById(R.id.pg_vent_txt18);
        ed13 = (EditText)findViewById(R.id.pg_vent_txt19);
        dieza = (CheckBox)findViewById(R.id.pg_vent_ch1);
        diezb = (CheckBox)findViewById(R.id.pg_vent_ch2);
        diezc = (CheckBox)findViewById(R.id.pg_vent_ch3);
        diezd = (CheckBox)findViewById(R.id.pg_vent_ch4);
        dieze = (CheckBox)findViewById(R.id.pg_vent_ch5);
        diezf = (CheckBox)findViewById(R.id.pg_vent_ch6);
        avanzar = findViewById(R.id.pg_vent_sig);

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
        else if(!si.isChecked() && !no.isChecked()){
            si.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si2.isChecked() && !no2.isChecked()){
            si2.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si3.isChecked() && !no3.isChecked()){
            si3.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si4.isChecked() && !no4.isChecked()){
            si4.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si5.isChecked() && !no5.isChecked()){
            si5.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si6.isChecked() && !no6.isChecked()){
            si6.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si7.isChecked() && !no7.isChecked()){
            si7.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si8.isChecked() && !no8.isChecked()){
            si8.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si9.isChecked() && !no9.isChecked()){
            si9.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if (!dieza.isChecked() && !diezb.isChecked() && !diezc.isChecked() && !diezd.isChecked() && !dieze.isChecked() && !diezf.isChecked()) {
            dieza.setError("Debes seleccionar almenos una opción");
            retorno = false;
        }
        else if(!si11.isChecked() && !no11.isChecked()){
            si11.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si11b.isChecked() && !no11b.isChecked()){
            si11b.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si12.isChecked() && !no12.isChecked()){
            si12.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(ed13.getText().toString().isEmpty()){
            ed13.setError("No puede quedar vacio");
            retorno=false;
        }

        return retorno;
    }

    @Override
    public void onBackPressed() {

    }

}