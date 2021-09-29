package com.example.geosegalmex.unidadproduccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadproduccion.variables.VariablesGlobalesUpf;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class TiposAlimentosDos extends AppCompatActivity {
    ExtendedFloatingActionButton fabAliDos;

    private int	ALITOR	= 0;	//	Integer
    private int	ALIPAP	= 0;	//	Integer
    private int	ALIVER	= 0;	//	Integer
    private int	ALIFRU	= 0;	//	Integer
    private int	ALICAR	= 0;	//	Integer
    private int	ALIHUE	= 0;	//	Integer
    private int	ALIPES	= 0;	//	Integer
    private int	ALIFLH	= 0;	//	Integer
    private int	ALIQUE	= 0;	//	Integer
    private int	ALIACE	= 0;	//	Integer
    private int	ALIAZU	= 0;	//	Integer
    private int	ALICON	= 0;	//	Integer

    EditText edtALITOR;
    EditText edtALIPAP;
    EditText edtALIVER;
    EditText edtALIFRU;
    EditText edtALICAR;
    EditText edtALIHUE;
    EditText edtALIPES;
    EditText edtALIFLH;
    EditText edtALIQUE;
    EditText edtALIACE;
    EditText edtALIAZU;
    EditText edtALICON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos_alimentos_dos);

        fabAliDos = findViewById(R.id.fab_next_pro_aldos);

        //Edittext
        edtALITOR = findViewById(R.id.inciso_a);
        edtALIPAP= findViewById(R.id.inciso_b);
        edtALIVER= findViewById(R.id.inciso_c);
        edtALIFRU= findViewById(R.id.inciso_d);

        edtALICAR= findViewById(R.id.inciso_e);
        edtALIHUE= findViewById(R.id.inciso_f);
        edtALIPES= findViewById(R.id.inciso_g);
        edtALIFLH= findViewById(R.id.inciso_h);

        edtALIQUE= findViewById(R.id.inciso_i);
        edtALIACE= findViewById(R.id.inciso_j);
        edtALIAZU= findViewById(R.id.inciso_k);
        edtALICON= findViewById(R.id.inciso_l);


        fabAliDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean vrtnCampos = validarCampos();

                if(vrtnCampos){
                    Snackbar snackbar = Snackbar.make(v, "Verique los dias de la semana o campos incompletos", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }else{
                    VariablesGlobalesUpf.ALITOR = String.valueOf(ALITOR);    //	Integer
                    VariablesGlobalesUpf.ALIPAP = String.valueOf(ALIPAP);    //	Integer
                    VariablesGlobalesUpf.ALIVER = String.valueOf(ALIVER);    //	Integer
                    VariablesGlobalesUpf.ALIFRU = String.valueOf(ALIFRU);    //	Integer

                    VariablesGlobalesUpf.ALICAR = String.valueOf(ALICAR);    //	Integer
                    VariablesGlobalesUpf.ALIHUE = String.valueOf(ALIHUE);    //	Integer
                    VariablesGlobalesUpf.ALIPES = String.valueOf(ALIPES);    //	Integer
                    VariablesGlobalesUpf.ALIFLH = String.valueOf(ALIFLH);    //	Integer

                    VariablesGlobalesUpf.ALIQUE = String.valueOf(ALIQUE);    //	Integer
                    VariablesGlobalesUpf.ALIACE = String.valueOf(ALIACE);    //	Integer
                    VariablesGlobalesUpf.ALIAZU = String.valueOf(ALIAZU);    //	Integer
                    VariablesGlobalesUpf.ALICON = String.valueOf(ALICON);    //	Integer
                    startActivity(new Intent(getApplication(), TiposAlimentosTres.class));
                }

            }
        });
    }



    @Override
    public void onBackPressed() {

    }


    private Boolean validarCampos() {
        Boolean incisoA = true;
        Boolean incisoB = true;
        Boolean incisoC = true;
        Boolean incisoD = true;

        Boolean incisoE = true;
        Boolean incisoF = true;
        Boolean incisoG = true;
        Boolean incisoH = true;

        Boolean incisoI = true;
        Boolean incisoJ = true;
        Boolean incisoK = true;
        Boolean incisoL = true;

        if(edtALITOR.getText().toString().isEmpty()){
            incisoA = true;
        }else if(!edtALITOR.getText().toString().isEmpty()){
            ALITOR = Integer.parseInt(edtALITOR.getText().toString());
            if(ALITOR > 7){
                incisoA = true;
            }else {
                incisoA = false;
            }
        }

        if(edtALIPAP.getText().toString().isEmpty()) {
            incisoB = true;
        }else if(!edtALIPAP.getText().toString().isEmpty()){
            ALIPAP = Integer.parseInt(edtALIPAP.getText().toString());
            if(ALIPAP > 7){
                incisoB = true;
            }else {
                incisoB = false;
            }
        }

        if(edtALIVER.getText().toString().isEmpty()){
            incisoC = true;
        }else if(!edtALIVER.getText().toString().isEmpty()){
            ALIVER = Integer.parseInt(edtALIVER.getText().toString());
            if(ALIVER > 7){
                incisoC = true;
            }else {
                incisoC = false;
            }

        }

        if(edtALIFRU.getText().toString().isEmpty()){
            incisoD = true;
        }else if(!edtALIFRU.getText().toString().isEmpty()){
            ALIFRU = Integer.parseInt(edtALIFRU.getText().toString());
            if(ALIFRU > 7){
                incisoD = true;
            }else {
                incisoD = false;
            }
        }


        if(edtALICAR.getText().toString().isEmpty()){
            incisoE = true;
        }
        if(!edtALICAR.getText().toString().isEmpty()){
            ALICAR = Integer.parseInt(edtALICAR.getText().toString());
            if(ALICAR > 7){
                incisoE = true;
            }else {
                incisoE = false;
            }
        }

        if(edtALIHUE.getText().toString().isEmpty()){
            incisoF = true;
        }
        if(!edtALIHUE.getText().toString().isEmpty()){
            ALIHUE = Integer.parseInt(edtALIHUE.getText().toString());
            if(ALIHUE > 7){
                incisoF = true;
            }else {
                incisoF = false;
            }
        }

        if(edtALIPES.getText().toString().isEmpty()){
            incisoG = true;
        }else if(!edtALIPES.getText().toString().isEmpty()){
            ALIPES = Integer.parseInt(edtALIPES.getText().toString());
            if(ALIPES > 7){
                incisoG = true;
            }else {
                incisoG = false;
            }
        }

        if(edtALIFLH.getText().toString().isEmpty()){
            incisoH = true;
        }else if(!edtALIFLH.getText().toString().isEmpty()){
            ALIFLH = Integer.parseInt(edtALIFLH.getText().toString());
            if(ALIFLH > 7){
                incisoH = true;
            }else {
                incisoH = false;
            }
        }

        if(edtALIQUE.getText().toString().isEmpty()){
            incisoI = true;
        }
        if(!edtALIQUE.getText().toString().isEmpty()){
            ALIQUE = Integer.parseInt(edtALIQUE.getText().toString());
            if(ALIQUE > 7){
                incisoI = true;
            }else {
                incisoI = false;
            }
        }

        if(edtALIACE.getText().toString().isEmpty()){
            incisoJ = true;
        }
        if(!edtALIACE.getText().toString().isEmpty()){
            ALIACE = Integer.parseInt(edtALIACE.getText().toString());
            if(ALIACE > 7){
                incisoJ = true;
            }else {
                incisoJ = false;
            }
        }

        if(edtALIAZU.getText().toString().isEmpty()){
            incisoK = true;
        }
        if(!edtALIAZU.getText().toString().isEmpty()){
            ALIAZU = Integer.parseInt(edtALIAZU.getText().toString());
            if(ALIAZU > 7){
                incisoK = true;
            }else {
                incisoK = false;
            }
        }

        if(edtALICON.getText().toString().isEmpty()){
            incisoL = true;
        }
        if(!edtALICON.getText().toString().isEmpty()){
            ALICON = Integer.parseInt(edtALICON.getText().toString());
            if(ALICON > 7){
                incisoL = true;
            }else {
                incisoL = false;
            }
        }

        if(incisoA || incisoB || incisoC || incisoD || incisoE || incisoF || incisoG || incisoH || incisoI || incisoJ || incisoK || incisoL){
            return true;
        }else{
            return false;
        }
    }
}
