package com.example.geosegalmex.drawer.fragment_drawer;


import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geosegalmex.Liconsa.LiconsaBD;
import com.example.geosegalmex.Liconsa2.LiconsaVerificacionBD;
import com.example.geosegalmex.LiconsaBeneficiario.PASLbeneficiarioBD;
import com.example.geosegalmex.LiconsaVentanilla.PASLoperativoBD;
import com.example.geosegalmex.PARBeneficiario.PARBeneficiarioBD;
import com.example.geosegalmex.PAROperativo.PARoperativoBD;
import com.example.geosegalmex.PGBeneficiarioGranos.PGBgranosBD;
import com.example.geosegalmex.PGBeneficiarioLeche.PGBeneficiarioLecheBD;
import com.example.geosegalmex.PGBeneficiariosGranosIncentivos.PGBeneficiariosGranosIncentivosBD;
import com.example.geosegalmex.PGOperativoEstimulos.PGOperativoEstimulosBD;
import com.example.geosegalmex.PGOperativoGranos.PGOperativoGranosBD;
import com.example.geosegalmex.PGOperativoLeche.PGOperativoLecheBD;
import com.example.geosegalmex.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExportarFragment extends Fragment {



    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1 ;
    private TextView tvProgreso;

    ExtendedFloatingActionButton fabExportar, aaaa;
    TextView ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8, ed9, ed10, ed11;
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
        aaaa = vistaExportar.findViewById(R.id.aaa);
        ed1 = vistaExportar.findViewById(R.id.pasl_o_tvTitulo55);
        ed1.setVisibility(View.GONE);

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

        aaaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Estas segur@?")
                        .setContentText("Deseas borrar tus registros")
                        .setConfirmText("Si")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                PASLoperativoBD baseBD;
                                baseBD = new PASLoperativoBD(getContext());
                                baseBD.deletePASLoperativo();

                                PASLbeneficiarioBD baseBD2;
                                baseBD2 = new PASLbeneficiarioBD(getContext());
                                baseBD2.deletePASLbeneficiario();

                                LiconsaBD baseBD3;
                                baseBD3 = new LiconsaBD(getContext());
                                baseBD3.deleteRNPLProductor();

                                LiconsaVerificacionBD baseBD4;
                                baseBD4 = new LiconsaVerificacionBD(getContext());
                                baseBD4.deleteRNPLExpediente();

                                PARBeneficiarioBD baseBD5;
                                baseBD5 = new PARBeneficiarioBD(getContext());
                                baseBD5.deletePARBeneficiario();

                                PARoperativoBD baseBD6;
                                baseBD6 = new PARoperativoBD(getContext());
                                baseBD6.deleteaddPAR_Operativo();

                                PGBgranosBD baseBD7;
                                baseBD7 = new PGBgranosBD(getContext());
                                baseBD7.deletePGBeneficiarioGranos();

                                PGBeneficiarioLecheBD baseBD8;
                                baseBD8 = new PGBeneficiarioLecheBD(getContext());
                                baseBD8.deletePGBeneficiarioLeche();

                                PGOperativoEstimulosBD baseBD9;
                                baseBD9 = new PGOperativoEstimulosBD(getContext());
                                baseBD9.deletePGOperativoEstimulos();

                                PGOperativoGranosBD baseBD10;
                                baseBD10 = new PGOperativoGranosBD(getContext());
                                baseBD10.deletePGOperativoGranos();

                                PGOperativoLecheBD baseBD11;
                                baseBD11 = new PGOperativoLecheBD(getContext());
                                baseBD11.deletePGOperativoLeche();

                                PGBeneficiariosGranosIncentivosBD baseBD12;
                                baseBD12 = new PGBeneficiariosGranosIncentivosBD(getContext());
                                baseBD12.deletePGBeneficiarioGranosIncentivos();

                                ed1.setText("Bases de datos borradas.");
                                ed1.setVisibility(View.VISIBLE);
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .setCancelButton("No", new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();


            }

        });


        fabExportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setVisibility(View.GONE);
                ed1.setText("Listo!, Bases de datos exportadas.");
                final ProgressDialog progressDialog = new ProgressDialog(getActivity());
                progressDialog.setTitle("Descargando Datos");
                progressDialog.setCancelable(false);
                //progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        progressDialog.setMax(10);
                progressDialog.setMessage("Descargando...");
                progressDialog.show();

                new Handler().postDelayed(new Runnable() {
                    public void run() {
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
                        }
                        catch (IOException e) {
                            try {
                                deployDatabase("PGOperativoEstimulos");
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            e.printStackTrace();

                        }

                        try {
                            deployDatabase("PGOperativoGranos");
                        } catch (IOException e) {
                            try {
                                deployDatabase("PGOperativoGranos");
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            e.printStackTrace();
                        }

                        try {
                            deployDatabase("PGOperativoLeche");
                        } catch (IOException e) {
                            try {
                                deployDatabase("PGOperativoLeche");
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            e.printStackTrace();
                        }

                        try {
                            deployDatabase("PGBeneficiarioGranos");
                        } catch (IOException e) {
                            try {
                                deployDatabase("PGBeneficiarioGranos");
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            e.printStackTrace();
                        }

                        try {
                            deployDatabase("PGBeneficiarioLeche");
                        } catch (IOException e) {
                            try {
                                deployDatabase("PGBeneficiarioLeche");
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            e.printStackTrace();
                        }

                        try {
                            deployDatabase("PARBeneficiario");
                        } catch (IOException e) {
                            try {
                                deployDatabase("PARBeneficiario");
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            e.printStackTrace();
                        }

                        try {
                            deployDatabase("RNPLProductor");
                        } catch (IOException e) {
                            try {
                                deployDatabase("RNPLProductor");
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            e.printStackTrace();
                        }

                        try {
                            deployDatabase("PAROperativo");
                        } catch (IOException e) {
                            try {
                                deployDatabase("PAROperativo");
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            e.printStackTrace();
                        }

                        try {
                            deployDatabase("RNPLExpediente");
                        } catch (IOException e) {
                            try {
                                deployDatabase("RNPLExpediente");
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            e.printStackTrace();
                        }

                        try {
                            deployDatabase("PGBeneficiarioEstimulos");
                        } catch (IOException e) {
                            try {
                                deployDatabase("PGBeneficiarioEstimulos");
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            e.printStackTrace();
                        }

                        ed1.setVisibility(View.VISIBLE);
                    }
                },2000);





                // TareaAsyncTask tareaAsyncTask = new TareaAsyncTask();
                // tareaAsyncTask.execute();
                progressDialog.dismiss();
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

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
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
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
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


    }





}