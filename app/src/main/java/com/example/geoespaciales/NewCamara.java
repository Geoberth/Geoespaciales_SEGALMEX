

package com.example.geoespaciales;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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

import com.example.geoespaciales.Gps.GpsEnableb;

import java.io.File;
import java.io.IOException;

public class NewCamara extends AppCompatActivity {

    Button btnCamara, btnCamara2, btnNext;
    ImageView logo1, logo2;
    TextView txt1, txt2;
    File archivo;
    File archivo2;
    String lizbelat = GpsEnableb.lizlati;
    String lizbelon = GpsEnableb.lizlong;
    String lizID = General.Foliocuestion;
    String nombreImagen = ""+ lizID + "," + lizbelat + "," + lizbelon + "_1.jpg";
    String nombreImagen2 = ""+ lizID + "," + lizbelat + "," + lizbelon + "_2.jpg";
    String rutaImagen;
    String nombre;
    String version = Build.VERSION.RELEASE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_camara);

        btnCamara = findViewById(R.id.btnCamara);
        btnCamara2 = findViewById(R.id.btnCamara2);
        btnNext = findViewById(R.id.btnNext);
        logo1 = findViewById(R.id.logo1);
        logo2 = findViewById(R.id.logo2);
        txt1 = findViewById(R.id.txtlogo1);
        txt2 = findViewById(R.id.txtlogo2);

        validaPermisos();

        btnCamara.setVisibility(View.VISIBLE);


        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(version)>10){
                    abrirCamara("1");
                }
                else{
                    tomarFoto(1);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnCamara.setVisibility(View.GONE);
                        btnCamara2.setVisibility(View.VISIBLE);
                        logo1.setVisibility(View.VISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                    }
                },2000);

            }
        });

        btnCamara2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(version)>10){
                    archivo = new File(getExternalFilesDir(null), "/GEOESPACIALES/" + nombre);
                }
                else{
                    archivo = new File(getExternalFilesDir(null), "../../../../GEOESPACIALES/" + nombreImagen);
                }

                if (!archivo.exists()){
                    Toast.makeText(getApplicationContext(), "No se guardo la Foto 1, favor de repetirla.",Toast.LENGTH_SHORT).show();
                    btnCamara.setVisibility(View.VISIBLE);
                    btnCamara2.setVisibility(View.GONE);
                    logo1.setVisibility(View.GONE);
                    txt1.setVisibility(View.GONE);
                }
                else{
                    if(Integer.parseInt(version)>10){
                        abrirCamara("2");
                    }
                    else{
                        tomarFoto(2);
                    }
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btnCamara2.setVisibility(View.GONE);
                            btnNext.setVisibility(View.VISIBLE);
                            logo2.setVisibility(View.VISIBLE);
                            txt2.setVisibility(View.VISIBLE);
                            txt1.setText("Foto 1 guardada correctamente");
                        }
                    },2000);
                }

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(version)>10){
                    archivo2 = new File(getExternalFilesDir(null), "/GEOESPACIALES/" + nombre);
                }
                else{
                    archivo2 = new File(getExternalFilesDir(null), "../../../../GEOESPACIALES/" + nombreImagen2);
                }


                if (!archivo2.exists()){
                    Toast.makeText(getApplicationContext(), "No se guardo la Foto 2, favor de repetirla.",Toast.LENGTH_SHORT).show();
                    btnCamara2.setVisibility(View.VISIBLE);
                    btnNext.setVisibility(View.GONE);
                    logo2.setVisibility(View.GONE);
                    txt2.setVisibility(View.GONE);
                }
                else{
                    txt2.setText("Foto 2 guardada correctamente");
                    btnNext.setVisibility(View.GONE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //Toast.makeText(getApplicationContext(), "Podemos avanzar",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplication(), IdentificacionCuestionario.class));
                        }
                    },2000);
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
                Uri fotoUri = FileProvider.getUriForFile(this, "com.example.geoespaciales.fileprovider", imagenarchivo);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri);
                startActivityForResult(intent, 1);
            }
       // }
    }

    private File crearimagen(String id) throws IOException {
        String lizbelat = GpsEnableb.lizlati;
        String lizbelon = GpsEnableb.lizlong;
        String lizID = General.Foliocuestion;
        String nombreImagen = ""+ lizID + "," + lizbelat + "," + lizbelon + "_" + id + "_";

        File file = new File(getExternalFilesDir(null), "/GEOESPACIALES/");
        if (!file.exists()) {
            file.mkdirs();
        }
        File imagen = File.createTempFile(nombreImagen, ".jpg", file);
        rutaImagen = imagen.getAbsolutePath();
        String[] parts = rutaImagen.split("/");
        nombre = parts[9];
        return imagen;
    }

    //Android 10 o menor
    public void tomarFoto(int id) {
        String lizbelat = GpsEnableb.lizlati;
        String lizbelon = GpsEnableb.lizlong;
        String lizID = General.Foliocuestion;
        String nombreImagennn = ""+ lizID + "," + lizbelat + "," + lizbelon + "_" + id + ".jpg";
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        String DB_PATHCopy =Environment.getExternalStorageDirectory() + "/" + "GEOESPACIALES";
        File directory = new File(DB_PATHCopy);
        if (!directory.exists()) {
            String direc = Environment.getExternalStorageDirectory().toString() + "/GEOESPACIALES/";
            new File(direc).mkdirs();

            Intent intento1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File foto = new File(getExternalFilesDir(null), "../../../../GEOESPACIALES/" + nombreImagennn);
            intento1.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(foto));
            startActivity(intento1);
        }
        else{
            Intent intento1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File foto = new File(getExternalFilesDir(null), "../../../../GEOESPACIALES/" + nombreImagennn);
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

}