package com.example.geosegalmex.Pecuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.Pecuario.GlobalPecuario.GlobalPecuario;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

public class EstructuraDelHato extends AppCompatActivity {


    //Variables locales
    private String BOVSEMENTALES = null;
    private String BOVSEMCANTIDADCAB = null;
    private String BOVSEMPRECIOCAB = null;

    private String BOVVIENTADULTAS = null;
    private String BOVVIENTADULTACANTCAB = null;
    private String BOVVIENTADULTAPRECIO = null;

    private String BOVVAQUILLAS = null;
    private String BOVVAQUILLASCANTCAB = null;
    private String BOVVAQUILLASPRECIO = null;

    private String BOVVIENTDESARROLLO = null;
    private String BOVVIENTDESARROLLOCANTCAB = null;
    private String BOVVIENTDESARROLLOPRECIO = null;


    private String BOVBECERROS = null;
    private String BOVBECERROSCANTCAB = null;
    private String BOVBECERROSPRECIO = null;

    private String BOVTORETESDES = null;
    private String BOVTORETESDESCANTCAB = null;
    private String BOVTORETESDESPRECIO = null;

    private String BOVTORETESFINAL = null;
    private String BOVTORETESFINALCANTCAB = null;
    private String BOVTORETESFINALPRECIO = null;



    //Del checkBox Sementales
    CheckBox checkGanbovsem;

    TextView txtGanbovsemcab;
    EditText edtGanbovsemcab;

    TextView txtGanbovsemval;
    EditText edtGanbovsemval;




    //Del checkBox Vientres(Vaca adulta)
    CheckBox checkGanbovvient;

    TextView txtGanbovvientcab;
    EditText edtGanbovvientcab;

    TextView txtGanbovvientval;
    EditText edtGanbovvientval;





    //Del checkBox Vaquillas
    CheckBox checkGanbovvaq;

    TextView txtGanbovvaqcab;
    EditText edtGanbovvaqcab;

    TextView txtGanbovvaqval;
    EditText edtGanbovvaqval;






    //Del checkBox Vientres en desarrollo;
    CheckBox checkGanbovvientdes;

    TextView txtGanbovvientdescab;
    EditText edtGanbovvientdescab;

    TextView txtGanbovvientdesval;
    EditText edtGanbovvientdesval;





    //Del checkBox Becerros;
    CheckBox checkGanbovbec;

    TextView txtGanbovbeccab;
    EditText edtGanbovbeccab;

    TextView txtGanbovbecval;
    EditText edtGanbovbecval;





    //Del checkBox Toretes en desarrollo;
    CheckBox checkGanbovtoredes;

    TextView txtGanbovtoredescab;
    EditText edtGanbovtoredescab;

    TextView txtGanbovtoredesval;
    EditText edtGanbovtoredesval;




    //Del checkBox Toretes en finalizacion;
    CheckBox checkGanbovtorefin;

    TextView txtGanbovtorefincab;
    EditText edtGanbovtorefincab;

    TextView txtGanbovtorefinval;
    EditText edtGanbovtorefinval;




    Button btnPecuestructurahato;


    //BASE DE DATOS
    private DatabaseHelper baseBD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estructura_del_hato);

        ///////////////////////////// 1 ////////////////////////////////////
        txtGanbovsemcab = (TextView) findViewById(R.id.txtGanbovsemcab);
        edtGanbovsemcab = (EditText) findViewById(R.id.edtGanbovsemcab);

        txtGanbovsemval = (TextView) findViewById(R.id.txtGanbovsemval);
        edtGanbovsemval = (EditText) findViewById(R.id.edtGanbovsemval);


        /////////////////////////////// 2 //////////////////////////////////
        txtGanbovvientcab = (TextView) findViewById(R.id.txtGanbovvientcab);
        edtGanbovvientcab = (EditText) findViewById(R.id.edtGanbovvientcab);

        txtGanbovvientval = (TextView) findViewById(R.id.txtGanbovvientval);
        edtGanbovvientval = (EditText) findViewById(R.id.edtGanbovvientval);


        ////////////////////////////// 3 ////////////////////////////////////
        txtGanbovvaqcab = (TextView) findViewById(R.id.txtGanbovvaqcab);
        edtGanbovvaqcab = (EditText) findViewById(R.id.edtGanbovvaqcab);

        txtGanbovvaqval = (TextView) findViewById(R.id.txtGanbovvaqval);
        edtGanbovvaqval = (EditText) findViewById(R.id.edtGanbovvaqval);


        ////////////////////////////// 4 ///////////////////////////////////
        txtGanbovvientdescab = (TextView) findViewById(R.id.txtGanbovvientdescab);
        edtGanbovvientdescab = (EditText) findViewById(R.id.edtGanbovvientdescab);

        txtGanbovvientdesval = (TextView) findViewById(R.id.txtGanbovvientdesval);
        edtGanbovvientdesval = (EditText) findViewById(R.id.edtGanbovvientdesval);


        /////////////////////////////// 5 ////////////////////////////////////////
        txtGanbovbeccab = (TextView) findViewById(R.id.txtGanbovbeccab);
        edtGanbovbeccab = (EditText) findViewById(R.id.edtGanbovbeccab);

        txtGanbovbecval = (TextView) findViewById(R.id.txtGanbovbecval);
        edtGanbovbecval = (EditText) findViewById(R.id.edtGanbovbecval);


        /////////////////////////////// 6 ///////////////////////////////////////
        txtGanbovtoredescab = (TextView) findViewById(R.id.txtGanbovtoredescab);
        edtGanbovtoredescab = (EditText) findViewById(R.id.edtGanbovtoredescab);

        txtGanbovtoredesval = (TextView) findViewById(R.id.txtGanbovtoredesval);
        edtGanbovtoredesval = (EditText) findViewById(R.id.edtGanbovtoredesval);


        /////////////////////////////// 7 //////////////////////////////////////
        txtGanbovtorefincab = (TextView) findViewById(R.id.txtGanbovtorefincab);
        edtGanbovtorefincab = (EditText) findViewById(R.id.edtGanbovtorefincab);

        txtGanbovtorefinval = (TextView) findViewById(R.id.txtGanbovtorefinval);
        edtGanbovtorefinval = (EditText) findViewById(R.id.edtGanbovtorefinval);



        //Botones
        btnPecuestructurahato = (Button)findViewById(R.id.pecuario_next_estructura_hato);


        //BD
        baseBD         = new DatabaseHelper(this);


        btnPecuestructurahato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean validaHato = validaEstructura();

               // if (validaHato){
              //      Toast.makeText(getApplicationContext(), "Faltan datos, al menos 1", Toast.LENGTH_SHORT).show();
              // }else{


                    validaCamposEstructura();

                    GlobalPecuario.BOVSEMENTALES = BOVSEMENTALES;
                    GlobalPecuario.BOVSEMCANTIDADCAB = BOVSEMCANTIDADCAB;
                    GlobalPecuario.BOVSEMPRECIOCAB = BOVSEMPRECIOCAB;

                    GlobalPecuario.BOVVIENTADULTAS = BOVVIENTADULTAS;
                    GlobalPecuario.BOVVIENTADULTACANTCAB = BOVVIENTADULTACANTCAB;
                    GlobalPecuario.BOVVIENTADULTAPRECIO = BOVVIENTADULTAPRECIO;

                    GlobalPecuario.BOVVAQUILLAS = BOVVAQUILLAS;
                    GlobalPecuario.BOVVAQUILLASCANTCAB = BOVVAQUILLASCANTCAB;
                    GlobalPecuario.BOVVAQUILLASPRECIO = BOVVAQUILLASPRECIO;

                    GlobalPecuario.BOVVIENTDESARROLLO = BOVVIENTDESARROLLO;
                    GlobalPecuario.BOVVIENTDESARROLLOCANTCAB = BOVVIENTDESARROLLOCANTCAB;
                    GlobalPecuario.BOVVIENTDESARROLLOPRECIO = BOVVIENTDESARROLLOPRECIO;

                    GlobalPecuario.BOVBECERROS = BOVBECERROS;
                    GlobalPecuario.BOVBECERROSCANTCAB = BOVBECERROSCANTCAB;
                    GlobalPecuario.BOVBECERROSPRECIO = BOVBECERROSPRECIO;

                    GlobalPecuario.BOVTORETESDES = BOVTORETESDES;
                    GlobalPecuario.BOVTORETESDESCANTCAB = BOVTORETESDESCANTCAB;
                    GlobalPecuario.BOVTORETESDESPRECIO = BOVTORETESDESPRECIO;

                    GlobalPecuario.BOVTORETESFINAL = BOVTORETESFINAL;
                    GlobalPecuario.BOVTORETESFINALCANTCAB = BOVTORETESFINALCANTCAB;
                    GlobalPecuario.BOVTORETESFINALPRECIO = BOVTORETESFINALPRECIO;

                    agregarEstructurahato();

                    Toast.makeText(getApplicationContext(), "Agregado correctamente ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(EstructuraDelHato.this, InventarioGanBovinoLeche.class));
                    finish();

              //  }




            }
        });


    }




    //INSERCION DE DATOS
    public void agregarEstructurahato(){



        addPecuesthato();

    }




    ///Agregar Estructura del Hato

    private void addPecuesthato(){
        boolean insertarData = baseBD.addEstructurahato();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }



    public void clickGanbovcarneleche(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkGanbovsem:
                if (checked) {
                    txtGanbovsemcab.setVisibility(View.VISIBLE);
                    edtGanbovsemcab.setVisibility(View.VISIBLE);
                    txtGanbovsemval.setVisibility(View.VISIBLE);
                    edtGanbovsemval.setVisibility(View.VISIBLE);

                    BOVSEMENTALES = "Sementales";


                } else {
                    txtGanbovsemcab.setVisibility(View.GONE);
                    edtGanbovsemcab.setVisibility(View.GONE);
                    txtGanbovsemval.setVisibility(View.GONE);
                    edtGanbovsemval.setVisibility(View.GONE);

                    BOVSEMENTALES = null;

                }
                break;

            case R.id.checkGanbovvient:
                if (checked) {

                    txtGanbovvientcab.setVisibility(View.VISIBLE);
                    edtGanbovvientcab.setVisibility(View.VISIBLE);
                    txtGanbovvientval.setVisibility(View.VISIBLE);
                    edtGanbovvientval.setVisibility(View.VISIBLE);

                    BOVVIENTADULTAS = "Vientres (vaca adulta)";


                }else{

                    txtGanbovvientcab.setVisibility(View.GONE);
                    edtGanbovvientcab.setVisibility(View.GONE);
                    txtGanbovvientval.setVisibility(View.GONE);
                    edtGanbovvientval.setVisibility(View.GONE);

                    BOVVIENTADULTAS = null;

                }
                break;


            case R.id.checkGanbovvaq:
                if (checked) {
                    txtGanbovvaqcab.setVisibility(View.VISIBLE);
                    edtGanbovvaqcab.setVisibility(View.VISIBLE);
                    txtGanbovvaqval.setVisibility(View.VISIBLE);
                    edtGanbovvaqval.setVisibility(View.VISIBLE);

                    BOVVAQUILLAS = "Vaquillas (del servicio al primer parto)";


                }else{

                    txtGanbovvaqcab.setVisibility(View.GONE);
                    edtGanbovvaqcab.setVisibility(View.GONE);
                    txtGanbovvaqval.setVisibility(View.GONE);
                    edtGanbovvaqval.setVisibility(View.GONE);

                    BOVVAQUILLAS = null;

                }
                break;


            case R.id.checkGanbovvientdes:
                if (checked) {

                    txtGanbovvientdescab.setVisibility(View.VISIBLE);
                    edtGanbovvientdescab.setVisibility(View.VISIBLE);
                    txtGanbovvientdesval.setVisibility(View.VISIBLE);
                    edtGanbovvientdesval.setVisibility(View.VISIBLE);

                    BOVVIENTDESARROLLO = "Vientres en desarrollo (destete a servicio)";

                }else{

                    txtGanbovvientdescab.setVisibility(View.GONE);
                    edtGanbovvientdescab.setVisibility(View.GONE);
                    txtGanbovvientdesval.setVisibility(View.GONE);
                    edtGanbovvientdesval.setVisibility(View.GONE);

                    BOVVIENTDESARROLLO = null;


                }
                break;



            case R.id.checkGanbovbec:
                if (checked) {

                    txtGanbovbeccab.setVisibility(View.VISIBLE);
                    edtGanbovbeccab.setVisibility(View.VISIBLE);
                    txtGanbovbecval.setVisibility(View.VISIBLE);
                    edtGanbovbecval.setVisibility(View.VISIBLE);

                    BOVBECERROS = "Becerros (sin destetar)";

                }else{


                    txtGanbovbeccab.setVisibility(View.GONE);
                    edtGanbovbeccab.setVisibility(View.GONE);
                    txtGanbovbecval.setVisibility(View.GONE);
                    edtGanbovbecval.setVisibility(View.GONE);

                    BOVBECERROS = null;

                }
                break;



            case R.id.checkGanbovtoredes:
                if (checked) {

                    txtGanbovtoredescab.setVisibility(View.VISIBLE);
                    edtGanbovtoredescab.setVisibility(View.VISIBLE);
                    txtGanbovtoredesval.setVisibility(View.VISIBLE);
                    edtGanbovtoredesval.setVisibility(View.VISIBLE);

                    BOVTORETESDES = "Toretes en desarrollo y/o engorde";

                }else{

                    txtGanbovtoredescab.setVisibility(View.GONE);
                    edtGanbovtoredescab.setVisibility(View.GONE);
                    txtGanbovtoredesval.setVisibility(View.GONE);
                    edtGanbovtoredesval.setVisibility(View.GONE);

                    BOVTORETESDES = null;

                }
                break;



            case R.id.checkGanbovtorefin:
                if (checked) {
                    txtGanbovtorefincab.setVisibility(View.VISIBLE);
                    edtGanbovtorefincab.setVisibility(View.VISIBLE);
                    txtGanbovtorefinval.setVisibility(View.VISIBLE);
                    edtGanbovtorefinval.setVisibility(View.VISIBLE);

                    BOVTORETESFINAL = "Toretes en finalización";

                }else{


                    txtGanbovtorefincab.setVisibility(View.GONE);
                    edtGanbovtorefincab.setVisibility(View.GONE);
                    txtGanbovtorefinval.setVisibility(View.GONE);
                    edtGanbovtorefinval.setVisibility(View.GONE);

                    BOVTORETESFINAL = null;

                }
                break;
        }
    }




    private void validaCamposEstructura(){

        if (BOVSEMENTALES != null){

            BOVSEMCANTIDADCAB = edtGanbovsemcab.getText().toString();
            BOVSEMPRECIOCAB = edtGanbovsemval.getText().toString();
        }else{

            BOVSEMCANTIDADCAB = null;
            BOVSEMPRECIOCAB = null;
        }




        if(BOVVIENTADULTAS != null){

            BOVVIENTADULTACANTCAB = edtGanbovvientcab.getText().toString();
            BOVVIENTADULTAPRECIO = edtGanbovvientval.getText().toString();

        }else{

            BOVVIENTADULTACANTCAB = null;
            BOVVIENTADULTAPRECIO = null;
        }



        if(BOVVAQUILLAS != null){

            BOVVAQUILLASCANTCAB = edtGanbovvaqcab.getText().toString();
            BOVVAQUILLASPRECIO = edtGanbovvaqval.getText().toString();

        }else{

            BOVVAQUILLASCANTCAB = null;
            BOVVAQUILLASPRECIO = null;
        }






        if(BOVVIENTDESARROLLO != null){

            BOVVIENTDESARROLLOCANTCAB = edtGanbovvientdescab.getText().toString();
            BOVVIENTDESARROLLOPRECIO = edtGanbovvientdesval.getText().toString();

        }else{
            BOVVIENTDESARROLLOCANTCAB = null;
            BOVVIENTDESARROLLOPRECIO = null;

        }




        if(BOVBECERROS != null){

            BOVBECERROSCANTCAB = edtGanbovbeccab.getText().toString();
            BOVBECERROSPRECIO = edtGanbovbecval.getText().toString();

        }else{

            BOVBECERROSCANTCAB = null;
            BOVBECERROSPRECIO = null;

        }





        if(BOVTORETESDES != null){

            BOVTORETESDESCANTCAB = edtGanbovtoredescab.getText().toString();
            BOVTORETESDESPRECIO = edtGanbovtoredesval.getText().toString();

        }else{

            BOVTORETESDESCANTCAB = null;
            BOVTORETESDESPRECIO = null;

        }



        if(BOVTORETESFINAL != null){

            BOVTORETESFINALCANTCAB = edtGanbovtorefincab.getText().toString();
            BOVTORETESFINALPRECIO = edtGanbovtorefinval.getText().toString();

        }else{

            BOVTORETESFINALCANTCAB = null;
            BOVTORETESFINALPRECIO = null;

        }

    }


    private Boolean validaEstructura(){

        if(BOVSEMENTALES != null || BOVVIENTADULTAS != null || BOVVAQUILLAS != null
                || BOVVIENTDESARROLLO != null || BOVBECERROS != null || BOVTORETESDES != null || BOVTORETESFINAL != null){
            return false;
        }else {
            return true;
        }
    }



    @Override
    public void onBackPressed() {

    }

}
