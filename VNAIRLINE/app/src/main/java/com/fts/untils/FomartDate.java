package com.fts.untils;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;

import com.fts.vnairline.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by MR_HUNG on 7/31/2017.
 */

public class FomartDate {

    public static String formartdatelocalEN(String strdate ){
        Date date= new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        SimpleDateFormat dateFormatEN = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH);

        try {
            date=dateFormat.parse(strdate);
            Log.i("format",""+date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormatEN.format(date);

    }

    public static String formartyyyy_mm_ddtoddmmyyy(String strdate ){
        Date date= new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormatVI = new SimpleDateFormat("dd/MM/yy");

        try {
            date=dateFormat.parse(strdate);
            Log.i("format",""+date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormatVI.format(date);

    }
    public static String formatdateyyyy_mm_ddtomm_dd_yyyy(String strdate){
        Date date= new Date();

        SimpleDateFormat dateFormatEN = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        try {
            date=dateFormatEN.parse(strdate);
            Log.i("format",""+date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat.format(date);
    }
    public static DatePickerDialog setdateEdittext(Context mContext, final EditText ed){
        Calendar mcurrentDate;
        int mDay, mMonth, mYear;
        mcurrentDate = Calendar.getInstance();
        mYear = mcurrentDate.get(Calendar.YEAR);
        mMonth = mcurrentDate.get(Calendar.MONTH);
        mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

        final DatePickerDialog mDatePicker = new DatePickerDialog(mContext, android.R.style.Theme_Holo_Light_Dialog, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                // TODO Auto-generated method stub
                    /*      Your code   to get date and time    */
                String date = selectedday + "-" + (selectedmonth+1)+ "-" + selectedyear;
                String result = FomartDate.formartdatelocalEN(date);
                ed.setText(result);
            }

        }, mYear, mMonth, mDay);
        mDatePicker.getDatePicker().setMaxDate(new Date().getTime());
        mDatePicker.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDatePicker.setButton(DialogInterface.BUTTON_NEGATIVE,mContext.getResources().getString(R.string.cancel),(DialogInterface.OnClickListener)null);
        mDatePicker.setButton(DialogInterface.BUTTON_POSITIVE,mContext.getResources().getString(R.string.done), mDatePicker);
        return mDatePicker;

    }
    public static String getfirtdateofmounth(){
        Calendar date = Calendar.getInstance();
        date.set(Calendar.DAY_OF_MONTH, 1);

        SimpleDateFormat dateFormatEN = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return dateFormatEN.format(date.getTime());
    }

    public static String getdatenow(){
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return  dtf.format(date);
    }
}
