package com.fts.models;

/**
 * Created by hungdn on 1/9/18.
 */

public class Model_Commodity {

    private String AWBID;
    private String CLASS;
    private String R_PIECES;
    private String T_PIECES;
    private String R_WEIGHT;
    private String T_WEIGHT;
    private String NATURE;
    private String ROUTER;

    public String getAWBID() {
        return AWBID;
    }

    public void setAWBID(String AWBID) {
        this.AWBID = AWBID;
    }

    public String getCLASS() {
        return CLASS;
    }

    public void setCLASS(String CLASS) {
        this.CLASS = CLASS;
    }

    public String getR_PIECES() {
        return R_PIECES;
    }

    public void setR_PIECES(String r_PIECES) {
        R_PIECES = r_PIECES;
    }

    public String getT_PIECES() {
        return T_PIECES;
    }

    public void setT_PIECES(String t_PIECES) {
        T_PIECES = t_PIECES;
    }

    public String getR_WEIGHT() {
        return R_WEIGHT;
    }

    public void setR_WEIGHT(String r_WEIGHT) {
        R_WEIGHT = r_WEIGHT;
    }

    public String getT_WEIGHT() {
        return T_WEIGHT;
    }

    public void setT_WEIGHT(String t_WEIGHT) {
        T_WEIGHT = t_WEIGHT;
    }

    public String getNATURE() {
        return NATURE;
    }

    public void setNATURE(String NATURE) {
        this.NATURE = NATURE;
    }

    public String getROUTER() {
        return ROUTER;
    }

    public void setROUTER(String ROUTER) {
        this.ROUTER = ROUTER;
    }
}
