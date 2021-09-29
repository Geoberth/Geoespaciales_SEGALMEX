package com.example.geosegalmex.unidadcomercializacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.geosegalmex.R;
import com.example.geosegalmex.unidadcomercializacion.bdcomercializacion.VariablesGlobalesCmrz;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class comercializacion_6 extends AppCompatActivity {
    ExtendedFloatingActionButton co6;
    private	String	PROVELE	= null;		//	String
    private	String	PROVECA	= null;		//	String
    private	String	PROSOCIAL	= null;		//	String
    private	String	PROPOLIT	= null;		//	String
    private	String	PROMERCA	= null;		//	String
    private	String	PRORENACC	= null;		//	String


    private	String	PROVELEEDIT	= null;		//	String

    EditText edtOtrProblem;


    ArrayList<String> problmVentaLechaList;
    ArrayList<String> problemVentaCarneList;
    ArrayList<String> problemAspcSocialList;
    ArrayList<String> problemAspcPoliticList;
    ArrayList<String> problemAspcMercaList;
    ArrayList<String> problemAspcRecrNatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comercializacion_6);
        co6 = findViewById(R.id.cr6);

        edtOtrProblem = findViewById(R.id.edt_otr_pro_cm_pro);

        problmVentaLechaList = new ArrayList<>();
        problemVentaCarneList = new ArrayList<>();
        problemAspcSocialList = new ArrayList<>();
        problemAspcPoliticList = new ArrayList<>();
        problemAspcMercaList = new ArrayList<>();
        problemAspcRecrNatList = new ArrayList<>();

        co6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                asignacionValores();
                if(!edtOtrProblem.getText().toString().isEmpty()){
                    PROVELEEDIT = edtOtrProblem.getText().toString();
                }

                VariablesGlobalesCmrz.PROVELE = PROVELE;	//	String
                VariablesGlobalesCmrz.PROVECA = PROVECA;	//	String
                VariablesGlobalesCmrz.PROSOCIAL = PROSOCIAL;	//	String
                VariablesGlobalesCmrz.PROPOLIT = PROPOLIT;	//	String
                VariablesGlobalesCmrz.PROMERCA = PROMERCA;	//	String
                VariablesGlobalesCmrz.PRORENACC = PRORENACC;	//	String
                VariablesGlobalesCmrz.PROVELEEDIT = PROVELEEDIT;	//	String
                startActivity(new Intent(getApplicationContext(), comercializacion_7.class));
            }
        });
    }

    private void asignacionValores() {
        int i =0;

        //Problema venta de leche
        String ventaLeche = null;
        for(i = 0; i < problmVentaLechaList.size(); i++){
            if(ventaLeche == null){
                ventaLeche = problmVentaLechaList.get(i);
             //   Log.i("===>", ventaLeche);
            }else if(ventaLeche != null){
                ventaLeche = ventaLeche + "," + problmVentaLechaList.get(i);
               // Log.i("===>", ventaLeche);
            }
        }

        PROVELE = ventaLeche;
        System.out.println("===>"+ PROVELE);

        //+++++++++++++++++++++++++++++++++++Problema venta de Carne
        String ventaCarne = null;
        for(i =0; i < problemVentaCarneList.size(); i++){
            if(ventaCarne == null){
                ventaCarne = problemVentaCarneList.get(i);
            }else if(ventaCarne != null){
                ventaCarne = ventaCarne + "," + problemVentaCarneList.get(i);
            }
        }
        PROVECA = ventaCarne;
        System.out.println("===>"+ PROVECA);

        //+++++++++++++++++++Problema Social
        String problemSocial = null;
        for (i = 0; i < problemAspcSocialList.size(); i++){
            if(problemSocial == null){
                problemSocial = problemAspcSocialList.get(i);
            }else if(problemSocial != null){
                problemSocial = problemSocial + "," + problemAspcSocialList.get(i);
            }
        }

        PROSOCIAL = problemSocial;
        System.out.println("===>"+ PROSOCIAL);
        //++++++++++++++++++++Problema Politico
        String problemPolitico = null;

        for(i = 0; i <  problemAspcPoliticList.size(); i++){
            if(problemPolitico == null){
                problemPolitico = problemAspcPoliticList.get(i);
            }else if(problemPolitico != null){
                problemPolitico = problemPolitico + "," + problemAspcPoliticList.get(i);
            }
        }

        PROPOLIT = problemPolitico;
        System.out.println("===>"+ PROPOLIT);
        //++++++++++++++++++++++++++Problema de Mercado
        String probMercado = null;

        for(i = 0; i < problemAspcMercaList.size(); i++){
            if(probMercado == null){
                probMercado = problemAspcMercaList.get(i);
            }else if(probMercado != null){
                probMercado = probMercado + "," + problemAspcMercaList.get(i);
            }
        }

        PROMERCA = probMercado;
        System.out.println("===>"+ PROMERCA);
        //++++++++++++++++++++++++++Problema recursos naturales
        String RecrNatproble = null;

        for (i = 0; i < problemAspcRecrNatList.size() ; i++){
            if(RecrNatproble == null){
                RecrNatproble = problemAspcRecrNatList.get(i);
            }else if(RecrNatproble != null){
                RecrNatproble = RecrNatproble + "," + problemAspcRecrNatList.get(i);
            }
        }

        PRORENACC = RecrNatproble;
        System.out.println("===>" + PRORENACC);
    }

    public void enumProblemVntLeche(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.ck_pro_vnt_lec_1:
                if (checkedTipo) {
                    //PROVELE = "Precio bajo de venta";
                    problmVentaLechaList.add("Precio bajo de venta");
                }else{
                    problmVentaLechaList.remove("Precio bajo de venta");
                }
                break;
            case R.id.ck_pro_vnt_lec_2:
                if (checkedTipo) {
                    problmVentaLechaList.add("El comprador no compra toda la leche que se produce");
                    //PROVELE = "El comprador no compra toda la leche que se produce";
                }else {
                    problmVentaLechaList.remove("El comprador no compra toda la leche que se produce");
                }
                break;
            case R.id.ck_pro_vnt_lec_3:
                if (checkedTipo) {
                    //PROVELE = "Intermediarios";
                    problmVentaLechaList.add("Intermediarios");
                }else {
                    problmVentaLechaList.remove("Intermediarios");
                }
                break;
            case R.id.ck_pro_vnt_lec_4:
                if (checkedTipo) {
                    //PROVELE = "Se castigan precios por baja calidad";
                    problmVentaLechaList.add("Se castigan precios por baja calidad");
                }else {
                    problmVentaLechaList.remove("Se castigan precios por baja calidad");
                }
                break;
            case R.id.ck_pro_vnt_lec_5:
                if (checkedTipo) {
                    //PROVELE = "Baja producción";
                    problmVentaLechaList.add("Baja producción");
                }else{
                    problmVentaLechaList.remove("Baja producción");
                }
                break;
            case R.id.ck_pro_vnt_lec_6:
                if (checkedTipo) {
                    PROVELE = "Otro";
                    problmVentaLechaList.add("Otro");
                    edtOtrProblem.setEnabled(true);
                }else{
                    PROVELEEDIT = null;
                    edtOtrProblem.setEnabled(false);
                    edtOtrProblem.setText("");
                    problmVentaLechaList.remove("Otro");
                }
                break;
        }
    }

    public void enumProblemVntCarne(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_pro_vnt_car_1:
                if (checkedTipo) {
                    problemVentaCarneList.add("Precios bajos del ganado en pie");
                    //PROVECA = "Precios bajos del ganado en pie";
                }else {
                    problemVentaCarneList.remove("Precios bajos del ganado en pie");
                }

                break;
            case R.id.ck_pro_vnt_car_2:
                if (checkedTipo) {
                    //PROVECA = "Bajo peso a la venta";
                    problemVentaCarneList.add("Bajo peso a la venta");
                }else{
                    problemVentaCarneList.remove("Bajo peso a la venta");
                }
                break;
            case R.id.ck_pro_vnt_car_3:
                if (checkedTipo) {
                    //PROVECA = "Normativas para la venta de becerros";
                    problemVentaCarneList.add("Normativas para la venta de becerros");
                }else{
                    problemVentaCarneList.remove("Normativas para la venta de becerros");
                }
                break;
            case R.id.ck_pro_vnt_car_4:
                if (checkedTipo) {
                    problemVentaCarneList.add("Raza y características del animal");
                    //PROVECA = "Raza y características del animal";
                }else{
                    problemVentaCarneList.remove("Raza y características del animal");
                }
                break;
            case R.id.ck_pro_vnt_car_5:
                if (checkedTipo) {
                    problemVentaCarneList.add("Intermediarios");
                    //PROVECA = "Intermediarios";
                }else{
                    problemVentaCarneList.remove("Intermediarios");
                }
                break;
            case R.id.ck_pro_vnt_car_6:
                if (checkedTipo) {
                    problemVentaCarneList.add("Pago diferido a la compra (fiado)");
                    //PROVECA = "Pago diferido a la compra (fiado)";
                }else{
                    problemVentaCarneList.remove("Pago diferido a la compra (fiado)");
                }
                break;
            case R.id.ck_pro_vnt_car_7:
                if (checkedTipo) {
                    problemVentaCarneList.add("Competencia en el territorio");
                    //PROVECA = "Competencia en el territorio";
                }else{
                    problemVentaCarneList.remove("Competencia en el territorio");
                }
                break;
            case R.id.ck_pro_vnt_car_8:
                if (checkedTipo) {
                    problemVentaCarneList.add("Edad de los becerros vs precio");
                    //PROVECA = "Edad de los becerros vs precio";
                }else{
                    problemVentaCarneList.remove("Edad de los becerros vs precio");
                }
                break;
            case R.id.ck_pro_vnt_car_9:
                if (checkedTipo) {
                    problemVentaCarneList.add("Falta acceso a mercados");
                    //PROVECA = "Falta acceso a mercados";
                }else{
                    problemVentaCarneList.remove("Falta acceso a mercados");
                }
                break;
        }
    }

    public void problemAspSocial(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_pro_asp_soc_1:
                if (checkedTipo) {
                    problemAspcSocialList.add("Abigeato (robo de ganado)");
                    //PROSOCIAL = "Abigeato (robo de ganado)";
                }else{
                    problemAspcSocialList.remove("Abigeato (robo de ganado)");
                }
                break;
            case R.id.ck_pro_asp_soc_2:
                if (checkedTipo) {
                    problemAspcSocialList.add("Inseguridad pública");
                    //PROSOCIAL = "Inseguridad pública";
                }else{
                    problemAspcSocialList.remove("Inseguridad pública");
                }
                break;
            case R.id.ck_pro_asp_soc_3:
                if (checkedTipo) {
                    //PROSOCIAL = "Adicciones recurrentes";
                    problemAspcSocialList.add("Adicciones recurrentes");
                }else{
                    problemAspcSocialList.remove("Adicciones recurrentes");
                }
                break;
            case R.id.ck_pro_asp_soc_4:
                if (checkedTipo) {
                    //PROSOCIAL = "Gobernanza y cacicazgo";
                    problemAspcSocialList.add("Gobernanza y cacicazgo");
                }else{
                    problemAspcSocialList.remove("Gobernanza y cacicazgo");
                }
                break;
            case R.id.ck_pro_asp_soc_5:
                if (checkedTipo) {
                    //PROSOCIAL = "Invasión de tierras";
                    problemAspcSocialList.add("Invasión de tierras");
                }else{
                    problemAspcSocialList.remove("Invasión de tierras");
                }
                break;
        }
    }

    public void problAspPolit(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_pro_asp_pol_1:
                if (checkedTipo) {
                    problemAspcPoliticList.add("Ideología política (partidos políticos, religiones)");
                    //PROPOLIT = "Ideología política (partidos políticos, religiones)";
                }else{
                    problemAspcPoliticList.remove("Ideología política (partidos políticos, religiones)");
                }
                break;
            case R.id.ck_pro_asp_pol_2:
                if (checkedTipo) {
                    problemAspcPoliticList.add("Políticas publicas confusas (reglas de operación)");
                    //PROPOLIT = "Políticas publicas confusas (reglas de operación)";
                }else{
                    problemAspcPoliticList.remove("Políticas publicas confusas (reglas de operación)");
                }
                break;
        }
    }

    public void problemAspMerc(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_pro_asp_mer_1:
                if (checkedTipo) {
                    problemAspcMercaList.add("Infraestructura carretera (caminos malos, terracerías)");
                    //PROMERCA = "Infraestructura carretera (caminos malos, terracerías)";
                }else{
                    problemAspcMercaList.remove("Infraestructura carretera (caminos malos, terracerías)");
                }
                break;
            case R.id.ck_pro_asp_mer_2:
                if (checkedTipo) {
                    problemAspcMercaList.add("Fijación de precios (variación de precios)");
                    //PROMERCA = "Fijación de precios (variación de precios)";
                }else{
                    problemAspcMercaList.remove("Fijación de precios (variación de precios)");
                }
                break;
        }
    }

    public void problemRecNatClim(View view) {
        boolean checkedTipo = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.ck_pro_asp_rn_1:
                if (checkedTipo) {
                    problemAspcRecrNatList.add("Sequías");
                    //PRORENACC = "Sequías";
                }else{
                    problemAspcRecrNatList.remove("Sequías");
                }
                break;
            case R.id.ck_pro_asp_rn_2:
                if (checkedTipo) {
                    problemAspcRecrNatList.add("Heladas/granizadas");
                    //PRORENACC = "Heladas/granizadas";
                }else{
                    problemAspcRecrNatList.remove("Heladas/granizadas");
                }
                break;
            case R.id.ck_pro_asp_rn_3:
                if (checkedTipo) {
                    problemAspcRecrNatList.add("Inundaciones");
                    //PRORENACC = "Inundaciones";
                }else{
                    problemAspcRecrNatList.remove("Inundaciones");
                }
                break;
            case R.id.ck_pro_asp_rn_4:
                if (checkedTipo) {
                    //PRORENACC = "Retraso de época de lluvias (Cuantos días)";
                    problemAspcRecrNatList.add("Retraso de época de lluvias (Cuantos días)");
                }else{
                    problemAspcRecrNatList.remove("Retraso de época de lluvias (Cuantos días)");
                }
                break;
            case R.id.ck_pro_asp_rn_5:
                if (checkedTipo) {
                    problemAspcRecrNatList.add("Vientos");
                    //PRORENACC = "Vientos";
                }else{
                    problemAspcRecrNatList.remove("Vientos");
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
