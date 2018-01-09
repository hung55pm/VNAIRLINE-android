package com.fts.vnairline;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.fts.connect.APIConnection;
import com.fts.connect.StringRequestListener;
import com.fts.constants.Constants;
import com.fts.untils.SharedConfig;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends Activity {
    private EditText ed_user, ed_pass;
    private Button btlogin;
    private TextView txtneed;
    private ProgressDialog progress;
    private Switch remmeber;
    private Boolean check = false;
    int PERMISSION_ALL = 1;
    LocationManager locationManager;
    int RESQUETSCODE_GPS = 99;
    String[] PERMISSIONS = {android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.CAMERA, android.Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (!isNetworkConnected()) {
            confirmInternetFailDialog();
        }
        innit();
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress = new ProgressDialog(LoginActivity.this);
                progress.setMessage(getResources().getString(R.string.loging));
                progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progress.setIndeterminate(true);
                progress.show();
                Intent in = new Intent(LoginActivity.this, PalletActivity.class);
                startActivity(in);
              //  login(ed_user.getText().toString(),ed_pass.getText().toString());

            }
        });
        remmeber.setChecked(new SharedConfig(LoginActivity.this).getValueBoolean(SharedConfig.REMEMBER));
        remmeber.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                new SharedConfig(getBaseContext()).setValueBoolean(SharedConfig.REMEMBER, b);

            }
        });
        if (new SharedConfig(LoginActivity.this).getValueBoolean(SharedConfig.REMEMBER) == true) {
            ed_user.setText(new SharedConfig(LoginActivity.this).getValueString(Constants.USERNAME));
            ed_pass.setText(new SharedConfig(LoginActivity.this).getValueString(Constants.PASSWORD));
        }
    }

    public void innit() {
        btlogin = (Button) findViewById(R.id.bt_login);
        ed_user = (EditText) findViewById(R.id.ed_user);
        ed_pass = (EditText) findViewById(R.id.ed_pass);
        remmeber = (Switch) findViewById(R.id.switch1);


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    private void confirmInternetFailDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.not_connect_internet))
                .setCancelable(false)
                .setPositiveButton(getResources().getString(R.string.try_again), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (!isNetworkConnected()) {
                            confirmInternetFailDialog();
                        }
                    }
                })
                .setNegativeButton(getResources().getString(R.string.exits), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        finish();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    public void showToast(String msg){
        Toast.makeText(LoginActivity.this,msg,Toast.LENGTH_SHORT).show();

    }


//    public void login(final String user, final String pass){
//        try {
//            APIConnection.requestlogin(LoginActivity.this, user, pass, new StringRequestListener() {
//                @Override
//                public void onSuccess(String response) {
//                    Log.e("login result",response);
//                    try {
//                        JSONObject jsonObj = new JSONObject(response);
//                        Log.e("access_token",jsonObj.getString(Constants.access_token));
//                        String acctoken = jsonObj.getString(Constants.access_token);
//                        if(acctoken.equals("")|| acctoken==null){
//                            Toast.makeText(LoginActivity.this,getResources().getString(R.string.login_fail), Toast.LENGTH_SHORT).show();
//                        }else {
//                            new SharedConfig(LoginActivity.this).setValueString(Constants.USERNAME, user);
//                            new SharedConfig(LoginActivity.this).setValueString(Constants.PASSWORD,pass);
//                            new SharedConfig(LoginActivity.this).setValueString(Constants.access_token,acctoken);
//                            Model_Employee employee = new Model_Employee();
//                            employee.setUSER_ID(jsonObj.getString(Constants.USER_ID));
//                            employee.setUSER_ID_WEB(jsonObj.getString(Constants.USER_ID_WEB));
//                            employee.setEMPLOYEE_ID(jsonObj.getString(Constants.EMPLOYEE_ID));
//                            employee.setEMPLOYEE_NAME(jsonObj.getString(Constants.EMPLOYEE_NAME));
//                            employee.setDOB(jsonObj.getString(Constants.DOB));
//                            employee.setPOSITION_ID(jsonObj.getString(Constants.POSITION_ID));
//                            employee.setPR_ORGANIZATION_ID(jsonObj.getString(Constants.PR_ORGANIZATION_ID));
//                            employee.setPOSITION_NAME(jsonObj.getString(Constants.POSITION_NAME));
//                            employee.setPR_ORGANIZATION_NAME(jsonObj.getString(Constants.PR_ORGANIZATION_NAME));
//                            employee.setMOBILE_PHONE(jsonObj.getString(Constants.MOBILE_PHONE));
//
//                            employee.setIMAGES(jsonObj.getString(Constants.IMAGES));
//                            employee.setEMAIL(jsonObj.getString(Constants.EMAIL));
//
//                            new SharedConfig(LoginActivity.this).setValueEmployee(employee);
//                            Intent in = new Intent(LoginActivity.this, MainActivity.class);
//                            startActivity(in);
//                            finish();
//                            progress.dismiss();
//
//                        }
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                        progress.dismiss();
//                        Toast.makeText(LoginActivity.this,getResources().getString(R.string.login_fail), Toast.LENGTH_SHORT).show();
//                    }
//
//                }
//
//                @Override
//                public void onError(VolleyError error) {
//                    progress.dismiss();
//                    Toast.makeText(LoginActivity.this,getResources().getString(R.string.login_fail), Toast.LENGTH_SHORT).show();
//
//                }
//            });
//        } catch (JSONException e) {
//            e.printStackTrace();
//            progress.dismiss();
//            Toast.makeText(LoginActivity.this,getResources().getString(R.string.login_fail), Toast.LENGTH_SHORT).show();
//        }
//    }

}
