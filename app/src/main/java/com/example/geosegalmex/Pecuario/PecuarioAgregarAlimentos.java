package com.example.geosegalmex.Pecuario;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.geosegalmex.Pecuario.GlobalPecuario.GlobalPecuario;
import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;

public class PecuarioAgregarAlimentos extends AppCompatActivity {


    //Variables locales
    //Pecuario Agregar Alimentos
    private String PECUALIMENTOCOM = null;
    private String PECUALIMENTOCOTRO = null;
    private String PECUALIMLUGCOMP = null;
    private String PECUALIMPRECCOMP = null;



    //Spinner
    Spinner Pecaliment;


    //EditText
    EditText edtpPecalimotro;

    //Boton
    Button btnPecuaretornamanagosta;


    //BASE DE DATOS
    private DatabaseHelper baseBD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pecuario_agregar_alimentos);

        Pecaliment = (Spinner)findViewById(R.id.Pecaliment);
        edtpPecalimotro = (EditText)findViewById(R.id.edtpPecalimotro);




        btnPecuaretornamanagosta = (Button)findViewById(R.id.pecu_next_pecuario_alimentos);


        //BD
        baseBD         = new DatabaseHelper(this);

        Pecaliment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                switch (position) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        edtpPecalimotro.setVisibility(View.GONE);

                        break;


                    case 6:
                        edtpPecalimotro.setVisibility(View.VISIBLE);

                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnPecuaretornamanagosta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                obtenerValoresagralimentos();


                GlobalPecuario.PECUALIMENTOCOM = PECUALIMENTOCOM;
                GlobalPecuario.PECUALIMENTOCOTRO = PECUALIMENTOCOTRO;
                GlobalPecuario.PECUALIMLUGCOMP = PECUALIMLUGCOMP;
                GlobalPecuario.PECUALIMPRECCOMP = PECUALIMPRECCOMP;

                agregaAlimentospecu();
                Toast.makeText(getApplicationContext(), "Agregado correctamente ", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }




    //INSERCION DE DATOS
    public void agregaAlimentospecu(){

        addAlimentospecu();

    }




    ///Agregar alimentos pecuario

    private void addAlimentospecu(){
        boolean insertarData = baseBD.addPecuagregalimcomp();
        if(insertarData == true) {
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Algo salio mal", Toast.LENGTH_LONG).show();
        }

    }






    //Metodo para saber donde compra el alimento
    public void clicklugcompalimento(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioPecalimlugarlocal:
                if (checked) {
                    PECUALIMLUGCOMP = "En la localidad";

                }

                break;


            case R.id.radioPecalimlugreg:
                if (checked) {
                    PECUALIMLUGCOMP = "Región";

                }

                break;


            case R.id.radioPecalimlugdentest:
                if (checked) {
                    PECUALIMLUGCOMP = "Dentro del Estado";

                }

                break;


            case R.id.radioPecalimlugfueraest:
                if (checked) {
                    PECUALIMLUGCOMP = "Fuera del estado";

                }

                break;


        }

    }


    public void obtenerValoresagralimentos(){

        PECUALIMENTOCOM =  Pecaliment.getSelectedItem().toString();


        if(!edtpPecalimotro.getText().toString().isEmpty()){
            PECUALIMENTOCOTRO = edtpPecalimotro.getText().toString();
        } else{
            PECUALIMENTOCOTRO = null;
        }
    }



    @Override
    public void onBackPressed() {

    }

}
