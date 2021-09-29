package com.example.geosegalmex.Geo;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.geosegalmex.General;
import com.example.geosegalmex.Gps.GpsEnableb;
import com.example.geosegalmex.IdentificacionCuestionario;
import com.example.geosegalmex.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FotoActivityUno extends AppCompatActivity {
    Button btnNext;
    Button button;
    TextureView textureView;
    Button botonFotoDos;
    Toast toastMessageUno;

    String lizlat, lizlon;



    int fotoCheck = 0;

    private static final SparseIntArray ORIENTATIONS = new SparseIntArray();
    private int valorCamarados = 0;

    static{
        ORIENTATIONS.append(Surface.ROTATION_0, 90);
        ORIENTATIONS.append(Surface.ROTATION_90, 0);
        ORIENTATIONS.append(Surface.ROTATION_180, 270);
        ORIENTATIONS.append(Surface.ROTATION_270, 180);
    }

    private String cameraId;
    CameraDevice cameraDevice;
    CameraCaptureSession cameraCaptureSession;
    CaptureRequest captureRequest;
    CaptureRequest.Builder captureRequestBuilder;

    private Size imageDimensions;
    private ImageReader imageReader;
    private File file;
    Handler mBackgroundHandler;
    HandlerThread mBackgroundThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto_uno);
        textureView=(TextureView)findViewById(R.id.textureUno);
        button = (Button)findViewById(R.id.button_captureUno);

        //textureView.setSurfaceTextureListener(textureListener);
        botonFotoDos = findViewById(R.id.button_fotodos_capture);
        botonFotoDos.setVisibility(View.GONE);
        btnNext = findViewById(R.id.btn_nex_fot_tray);
        btnNext.setVisibility(View.GONE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //botonFotoDos.setVisibility(View.VISIBLE);
                    fotoCheck =1;
                    takePicture();


                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }

        });


        botonFotoDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                toastMessageUno.cancel();

                try {
                    fotoCheck =2;
                    takePicture();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
                //  startActivity(new Intent(getApplication(), FotoActivityDos.class));
              //  finish();
            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMessageUno.cancel();
                finish();
                startActivity(new Intent(getApplication(), IdentificacionCuestionario.class));
                toastMessageUno.cancel();
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 101)
        {
            if(grantResults[0] == PackageManager.PERMISSION_DENIED)
            {
                Toast.makeText(getApplicationContext(), "Lo siento, se deben otorgar los permisos de la camara", Toast.LENGTH_LONG).show();
                //finish();
            }
        }
    }

    TextureView.SurfaceTextureListener textureListener = new TextureView.SurfaceTextureListener() {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {

            try {
                openCamera();
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            return false;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {

        }
    };

    private final CameraDevice.StateCallback stateCallback = new CameraDevice.StateCallback() {
        @Override
        public void onOpened( CameraDevice camera) {
            cameraDevice = camera;
            try {
                createCameraPreview();
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onDisconnected( CameraDevice camera) {
            cameraDevice.close();
        }

        @Override
        public void onError( CameraDevice camera, int error) {
            cameraDevice.close();
            cameraDevice = null;
        }
    };

    private void createCameraPreview() throws CameraAccessException {
        SurfaceTexture texture = textureView.getSurfaceTexture();
        texture.setDefaultBufferSize(imageDimensions.getWidth(), imageDimensions.getHeight());
        Surface surface = new Surface(texture);

        captureRequestBuilder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
        captureRequestBuilder.addTarget(surface);

        cameraDevice.createCaptureSession(Arrays.asList(surface), new CameraCaptureSession.StateCallback() {
            @Override
            public void onConfigured(@NonNull CameraCaptureSession session) {
                if(cameraDevice==null)
                {
                    return;
                }

                cameraCaptureSession = session;
                try {
                    updatePreview();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onConfigureFailed(@NonNull CameraCaptureSession session) {
                Toast.makeText(getApplicationContext(), "Configuración cambiada", Toast.LENGTH_LONG).show();
            }
        }, null);
    }

    private void updatePreview() throws CameraAccessException {
        if (cameraDevice == null) {
            return;
        }
        captureRequestBuilder.set(CaptureRequest.CONTROL_MODE, CaptureRequest.CONTROL_MODE_AUTO);

        cameraCaptureSession.setRepeatingRequest(captureRequestBuilder.build(), null, mBackgroundHandler);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void openCamera() throws CameraAccessException {
        CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        cameraId = manager.getCameraIdList()[0];

        CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraId);

        StreamConfigurationMap map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);

        imageDimensions = map.getOutputSizes(SurfaceTexture.class)[0];

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},101);
            return;
        }

        manager.openCamera(cameraId,stateCallback, null);
    }

    private void takePicture() throws CameraAccessException {
        //    botonFotoDos = findViewById(R.id.button_fotodos_capture);
        //    botonFotoDos.setVisibility(View.VISIBLE);

        if(cameraDevice == null)
        {
            return;
        }
        CameraManager manager = (CameraManager)getSystemService(Context.CAMERA_SERVICE);

        CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraDevice.getId());
        Size[] jpegSizes = null;

        jpegSizes = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP).getOutputSizes(ImageFormat.JPEG);

        int width = 640;
        int height = 480;

        if(jpegSizes!=null && jpegSizes.length>0) {
            width = jpegSizes[0].getWidth();
            height = jpegSizes[0].getHeight();
        }
        ImageReader reader = ImageReader.newInstance(width, height, ImageFormat.JPEG, 1);
        List<Surface> outputSurfaces = new ArrayList<>(2);
        outputSurfaces.add(reader.getSurface());

        outputSurfaces.add(new Surface(textureView.getSurfaceTexture()));

        final CaptureRequest.Builder captureBuilder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE);
        captureBuilder.addTarget(reader.getSurface());
        captureBuilder.set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);

        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        captureBuilder.set(CaptureRequest.JPEG_ORIENTATION,ORIENTATIONS.get(rotation));

        //Long tsLong = System.currentTimeMillis()/1000;
        Long tsLong = System.currentTimeMillis()/30000;

        String ts = tsLong.toString();
        String foli = General.Foliocuestion;
        String lizbelat = GpsEnableb.lizlati;
        String lizbelon = GpsEnableb.lizlong;
        String lizID = General.Foliocuestion;
        if(fotoCheck == 1) {
            //file = new File(Environment.getExternalStorageDirectory() + "/" + ts + "_"+ foli + "_1" + ".jpg");
            file = new File(Environment.getExternalStorageDirectory() + "/" + lizID + "," + lizbelat + "," + lizbelon + "_1" + ".jpg");
            botonFotoDos.setVisibility(View.VISIBLE);
        }

        if(fotoCheck == 2) {
            //file = new File(Environment.getExternalStorageDirectory() + "/" + ts + "_"+ foli +"_2" + ".jpg");
            file = new File(Environment.getExternalStorageDirectory() + "/" + lizID + "," + lizbelat + "," + lizbelon + "_2" + ".jpg");
            btnNext.setVisibility(View.VISIBLE);
        }

        ImageReader.OnImageAvailableListener readerListener =new ImageReader.OnImageAvailableListener() {
            @Override
            public void onImageAvailable(ImageReader reader) {
                Image image = null;

                image = reader.acquireLatestImage();
                ByteBuffer buffer = image.getPlanes()[0].getBuffer();
                byte[] bytes = new byte[buffer.capacity()];
                buffer.get(bytes);
                try {
                    save(bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if(image!=null)
                    {
                        image.close();
                    }
                }
            }
        };

        reader.setOnImageAvailableListener(readerListener,mBackgroundHandler);

        final CameraCaptureSession.CaptureCallback captureListener = new CameraCaptureSession.CaptureCallback() {
            @Override
            public void onCaptureCompleted( CameraCaptureSession session, CaptureRequest request, TotalCaptureResult result) {
                super.onCaptureCompleted(session, request, result);

                if(fotoCheck == 1) {
                    toastMessageUno = Toast.makeText(getApplicationContext(), "Foto 1 Guardada", Toast.LENGTH_SHORT);
                    toastMessageUno.show();
                }
                if(fotoCheck == 2) {
                    toastMessageUno = Toast.makeText(getApplicationContext(), "Foto 2 Guardada", Toast.LENGTH_SHORT);
                    toastMessageUno.show();

                }

                //startActivity(new Intent(getApplication(), GeoFotos.class));


                try {
                    Log.i("foto guardada", result+"");
                    Log.i("foto guardada", request+"");
                    valorCamarados = 1;
                    //    botonFotoDos = findViewById(R.id.button_fotodos_capture);
                    //    botonFotoDos.setVisibility(View.GONE);
                    createCameraPreview();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }


            }
        };
        cameraDevice.createCaptureSession(outputSurfaces, new CameraCaptureSession.StateCallback() {
            @Override
            public void onConfigured(@NonNull CameraCaptureSession session) {
                try{
                    session.capture(captureBuilder.build(), captureListener, mBackgroundHandler);
                }
                catch (CameraAccessException e)
                {
                    e.printStackTrace();
                }
            }
            @Override
            public void onConfigureFailed( CameraCaptureSession session) {

            }
        },mBackgroundHandler);
    }



    private void save(byte[] bytes) throws IOException {
        OutputStream outputStream = null;

        outputStream = new FileOutputStream(file);

        outputStream.write(bytes);

        outputStream.close();
    }

    @Override
    protected void onResume(){
        super.onResume();

        startBackgroundThread();

        if(textureView.isAvailable())
        {
            try {
                openCamera();
            } catch (CameraAccessException e){
                e.printStackTrace();
            }
        }
        else
        {
            textureView.setSurfaceTextureListener(textureListener);
        }
    }
    private void startBackgroundThread()
    {
        mBackgroundThread = new HandlerThread("Camara Background");
        mBackgroundThread.start();
        mBackgroundHandler = new Handler(mBackgroundThread.getLooper());
    }

    @Override
    protected void onPause(){
        try {
            stopBackgroundThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        super.onPause();
    }
    protected void stopBackgroundThread() throws InterruptedException
    {
        mBackgroundThread.quitSafely();

        mBackgroundThread.join();
        mBackgroundThread = null;
        mBackgroundHandler = null;

    }
}
