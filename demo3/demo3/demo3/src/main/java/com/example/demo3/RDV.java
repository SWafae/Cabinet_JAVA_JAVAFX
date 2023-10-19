package com.example.demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Date;
import java.time.LocalTime;

public class RDV{
    private int idRDV;
    private int idSean;
    private Date date;
    private String Heure;
    //public Seance seanceB;

    public RDV(){};

    public RDV(int idRDV, int idSean, Date date, String heure) {
        this.idRDV = idRDV;
        this.idSean = idSean;
        this.date = date;
        this.Heure = heure;
    }
/*public Rdv(int idRDV, Date date, Date heure, Seance seanceB) {
        super();
        this.idRDV = idRDV;
        this.date = date;
        this.heure = heure;
        this.seanceB = seanceB;
    }*/

  /*  public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Patient.class.getResource("Rdv.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }*/

    public int getIdRDV() {
        return idRDV;
    }

    public void setIdRDV(int idRDV) {
        this.idRDV = idRDV;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeure() {
        return Heure;
    }

    public void setHeure(String heure) {
        this.Heure = heure;
    }
}
