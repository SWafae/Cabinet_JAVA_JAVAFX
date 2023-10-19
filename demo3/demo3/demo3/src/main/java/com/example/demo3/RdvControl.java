package com.example.demo3;

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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class RdvControl {


    @FXML
    private Button btnAjouter;


    @FXML
    private Button btnSupprimer;


    @FXML
    private DatePicker d;

    @FXML
    private TextField h;

    @FXML
    private TextField idPat;

    @FXML
    private TextField idRdv;

    @FXML
    private Label msg1;

    @FXML
    private Label msg2;

    @FXML
    private TextField idsean;

    @FXML
    private Pane pnUser;

    @FXML
    private Button bntMed;

    @FXML
    private Button btnAccueil;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnFacture;

    @FXML
    private Button btnKine;

    @FXML
    private Button btnPatients;

    @FXML
    private Button btnProgres;

    @FXML
    private Button btnRDV;

    @FXML
    private Button btnSeance;

    @FXML
    private TableColumn<RDV, Date> dt;
    @FXML
    private TableColumn<RDV, String> hr;

    @FXML
    private TableColumn<RDV, Integer> idPa;
    @FXML
    private TableColumn<RDV, Integer> idSean;
    @FXML
    private TableView<RDV> tab;



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


    @FXML
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


    @FXML
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

    @FXML
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
    @FXML
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
    @FXML
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
    @FXML
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


    @FXML
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

    @FXML
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




    public void btnAjouterAction(ActionEvent actionEvent) {
        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();

        int Patient = Integer.parseInt(idPat.getText());
        int Seance = Integer.parseInt(idsean.getText());
        String Heure = h.getText();
        LocalDate Date = d.getValue();
        String DateText = Date.toString();

        try {

            PreparedStatement statement = connectDB.prepareStatement("INSERT INTO rdv(idPat, idSea, date, time) VALUES (?, ?, ?, ?)");
            statement.setInt(1, Patient);
            statement.setInt(2, Seance);
            statement.setString(3, DateText);
            statement.setString(4, Heure);
            int i = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        msg1.setText("L'ajout est fait avec succès !");
    }

    public void btnSupprimerAction(ActionEvent actionEvent) {
        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();
        int id = Integer.parseInt(idRdv.getText());


        try {

            PreparedStatement statement = connectDB.prepareStatement("DELETE FROM rdv WHERE idRdv = ?");
            statement.setInt(1,id);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        msg2.setText("La suppression est faite avec succès !");

    }

    public void btnAfficherAction(ActionEvent actionEvent) {


        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();

        try {

            PreparedStatement statement = connectDB.prepareStatement("SELECT * FROM rdv ");
            ResultSet rs = statement.executeQuery();

            ObservableList<RDV> RDVList = FXCollections.observableArrayList();

            while (rs.next()) {

                RDV rdv = new RDV(//rs.getInt("idKin"),
                        rs.getInt("idPat"),
                        rs.getInt("idSea"),
                        rs.getDate("Date"),
                        rs.getString("Time"));

                RDVList.add(rdv);
            }

            idPa.setCellValueFactory(new PropertyValueFactory<>("idPat"));
            idSean.setCellValueFactory(new PropertyValueFactory<>("idSea"));
            dt.setCellValueFactory(new PropertyValueFactory<>("Date"));
            hr.setCellValueFactory(new PropertyValueFactory<>("Time"));


            tab.setItems(RDVList);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
