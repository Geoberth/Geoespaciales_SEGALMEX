package com.example.geosegalmex.caracterizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.caracterizacion.variables_caracterizacion.ActividadesCosecha;
import com.example.geosegalmex.caracterizacion.variables_caracterizacion.VariablesModuloCuatro;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ciclo_caracterizacion11 extends AppCompatActivity {
    ExtendedFloatingActionButton siguiente11;
    private String METDES= null;// Integer¿Qué método de desgrane utiliza?
    private String JORDESM= null;// IntegerNúmero de jornales
    private String SERMEN= null;// IntegerPrecio ($) Servicio/ton

    EditText edtNumJornAgri;
    EditText edtCostSerAgri;

    private DatabaseHelper db;

    //tabla cosecha
    EditText edtJrn1;
    EditText edtJrn2;
    EditText edtJrn3;
    EditText edtJrn4;
    private String ACTCOSECH= null;// Integer¿Qué actividades realiza durante la cosecha?
    private String JORCOSGR= null;// IntegerNúmero de jornales
    List <String> listaActividadesCosecha = new ArrayList<>();
    List <ActividadesCosecha> cosechaList = new ArrayList<>();

    TextView txtTitCose;
    TextView txtTitPstCose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_caracterizacion11);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        edtNumJornAgri = findViewById(R.id.no_jorna);
        edtCostSerAgri = findViewById(R.id.costo_serv);
        siguiente11 = findViewById(R.id.btn_sig11);
        txtTitCose = findViewById(R.id.tx_tit_cm_agr_cs);
        txtTitPstCose = findViewById(R.id.tx_tit_cm_agr_psc);

        db         = new DatabaseHelper(this);

        if(ciclo_carac.valorTempCosPvAgricola == 1){
            txtTitCose.setText(getString(R.string.name_mod_csh_pv_cuatro));
            txtTitPstCose.setText(getString(R.string.name_mod_pcs_pv_cuatro));
        }else if(ciclo_carac.valorTempCosOiAgricola == 1){
            txtTitCose.setText(getString(R.string.name_mod_csh_oi_cuatro));
            txtTitPstCose.setText(getString(R.string.name_mod_pcs_oi_cuatro));
        }



        //++++++++++++++++++Tabla Cosecha+++++++
        edtJrn1 = findViewById(R.id.jr_agr_1);
        edtJrn2 = findViewById(R.id.jr_agr_2);
        edtJrn3 = findViewById(R.id.jr_agr_3);
        edtJrn4 = findViewById(R.id.jr_agr_agri_4);

        //+++++++++++++++++++++++++++++++++

        siguiente11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtNumJornAgri.getText().toString().isEmpty()){
                    JORDESM  = edtNumJornAgri.getText().toString();
                }

                if(!edtCostSerAgri.getText().toString().isEmpty()){
                    SERMEN = edtCostSerAgri.getText().toString();
                }

                VariablesModuloCuatro.METDES = METDES ;// Integer¿Qué método de desgrane utiliza?
                VariablesModuloCuatro.JORDESM = JORDESM;// IntegerNúmero de jornales
                VariablesModuloCuatro.SERMEN = SERMEN;// IntegerPrecio ($) Servicio/ton


                //+++++++++++++++++++tabla cosecha+++++++++++++++++++++++++

                listaCosechaMvc();
                recorreLista();
              //  listaActividadesCosecha.clear();
                //++++++++++++++++++++++++++++++++
             //   aggAgricola();

                startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion12.class));
            }
        });
    }



    private void aggAgricola() {
        boolean insertarData = db.addAgricola();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    public void tipoDesgrane(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.manu_des_agr:
                if (checkedTipo) {
                    METDES = "Manual";
                }
                break;
            case R.id.meca_des_agr:
                if (checkedTipo) {
                    METDES = "Mecanizado";
                }
                break;
        }
    }


    //+++++++++++++++++++++++++++++++++++ Tabla Cosecha ++++++++++++++++++++++++++++++++++++++++++++

    private void recorreLista() {
        int j=0;
        String actCosecha;
        String nmjCosecha;
        for(j =0; j < cosechaList.size();j++){
            System.out.println(cosechaList.get(j).getNombreCosecha());
            System.out.println(cosechaList.get(j).getNumJorCosecha());

            actCosecha = cosechaList.get(j).getNombreCosecha();
            nmjCosecha = cosechaList.get(j).getNumJorCosecha();

            VariablesModuloCuatro.ACTCOSECH = actCosecha;// Integer¿Qué actividades realiza durante la cosecha?
            VariablesModuloCuatro.JORCOSGR = nmjCosecha;// IntegerNúmero de jornales
            aggCosecha();
        }

    }

    private void aggCosecha() {
        boolean insertarData = db.addCosechaAgri();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }


    private void listaCosechaMvc() {
        int i =0;
        String valActCos;
        for(i=0; i < listaActividadesCosecha.size(); i++){
            System.out.println(listaActividadesCosecha.get(i));
            valActCos = listaActividadesCosecha.get(i);
            valoresComparar(valActCos);
        }
    }

    private void valoresComparar(String valActCos) {
        ActividadesCosecha actividadesCosecha;
        switch (valActCos){
            case "Doblado de mazorca":
                if(!edtJrn1.getText().toString().isEmpty()) {
                    JORCOSGR = edtJrn1.getText().toString();
                }else {
                    JORCOSGR = null;
                }
                actividadesCosecha = new ActividadesCosecha(valActCos,JORCOSGR);
                cosechaList.add(actividadesCosecha);
                break;
            case "Moneo":
                if(!edtJrn2.getText().toString().isEmpty()) {
                    JORCOSGR = edtJrn2.getText().toString();
                }else {
                    JORCOSGR = null;
                }
                actividadesCosecha = new ActividadesCosecha(valActCos,JORCOSGR);
                cosechaList.add(actividadesCosecha);
                break;
            case "Pizca":
                if(!edtJrn3.getText().toString().isEmpty()) {
                    JORCOSGR = edtJrn3.getText().toString();
                }else {
                    JORCOSGR = null;
                }
                actividadesCosecha = new ActividadesCosecha(valActCos,JORCOSGR);
                cosechaList.add(actividadesCosecha);
                break;
            case "Acarreo":
                if(!edtJrn4.getText().toString().isEmpty()) {
                    JORCOSGR = edtJrn4.getText().toString();
                }else {
                    JORCOSGR = null;
                }
                actividadesCosecha = new ActividadesCosecha(valActCos,JORCOSGR);
                cosechaList.add(actividadesCosecha);
                break;

        }
    }


    public void cosechaAgri(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ch_dbl_agr_1:
                if (checkedTipo) {
                    ACTCOSECH= "Doblado de mazorca";
                    listaActividadesCosecha.add(ACTCOSECH);
                } else {
                    listaActividadesCosecha.remove("Doblado de mazorca");
                    edtJrn1.setText("");
                }
                break;
            case R.id.ch_dbl_agr_2:
                if (checkedTipo) {
                    ACTCOSECH = "Moneo";
                    listaActividadesCosecha.add(ACTCOSECH);
                } else {
                    listaActividadesCosecha.remove("Moneo");
                    edtJrn2.setText("");
                }
                break;
            case R.id.ch_dbl_agr_3:
                if (checkedTipo) {
                    ACTCOSECH = "Pizca";
                    listaActividadesCosecha.add(ACTCOSECH);
                } else {
                    listaActividadesCosecha.remove("Pizca");
                    edtJrn3.setText("");
                }
                break;
            case R.id.ch_dbl_agr_4:
                if (checkedTipo) {
                    ACTCOSECH = "Acarreo";
                    listaActividadesCosecha.add(ACTCOSECH);
                } else {
                    listaActividadesCosecha.remove("Acarreo");
                    edtJrn4.setText("");
                }
                break;
        }

    }

    @Override
    public void onBackPressed() {

    }
}
