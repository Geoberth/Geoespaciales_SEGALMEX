package com.example.geosegalmex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.provider.MediaStore;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geosegalmex.Liconsa.Liconsa;
import com.example.geosegalmex.Liconsa2.LiconsaVerificacion;
import com.example.geosegalmex.LiconsaBeneficiario.PASLBeneficiario;
import com.example.geosegalmex.LiconsaVentanilla.PASLOperativo;
import com.example.geosegalmex.PARBeneficiario.PARBeneficiario;
import com.example.geosegalmex.PAROperativo.PAR_Operativo;
import com.example.geosegalmex.PGBeneficiarioGranos.PGBeneficiariosGranos;
import com.example.geosegalmex.PGBeneficiarioLeche.PGBeneficiarioLeche;
import com.example.geosegalmex.PGBeneficiariosGranosIncentivos.PGBeneficiariosGranosIncentivos;
import com.example.geosegalmex.PGOperativoEstimulos.PGOperativoEstimulos;
import com.example.geosegalmex.PGOperativoGranos.PGOperativoGranos;
import com.example.geosegalmex.PGOperativoLeche.PGOperativoLeche;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class NewCamara extends AppCompatActivity {

    Button btnCamara, btnCamara2, btnCamara3, btnNext;
    ImageView logo1, logo2, logo3;
    TextView txt1, txt2, txt3;
    File archivo;
    File archivo2;
    File archivo3;
    String lizbelat = General.Latini;
    String lizbelon = General.Lonini;
    String lizID = General.Foliocuestion;
    String nombreImagen = ""+ lizID + "-" + lizbelat + "-" + lizbelon + "_1.jpg";
    String nombreImagen2 = ""+ lizID + "-" + lizbelat + "-" + lizbelon + "_2.jpg";
    String nombreImagen3 = ""+ lizID + "-" + lizbelat + "-" + lizbelon + "_3.jpg";
    String rutaImagen;
    String nombre, nombre2, nombre3;
    String version2 = Build.VERSION.RELEASE;
    String version = android.os.Build.VERSION.RELEASE;
    String typeproyect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_camara);

        typeproyect = General.Proyecto;
        typeproyect = typeproyect.replaceAll(" ","");
        btnCamara = findViewById(R.id.btnCamara);
        btnCamara2 = findViewById(R.id.btnCamara2);
        btnCamara3 = findViewById(R.id.btnCamara3);
        btnNext = findViewById(R.id.btnNext);
        logo1 = findViewById(R.id.logo1);
        logo2 = findViewById(R.id.logo2);
        logo3 = findViewById(R.id.logo3);
        txt1 = findViewById(R.id.txtlogo1);
        txt2 = findViewById(R.id.txtlogo2);
        txt3 = findViewById(R.id.txtlogo3);

        validaPermisos();

        btnCamara.setVisibility(View.VISIBLE);

        if(General.Proyecto.equals("RNPL Productor")){
            btnCamara3.setVisibility(View.VISIBLE);
        }



        btnCamara.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    abrirCamara("1");
                }
                else{
                    tomarFoto(1);

                }

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        btnCamara.setVisibility(View.GONE);
                        //btnCamara2.setVisibility(View.VISIBLE);
                        logo1.setVisibility(View.VISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                    }
                },2000);

            }
        });

        btnCamara2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    abrirCamara("2");
                }
                else{
                    tomarFoto(2);

                }
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        btnCamara2.setVisibility(View.GONE);
                        logo2.setVisibility(View.VISIBLE);
                        txt2.setVisibility(View.VISIBLE);
                    }
                },2000);


            }
        });

        btnCamara3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    abrirCamara("3");
                }
                else{
                    tomarFoto(3);

                }
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        btnCamara3.setVisibility(View.GONE);
                        logo3.setVisibility(View.VISIBLE);
                        txt3.setVisibility(View.VISIBLE);
                    }
                },2000);


            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(btnCamara.getVisibility()==View.VISIBLE || btnCamara2.getVisibility()==View.VISIBLE || btnCamara3.getVisibility()==View.VISIBLE){
                    Toast.makeText(getApplicationContext(), "Favor de capturar las fotos",Toast.LENGTH_SHORT).show();
                }
                else{
                    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
                        archivo = new File(getExternalFilesDir(null), "/" + typeproyect + "/" + nombre);
                        archivo2 = new File(getExternalFilesDir(null), "/" + typeproyect + "/" + nombre2);
                        General.Foto1 = nombre;
                        General.Foto2 = nombre2;
                        if(General.Proyecto.equals("RNPL Productor")){
                            archivo3 = new File(getExternalFilesDir(null), "/" + typeproyect + "/" + nombre3);
                            General.Foto3 = nombre3;
                        }
                    }
                    else{
                        archivo = new File(getExternalFilesDir(null), "../../../../" + typeproyect + "/" + nombreImagen);
                        archivo2 = new File(getExternalFilesDir(null), "../../../../" + typeproyect + "/" + nombreImagen2);
                        General.Foto1 = nombreImagen;
                        General.Foto2 = nombreImagen2;
                        if(General.Proyecto.equals("RNPL Productor")){
                            archivo3 =  new File(getExternalFilesDir(null), "../../../../" + typeproyect + "/" + nombreImagen3);
                            General.Foto3 = nombreImagen3;
                        }
                    }

                    if (!archivo.exists()){
                        Toast.makeText(getApplicationContext(), "No se guardo la Foto 1, favor de repetirla.",Toast.LENGTH_SHORT).show();
                        btnCamara.setVisibility(View.VISIBLE);
                        logo1.setVisibility(View.GONE);
                        txt1.setVisibility(View.GONE);
                    }
                    else if (!archivo2.exists()){
                        Toast.makeText(getApplicationContext(), "No se guardo la Foto 2, favor de repetirla.",Toast.LENGTH_SHORT).show();
                        btnCamara2.setVisibility(View.VISIBLE);
                        logo2.setVisibility(View.GONE);
                        txt2.setVisibility(View.GONE);
                    }
                    else if (General.Proyecto.equals("RNPL Productor") && !archivo3.exists()){
                        Toast.makeText(getApplicationContext(), "No se guardo la Foto 3, favor de repetirla.",Toast.LENGTH_SHORT).show();
                        btnCamara3.setVisibility(View.VISIBLE);
                        logo3.setVisibility(View.GONE);
                        txt3.setVisibility(View.GONE);
                    }
                    else{
                        int file_size = Integer.parseInt(String.valueOf(archivo.length()/1024));
                        int file_size2 = Integer.parseInt(String.valueOf(archivo2.length()/1024));
                        int file_size3 = 100;
                        if(General.Proyecto.equals("RNPL Productor")){
                            file_size3 = Integer.parseInt(String.valueOf(archivo3.length()/1024));
                        }

                        if(file_size<=1){
                            Toast.makeText(getApplicationContext(), "Error en la Foto 1, favor de repetirla.",Toast.LENGTH_SHORT).show();
                            btnCamara.setVisibility(View.VISIBLE);
                            logo1.setVisibility(View.GONE);
                            txt1.setVisibility(View.GONE);
                        }
                        else if(file_size2<=1){
                            Toast.makeText(getApplicationContext(), "Error en la Foto 2, favor de repetirla.",Toast.LENGTH_SHORT).show();
                            btnCamara2.setVisibility(View.VISIBLE);
                            logo2.setVisibility(View.GONE);
                            txt2.setVisibility(View.GONE);
                        }
                        else if(file_size3<=1){
                            Toast.makeText(getApplicationContext(), "Error en la Foto 3, favor de repetirla.",Toast.LENGTH_SHORT).show();
                            btnCamara3.setVisibility(View.VISIBLE);
                            logo3.setVisibility(View.GONE);
                            txt3.setVisibility(View.GONE);
                        }
                        else{
                            txt1.setText("Foto 1 guardada correctamente");
                            txt2.setText("Foto 2 guardada correctamente");
                            if(General.Proyecto.equals("RNPL Productor")){
                                txt3.setText("Foto 3 guardada correctamente");
                            }
                            btnNext.setVisibility(View.GONE);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    //Toast.makeText(getApplicationContext(), "Podemos avanzar",Toast.LENGTH_SHORT).show();
                                    if(General.Proyecto.equals("PASL Operativo")){
                                        startActivity(new Intent(getApplication(), PASLOperativo.class));
                                    }
                                    else if(General.Proyecto.equals("PASL Beneficiario")){
                                        startActivity(new Intent(getApplication(), PASLBeneficiario.class));
                                    }
                                    else if(General.Proyecto.equals("PG Operativo Estimulos")){
                                        startActivity(new Intent(getApplication(), PGOperativoEstimulos.class));
                                    }
                                    else if(General.Proyecto.equals("PG Operativo Granos")){
                                        startActivity(new Intent(getApplication(), PGOperativoGranos.class));
                                    }
                                    else if(General.Proyecto.equals("PG Operativo Leche")){
                                        startActivity(new Intent(getApplication(), PGOperativoLeche.class));
                                    }
                                    else if(General.Proyecto.equals("PG Beneficiario Leche")){
                                        startActivity(new Intent(getApplication(), PGBeneficiarioLeche.class));
                                    }
                                    else if (General.Proyecto.equals("PG Beneficiario Granos")){
                                        startActivity(new Intent(getApplication(), PGBeneficiariosGranos.class));
                                    }
                                    else if (General.Proyecto.equals("PAR Beneficiario")){
                                        startActivity(new Intent(getApplication(), PARBeneficiario.class));
                                    }
                                    else if (General.Proyecto.equals("PAR Operativo")){
                                        startActivity(new Intent(getApplication(), PAR_Operativo.class));
                                    }
                                    else if (General.Proyecto.equals("RNPL Productor")){
                                        startActivity(new Intent(getApplication(), Liconsa.class));
                                    }
                                    else if (General.Proyecto.equals("PG Beneficiario Estimulos")){
                                        startActivity(new Intent(getApplication(), PGBeneficiariosGranosIncentivos.class));
                                    }
                                    else{
                                        startActivity(new Intent(getApplication(), IdentificacionCuestionario.class));
                                    }
                                }
                            }, 1000);
                        }

                    }
                }
            }

        });

    }

    //Android 11
    private void abrirCamara(String id){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //if(intent.resolveActivity(getPackageManager()) != null){
        File imagenarchivo = null;
        try{
            imagenarchivo = crearimagen(id);
        }catch(IOException ex){
            Log.e("Error", ex.toString());
        }
        if(imagenarchivo != null){
            Uri fotoUri = FileProvider.getUriForFile(this, "com.example.geosegalmex.fileprovider", imagenarchivo);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri);
            startActivityForResult(intent, 1);
        }
        // }
    }

    private File crearimagen(String id) throws IOException {
        String lizbelat = General.Latini;
        String lizbelon = General.Lonini;
        String lizID = General.Foliocuestion;
        String nombreImagen = ""+ lizID + "-" + lizbelat + "-" + lizbelon + "_" + id + "_";

        File file = new File(getExternalFilesDir(null), "/" + typeproyect + "/");
        if (!file.exists()) {
            file.mkdirs();
        }
        File imagen = File.createTempFile(nombreImagen, ".jpg", file);
        rutaImagen = imagen.getAbsolutePath();
        String[] parts = rutaImagen.split("/");
        if (id.equals("1")){
            nombre = parts[9];
        }
        else if (id.equals("2")){
            nombre2 = parts[9];
        }
        else{
            nombre3 = parts[9];
        }

        return imagen;
    }

    //Android 10 o menor
    public void tomarFoto(int id) {
        String lizbelat = General.Latini;
        String lizbelon = General.Lonini;
        String lizID = General.Foliocuestion;
        String nombreImagennn = ""+ lizID + "-" + lizbelat + "-" + lizbelon + "_" + id + ".jpg";
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        String DB_PATHCopy =Environment.getExternalStorageDirectory() + "/" + typeproyect;
        File directory = new File(DB_PATHCopy);
        if (!directory.exists()) {
            String direc = Environment.getExternalStorageDirectory().toString() + "/" + typeproyect + "/";
            new File(direc).mkdirs();

            Intent intento1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File foto = new File(getExternalFilesDir(null), "../../../../" + typeproyect + "/" + nombreImagennn);
            intento1.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(foto));
            startActivity(intento1);
        }
        else{
            Intent intento1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File foto = new File(getExternalFilesDir(null), "../../../../" + typeproyect + "/" + nombreImagennn);
            intento1.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(foto));
            startActivity(intento1);
        }

    }

    private boolean validaPermisos() {

        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            return true;
        }

        if((checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED)&&
                (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED)){
            return true;
        }

        if((shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) ||
                (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE))){
        }else{

//falla aqui al ejecutar esta función
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},100);
        }
        return false;
    }

    @Override
    public void onBackPressed() {

    }
    

}