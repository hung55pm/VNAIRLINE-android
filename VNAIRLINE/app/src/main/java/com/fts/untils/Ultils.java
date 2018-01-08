package com.fts.untils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

//import com.fts.models.Model_total;

/**
 * Created by hungdn on 9/9/2017.
 */

public class Ultils {
    public static String PricefromString(String number, int decima_fomat){
        double amount = Double.parseDouble(number);

        if(amount == 0){
            String a = "0.";
            for(int i=0;i<decima_fomat;i++){
                a=a+"0";
            }
            return a;
        }
        String fomat = "#,###.";
        for(int i=0;i<decima_fomat;i++){
            fomat=fomat+"0";
        }
        DecimalFormat formatter = new DecimalFormat(fomat);
        return formatter.format(amount);
    }
    public static Bitmap rotateImage(Bitmap img, int degree) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        Bitmap rotatedImg = Bitmap.createBitmap(img, 0, 0, img.getWidth(), img.getHeight(), matrix, true);
        return rotatedImg;
    }
    public static String convertToBase64(String imagePath)

    {
        int width;
        int height;
        ExifInterface ei = null;
        Bitmap bm = BitmapFactory.decodeFile(imagePath);
        try {
            ei = new ExifInterface(imagePath);
            int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            Log.e("orientation: %s", ""+orientation);

            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    bm = rotateImage(bm, 90);
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    bm = rotateImage(bm, 180);
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    bm = rotateImage(bm, 270);
                    break;
                default:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }




        if(bm.getWidth()>=768){
            width =768;
            height = (bm.getHeight() * 768)/(bm.getWidth());
        }else {
            width = bm.getWidth();
            height = bm.getHeight();
        }
        Bitmap bitmap = Bitmap.createScaledBitmap(bm,width,height,true);

        Log.e("width",""+width + "   "+height);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        bitmap.compress(Bitmap.CompressFormat.PNG, 0, baos);

        byte[] byteArrayImage = baos.toByteArray();

        String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);

        return encodedImage;

    }

    public static Bitmap decodeFromBase64ToBitmap(String encodedImage)

    {

        byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);

        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        return decodedByte;

    }

//    public static void addview(Context mContext, ArrayList<Model_total> data, LinearLayout layout){
//
//
//            for (int i =0;i<data.size(); i++){
//
//            }
//
//        for (int i=0;i<data.size();i++){
//            LinearLayout layout1 = new LinearLayout(mContext);
//
//
//            TextView txt_total = new TextView(mContext);
//            txt_total.setId(i);
//            LinearLayout.LayoutParams param_total = new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.WRAP_CONTENT,
//                    LinearLayout.LayoutParams.MATCH_PARENT,
//                    1.0f
//            );
//            param_total.setMargins(30,0,0,0);
//            txt_total.setLayoutParams(param_total);
//            txt_total.setGravity(Gravity.CENTER_VERTICAL);
//            txt_total.setTextSize(16);
//            txt_total.setTextColor(Color.WHITE);
//
//
//            TextView txt_value = new TextView(mContext);
//            txt_value.setId(i);
//            LinearLayout.LayoutParams param_value = new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.WRAP_CONTENT,
//                    LinearLayout.LayoutParams.MATCH_PARENT
//            );
//            param_value.setMargins(0,0,20,0);
//            txt_value.setLayoutParams(param_value);
//            txt_value.setGravity(Gravity.CENTER_VERTICAL);
//            txt_value.setTextSize(16);
//            txt_value.setTextColor(Color.WHITE);
//
//
//
//            layout1.setOrientation(LinearLayout.HORIZONTAL);
//            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.MATCH_PARENT, 130
//            );
//
//            layout1.addView(txt_total);
//            layout1.addView(txt_value);
//            layout1.setLayoutParams(param);
//            layout.addView(layout1);
//            layout.setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimary));
//
//            txt_total.setText(mContext.getResources().getString(R.string.total));
//            txt_value.setText(data.get(i).getCurent_display()+" "+PricefromString(""+data.get(i).getTotal(),2));
//        }
//    }


}
