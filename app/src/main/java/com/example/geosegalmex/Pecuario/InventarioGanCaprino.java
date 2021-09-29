package com.example.geosegalmex.Pecuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.Pecuario.GlobalPecuario.GlobalPecuario;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

public class InventarioGanCaprino extends AppCompatActivity {


    //variables locales
    private String CAPRINOSEMENTAL = null;
    private String CAPRISEMCANTIDAD = null;
    private String CAPRISEMEPRECIO = null;

    private String CAPRINOSCABRASLACTACION = null;
    private String CAPRICABRASLACTCANTIDAD = null;
    private String CAPRICABRASLACTPRECIO = null;

    private String CAPRINOCABRASSECAS = null;
    private String CAPRICABRASSECCANTIDAD = null;
    private String CAPRICABRASSECPRECIO = null;

    private String CAPRINOCABRASSERVPRIMERPARTO  = null;
    private String CAPRICABRASPRIMERPARTOCANTIDAD = null;
    private String CAPRICABRASPRIMPARTOPRECIO = null;

    private String CAPRINOCABRASDESAR = null;
    private String CAPRINOCABRASDESCANTIDAD = null;
    private String CAPRINOCABRASDESPRECIO = null;

    private String CAPRICABRASLACTANTES = null;
    private String CAPRICABRASLATCANTIDAD = null;
    private String CAPRICABRASLACPRECIO = null;

    private String CAPRICABRITOLACTANTES = null;
    private String CAPRICABLACTCANTIDAD = null;
    private String CAPRICABLACTPRECIO = null;

    private String CAPRICABRITOENGORDA = null;
    private String CAPRICABENGCANTIDAD = null;
    private String CAPRICABENGPRECIO = null;


    private String EXPLOTACCAPRINO = null;




    //Sementales
    TextView txtGanadocaprinosementalcabezas;
    EditText edtGanadocaprinosementalcabezas;
    TextView txtGanadocaprinosementalvalor;
    EditText edtGanadocaprinosementalvalor;


    //Cabras en lactación
    TextView txtGanadocaprinocabraslactanciacabezas;
    EditText edtGanadocaprinocabraslactanciacabezas;
    TextView txtGanadocaprinocabraslactanciavalor;
    EditText edtGanadocaprinocabraslactanciavalor;


    //Cabras secas
    TextView txtGanadocaprinocabrasecacabezas;
    EditText edtGanadocaprinocabrasecacabezas;
    TextView txtGanadocaprinocabrasecavalor;
    EditText edtGanadocaprinocabrasecavalor;


    //Cabras del servicio al primer parto
    TextView txtGanadocaprinocabrasserviciocabezas;
    EditText edtGanadocaprinocabrasserviciocabezas;
    TextView txtGanadocaprinocabrasserviciovalor;
    EditText edtGanadocaprinocabrasserviciovalor;


    //Cabras en desarrollo (destete a servicio)
    TextView txtGanadocaprinocabradesarrollocabezas;
    EditText edtGanadocaprinocabradesarrollocabezas;
    TextView txtGanadocaprinocabradesarrollovalor;
    EditText edtGanadocaprinocabradesarrollovalor;


    //Cabritas lactantes (sin destetar)
    TextView txtGanadocaprinocabritaslactcabezas;
    EditText edtGanadocaprinocabritaslactcabezas;
    TextView txtGanadocaprinocabritaslactvalor;
    EditText edtGanadocaprinocabritaslactvalor;



    //Cabritos lactantes (sin destetar)
    TextView txtGanadocaprinocabritoslactcabezas;
    EditText edtGanadocaprinocabritoslactcabezas;
    TextView txtGanadocaprinocabritoslactvalor;
    EditText edtGanadocaprinocabritoslactvalor;



    //Cabritos en engorda
    TextView txtGanadocaprinocabritoengordacabezas;
    EditText edtGanadocaprinocabritoengordacabezas;
    TextView txtGanadocaprinocabritoengordavalor;
    EditText edtGanadocaprinocabritoengordavalor;



    //Botones
    Button btnPecuinvganadcaprino;



    //BASE DE DATOS
    private DatabaseHelper baseBD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario_gan_caprino);


        //////////////////////////// 1 ///////////////////////////////////////////
        txtGanadocaprinosementalcabezas = (TextView)findViewById(R.id.txtGanadocaprinosementalcabezas);
        edtGanadocaprinosementalcabezas = (EditText)findViewById(R.id.edtGanadocaprinosementalcabezas);
        txtGanadocaprinosementalvalor = (TextView)findViewById(R.id.txtGanadocaprinosementalvalor);
        edtGanadocaprinosementalvalor = (EditText)findViewById(R.id.edtGanadocaprinosementalvalor);


        //////////////////////////// 2 ///////////////////////////////////////////
        txtGanadocaprinocabraslactanciacabezas = (TextView)findViewById(R.id.txtGanadoovinolecborregadultacabezas);
        edtGanadocaprinocabraslactanciacabezas = (EditText)findViewById(R.id.edtGanadocaprinocabraslactanciacabezas);
        txtGanadocaprinocabraslactanciavalor = (TextView)findViewById(R.id.txtGanadocaprinocabraslactanciavalor);
        edtGanadocaprinocabraslactanciavalor = (EditText)findViewById(R.id.edtGanadocaprinocabraslactanciavalor);



        //////////////////////////// 3 ///////////////////////////////////////////
        txtGanadocaprinocabrasecacabezas = (TextView)findViewById(R.id.txtGanadocaprinocabrasecacabezas);
        edtGanadocaprinocabrasecacabezas = (EditText)findViewById(R.id.edtGanadocaprinocabrasecacabezas);
        txtGanadocaprinocabrasecavalor = (TextView)findViewById(R.id.txtGanadocaprinocabrasecavalor);
        edtGanadocaprinocabrasecavalor = (EditText)findViewById(R.id.edtGanadocaprinocabrasecavalor);


        //////////////////////////// 4 ///////////////////////////////////////////
        txtGanadocaprinocabrasserviciocabezas = (TextView)findViewById(R.id.txtGanadocaprinocabrasserviciocabezas);
        edtGanadocaprinocabrasserviciocabezas = (EditText)findViewById(R.id.edtGanadocaprinocabrasserviciocabezas);
        txtGanadocaprinocabrasserviciovalor = (TextView)findViewById(R.id.txtGanadocaprinocabrasserviciovalor);
        edtGanadocaprinocabrasserviciovalor = (EditText)findViewById(R.id.edtGanadocaprinocabrasserviciovalor);


        //////////////////////////// 5 ///////////////////////////////////////////
        txtGanadocaprinocabradesarrollocabezas = (TextView)findViewById(R.id.txtGanadocaprinocabradesarrollocabezas);
        edtGanadocaprinocabradesarrollocabezas = (EditText)findViewById(R.id.edtGanadocaprinocabradesarrollocabezas);
        txtGanadocaprinocabradesarrollovalor = (TextView)findViewById(R.id.txtGanadocaprinocabradesarrollovalor);
        edtGanadocaprinocabradesarrollovalor = (EditText)findViewById(R.id.edtGanadocaprinocabradesarrollovalor);


        //////////////////////////// 6 ///////////////////////////////////////////
        txtGanadocaprinocabritaslactcabezas = (TextView)findViewById(R.id.txtGanadocaprinocabritaslactcabezas);
        edtGanadocaprinocabritaslactcabezas = (EditText)findViewById(R.id.edtGanadocaprinocabritaslactcabezas);
        txtGanadocaprinocabritaslactvalor = (TextView)findViewById(R.id.txtGanadocaprinocabritaslactvalor);
        edtGanadocaprinocabritaslactvalor = (EditText)findViewById(R.id.edtGanadocaprinocabritaslactvalor);


        //////////////////////////// 7 ///////////////////////////////////////////
        txtGanadocaprinocabritoslactcabezas = (TextView)findViewById(R.id.txtGanadocaprinocabritoslactcabezas);
        edtGanadocaprinocabritoslactcabezas = (EditText)findViewById(R.id.edtGanadocaprinocabritoslactcabezas);
        txtGanadocaprinocabritoslactvalor = (TextView)findViewById(R.id.txtGanadocaprinocabritoslactvalor);
        edtGanadocaprinocabritoslactvalor = (EditText)findViewById(R.id.edtGanadocaprinocabritoslactvalor);


        //////////////////////////// 8 ///////////////////////////////////////////
        txtGanadocaprinocabritoengordacabezas = (TextView)findViewById(R.id.txtGanadocaprinocabritoengordacabezas);
        edtGanadocaprinocabritoengordacabezas = (EditText)findViewById(R.id.edtGanadocaprinocabritoengordacabezas);
        txtGanadocaprinocabritoengordavalor = (TextView)findViewById(R.id.txtGanadocaprinocabritoengordavalor);
        edtGanadocaprinocabritoengordavalor = (EditText)findViewById(R.id.edtGanadocaprinocabritoengordavalor);





        //Botones
        btnPecuinvganadcaprino = (Button)findViewById(R.id.pecuario_next_inventario_gan_caprino);



        //BD
        baseBD         = new DatabaseHelper(this);




        btnPecuinvganadcaprino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean valCapri = validaCapri();

            //   if (valCapri){
             //       Toast.makeText(getApplicationContext(), "Faltan datos, al menos seleccionar 1", Toast.LENGTH_SHORT).show();


             //   }else{

                    validaCamposCaprinos();

                    GlobalPecuario.CAPRINOSEMENTAL = CAPRINOSEMENTAL;
                    GlobalPecuario.CAPRISEMCANTIDAD = CAPRISEMCANTIDAD;
                    GlobalPecuario.CAPRISEMEPRECIO = CAPRISEMEPRECIO;

                    GlobalPecuario.CAPRINOSCABRASLACTACION = CAPRINOSCABRASLACTACION;
                    GlobalPecuario.CAPRICABRASLACTCANTIDAD = CAPRICABRASLACTCANTIDAD;
                    GlobalPecuario.CAPRICABRASLACTPRECIO = CAPRICABRASLACTPRECIO;

                    GlobalPecuario.CAPRINOCABRASSECAS = CAPRINOCABRASSECAS;
                    GlobalPecuario.CAPRICABRASSECCANTIDAD = CAPRICABRASSECCANTIDAD;
                    GlobalPecuario.CAPRICABRASSECPRECIO = CAPRICABRASSECPRECIO;

                    GlobalPecuario.CAPRINOCABRASSERVPRIMERPARTO = CAPRINOCABRASSERVPRIMERPARTO;
                    GlobalPecuario.CAPRICABRASPRIMERPARTOCANTIDAD = CAPRICABRASPRIMERPARTOCANTIDAD;
                    GlobalPecuario.CAPRICABRASPRIMPARTOPRECIO = CAPRICABRASPRIMPARTOPRECIO;

                    GlobalPecuario.CAPRINOCABRASDESAR = CAPRINOCABRASDESAR;
                    GlobalPecuario.CAPRINOCABRASDESCANTIDAD = CAPRINOCABRASDESCANTIDAD;
                    GlobalPecuario.CAPRINOCABRASDESPRECIO = CAPRINOCABRASDESPRECIO;

                    GlobalPecuario.CAPRICABRASLACTANTES = CAPRICABRASLACTANTES;
                    GlobalPecuario.CAPRICABRASLATCANTIDAD = CAPRICABRASLATCANTIDAD;
                    GlobalPecuario.CAPRICABRASLACPRECIO = CAPRICABRASLACPRECIO;

                    GlobalPecuario.CAPRICABRITOLACTANTES = CAPRICABRITOLACTANTES;
                    GlobalPecuario.CAPRICABLACTCANTIDAD = CAPRICABLACTCANTIDAD;
                    GlobalPecuario.CAPRICABLACTPRECIO = CAPRICABLACTPRECIO;

                    GlobalPecuario.CAPRICABRITOENGORDA = CAPRICABRITOENGORDA;
                    GlobalPecuario.CAPRICABENGCANTIDAD = CAPRICABENGCANTIDAD;
                    GlobalPecuario.CAPRICABENGPRECIO = CAPRICABENGPRECIO;

                    GlobalPecuario.EXPLOTACCAPRINO = EXPLOTACCAPRINO;



                    agregaInventarioganadocaprino();

                    Toast.makeText(getApplicationContext(), "Agregado correctamente ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(InventarioGanCaprino.this, PecuarioAlimentacionGanado.class));
                    finish();

              //  }

            }
        });
    }







    //INSERCION DE DATOS
    public void agregaInventarioganadocaprino(){



        addInvganadocaprino();

    }




    ///Agregar Estructura del Hato

    private void addInvganadocaprino(){
        boolean insertarData = baseBD.addInvgancaprino();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }







    ////////////////////////////////validaciones de mostrar la informacion del checkbox///////////////////////////////////////////////////
    public void clickGanadocaprino(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkGanadocaprinosemental:
                if (checked) {
                    txtGanadocaprinosementalcabezas.setVisibility(View.VISIBLE);
                    edtGanadocaprinosementalcabezas.setVisibility(View.VISIBLE);
                    txtGanadocaprinosementalvalor.setVisibility(View.VISIBLE);
                    edtGanadocaprinosementalvalor.setVisibility(View.VISIBLE);


                    CAPRINOSEMENTAL = "Sementales";


                } else {
                    txtGanadocaprinosementalcabezas.setVisibility(View.GONE);
                    edtGanadocaprinosementalcabezas.setVisibility(View.GONE);
                    txtGanadocaprinosementalvalor.setVisibility(View.GONE);
                    edtGanadocaprinosementalvalor.setVisibility(View.GONE);


                    CAPRINOSEMENTAL = null;

                }
                break;

            case R.id.checkGanadocaprinocabraslactancia:
                if (checked) {

                    txtGanadocaprinocabraslactanciacabezas.setVisibility(View.VISIBLE);
                    edtGanadocaprinocabraslactanciacabezas.setVisibility(View.VISIBLE);
                    txtGanadocaprinocabraslactanciavalor.setVisibility(View.VISIBLE);
                    edtGanadocaprinocabraslactanciavalor.setVisibility(View.VISIBLE);



                    CAPRINOSCABRASLACTACION = "Cabras en lactación";


                }else{

                    txtGanadocaprinocabraslactanciacabezas.setVisibility(View.GONE);
                    edtGanadocaprinocabraslactanciacabezas.setVisibility(View.GONE);
                    txtGanadocaprinocabraslactanciavalor.setVisibility(View.GONE);
                    edtGanadocaprinocabraslactanciavalor.setVisibility(View.GONE);



                    CAPRINOSCABRASLACTACION = null;

                }
                break;


            case R.id.checkGanadocaprinocabraseca:
                if (checked) {
                    txtGanadocaprinocabrasecacabezas.setVisibility(View.VISIBLE);
                    edtGanadocaprinocabrasecacabezas.setVisibility(View.VISIBLE);
                    txtGanadocaprinocabrasecavalor.setVisibility(View.VISIBLE);
                    edtGanadocaprinocabrasecavalor.setVisibility(View.VISIBLE);



                    CAPRINOCABRASSECAS = "Cabras secas";


                }else{

                    txtGanadocaprinocabrasecacabezas.setVisibility(View.GONE);
                    edtGanadocaprinocabrasecacabezas.setVisibility(View.GONE);
                    txtGanadocaprinocabrasecavalor.setVisibility(View.GONE);
                    edtGanadocaprinocabrasecavalor.setVisibility(View.GONE);



                    CAPRINOCABRASSECAS = null;

                }
                break;


            case R.id.checkGanadocaprinocabrasservicio:
                if (checked) {

                    txtGanadocaprinocabrasserviciocabezas.setVisibility(View.VISIBLE);
                    edtGanadocaprinocabrasserviciocabezas.setVisibility(View.VISIBLE);
                    txtGanadocaprinocabrasserviciovalor.setVisibility(View.VISIBLE);
                    edtGanadocaprinocabrasserviciovalor.setVisibility(View.VISIBLE);



                    CAPRINOCABRASSERVPRIMERPARTO = "Cabras del servicio al primer parto";

                }else{

                    txtGanadocaprinocabrasserviciocabezas.setVisibility(View.GONE);
                    edtGanadocaprinocabrasserviciocabezas.setVisibility(View.GONE);
                    txtGanadocaprinocabrasserviciovalor.setVisibility(View.GONE);
                    edtGanadocaprinocabrasserviciovalor.setVisibility(View.GONE);



                    CAPRINOCABRASSERVPRIMERPARTO = null;


                }
                break;



            case R.id.checkGanadocaprinocabradesarrollo:
                if (checked) {

                    txtGanadocaprinocabradesarrollocabezas.setVisibility(View.VISIBLE);
                    edtGanadocaprinocabradesarrollocabezas.setVisibility(View.VISIBLE);
                    txtGanadocaprinocabradesarrollovalor.setVisibility(View.VISIBLE);
                    edtGanadocaprinocabradesarrollovalor.setVisibility(View.VISIBLE);



                    CAPRINOCABRASDESAR = "Cabras en desarrollo (destete a servicio)";

                }else{


                    txtGanadocaprinocabradesarrollocabezas.setVisibility(View.GONE);
                    edtGanadocaprinocabradesarrollocabezas.setVisibility(View.GONE);
                    txtGanadocaprinocabradesarrollovalor.setVisibility(View.GONE);
                    edtGanadocaprinocabradesarrollovalor.setVisibility(View.GONE);



                    CAPRINOCABRASDESAR = null;

                }
                break;



            case R.id.checkGanadocaprinocabritaslact:
                if (checked) {

                    txtGanadocaprinocabritaslactcabezas.setVisibility(View.VISIBLE);
                    edtGanadocaprinocabritaslactcabezas.setVisibility(View.VISIBLE);
                    txtGanadocaprinocabritaslactvalor.setVisibility(View.VISIBLE);
                    edtGanadocaprinocabritaslactvalor.setVisibility(View.VISIBLE);



                    CAPRICABRASLACTANTES = "Cabritas lactantes (sin destetar)";

                }else{

                    txtGanadocaprinocabritaslactcabezas.setVisibility(View.GONE);
                    edtGanadocaprinocabritaslactcabezas.setVisibility(View.GONE);
                    txtGanadocaprinocabritaslactvalor.setVisibility(View.GONE);
                    edtGanadocaprinocabritaslactvalor.setVisibility(View.GONE);



                    CAPRICABRASLACTANTES = null;

                }
                break;




            case R.id.checkGanadocaprinocabritoslact:
                if (checked) {

                    txtGanadocaprinocabritoslactcabezas.setVisibility(View.VISIBLE);
                    edtGanadocaprinocabritoslactcabezas.setVisibility(View.VISIBLE);
                    txtGanadocaprinocabritoslactvalor.setVisibility(View.VISIBLE);
                    edtGanadocaprinocabritoslactvalor.setVisibility(View.VISIBLE);



                    CAPRICABRITOLACTANTES = "Cabritos lactantes (sin destetar)";

                }else{

                    txtGanadocaprinocabritoslactcabezas.setVisibility(View.GONE);
                    edtGanadocaprinocabritoslactcabezas.setVisibility(View.GONE);
                    txtGanadocaprinocabritoslactvalor.setVisibility(View.GONE);
                    edtGanadocaprinocabritoslactvalor.setVisibility(View.GONE);



                    CAPRICABRITOLACTANTES = null;

                }
                break;




            case R.id.checkGanadocaprinocabritoengorda:
                if (checked) {

                    txtGanadocaprinocabritoengordacabezas.setVisibility(View.VISIBLE);
                    edtGanadocaprinocabritoengordacabezas.setVisibility(View.VISIBLE);
                    txtGanadocaprinocabritoengordavalor.setVisibility(View.VISIBLE);
                    edtGanadocaprinocabritoengordavalor.setVisibility(View.VISIBLE);



                    CAPRICABRITOENGORDA = "Cabritos en engorda";

                }else{

                    txtGanadocaprinocabritoengordacabezas.setVisibility(View.GONE);
                    edtGanadocaprinocabritoengordacabezas.setVisibility(View.GONE);
                    txtGanadocaprinocabritoengordavalor.setVisibility(View.GONE);
                    edtGanadocaprinocabritoengordavalor.setVisibility(View.GONE);



                    CAPRICABRITOENGORDA = null;

                }
                break;

        }
    }






    ////////////////////////////////validaciones de mostrar la informacion del checkbox///////////////////////////////////////////////////
    public void clickGanadocapexplotac(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioGanadocaprinoexplotacinten:
                if (checked) {

                    EXPLOTACCAPRINO = "Intensiva";

                }
                break;


            case R.id.radioGanadocaprinoexplotacsemiexten:
                if (checked) {

                    EXPLOTACCAPRINO = "Semi-extensiva";

                }
                break;


            case R.id.radioGanadocaprinoexplotacexten:
                if (checked) {

                    EXPLOTACCAPRINO = "Extensiva";

                }
                break;

        }
    }



    //////////////////////////////////////////////////////////////////////////////////////////
    private void validaCamposCaprinos(){

        //////////////////////////////////////////////////////////////////////////////
        if (CAPRINOSEMENTAL != null){

            CAPRISEMCANTIDAD = edtGanadocaprinosementalcabezas.getText().toString();
            CAPRISEMEPRECIO = edtGanadocaprinosementalvalor.getText().toString();
        }else{

            CAPRISEMCANTIDAD = null;
            CAPRISEMEPRECIO = null;
        }




        //////////////////////////////////////////////////////////////////////////////
        if(CAPRINOSCABRASLACTACION != null ){

            CAPRICABRASLACTCANTIDAD = edtGanadocaprinocabraslactanciacabezas.getText().toString();
            CAPRICABRASLACTPRECIO = edtGanadocaprinocabraslactanciavalor.getText().toString();

        }else{

            CAPRICABRASLACTCANTIDAD = null;
            CAPRICABRASLACTPRECIO = null;
        }



        ///////////////////////////////////////////////////////////////////////////////
        if(CAPRINOCABRASSECAS != null){

            CAPRICABRASSECCANTIDAD = edtGanadocaprinocabrasecacabezas.getText().toString();
            CAPRICABRASSECPRECIO = edtGanadocaprinocabrasecavalor.getText().toString();

        }else{

            CAPRICABRASSECCANTIDAD = null;
            CAPRICABRASSECPRECIO = null;
        }






        ///////////////////////////////////////////////////////////////////////////////
        if(CAPRINOCABRASSERVPRIMERPARTO != null){

            CAPRICABRASPRIMERPARTOCANTIDAD = edtGanadocaprinocabrasserviciocabezas.getText().toString();
            CAPRICABRASPRIMPARTOPRECIO = edtGanadocaprinocabrasserviciovalor.getText().toString();

        }else{
            CAPRICABRASPRIMERPARTOCANTIDAD = null;
            CAPRICABRASPRIMPARTOPRECIO = null;

        }




        /////////////////////////////////////////////////////////////////////////////////
        if(CAPRINOCABRASDESAR != null){

            CAPRINOCABRASDESCANTIDAD = edtGanadocaprinocabradesarrollocabezas.getText().toString();
            CAPRINOCABRASDESPRECIO = edtGanadocaprinocabradesarrollovalor.getText().toString();

        }else{

            CAPRINOCABRASDESCANTIDAD = null;
            CAPRINOCABRASDESPRECIO = null;

        }





        ///////////////////////////////////////////////////////////////////////////////
        if(CAPRICABRASLACTANTES != null){

            CAPRICABRASLATCANTIDAD = edtGanadocaprinocabritaslactcabezas.getText().toString();
            CAPRICABRASLACPRECIO = edtGanadocaprinocabritaslactvalor.getText().toString();

        }else{

            CAPRICABRASLATCANTIDAD = null;
            CAPRICABRASLACPRECIO = null;

        }


        ///////////////////////////////////////////////////////////////////////////////
        if(CAPRICABRITOLACTANTES != null){

            CAPRICABLACTCANTIDAD = edtGanadocaprinocabritoslactcabezas.getText().toString();
            CAPRICABLACTPRECIO = edtGanadocaprinocabritoslactvalor.getText().toString();

        }else{

            CAPRICABLACTCANTIDAD = null;
            CAPRICABLACTPRECIO = null;

        }


        ///////////////////////////////////////////////////////////////////////////////
        if(CAPRICABRITOENGORDA != null){

            CAPRICABENGCANTIDAD = edtGanadocaprinocabritoslactcabezas.getText().toString();
            CAPRICABENGPRECIO = edtGanadocaprinocabritoslactvalor.getText().toString();

        }else{

            CAPRICABENGCANTIDAD = null;
            CAPRICABENGPRECIO = null;

        }

    }





    //////////////////////////////validacion de seleccion de checkbox///////////////////////////////////////////////////
    private Boolean validaCapri(){

        if(CAPRINOSEMENTAL != null || CAPRINOSCABRASLACTACION != null || CAPRINOCABRASSECAS != null
                || CAPRINOCABRASSERVPRIMERPARTO != null || CAPRINOCABRASDESAR != null || CAPRICABRASLACTANTES != null
                || CAPRICABRITOLACTANTES != null || CAPRICABRITOENGORDA != null){
            return false;
        }else {
            return true;
        }
    }




    @Override
    public void onBackPressed() {

    }
}
