package com.example.geosegalmex.Liconsa2;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Georeferencia.GeoreferenciaActivity;
import com.example.geosegalmex.Liconsa.Liconsa;
import com.example.geosegalmex.Liconsa.Liconsa_Model;
import com.example.geosegalmex.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LiconsaVerificacion extends AppCompatActivity {
    EditText ernplpt1, ernplpt2, ernplpt3, ernplpt4, et3, et8, et9, et11, et12, et13;
    RadioButton p21a, p21b, sia, sib, noa, nob, si1, no1, si2, no2, si3, no3, si4, no4, a4, b4, c4, si5, no5, si6, no6, si7, no7, si8, no8, si9, no9, a10, b10, c10;
    Button btnSiguiente;

    LiconsaVerificacion_Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liconsa_verificacion);

        Declaracion();
        Eventos();
        noa.setVisibility(View.GONE);
        nob.setVisibility(View.GONE);
        sia.setVisibility(View.GONE);
        sib.setVisibility(View.GONE);
        et3.setVisibility(View.GONE);
        a4.setVisibility(View.GONE);
        b4.setVisibility(View.GONE);
        c4.setVisibility(View.GONE);
        et8.setVisibility(View.GONE);
        et9.setVisibility(View.GONE);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validar()){
                    String fol = General.Foliocuestion;
                    String nom = ernplpt1.getText().toString();
                    String app= ernplpt2.getText().toString();
                    String apm = ernplpt3.getText().toString();
                    String p21 = obtenerResultado(p21a, p21b);
                    String p21cual = (p21a.isChecked()==true)? obtenerResultado(sia, sib) : obtenerResultado(noa, nob) ;
                    String p22rfc = obtenerResultado(si1, no1);
                    String p22curp = obtenerResultado(si2, no2);
                    String p22clabe = obtenerResultado(si3, no3);
                    String clabe = (si3.isChecked()==true)? et3.getText().toString() : "" ;
                    String p22dom = obtenerResultado(si4, no4);
                    String dom = (si4.isChecked()==true)? obtenerResultado3(a4, b4, c4) : "" ;
                    String p22art50 = obtenerResultado(si5, no5);
                    String p22art32 = obtenerResultado(si6, no6);
                    String p22carta = obtenerResultado(si7, no7);
                    String p22cod = obtenerResultado(si8, no8);
                    String cod = (si8.isChecked()==true)? et8.getText().toString() : "" ;
                    String p22ger = obtenerResultado(si9, no9);
                    String ger = (si9.isChecked()==true)? et9.getText().toString() : "" ;
                    String productor = obtenerResultado3(a10, b10, c10);
                    String nomproductor = et11.getText().toString();
                    String tipoproductor = et12.getText().toString();
                    String obs = et13.getText().toString();

                    model = new LiconsaVerificacion_Model(fol,nom,app,apm,p21,p21cual,p22rfc,p22curp,p22clabe,clabe,p22dom,dom,p22art50,p22art32,p22carta,p22cod,cod,p22ger,ger,productor,nomproductor,tipoproductor,obs, "", "");

                    Intent in = new Intent(LiconsaVerificacion.this, GeoreferenciaActivity.class);
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
        ernplpt1 = (EditText)findViewById(R.id.ernpl_prod_txt1);
        ernplpt2 = (EditText)findViewById(R.id.ernpl_prod_txt2);
        ernplpt3 = (EditText)findViewById(R.id.ernpl_prod_txt3);
        ernplpt4 = (EditText)findViewById(R.id.ernpl_prod_txt4);

        p21a = (RadioButton)findViewById(R.id.par_ben_ra4);
        p21b = (RadioButton)findViewById(R.id.par_ben_ra5);

        sia = (RadioButton)findViewById(R.id.par_ben_ra6);
        sib = (RadioButton)findViewById(R.id.par_ben_ra7);

        noa = (RadioButton)findViewById(R.id.par_ben_ra8);
        nob = (RadioButton)findViewById(R.id.par_ben_ra9);

        si1 = (RadioButton)findViewById(R.id.par_ben_ra10);
        no1 = (RadioButton)findViewById(R.id.par_ben_ra11);

        si2 = (RadioButton)findViewById(R.id.par_ben_ra12);
        no2 = (RadioButton)findViewById(R.id.par_ben_ra13);

        si3 = (RadioButton)findViewById(R.id.par_ben_ra14);
        no3 = (RadioButton)findViewById(R.id.par_ben_ra15);
        et3 = (EditText)findViewById(R.id.ernpl_prod_txt12);

        si4 = (RadioButton)findViewById(R.id.par_ben_ra16);
        no4 = (RadioButton)findViewById(R.id.par_ben_ra17);

        a4 = (RadioButton)findViewById(R.id.par_ben_ra18);
        b4 = (RadioButton)findViewById(R.id.par_ben_ra19);
        c4 = (RadioButton)findViewById(R.id.par_ben_ra20);

        si5 = (RadioButton)findViewById(R.id.par_ben_ra21);
        no5 = (RadioButton)findViewById(R.id.par_ben_ra22);

        si6 = (RadioButton)findViewById(R.id.par_ben_ra23);
        no6 = (RadioButton)findViewById(R.id.par_ben_ra24);

        si7 = (RadioButton)findViewById(R.id.par_ben_ra25);
        no7 = (RadioButton)findViewById(R.id.par_ben_ra26);

        si8 = (RadioButton)findViewById(R.id.par_ben_ra27);
        no8 = (RadioButton)findViewById(R.id.par_ben_ra28);
        et8 = (EditText)findViewById(R.id.ernpl_prod_txt13);

        si9 = (RadioButton)findViewById(R.id.par_ben_ra29);
        no9 = (RadioButton)findViewById(R.id.par_ben_ra30);
        et9 = (EditText)findViewById(R.id.ernpl_prod_txt14);

        a10 = (RadioButton)findViewById(R.id.par_ben_ra31);
        b10 = (RadioButton)findViewById(R.id.par_ben_ra32);
        c10 = (RadioButton)findViewById(R.id.par_ben_ra33);

        et11 = (EditText)findViewById(R.id.ernpl_prod_txt15);
        et12 = (EditText)findViewById(R.id.ernpl_prod_txt16);
        et13 = (EditText)findViewById(R.id.ernpl_prod_txt17);

        btnSiguiente = (Button)findViewById(R.id.ernpl_prod_sig);
    }

    public void Eventos(){

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg222);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(p21a.isChecked()==true){
                    sia.setVisibility(View.VISIBLE);
                    sib.setVisibility(View.VISIBLE);
                    noa.setVisibility(View.GONE);
                    nob.setVisibility(View.GONE);
                }else{
                    sia.setVisibility(View.GONE);
                    sib.setVisibility(View.GONE);
                    noa.setVisibility(View.VISIBLE);
                    nob.setVisibility(View.VISIBLE);
                }
            }
        });

        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.rg777);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(si3.isChecked()==true){
                    et3.setVisibility(View.VISIBLE);
                }else{
                    et3.setVisibility(View.GONE);
                    et3.setText("");
                }
            }
        });

        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.rg888);
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(si4.isChecked()==true){
                    a4.setVisibility(View.VISIBLE);
                    b4.setVisibility(View.VISIBLE);
                    c4.setVisibility(View.VISIBLE);
                }else{
                    a4.setVisibility(View.GONE);
                    b4.setVisibility(View.GONE);
                    c4.setVisibility(View.GONE);

                }
            }
        });

        RadioGroup radioGroup4 = (RadioGroup) findViewById(R.id.rg1313);
        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(si8.isChecked()==true){
                    et8.setVisibility(View.VISIBLE);
                }else{
                    et8.setVisibility(View.GONE);
                    et8.setText("");
                }
            }
        });

        RadioGroup radioGroup5 = (RadioGroup) findViewById(R.id.rg1414);
        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(si9.isChecked()==true){
                    et9.setVisibility(View.VISIBLE);
                }else{
                    et9.setVisibility(View.GONE);
                    et9.setText("");
                }
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
        else if(!p21a.isChecked() && !p21b.isChecked()){
            p21a.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(p21a.isChecked() && (!sia.isChecked() && !sib.isChecked())){
            sia.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(p21b.isChecked() && (!noa.isChecked() && !nob.isChecked())){
            noa.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(!si1.isChecked() && !no1.isChecked()){
            si1.setError("Debes seleccionar una opción");
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
        else if(si3.isChecked() && et3.getText().toString().isEmpty()){
            et3.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!si4.isChecked() && !no4.isChecked()){
            si4.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(si4.isChecked() && (!a4.isChecked() && !b4.isChecked() && !c4.isChecked())){
            c4.setError("No puede quedar vacio");
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
        else if(si8.isChecked() && et8.getText().toString().isEmpty()){
            et8.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!si9.isChecked() && !no9.isChecked()){
            si9.setError("Debes seleccionar una opción");
            retorno=false;
        }
        else if(si9.isChecked() && et9.getText().toString().isEmpty()){
            et9.setError("No puede quedar vacio");
            retorno=false;
        }
        else if(!a10.isChecked() && !b10.isChecked() && !c10.isChecked()){
            c10.setError("Debes seleccionar una opción");
            retorno=false;
        }


        return retorno;
    }

    @Override
    public void onBackPressed() {

    }

}