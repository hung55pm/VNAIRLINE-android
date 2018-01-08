package com.fts.connect;

import com.android.volley.VolleyError;

import org.json.JSONObject;


public interface JSONObjectRequestListener {
    public void onSuccess(JSONObject response);

    public void onError(VolleyError error);
}
