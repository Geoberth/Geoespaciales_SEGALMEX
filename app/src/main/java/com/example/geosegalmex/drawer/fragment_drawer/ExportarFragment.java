package com.example.geosegalmex.drawer.fragment_drawer;


import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geosegalmex.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExportarFragment extends Fragment {



    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1 ;
    private TextView tvProgreso;

    ExtendedFloatingActionButton fabExportar;
    private ProgressDialog progressDialog;

    public ExportarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vistaExportar= inflater.inflate(R.layout.fragment_exportar, container, false);


        // tvProgreso = vistaExportar.findViewById(R.id.tvProgreso);
        fabExportar = vistaExportar.findViewById(R.id.fab_exportar);

        int permissionCheck = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            } else {

                ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);

            }
        }


        fabExportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    deployDatabase("PASLOperativo");
                } catch (IOException e) {
                    try {
                        deployDatabase("PASLOperativo");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    e.printStackTrace();

                }

                try {
                    deployDatabase("PASLBeneficiario");
                } catch (IOException e) {
                    try {
                        deployDatabase("PASLBeneficiario");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    e.printStackTrace();

                }

                try {
                    deployDatabase("PGOperativoEstimulos");
                } catch (IOException e) {
                    try {
                        deployDatabase("PGOperativoEstimulos");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    e.printStackTrace();

                }


                // TareaAsyncTask tareaAsyncTask = new TareaAsyncTask();
                // tareaAsyncTask.execute();
            }
        });

        return vistaExportar;
    }

    private class TareaAsyncTask extends AsyncTask<String, Integer, Boolean> {

        @Override
        protected void onPreExecute(){
            //tvProgreso.setText("0");
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setTitle("Exportando Datos");
            progressDialog.setCancelable(false);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMax(10);
            progressDialog.setMessage("Exportando");
            progressDialog.show();
        }

        @Override
        protected Boolean doInBackground(String... strings) {



            for(int i=1; i<=10; i++){
                esperarUnSegundo();
                //publishProgress(i * 100 / 100);
                publishProgress(i);
            }



            //publishProgress(100 * 100 / 100);
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values){
            //tvProgreso.setText(values[0].toString());
            progressDialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Boolean result){
            //tvProgreso.setText(resultado);
            progressDialog.dismiss();
        }
    }

    private void esperarUnSegundo(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }

    }

    public File crearDirectorioPublico(String nombreDirectorio) {
        //Crear directorio público en la carpeta Pictures.
        File directorio = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), nombreDirectorio);
        //Muestro un mensaje en el logcat si no se creo la carpeta por algun motivo

        return directorio;
    }


    private void deployDatabase(String DB_NAME) throws IOException {
//Open your local db as the input stream

       /* if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
        }
*/
        String packageName = getContext().getPackageName();
        String DB_PATH = "/data/data/" + packageName + "/databases/";
        String DB_PATHCopy =Environment.getExternalStorageDirectory() + "/" + DB_NAME;

        String version = Build.VERSION.RELEASE;

        if(Integer.parseInt(version)>10){
            File file = new File(getActivity().getExternalFilesDir(null), "/" + DB_NAME + "/");
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        else{
            File directory = new File(DB_PATHCopy);
            if (!directory.exists()) {
                //Toast.makeText(getContext(), "No: " + directory, Toast.LENGTH_LONG).show();
                String direc = Environment.getExternalStorageDirectory().toString() + "/" + DB_NAME + "/";

                new File(direc).mkdirs();
            }
            else{
                //Toast.makeText(getContext(), "Si: " + directory, Toast.LENGTH_LONG).show();
            }
        }




        Log.e("========>>", DB_PATH);

        //InputStream myInput = getAssets().open("BDENCUESTA");
        InputStream myInput = new FileInputStream(DB_PATH + DB_NAME);

// Path to the just created empty db
        //String outFileName = DB_PATH + DB_NAME;
        //String outFileName = Environment.getExternalStorageDirectory() + "/" + DB_NAME;

        String outFileName;
        if(Integer.parseInt(version)>10){
            File file = new File(getActivity().getExternalFilesDir(null), "/" + DB_NAME + "/" + DB_NAME);
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
            outFileName = Environment.getExternalStorageDirectory() + "/" + DB_NAME + "/" + DB_NAME;
        }

        //String outFileName = Environment.getExternalStorageDirectory() + "/" + "GEOESPACIALES" + "/" + "basedatos";

        Log.e("========>>", outFileName);
//Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

//transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

//Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

        Toast.makeText(getContext(), "Base de datos: " + DB_NAME + " exportada", Toast.LENGTH_LONG).show();
    }
}