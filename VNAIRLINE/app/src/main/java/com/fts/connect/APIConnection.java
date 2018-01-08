package com.fts.connect;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.fts.constants.Constants;
import com.fts.untils.SharedConfig;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by HoangTien on 3/26/16.
 */
public class APIConnection {


    public static void requestlogin (Context context, final String username, final String pass, final StringRequestListener callback) throws JSONException {
        StringRequest jsonObjRequest = new StringRequest(Request.Method.POST, Constants.URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callback.onSuccess(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onError(error);

            }
        }) {

            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> pars = new HashMap<String, String>();
                pars.put(Constants.USERNAME,username);
                pars.put(Constants.PASSWORD,pass);
                //pars.put(Constants.GRANT_TYPE,"password");
                return pars;
            }
        };
        MySingleton.getInstance(context).addToRequestQueue(jsonObjRequest);
    }

//    public static void checkinout (final Context context, final Model_Maps map, final StringRequestListener callback) throws JSONException {
//
//        StringRequest jsonObjRequest = new StringRequest(Request.Method.POST, Constants.URL_CHECK_INOUT, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                callback.onSuccess(response);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                callback.onError(error);
//
//            }
//        }) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer "+new SharedConfig(context).getValueString(Constants.access_token));
//                return params;
//            }
//            @Override
//            public Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> pars = new HashMap<String, String>();
//
//                pars.put(Constants.EMPLOYEE_ID,new SharedConfig(context).getValueEmployee().getEMPLOYEE_ID());
//                pars.put(Constants.TIME_CHECK,map.getTime_check());
//                pars.put(Constants.DATE_CHECK,map.getDate_check());
//                pars.put(Constants.CHECK_TYPE,map.getCheck_type());
//                pars.put(Constants.IMAGES,map.getImage());
//                pars.put(Constants.MAP_X, String.valueOf(map.getLat()));
//                pars.put(Constants.MAP_Y, String.valueOf(map.getLng()));
//                pars.put(Constants.MAP_Z, "0");
//                pars.put(Constants.ADRRESS_MAP,map.getAddress());
//                Log.e("access",new SharedConfig(context).getValueString(Constants.access_token));
//                Log.e("req",pars.toString());
//
//                //pars.put(Constants.GRANT_TYPE,"password");
//                return pars;
//            }
//        };
//        MySingleton.getInstance(context).addToRequestQueue(jsonObjRequest);
//    }

//    public static void request(Context context, final String username,final String pass, final JSONObjectRequestListener callback) throws JSONException {
//
//        final JSONObject jsonBody = new JSONObject();
//        jsonBody.put(Constants.USERNAME,username);
//        jsonBody.put(Constants.PASSLOGIN,pass);
//        jsonBody.put(Constants.GRANT_TYPE,"password");
//
//        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST, Constants.URL_TOKEN, jsonBody, new Response.Listener<JSONObject>() {
//
//            @Override
//            public void onResponse(JSONObject response) {
//                callback.onSuccess(response);
//
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                callback.onError(error);
//            }
//        }) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Content-Type", "application/x-www-form-urlencoded");
//                params.put("charset", "utf-8");
//                return params;
//            }
//        };
//        MySingleton.getInstance(context).addToRequestQueue(jsObjRequest);
//    }
//    public static void getinfo(Context context, final String access_token, String investorid, final JSONObjectRequestListener callback) throws JSONException{
//        final JSONObject jsonBody = new JSONObject();
//        String url = Constants.URL_GET_PROFILE;
//        url = url.replace(Constants.INVESTORID, investorid);
//        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, jsonBody, new Response.Listener<JSONObject>() {
//
//            @Override
//            public void onResponse(JSONObject response) {
//                callback.onSuccess(response);
//                Log.e("res  ",response.toString());
//
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                callback.onError(error);
//            }
//        }) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer "+access_token);
//                return params;
//            }
//        };
//        MySingleton.getInstance(context).addToRequestQueue(jsObjRequest);
//    }
//    public static void getalltransaction(Context context,final String access_token, String investorid, String shareclassid,final JSONObjectRequestListener callback) throws JSONException{
//        final JSONObject jsonBody = new JSONObject();
//        String url = Constants.URL_GET_ALL_TRANSACTION;
//        url = url.replace(Constants.INVESTORID, investorid);
//        url = url.replace(Constants.SHARECLASSID, shareclassid);
//        Log.e("url", url);
//        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, jsonBody, new Response.Listener<JSONObject>() {
//
//            @Override
//            public void onResponse(JSONObject response) {
//                callback.onSuccess(response);
//                Log.e("res  ",response.toString());
//
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                callback.onError(error);
//            }
//        }) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer "+access_token);
//                return params;
//            }
//        };
//        MySingleton.getInstance(context).addToRequestQueue(jsObjRequest);
//    }
//    public static void getportfolio(Context context,final String access_token, String investorid, String date,final JSONObjectRequestListener callback) throws JSONException{
//        final JSONObject jsonBody = new JSONObject();
//        String url = Constants.URL_GET_PORTFOLIO;
//        url = url.replace(Constants.INVESTORID, investorid);
//        url = url.replace(Constants.DATE, date);
//
//        Log.e("url", url);
//        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, jsonBody, new Response.Listener<JSONObject>() {
//
//            @Override
//            public void onResponse(JSONObject response) {
//                callback.onSuccess(response);
//                Log.e("res  ",response.toString());
//
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                callback.onError(error);
//            }
//        }) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer "+access_token);
//                return params;
//            }
//        };
//        MySingleton.getInstance(context).addToRequestQueue(jsObjRequest);
//    }
//    public static void Logout (Context context,final String access_token, final JSONObjectRequestListener callback) throws JSONException {
//
//        final JSONObject jsonBody = new JSONObject();
//
//        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST, Constants.URL_LOGOUT, jsonBody, new Response.Listener<JSONObject>() {
//
//            @Override
//            public void onResponse(JSONObject response) {
//                callback.onSuccess(response);
//
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                callback.onError(error);
//            }
//        }) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Content-Type", "application/json");
//                params.put("charset", "utf-8");
//                params.put("Authorization", "access_token "+access_token);
//                return params;
//            }
//        };
//        MySingleton.getInstance(context).addToRequestQueue(jsObjRequest);
//    }
//    public static void Change_password (Context context,final String access_token, final String newpassword, final String oldpassword, final String ivestorid, final StringRequestListener callback) throws JSONException {
//        StringRequest jsonObjRequest = new StringRequest(Request.Method.PUT, Constants.URL_CHANGE_PASSWORD, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                callback.onSuccess(response);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                callback.onError(error);
//
//            }
//        }) {
//
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> pars = new HashMap<String, String>();
//                pars.put("Authorization", "Bearer "+access_token);
//                return pars;
//            }
//
//            @Override
//            public Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> pars = new HashMap<String, String>();
//                pars.put(Constants.USERID,ivestorid);
//                pars.put(Constants.CHANGE_OLD_PASSWORD,oldpassword);
//                pars.put(Constants.CHANGE_NEW_PASSWORD,newpassword);
//
//                Log.e("change", ivestorid+"   "+ oldpassword+"    "+newpassword);
//                // data truyen vao body them tai day
//                return pars;
//            }
//        };
//        MySingleton.getInstance(context).addToRequestQueue(jsonObjRequest);
//    }
//    public static void UpdateContact (Context context, final String maillingAddress, final String email,final String fax, final String tel, final String ivestorid, final StringRequestListener callback) throws JSONException {
//       final String access_token= new SharedConfig(context).getValueString(Constants.ACCESS_TOKEN);
//
//        StringRequest jsonObjRequest = new StringRequest(Request.Method.PUT, Constants.URL_UPDATE_CONTACT, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                callback.onSuccess(response);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                callback.onError(error);
//
//            }
//        }) {
//
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> pars = new HashMap<String, String>();
//                pars.put("Authorization", "Bearer "+access_token);
//                return pars;
//            }
//
//            @Override
//            public Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> pars = new HashMap<String, String>();
//                pars.put(Constants.investorId,ivestorid);
//                pars.put(Constants.UPDATE_EMAIL,email);
//                pars.put(Constants.UPDATE_FAX,fax);
//                pars.put(Constants.UPDATE_MAILLINGADRESS,maillingAddress);
//                pars.put(Constants.UPDATE_TEL,tel);
//
//                Log.e("pram",pars.toString());
//
//                // data truyen vao body them tai day
//                return pars;
//            }
//        };
//        MySingleton.getInstance(context).addToRequestQueue(jsonObjRequest);
//    }
//    public static void GetSucription(Context context,final String access_token, String investorid, String start, String end, final JSONArrayRequestListener callback) throws JSONException {
//        String url = Constants.URL_GET_SUBCRIPTION;
//        url = url.replace(Constants.INVESTORID, investorid);
//        url = url.replace(Constants.STARTDATE,start );
//        url = url.replace(Constants.ENDDATE, end);
//        Log.d("HungDN", "URL: " + url);
//        JsonArrayRequest searchMsg= new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//
//            @Override
//            public void onResponse(JSONArray response) {
//                callback.onResponse(response);
//                Log.d("HungDN", response.toString());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                callback.onError(error);
//                VolleyLog.d("HungDN", "Error: " + error.getMessage());
//
//            }
//        }){
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer "+access_token);
//                return params;
//            }
//        };
//
//
//        MySingleton.getInstance(context).addToRequestQueue(searchMsg);
//    }
//    public static void GetSucriptionOrder(Context context,final String access_token, String investorid, String start, String end, final JSONArrayRequestListener callback) throws JSONException {
//        String url = Constants.URL_GET_SUBCRIPTION_ORDER;
//        url = url.replace(Constants.INVESTORID, investorid);
//        url = url.replace(Constants.STARTDATE,start );
//        url = url.replace(Constants.ENDDATE, end);
//        Log.d("HungDN", "URL: " + url);
//        JsonArrayRequest searchMsg= new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//
//            @Override
//            public void onResponse(JSONArray response) {
//                callback.onResponse(response);
//                Log.d("HungDN", response.toString());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                callback.onError(error);
//                VolleyLog.d("HungDN", "Error: " + error.getMessage());
//
//            }
//        }){
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer "+access_token);
//                return params;
//            }
//        };
//
//
//        MySingleton.getInstance(context).addToRequestQueue(searchMsg);
//    }
//    public static void GetSucriptionCash(Context context,final String access_token, String investorid, String start, String end, final JSONArrayRequestListener callback) throws JSONException {
//        String url = Constants.URL_GET_SUBCRIPTION_CASH;
//        url = url.replace(Constants.INVESTORID, investorid);
//        url = url.replace(Constants.STARTDATE,start );
//        url = url.replace(Constants.ENDDATE, end);
//        Log.d("HungDN", "URL: " + url);
//        JsonArrayRequest searchMsg= new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//
//            @Override
//            public void onResponse(JSONArray response) {
//                callback.onResponse(response);
//                Log.d("HungDN", response.toString());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                callback.onError(error);
//                VolleyLog.d("HungDN", "Error: " + error.getMessage());
//
//            }
//        }){
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer "+access_token);
//                return params;
//            }
//        };
//
//
//        MySingleton.getInstance(context).addToRequestQueue(searchMsg);
//    }
//    public static void GetRedemption(Context context,final String access_token, String investorid, String start, String end, final JSONArrayRequestListener callback) throws JSONException {
//        String url = Constants.URL_GET_REDEMPTION;
//        url = url.replace(Constants.INVESTORID, investorid);
//        url = url.replace(Constants.STARTDATE,start );
//        url = url.replace(Constants.ENDDATE, end);
//        Log.d("HungDN", "URL: " + url);
//        JsonArrayRequest searchMsg= new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//
//            @Override
//            public void onResponse(JSONArray response) {
//                callback.onResponse(response);
//                Log.d("HungDN", response.toString());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                callback.onError(error);
//                VolleyLog.d("HungDN", "Error: " + error.getMessage());
//
//            }
//        }){
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer "+access_token);
//                return params;
//            }
//        };
//        MySingleton.getInstance(context).addToRequestQueue(searchMsg);
//    }
//
//    public static void GetRedemptionCash(Context context,final String access_token, String investorid, String start, String end, final JSONArrayRequestListener callback) throws JSONException {
//        String url = Constants.URL_GET_REDEMPTION_CASH;
//        url = url.replace(Constants.INVESTORID, investorid);
//        url = url.replace(Constants.STARTDATE,start );
//        url = url.replace(Constants.ENDDATE, end);
//        Log.d("HungDN", "URL: " + url);
//        JsonArrayRequest searchMsg= new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//
//            @Override
//            public void onResponse(JSONArray response) {
//                callback.onResponse(response);
//                Log.d("HungDN", response.toString());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                callback.onError(error);
//                VolleyLog.d("HungDN", "Error: " + error.getMessage());
//
//            }
//        }){
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer "+access_token);
//                return params;
//            }
//        };
//        MySingleton.getInstance(context).addToRequestQueue(searchMsg);
//    }
//    public static void GetRedemptionOrder(Context context,final String access_token, String investorid, String start, String end, final JSONArrayRequestListener callback) throws JSONException {
//        String url = Constants.URL_GET_REDEMPTION_ORDER;
//        url = url.replace(Constants.INVESTORID, investorid);
//        url = url.replace(Constants.STARTDATE,start );
//        url = url.replace(Constants.ENDDATE, end);
//        Log.d("HungDN", "URL: " + url);
//        JsonArrayRequest searchMsg= new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//
//            @Override
//            public void onResponse(JSONArray response) {
//                callback.onResponse(response);
//                Log.d("HungDN", response.toString());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                callback.onError(error);
//                VolleyLog.d("HungDN", "Error: " + error.getMessage());
//
//            }
//        }){
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Authorization", "Bearer "+access_token);
//                return params;
//            }
//        };
//        MySingleton.getInstance(context).addToRequestQueue(searchMsg);
//    }

}
