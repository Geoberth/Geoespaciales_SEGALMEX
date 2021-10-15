package com.example.geosegalmex.LiconsaBeneficiario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Georeferencia.GeoreferenciaActivity;
import com.example.geosegalmex.LiconsaVentanilla.PASLOperativo;
import com.example.geosegalmex.LiconsaVentanilla.Pasl_o_Model;
import com.example.geosegalmex.R;

public class PASLBeneficiario extends AppCompatActivity {

    Spinner responde;
    CheckBox beneficiarioa, beneficiariob, beneficiarioc, beneficiariod, beneficiarioe, beneficiariof;
    RadioButton bueno, aceptable, malo, bueno2, aceptable2, malo2, bueno3, aceptable3, malo3,bueno4, aceptable4, malo4,bueno5, aceptable5, malo5,bueno6, aceptable6, malo6,bueno7, aceptable7, malo7;
    RadioButton bueno8, aceptable8, malo8, bueno9, aceptable9, malo9, bueno10, aceptable10, malo10, bueno11, aceptable11, malo11,bueno12, aceptable12, malo12,bueno13, aceptable13, malo13,bueno14, aceptable14, malo14;
    CheckBox quincea, quinceb, quincec, quinced;
    EditText quinceotras, quince, dieciseis, diecisiete,  cuatrocom, cincocom, seiscom, sietecom, ochocom, nuevecom, diezcom, oncecom, docecom, trececom, catorcecom;
    Button btnNext;

    Pasl_b_Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paslbeneficiario);

        responde = (Spinner)findViewById(R.id.paslb_spin1);

        beneficiarioa = (CheckBox)findViewById(R.id.paslb_ch1);
        beneficiariob = (CheckBox)findViewById(R.id.paslb_ch2);
        beneficiarioc = (CheckBox)findViewById(R.id.paslb_ch3);
        beneficiariod = (CheckBox)findViewById(R.id.paslb_ch4);
        beneficiarioe = (CheckBox)findViewById(R.id.paslb_ch5);
        beneficiariof = (CheckBox)findViewById(R.id.paslb_ch6);

        bueno = (RadioButton)findViewById(R.id.paslb_ra1);
        aceptable = (RadioButton)findViewById(R.id.paslb_ra2);
        malo = (RadioButton)findViewById(R.id.paslb_ra3);

        bueno2 = (RadioButton)findViewById(R.id.paslb_ra4);
        aceptable2 = (RadioButton)findViewById(R.id.paslb_ra5);
        malo2 = (RadioButton)findViewById(R.id.paslb_ra6);

        bueno3 = (RadioButton)findViewById(R.id.paslb_ra7);
        aceptable3 = (RadioButton)findViewById(R.id.paslb_ra8);
        malo3 = (RadioButton)findViewById(R.id.paslb_ra9);

        bueno4 = (RadioButton)findViewById(R.id.paslb_ra10);
        aceptable4 = (RadioButton)findViewById(R.id.paslb_ra11);
        malo4 = (RadioButton)findViewById(R.id.paslb_ra12);

        bueno5 = (RadioButton)findViewById(R.id.paslb_ra13);
        aceptable5 = (RadioButton)findViewById(R.id.paslb_ra14);
        malo5 = (RadioButton)findViewById(R.id.paslb_ra15);

        bueno6 = (RadioButton)findViewById(R.id.paslb_ra16);
        aceptable6 = (RadioButton)findViewById(R.id.paslb_ra17);
        malo6 = (RadioButton)findViewById(R.id.paslb_ra18);

        bueno7 = (RadioButton)findViewById(R.id.paslb_ra19);
        aceptable7 = (RadioButton)findViewById(R.id.paslb_ra20);
        malo7 = (RadioButton)findViewById(R.id.paslb_ra21);

        bueno8 = (RadioButton)findViewById(R.id.paslb_ra81);
        aceptable8 = (RadioButton)findViewById(R.id.paslb_ra82);


        bueno9 = (RadioButton)findViewById(R.id.paslb_ra22);
        aceptable9 = (RadioButton)findViewById(R.id.paslb_ra23);
        malo9 = (RadioButton)findViewById(R.id.paslb_ra27);

        bueno10 = (RadioButton)findViewById(R.id.paslb_ra25);
        aceptable10 = (RadioButton)findViewById(R.id.paslb_ra26);
        malo10 = (RadioButton)findViewById(R.id.paslb_ra30);

        bueno11 = (RadioButton)findViewById(R.id.paslb_ra28);
        aceptable11 = (RadioButton)findViewById(R.id.paslb_ra29);
        malo11 = (RadioButton)findViewById(R.id.paslb_ra33);

        bueno12 = (RadioButton)findViewById(R.id.paslb_ra31);
        aceptable12 = (RadioButton)findViewById(R.id.paslb_ra32);
        malo12 = (RadioButton)findViewById(R.id.paslb_ra36);

        bueno13 = (RadioButton)findViewById(R.id.paslb_ra34);
        aceptable13 = (RadioButton)findViewById(R.id.paslb_ra35);
        malo13 = (RadioButton)findViewById(R.id.paslb_ra39);

        bueno14 = (RadioButton)findViewById(R.id.paslb_ra37);
        aceptable14 = (RadioButton)findViewById(R.id.paslb_ra38);
        malo14 = (RadioButton)findViewById(R.id.paslb_ra39);

        quincea = (CheckBox)findViewById(R.id.paslb_ch9);
        quinceb = (CheckBox)findViewById(R.id.paslb_ch7);
        quincec = (CheckBox)findViewById(R.id.paslb_ch8);
        quinced = (CheckBox)findViewById(R.id.paslb_ch10);

        quinceotras = (EditText)findViewById(R.id.paslb_txtotras);
        dieciseis = (EditText)findViewById(R.id.paslb_txt1);
        diecisiete = (EditText)findViewById(R.id.paslb_txt2);
        cuatrocom = (EditText)findViewById(R.id.paslb_txt4);
        cincocom = (EditText)findViewById(R.id.paslb_txt5);
        seiscom = (EditText)findViewById(R.id.paslb_txt6);
        sietecom = (EditText)findViewById(R.id.paslb_txt7);
        ochocom = (EditText)findViewById(R.id.paslb_txt8);
        nuevecom = (EditText)findViewById(R.id.paslb_txt9);
        diezcom = (EditText)findViewById(R.id.paslb_txt10);
        oncecom = (EditText)findViewById(R.id.paslb_txt11);
        docecom = (EditText)findViewById(R.id.paslb_txt12);
        trececom = (EditText)findViewById(R.id.paslb_txt13);
        catorcecom = (EditText)findViewById(R.id.paslb_txt14);


        btnNext = findViewById(R.id.paslb_sig);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validar()){
                    String fol = General.Foliocuestion;
                    String res = responde.getSelectedItem().toString();
                    String bene = Resultado();
                    String uno = obtenerRadio(bueno,aceptable,malo);
                    String dos = obtenerRadio(bueno2,aceptable2,malo2);
                    String tres = obtenerRadio(bueno3,aceptable3,malo3);
                    String cuatro = obtenerRadio(bueno4,aceptable4,malo4);
                    String cinco = obtenerRadio(bueno5,aceptable5,malo5);
                    String seis = obtenerRadio(bueno6,aceptable6,malo6);
                    String siete = obtenerRadio(bueno7,aceptable7,malo7);
                    String ocho = obtenerRadio(bueno8,aceptable8,malo8);
                    String nueve = obtenerRadio(bueno9,aceptable9,malo9);
                    String diez = obtenerRadio(bueno10,aceptable10,malo10);
                    String once = obtenerRadio(bueno11,aceptable11,malo11);
                    String doce = obtenerRadio(bueno12,aceptable12,malo12);
                    String trece = obtenerRadio(bueno13,aceptable13,malo13);
                    String catorce = obtenerRadio(bueno14,aceptable14,malo14);
                    String quince = Resultado4();
                    String quinceco = quinceotras.getText().toString();
                    String dieciseiss = dieciseis.getText().toString();
                    String diecisietes = diecisiete.getText().toString();
                    String f1 = General.Foto1;
                    String f2 = General.Foto2;
                    String cuatroco = cuatrocom.getText().toString();
                    String cincoco = cincocom.getText().toString();
                    String seisco = seiscom.getText().toString();
                    String sieteco = sietecom.getText().toString();
                    String ochoco = ochocom.getText().toString();
                    String nueveco = nuevecom.getText().toString();
                    String diezco = diezcom.getText().toString();
                    String onceco = oncecom.getText().toString();
                    String doceco = docecom.getText().toString();
                    String trececo = trececom.getText().toString();
                    String catorceco = catorcecom.getText().toString();




                    model = new Pasl_b_Model(fol, res, bene, uno, dos, tres, cuatro, cuatroco, cinco, cincoco, seis, seisco, siete, sieteco, ocho, ochoco, nueve, nueveco, diez, diezco, once, onceco, doce, doceco, trece, trececo, catorce, catorceco, quince, quinceco, dieciseiss, diecisietes, f1, f2, "", "");
                    Intent in = new Intent(PASLBeneficiario.this, GeoreferenciaActivity.class);
                    in.putExtra("model", model);
                    startActivity(in);

                    /*Toast.makeText(getApplicationContext(), "" + model.getResponde() + "\n" + model.getBeneficiarios() + "\n" + model.getUno() + "\n" + model.getDos() + "\n" + model.getTres()
                            + "\n" + model.getCuatro() + "\n" + model.getCinco() + "\n" + model.getSeis() + "\n" + model.getSiete() + "\n" + model.getOcho() + "\n" + model.getNueve()
                            + "\n" + model.getDiez() + "\n" + model.getOnce() + "\n" + model.getDoce() + "\n" + model.getTrece() + "\n" + model.getCatorce() + "\n" + model.getCatorceotrasespecificacion()
                            + "\n" + model.getQuince() + "\n" + model.getDieciseis(), Toast.LENGTH_SHORT).show();*/
                }

            }
        });

        findViewById(R.id.paslb_ch10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quinced.isChecked()==true){
                    quinceotras.setVisibility(View.VISIBLE);
                }else{
                    quinceotras.setVisibility(View.GONE);
                    quinceotras.setText("");
                }
            }
        });


    }

    public String Resultado(){
        String cadena="";
        String resultado="";
        if (beneficiarioa.isChecked()){
            cadena += "a-";
        }
        if (beneficiariob.isChecked()){
            cadena += "b-";
        }
        if (beneficiarioc.isChecked()){
            cadena += "c-";
        }
        if (beneficiariod.isChecked()){
            cadena += "d-";
        }
        if (beneficiarioe.isChecked()){
            cadena += "e-";
        }
        if (beneficiariof.isChecked()){
            cadena += "f-";
        }
        resultado = cadena.substring(0, cadena.length()-1);
        return resultado;
    }

    public String obtenerRadio(RadioButton rb1, RadioButton rb2, RadioButton rb3){
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

    public String Resultado4(){
        String cadena="";
        String resultado="";
        if (quincea.isChecked()){
            cadena += "a-";
        }
        if (quinceb.isChecked()){
            cadena += "b-";
        }
        if (quincec.isChecked()){
            cadena += "c-";
        }
        if (quinced.isChecked()){
            cadena += "d-";
        }
        resultado = cadena.substring(0, cadena.length()-1);
        return resultado;
    }

    public boolean validar() {
        boolean retorno = true;

        if (responde.getSelectedItem().toString().equals("")) {
            TextView errorText = (TextView) responde.getSelectedView();
            errorText.setError("No puede quedar vacio");
            errorText.setTextColor(Color.RED);
            errorText.setText("No puede quedar vacio");
            retorno = false;
        }
        else if (!beneficiarioa.isChecked() && !beneficiariob.isChecked() && !beneficiarioc.isChecked() && !beneficiariod.isChecked() && !beneficiarioe.isChecked() && !beneficiariof.isChecked()) {
            beneficiarioa.setError("Debes seleccionar almenos una opción");
            retorno = false;
        }
        else if (!bueno.isChecked() && !aceptable.isChecked() && !malo.isChecked()) {
            malo.setError("Debes seleccionar una opción");
            retorno = false;
        }
        else if (!bueno2.isChecked() && !aceptable2.isChecked() && !malo2.isChecked()) {
            malo2.setError("Debes seleccionar una opción");
            retorno = false;
        }
        else if (!bueno3.isChecked() && !aceptable3.isChecked() && !malo3.isChecked()) {
            malo3.setError("Debes seleccionar una opción");
            retorno = false;
        }
        else if (!bueno4.isChecked() && !aceptable4.isChecked() && !malo4.isChecked()) {
            malo4.setError("Debes seleccionar una opción");
            retorno = false;
        }
        else if (!bueno5.isChecked() && !aceptable5.isChecked() && !malo5.isChecked()) {
            malo5.setError("Debes seleccionar una opción");
            retorno = false;
        }
        else if (!bueno6.isChecked() && !aceptable6.isChecked() && !malo6.isChecked()) {
            malo6.setError("Debes seleccionar una opción");
            retorno = false;
        }
        else if (!bueno7.isChecked() && !aceptable7.isChecked() && !malo7.isChecked()) {
            malo7.setError("Debes seleccionar una opción");
            retorno = false;
        }
        else if (!bueno8.isChecked() && !aceptable8.isChecked() && !malo8.isChecked()) {
            malo8.setError("Debes seleccionar una opción");
            retorno = false;
        }
        else if (!bueno9.isChecked() && !aceptable9.isChecked() && !malo9.isChecked()) {
            malo9.setError("Debes seleccionar una opción");
            retorno = false;
        }
        else if (!bueno10.isChecked() && !aceptable10.isChecked() && !malo10.isChecked()) {
            malo10.setError("Debes seleccionar una opción");
            retorno = false;
        }
        else if (!bueno11.isChecked() && !aceptable11.isChecked() && !malo11.isChecked()) {
            malo11.setError("Debes seleccionar una opción");
            retorno = false;
        }
        else if (!bueno12.isChecked() && !aceptable12.isChecked() && !malo12.isChecked()) {
            malo12.setError("Debes seleccionar una opción");
            retorno = false;
        }
        else if (!bueno13.isChecked() && !aceptable13.isChecked() && !malo13.isChecked()) {
            malo13.setError("Debes seleccionar una opción");
            retorno = false;
        }
        else if (!quincea.isChecked() && !quinceb.isChecked() && !quincec.isChecked() && !quinced.isChecked()) {
            quincea.setError("Debes seleccionar almenos una opción");
            retorno = false;
        }
        else if (quinced.isChecked() && quinceotras.getText().toString().isEmpty()) {
            quinceotras.setError("No puede quedar vacio");
            retorno = false;
        }
        else if (dieciseis.getText().toString().isEmpty()) {
            dieciseis.setError("No puede quedar vacio");
            retorno = false;
        }
        else if (diecisiete.getText().toString().isEmpty()) {
            diecisiete.setError("No puede quedar vacio");
            retorno = false;
        }

        return retorno;
    }

    @Override
    public void onBackPressed() {

    }

}
