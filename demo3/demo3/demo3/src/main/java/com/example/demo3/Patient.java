package com.example.demo3;

public class Patient {

    private int idPat;
    private String nom;
    private String prenom;
    private int age;
    private String numTel;
    private String adress;
    private String maladie;
    private String email;

    public Patient(){};

    public Patient(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        //this.numTel = numTel;
        //this.adress = adress;
        //this.maladie = maladie;
    }

    public int getIdPat() {
        return idPat;
    }

    public void setIdPat(int idPat) {
        this.idPat = idPat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getMaladie() {
        return maladie;
    }

    public void setMaladie(String maladie) {
        this.maladie = maladie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
