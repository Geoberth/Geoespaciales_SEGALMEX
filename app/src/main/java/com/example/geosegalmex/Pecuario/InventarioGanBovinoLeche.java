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

public class InventarioGanBovinoLeche extends AppCompatActivity {

    //variables locales
    private String BOVSEMENTALLEC = null;
    private String BOVSEMCANTIDADCABLEC = null;
    private String BOVSEMPRECIOCABLEC = null;

    private String BOVVACAPRODLEC = null;
    private String BOVVACACANTIDADCABLEC = null;
    private String BOVVACAPRECIOCABLEC = null;

    private String BOVVASEPRODLEC = null;
    private String BOVVASECANTIDADCABLEC = null;
    private String BOVVASEPRECIOCABLEC = null;

    private String BOVVAQPRODLEC = null;
    private String BOVVAQCANTIDADCABLEC = null;
    private String BOVVAQPRECIOCABLEC = null;

    private String BOVHEMDESPRODLEC = null;
    private String BOVHEMDESCANTIDADCABLEC = null;
    private String BOVHEMDESPRECIOCABLEC = null;

    private String BOVBECPRODLEC = null;
    private String BOVBECCANTIDADCABLEC = null;
    private String BOVBECPRECIOCABLEC = null;

    private String BOVBECERRASPRODLEC = null;
    private String BOVBECERRASCANTIDADCABLEC = null;
    private String BOVBECERRASPRECIOCABLEC = null;

    private String BOVTORETESPRODLEC = null;
    private String BOVTORETESCANTIDADCABLEC = null;
    private String BOVTORETESPRECIOCABLEC = null;



    //CheckBox Sementales
    TextView txtGanbovlecsemcabez;
    EditText edtGanbovlecsemcabez;
    TextView txtGanbovlecsemval;
    EditText edtGanbovlecsemval;


    //CheckBox Vacas en producción
    TextView txtGanbovlecvacaprodcab;
    EditText edtGanbovlecvacaprodcab;
    TextView txtGanbovlecvacaprodval;
    EditText edtGanbovlecvacaprodval;


    //CheckBox Vacas secas
    TextView txtGanbovlecvacasecacab;
    EditText edtGanbovlecvacasecacab;
    TextView txtGanbovlecvacasecaval;
    EditText edtGanbovlecvacasecaval;


    //CheckBox Vaquillas (del servicio al primer parto)
    TextView txtGanbovlecvaqcab;
    EditText edtGanbovlecvaqcab;
    TextView txtGanbovlecvaqval;
    EditText edtGanbovlecvaqval;


    //CheckBox Hembras en desarrollo (destete a servicio)
    TextView txtGanbovlechemdesarcab;
    EditText edtGanbovlechemdesarcab;
    TextView txtGanbovlechemdesarval;
    EditText edtGanbovlechemdesarval;


    //CheckBox Becerros (sin destetar)
    TextView txtGanbovlecbeccab;
    EditText edtGanbovlecbeccab;
    TextView txtGanbovlecbecval;
    EditText edtGanbovlecbecval;


    //CheckBox Becerras
    TextView txtGanbovlecbecerracab;
    EditText edtGanbovlecbecerracab;
    TextView txtGanbovlecbecerraval;
    EditText edtGanbovlecbecerraval;


    //CheckBox Toretes
    TextView txtGanbovlecteretecab;
    EditText edtGanbovlecteretecab;
    TextView txtGanbovlectereteval;
    EditText edtGanbovlectereteval;




    //Botones
    Button btnPecuinvganadbovleche;



    //BASE DE DATOS
    private DatabaseHelper baseBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario_gan_bovino_leche);


        ///////////////////////// 1 /////////////////////////////////////////////
        txtGanbovlecsemcabez = (TextView)findViewById(R.id.txtGanbovlecsemcabez);
        edtGanbovlecsemcabez = (EditText)findViewById(R.id.edtGanbovlecsemcabez);
        txtGanbovlecsemval = (TextView)findViewById(R.id.txtGanbovlecsemval);
        edtGanbovlecsemval = (EditText)findViewById(R.id.edtGanbovlecsemval);


        ///////////////////////// 2 ///////////////////////////////////////////
        txtGanbovlecvacaprodcab = (TextView)findViewById(R.id.txtGanbovlecvacaprodcab);
        edtGanbovlecvacaprodcab = (EditText)findViewById(R.id.edtGanbovlecvacaprodcab);
        txtGanbovlecvacaprodval = (TextView)findViewById(R.id.txtGanbovlecvacaprodval);
        edtGanbovlecvacaprodval = (EditText)findViewById(R.id.edtGanbovlecvacaprodval);


        ///////////////////////// 3 ///////////////////////////////////////////
        txtGanbovlecvacasecacab = (TextView)findViewById(R.id.txtGanbovlecvacasecacab);
        edtGanbovlecvacasecacab = (EditText)findViewById(R.id.edtGanbovlecvacasecacab);
        txtGanbovlecvacasecaval = (TextView)findViewById(R.id.txtGanbovlecvacasecaval);
        edtGanbovlecvacasecaval = (EditText)findViewById(R.id.edtGanbovlecvacasecaval);


        ///////////////////////// 4 ///////////////////////////////////////////
        txtGanbovlecvaqcab = (TextView)findViewById(R.id.txtGanbovlecvaqcab);
        edtGanbovlecvaqcab = (EditText)findViewById(R.id.edtGanbovlecvaqcab);
        txtGanbovlecvaqval = (TextView)findViewById(R.id.txtGanbovlecvaqval);
        edtGanbovlecvaqval = (EditText)findViewById(R.id.edtGanbovlecvaqval);


        ///////////////////////// 5 ///////////////////////////////////////////
        txtGanbovlechemdesarcab = (TextView)findViewById(R.id.txtGanbovlechemdesarcab);
        edtGanbovlechemdesarcab = (EditText)findViewById(R.id.edtGanbovlechemdesarcab);
        txtGanbovlechemdesarval = (TextView)findViewById(R.id.txtGanbovlechemdesarval);
        edtGanbovlechemdesarval = (EditText)findViewById(R.id.edtGanbovlechemdesarval);


        ///////////////////////// 6 ///////////////////////////////////////////
        txtGanbovlecbeccab = (TextView)findViewById(R.id.txtGanbovlecbeccab);
        edtGanbovlecbeccab = (EditText)findViewById(R.id.edtGanbovlecbeccab);
        txtGanbovlecbecval = (TextView)findViewById(R.id.txtGanbovlecbecval);
        edtGanbovlecbecval = (EditText)findViewById(R.id.edtGanbovlecbecval);



        ///////////////////////// 7 ///////////////////////////////////////////
        txtGanbovlecbecerracab = (TextView)findViewById(R.id.txtGanbovlecbecerracab);
        edtGanbovlecbecerracab = (EditText)findViewById(R.id.edtGanbovlecbecerracab);
        txtGanbovlecbecerraval = (TextView)findViewById(R.id.txtGanbovlecbecerraval);
        edtGanbovlecbecerraval = (EditText)findViewById(R.id.edtGanbovlecbecerraval);



        ///////////////////////// 8 ///////////////////////////////////////////
        txtGanbovlecteretecab = (TextView)findViewById(R.id.txtGanbovlecteretecab);
        edtGanbovlecteretecab = (EditText)findViewById(R.id.edtGanbovlecteretecab);
        txtGanbovlectereteval = (TextView)findViewById(R.id.txtGanbovlectereteval);
        edtGanbovlectereteval = (EditText)findViewById(R.id.edtGanbovlectereteval);



        //Botones
        btnPecuinvganadbovleche = (Button)findViewById(R.id.pecuario_next_inventario_bovinoleche);


        //BD
        baseBD         = new DatabaseHelper(this);




        btnPecuinvganadbovleche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Boolean valBovlech = validaBovlech();

             //   if (valBovlech){
              //      Toast.makeText(getApplicationContext(), "Faltan datos, al menos seleccionar 1", Toast.LENGTH_SHORT).show();


            //    }else{

                    validaCamposbovinoleche();

                    GlobalPecuario.BOVSEMENTALLEC = BOVSEMENTALLEC;
                    GlobalPecuario.BOVSEMCANTIDADCABLEC = BOVSEMCANTIDADCABLEC;
                    GlobalPecuario.BOVSEMPRECIOCABLEC = BOVSEMPRECIOCABLEC;

                    GlobalPecuario.BOVVACAPRODLEC = BOVVACAPRODLEC;
                    GlobalPecuario.BOVVACACANTIDADCABLEC = BOVVACACANTIDADCABLEC;
                    GlobalPecuario.BOVVACAPRECIOCABLEC = BOVVACAPRECIOCABLEC;

                    GlobalPecuario.BOVVASEPRODLEC = BOVVASEPRODLEC;
                    GlobalPecuario.BOVVASECANTIDADCABLEC = BOVVASECANTIDADCABLEC;
                    GlobalPecuario.BOVVASEPRECIOCABLEC = BOVVASEPRECIOCABLEC;

                    GlobalPecuario.BOVVAQPRODLEC = BOVVAQPRODLEC;
                    GlobalPecuario.BOVVAQCANTIDADCABLEC = BOVVAQCANTIDADCABLEC;
                    GlobalPecuario.BOVVAQPRECIOCABLEC = BOVVAQPRECIOCABLEC;

                    GlobalPecuario.BOVHEMDESPRODLEC = BOVHEMDESPRODLEC;
                    GlobalPecuario.BOVHEMDESCANTIDADCABLEC = BOVHEMDESCANTIDADCABLEC;
                    GlobalPecuario.BOVHEMDESPRECIOCABLEC = BOVHEMDESPRECIOCABLEC;

                    GlobalPecuario.BOVBECPRODLEC = BOVBECPRODLEC;
                    GlobalPecuario.BOVBECCANTIDADCABLEC = BOVBECCANTIDADCABLEC;
                    GlobalPecuario.BOVBECPRECIOCABLEC = BOVBECPRECIOCABLEC;

                    GlobalPecuario.BOVBECERRASPRODLEC = BOVBECERRASPRODLEC;
                    GlobalPecuario.BOVBECERRASCANTIDADCABLEC = BOVBECERRASCANTIDADCABLEC;
                    GlobalPecuario.BOVBECERRASPRECIOCABLEC = BOVBECERRASPRECIOCABLEC;

                    GlobalPecuario.BOVTORETESPRODLEC = BOVTORETESPRODLEC;
                    GlobalPecuario.BOVTORETESCANTIDADCABLEC = BOVTORETESCANTIDADCABLEC;
                    GlobalPecuario.BOVTORETESPRECIOCABLEC = BOVTORETESPRECIOCABLEC;



                    agregaInventariobovleche();
                    Toast.makeText(getApplicationContext(), "Agregado correctamente ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(InventarioGanBovinoLeche.this, InventarioGanadoOvino.class));
                    finish();

             //   }


            }
        });
    }




    //INSERCION DE DATOS
    public void agregaInventariobovleche(){



        addInvganbovinolech();

    }




    ///Agregar Estructura del Hato

    private void addInvganbovinolech(){
        boolean insertarData = baseBD.addInvbovinoleche();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }



///////////////////////////////////////////////////////////////////////////////////
    public void clickGanbovinoleche(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkGanbovlecsem:
                if (checked) {
                    txtGanbovlecsemcabez.setVisibility(View.VISIBLE);
                    edtGanbovlecsemcabez.setVisibility(View.VISIBLE);
                    txtGanbovlecsemval.setVisibility(View.VISIBLE);
                    edtGanbovlecsemval.setVisibility(View.VISIBLE);

                    BOVSEMENTALLEC = "Sementales";


                } else {
                    txtGanbovlecsemcabez.setVisibility(View.GONE);
                    edtGanbovlecsemcabez.setVisibility(View.GONE);
                    txtGanbovlecsemval.setVisibility(View.GONE);
                    edtGanbovlecsemval.setVisibility(View.GONE);

                    BOVSEMENTALLEC = null;

                }
                break;

            case R.id.checkGanbovlecvacaprod:
                if (checked) {

                    txtGanbovlecvacaprodcab.setVisibility(View.VISIBLE);
                    edtGanbovlecvacaprodcab.setVisibility(View.VISIBLE);
                    txtGanbovlecvacaprodval.setVisibility(View.VISIBLE);
                    edtGanbovlecvacaprodval.setVisibility(View.VISIBLE);

                    BOVVACAPRODLEC = "Vacas en producción";


                }else{

                    txtGanbovlecvacaprodcab.setVisibility(View.GONE);
                    edtGanbovlecvacaprodcab.setVisibility(View.GONE);
                    txtGanbovlecvacaprodval.setVisibility(View.GONE);
                    edtGanbovlecvacaprodval.setVisibility(View.GONE);

                    BOVVACAPRODLEC = null;

                }
                break;


            case R.id.checkGanbovlecvacaseca:
                if (checked) {
                    txtGanbovlecvacasecacab.setVisibility(View.VISIBLE);
                    edtGanbovlecvacasecacab.setVisibility(View.VISIBLE);
                    txtGanbovlecvacasecaval.setVisibility(View.VISIBLE);
                    edtGanbovlecvacasecaval.setVisibility(View.VISIBLE);

                    BOVVASEPRODLEC = "Vacas secas";


                }else{

                    txtGanbovlecvacasecacab.setVisibility(View.GONE);
                    edtGanbovlecvacasecacab.setVisibility(View.GONE);
                    txtGanbovlecvacasecaval.setVisibility(View.GONE);
                    edtGanbovlecvacasecaval.setVisibility(View.GONE);

                    BOVVASEPRODLEC = null;

                }
                break;


            case R.id.checkGanbovlecvaq:
                if (checked) {

                    txtGanbovlecvaqcab.setVisibility(View.VISIBLE);
                    edtGanbovlecvaqcab.setVisibility(View.VISIBLE);
                    txtGanbovlecvaqval.setVisibility(View.VISIBLE);
                    edtGanbovlecvaqval.setVisibility(View.VISIBLE);

                    BOVVAQPRODLEC = "Vaquillas (del servicio al primer parto)";

                }else{

                    txtGanbovlecvaqcab.setVisibility(View.GONE);
                    edtGanbovlecvaqcab.setVisibility(View.GONE);
                    txtGanbovlecvaqval.setVisibility(View.GONE);
                    edtGanbovlecvaqval.setVisibility(View.GONE);

                    BOVVAQPRODLEC = null;


                }
                break;



            case R.id.checkGanbovlechemdesar:
                if (checked) {

                    txtGanbovlechemdesarcab.setVisibility(View.VISIBLE);
                    edtGanbovlechemdesarcab.setVisibility(View.VISIBLE);
                    txtGanbovlechemdesarval.setVisibility(View.VISIBLE);
                    edtGanbovlechemdesarval.setVisibility(View.VISIBLE);

                    BOVHEMDESPRODLEC = "Hembras en desarrollo (destete a servicio)";

                }else{


                    txtGanbovlechemdesarcab.setVisibility(View.GONE);
                    edtGanbovlechemdesarcab.setVisibility(View.GONE);
                    txtGanbovlechemdesarval.setVisibility(View.GONE);
                    edtGanbovlechemdesarval.setVisibility(View.GONE);

                    BOVHEMDESPRODLEC = null;

                }
                break;



            case R.id.checkGanbovlecbec:
                if (checked) {

                    txtGanbovlecbeccab.setVisibility(View.VISIBLE);
                    edtGanbovlecbeccab.setVisibility(View.VISIBLE);
                    txtGanbovlecbecval.setVisibility(View.VISIBLE);
                    edtGanbovlecbecval.setVisibility(View.VISIBLE);

                    BOVBECPRODLEC = "Becerros (sin destetar)";

                }else{

                    txtGanbovlecbeccab.setVisibility(View.GONE);
                    edtGanbovlecbeccab.setVisibility(View.GONE);
                    txtGanbovlecbecval.setVisibility(View.GONE);
                    edtGanbovlecbecval.setVisibility(View.GONE);

                    BOVBECPRODLEC = null;

                }
                break;



            case R.id.checkGanbovlecbecerra:
                if (checked) {
                    txtGanbovlecbecerracab.setVisibility(View.VISIBLE);
                    edtGanbovlecbecerracab.setVisibility(View.VISIBLE);
                    txtGanbovlecbecerraval.setVisibility(View.VISIBLE);
                    edtGanbovlecbecerraval.setVisibility(View.VISIBLE);

                    BOVBECERRASPRODLEC = "Becerras";

                }else{


                    txtGanbovlecbecerracab.setVisibility(View.GONE);
                    edtGanbovlecbecerracab.setVisibility(View.GONE);
                    txtGanbovlecbecerraval.setVisibility(View.GONE);
                    edtGanbovlecbecerraval.setVisibility(View.GONE);

                    BOVBECERRASPRODLEC = null;

                }
                break;

            case R.id.checkGanbovlectorete:
                if (checked) {
                    txtGanbovlecteretecab.setVisibility(View.VISIBLE);
                    edtGanbovlecteretecab.setVisibility(View.VISIBLE);
                    txtGanbovlectereteval.setVisibility(View.VISIBLE);
                    edtGanbovlectereteval.setVisibility(View.VISIBLE);

                    BOVTORETESPRODLEC = "Toretes";

                }else{


                    txtGanbovlecteretecab.setVisibility(View.GONE);
                    edtGanbovlecteretecab.setVisibility(View.GONE);
                    txtGanbovlectereteval.setVisibility(View.GONE);
                    edtGanbovlectereteval.setVisibility(View.GONE);

                    BOVTORETESPRODLEC = null;

                }
                break;
        }
    }


    //////////////////////////////////////////////////////////////////////////////////////////
    private void validaCamposbovinoleche(){

        //////////////////////////////////////////////////////////////////////////////
        if (BOVSEMENTALLEC != null){

            BOVSEMCANTIDADCABLEC = edtGanbovlecsemcabez.getText().toString();
            BOVSEMPRECIOCABLEC = edtGanbovlecsemval.getText().toString();
        }else{

            BOVSEMCANTIDADCABLEC = null;
            BOVSEMPRECIOCABLEC = null;
        }




        //////////////////////////////////////////////////////////////////////////////
        if(BOVVACAPRODLEC != null ){

            BOVVACACANTIDADCABLEC = edtGanbovlecvacaprodcab.getText().toString();
            BOVVACAPRECIOCABLEC = edtGanbovlecvacaprodval.getText().toString();

        }else{

            BOVVACACANTIDADCABLEC = null;
            BOVVACAPRECIOCABLEC = null;
        }



        ///////////////////////////////////////////////////////////////////////////////
        if(BOVVASEPRODLEC != null){

            BOVVASECANTIDADCABLEC = edtGanbovlecvacasecacab.getText().toString();
            BOVVASEPRECIOCABLEC = edtGanbovlecvacasecaval.getText().toString();

        }else{

            BOVVASECANTIDADCABLEC = null;
            BOVVASEPRECIOCABLEC = null;
        }






        ///////////////////////////////////////////////////////////////////////////////
        if(BOVVAQPRODLEC != null){

            BOVVAQCANTIDADCABLEC = edtGanbovlecvaqcab.getText().toString();
            BOVVAQPRECIOCABLEC = edtGanbovlecvaqval.getText().toString();

        }else{
            BOVVAQCANTIDADCABLEC = null;
            BOVVAQPRECIOCABLEC = null;

        }




        /////////////////////////////////////////////////////////////////////////////////
        if(BOVHEMDESPRODLEC != null){

            BOVHEMDESCANTIDADCABLEC = edtGanbovlechemdesarcab.getText().toString();
            BOVHEMDESPRECIOCABLEC = edtGanbovlechemdesarval.getText().toString();

        }else{

            BOVHEMDESCANTIDADCABLEC = null;
            BOVHEMDESPRECIOCABLEC = null;

        }





        ///////////////////////////////////////////////////////////////////////////////
        if(BOVBECPRODLEC != null){

            BOVBECCANTIDADCABLEC = edtGanbovlecbeccab.getText().toString();
            BOVBECPRECIOCABLEC = edtGanbovlecbecval.getText().toString();

        }else{

            BOVBECCANTIDADCABLEC = null;
            BOVBECPRECIOCABLEC = null;

        }



        //////////////////////////////////////////////////////////////////////////////
        if(BOVBECERRASPRODLEC != null){

            BOVBECERRASCANTIDADCABLEC = edtGanbovlecbecerracab.getText().toString();
            BOVBECERRASPRECIOCABLEC = edtGanbovlecbecerraval.getText().toString();

        }else{

            BOVBECERRASCANTIDADCABLEC = null;
            BOVBECERRASPRECIOCABLEC = null;

        }


        //////////////////////////////////////////////////////////////////////////////
        if(BOVTORETESPRODLEC != null){

            BOVTORETESCANTIDADCABLEC = edtGanbovlecbecerracab.getText().toString();
            BOVTORETESPRECIOCABLEC = edtGanbovlecbecerraval.getText().toString();

        }else{

            BOVTORETESCANTIDADCABLEC = null;
            BOVTORETESPRECIOCABLEC = null;

        }

    }





    //////////////////////////////////////////////////////////////////////////////////////////
    private Boolean validaBovlech(){

        if(BOVSEMENTALLEC != null || BOVVACAPRODLEC != null || BOVVASEPRODLEC != null
                || BOVVAQPRODLEC != null || BOVHEMDESPRODLEC != null || BOVBECPRODLEC != null
                || BOVBECERRASPRODLEC != null || BOVTORETESPRODLEC != null){
            return false;
        }else {
            return true;
        }
    }


    @Override
    public void onBackPressed() {

    }

}
