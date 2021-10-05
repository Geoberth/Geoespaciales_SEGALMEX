package com.example.geosegalmex.LiconsaVentanilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
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
    EditText localidad, nombre, apaterno, amaterno, edad, años, meses, observ;
    RadioButton sexo1, sexo2, si, no, si2, no2, si3, no3, si4, no4, si5, no5, si6, no6, si7, no7, si8, no8, si9, no9, si10, no10, si11, no11, si12, no12, si13, no13;

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

        muestrafecha();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fol = General.Foliocuestion;
                General.fechaenc = textFecha.getText().toString();
                String edo = spi_edo.getSelectedItem().toString();
                String mun = spi_mun.getSelectedItem().toString();
                String loc = localidad.getText().toString();
                String nom = nombre.getText().toString();
                String apa = apaterno.getText().toString();
                String ama = amaterno.getText().toString();
                String sexo = obtenerResultado(sexo1, sexo2);
                String eda = edad.getText().toString();
                    String año = años.getText().toString();
                    String mes = meses.getText().toString();
                String tie = año + " años, " + mes + " meses";
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
                String doce = obtenerResultado(si12, no12);
                String doce_observ = observ.getText().toString();
                String trece = obtenerResultado(si13, no13);
                String f1 = General.Foto1;
                String f2 = General.Foto2;

                if(validar()){
                    model = new Pasl_o_Model(fol, General.fechaenc, edo, mun, loc, nom, apa, ama, sexo, eda, tie, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, diez, once, doce, doce_observ, trece, f1, f2, "", "");
                    //addCuestionario(model);
                    Intent in = new Intent(PASLOperativo.this, GeoreferenciaActivity.class);
                    in.putExtra("model", model);
                    startActivity(in);
                    /*Toast.makeText(getApplicationContext(), "Folio: " + model.getFolio() + "\n Fecha: " + model.getFecha() + "\n Nombre: " + model.getNombre() + "\n Apaterno: " + model.getApaterno()
                            + "\n Amaterno: " + model.getAmaterno() + "\n Sexo: " + model.getSexo()  + "\n Edad: " + model.getEdad()  + "\n Tiempo: " + model.getTiempo()
                            + "\n Uno: " + model.getUno() + "\n Dos: " + model.getDos() + "\n Tres: " + model.getTres() + "\n Cuatro: " + model.getCuatro() + "\n Cinco: " + model.getCinco()
                            + "\n Seis: " + model.getSeis() + "\n Siete: " + model.getSiete() + "\n Ocho: " + model.getOcho() + "\n Nueve: " + model.getNueve()
                            + "\n Diez: " + model.getDiez() + "\n Once: " + model.getOnce() + "\n Doce: " + model.getDoce() + "\n Doce_Obs: " + model.getDoce_bservaciones() + "\n Trece: " + model.getTrece(),Toast.LENGTH_SHORT).show();*/
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

        if(localidad.getText().toString().isEmpty()){
            localidad.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(spi_edo.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spi_edo.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno=false;
        }
        else if(spi_mun.getSelectedItem().toString().equals("")){
            TextView errorText = (TextView)spi_mun.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
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
        else if(años.getText().toString().isEmpty()){
            años.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(meses.getText().toString().isEmpty()){
            meses.setError("No puede quedar vacio");
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

        return retorno;
    }


}