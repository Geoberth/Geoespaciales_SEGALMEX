package com.example.geosegalmex.unidadcaracterizacionhortalizas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.caracterizacion.variables_caracterizacion.DatePickerFragment;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.variables.VariblesGlobalesHortalizas;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class FertilizanteSi extends AppCompatActivity {
    Button btnOtroFert;
    ExtendedFloatingActionButton fabFertFe;

    EditText edtFert;
    EditText edtFchApli;
    EditText edtCntd;
    EditText edtCstFert;
    EditText edtNmj;


    String txtpFertAbon = null;
    String txtFech = null;
    String txtCnt = null;
    String txtCstFert = null;
    String txtNmJ = null;

    String txtMtAplicacion = null;


    private String FERTGRA = null;    //	Text
    private String EFFRUT = null;    //	Text
    private String FERAPPG = null;    //	Text
    private String FERCANG = null;    //	Integer
    private String FERCOSG = null;    //	Integer
    private String FERJORG = null;    //	Integer
    private String METHORT = null;    //	Text
    private String METHORTA = null;    //	Text

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizante_si);

        btnOtroFert = findViewById(R.id.btn_oto_fet_fe);
        fabFertFe = findViewById(R.id.fab_next_fet_fe);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        edtFert = findViewById(R.id.edit_fer_fe);
        edtFchApli = findViewById(R.id.edit_fc_fe);
        edtCntd = findViewById(R.id.edit_can_fe);
        edtCstFert = findViewById(R.id.edit_cost_fer_fe);
        edtNmj = findViewById(R.id.edit_nm_jor_fe);

        //edtOtrMetApli = findViewById(R.id.edt_met_otr_fer);

        db = new DatabaseHelper(this);

        edtFchApli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(edtFchApli);
            }
        });

        btnOtroFert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean valorFert = false;

                valorFert = validTabTipoFertilizante();

                if (valorFert) {
                    aggFertilizante();
                    startActivity(new Intent(getBaseContext(), FertilizanteSi.class));
                } else {
                    Snackbar snackbar = Snackbar.make(v, "Ingrese el tipo de fertilizante", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
        });

        fabFertFe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean valorFert = false;

                valorFert = validTabTipoFertilizante();

                if (valorFert) {
                    aggFertilizante();
                    startActivity(new Intent(getBaseContext(), FoliarRiego.class));
                } else {
                    Snackbar snackbar = Snackbar.make(v, "Ingrese el tipo de fertilizante", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
        });
    }

    private void showDatePickerDialog(final EditText editText) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + "/" + (month + 1) + "/" + year;
                editText.setText(selectedDate);
                FERAPPG = selectedDate;

            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    private Boolean validTabTipoFertilizante() {

        if (!edtFert.getText().toString().isEmpty()) {
            txtpFertAbon = edtFert.getText().toString();
            //  txtFech       = edtFchApli.getText().toString();
            txtCnt = edtCntd.getText().toString();
            txtCstFert = edtCstFert.getText().toString();
            txtNmJ = edtNmj.getText().toString();

            VariblesGlobalesHortalizas.FERTGRA = txtpFertAbon;    //	Text
            VariblesGlobalesHortalizas.EFFRUT = "FRUTALES";    //	Text Etapa Fonologica solo frutales
            //  VariblesGlobalesHortalizas.FERAPPG	= txtFech;	//	Text
            VariblesGlobalesHortalizas.FERAPPG = FERAPPG;    //	Text
            VariblesGlobalesHortalizas.FERCANG = txtCnt;    //	Integer
            VariblesGlobalesHortalizas.FERCOSG = txtCstFert;    //	Integer
            VariblesGlobalesHortalizas.FERJORG = txtNmJ;    //	Integer
            VariblesGlobalesHortalizas.METHORT = txtMtAplicacion;    //	Text
            //VariblesGlobalesHortalizas.METHORTA	= "otro Null";	//	Text
            return true;
        }
        return false;
    }


    private void aggFertilizante() {
        boolean insertarData = db.addFertilizante();
        if (insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }

    public void metodoAplicacion(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.edt_met_rad_fer:
                if (checkedTipo) {
                    txtMtAplicacion = "Radicular";
                }
                break;
            case R.id.edt_met_fer_fer:
                if (checkedTipo) {
                    txtMtAplicacion = "Fertirrigación";
                }
                break;
            case R.id.edt_met_sue_fer:
                if (checkedTipo) {
                    txtMtAplicacion = "Al suelo";
                }
                break;
            case R.id.edt_met_fol_fer:
                if (checkedTipo) {
                    txtMtAplicacion = "Foliar";
                }
                break;
          /*
            case R.id.edt_met_otr_fer:
                if (checkedTipo) {
                    txtMtAplicacion = "Otro";
                }
                break;

           */
        }
    }

    @Override
    public void onBackPressed() {

    }
}
