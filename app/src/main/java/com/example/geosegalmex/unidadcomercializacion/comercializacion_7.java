package com.example.geosegalmex.unidadcomercializacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcomercializacion.bdcomercializacion.VariablesGlobalesCmrz;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class comercializacion_7 extends AppCompatActivity {
    ExtendedFloatingActionButton co7;

    private	String	COSPROCAL	= null;		//	String
    private	String	COSPROCLI	= null;		//	String
    private	String	COSPROCRE	= null;		//	String
    private	String	COSPROCCO	= null;		//	String
    private	String	COSPROCCC	= null;		//	String
    private	String	COSPROCEM	= null;		//	String
    private	String	COSPROCCU	= null;		//	String
    private	String	COSPROCSE	= null;		//	String
    // private	String	PROVAAGPE	= null;		//	String pregunta
    private	String	PROVAAGPEEMB	= null;		//	String
    private	String	PROVAAGPECRE	= null;		//	String
    private	String	PROVAAGPEQUE	= null;		//	String
    private	String	PROVAAGPEYOG	= null;		//	String
    private	String	PROVAAGPEHAR	= null;		//	String
    private	String	PROVAAGPEOTR	= null;		//	String

    private	String	PROVAAGPEOTREP	= null;		//	String


    EditText edtApl1;
    EditText edtApl2;
    EditText edtApl3;
    EditText edtApl4;
    EditText edtApl5;
    EditText edtApl6;
    EditText edtApl7;
    EditText edtApl8;

    EditText edtOtrProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comercializacion_7);
        co7 = findViewById(R.id.cr7);

        edtApl1 = findViewById(R.id.edt_apl_pr_cns_1);
        edtApl2 = findViewById(R.id.edt_apl_pr_cns_2);
        edtApl3 = findViewById(R.id.edt_apl_pr_cns_3);
        edtApl4 = findViewById(R.id.edt_apl_pr_cns_4);
        edtApl5 = findViewById(R.id.edt_apl_pr_cns_5);
        edtApl6 = findViewById(R.id.edt_apl_pr_cns_6);
        edtApl7 = findViewById(R.id.edt_apl_pr_cns_7);
        edtApl8 = findViewById(R.id.edt_apl_pr_cns_8);


        edtOtrProd = findViewById(R.id.edt_pro_sie_cm);


        co7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funGetEdit();
                VariablesGlobalesCmrz.COSPROCAL = COSPROCAL;	//	String
                VariablesGlobalesCmrz.COSPROCLI = COSPROCLI;	//	String
                VariablesGlobalesCmrz.COSPROCRE = COSPROCRE;	//	String
                VariablesGlobalesCmrz.COSPROCCO = COSPROCCO;	//	String
                VariablesGlobalesCmrz.COSPROCCC = COSPROCCC;	//	String
                VariablesGlobalesCmrz.COSPROCEM = COSPROCEM;	//	String
                VariablesGlobalesCmrz.COSPROCCU = COSPROCCU;	//	String
                VariablesGlobalesCmrz.COSPROCSE = COSPROCSE;	//	String

                //      VariablesGlobalesCmrz.PROVAAGPE = PROVAAGPE;	//	String pregunta

                VariablesGlobalesCmrz.PROVAAGPEEMB = PROVAAGPEEMB;	//	String
                VariablesGlobalesCmrz.PROVAAGPECRE = PROVAAGPECRE;	//	String
                VariablesGlobalesCmrz.PROVAAGPEQUE = PROVAAGPEQUE;	//	String
                VariablesGlobalesCmrz.PROVAAGPEYOG = PROVAAGPEYOG;	//	String
                VariablesGlobalesCmrz.PROVAAGPEHAR = PROVAAGPEHAR;	//	String
                VariablesGlobalesCmrz.PROVAAGPEOTR = PROVAAGPEOTR;	//	String
                VariablesGlobalesCmrz.PROVAAGPEOTREP = PROVAAGPEOTREP;	//	String
                //      VariablesGlobalesCmrz.PROVAAGPEOTREP = PROVAAGPEOTREP;	//	String pregunta
                startActivity(new Intent(getApplicationContext(), comercializacion_8.class));
            }
        });
    }


    private void funGetEdit() {
        COSPROCAL = edtApl1.getText().toString();
        COSPROCLI = edtApl2.getText().toString();
        COSPROCRE = edtApl3.getText().toString();
        COSPROCCO = edtApl4.getText().toString();
        COSPROCCC = edtApl5.getText().toString();
        COSPROCEM = edtApl6.getText().toString();
        COSPROCCU = edtApl7.getText().toString();
        COSPROCSE = edtApl8.getText().toString();
        PROVAAGPEOTREP = edtOtrProd.getText().toString();
    }

    public void prinProdIncremIngresos(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_pro_ing_1:
                if (checkedTipo) {
                    PROVAAGPEEMB = "Embutidos (jamón, salchicha…)";
                }else{
                    PROVAAGPEEMB = null;
                }
                break;
            case R.id.ck_pro_ing_2:
                if (checkedTipo) {
                    PROVAAGPECRE = "Crema";
                }else {
                    PROVAAGPECRE = null;
                }
                break;
            case R.id.ck_pro_ing_3:
                if (checkedTipo) {
                    PROVAAGPEQUE = "Quesos";
                }else{
                    PROVAAGPEQUE = null;
                }
                break;
            case R.id.ck_pro_ing_4:
                if (checkedTipo) {
                    PROVAAGPEYOG = "Yogurt";
                }else {
                    PROVAAGPEYOG = null;
                }
                break;
            case R.id.ck_pro_ing_5:
                if (checkedTipo) {
                    PROVAAGPEHAR = "Harina";
                }else{
                    PROVAAGPEHAR = null;
                }
                break;
            case R.id.ck_pro_ing_6:
                if (checkedTipo) {
                    PROVAAGPEOTR = "Otro";
                    edtOtrProd.setEnabled(true);
                }else{
                    PROVAAGPEOTR = null;
                    edtOtrProd.setEnabled(false);
                }
                break;
        }
    }
    @Override
    public void onBackPressed() {

    }
}
