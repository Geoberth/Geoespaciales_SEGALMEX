package com.example.geosegalmex.frutales;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.example.geosegalmex.caracterizacion.variables_caracterizacion.DatePickerFragment;
import com.example.geosegalmex.frutales.dbfrutales.VariablesFrutales;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class frutales_1 extends AppCompatActivity {

    private String TIPOFRUTAL = null; //tipo frutal
    private String OTROTIPOFRUTAL = null; //otro tipo frutal
    private String ESTFRU = null;    //	¿Año de establecimiento del frutal? 	1
    private String ESTABIPLA = null;    //	¿Año de estabilización de la plantación?	1
    private String SUPPLANT = null;    //	¿cuál es la superficie (ha) plantada total? 	1
    private String CONSUPNU = null;    //	Superficie nueva (ha)	1
    private String CONSUPDE = null;    //	Superficie en desarrollo (ha)	1
    private String CONSUPPRO = null;    //	Superficie en producción (ha)	1

    private String DECFRU = null;    //	¿Por qué decidió plantar este frutal?	1

    private String INFFRU = null;    //	¿Qué tipo de infraestructura utiliza?	1
    private String OTINFFRU = null;    //	Otro tipo de infraestructura utilizada	1

    private String AFESINI = null;    //	¿Su plantación tuvo alguna afectación por siniestro?	1
    private String CAUSINF = null;    //	¿Cuál fue la causa de la superficie siniestrada?	1

    private String ASOFRU = null;    //	¿Está asociado con otro cultivo?	1

    private String ASOFRUCUL = null;    //	¿Con cuál cultivo está asociado?	1
    private String FECHSICUL = null;    //	¿Cuál es la fecha de siembra del cultivo asociado?	1

    private String ASOCULT = null;    //	¿Ha recibido alguna asesoría para establecer otro cultivo? 	1
    private String OTROFRU = null;    //	¿Cuál cultivo?	1

    EditText edt1ftu1;
    EditText edt1ftu2;
    EditText edt1ftu3;
    EditText edt1ftu4;
    EditText edt1ftu5;
    EditText edt1ftu6;

    EditText edtOtrFrutal;

    EditText edtOtrInfra;
    EditText edtAsocCult;
    EditText edtFecAsocCult;
    EditText edtAserCult;

    ExtendedFloatingActionButton f1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutales_1);
        f1 = findViewById(R.id.fr1);

        edt1ftu1 = findViewById(R.id.car_an_rt_1);
        edt1ftu2 = findViewById(R.id.car_an_rt_2);
        edt1ftu3 = findViewById(R.id.car_an_rt_3);
        edt1ftu4 = findViewById(R.id.car_an_rt_4);
        edt1ftu5 = findViewById(R.id.car_an_rt_5);
        edt1ftu6 = findViewById(R.id.car_an_rt_6);

        edtOtrFrutal = findViewById(R.id.edt_otr_frt_sel);

        edtOtrInfra = findViewById(R.id.edt_otr_inf_frt);
        edtAsocCult = findViewById(R.id.edt_aso_frt_si);
        edtFecAsocCult = findViewById(R.id.edt_fch_cult_frt);
        edtAserCult = findViewById(R.id.edt_ase_frt);

        //Spinner Frutal Establecido
        final Spinner spinnerFrt = (Spinner) findViewById(R.id.spn_frt_frt_stab);
        ArrayAdapter<CharSequence> adapterFrt = ArrayAdapter.createFromResource(this,
                R.array.frutales, android.R.layout.simple_spinner_item);
        adapterFrt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrt.setAdapter(adapterFrt);
        spinnerFrt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                String selecFrtutal;
                selecFrtutal = parent.getSelectedItem().toString();
                seleccionFrutal(position, selecFrtutal);
                //  if (position != 0) {
                //    DECFRU = selecMotivo;
                // }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Log.e("========>>", parent.getSelectedItem().toString());
            }
        });


        //Spinner plantarFrutal
        final Spinner spinner = (Spinner) findViewById(R.id.spin_cart_mot_frt);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.caracterizacion_motivo, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                String selecMotivo;
                selecMotivo = parent.getSelectedItem().toString();
                if (position != 0) {
                    DECFRU = selecMotivo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Log.e("========>>", parent.getSelectedItem().toString());
            }
        });

        final Spinner spinner2 = (Spinner) findViewById(R.id.spin_cart_mot_frt_2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.caracterizacion_tipo_infraestructura, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                String selecInfra;
                selecInfra = parent.getSelectedItem().toString();
                //if(position != 0){
                //    INFFRU = selecInfra;
                activarEdtOtro(position, selecInfra);
                //}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Log.e("========>>", parent.getSelectedItem().toString());
            }
        });


        final Spinner spinner3 = (Spinner) findViewById(R.id.spin_cart_mot_frt_3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.caracterizacion_causa_supsiniestrada, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                String selecInfect;
                selecInfect = parent.getSelectedItem().toString();
                if (position != 0) {
                    CAUSINF = selecInfect;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Log.e("========>>", parent.getSelectedItem().toString());
            }
        });


        // End Spinner+++++++++++++++++++++++++++++++++++

        //Fecha
        edtFecAsocCult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(edtFecAsocCult);
            }
        });


        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacioValores();
                impresion();
                if(TIPOFRUTAL != null) {
                    startActivity(new Intent(getApplicationContext(), frutales_2.class));
                }else {
                    Toast.makeText(getBaseContext(), "Seleccione un frutal", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void seleccionFrutal(int position, String selecFrtutal) {
        switch (position) {
            case 0:
                TIPOFRUTAL = null;
                edtOtrFrutal.setText("");
                edtOtrFrutal.setEnabled(false);
                break;
            case 31:
                TIPOFRUTAL = selecFrtutal;
                edtOtrFrutal.setEnabled(true);
                break;
            default:
                TIPOFRUTAL = selecFrtutal;
                edtOtrFrutal.setText("");
                edtOtrFrutal.setEnabled(false);
                break;
        }
    }

    private void impresion() {
        System.out.println(ESTFRU);
        System.out.println(ESTABIPLA);
        System.out.println(SUPPLANT);
        System.out.println(CONSUPNU);
        System.out.println(CONSUPDE);
        System.out.println(CONSUPPRO);

        System.out.println(DECFRU);

        System.out.println(INFFRU);
        System.out.println(OTINFFRU);

        System.out.println(AFESINI);
        System.out.println(CAUSINF);

        System.out.println(ASOFRU);

        System.out.println(ASOFRUCUL);
        System.out.println(FECHSICUL);

        System.out.println(ASOCULT);
        System.out.println(OTROFRU);
    }

    private void asignacioValores() {

        if(!edtOtrFrutal.getText().toString().isEmpty()){
            OTROTIPOFRUTAL = edtOtrFrutal.getText().toString();
        }

        if (!edt1ftu1.getText().toString().isEmpty()) {
            ESTFRU = edt1ftu1.getText().toString();    //	¿Año de establecimiento del frutal? 	1
        }

        if (!edt1ftu2.getText().toString().isEmpty()) {
            ESTABIPLA = edt1ftu2.getText().toString();    //	¿Año de estabilización de la plantación?	1
        }

        if (!edt1ftu3.getText().toString().isEmpty()) {
            SUPPLANT = edt1ftu3.getText().toString();    //	¿cuál es la superficie (ha) plantada total? 	1
        }

        if (!edt1ftu4.getText().toString().isEmpty()) {
            CONSUPNU = edt1ftu4.getText().toString();    //	Superficie nueva (ha)	1
        }

        if (!edt1ftu5.getText().toString().isEmpty()) {
            CONSUPDE = edt1ftu5.getText().toString();    //	Superficie en desarrollo (ha)	1
        }

        if (!edt1ftu6.getText().toString().isEmpty()) {
            CONSUPPRO = edt1ftu6.getText().toString();    //	Superficie en producción (ha)	1
        }

        if (!edtOtrInfra.getText().toString().isEmpty()) {
            OTINFFRU = edtOtrInfra.getText().toString();    //	Otro tipo de infraestructura utilizada	1
        }

        if (!edtAsocCult.getText().toString().isEmpty()) {
            ASOFRUCUL = edtAsocCult.getText().toString();    //	¿Con cuál cultivo está asociado?	1
        }

        //    if(!edtFecAsocCult.getText().toString().isEmpty()) {
        //        FECHSICUL = edtFecAsocCult.getText().toString();    //	¿Cuál es la fecha de siembra del cultivo asociado?	1
        //    }


        if (!edtAserCult.getText().toString().isEmpty()) {
            OTROFRU = edtAserCult.getText().toString();    //	¿Cuál cultivo?	1
        }


        VariablesFrutales.TIPOFRUTAL = TIPOFRUTAL;    //	Tipo de Frutal
        VariablesFrutales.OTROTIPOFRUTAL = OTROTIPOFRUTAL;    // otro	Tipo de Frutal
        VariablesFrutales.ESTFRU = ESTFRU;    //	¿Año de establecimiento del frutal? 	1
        VariablesFrutales.ESTABIPLA = ESTABIPLA;    //	¿Año de estabilización de la plantación?	1
        VariablesFrutales.SUPPLANT = SUPPLANT;    //	¿cuál es la superficie (ha) plantada total? 	1
        VariablesFrutales.CONSUPNU = CONSUPNU;    //	Superficie nueva (ha)	1
        VariablesFrutales.CONSUPDE = CONSUPDE;    //	Superficie en desarrollo (ha)	1
        VariablesFrutales.CONSUPPRO = CONSUPPRO;    //	Superficie en producción (ha)	1

        VariablesFrutales.DECFRU = DECFRU;    //	¿Por qué decidió plantar este frutal?	1

        VariablesFrutales.INFFRU = INFFRU;    //	¿Qué tipo de infraestructura utiliza?	1
        VariablesFrutales.OTINFFRU = OTINFFRU;    //	Otro tipo de infraestructura utilizada	1

        VariablesFrutales.AFESINI = AFESINI;    //	¿Su plantación tuvo alguna afectación por siniestro?	1
        VariablesFrutales.CAUSINF = CAUSINF;    //	¿Cuál fue la causa de la superficie siniestrada?	1

        VariablesFrutales.ASOFRU = ASOFRU;    //	¿Está asociado con otro cultivo?	1

        VariablesFrutales.ASOFRUCUL = ASOFRUCUL;    //	¿Con cuál cultivo está asociado?	1
        VariablesFrutales.FECHSICUL = FECHSICUL;    //	¿Cuál es la fecha de siembra del cultivo asociado?	1

        VariablesFrutales.ASOCULT = ASOCULT;    //	¿Ha recibido alguna asesoría para establecer otro cultivo? 	1
        VariablesFrutales.OTROFRU = OTROFRU;    //	¿Cuál cultivo?	1

    }

    private void showDatePickerDialog(final EditText editText) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + "/" + (month + 1) + "/" + year;
                editText.setText(selectedDate);
                FECHSICUL = selectedDate;

            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    private void activarEdtOtro(int position, String selecInfra) {
        switch (position) {
            case 0:
                INFFRU = null;
                edtOtrInfra.setVisibility(View.INVISIBLE);
                edtOtrInfra.setText("");
                break;
            case 4:
                edtOtrInfra.setVisibility(View.VISIBLE);
                INFFRU = selecInfra;
                break;
            default:
                edtOtrInfra.setVisibility(View.INVISIBLE);
                INFFRU = selecInfra;
                edtOtrInfra.setText("");
                break;
        }
    }

    public void afetacionSinis(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_aft_si:
                if (checkedTipo) {
                    AFESINI = "Si";
                }
                break;
            case R.id.rd_aft_no:
                if (checkedTipo) {
                    AFESINI = "No";
                }
                break;
        }

    }

    public void asociadoCultivoFrut(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_aso_frt_si:
                if (checkedTipo) {
                    ASOFRU = "Si";
                    edtAsocCult.setEnabled(true);
                }
                break;
            case R.id.rd_aso_frt_no:
                if (checkedTipo) {
                    ASOFRU = "No";
                    edtAsocCult.setEnabled(false);
                    edtAsocCult.setText("");
                }
                break;
        }

    }

    public void asesoriaFrut(View view) {
        boolean checkedTipo = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_ase_frt_si:
                if (checkedTipo) {
                    ASOCULT = "Si";
                    edtAserCult.setEnabled(true);
                }
                break;
            case R.id.rd_ase_frt_no:
                if (checkedTipo) {
                    ASOCULT = "No";
                    edtAserCult.setEnabled(false);
                    edtAserCult.setText("");
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
