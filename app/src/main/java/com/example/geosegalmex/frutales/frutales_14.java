
package com.example.geosegalmex.frutales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.geosegalmex.IdentificacionCuestionario;
import com.example.geosegalmex.R;
import com.example.geosegalmex.frutales.dbfrutales.VariablesFrutales;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class frutales_14 extends AppCompatActivity {
    ExtendedFloatingActionButton f14;
    ArrayList<String> postList;
    private String	MPFRUT;	//	¿Realiza algún manejo postcosecha? 	14
    private String	MPFRUTCUAL;
    private String	MPFRUTCUALOTRO;

    EditText edtOtroFrt;

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutales_14);

        f14 = findViewById(R.id.fr14);
        edtOtroFrt = findViewById(R.id.ed_otr_frt);

        db         = new DatabaseHelper(this);
        postList = new ArrayList<>();

        f14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                aggSaveValore();
                startActivity(new Intent(getApplicationContext(), IdentificacionCuestionario.class));
            }
        });
    }

    private void aggSaveValore() {
        boolean insertarData = db.addDatosFrutales();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void asignacionValores() {
        int i =0;
        String valor = null;

        if(!postList.isEmpty()) {
            for (i = 0; i < postList.size(); i++) {

                if (valor != null) {
                    valor = valor + postList.get(i) + ",";
                } else if (valor == null) {
                    valor = postList.get(i) + ",";
                }
            }
        }
        if(!edtOtroFrt.getText().toString().isEmpty()){
            MPFRUTCUALOTRO = edtOtroFrt.getText().toString();
        }

        VariablesFrutales.MPFRUT = MPFRUT;
        VariablesFrutales.MPFRUTCUAL = valor;
        VariablesFrutales.MPFRUTCUALOTRO = MPFRUTCUALOTRO;
        System.out.println(valor);



    }

    public void manePostCostFrt(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_si_ps_fe_frt:
                if (checkedTipo) {
                    MPFRUT = "Si";
                }
                break;
            case R.id.rd_no_ps_fe_frt:
                if (checkedTipo) {
                    MPFRUT = "No";
                }
                break;
        }
    }

    public void manejoPosCscFrt(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_pas_fe_frt:
                if (checkedTipo) {
                    postList.add("Pastoreo");
                } else {
                    postList.remove("Pastoreo");
                }
                break;
            case R.id.ck_pi_fe_frt:
                if (checkedTipo) {
                    postList.add("Pizca o pepena ");
                } else {
                    postList.remove("Pizca o pepena ");
                }
                break;
            case R.id.ck_vn_fe_frt:
                if (checkedTipo) {
                    postList.add("Venta de esquilmos");
                } else {
                    postList.remove("Venta de esquilmos");
                }
                break;
            case R.id.ck_inc_fe_frt:
                if (checkedTipo) {
                    postList.add("Incorporación al suelo");
                } else {
                    postList.remove("Incorporación al suelo");
                }
                break;
            case R.id.ck_qe_fe_frt:
                if (checkedTipo) {
                    postList.add("Quema");
                } else {
                    postList.remove("Quema");
                }
                break;
            case R.id.ck_qe_fe_6_frt:
                if (checkedTipo) {
                    postList.add("Poda");
                    //edtOtroFrt.setEnabled(false);
                    //edtOtroFrt.setText("");
                } else {
                    postList.remove("Poda");
                }
                break;
            case R.id.ck_qe_fe_7_frt:
                if (checkedTipo) {
                    postList.add("Otro");
                    edtOtroFrt.setEnabled(true);
                } else {
                    edtOtroFrt.setText("");
                    MPFRUTCUALOTRO = null;
                    postList.remove("Otro");
                    edtOtroFrt.setEnabled(false);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
