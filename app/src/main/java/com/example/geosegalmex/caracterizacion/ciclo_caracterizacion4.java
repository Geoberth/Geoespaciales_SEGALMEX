package com.example.geosegalmex.caracterizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.caracterizacion.variables_caracterizacion.VariablesModuloCuatro;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class ciclo_caracterizacion4 extends AppCompatActivity {

    //++++++++++++++++++++++++3
    EditText edtOtraCerficada;
    EditText edtPrecio;
    EditText edtCantidad;
    TextView txtTituloSemilla;

    private String TIPSEM= null;// Integer¿Qué tipo de semilla?
    private String SEMCER= null;// Integer¿Cuál?
    private String PRECSEM= null;// IntegerPrecio ($/kg)
    private String CANTSEM= null;// IntegerCantidad (kg/ha)

   //++++++++++++++++++++++++++++++++++++
    ExtendedFloatingActionButton siguiente4;


    private String SEPROSEL= null;// Integer¿En caso de utilizar semilla propia como la seleccionó?
    private String OTRTISELSE= null;// Integer¿Cuál?

    private String METSIEM= null;// Integer¿Qué método de siembra utiliza?

    private String TRATSEM= null;// Integer¿Le da algún tratamiento a la semilla?

    private String SISTLAB= null;// Integer¿Qué sistema de labranza utiliza?

    private String PJOR= null;// IntegerSi contrata mano de obra, ¿Cuánto es el precio del jornal? $

    EditText edtOtrSelSem;
    EditText edtManObraJrn;

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_caracterizacion4);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        siguiente4 = findViewById(R.id.btn_sig4);
        edtOtrSelSem = findViewById(R.id.edt_sp_otro_mr_cp);
        edtManObraJrn = findViewById(R.id.ext_madera_edit);

        //+++++++++++++++++3
        edtOtraCerficada = findViewById(R.id.semil_otra2);
        edtPrecio = findViewById(R.id.precio_seotra);
        edtCantidad = findViewById(R.id.cant_seotra);
        txtTituloSemilla = findViewById(R.id.semil_otra);

        //++++++++++++++++++++++

        db = new DatabaseHelper(this);

        //++++++++++++++++++++++++3
        final Spinner spinner = (Spinner) findViewById(R.id.spn_sml_agr);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.semillas_cultivo, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                String tipoSemilla;
                tipoSemilla = parent.getSelectedItem().toString();
                tipSemilla(tipoSemilla);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Log.e("========>>", parent.getSelectedItem().toString());
            }
        });

        //+++++++++++++++++++++++++



        siguiente4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //++++++++++++++++++3
                if(!edtOtraCerficada.getText().toString().isEmpty()){
                    SEMCER  = edtOtraCerficada.getText().toString();
                }

                if(!edtPrecio.getText().toString().isEmpty()){
                    PRECSEM = edtPrecio.getText().toString();
                }

                if(!edtCantidad.getText().toString().isEmpty()){
                    CANTSEM  = edtCantidad.getText().toString();
                }

                VariablesModuloCuatro.TIPSEM = TIPSEM;// Integer¿Qué tipo de semilla?
                VariablesModuloCuatro.SEMCER = SEMCER;// Integer¿Cuál?
                VariablesModuloCuatro.PRECSEM = PRECSEM;// IntegerPrecio ($/kg)
                VariablesModuloCuatro.CANTSEM = CANTSEM;// IntegerCantidad (kg/ha)

                //+++++++++++++++++++++++
                if(!edtOtrSelSem.getText().toString().isEmpty()){
                    OTRTISELSE = edtOtrSelSem.getText().toString();
                }

                if(!edtManObraJrn.getText().toString().isEmpty()){
                    PJOR = edtManObraJrn.getText().toString();
                }


                VariablesModuloCuatro.SEPROSEL = SEPROSEL;// Integer¿En caso de utilizar semilla propia como la seleccionó?
                VariablesModuloCuatro.OTRTISELSE = OTRTISELSE ;// Integer¿Cuál?
                VariablesModuloCuatro.METSIEM = METSIEM;// Integer¿Qué método de siembra utiliza?
                VariablesModuloCuatro.TRATSEM = TRATSEM;// Integer¿Le da algún tratamiento a la semilla?
                VariablesModuloCuatro.SISTLAB = SISTLAB;// Integer¿Qué sistema de labranza utiliza?
                VariablesModuloCuatro.PJOR = PJOR;// IntegerSi contrata mano de obra, ¿Cuánto es el precio del jornal? $

                if(VariablesModuloCuatro.TIPSEM != null) {
                    aggSemillaCultivo();
                }
                startActivity(new Intent(getApplicationContext(), ciclo_caracterizacion_tabla.class));
            }
        });
    }

    private void tipSemilla(String tipoSemilla) {
        switch (tipoSemilla) {
            case "Especifique el tipo de semilla":
                TIPSEM = null;
                edtPrecio.setEnabled(false);
                edtCantidad.setEnabled(false);
                edtOtraCerficada.setVisibility(View.INVISIBLE);
                txtTituloSemilla.setText("");
                edtPrecio.setText("");
                edtCantidad.setText("");
                edtOtraCerficada.setText("");
                break;
            case "Criolla propia":
                TIPSEM="Criolla propia";
                edtOtraCerficada.setVisibility(View.INVISIBLE);
                edtOtraCerficada.setText("");
                txtTituloSemilla.setText("Criolla propia");
                edtPrecio.setEnabled(true);
                edtCantidad.setEnabled(true);
                break;
            case "Criolla mejorada":
                TIPSEM="Criolla mejorada";
                edtOtraCerficada.setVisibility(View.INVISIBLE);
                edtOtraCerficada.setText("");
                txtTituloSemilla.setText("Criolla mejorada");
                edtPrecio.setEnabled(true);
                edtCantidad.setEnabled(true);
                break;
            case "Criolla de otra procedencia":
                TIPSEM=tipoSemilla;
                edtOtraCerficada.setVisibility(View.INVISIBLE);
                edtOtraCerficada.setText("");
                txtTituloSemilla.setText(tipoSemilla);
                edtPrecio.setEnabled(true);
                edtCantidad.setEnabled(true);
                break;
            case "Certificada":
                TIPSEM = "Certificada";
                edtOtraCerficada.setVisibility(View.VISIBLE);
                txtTituloSemilla.setText(tipoSemilla);
                edtPrecio.setEnabled(true);
                edtCantidad.setEnabled(true);
                break;
            case "Otra":
                TIPSEM = "Otra";
                edtOtraCerficada.setVisibility(View.VISIBLE);
                txtTituloSemilla.setText("Otra");
                edtPrecio.setEnabled(true);
                edtCantidad.setEnabled(true);
                break;
        }
    }

    private void aggSemillaCultivo() {
        boolean insertarData = db.addSemillaCultivo();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    public void utilSemiProSelecc(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.sp_color:
                if (checkedTipo) {
                    edtOtrSelSem.setEnabled(false);
                    edtOtrSelSem.setText("");
                    SEPROSEL = "Color";
                }
                break;
            case R.id.sp_tam:
                if (checkedTipo) {
                    edtOtrSelSem.setEnabled(false);
                    edtOtrSelSem.setText("");
                    SEPROSEL = "Tamaño";
                }
                break;
            case R.id.sp_llenado:
                if (checkedTipo) {
                    edtOtrSelSem.setEnabled(false);
                    edtOtrSelSem.setText("");
                    SEPROSEL = "Llenado de mazorca, cápsula, espiga y/o panoja";
                }
                break;
            case R.id.sp_otro_mr_cp:
                if (checkedTipo) {
                    edtOtrSelSem.setEnabled(true);
                    SEPROSEL = "Otro";
                }
                break;
        }
    }

    public void utilMetodoSie(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.volteo:
                if (checkedTipo) {
                    METSIEM = "Al voleo";
                }
                break;
            case R.id.hilera:
                if (checkedTipo) {
                    METSIEM = "En surcos, una hilera";
                }
                break;
            case R.id.doble_h:
                if (checkedTipo) {
                    METSIEM = "En surcos, doble hilera";
                }
                break;
        }
    }

    public void tramientoSemilla(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.trata_si:
                if (checkedTipo) {
                    TRATSEM = "Si";
                }
                break;
            case R.id.trata_no:
                if (checkedTipo) {
                    TRATSEM = "No";
                }
                break;
        }
    }

    public void sistemaLabranza(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.conven:
                if (checkedTipo) {
                    SISTLAB = "Convencional (tradicional)";
                }
                break;
            case R.id.labran:
                if (checkedTipo) {
                    SISTLAB = "Labranza reducida o mínima";
                }
                break;
            case R.id.labracero:
                if (checkedTipo) {
                    SISTLAB = "Labranza cero";
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
