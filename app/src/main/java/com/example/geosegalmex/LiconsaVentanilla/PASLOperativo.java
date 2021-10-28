package com.example.geosegalmex.LiconsaVentanilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Georeferencia.GeoreferenciaActivity;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

import java.util.Calendar;

public class PASLOperativo extends AppCompatActivity {

    int dia, mes, anio;
    Pasl_o_Model model;

    Button btnNext;
    TextView textFecha;
    Spinner spi_edo, spi_mun;
    EditText localidad, nombre, apaterno, amaterno, edad, años, meses, observ, obs14, quince;
    RadioButton sexo1, sexo2, si, no, si2, no2, si3, no3, si4, no4, si5, no5, si6, no6, si7, no7, si8, no8, si9, no9, si10, no10, si11, no11, si12, no12, si13, no13, si14, no14;

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
        setContentView(R.layout.activity_pasl_operativo);

        btnNext = findViewById(R.id.btn_Avanzar);

        textFecha = (TextView)findViewById(R.id.pasl_o_txtFecha);
        spi_edo = (Spinner)findViewById(R.id.pasl_o_spiEstado);
        spi_mun = (Spinner)findViewById(R.id.pasl_o_spiMunicipio);
        localidad = (EditText)findViewById(R.id.pasl_o_txtLocalidad);
        nombre = (EditText)findViewById(R.id.pasl_o_txtNombre);
        apaterno = (EditText)findViewById(R.id.pasl_o_txtApaterno);
        amaterno = (EditText)findViewById(R.id.pasl_o_txtAmaterno);
        sexo1 = (RadioButton)findViewById(R.id.pasl_o_rbHombre);
        sexo2 = (RadioButton)findViewById(R.id.pasl_o_rbMujer);
        edad = (EditText)findViewById(R.id.pasl_o_txtEdad);
        años = (EditText)findViewById(R.id.pasl_o_txtAños);
        meses = (EditText)findViewById(R.id.pasl_o_txtMeses);
        si = (RadioButton)findViewById(R.id.pasl_o_rbSi);
        no = (RadioButton)findViewById(R.id.pasl_o_rbNO);
        si2 = (RadioButton)findViewById(R.id.pasl_o_rbSi2);
        no2 = (RadioButton)findViewById(R.id.pasl_o_rbNO2);
        si3 = (RadioButton)findViewById(R.id.pasl_o_rbSi3);
        no3 = (RadioButton)findViewById(R.id.pasl_o_rbNO3);
        si4 = (RadioButton)findViewById(R.id.pasl_o_rbSi4);
        no4 = (RadioButton)findViewById(R.id.pasl_o_rbNO4);
        si5 = (RadioButton)findViewById(R.id.pasl_o_rbSi5);
        no5 = (RadioButton)findViewById(R.id.pasl_o_rbNO5);
        si6 = (RadioButton)findViewById(R.id.pasl_o_rbSi6);
        no6 = (RadioButton)findViewById(R.id.pasl_o_rbNO6);
        si7 = (RadioButton)findViewById(R.id.pasl_o_rbSi7);
        no7 = (RadioButton)findViewById(R.id.pasl_o_rbNO7);
        si8 = (RadioButton)findViewById(R.id.pasl_o_rbSi8);
        no8 = (RadioButton)findViewById(R.id.pasl_o_rbNO8);
        si9 = (RadioButton)findViewById(R.id.pasl_o_rbSi9);
        no9 = (RadioButton)findViewById(R.id.pasl_o_rbNO9);
        si10 = (RadioButton)findViewById(R.id.pasl_o_rbSi10);
        no10 = (RadioButton)findViewById(R.id.pasl_o_rbNO10);
        si11 = (RadioButton)findViewById(R.id.pasl_o_rbSi11);
        no11 = (RadioButton)findViewById(R.id.pasl_o_rbNO11);
        si12 = (RadioButton)findViewById(R.id.pasl_o_rbSi12);
        no12 = (RadioButton)findViewById(R.id.pasl_o_rbNO12);
        observ = (EditText)findViewById(R.id.pasl_o_txtObservaciones12);
        si13 = (RadioButton)findViewById(R.id.pasl_o_rbSi13);
        no13 = (RadioButton)findViewById(R.id.pasl_o_rbNO13);
        si14 = (RadioButton)findViewById(R.id.pasl_o_rbSi14);
        no14 = (RadioButton)findViewById(R.id.pasl_o_rbNO14);
        obs14 = (EditText)findViewById(R.id.pasl_o_txtObservaciones14);
        quince = (EditText)findViewById(R.id.pasl_o_txtQuince);

        muestrafecha();

        spi_edo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String[] estados = getResources().getStringArray(R.array.Estados2021);
                String[] cveestados = getResources().getStringArray(R.array.cveEstados2021);

                cveedo = cveestados[position];
                nomedo = estados[position];

                municipios = getResources().getStringArray(idmunicipios[position]);
                cvemunicipios = getResources().getStringArray(idcvemunicipios[position]);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(PASLOperativo.this, android.R.layout.simple_spinner_item, municipios);
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
                //Toast.makeText(getApplicationContext(), "cveEdo: " + cveedo + "\n Edo: " + nomedo + "\n cveMun: " + nommun + "\n Mun: " + cvemun,Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fol = General.Foliocuestion;
                General.fechaenc = textFecha.getText().toString();
                String loc = localidad.getText().toString();
                String nom = nombre.getText().toString();
                String apa = apaterno.getText().toString();
                String ama = amaterno.getText().toString();
                String sexo = obtenerResultado(sexo1, sexo2);
                String eda = edad.getText().toString();
                    String año = años.getText().toString();
                    String mes = meses.getText().toString();
                String tie = año + " años-" + mes + " meses";
                String uno = obtenerResultado(si, no);
                String dos = obtenerResultado(si2, no2);
                String tres = obtenerResultado(si3, no3);
                String cuatro = obtenerResultado(si4, no4);
                String cinco = obtenerResultado(si5, no5);
                String seis = obtenerResultado(si6, no6);
                String siete = obtenerResultado(si7, no7);
                String ocho = obtenerResultado(si8, no8);
                String nueve = obtenerResultado(si9, no9);
                String diez = obtenerResultado(si10, no10);
                String once = obtenerResultado(si11, no11);
                String doce = (!observ.getText().toString().equals(""))? obtenerResultado(si12, no12) + "-" + observ.getText().toString() : obtenerResultado(si12, no12);
                String trece = obtenerResultado(si13, no13);
                String cator = (!obs14.getText().toString().equals(""))? obtenerResultado(si14, no14) + "-" + obs14.getText().toString() : obtenerResultado(si14, no14);
                String quin = quince.getText().toString();
                String f1 = General.Foto1;
                String f2 = General.Foto2;

                if(validar()){
                    model = new Pasl_o_Model(fol, General.fechaenc, cveedo, nomedo, cvemun,  nommun, "", loc, nom, apa, ama, sexo, eda, tie, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, diez, once, doce, trece, cator, quin, f1, f2, "", "");
                    Intent in = new Intent(PASLOperativo.this, GeoreferenciaActivity.class);
                    in.putExtra("model", model);
                    startActivity(in);
                    /*Toast.makeText(getApplicationContext(), "Folio: " + model.getFolio() + "\n Fecha: " + model.getFecha() + "\n CveEdo: " + model.getCveestado() + "\n Edo: " + model.getEstado()
                            + "\n CveMun: " + model.getCvemunicipio() + "\n Mun: " + model.getMunicipio() + "\n Nombre: " + model.getNombre() + "\n Apaterno: " + model.getApaterno()
                            + "\n Amaterno: " + model.getAmaterno() + "\n Sexo: " + model.getSexo()  + "\n Edad: " + model.getEdad()  + "\n Tiempo: " + model.getTiempo()
                            + "\n Uno: " + model.getUno() + "\n Dos: " + model.getDos() + "\n Tres: " + model.getTres() + "\n Cuatro: " + model.getCuatro() + "\n Cinco: " + model.getCinco()
                            + "\n Seis: " + model.getSeis() + "\n Siete: " + model.getSiete() + "\n Ocho: " + model.getOcho() + "\n Nueve: " + model.getNueve()
                            + "\n Diez: " + model.getDiez() + "\n Once: " + model.getOnce() + "\n Doce: " + model.getDoce() + "\n Trece: " + model.getTrece() + "\n Catorce: " + model.getCatorce() +  "\n Quince: " + model.getQuince(),Toast.LENGTH_SHORT).show();*/
                }
                else{
                    Toast.makeText(getApplicationContext(), "Faltan respuestas",Toast.LENGTH_SHORT).show();
                }
            }
        });

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.pasl_o_rg12);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(si12.isChecked()==true){
                    observ.setVisibility(View.VISIBLE);
                }else{
                    observ.setVisibility(View.GONE);
                    observ.setText("");
                }
            }
        });

        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.pasl_o_rg14);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(si14.isChecked()==true){
                    obs14.setVisibility(View.VISIBLE);
                }else{
                    obs14.setVisibility(View.GONE);
                    obs14.setText("");
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

        if(spi_edo.getSelectedItem().toString().equals("") || cveedo.equals("") || nomedo.equals("")){
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
        else if(nombre.getText().toString().isEmpty()){
            nombre.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(apaterno.getText().toString().isEmpty()){
            apaterno.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(amaterno.getText().toString().isEmpty()){
            amaterno.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(edad.getText().toString().isEmpty()){
            edad.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(Float.parseFloat(edad.getText().toString()) > 100){
            edad.setError("No es un rango aceptable");
            retorno=false;
        }
        else if(Float.parseFloat(edad.getText().toString()) < 10){
            edad.setError("No es un rango aceptable");
            retorno=false;
        }
        else if(años.getText().toString().isEmpty()){
            años.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(meses.getText().toString().isEmpty()){
            meses.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(Float.parseFloat(meses.getText().toString()) < 0){
            meses.setError("No es un rango aceptable");
            retorno=false;
        }
        else if(Float.parseFloat(meses.getText().toString()) > 12){
            meses.setError("No es un rango aceptable");
            retorno=false;
        }
        else if(!sexo1.isChecked() && !sexo2.isChecked()){
            sexo1.setError("Debes seleccionar una opción");
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
        else if(!si10.isChecked() && !no10.isChecked()){
            si11.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si11.isChecked() && !no11.isChecked()){
            si11.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si12.isChecked() && !no12.isChecked()){
            si12.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si13.isChecked() && !no13.isChecked()){
            si13.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(si12.isChecked() && observ.getText().toString().isEmpty()){
            observ.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(si12.isChecked() && Float.parseFloat(observ.getText().toString()) > 100){
            observ.setError("El precio no puede ser mayor a $100.00 pesos");
            retorno=false;
        }


        else if(!si14.isChecked() && !no14.isChecked()){
            si14.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(si14.isChecked() && obs14.getText().toString().isEmpty()){
            obs14.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(quince.getText().toString().isEmpty()){
            quince.setError("No puede quedar vacio");
            retorno=false;
        }

        return retorno;
    }

    @Override
    public void onBackPressed() {

    }



}