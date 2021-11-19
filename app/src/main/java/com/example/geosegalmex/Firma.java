package com.example.geosegalmex;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ajithvgiri.canvaslibrary.CanvasView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Firma extends AppCompatActivity {

    CanvasView myDrawView;
    String typeproyect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firma);

        validaPermisos();

        typeproyect = General.Proyecto;
        typeproyect = typeproyect.replaceAll(" ","");
        myDrawView = (CanvasView)findViewById(R.id.draw);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                myDrawView.clear();
            }
        });

        button1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                try {
                    getfirma(typeproyect,General.Foliocuestion);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        });

    }

    private boolean validaPermisos() {

        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            return true;
        }

        if((checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)&&
                (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED)){
            return true;
        }

        if((shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) ||
                (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE))){
        }else{

            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},100);
        }
        return false;
    }

    @Override
    public void onBackPressed() {

    }

    private void getfirma(String DB_NAME, String name) throws IOException {

        String DB_PATHCopy =Environment.getExternalStorageDirectory() + "/" + DB_NAME;

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            File file = new File(getExternalFilesDir(null), "/" + DB_NAME + "/");
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        else{
            File directory = new File(DB_PATHCopy);
            if (!directory.exists()) {
                String direc = Environment.getExternalStorageDirectory().toString() + "/" + DB_NAME + "/";
                new File(direc).mkdirs();
            }
        }

        String outFileName;
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            File file = new File(getExternalFilesDir(null), "/" + DB_NAME + "/" + name + ".jpg");
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            outFileName = file.getAbsolutePath();
        }
        else{
            outFileName = Environment.getExternalStorageDirectory() + "/" + DB_NAME + "/" + name + ".jpg";
        }

        FileOutputStream ostream = null;
        try
        {
            ostream = new FileOutputStream(outFileName);

            System.out.println(ostream);
            View targetView = myDrawView;

            Bitmap well = myDrawView.getBitmap();
            Bitmap save = Bitmap.createBitmap(480, 720, Bitmap.Config.ARGB_8888);
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            Canvas now = new Canvas(save);
            now.drawRect(new Rect(0,0,480,720), paint);
            now.drawBitmap(well, new Rect(0,0,well.getWidth(),well.getHeight()), new Rect(0,0,480,720), null);

            if(save == null) {
                System.out.println("NULL bitmap save\n");
            }
            save.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
            Toast.makeText(getApplicationContext(), "Firma Guardada", Toast.LENGTH_SHORT).show();

        }catch (NullPointerException e)
        {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Null error", Toast.LENGTH_SHORT).show();
        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "File error", Toast.LENGTH_SHORT).show();
        }


    }

}