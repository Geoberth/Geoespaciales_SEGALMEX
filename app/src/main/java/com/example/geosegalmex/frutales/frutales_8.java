package com.example.geosegalmex.frutales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.frutales.dbfrutales.VariablesFrutales;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class frutales_8 extends AppCompatActivity {
    ExtendedFloatingActionButton f8;

    private String MALGR= null;// IntegerMaleza
    private String NCFRU= null;// IntegerNombre común
    private String CONQMGR= null;// IntegerControl: (1) químico o 2) manual

    private String HERGR= null;// IntegerHerbicida
    private String HERCANGR= null;// IntegerCantidad (l ó kg / ha)
  //  private String SUPAPFRU= null;// IntegerSuperficie de aplicación (ha)
    private String HJORGR= null;// IntegerJornales
    private String CHERGR= null;// IntegerCosto herbicida

    EditText edtHrbci;
    EditText edtCant;
    EditText edtJorn;
    EditText edtCstHerb;

    EditText edtNmbCmn;

    Button btnOtraMaleza;
    private DatabaseHelper db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutales_8);

        f8 = findViewById(R.id.fr8);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        db = new DatabaseHelper(this);


        edtHrbci = findViewById(R.id.edt_her_cm_fe_agr_frt);
        edtCant = findViewById(R.id.edt_can_cm_fe_agr_frt);
        edtJorn = findViewById(R.id.edt_jr_cm_fe_agr_frt);
        edtCstHerb = findViewById(R.id.edt_ch_cm_fe_agr_frt);

        edtNmbCmn = findViewById(R.id.edt_nmb_cmn_frt);


        btnOtraMaleza = findViewById(R.id.btn_oto_cm_fe_agr_frt);



        btnOtraMaleza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                if(MALGR != null) {
                    aggMaleza();
                    startActivity(new Intent(getApplicationContext(), frutales_8.class));
                }
            }
        });

        f8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionValores();
                if(MALGR != null) {
                    aggMaleza();
                }
                startActivity(new Intent(getApplicationContext(), frutales_10.class));
            }
        });
    }

    private void aggMaleza() {
        boolean insertarData = db.addDatosFrutalesMaleza();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void asignacionValores() {


        if(!edtNmbCmn.getText().toString().isEmpty()){
            NCFRU = edtNmbCmn.getText().toString();
        }

        if(!edtHrbci.getText().toString().isEmpty()){
            HERGR =  edtHrbci.getText().toString();
        }

        if(!edtCant.getText().toString().isEmpty()){
            HERCANGR = edtCant.getText().toString();
        }

        if(!edtJorn.getText().toString().isEmpty()){
            HJORGR = edtJorn.getText().toString();
        }

        if(!edtCstHerb.getText().toString().isEmpty()){
            CHERGR = edtCstHerb.getText().toString();
        }


        VariablesFrutales.MALGRFRT = MALGR; //	Text	Maleza
        VariablesFrutales.NCFRUFRT = NCFRU; //	Text	Nombre común
        VariablesFrutales.CONQMGRFRT = CONQMGR; //	Text	Control: (1) químico o 2) manual
        VariablesFrutales.HERGRFRT = HERGR; //	Text	Herbicida
        VariablesFrutales.HERCANGRFRT = HERCANGR; //	Integer	Cantidad (l ó kg / ha)
        VariablesFrutales.HJORGRFRT = HJORGR; //	Integer	Jornales
        VariablesFrutales.CHERGRFRT = CHERGR; //	Text	Costo herbicida
    }


    public void tipoMalezagrfrt(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_hj_ach_agr_frt:
                if (checkedTipo) {
                    MALGR = "Hoja ancha";
                }
                break;
            case R.id.rd_hj_dlg_agr_frt:
                if (checkedTipo) {
                    MALGR = "Hoja delgada";
                }
                break;
        }
    }

    public void tipoControlagrfrt(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rd_cm_qui_agr_frt:
                if (checkedTipo) {
                    CONQMGR = "Químico";
                }
                break;
            case R.id.rd_cm_mnl_agr_frt:
                if (checkedTipo) {
                    CONQMGR = "Manual";
                }
                break;
        }
    }
    @Override
    public void onBackPressed() {

    }
}
