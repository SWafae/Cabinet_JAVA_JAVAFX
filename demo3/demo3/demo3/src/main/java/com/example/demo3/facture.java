package com.example.demo3;

public class facture {
    private int idFac;
    private int idSea;
    private String suivi;

    public facture() {
        super();
    }

    public facture(int idFac, int idSea, String suivi) {
        super();
        this.idFac = idFac;
        this.idSea = idSea;
        this.suivi = suivi;
    }

    public int getIdFac() {
        return idFac;
    }

    public void setIdFac(int idFac) {
        this.idFac = idFac;
    }

    public int getIdSea() {
        return idSea;
    }

    public void setIdSea(int idSea) {
        this.idSea = idSea;
    }

    public String getSuivi() {
        return suivi;
    }

    public void setSuivi(String suivi) {
        this.suivi = suivi;
    }
}
