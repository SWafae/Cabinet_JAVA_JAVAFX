package com.example.demo3;

public class Seance {

    public int idMed;

    public int idSea;
    public String salle;
    public String materiel;
    public String description;

    public Seance() {
        super();
    }

    public Seance( int idMed, String salle, String matereil, String description) {
        super();
        this.idMed = idMed;
        this.salle = salle;
        this.materiel = matereil;
        this.description = description;
    }
    public int getIdSea() {
        return idSea;
    }

    public void setIdSea(int id) {
        idSea = id;
    }
    public int getIdMed() {
        return idMed;
    }

    public void setIdMed(int num) {
        idMed = num;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String nom) {
        salle = nom;
    }

    public String getMateriel() {
        return materiel;
    }

    public void setMateriel(String mat) {
        materiel = mat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        description = desc;
    }








}
