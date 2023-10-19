package com.example.demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Kine /*extends Application*/ {

        private int idKine;
        private int idMed;
        private String nom;
        private String prenom;
        private String tel;
        private String email;
        private String adress;




    public Kine(){};
    public Kine( String nom, String prenom, String tel, String email, String adress) {
        //this.idKine = idKine;
        //this.idMed = idMed;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
        this.adress = adress;
    }
      /*  @Override
        public void start(Stage stage) throws Exception {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Patient.class.getResource("Kine.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }*/

    /*public KineApplication(int idKine, String nom, String prenom, String tel, String email, String adress) {
        super();
        this.idKine = idKine;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
        this.adress = adress;
    }*/

        public int getIdKine() {
            return idKine;
        }

        public void setIdKine(int idKine) {
            this.idKine = idKine;
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

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
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
    }


