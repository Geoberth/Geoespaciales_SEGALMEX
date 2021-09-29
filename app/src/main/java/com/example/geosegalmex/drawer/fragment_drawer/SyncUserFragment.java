package com.example.geosegalmex.drawer.fragment_drawer;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.geosegalmex.R;
import com.example.geosegalmex.drawer.fragment_drawer.bdmunicipios.VolleySingleton;
import com.example.geosegalmex.drawer.fragment_drawer.bdusers.ModelUsuarios;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class SyncUserFragment extends Fragment {

    ExtendedFloatingActionButton fabUsuarios;
    private ProgressDialog progressDialog;

    DatabaseHelper db;
    private ArrayList<ModelUsuarios> azureArrayList;

    RequestQueue rq;

    public SyncUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vistaUsuarios = inflater.inflate(R.layout.fragment_sync_user, container, false);

        fabUsuarios = vistaUsuarios.findViewById(R.id.fab_sync_usuarios);

        db                  = new DatabaseHelper(getContext());
        azureArrayList = new ArrayList<>();


        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //+++++++++++++++++++++05 Diciembre 2019
        //rq = Volley.newRequestQueue(getContext(), new HurlStack(null, getSocketFactory()));
        //+++++++++++++++++++++++++++++++++++++++++


        fabUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TareaAsyncTask tareaAsyncTask = new TareaAsyncTask();
                //tareaAsyncTask.execute();
                consutaJsonSqlite();
            }
        });

        return vistaUsuarios;
    }


    //+++++++++++++++++++++Get Municiips+++++++++++++++++++++++++

    private void consutaJsonSqlite(){
        //  String urlAzure = "http://delagacion.azurewebsites.net/noticlikimages/seccion/secciondos.php";
        // String urlAzure = "http://localhost/SqliteSync/viewmunicipios.php";
        //String urlAzure = "http://10.11.21.186/SqliteSync/viewjson.php";


       // final String urlAzure = "https://mapoteca.siap.gob.mx/desarrollorural/viewjsonusr.php";
        final String urlAzure = "http://187.191.53.144/desarrollorural/viewjsonusr.php";

        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Descargando Datos");
        progressDialog.setCancelable(false);
        //progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        progressDialog.setMax(10);
        progressDialog.setMessage("Descargando...");
        progressDialog.show();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlAzure, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            int valor = 0;
                            JSONArray jsonArray = response.getJSONArray("Usuarios");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                valor = i;
                                // publishProgress();
                                JSONObject Usuarios      = jsonArray.getJSONObject(i);
                                String responsable    = Usuarios.getString("INVSTRESPON");
                                String usuarios = Usuarios.getString("USUARIO");
                                String password     = Usuarios.getString("PASSWORD");
                               // String nomEntidad     = Municipios.getString("NOM_ENT");
                               // String nomMunicipio     = Municipios.getString("NOM_MUN");
                                //textView.setText(azureArrayList.get(1).getTituloEspecta());
                                azureArrayList.add(new ModelUsuarios(responsable, usuarios, password));
                                agregarLocalAzureInfo(responsable, usuarios, password);

                            }
                            progressDialog.dismiss();
                            // textView.setText(String.valueOf(valor));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "¡Error en la conexión! Intenta de nuevo", Toast.LENGTH_SHORT).show();
                Log.e("FALLO LA CONEXION", error.toString());
            }
        });
      //  rq.add(request);
         VolleySingleton.getInstance(getContext()).addToRequestQueue(request);
    }


    public void agregarLocalAzureInfo(String responsable, String usuarios, String password){
        boolean insertarData = db.addDatosUsers(responsable, usuarios, password);
        if(insertarData == true) {
            Toast.makeText(getContext(), "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(), "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }



    //++++++++++++++++++++Certificado+++++++++++++++++++++++++
    private SSLSocketFactory getSocketFactory() {

        CertificateFactory cf = null;
        try {
            cf = CertificateFactory.getInstance("X.509");
            InputStream caInput = getResources().openRawResource(R.raw.f87a0836b68c13b0);
            Certificate ca;
            try {
                ca = cf.generateCertificate(caInput);
                Log.e("CERT", "ca=" + ((X509Certificate) ca).getSubjectDN());
            } finally {
                caInput.close();
            }


            String keyStoreType = KeyStore.getDefaultType();
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", ca);


            String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
            tmf.init(keyStore);


            HostnameVerifier hostnameVerifier = new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {

                    Log.e("CipherUsed", session.getCipherSuite());
                    // return hostname.compareTo("192.168.1.10")==0; //The Hostname of your server
                    return hostname.compareTo("mapoteca.siap.gob.mx")==0; //The Hostname of your server

                }
            };


            HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
            SSLContext context = null;
            context = SSLContext.getInstance("TLS");

            context.init(null, tmf.getTrustManagers(), null);
            HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());

            SSLSocketFactory sf = context.getSocketFactory();


            return sf;

        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

        return  null;
    }

    //++++++++++++++++++++++++++



    private class TareaAsyncTask extends AsyncTask<String, Integer, Boolean> {

        @Override
        protected void onPreExecute(){
            //tvProgreso.setText("0");
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setTitle("Descargando Datos");
            progressDialog.setCancelable(false);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMax(10);
            progressDialog.setMessage("Descargando...");
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

}
