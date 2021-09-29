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
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.geosegalmex.R;
import com.example.geosegalmex.drawer.fragment_drawer.bdmunicipios.ModelMunicipios;
import com.example.geosegalmex.unidadcaracterizacionhortalizas.db.DatabaseHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
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
public class SyncMunFragment extends Fragment {

    ExtendedFloatingActionButton fabMunicipios;
    private ProgressDialog progressDialog;
    DatabaseHelper db;
    private ArrayList<ModelMunicipios> azureArrayList;

    RequestQueue rq;


    public SyncMunFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vistaMunicipios = inflater.inflate(R.layout.fragment_sync_mun, container, false);

        //++++++++++++++++++++++02 Diciembre 2019 +++++++++++++++++++++++++++++++++++++++++++++++++
        db                  = new DatabaseHelper(getContext());
        azureArrayList = new ArrayList<>();


        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //+++++++++++++++++++++05 Diciembre 2019
        rq = Volley.newRequestQueue(getContext(), new HurlStack(null, getSocketFactory()));
        //+++++++++++++++++++++++++++++++++++++++++


        fabMunicipios = vistaMunicipios.findViewById(R.id.fab_sync_municipios);

        fabMunicipios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  TareaAsyncTask tareaAsyncTask = new TareaAsyncTask();
              //  tareaAsyncTask.execute();
                consutaJsonSqlite();

            }
        });

        return vistaMunicipios;
    }



    //+++++++++++++++++++++Get Municiips+++++++++++++++++++++++++

    private void consutaJsonSqlite(){
        //  String urlAzure = "http://delagacion.azurewebsites.net/noticlikimages/seccion/secciondos.php";
        // String urlAzure = "http://localhost/SqliteSync/viewmunicipios.php";
        //String urlAzure = "http://10.11.21.186/SqliteSync/viewjson.php";


        //String urlAzure = "https://mapoteca.siap.gob.mx/desarrollorural/viewjsonmunic.php";
        String urlAzure = "http://187.191.53.144/desarrollorural/viewjsonmunic.php";

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
                            JSONArray jsonArray = response.getJSONArray("Municipios");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                valor = i;
                               // publishProgress();
                                JSONObject Municipios      = jsonArray.getJSONObject(i);
                                int claveEntidad    = Municipios.getInt("CVE_ENT");
                                int claveMunicipio = Municipios.getInt("CVE_MUN");
                                int claveEstado     = Municipios.getInt("CVEGEO");
                                String nomEntidad     = Municipios.getString("NOM_ENT");
                                String nomMunicipio     = Municipios.getString("NOM_MUN");
                                //textView.setText(azureArrayList.get(1).getTituloEspecta());
                                azureArrayList.add(new ModelMunicipios(claveEntidad, claveMunicipio, claveEstado,nomEntidad, nomMunicipio));
                                agregarLocalAzureInfo(claveEntidad, claveMunicipio, claveEstado,nomEntidad, nomMunicipio);

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
        rq.add(request);
       // VolleySingleton.getInstance(getContext()).addToRequestQueue(request);
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

    private void copyInputStreamToOutputStream(InputStream in, PrintStream out) {
        System.out.println(out);
    }


    public void agregarLocalAzureInfo(int claveEntidad, int claveMunicipio, int claveEstado, String nomEntidad, String nomMunicipio){
        boolean insertarData = db.addDatosAzure(claveEntidad, claveMunicipio, claveEstado,nomEntidad, nomMunicipio);
        if(insertarData == true) {
            Toast.makeText(getContext(), "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(), "Algo salio mal", Toast.LENGTH_LONG).show();
        }
    }


    //++++++++++++++++++++++++++++++++++++++



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

            consutaJsonSqlite();
          //  for(int i=1; i<=10; i++){
           //     esperarUnSegundo();
                //publishProgress(i * 100 / 100);
            //    publishProgress(i);
           // }



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
