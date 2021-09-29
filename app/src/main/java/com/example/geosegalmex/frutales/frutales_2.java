package com.example.geosegalmex.frutales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.geosegalmex.R;
import com.example.geosegalmex.frutales.dbfrutales.VariablesFrutales;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class frutales_2 extends AppCompatActivity {
    ExtendedFloatingActionButton f2;

    private String PROPLANT = null;    //	¿Cuál es la procedencia de su plantación?	2
    private String PROPLANTOTRO = null;    //	¿Cuál es la procedencia de su plantación? OTRO	2

    private String TIPVIVFRU = null;    //	¿El vivero es?	2

    private String PROPLANTD = null;    //	¿De dónde procede su plantación?	2
    private String PROPLANTDOTRO = null;    //¿De dónde procede su plantación? OTRO

    private String VARFRU = null;    //	¿Qué variedad tiene?	2
    private String VARFRUC = null;    //	¿Cuál? CERTIFICADA Y OTRO	2

    private String MODSELVF = null;    //	¿Por qué selecciono dicha variedad?	2
    private String MODSELVFO = null;    //	¿Por qué selecciono dicha variedad? OTRO	2

    private String DENDFRU = null;    //	¿Cuál es la densidad de plantación por hectárea? 	2
    private String COSPLANFRU = null;    //	¿Cuál es el costo por planta? $/planta	2
    private String DISTFRUT = null;    //	¿Cuál es la distancia entre hileras y entre plantas?	2


    EditText edtProPlnt;
    EditText edtProPlnt2;
    EditText edtProPlntss;
    EditText edtProPlnt4;

    EditText edtProPlnt5;
    EditText edtProPlnt6;
    EditText edtProPlnt7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutales_2);
        f2 = findViewById(R.id.fr2);

        edtProPlnt = findViewById(R.id.edt_otr_pro_pln_frt);
        edtProPlnt2 = findViewById(R.id.edt_otr_pro_pln_frt_2);
        edtProPlntss = findViewById(R.id.edt_otr_pro_pln_frt_ss);
        edtProPlnt4 = findViewById(R.id.edt_otr_pro_pln_frt_4);
        edtProPlnt5 = findViewById(R.id.edt_otr_pro_pln_frt_5);
        edtProPlnt6 = findViewById(R.id.edt_otr_pro_pln_frt_6);
        edtProPlnt7 = findViewById(R.id.edt_otr_pro_pln_frt_7);

        //++++++++++++++++++Spiners++++++++++++++++++++

        //Spinners1
        final Spinner spinner = (Spinner) findViewById(R.id.spin_pro_pln_frt);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.caracterizacion_procedencia_plantacion, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                String selecProcd;
                selecProcd = parent.getSelectedItem().toString();
                procedenciaPlantacion(position, selecProcd);
                //  if (position != 0) {
                //    DECFRU = selecMotivo;
                // }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Log.e("========>>", parent.getSelectedItem().toString());
            }
        });

        //Spinners2
        final Spinner spinner2 = (Spinner) findViewById(R.id.spin_pro_pln_frt2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.caracterizacion_tipo_vivero, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                String selecVivero;
                selecVivero = parent.getSelectedItem().toString();
                //procedenciaVivero(position, selecVivero);
                if (position != 0) {
                    TIPVIVFRU = selecVivero;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Log.e("========>>", parent.getSelectedItem().toString());
            }
        });


        //Spinners3
        final Spinner spinner3 = (Spinner) findViewById(R.id.spin_pro_pln_frt3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.caracterizacion_procedencia_de_plantacion, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                String selecOrigen;
                selecOrigen = parent.getSelectedItem().toString();
                procedenciaOrigen(position, selecOrigen);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Log.e("========>>", parent.getSelectedItem().toString());
            }
        });


        //Spinners4
        final Spinner spinner4 = (Spinner) findViewById(R.id.spin_pro_pln_frt4);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.caracterizacion_variedad, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                String selecVariedad;
                selecVariedad = parent.getSelectedItem().toString();
                procedenciaVariedad(position, selecVariedad);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Log.e("========>>", parent.getSelectedItem().toString());
            }
        });

        //Spinners5
        final Spinner spinner5 = (Spinner) findViewById(R.id.spin_pro_pln_frt5);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this,
                R.array.caracterizacion_motivo_variedad, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("========>>", parent.getSelectedItem().toString());
                String selecVariedad2;
                selecVariedad2 = parent.getSelectedItem().toString();
                seleccVariedad(position, selecVariedad2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Log.e("========>>", parent.getSelectedItem().toString());
            }
        });


        //+++++++++++++++++++++++++++++++++++++++++++++


        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignacionEdt();
                impresion();
                startActivity(new Intent(getApplicationContext(), frutales_3.class));
            }
        });
    }

    private void impresion() {
        System.out.println(PROPLANT);    //	¿Cuál es la procedencia de su plantación?	2
        System.out.println(PROPLANTOTRO);    //	¿Cuál es la procedencia de su plantación? OTRO	2

        System.out.println(TIPVIVFRU);    //	¿El vivero es?	2

        System.out.println(PROPLANTD);    //	¿De dónde procede su plantación?	2
        System.out.println(PROPLANTDOTRO);    //¿De dónde procede su plantación? OTRO

        System.out.println(VARFRU);    //	¿Qué variedad tiene?	2
        System.out.println(VARFRUC);    //	¿Cuál? CERTIFICADA Y OTRO	2

        System.out.println(MODSELVF);    //	¿Por qué selecciono dicha variedad?	2
        System.out.println(MODSELVFO);    //	¿Por qué selecciono dicha variedad? OTRO	2

        System.out.println(DENDFRU);    //	¿Cuál es la densidad de plantación por hectárea? 	2
        System.out.println(COSPLANFRU);    //	¿Cuál es el costo por planta? $/planta	2
        System.out.println(DISTFRUT);    //	¿Cuál es la distancia entre hileras y entre plantas?	2

    }

    private void seleccVariedad(int position, String selecVariedad2) {
        switch (position) {
            case 0:
                MODSELVF = null;
                edtProPlnt4.setText("");
                edtProPlnt4.setVisibility(View.INVISIBLE);
                break;
            case 5:
                MODSELVF = selecVariedad2;
                edtProPlnt4.setVisibility(View.VISIBLE);
                break;
            default:
                MODSELVF = selecVariedad2;
                edtProPlnt4.setText("");
                edtProPlnt4.setVisibility(View.INVISIBLE);
                break;
        }

    }

    private void procedenciaVariedad(int position, String selecVariedad) {
        switch (position) {
            case 0:
                VARFRU = null;
                edtProPlntss.setVisibility(View.INVISIBLE);
                edtProPlntss.setText("");
                break;
            case 3:
                VARFRU = selecVariedad;
                edtProPlntss.setVisibility(View.VISIBLE);
                break;
            case 4:
                VARFRU = selecVariedad;
                edtProPlntss.setVisibility(View.VISIBLE);
                break;
            default:
                edtProPlntss.setVisibility(View.INVISIBLE);
                edtProPlntss.setText("");
                VARFRU = selecVariedad;
                break;
        }
    }

    private void procedenciaOrigen(int position, String selecOrigen) {
        switch (position) {
            case 0:
                PROPLANTD = null;
                edtProPlnt2.setVisibility(View.INVISIBLE);
                edtProPlnt2.setText("");
                break;
            case 6:
                PROPLANTD = selecOrigen;
                edtProPlnt2.setVisibility(View.VISIBLE);
                break;
            default:
                PROPLANTD = selecOrigen;
                edtProPlnt2.setVisibility(View.INVISIBLE);
                edtProPlnt2.setText("");
                break;
        }
    }

    private void asignacionEdt() {
        if (!edtProPlnt.getText().toString().isEmpty()) {
            PROPLANTOTRO = edtProPlnt.getText().toString();
        }

        if (!edtProPlnt2.getText().toString().isEmpty()) {
            PROPLANTDOTRO = edtProPlnt2.getText().toString();
        }

        if (!edtProPlntss.getText().toString().isEmpty()) {
            VARFRUC = edtProPlntss.getText().toString();
        }

        if (!edtProPlnt4.getText().toString().isEmpty()) {
            MODSELVFO = edtProPlnt4.getText().toString();
        }

        if (!edtProPlnt5.getText().toString().isEmpty()) {
            DENDFRU = edtProPlnt5.getText().toString();
        }

        if (!edtProPlnt6.getText().toString().isEmpty()) {
            COSPLANFRU = edtProPlnt6.getText().toString();
        }

        if (!edtProPlnt7.getText().toString().isEmpty()) {
            DISTFRUT = edtProPlnt7.getText().toString();
        }

        VariablesFrutales.PROPLANT = PROPLANT;    //	¿Cuál es la procedencia de su plantación?	2
        VariablesFrutales.PROPLANTOTRO = PROPLANTOTRO;    //	¿Cuál es la procedencia de su plantación? OTRO	2

        VariablesFrutales.TIPVIVFRU = TIPVIVFRU;    //	¿El vivero es?	2

        VariablesFrutales.PROPLANTD = PROPLANTD;    //	¿De dónde procede su plantación?	2
        VariablesFrutales.PROPLANTDOTRO = PROPLANTDOTRO;    //¿De dónde procede su plantación? OTRO

        VariablesFrutales.VARFRU = VARFRU;    //	¿Qué variedad tiene?	2
        VariablesFrutales.VARFRUC = VARFRUC;    //	¿Cuál? CERTIFICADA Y OTRO	2

        VariablesFrutales.MODSELVF = MODSELVF;    //	¿Por qué selecciono dicha variedad?	2
        VariablesFrutales.MODSELVFO = MODSELVFO;    //	¿Por qué selecciono dicha variedad? OTRO	2

        VariablesFrutales.DENDFRU = DENDFRU;    //	¿Cuál es la densidad de plantación por hectárea? 	2
        VariablesFrutales.COSPLANFRU = COSPLANFRU;    //	¿Cuál es el costo por planta? $/planta	2
        VariablesFrutales.DISTFRUT = DISTFRUT;

    }

    private void procedenciaPlantacion(int position, String selecProcd) {
        switch (position) {
            case 0:
                PROPLANT = null;
                edtProPlnt.setVisibility(View.INVISIBLE);
                edtProPlnt.setText("");
                break;
            case 3:
                PROPLANT = selecProcd;
                edtProPlnt.setVisibility(View.VISIBLE);
                break;
            default:
                PROPLANT = selecProcd;
                edtProPlnt.setVisibility(View.INVISIBLE);
                edtProPlnt.setText("");
                break;

        }
    }
    @Override
    public void onBackPressed() {

    }
}
