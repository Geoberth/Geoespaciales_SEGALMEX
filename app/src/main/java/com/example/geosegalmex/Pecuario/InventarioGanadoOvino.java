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

public class InventarioGanadoOvino extends AppCompatActivity {

    //variables locales
    private String OVINOSEMENTAL = null;
    private String OVISEMCANTIDAD = null;
    private String OVISEMEPRECIO = null;

    private String OVIBORREGADUL = null;
    private String OVIBORREGADULCANTIDAD = null;
    private String OVIBORREGADULPRECIO = null;

    private String OVIPRIMALASPROD = null;
    private String OVIPRIMALASCANTIDAD = null;
    private String OVIPRIMALASPRECIO = null;

    private String OVICORDERAS  = null;
    private String OVICORDERASCANTIDAD = null;
    private String OVICORDERASPRECIO = null;

    private String OVICORDEROSLACT = null;
    private String OVICORDEROSLACTCANTIDAD = null;
    private String OVICORDEROSLACTPRECIO = null;

    private String OVICORDEROSENG = null;
    private String OVICORDEROSENGCANTIDAD = null;
    private String OVICORDEROSENGPRECIO = null;




    //Sementales
    TextView txtGanadoovinolecsemcabez;
    EditText edtGanadoovinolecsemcabez;
    TextView txtGanadoovinolecsemvalor;
    EditText edtGanadoovinolecsemvalor;


    //Borregas adultas
    TextView txtGanadoovinolecborregadultacabezas;
    EditText edtGanadoovinolecborregadultacabezas;
    TextView txtGanadoovinolecborregadultavalor;
    EditText edtGanadoovinolecborregadultavalor;


    //Primalas del empadre al primer parto
    TextView txtGanadoovinolecprimalascabezas;
    EditText edtGanadoovinolecprimalascabezas;
    TextView txtGanadoovinolecprimalasavalor;
    EditText edtGanadoovinolecprimalasavalor;


    //Corderas del destete al primer empadre
    TextView txtGanadoovinoleccorderadestetecabezas;
    EditText edtGanadoovinoleccorderadestetecabezas;
    TextView txtGanadoovinoleccorderadestetevalor;
    EditText edtGanadoovinoleccorderadestetevalor;


    //Corderos lactantes
    TextView txtGanadoovinoleccorderolactcabezas;
    EditText edtGanadoovinoleccorderolactcabezas;
    TextView txtGanadoovinoleccorderolactvalor;
    EditText edtGanadoovinoleccorderolactvalor;

    //Corderos en engorda
    TextView txtGanadoovinoleccorderoengordacabezas;
    EditText edtGanadoovinoleccorderoengordacabezas;
    TextView txtGanadoovinoleccorderoengordavalor;
    EditText edtGanadoovinoleccorderoengordavalor;



    //Botones
    Button btnPecuinvganadovino;



    //BASE DE DATOS
    private DatabaseHelper baseBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario_ganado_ovino);


        //////////////////////////// 1 ///////////////////////////////////////////
        txtGanadoovinolecsemcabez = (TextView)findViewById(R.id.txtGanadoovinolecsemcabez);
        edtGanadoovinolecsemcabez = (EditText)findViewById(R.id.edtGanadoovinolecsemcabez);
        txtGanadoovinolecsemvalor = (TextView)findViewById(R.id.txtGanadoovinolecsemvalor);
        edtGanadoovinolecsemvalor = (EditText)findViewById(R.id.edtGanadoovinolecsemvalor);


        //////////////////////////// 2 ///////////////////////////////////////////
        txtGanadoovinolecborregadultacabezas = (TextView)findViewById(R.id.txtGanadoovinolecborregadultacabezas);
        edtGanadoovinolecborregadultacabezas = (EditText)findViewById(R.id.edtGanadoovinolecborregadultacabezas);
        txtGanadoovinolecborregadultavalor = (TextView)findViewById(R.id.txtGanadoovinolecborregadultavalor);
        edtGanadoovinolecborregadultavalor = (EditText)findViewById(R.id.edtGanadoovinolecborregadultavalor);



        //////////////////////////// 3 ///////////////////////////////////////////
        txtGanadoovinolecprimalascabezas = (TextView)findViewById(R.id.txtGanadoovinolecprimalascabezas);
        edtGanadoovinolecprimalascabezas = (EditText)findViewById(R.id.edtGanadoovinolecprimalascabezas);
        txtGanadoovinolecprimalasavalor = (TextView)findViewById(R.id.txtGanadoovinolecprimalasavalor);
        edtGanadoovinolecprimalasavalor = (EditText)findViewById(R.id.edtGanadoovinolecprimalasavalor);


        //////////////////////////// 4 ///////////////////////////////////////////
        txtGanadoovinoleccorderadestetecabezas = (TextView)findViewById(R.id.txtGanadoovinoleccorderadestetecabezas);
        edtGanadoovinoleccorderadestetecabezas = (EditText)findViewById(R.id.edtGanadoovinoleccorderadestetecabezas);
        txtGanadoovinoleccorderadestetevalor = (TextView)findViewById(R.id.txtGanadoovinoleccorderadestetevalor);
        edtGanadoovinoleccorderadestetevalor = (EditText)findViewById(R.id.edtGanadoovinoleccorderadestetevalor);


        //////////////////////////// 5 ///////////////////////////////////////////
        txtGanadoovinoleccorderolactcabezas = (TextView)findViewById(R.id.txtGanadoovinoleccorderolactcabezas);
        edtGanadoovinoleccorderolactcabezas = (EditText)findViewById(R.id.edtGanadoovinoleccorderolactcabezas);
        txtGanadoovinoleccorderolactvalor = (TextView)findViewById(R.id.txtGanadoovinoleccorderolactvalor);
        edtGanadoovinoleccorderolactvalor = (EditText)findViewById(R.id.edtGanadoovinoleccorderolactvalor);


        //////////////////////////// 6 ///////////////////////////////////////////
        txtGanadoovinoleccorderoengordacabezas = (TextView)findViewById(R.id.txtGanadoovinoleccorderoengordacabezas);
        edtGanadoovinoleccorderoengordacabezas = (EditText)findViewById(R.id.edtGanadoovinoleccorderoengordacabezas);
        txtGanadoovinoleccorderoengordavalor = (TextView)findViewById(R.id.txtGanadoovinoleccorderoengordavalor);
        edtGanadoovinoleccorderoengordavalor = (EditText)findViewById(R.id.edtGanadoovinoleccorderoengordavalor);



        //Botones
        btnPecuinvganadovino = (Button)findViewById(R.id.pecuario_next_inventario_ovino);


        //BD
        baseBD         = new DatabaseHelper(this);







        ///////////////////////////////////////////////////////////////////////////////
        btnPecuinvganadovino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean valOvi = validaOvino();

             //   if (valOvi){
             //       Toast.makeText(getApplicationContext(), "Faltan datos, al menos seleccionar 1", Toast.LENGTH_SHORT).show();


             //   }else{

                    validaCamposOvinos();

                    GlobalPecuario.OVINOSEMENTAL = OVINOSEMENTAL;
                    GlobalPecuario.OVISEMCANTIDAD = OVISEMCANTIDAD;
                    GlobalPecuario.OVISEMEPRECIO = OVISEMEPRECIO;

                    GlobalPecuario.OVIBORREGADUL = OVIBORREGADUL;
                    GlobalPecuario.OVIBORREGADULCANTIDAD = OVIBORREGADULCANTIDAD;
                    GlobalPecuario.OVIBORREGADULPRECIO = OVIBORREGADULPRECIO;

                    GlobalPecuario.OVIPRIMALASPROD = OVIPRIMALASPROD;
                    GlobalPecuario.OVIPRIMALASCANTIDAD = OVIPRIMALASCANTIDAD;
                    GlobalPecuario.OVIPRIMALASPRECIO = OVIPRIMALASPRECIO;

                    GlobalPecuario.OVICORDERAS = OVICORDERAS;
                    GlobalPecuario.OVICORDERASCANTIDAD = OVICORDERASCANTIDAD;
                    GlobalPecuario.OVICORDERASPRECIO = OVICORDERASPRECIO;

                    GlobalPecuario.OVICORDEROSLACT = OVICORDEROSLACT;
                    GlobalPecuario.OVICORDEROSLACTCANTIDAD = OVICORDEROSLACTCANTIDAD;
                    GlobalPecuario.OVICORDEROSLACTPRECIO = OVICORDEROSLACTPRECIO;

                    GlobalPecuario.OVICORDEROSENG = OVICORDEROSENG;
                    GlobalPecuario.OVICORDEROSENGCANTIDAD = OVICORDEROSENGCANTIDAD;
                    GlobalPecuario.OVICORDEROSENGPRECIO = OVICORDEROSENGPRECIO;



                    agregaInventarioganadoovino();

                    Toast.makeText(getApplicationContext(), "Agregado correctamente ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(InventarioGanadoOvino.this, InventarioGanCaprino.class));
                    finish();

              //  }

            }
        });
    }




    //INSERCION DE DATOS
    public void agregaInventarioganadoovino(){



        addInvganadoovino();

    }




    ///Agregar Estructura del Hato

    private void addInvganadoovino(){
        boolean insertarData = baseBD.addInvovino();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }







    ////////////////////////////////validaciones de mostrar la informacion del checkbox///////////////////////////////////////////////////
    public void clickGanadovino(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkGanadoovinolecsem:
                if (checked) {
                    txtGanadoovinolecsemcabez.setVisibility(View.VISIBLE);
                    edtGanadoovinolecsemcabez.setVisibility(View.VISIBLE);
                    txtGanadoovinolecsemvalor.setVisibility(View.VISIBLE);
                    edtGanadoovinolecsemvalor.setVisibility(View.VISIBLE);


                    OVINOSEMENTAL = "Sementales";


                } else {
                    txtGanadoovinolecsemcabez.setVisibility(View.GONE);
                    edtGanadoovinolecsemcabez.setVisibility(View.GONE);
                    txtGanadoovinolecsemvalor.setVisibility(View.GONE);
                    edtGanadoovinolecsemvalor.setVisibility(View.GONE);


                    OVINOSEMENTAL = null;

                }
                break;

            case R.id.checkGanadoovinolecborregadulta:
                if (checked) {

                    txtGanadoovinolecborregadultacabezas.setVisibility(View.VISIBLE);
                    edtGanadoovinolecborregadultacabezas.setVisibility(View.VISIBLE);
                    txtGanadoovinolecborregadultavalor.setVisibility(View.VISIBLE);
                    edtGanadoovinolecborregadultavalor.setVisibility(View.VISIBLE);


                    OVIBORREGADUL = "Borregas adultas";


                }else{

                    txtGanadoovinolecborregadultacabezas.setVisibility(View.GONE);
                    edtGanadoovinolecborregadultacabezas.setVisibility(View.GONE);
                    txtGanadoovinolecborregadultavalor.setVisibility(View.GONE);
                    edtGanadoovinolecborregadultavalor.setVisibility(View.GONE);


                    OVIBORREGADUL = null;

                }
                break;


            case R.id.checkGanadoovinolecprimalas:
                if (checked) {
                    txtGanadoovinolecprimalascabezas.setVisibility(View.VISIBLE);
                    edtGanadoovinolecprimalascabezas.setVisibility(View.VISIBLE);
                    txtGanadoovinolecprimalasavalor.setVisibility(View.VISIBLE);
                    edtGanadoovinolecprimalasavalor.setVisibility(View.VISIBLE);


                    OVIPRIMALASPROD = "Primalas del empadre al primer parto";


                }else{

                    txtGanadoovinolecprimalascabezas.setVisibility(View.GONE);
                    edtGanadoovinolecprimalascabezas.setVisibility(View.GONE);
                    txtGanadoovinolecprimalasavalor.setVisibility(View.GONE);
                    edtGanadoovinolecprimalasavalor.setVisibility(View.GONE);


                    OVIPRIMALASPROD = null;

                }
                break;


            case R.id.checkGanadoovinoleccorderadestete:
                if (checked) {

                    txtGanadoovinoleccorderadestetecabezas.setVisibility(View.VISIBLE);
                    edtGanadoovinoleccorderadestetecabezas.setVisibility(View.VISIBLE);
                    txtGanadoovinoleccorderadestetevalor.setVisibility(View.VISIBLE);
                    edtGanadoovinoleccorderadestetevalor.setVisibility(View.VISIBLE);


                    OVICORDERAS = "Corderas del destete al primer empadre";

                }else{

                    txtGanadoovinoleccorderadestetecabezas.setVisibility(View.GONE);
                    edtGanadoovinoleccorderadestetecabezas.setVisibility(View.GONE);
                    txtGanadoovinoleccorderadestetevalor.setVisibility(View.GONE);
                    edtGanadoovinoleccorderadestetevalor.setVisibility(View.GONE);


                    OVICORDERAS = null;


                }
                break;



            case R.id.checkGanadoovinoleccorderolact:
                if (checked) {

                    txtGanadoovinoleccorderolactcabezas.setVisibility(View.VISIBLE);
                    edtGanadoovinoleccorderolactcabezas.setVisibility(View.VISIBLE);
                    txtGanadoovinoleccorderolactvalor.setVisibility(View.VISIBLE);
                    edtGanadoovinoleccorderolactvalor.setVisibility(View.VISIBLE);


                    OVICORDEROSLACT = "Corderos lactantes";

                }else{


                    txtGanadoovinoleccorderolactcabezas.setVisibility(View.GONE);
                    edtGanadoovinoleccorderolactcabezas.setVisibility(View.GONE);
                    txtGanadoovinoleccorderolactvalor.setVisibility(View.GONE);
                    edtGanadoovinoleccorderolactvalor.setVisibility(View.GONE);


                    OVICORDEROSLACT = null;

                }
                break;



            case R.id.checkGanadoovinoleccorderoengorda:
                if (checked) {

                    txtGanadoovinoleccorderoengordacabezas.setVisibility(View.VISIBLE);
                    edtGanadoovinoleccorderoengordacabezas.setVisibility(View.VISIBLE);
                    txtGanadoovinoleccorderoengordavalor.setVisibility(View.VISIBLE);
                    edtGanadoovinoleccorderoengordavalor.setVisibility(View.VISIBLE);


                    OVICORDEROSENG = "Corderos en engorda";

                }else{

                    txtGanadoovinoleccorderoengordacabezas.setVisibility(View.GONE);
                    edtGanadoovinoleccorderoengordacabezas.setVisibility(View.GONE);
                    txtGanadoovinoleccorderoengordavalor.setVisibility(View.GONE);
                    edtGanadoovinoleccorderoengordavalor.setVisibility(View.GONE);


                    OVICORDEROSENG = null;

                }
                break;

        }
    }



    //////////////////////////////////////////////////////////////////////////////////////////
    private void validaCamposOvinos(){

        //////////////////////////////////////////////////////////////////////////////
        if (OVINOSEMENTAL != null){

            OVISEMCANTIDAD = edtGanadoovinolecsemcabez.getText().toString();
            OVISEMEPRECIO = edtGanadoovinolecsemvalor.getText().toString();
        }else{

            OVISEMCANTIDAD = null;
            OVISEMEPRECIO = null;
        }




        //////////////////////////////////////////////////////////////////////////////
        if(OVIBORREGADUL != null ){

            OVIBORREGADULCANTIDAD = edtGanadoovinolecborregadultacabezas.getText().toString();
            OVIBORREGADULPRECIO = edtGanadoovinolecborregadultavalor.getText().toString();

        }else{

            OVIBORREGADULCANTIDAD = null;
            OVIBORREGADULPRECIO = null;
        }



        ///////////////////////////////////////////////////////////////////////////////
        if(OVIPRIMALASPROD != null){

            OVIPRIMALASCANTIDAD = edtGanadoovinolecprimalascabezas.getText().toString();
            OVIPRIMALASPRECIO = edtGanadoovinolecprimalasavalor.getText().toString();

        }else{

            OVIPRIMALASCANTIDAD = null;
            OVIPRIMALASPRECIO = null;
        }






        ///////////////////////////////////////////////////////////////////////////////
        if(OVICORDERAS != null){

            OVICORDERASCANTIDAD = edtGanadoovinoleccorderadestetecabezas.getText().toString();
            OVICORDERASPRECIO = edtGanadoovinoleccorderadestetevalor.getText().toString();

        }else{
            OVICORDERASCANTIDAD = null;
            OVICORDERASPRECIO = null;

        }




        /////////////////////////////////////////////////////////////////////////////////
        if(OVICORDEROSLACT != null){

            OVICORDEROSLACTCANTIDAD = edtGanadoovinoleccorderolactcabezas.getText().toString();
            OVICORDEROSLACTPRECIO = edtGanadoovinoleccorderolactvalor.getText().toString();

        }else{

            OVICORDEROSLACTCANTIDAD = null;
            OVICORDEROSLACTPRECIO = null;

        }





        ///////////////////////////////////////////////////////////////////////////////
        if(OVICORDEROSENG != null){

            OVICORDEROSENGCANTIDAD = edtGanadoovinoleccorderoengordacabezas.getText().toString();
            OVICORDEROSENGPRECIO = edtGanadoovinoleccorderoengordavalor.getText().toString();

        }else{

            OVICORDEROSENGCANTIDAD = null;
            OVICORDEROSENGPRECIO = null;

        }

    }





    //////////////////////////////validacion de seleccion de checkbox///////////////////////////////////////////////////
    private Boolean validaOvino(){

        if(OVINOSEMENTAL != null || OVIBORREGADUL != null || OVIPRIMALASPROD != null
                || OVICORDERAS != null || OVICORDEROSLACT != null || OVICORDEROSENG != null){
            return false;
        }else {
            return true;
        }
    }


    @Override
    public void onBackPressed() {

    }


}
