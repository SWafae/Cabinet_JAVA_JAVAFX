package com.example.demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Medecin {
    private int idMed;
    private String nom;
    private String prenom;
    private String email;
    private String adress;
    private String numTel;
    private String specialite;
    private int tarif;
    //public java.util.Collection<PatientApplication> patient;
    //public java.util.Collection<KineApplication> kinesitherapeute;
    //public java.util.Collection<Seance> seance;


    public Medecin(){};
    public Medecin( String nom, String prenom,  String email,  String specialite,int tarif) {
        //this.idMed = idMed;
        this.nom = nom;
        this.prenom = prenom;
       // this.numTel = numTel;
        this.email = email;
        //this.adress = adress;
        this.specialite=specialite;
        this.tarif=tarif;
    }

  /*  public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Patient.class.getResource("Med.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
*/



    /*public java.util.Collection<Patient> getPatient() {
        if (patient == null)
            patient = new java.util.HashSet<Patient>();
        return patient;
    }

    // default iterator getter
    public java.util.Iterator getIteratorPatient() {
        if (patient == null)
            patient = new java.util.HashSet<Patient>();
        return patient.iterator();
    }

    //default setter newPatient
    public void setPatient(java.util.Collection<Patient> newPatient) {
        removeAllPatient();
        for (java.util.Iterator iter = newPatient.iterator(); iter.hasNext();)
            addPatient((Patient)iter.next());
    }

    // default add newPatient
    public void addPatient(Patient newPatient) {
        if (newPatient == null)
            return;
        if (this.patient == null)
            this.patient = new java.util.HashSet<Patient>();
        if (!this.patient.contains(newPatient))
            this.patient.add(newPatient);
    }

    // default remove oldPatient
    public void removePatient(Patient oldPatient) {
        if (oldPatient == null)
            return;
        if (this.patient != null)
            if (this.patient.contains(oldPatient))
                this.patient.remove(oldPatient);
    }

    // default removeAll
    public void removeAllPatient() {
        if (patient != null)
            patient.clear();
    }
    // default getter
    public java.util.Collection<Kinesitherapeute> getKinesitherapeute() {
        if (kinesitherapeute == null)
            kinesitherapeute = new java.util.HashSet<Kinesitherapeute>();
        return kinesitherapeute;
    }

    // default iterator getter
    public java.util.Iterator getIteratorKinesitherapeute() {
        if (kinesitherapeute == null)
            kinesitherapeute = new java.util.HashSet<Kinesitherapeute>();
        return kinesitherapeute.iterator();
    }

    // default setter newKinesitherapeute
    public void setKinesitherapeute(java.util.Collection<Kinesitherapeute> newKinesitherapeute) {
        removeAllKinesitherapeute();
        for (java.util.Iterator iter = newKinesitherapeute.iterator(); iter.hasNext();)
            addKinesitherapeute((Kinesitherapeute)iter.next());
    }

    // default add newKinesitherapeute
    public void addKinesitherapeute(Kinesitherapeute newKinesitherapeute) {
        if (newKinesitherapeute == null)
            return;
        if (this.kinesitherapeute == null)
            this.kinesitherapeute = new java.util.HashSet<Kinesitherapeute>();
        if (!this.kinesitherapeute.contains(newKinesitherapeute))
            this.kinesitherapeute.add(newKinesitherapeute);
    }

    // default remove oldKinesitherapeute
    public void removeKinesitherapeute(Kinesitherapeute oldKinesitherapeute) {
        if (oldKinesitherapeute == null)
            return;
        if (this.kinesitherapeute != null)
            if (this.kinesitherapeute.contains(oldKinesitherapeute))
                this.kinesitherapeute.remove(oldKinesitherapeute);
    }

    // default removeAll
    public void removeAllKinesitherapeute() {
        if (kinesitherapeute != null)
            kinesitherapeute.clear();
    }
    // default getter
    public java.util.Collection<Seance> getSeance() {
        if (seance == null)
            seance = new java.util.HashSet<Seance>();
        return seance;
    }

    // default iterator getter
    public java.util.Iterator getIteratorSeance() {
        if (seance == null)
            seance = new java.util.HashSet<Seance>();
        return seance.iterator();
    }

    // default setter newSeance
    public void setSeance(java.util.Collection<Seance> newSeance) {
        removeAllSeance();
        for (java.util.Iterator iter = newSeance.iterator(); iter.hasNext();)
            addSeance((Seance)iter.next());
    }

    // default add newSeance
    public void addSeance(Seance newSeance) {
        if (newSeance == null)
            return;
        if (this.seance == null)
            this.seance = new java.util.HashSet<Seance>();
        if (!this.seance.contains(newSeance))
            this.seance.add(newSeance);
    }

    // default remove oldSeance
    public void removeSeance(Seance oldSeance) {
        if (oldSeance == null)
            return;
        if (this.seance != null)
            if (this.seance.contains(oldSeance))
                this.seance.remove(oldSeance);
    }

    // default removeAll
    public void removeAllSeance() {
        if (seance != null)
            seance.clear();
    }*/

    public int getIdMed() {
        return idMed;
    }

    public void setIdMed(int idMed) {
        this.idMed = idMed;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }


}
