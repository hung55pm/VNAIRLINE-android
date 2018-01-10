package com.fts.vnairline;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.File;
import java.util.UUID;


public class PalletActivity extends BaseActivity implements View.OnClickListener {

    private EditText uldid_1, uldid_2, unloading, awbid, pieces, weight, shc, nature, contour, w_ver, w_hor, mate;
    private LinearLayout parent, left, right, layout_listview;
    private Button bt_scanqr, bt_takephoto, bt_new, bt_save, bt_delete, bt_next, bt_pre, bt_finnish, bt_save_all, bt_exit;
    private ImageView picView;
    final int CAMERA_CAPTURE = 1;
    final int PIC_CROP = 2;
    private Uri picUri;
    private static final int REQUEST_CAMERA = 3;
    //    private ZXingScannerView mScannerView;
    public static File mTempCameraPhotoFile;
    private ListView lv;
    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pallet);
        initview();
    }

    public void initview() {
        setuptoolbar(getResources().getString(R.string.title_pallet));
        qrScan = new IntentIntegrator(this);
        qrScan.setBeepEnabled(false);
        qrScan.setOrientationLocked(true);
        uldid_1 = (EditText) findViewById(R.id.edit_ulid_1);
        uldid_2 = (EditText) findViewById(R.id.edit_ulid_2);
        unloading = (EditText) findViewById(R.id.edit_unloading);
        awbid = (EditText) findViewById(R.id.edit_awbid);
        pieces = (EditText) findViewById(R.id.edit_pieces);
        weight = (EditText) findViewById(R.id.edit_weight);
        shc = (EditText) findViewById(R.id.edit_shc);
        nature = (EditText) findViewById(R.id.edit_nature);

        contour = (EditText) findViewById(R.id.edit_contour);
        w_ver = (EditText) findViewById(R.id.edit_w_vertical);
        w_hor = (EditText) findViewById(R.id.edit_w_horizontal);
        mate = (EditText) findViewById(R.id.edit_materail);

        lv = (ListView) findViewById(R.id.litsview_pallet);

        layout_listview = (LinearLayout) findViewById(R.id.layout_listview);
        parent = (LinearLayout) findViewById(R.id.layoutparent);
        left = (LinearLayout) findViewById(R.id.layout_left);
        right = (LinearLayout) findViewById(R.id.layout_right);

        bt_scanqr = (Button) findViewById(R.id.bt_scan_qr);
        bt_takephoto = (Button) findViewById(R.id.bt_take_photo);
        bt_new = (Button) findViewById(R.id.bt_news);
        bt_save = (Button) findViewById(R.id.bt_save_pr);
        bt_delete = (Button) findViewById(R.id.bt_delete);
        bt_next = (Button) findViewById(R.id.bt_next);
        bt_pre = (Button) findViewById(R.id.bt_precious);
        bt_finnish = (Button) findViewById(R.id.bt_finish_build_up);
        bt_save_all = (Button) findViewById(R.id.bt_save);
        bt_exit = (Button) findViewById(R.id.bt_exits);

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

        picView = (ImageView) findViewById(R.id.img);

        if ((getResources().getDisplayMetrics().widthPixels) <= 730) {
            int width = (int) ((getResources().getDisplayMetrics().widthPixels) * 0.55);
            Log.e("log width", (getResources().getDisplayMetrics().widthPixels) + "");
            left.setLayoutParams(new LinearLayout.LayoutParams(width, LinearLayout.LayoutParams.WRAP_CONTENT));
            int width_uldid = (int) ((getResources().getDisplayMetrics().widthPixels) * 0.2);
            LinearLayout.LayoutParams la = new LinearLayout.LayoutParams(width_uldid, LinearLayout.LayoutParams.MATCH_PARENT);
            la.setMargins(5, 0, 0, 0);
            uldid_1.setLayoutParams(la);
            LinearLayout.LayoutParams la_list = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 180);
            layout_listview.setLayoutParams(la_list);
            LinearLayout.LayoutParams la_bt3 = new LinearLayout.LayoutParams(100, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams la_bt4 = new LinearLayout.LayoutParams(120, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout.LayoutParams la_edit = new LinearLayout.LayoutParams(120, LinearLayout.LayoutParams.MATCH_PARENT);
            contour.setLayoutParams(la_edit);
            w_ver.setLayoutParams(la_edit);
            w_hor.setLayoutParams(la_edit);
            bt_new.setLayoutParams(la_bt3);
            bt_save.setLayoutParams(la_bt4);
            bt_pre.setLayoutParams(la_bt4);
            bt_next.setLayoutParams(la_bt4);
            bt_scanqr.setLayoutParams(la_bt4);
        } else {
            int width = (int) ((getResources().getDisplayMetrics().widthPixels) * 0.60);
            Log.e("log width", (getResources().getDisplayMetrics().widthPixels) + "");
            left.setLayoutParams(new LinearLayout.LayoutParams(width, LinearLayout.LayoutParams.WRAP_CONTENT));
            int width_uldid = (int) ((getResources().getDisplayMetrics().widthPixels) * 0.27);
            LinearLayout.LayoutParams la = new LinearLayout.LayoutParams(width_uldid, LinearLayout.LayoutParams.MATCH_PARENT);
            la.setMargins(10, 0, 0, 0);
            uldid_1.setLayoutParams(la);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt_scan_qr) {
            qrScan.initiateScan();
        } else if (view.getId() == R.id.bt_take_photo) {
            takeFromCamera();
        } else if (view.getId() == R.id.bt_news) {

        } else if (view.getId() == R.id.bt_save_pr) {

        } else if (view.getId() == R.id.bt_delete) {

        } else if (view.getId() == R.id.bt_next) {

        } else if (view.getId() == R.id.bt_precious) {

        } else if (view.getId() == R.id.bt_finish_build_up) {

        } else if (view.getId() == R.id.bt_save) {

        } else if (view.getId() == R.id.bt_exits) {

        }
    }

    public File savefile() {
        File exportDir = new File(Environment.getExternalStorageDirectory(), "TempFolder");
        if (!exportDir.exists()) {
            exportDir.mkdirs();
        } else {
            exportDir.delete();
        }
        File file = new File(exportDir, "/" + UUID.randomUUID().toString().replaceAll("-", "") + ".jpg");
        Log.d("LOG_TAG", "/" + UUID.randomUUID().toString().replaceAll("-", "") + ".jpg");
        return file;
    }

    private void takeFromCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(this.getPackageManager()) != null) {

            mTempCameraPhotoFile = savefile();
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mTempCameraPhotoFile));
            startActivityForResult(takePictureIntent, CAMERA_CAPTURE);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CAMERA_CAPTURE) {
            if (resultCode != Activity.RESULT_CANCELED) {
                picUri = Uri.fromFile(mTempCameraPhotoFile);
                Log.e("uri", picUri.toString());
                performCrop(mTempCameraPhotoFile);
            }
        } else if (requestCode == PIC_CROP) {
            if (resultCode != Activity.RESULT_CANCELED) {
                Log.e("data", data.toString());
                Bundle extras = data.getExtras();
                Bitmap thePic = extras.getParcelable("data");
                picView.setImageBitmap(thePic);
            }
        }

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                Log.e("QR code", result.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    private void performCrop(File file) {


        try {
            Intent intent = new Intent("com.android.camera.action.CROP");
//            List<ResolveInfo> list = this.getPackageManager().queryIntentActivities(intent, 0);
//            int size = list.size();
//            if (size == 0) {
//                Toast.makeText(this, "Can not find image crop app", Toast.LENGTH_SHORT).show();
//            } else {
            Uri photoURI;
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                photoURI = FileProvider.getUriForFile(this, "com.fts.vnairline.provider", file);
                this.grantUriPermission("com.android.camera", photoURI,
                        Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            } else {
                photoURI = Uri.fromFile(file);
            }
            intent.setDataAndType(photoURI, "image/*");
//                ResolveInfo res = list.get(0);
//                Intent cropIntent = new Intent();
//                cropIntent.setClassName(res.activityInfo.packageName, res.activityInfo.name);
            intent.putExtra("crop", "true");
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("outputX", 200);
            intent.putExtra("outputY", 200);
            intent.putExtra("return-data", true);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);

            startActivityForResult(intent, PIC_CROP);
            //}
        } catch (ActivityNotFoundException anfe) {
            //display an error message
            String errorMessage = "Whoops - your device doesn't support the crop action!";
            Toast toast = Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT);
            toast.show();
        }

    }


}
