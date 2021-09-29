package com.example.geosegalmex.frutales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.geosegalmex.R;
import com.example.geosegalmex.frutales.dbfrutales.VariablesFrutales;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class frutales_11 extends AppCompatActivity {
    ExtendedFloatingActionButton f11;
    private  String	PCFRU;	//	¿Ha detectado alguna plaga cuarentenaria? 	9
    private  String	PLACUA;	//	¿Cuál?	9
    private  String	PLACUAO;	//	Otra	9

    EditText edtOtro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutales_11);

        f11 = findViewById(R.id.fr11);
        edtOtro = findViewById(R.id.edt_ot_pe_fe_frt);

        f11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();


                startActivity(new Intent(getApplicationContext(), frutales_12.class));
            }
        });
    }

    private void asignacionValores() {
        if(!edtOtro.getText().toString().isEmpty()){
            PLACUAO  = edtOtro.getText().toString();
        }

        VariablesFrutales.PCFRU = PCFRU;	//	¿Ha detectado alguna plaga cuarentenaria? 	9
        VariablesFrutales.PLACUA = PLACUA;	//	¿Cuál?	9
        VariablesFrutales.PLACUAO = PLACUAO;	//	Otra	9
    }

    public void plagaCuarentaria(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_si_ori_pr_fe_frt:
                if (checkedTipo) {
                    PCFRU = "Si";
                }
                break;
            case R.id.rd_no_ori_pr_fe_frt:
                if (checkedTipo) {
                    PCFRU = "No";
                }
                break;
        }
    }

    public void cualPlaga(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_su_pe_fe_frt:
                if (checkedTipo) {
                    PLACUA = "Mosca del mediterráneo ";
                    edtOtro.setEnabled(false);
                    edtOtro.setText("");
                }
                break;
            case R.id.ck_ag_pe_fe_frt:
                if (checkedTipo) {
                    PLACUA = "Mosca mexicana";
                    edtOtro.setEnabled(false);
                    edtOtro.setText("");
                }
                break;
            case R.id.ck_sm_pe_fe_frt:
                if (checkedTipo) {
                    PLACUA = "Barrenadores de tronco y fruto";
                    edtOtro.setEnabled(false);
                    edtOtro.setText("");
                }
                break;
            case R.id.ck_ut_pe_fe_frt:
                if (checkedTipo) {
                    PLACUA = "Escarabajos ambrosiales";
                    edtOtro.setEnabled(false);
                    edtOtro.setText("");
                }
                break;
            case R.id.ck_ot_pe_fe_frt:
                if (checkedTipo) {
                    PLACUA = "Otro";
                    edtOtro.setEnabled(true);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
