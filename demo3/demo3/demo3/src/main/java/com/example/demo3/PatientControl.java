package com.example.demo3;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class PatientControl {

    @FXML
    private Button btnAccueil;

    @FXML
    private Button btnAfficher;

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnMed;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnPatients;

    @FXML
    private Label msg;

    @FXML
    private Button btnSupprimer;

    @FXML
    private Button btndeconect;

    @FXML
    private Button btnfacture;

    @FXML
    private Button btnkine;


    @FXML
    private Button btnprog;

    @FXML
    private Button btnrdv;

    @FXML
    private Button btnseance;

    @FXML
    private TableColumn<Patient, String> nom;

    @FXML
    private TableColumn<Patient, String> prenom;

    @FXML
    private TableColumn<Patient, Integer> age;

    @FXML
    private TableColumn<Patient, String> adresse;

    @FXML
    private TableColumn<Patient, String> tel;

    @FXML
    private TableColumn<Patient, String> maladie;

    @FXML
    private Label msg1;

    @FXML
    private Label msg2;

    @FXML
    private Pane pnConfig;

    @FXML
    private Pane pnUser;

    @FXML
    private TableView<Patient> tableCatInt;

    @FXML
    private TextField tfIdCatInt;
    @FXML
    private TextField name;
    @FXML
    private TextField Fname;
    @FXML
    private TextField ag;
    @FXML
    private TextField ad;
    @FXML
    private TextField numtel;
    @FXML
    private TextField mal;
    @FXML
    private TextField mail;
    @FXML
    private TextField idMed;
    @FXML
    private TextField idPr;



    @FXML
    void btnAfficherAction(ActionEvent event) {


        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();

        try {

            PreparedStatement statement = connectDB.prepareStatement("SELECT * FROM patient ");
            ResultSet rs = statement.executeQuery();

            ObservableList<Patient> PatientList = FXCollections.observableArrayList();

            while (rs.next()) {

                Patient pat = new Patient(//rs.getInt("idKin"),

                        rs.getString("Nom"),
                        rs.getString("Prenom"),
                        rs.getInt("Age"));
                        //rs.getString("Tel"),
                       // rs.getString("Adresse"),
                        //rs.getString("Maladie")*/);


                PatientList.add(pat);
            }


            nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
            prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
            age.setCellValueFactory(new PropertyValueFactory<>("Age"));
           // tel.setCellValueFactory(new PropertyValueFactory<>("Tel"));
            //adresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
            //maladie.setCellValueFactory(new PropertyValueFactory<>("Maladie"));

            tableCatInt.setItems(PatientList);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    @FXML
    void btnAjouterAction(ActionEvent event) {

        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();

        String Nom = name.getText();
        String Prenom = Fname.getText();
        int Age = parseInt(ag.getText());
        int Med = parseInt(idMed.getText());
        int Pr = parseInt(idPr.getText());


        String Adress = ad.getText();
        String Tel = numtel.getText();
        String Maladie = mal.getText();
        String Email = mail.getText();


        try {

            PreparedStatement statement = connectDB.prepareStatement("INSERT INTO Patient(idMed,idPr,Nom, Prenom, Age, Tel, Adresse, Maladie, Email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, Med);
            statement.setInt(2, Pr);
            statement.setString(3, Nom);
            statement.setString(4, Prenom);
            statement.setInt(5, Age);
            statement.setString(6,Tel);
            statement.setString(7, Adress);
            statement.setString(8, Maladie);
            statement.setString(9, Email);
           /* int i =*/ statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        msg1.setText("L'ajout est fait avec succès !");


    }



    @FXML
    void btnModifierAction(ActionEvent event) {
        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();

        String Nom = name.getText();
        String Prenom = Fname.getText();
        int Age = parseInt(ag.getText());
        String Adress = ad.getText();
        String Tel = numtel.getText();
        String Maladie = mal.getText();
        String Email = mail.getText();
        int id = parseInt(tfIdCatInt.getText());


        try {

            PreparedStatement statement = connectDB.prepareStatement("UPDATE Patient SET Nom = ?, Prenom = ?, Age = ?, Tel = ?, Adresse = ?, Maladie = ?, Email = ? WHERE idPat = ?");

            statement.setString(1, Nom);
            statement.setString(2, Prenom);
            statement.setInt(3, Age);
            statement.setString(4, Tel);
            statement.setString(5, Adress);
            statement.setString(6, Maladie);
            statement.setString(7, Email);
            statement.setInt(8,id);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        msg1.setText("La modification est faite avec succès !");

    }



    @FXML
    void btnSupprimerAction(ActionEvent event) {
        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();
        int id = parseInt(tfIdCatInt.getText());


        try {

            PreparedStatement statement = connectDB.prepareStatement("DELETE FROM Patient WHERE idPat = ?");
            statement.setInt(1,id);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        msg2.setText("La suppression est faite avec succès !");

    }


    @FXML
    void AccueilAction(ActionEvent event) throws IOException {

        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root;
            Scene scene;

            root = (Parent) FXMLLoader.load(this.getClass().getResource("Home.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception var6) {
            System.out.println("y" + var6.getMessage());
        }



    }






    public void PatientAction(ActionEvent actionEvent)  throws IOException {

        try {
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root;
            Scene scene;

            root = (Parent) FXMLLoader.load(this.getClass().getResource("Patient.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception var6) {
            System.out.println("y" + var6.getMessage());
        }
    }


    public void KineAction(ActionEvent actionEvent)throws IOException {

        try {
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root;
            Scene scene;

            root = (Parent) FXMLLoader.load(this.getClass().getResource("Kine.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception var6) {
            System.out.println("y" + var6.getMessage());
        }



    }
    public void MedAction(ActionEvent actionEvent)throws IOException {

        try {
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root;
            Scene scene;

            root = (Parent) FXMLLoader.load(this.getClass().getResource("Medecin.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception var6) {
            System.out.println("y" + var6.getMessage());
        }



    }

    public void RdvAction(ActionEvent actionEvent)throws IOException {

        try {
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root;
            Scene scene;

            root = (Parent) FXMLLoader.load(this.getClass().getResource("RDV.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception var6) {
            System.out.println("y" + var6.getMessage());
        }



    }
    public void FactureAction(ActionEvent actionEvent) throws IOException {

        try {
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root;
            Scene scene;

            root = (Parent) FXMLLoader.load(this.getClass().getResource("Facture.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception var6) {
            System.out.println("y" + var6.getMessage());
        }



    }
    public void SeanceAction(ActionEvent actionEvent) throws IOException {

        try {
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root;
            Scene scene;

            root = (Parent) FXMLLoader.load(this.getClass().getResource("Seance.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception var6) {
            System.out.println("y" + var6.getMessage());
        }



    }
    public void ProgresAction(ActionEvent actionEvent) throws IOException {

        try {
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root;
            Scene scene;

            root = (Parent) FXMLLoader.load(this.getClass().getResource("Progres.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception var6) {
            System.out.println("y" + var6.getMessage());
        }



    }

    public void CloseAction(ActionEvent actionEvent)throws IOException {

        try {
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root;
            Scene scene;

            root = (Parent) FXMLLoader.load(this.getClass().getResource("hello-view.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception var6) {
            System.out.println("y" + var6.getMessage());
        }



    }










}
