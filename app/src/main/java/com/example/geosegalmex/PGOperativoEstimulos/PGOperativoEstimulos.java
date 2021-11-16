package com.example.geosegalmex.PGOperativoEstimulos;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Georeferencia.GeoreferenciaActivity;
import com.example.geosegalmex.LiconsaVentanilla.PASLOperativo;
import com.example.geosegalmex.LiconsaVentanilla.Pasl_o_Model;
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

public class PGOperativoEstimulos extends AppCompatActivity {

    int dia, mes, anio;
    PGOperativoEstimulos_Model model;
    TextView textFecha;
    EditText nomcentro, numcentro, localidad, calle, cp;
    Spinner spi_edo, spi_mun;
    RadioButton si, no, na, si2, no2, na2, si3, no3, na3, si4, no4, na4, si5, no5, na5, si6, no6, na6, si8, no8, na8, si9, no9, na9;
    CheckBox sietea, sieteb, sietec, sieted, sietee, sietef;
    Button btn_Avanzar;

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
        setContentView(R.layout.activity_pgoperativo_estimulos);

        textFecha = (TextView)findViewById(R.id.pasl_o_txtFecha);
        nomcentro = (EditText)findViewById(R.id.pg_granos_txtnombrecentro);
        numcentro = (EditText)findViewById(R.id.pg_granos_txtnumcentro);
        spi_edo = (Spinner)findViewById(R.id.pg_granos_spiEstado);
        spi_mun = (Spinner)findViewById(R.id.pg_granos_spiMunicipio);
        localidad = (EditText)findViewById(R.id.pg_granos_txtLocalidad);
        calle = (EditText)findViewById(R.id.pg_granos_txtCalle);
        cp = (EditText)findViewById(R.id.pg_granos_txtCP);
        si = (RadioButton)findViewById(R.id.pg_granos_rbSi);
        no = (RadioButton)findViewById(R.id.pg_granos_rbNO);
        na = (RadioButton)findViewById(R.id.pg_granos_rbNa);
        si2 = (RadioButton)findViewById(R.id.pg_granos_rbSi2);
        no2 = (RadioButton)findViewById(R.id.pg_granos_rbNO2);
        na2 = (RadioButton)findViewById(R.id.pg_granos_rbNa2);
        si3 = (RadioButton)findViewById(R.id.pg_granos_rbSi3);
        no3 = (RadioButton)findViewById(R.id.pg_granos_rbNO3);
        na3 = (RadioButton)findViewById(R.id.pg_granos_rbNa3);
        si4 = (RadioButton)findViewById(R.id.pg_granos_rbSi4);
        no4 = (RadioButton)findViewById(R.id.pg_granos_rbNO4);
        na4 = (RadioButton)findViewById(R.id.pg_granos_rbNa4);
        si5 = (RadioButton)findViewById(R.id.pg_granos_rbSi5);
        no5 = (RadioButton)findViewById(R.id.pg_granos_rbNO5);
        na5 = (RadioButton)findViewById(R.id.pg_granos_rbNa5);
        si6 = (RadioButton)findViewById(R.id.pg_granos_rbSi6);
        no6 = (RadioButton)findViewById(R.id.pg_granos_rbNO6);
        na6 = (RadioButton)findViewById(R.id.pg_granos_rbNa6);
        si8 = (RadioButton)findViewById(R.id.pg_granos_rbSi8);
        no8 = (RadioButton)findViewById(R.id.pg_granos_rbNO8);
        na8 = (RadioButton)findViewById(R.id.pg_granos_rbNa8);
        si9 = (RadioButton)findViewById(R.id.pg_granos_rbSi9);
        no9 = (RadioButton)findViewById(R.id.pg_granos_rbNO9);
        na9 = (RadioButton)findViewById(R.id.pg_granos_rbNa9);
        sietea = (CheckBox)findViewById(R.id.pg_granos_ch1);
        sieteb = (CheckBox)findViewById(R.id.pg_granos_ch2);
        sietec = (CheckBox)findViewById(R.id.pg_granos_ch3);
        sieted = (CheckBox)findViewById(R.id.pg_granos_ch4);
        sietee = (CheckBox)findViewById(R.id.pg_granos_ch5);
        sietef = (CheckBox)findViewById(R.id.pg_granos_ch6);
        btn_Avanzar = findViewById(R.id.btn_Avanzar);

        muestrafecha();

        spi_edo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String[] estados = getResources().getStringArray(R.array.Estados2021);
                String[] cveestados = getResources().getStringArray(R.array.cveEstados2021);

                cveedo = cveestados[position];
                nomedo = estados[position];

                municipios = getResources().getStringArray(idmunicipios[position]);
                cvemunicipios = getResources().getStringArray(idcvemunicipios[position]);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(PGOperativoEstimulos.this, android.R.layout.simple_spinner_item, municipios);
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

        btn_Avanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validar()){

                    String fol = General.Foliocuestion;
                    General.fechaenc = textFecha.getText().toString();
                    String nomven = nomcentro.getText().toString();
                    //String cveven = numcentro.getText().toString();
                    String loc = localidad.getText().toString();
                    String call = calle.getText().toString();
                    String codp = cp.getText().toString();
                    String uno = obtenerResultado(si, no, na);
                    String dos = obtenerResultado(si2, no2, na2);
                    String tres = obtenerResultado(si3, no3, na3);
                    String cuatro = obtenerResultado(si4, no4, na4);
                    String cinco = obtenerResultado(si5, no5, na5);
                    String seis = obtenerResultado(si6, no6, na6);
                    String siete = Resultado();
                    //String ocho = obtenerResultado(si8, no8, na8);
                    String nueve = obtenerResultado(si9, no9, na9);
                    String f1 = General.Foto1;
                    String f2 = General.Foto2;

                    model = new PGOperativoEstimulos_Model(fol, General.fechaenc, nomven, cveedo, nomedo, cvemun,  nommun, "", loc, call, codp, uno, dos, tres, cuatro, cinco, seis, siete, nueve, f1, f2, "", "");
                    Intent in = new Intent(PGOperativoEstimulos.this, GeoreferenciaActivity.class);
                    in.putExtra("model", model);
                    startActivity(in);
                    /*Toast.makeText(getApplicationContext(), "Folio: " + model.getFolio() + "\n Fecha: " + model.getFecha() + "\n cveven: " + model.getCveventanilla() + "\n nomven: " + model.getVentanilla()
                            + "\n CveEdo: " + model.getCveestado() + "\n Edo: " + model.getEstado() + "\n CveMun: " + model.getCvemunicipio() + "\n Mun: " + model.getMunicipio()
                            + "\n loc: " + model.getLocalidad() + "\n calle: " + model.getCalle()  + "\n Cp: " + model.getCp() + "\n Uno: " + model.getUno() + "\n Dos: " + model.getDos()
                            + "\n Tres: " + model.getTres() + "\n Cuatro: " + model.getCuatro() + "\n Cinco: " + model.getCinco() + "\n Seis: " + model.getSeis() + "\n Siete: " + model.getSiete()
                            + "\n Ocho: " + model.getOcho() + "\n Nueve: " + model.getNueve() + "\n F1: " + model.getFoto1() + "\n F2: " + model.getFoto2(),Toast.LENGTH_SHORT).show();*/
                }
                else{
                    Toast.makeText(getApplicationContext(), "Faltan respuestas",Toast.LENGTH_SHORT).show();
                }
            }
        });


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

    public String Resultado(){
        String cadena="";
        String resultado="";
        if (sietea.isChecked()){
            cadena += "a-";
        }
        if (sieteb.isChecked()){
            cadena += "b-";
        }
        if (sietec.isChecked()){
            cadena += "c-";
        }
        if (sieted.isChecked()){
            cadena += "d-";
        }
        if (sietee.isChecked()){
            cadena += "e-";
        }
        if (sietef.isChecked()){
            cadena += "f-";
        }
        resultado = cadena.substring(0, cadena.length()-1);
        return resultado;
    }

    public boolean validar(){
        boolean retorno=true;

        if(nomcentro.getText().toString().isEmpty()){
            nomcentro.setError("No puede quedar vacio");
            retorno=false;
        }
        /*
        else if(numcentro.getText().toString().isEmpty()){
            numcentro.setError("No puede quedar vacio");
            retorno=false;
        }
        */
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
            si.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si3.isChecked() && !no3.isChecked() && !na3.isChecked()){
            si.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si4.isChecked() && !no4.isChecked() && !na4.isChecked()){
            si.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si5.isChecked() && !no5.isChecked() && !na5.isChecked()){
            si.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si6.isChecked() && !no6.isChecked() && !na6.isChecked()){
            si.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if (!sietea.isChecked() && !sieteb.isChecked() && !sietec.isChecked() && !sieted.isChecked() && !sietee.isChecked() && !sietef.isChecked()) {
            sietea.setError("Debes seleccionar almenos una opción");
            retorno = false;
        }
        /*
        else if(!si8.isChecked() && !no8.isChecked() && !na8.isChecked()){
            si.setError("Debes seleccionar una opción");
            retorno=false;
        }
         */
        else if(!si9.isChecked() && !no9.isChecked() && !na9.isChecked()){
            si9.setError("Debes seleccionar una opción");
            retorno=false;
        }

        return retorno;
    }

    @Override
    public void onBackPressed() {

    }

}