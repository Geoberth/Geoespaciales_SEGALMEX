package com.example.geosegalmex.Pecuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.Pecuario.GlobalPecuario.GlobalPecuario;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

public class PecuarioParamProdReproductivos extends AppCompatActivity {

    //Pecuario Parametros Reproductivos
    private String PARAMHEMBPARIDO = null;
    private String PARAMTIEMPOPART = null;
    private String PARAMEDADPPARTO = null;
    private String PARAMEDADDHEMBR = null;
    private String PARAMNUMCRPPART = null;
    private String PARAMNUMPALANIO = null;
    private String PARAMPESONACERC = null;
    private String PARAMPESODESTET = null;
    private String PARAMEDADDESTET = null;
    private String PARAMMORTDESTET = null;
    private String PARAMPESOVENTAA = null;
    private String PARAMEDADVENTAA = null;
    private String PARAMNUMVIENTRE = null;
    private String PARAMVOLLECHEDI = null;
    private String PARAMNUMDORDENI = null;
    private String PARAMVOLPLECHEV = null;
    private String PARAMNUMCRIASAN = null;
    private String PARAMNUMHEMRANI = null;


    //EditText
    EditText edtParametrosreproductivosporchembras;
    EditText edtParametrosreproductivostiempopartos;
    EditText edtParametrosreproductivosedadpartouno;
    EditText edtParametrosreproductivosedaddeshembras;
    EditText edtParametrosreproductivosnumcrias;
    EditText edtParametrosreproductivosnumpartosrebanio;
    EditText edtParametrosreproductivospesocrias;
    EditText edtParametrosreproductivospesocdestete;
    EditText edtParametrosreproductivosedaddestete;
    EditText edtParametrosreproductivosmortaldestete;
    EditText edtParametrosreproductivospesoventa;
    EditText edtParametrosreproductivosedadventa;
    EditText edtParametrosreproductivosnumvientres;
    EditText edtParametrosreproductivosvolproducleche;
    EditText edtParametrosreproductivosnumdiasordenia;
    EditText edtParametrosreproductivosvolproduclechevaca;
    EditText edtParametrosreproductivosnumcriasprodanio;
    EditText edtParametrosreproductivosnumhembrasreprod;


    //Botones
    Button btnPecuparamprodreprod;


    //BASE DE DATOS
    private DatabaseHelper baseBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pecuario_param_prod_reproductivos);

        //EditText
        edtParametrosreproductivosporchembras = (EditText)findViewById(R.id.edtParametrosreproductivosporchembras);
        edtParametrosreproductivostiempopartos = (EditText)findViewById(R.id.edtParametrosreproductivostiempopartos);
        edtParametrosreproductivosedadpartouno = (EditText)findViewById(R.id.edtParametrosreproductivosedadpartouno);
        edtParametrosreproductivosedaddeshembras = (EditText)findViewById(R.id.edtParametrosreproductivosedaddeshembras);
        edtParametrosreproductivosnumcrias = (EditText)findViewById(R.id.edtParametrosreproductivosnumcrias);
        edtParametrosreproductivosnumpartosrebanio = (EditText)findViewById(R.id.edtParametrosreproductivosnumpartosrebanio);
        edtParametrosreproductivospesocrias = (EditText)findViewById(R.id.edtParametrosreproductivospesocrias);
        edtParametrosreproductivospesocdestete = (EditText)findViewById(R.id.edtParametrosreproductivospesocdestete);
        edtParametrosreproductivosedaddestete = (EditText)findViewById(R.id.edtParametrosreproductivosedaddestete);
        edtParametrosreproductivosmortaldestete = (EditText)findViewById(R.id.edtParametrosreproductivosmortaldestete);
        edtParametrosreproductivospesoventa = (EditText)findViewById(R.id.edtParametrosreproductivospesoventa);
        edtParametrosreproductivosedadventa = (EditText)findViewById(R.id.edtParametrosreproductivosedadventa);
        edtParametrosreproductivosnumvientres = (EditText)findViewById(R.id.edtParametrosreproductivosnumvientres);
        edtParametrosreproductivosvolproducleche = (EditText)findViewById(R.id.edtParametrosreproductivosvolproducleche);
        edtParametrosreproductivosnumdiasordenia = (EditText)findViewById(R.id.edtParametrosreproductivosnumdiasordenia);
        edtParametrosreproductivosvolproduclechevaca = (EditText)findViewById(R.id.edtParametrosreproductivosvolproduclechevaca);
        edtParametrosreproductivosnumcriasprodanio = (EditText)findViewById(R.id.edtParametrosreproductivosnumcriasprodanio);
        edtParametrosreproductivosnumhembrasreprod = (EditText)findViewById(R.id.edtParametrosreproductivosnumhembrasreprod);

        //Boton
        btnPecuparamprodreprod = (Button)findViewById(R.id.pecuario_next_param_reproductivos);


        //BD
        baseBD         = new DatabaseHelper(this);



        btnPecuparamprodreprod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                obtenerParamreproductivos();

                GlobalPecuario.PARAMHEMBPARIDO = PARAMHEMBPARIDO;
                GlobalPecuario.PARAMTIEMPOPART = PARAMTIEMPOPART;
                GlobalPecuario.PARAMEDADPPARTO = PARAMEDADPPARTO;
                GlobalPecuario.PARAMEDADDHEMBR = PARAMEDADDHEMBR;
                GlobalPecuario.PARAMNUMCRPPART = PARAMNUMCRPPART;
                GlobalPecuario.PARAMNUMPALANIO = PARAMNUMPALANIO;
                GlobalPecuario.PARAMPESONACERC = PARAMPESONACERC;
                GlobalPecuario.PARAMPESODESTET = PARAMPESODESTET;
                GlobalPecuario.PARAMEDADDESTET = PARAMEDADDESTET;
                GlobalPecuario.PARAMMORTDESTET = PARAMMORTDESTET;
                GlobalPecuario.PARAMPESOVENTAA = PARAMPESOVENTAA;
                GlobalPecuario.PARAMEDADVENTAA = PARAMEDADVENTAA;
                GlobalPecuario.PARAMNUMVIENTRE = PARAMNUMVIENTRE;
                GlobalPecuario.PARAMVOLLECHEDI = PARAMVOLLECHEDI;
                GlobalPecuario.PARAMNUMDORDENI = PARAMNUMDORDENI;
                GlobalPecuario.PARAMVOLPLECHEV = PARAMVOLPLECHEV;
                GlobalPecuario.PARAMNUMCRIASAN = PARAMNUMCRIASAN;
                GlobalPecuario.PARAMNUMHEMRANI = PARAMNUMHEMRANI;


                agregaReproducciongen();
                Toast.makeText(getApplicationContext(), "Agregado correctamente ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PecuarioParamProdReproductivos.this, PecuarioManejoSanGanado.class));
                finish();
            }
        });
    }



    //INSERCION DE DATOS
    public void agregaReproducciongen(){

        addReproducciongen();

    }




    ///Agregar manejo de agostadero

    private void addReproducciongen(){
        boolean insertarData = baseBD.addPecureproducgenetica();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }







    public void obtenerParamreproductivos(){

        if(!edtParametrosreproductivosporchembras.getText().toString().isEmpty()){
            PARAMHEMBPARIDO = edtParametrosreproductivosporchembras.getText().toString();
        } else{
            PARAMHEMBPARIDO = null;
        }

        if(!edtParametrosreproductivostiempopartos.getText().toString().isEmpty()){
            PARAMTIEMPOPART = edtParametrosreproductivostiempopartos.getText().toString();
        } else{
            PARAMTIEMPOPART = null;
        }


        if(!edtParametrosreproductivosedadpartouno.getText().toString().isEmpty()){
            PARAMEDADPPARTO = edtParametrosreproductivosedadpartouno.getText().toString();
        } else{
            PARAMEDADPPARTO = null;
        }

        if(!edtParametrosreproductivosedaddeshembras.getText().toString().isEmpty()){
            PARAMEDADDHEMBR = edtParametrosreproductivosedaddeshembras.getText().toString();
        } else{
            PARAMEDADDHEMBR = null;
        }


        if(!edtParametrosreproductivosnumcrias.getText().toString().isEmpty()){
            PARAMNUMCRPPART = edtParametrosreproductivosnumcrias.getText().toString();
        } else{
            PARAMNUMCRPPART = null;
        }

        if(!edtParametrosreproductivosnumpartosrebanio.getText().toString().isEmpty()){
            PARAMNUMPALANIO = edtParametrosreproductivosnumpartosrebanio.getText().toString();
        } else{
            PARAMNUMPALANIO = null;
        }

        if(!edtParametrosreproductivospesocrias.getText().toString().isEmpty()){
            PARAMPESONACERC = edtParametrosreproductivospesocrias.getText().toString();
        } else{
            PARAMPESONACERC = null;
        }


        if(!edtParametrosreproductivospesocdestete.getText().toString().isEmpty()){
            PARAMPESODESTET = edtParametrosreproductivospesocdestete.getText().toString();
        } else{
            PARAMPESODESTET = null;
        }

        if(!edtParametrosreproductivosedaddestete.getText().toString().isEmpty()){
            PARAMEDADDESTET = edtParametrosreproductivosedaddestete.getText().toString();
        } else{
            PARAMEDADDESTET = null;
        }

        if(!edtParametrosreproductivosmortaldestete.getText().toString().isEmpty()){
            PARAMMORTDESTET = edtParametrosreproductivosmortaldestete.getText().toString();
        } else{
            PARAMMORTDESTET = null;
        }

        if(!edtParametrosreproductivospesoventa.getText().toString().isEmpty()){
            PARAMPESOVENTAA = edtParametrosreproductivospesoventa.getText().toString();
        } else{
            PARAMPESOVENTAA = null;
        }

        if(!edtParametrosreproductivosedadventa.getText().toString().isEmpty()){
            PARAMEDADVENTAA = edtParametrosreproductivosedadventa.getText().toString();
        } else{
            PARAMEDADVENTAA = null;
        }


        if(!edtParametrosreproductivosnumvientres.getText().toString().isEmpty()){
            PARAMNUMVIENTRE = edtParametrosreproductivosnumvientres.getText().toString();
        } else{
            PARAMNUMVIENTRE = null;
        }

        if(!edtParametrosreproductivosvolproducleche.getText().toString().isEmpty()){
            PARAMVOLLECHEDI = edtParametrosreproductivosvolproducleche.getText().toString();
        } else{
            PARAMVOLLECHEDI = null;
        }


        if(!edtParametrosreproductivosnumdiasordenia.getText().toString().isEmpty()){
            PARAMNUMDORDENI = edtParametrosreproductivosnumdiasordenia.getText().toString();
        } else{
            PARAMNUMDORDENI = null;
        }

        if(!edtParametrosreproductivosvolproduclechevaca.getText().toString().isEmpty()){
            PARAMVOLPLECHEV = edtParametrosreproductivosvolproduclechevaca.getText().toString();
        } else{
            PARAMVOLPLECHEV = null;
        }

        if(!edtParametrosreproductivosnumcriasprodanio.getText().toString().isEmpty()){
            PARAMNUMCRIASAN = edtParametrosreproductivosnumcriasprodanio.getText().toString();
        } else{
            PARAMNUMCRIASAN = null;
        }

        if(!edtParametrosreproductivosnumhembrasreprod.getText().toString().isEmpty()){
            PARAMNUMHEMRANI = edtParametrosreproductivosnumhembrasreprod.getText().toString();
        } else{
            PARAMNUMHEMRANI = null;
        }

    }


    @Override
    public void onBackPressed() {

    }


}
