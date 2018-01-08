package com.fts.untils;

import android.content.Context;
import android.content.SharedPreferences;

import com.fts.constants.Constants;
//import com.fts.models.Model_Fund_Bank_Acount;
//import com.fts.models.Model_Fund_Contact;
//import com.fts.models.Model_Profile_Investor;

/**
 * Created by vnGame on 12/30/16.
 */

public class SharedConfig {

    private Context context;
    private SharedPreferences shared;
    public static final String REMEMBER  = "REMEMBER";
    public static final String USER_ID = "USER_ID";
    public static final String NAME = "NAME";

    public SharedConfig(Context context) {
        this.context = context;
        shared = context.getSharedPreferences("CONFIG", Context.MODE_PRIVATE);
    }

    public SharedPreferences GetConfig() {
        return shared;
    }

    public void setValueBoolean(String key, boolean value) {
        SharedPreferences.Editor edit = shared.edit();
        edit.putBoolean(key, value);
        edit.commit();
    }

    public void setValueString(String key, String value) {
        SharedPreferences.Editor edit = shared.edit();
        edit.putString(key, value);
        edit.commit();
    }
    public Boolean getValueBoolean(String key){
       return shared.getBoolean(key,false);

    }

    public String getValueString(String key){
        return  shared.getString(key,"");
    }

    public void setValueInt(String key, int value) {
        SharedPreferences.Editor edit = shared.edit();
        edit.putInt(key, value);
        edit.commit();
    }
    public int getValueInt(String key){
        return  shared.getInt(key,0);
    }

//    public void setvalueFundacount(Model_Fund_Bank_Acount f_acount){
//        SharedPreferences.Editor edit = shared.edit();
//        edit.putString(Constants.BENEFICIARY_BANK, f_acount.getBENEFICIARY_BANK());
//        edit.putString(Constants.INTERMEDIATE_BANK, f_acount.getINTERMEDIATE_BANK());
//        edit.putString(Constants.BENEFICIARY_BANK_BIC, f_acount.getBENEFICIARY_BANK_BIC());
//        edit.putString(Constants.BENEFICIARY_ACCOUNT_NUMBER, f_acount.getBENEFICIARY_ACCOUNT_NUMBER());
//        edit.putString(Constants.BENEFICIARY_ACCOUNT_NAME, f_acount.getBENEFICIARY_ACCOUNT_NAME());
//
//        edit.commit();
//
//
//    }
//
//    public Model_Fund_Contact getvalueFundcontact(){
//        Model_Fund_Contact f_acount = new Model_Fund_Contact();
//        f_acount.setORGANIZATION_ID(shared.getString(Constants.ORGANIZATION_ID,""));
//        f_acount.setORGANIZATION_NAME(shared.getString(Constants.ORGANIZATION_NAME,""));
//        f_acount.setADDRESS(shared.getString(Constants.ADDRESS,""));
//        f_acount.setFUND_EMAIL_ENOVESTOR(shared.getString(Constants.FUND_EMAIL_ENOVESTOR,""));
//        f_acount.setFUND_FAX(shared.getString(Constants.FUND_FAX,""));
//        f_acount.setFUND_TEL(shared.getString(Constants.FUND_TEL,""));
//
//        return f_acount;
//    }
//
//    public void setvalueFundcontact(Model_Fund_Contact f_acount){
//        SharedPreferences.Editor edit = shared.edit();
//        edit.putString(Constants.ORGANIZATION_ID, f_acount.getORGANIZATION_ID());
//        edit.putString(Constants.ORGANIZATION_NAME, f_acount.getORGANIZATION_NAME());
//        edit.putString(Constants.ADDRESS, f_acount.getADDRESS());
//        edit.putString(Constants.FUND_EMAIL_ENOVESTOR, f_acount.getFUND_EMAIL_ENOVESTOR());
//        edit.putString(Constants.FUND_FAX, f_acount.getFUND_FAX());
//        edit.putString(Constants.FUND_TEL, f_acount.getFUND_TEL());
//
//        edit.commit();
//
//
//    }
//
//    public Model_Fund_Bank_Acount getvalueFundacount(){
//        Model_Fund_Bank_Acount f_acount = new Model_Fund_Bank_Acount();
//        f_acount.setBENEFICIARY_ACCOUNT_NAME(shared.getString(Constants.BENEFICIARY_ACCOUNT_NAME,""));
//        f_acount.setBENEFICIARY_ACCOUNT_NUMBER(shared.getString(Constants.BENEFICIARY_ACCOUNT_NUMBER,""));
//        f_acount.setBENEFICIARY_BANK(shared.getString(Constants.BENEFICIARY_BANK,""));
//        f_acount.setBENEFICIARY_BANK_BIC(shared.getString(Constants.BENEFICIARY_BANK_BIC,""));
//        f_acount.setINTERMEDIATE_BANK(shared.getString(Constants.INTERMEDIATE_BANK,""));
//
//        return f_acount;
//    }
//    public void setValueEmployee(Model_Employee model_profile_investor) {
//        SharedPreferences.Editor edit = shared.edit();
//        edit.putString(Constants.USER_ID, model_profile_investor.getUSER_ID());
//        edit.putString(Constants.USER_ID_WEB, model_profile_investor.getUSER_ID_WEB());
//        edit.putString(Constants.EMPLOYEE_ID, model_profile_investor.getEMPLOYEE_ID());
//        edit.putString(Constants.EMPLOYEE_NAME, model_profile_investor.getEMPLOYEE_NAME());
//        edit.putString(Constants.DOB, model_profile_investor.getDOB());
//        edit.putString(Constants.MOBILE_PHONE, model_profile_investor.getMOBILE_PHONE());
//        edit.putString(Constants.POSITION_ID, model_profile_investor.getPOSITION_ID());
//        edit.putString(Constants.PR_ORGANIZATION_ID, model_profile_investor.getPR_ORGANIZATION_ID());
//        edit.putString(Constants.POSITION_NAME, model_profile_investor.getPOSITION_NAME());
//        edit.putString(Constants.PR_ORGANIZATION_NAME, model_profile_investor.getPR_ORGANIZATION_NAME());
//
//        edit.putString(Constants.IMAGES, model_profile_investor.getIMAGES());
//
//        edit.putString(Constants.EMAIL, model_profile_investor.getEMAIL());
//
//
//
//        edit.commit();
//    }
//        public Model_Employee getValueEmployee(){
//            Model_Employee investor=new Model_Employee();
//            investor.setUSER_ID(shared.getString(Constants.USER_ID,""));
//            investor.setUSER_ID_WEB(shared.getString(Constants.USER_ID_WEB,""));
//            investor.setEMPLOYEE_ID(shared.getString(Constants.EMPLOYEE_ID,""));
//            investor.setEMPLOYEE_NAME(shared.getString(Constants.EMPLOYEE_NAME,""));
//            investor.setDOB(shared.getString(Constants.DOB,""));
//            investor.setMOBILE_PHONE(shared.getString(Constants.MOBILE_PHONE,""));
//            investor.setPOSITION_ID(shared.getString(Constants.POSITION_ID,""));
//            investor.setPR_ORGANIZATION_ID(shared.getString(Constants.PR_ORGANIZATION_ID,""));
//            investor.setPOSITION_NAME(shared.getString(Constants.POSITION_NAME,""));
//            investor.setPR_ORGANIZATION_NAME(shared.getString(Constants.PR_ORGANIZATION_NAME,""));
//
//            investor.setIMAGES(shared.getString(Constants.IMAGES,""));
//
//            investor.setEMAIL(shared.getString(Constants.EMAIL,""));
//
//
//
//        return  investor;
//        }
}
