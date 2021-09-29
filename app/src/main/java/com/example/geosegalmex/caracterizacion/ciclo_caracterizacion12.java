package com.example.geosegalmex.caracterizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.geosegalmex.IdentificacionCuestionario;
import com.example.geosegalmex.R;
import com.example.geosegalmex.caracterizacion.variables_caracterizacion.ConservaGranos;
import com.example.geosegalmex.caracterizacion.variables_caracterizacion.VariablesModuloCuatro;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ciclo_caracterizacion12 extends AppCompatActivity {
    ExtendedFloatingActionButton siguiente12;
    EditText edtGrn1;
    EditText edtGrn2;
    EditText edtGrn3;
    EditText edtGrn4;
    EditText edtGrn5;
    EditText edtGrn5_1;

    private String CONGRALM= null;// Integer¿Cómo conserva sus granos almacenados?
    private String CONGRALMO= null;// IntegerOtro
    private String COSALMGR= null;// IntegerCosto ($)
    private String SUBAPRO= null;// Integer¿Qué subproductos aprovecha?

    List<String>listaGranos = new ArrayList<>();
    List<ConservaGranos> conservaGranosArrayList = new ArrayList<>();
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_caracterizacion12);

        db = new DatabaseHelper(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        siguiente12 = findViewById(R.id.btn_sig12);

        edtGrn1 = findViewById(R.id.edt_gra_1);
        edtGrn2 = findViewById(R.id.edt_gra_2);
        edtGrn3 = findViewById(R.id.edt_gra_3);
        edtGrn4 = findViewById(R.id.edt_gra_4);
        edtGrn5 = findViewById(R.id.edt_gra_5);
        edtGrn5_1 = findViewById(R.id.edt_gra_5_1);


        if(ciclo_carac.valorTempCosPvOiAgricola == 1){
            ciclo_carac.valorTempCosPvOiAgricola = 0;
            ciclo_carac.valorTempCosPvAgricola = 0;
            ciclo_carac.valorTempCosOiAgricola = 1;
            siguiente12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recorreLista();
                    guardarRecorrerLista();
                    VariablesModuloCuatro.SUBAPRO = SUBAPRO;
                    aggAgricola();
                    // comparativoValores(CONGRALM);
                   // asignacionValores();
                    startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion.class));
                }
            });
        }else{
            siguiente12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    recorreLista();
                    guardarRecorrerLista();
                    VariablesModuloCuatro.SUBAPRO = SUBAPRO;// Integer¿Qué subproductos aprovecha?
                    aggAgricola();
                    startActivity(new Intent(getApplicationContext(), IdentificacionCuestionario.class));

                }
            });
        }


    }

    private void guardarRecorrerLista() {
        int i=0;
        String actGranos;
        String actGranosOtr;
        String actGranosCst;

        for (i=0 ; i< conservaGranosArrayList.size(); i++){
            System.out.println(conservaGranosArrayList.get(i).getNombGranosAlmc());
            System.out.println(conservaGranosArrayList.get(i).getNombGranosAlmcOtro());
            System.out.println(conservaGranosArrayList.get(i).getCostoGranosAlmc());

            actGranos = conservaGranosArrayList.get(i).getNombGranosAlmc();
            actGranosOtr = conservaGranosArrayList.get(i).getNombGranosAlmcOtro();
            actGranosCst= conservaGranosArrayList.get(i).getCostoGranosAlmc();

            VariablesModuloCuatro.CONGRALM = actGranos;// Integer¿Cómo conserva sus granos almacenados?
            VariablesModuloCuatro.CONGRALMO = actGranosOtr;// IntegerOtro
            VariablesModuloCuatro.COSALMGR = actGranosCst;// IntegerCosto

            aggGranos();

        }
    }

    //*++++++++++++++++++++++Agricola

    private void aggAgricola() {
        boolean insertarData = db.addAgricola();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }
    //

    private void aggGranos() {
        boolean insertarData = db.addGranoAgri();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    private void recorreLista() {
        int i =0;
        String valorLista;

        for(i =0; i< listaGranos.size(); i++){
            System.out.println(listaGranos.get(i));
            valorLista = listaGranos.get(i);
            comparativoValores(valorLista);
        }

    }

    private void comparativoValores(String valorCheck) {
        ConservaGranos conservaGranos;
        String edtValorReg;
        String edtOtroEsp = null;
        switch (valorCheck){
        case "Tapanco":
            edtValorReg = asignacionValores(edtGrn1);
            conservaGranos = new ConservaGranos(valorCheck,null,edtValorReg);
            conservaGranosArrayList.add(conservaGranos);
            break;
        case "Troje":
            edtValorReg = asignacionValores(edtGrn2);
            conservaGranos = new ConservaGranos(valorCheck,null,edtValorReg);
            conservaGranosArrayList.add(conservaGranos);
            break;
        case "Silo":
            edtValorReg = asignacionValores(edtGrn3);
            conservaGranos = new ConservaGranos(valorCheck,null,edtValorReg);
            conservaGranosArrayList.add(conservaGranos);
            break;
        case "Tambos herméticos":
            edtValorReg = asignacionValores(edtGrn4);
            conservaGranos = new ConservaGranos(valorCheck,null,edtValorReg);
            conservaGranosArrayList.add(conservaGranos);
            break;
        case "Otro":
            if(!edtGrn5.getText().toString().isEmpty()){
               edtOtroEsp = edtGrn5.getText().toString();
            }
            edtValorReg = asignacionValores(edtGrn5_1);
            conservaGranos = new ConservaGranos(valorCheck,edtOtroEsp,edtValorReg);
            conservaGranosArrayList.add(conservaGranos);
            break;
    }

    }


    private String asignacionValores(EditText editText) {
        String edtValor;
        if(!editText.getText().toString().isEmpty()){
            COSALMGR = editText.getText().toString();
            edtValor = COSALMGR;
            return edtValor;
        }else {
           // COSALMGR = null;
            edtValor = null;
            return edtValor;
        }

    }

    public void tipoGranos(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ckc_gra_1:
                if (checkedTipo) {
                    CONGRALM = "Tapanco";
                    listaGranos.add("Tapanco");
                    edtGrn1.setEnabled(true);

                } else {
                    listaGranos.remove("Tapanco");
                    CONGRALM = null;
                    edtGrn1.setEnabled(false);
                    edtGrn1.setText("");
                }
                break;
            case R.id.ckc_gra_2:
                if (checkedTipo) {
                    CONGRALM = "Troje";
                    listaGranos.add("Troje");
                    edtGrn2.setEnabled(true);

                } else {
                    listaGranos.remove("Troje");
                    CONGRALM = null;
                    edtGrn2.setEnabled(false);
                    edtGrn2.setText("");
                }
                break;
            case R.id.ckc_gra_3:
                if (checkedTipo) {
                    CONGRALM = "Silo";
                    listaGranos.add("Silo");
                    edtGrn3.setEnabled(true);

                } else {
                    listaGranos.remove("Silo");
                    CONGRALM = null;
                    edtGrn3.setEnabled(false);
                    edtGrn3.setText("");
                }
                break;
            case R.id.ckc_gra_4:
                if (checkedTipo) {
                    CONGRALM = "Tambos herméticos";
                    listaGranos.add("Tambos herméticos");
                    edtGrn4.setEnabled(true);

                } else {
                    listaGranos.remove("Tambos herméticos");
                    CONGRALM = null;
                    edtGrn4.setEnabled(false);
                    edtGrn4.setText("");
                }
                break;
            case R.id.ckc_gra_5:
                if (checkedTipo) {
                    CONGRALM = "Otro";
                    listaGranos.add("Otro");
                    edtGrn5.setEnabled(true);
                    edtGrn5_1.setEnabled(true);
                } else {
                    listaGranos.remove("Otro");
                    CONGRALM = null;
                    edtGrn5.setEnabled(false);
                    edtGrn5.setText("");
                    edtGrn5_1.setEnabled(false);
                    edtGrn5_1.setText("");
                }
                break;
        }

    }

    public void subproductosAprovecha(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_sub_aprv_1:
                if (checkedTipo) {
                    SUBAPRO = "Esquilmo, paja o rastrojo";
                }
                break;
            case R.id.rd_sub_aprv_2:
                if (checkedTipo) {
                    SUBAPRO = "Hojas (totomoxtle o jolochi)";
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
