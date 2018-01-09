package com.fts.vnairline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PalletActivity extends BaseActivity {

    private EditText uldid_1,uldid_2,unloading,awbid,pieces,weight,shc, nature;
    private LinearLayout parent,left,right;
    private TextView toolbar_title;
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

        int width = (int) ((getResources().getDisplayMetrics().widthPixels)*0.60);
        left.setLayoutParams(new LinearLayout.LayoutParams(width, LinearLayout.LayoutParams.WRAP_CONTENT));
        int width_uldid =(int) ((getResources().getDisplayMetrics().widthPixels)*0.27);
        LinearLayout.LayoutParams la = new LinearLayout.LayoutParams(width_uldid, LinearLayout.LayoutParams.MATCH_PARENT);
        la.setMargins(10,0,0,0);
        uldid_1.setLayoutParams(la);
    }

}
