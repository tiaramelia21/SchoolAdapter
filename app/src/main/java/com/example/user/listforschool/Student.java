package com.example.user.listforschool;

/**
 * Created by User on 23-Oct-16.
 */

public class Student {
    private int noS;
    private String noregS;
    private String namaS;
    private String emailS;
    private String telponS;

    public Student(int noS, String noregS, String namaS, String emailS, String telponS){
        this.setNoS(noS);
        this.setNoregS(noregS);
        this.setNamaS(namaS);
        this.setEmailS(emailS);
        this.setTelponS(telponS);
    }

    public int getNoS() {
        return noS;
    }

    public void setNoS(int noS) {
        this.noS = noS;
    }

    public String getNoregS() {
        return noregS;
    }

    public void setNoregS(String noregS) {
        this.noregS = noregS;
    }

    public String getNamaS() {
        return namaS;
    }

    public void setNamaS(String namaS) {
        this.namaS = namaS;
    }

    public String getEmailS() {
        return emailS;
    }

    public void setEmailS(String emailS) {
        this.emailS = emailS;
    }

    public String getTelponS() {
        return telponS;
    }

    public void setTelponS(String telponS) {
        this.telponS = telponS;
    }

}
