package com.example.geosegalmex.drawer.fragment_drawer;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.os.Handler;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.geosegalmex.PAROperativo.PAR_operativo_model;
import com.example.geosegalmex.PAROperativo.PARoperativoBD;
import com.example.geosegalmex.R;
import com.example.geosegalmex.drawer.DrawerActivity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiconsaPrecios extends Fragment {

    TextView tv1, tv3;
    ImageView tv2;
    Spinner folios, produc;
    Button cam, next;

    String rutaImagen;
    String nombre;
    String typeproyect = "PAROperativo";

    File archivo;
    String nombreImagen = "aaa" + ".jpg";

    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1 ;

    public LiconsaPrecios() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vistaExportar= inflater.inflate(R.layout.fragment_liconsa_precios, container, false);
        tv3 = vistaExportar.findViewById(R.id.tv3);

        tv1 = vistaExportar.findViewById(R.id.txtlogo1);
        tv2 = vistaExportar.findViewById(R.id.logo1);
        cam = vistaExportar.findViewById(R.id.btnCamara);
        next = vistaExportar.findViewById(R.id.btnNext);
        next.setVisibility(View.GONE);

        //Permisos de almacenamiento
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            } else {

                ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);

            }
        }


        //Conectamos a BD y obtenemos registros
        PARoperativoBD db = new PARoperativoBD(getContext());
        List<PAR_operativo_model> everyone = db.getEveryone();

        //Añadimos los folios a un array
        ArrayList<String> miArreglo = new ArrayList<String>();

        for(int i=0; i<everyone.size(); i++){
            miArreglo.add(everyone.get(i).getFolio());
        }

        //Agregamos el array de folios al spinner
        folios = vistaExportar.findViewById(R.id.sp1);
        produc = vistaExportar.findViewById(R.id.sp2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, miArreglo);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        folios.setAdapter(adapter2);
        folios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //Se detecta la opcion seleccionada
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                tv3.setText("Entidad: " + everyone.get(position).getNoment() + "\nMunicipio: " + everyone.get(position).getNommun() +  "\nNombre: " + everyone.get(position).getParnom() + " " + everyone.get(position).getParape());
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });


        cam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if(everyone.size() == 0){
                    Toast.makeText(getContext(), "No tienes registros guardados!" ,Toast.LENGTH_SHORT).show();
                }
                else{
                    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        abrirCamara("1");
                    }
                    else{
                        tomarFoto(1);

                    }

                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            cam.setVisibility(View.GONE);
                            tv1.setVisibility(View.VISIBLE);
                            tv2.setVisibility(View.VISIBLE);
                            next.setVisibility(View.VISIBLE);
                        }
                    },2000);
                }


            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(everyone.size() == 0){
                    Toast.makeText(getContext(), "No tienes registros guardados!" ,Toast.LENGTH_SHORT).show();
                }
                else{
                    nombreImagen = ""  + folios.getSelectedItem().toString() + "_" + produc.getSelectedItem().toString().replaceAll(" ","") + ".jpg";
                    if(cam.getVisibility()==View.VISIBLE){
                        Toast.makeText(getContext(), "Favor de capturar las fotos",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
                            archivo = new File(getActivity().getExternalFilesDir(null), "/" + typeproyect + "/" + nombre);

                        }
                        else{
                            archivo = new File(getActivity().getExternalFilesDir(null), "../../../../" + typeproyect + "/" + nombreImagen);
                        }

                        if (!archivo.exists()){
                            Toast.makeText(getContext(), "No se guardo la Foto, favor de repetirla.",Toast.LENGTH_SHORT).show();
                            cam.setVisibility(View.VISIBLE);
                            tv1.setVisibility(View.GONE);
                            tv2.setVisibility(View.GONE);
                            next.setVisibility(View.GONE);
                        }
                        else{
                            int file_size = Integer.parseInt(String.valueOf(archivo.length()/1024));
                            if(file_size<=1){
                                Toast.makeText(getContext(), "Error en la Foto, favor de repetirla.",Toast.LENGTH_SHORT).show();
                                cam.setVisibility(View.VISIBLE);
                                tv1.setVisibility(View.GONE);
                                tv2.setVisibility(View.GONE);
                                next.setVisibility(View.GONE);
                            }
                            else{
                                tv1.setText("Foto guardada correctamente");
                                next.setVisibility(View.GONE);
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        startActivity(new Intent(getContext(), DrawerActivity.class));
                                    }
                                }, 1000);
                            }

                        }
                    }
                }
            }


        });


        return vistaExportar;
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
            Uri fotoUri = FileProvider.getUriForFile(getContext(), "com.example.geosegalmex.fileprovider", imagenarchivo);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri);
            startActivityForResult(intent, 1);
        }
        // }
    }

    private File crearimagen(String id) throws IOException {
        String nombreImagen = ""  + folios.getSelectedItem().toString() + "_" + produc.getSelectedItem().toString().replaceAll(" ","") + "_";

        File file = new File(getActivity().getExternalFilesDir(null), "/" + typeproyect + "/");
        if (!file.exists()) {
            file.mkdirs();
        }
        File imagen = File.createTempFile(nombreImagen, ".jpg", file);
        rutaImagen = imagen.getAbsolutePath();
        String[] parts = rutaImagen.split("/");
        if (id.equals("1")){
            nombre = parts[9];
        }

        return imagen;
    }

    //Android 10 o menor
    public void tomarFoto(int id) {
        String nombreImagennn = ""  + folios.getSelectedItem().toString() + "_" + produc.getSelectedItem().toString().replaceAll(" ","") + ".jpg";
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        String DB_PATHCopy = Environment.getExternalStorageDirectory() + "/" + typeproyect;
        File directory = new File(DB_PATHCopy);
        if (!directory.exists()) {
            String direc = Environment.getExternalStorageDirectory().toString() + "/" + typeproyect + "/";
            new File(direc).mkdirs();

            Intent intento1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File foto = new File(getActivity().getExternalFilesDir(null), "../../../../" + typeproyect + "/" + nombreImagennn);
            intento1.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(foto));
            startActivity(intento1);
            rutaImagen = foto.getAbsolutePath();
        }
        else{
            Intent intento1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File foto = new File(getActivity().getExternalFilesDir(null), "../../../../" + typeproyect + "/" + nombreImagennn);
            intento1.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(foto));
            startActivity(intento1);
            rutaImagen = foto.getAbsolutePath();
        }


    }



}