package com.fts.models;

/**
 * Created by hungdn on 1/9/18.
 */

public class Model_flight {
    private String FLIGHTNO;
    private String FLIGHTDATE;
    private String FLITIME;
    private String DEST;
    private String STATUS;
    private String ATD;

    public String getFLIGHTNO() {
        return FLIGHTNO;
    }

    public void setFLIGHTNO(String FLIGHTNO) {
        this.FLIGHTNO = FLIGHTNO;
    }

    public String getFLIGHTDATE() {
        return FLIGHTDATE;
    }

    public void setFLIGHTDATE(String FLIGHTDATE) {
        this.FLIGHTDATE = FLIGHTDATE;
    }

    public String getFLITIME() {
        return FLITIME;
    }

    public void setFLITIME(String FLITIME) {
        this.FLITIME = FLITIME;
    }

    public String getDEST() {
        return DEST;
    }

    public void setDEST(String DEST) {
        this.DEST = DEST;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getATD() {
        return ATD;
    }

    public void setATD(String ATD) {
        this.ATD = ATD;
    }
}
