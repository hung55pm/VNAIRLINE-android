package com.fts.vnairline;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import static android.Manifest.permission.CAMERA;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class PalletActivity extends BaseActivity implements View.OnClickListener,ZXingScannerView.ResultHandler {

    private EditText uldid_1,uldid_2,unloading,awbid,pieces,weight,shc, nature;
    private LinearLayout parent,left,right;
    private Button bt_scanqr,bt_takephoto,bt_new,bt_save,bt_delete, bt_next, bt_pre,bt_finnish,bt_save_all,bt_exit;
    private ImageView picView;
    final int CAMERA_CAPTURE = 1;
    final int PIC_CROP = 2;
    private Uri picUri;
    private static final int REQUEST_CAMERA = 3;
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pallet);

        initview();
    }
    public void initview(){
        setuptoolbar(getResources().getString(R.string.title_pallet));
        uldid_1 =(EditText)findViewById(R.id.edit_ulid_1);
        uldid_2 =(EditText)findViewById(R.id.edit_ulid_2);
        unloading =(EditText)findViewById(R.id.edit_unloading);
        awbid =(EditText)findViewById(R.id.edit_awbid);
        pieces =(EditText)findViewById(R.id.edit_pieces);
        weight =(EditText)findViewById(R.id.edit_weight);
        shc =(EditText)findViewById(R.id.edit_shc);
        nature =(EditText)findViewById(R.id.edit_nature);

        parent =(LinearLayout)findViewById(R.id.layoutparent);
        left =(LinearLayout)findViewById(R.id.layout_left);
        right =(LinearLayout)findViewById(R.id.layout_right);

        bt_scanqr =(Button) findViewById(R.id.bt_scan_qr);
        bt_takephoto =(Button) findViewById(R.id.bt_take_photo);
        bt_new =(Button) findViewById(R.id.bt_news);
        bt_save =(Button) findViewById(R.id.bt_save_pr);
        bt_delete =(Button) findViewById(R.id.bt_delete);
        bt_next =(Button) findViewById(R.id.bt_next);
        bt_pre =(Button) findViewById(R.id.bt_precious);
        bt_finnish =(Button) findViewById(R.id.bt_finish_build_up);
        bt_save_all =(Button) findViewById(R.id.bt_save);
        bt_exit =(Button) findViewById(R.id.bt_exits);

        bt_scanqr.setOnClickListener(this);
        bt_takephoto.setOnClickListener(this);
        bt_new.setOnClickListener(this);
        bt_save.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
        bt_next.setOnClickListener(this);
        bt_pre.setOnClickListener(this);
        bt_finnish.setOnClickListener(this);
        bt_save_all.setOnClickListener(this);
        bt_exit.setOnClickListener(this);

        picView = (ImageView)findViewById(R.id.img);



        int width = (int) ((getResources().getDisplayMetrics().widthPixels)*0.60);
        left.setLayoutParams(new LinearLayout.LayoutParams(width, LinearLayout.LayoutParams.WRAP_CONTENT));
        int width_uldid =(int) ((getResources().getDisplayMetrics().widthPixels)*0.27);
        LinearLayout.LayoutParams la = new LinearLayout.LayoutParams(width_uldid, LinearLayout.LayoutParams.MATCH_PARENT);
        la.setMargins(10,0,0,0);
        uldid_1.setLayoutParams(la);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt_scan_qr) {
            openQRcode();
        }else if (view.getId() == R.id.bt_take_photo) {
            opencamera();
        }else if (view.getId() == R.id.bt_news) {

        }else if (view.getId() == R.id.bt_save_pr) {

        }else if (view.getId() == R.id.bt_delete) {

        }else if (view.getId() == R.id.bt_next) {

        }else if (view.getId() == R.id.bt_precious) {

        }else if (view.getId() == R.id.bt_finish_build_up) {

        }else if (view.getId() == R.id.bt_save) {

        }else if (view.getId() == R.id.bt_exits) {

        }
    }
    private void opencamera(){
        try {
            //use standard intent to capture an image
            Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //we will handle the returned data in onActivityResult
            startActivityForResult(captureIntent, CAMERA_CAPTURE);
        }catch(ActivityNotFoundException anfe){
            //display an error message
            String errorMessage = "Whoops - your device doesn't support capturing images!";
            Toast toast = Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if(requestCode == CAMERA_CAPTURE){
                picUri = data.getData();
                performCrop();
            }else if(requestCode == PIC_CROP){
                Bundle extras = data.getExtras();
                Bitmap thePic = extras.getParcelable("data");
                picView.setImageBitmap(thePic);
            }
        }
    }

    private void performCrop(){
        try {
            Intent cropIntent = new Intent("com.android.camera.action.CROP");
            //indicate image type and Uri
            cropIntent.setDataAndType(picUri, "image/*");
            //set crop properties
            cropIntent.putExtra("crop", "true");
            //indicate aspect of desired crop
            cropIntent.putExtra("aspectX", 1);
            cropIntent.putExtra("aspectY", 1);
            //indicate output X and Y
            cropIntent.putExtra("outputX", 256);
            cropIntent.putExtra("outputY", 256);
            //retrieve data on return
            cropIntent.putExtra("return-data", true);
            //start the activity - we handle returning in onActivityResult
            startActivityForResult(cropIntent, PIC_CROP);
        }
        catch(ActivityNotFoundException anfe){
            //display an error message
            String errorMessage = "Whoops - your device doesn't support the crop action!";
            Toast toast = Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    private void openQRcode(){
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= android.os.Build.VERSION_CODES.M) {
            if (checkPermission()) {
                Toast.makeText(getApplicationContext(), "Permission already granted", Toast.LENGTH_LONG).show();

            } else {
                requestPermission();
            }
        }
    }
    private boolean checkPermission() {
        return ( ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA ) == PackageManager.PERMISSION_GRANTED);
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, REQUEST_CAMERA);
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CAMERA:
                if (grantResults.length > 0) {

                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (cameraAccepted){
                        Toast.makeText(getApplicationContext(), "Permission Granted, Now you can access camera", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(), "Permission Denied, You cannot access and camera", Toast.LENGTH_LONG).show();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(CAMERA)) {
                                showMessageOKCancel("You need to allow access to both the permissions",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{CAMERA},
                                                            REQUEST_CAMERA);
                                                }
                                            }
                                        });
                                return;
                            }
                        }
                    }
                }
                break;
        }
    }
    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new android.support.v7.app.AlertDialog.Builder(PalletActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }
    @Override
    public void handleResult(Result rawResult) {
        final String result = rawResult.getText();
        Log.d("QRCodeScanner", rawResult.getText());
        Log.d("QRCodeScanner", rawResult.getBarcodeFormat().toString());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mScannerView.resumeCameraPreview(PalletActivity.this);
            }
        });
        builder.setNeutralButton("Visit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(result));
                startActivity(browserIntent);
            }
        });
        builder.setMessage(rawResult.getText());
        AlertDialog alert1 = builder.create();
        alert1.show();
    }

    @Override
    public void onResume() {
        super.onResume();

        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= android.os.Build.VERSION_CODES.M) {
            if (checkPermission()) {
                if(mScannerView == null) {
                    mScannerView = new ZXingScannerView(this);
                    setContentView(mScannerView);
                }
                mScannerView.setResultHandler(this);
                mScannerView.startCamera();
            } else {
                requestPermission();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mScannerView.stopCamera();
    }
}
