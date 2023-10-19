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
import java.sql.SQLException;

import static java.lang.Integer.parseInt;
import javafx.beans.property.SimpleIntegerProperty;

public class SeanceControl {


    @FXML
    private TextField NumMed;

    @FXML
    private Button bntMed;

    @FXML
    private Button btnAccueil;


    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnAnnuler;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnFacture;

    @FXML
    private Button btnKine;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnPatients;

    @FXML
    private Button btnProgres;

    @FXML
    private Button btnRDV;

    @FXML
    private Button btnSeance;

    @FXML
    private Button btnSupprimer;


    @FXML
    private TextField description;

    @FXML
    private TextField id_Seance;

    @FXML
    private TextField materiel;

    @FXML
    public TextField salle;

    @FXML
    private Label message;

    @FXML
    private Label messageS;

    @FXML

    private Button afficher;

    @FXML
    private TableColumn<Seance, String> description1;

    @FXML
    private TableColumn<Seance, Integer> num;

    @FXML
    private TableColumn<Seance, Integer> salleT;

    @FXML
    private TableColumn<Seance, String>   mat;

    @FXML
    private TableColumn<Seance, String> desc;

    @FXML
    private TableView<Seance> tableCatInt;
    //public ObservableList<Seance> data = FXCollections.observableArrayList();

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

    @FXML
    void btnAjouterAction(ActionEvent event) {
        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();
        String num = NumMed.getText();
        String salle1 = salle.getText();
        String mat=materiel.getText();
        String desc=description.getText();

        String Query = "INSERT INTO  seance(idMed,Salle,Materiel,Description)VALUES (?,?,?,?)";

        try {
            PreparedStatement statement = connectNow.getConnection().prepareStatement(Query);
            statement.setString(1, num);
            statement.setString(2, salle1);
            statement.setString(3, mat);
            statement.setString(4,desc );

            statement.executeUpdate();
            message.setText("la seance bien ajoutée");

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    @FXML
    void btnModifierAction(ActionEvent event) throws SQLException {


        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();
        int num = parseInt(NumMed.getText());
        String salle1 = salle.getText();
        String mat=materiel.getText();
        String desc=description.getText();
        int id = Integer.parseInt(id_Seance.getText());



        try {

            PreparedStatement statement = connectDB.prepareStatement("UPDATE seance SET idMed = ?, Salle = ?, Materiel = ?, Description = ? WHERE idSea = ?");

            statement.setInt(1,num);
            statement.setString(2, salle1);
            statement.setString(3, mat);
            statement.setString(4, desc);
            statement.setInt(5,id);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        message.setText("La séance est bien modifiée ");









    }

    @FXML
    void btnSupprimerAction(ActionEvent event) {

        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();

        int id = parseInt(id_Seance.getText());


        try {

            PreparedStatement statement = connectDB.prepareStatement("DELETE FROM seance WHERE idSea = ?");
            statement.setInt(1,id);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        messageS.setText("La seance numero "+id+" supprimée");

    }


    @FXML
    void AfficherAction(ActionEvent event) {
        /*DatabaseConnction connectNow = new DatabaseConnction();
        //Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT * FROM seance ";

        try {
            PreparedStatement statement = connectNow.getConnection().prepareStatement(verifyLogin);
            ResultSet res = statement.executeQuery();
            while (res.next()){
                data.add(new Seance(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getString(5)));

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        idseance.setCellValueFactory(new PropertyValueFactory<Seance, Integer>("idSea"));
        idmedecin.setCellValueFactory(new PropertyValueFactory<Seance,Integer>("idMed"));
        salle1.setCellValueFactory(new PropertyValueFactory<Seance,String>("Salle"));
        materiel1.setCellValueFactory(new PropertyValueFactory<Seance,String>("Materiel"));
        description1.setCellValueFactory(new PropertyValueFactory<Seance,String>("Description"));

        table.setItems(data);*/

        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();

        try {

            PreparedStatement statement = connectDB.prepareStatement("SELECT * FROM seance ");
            ResultSet rs = statement.executeQuery();

            ObservableList<Seance> SeanceList = FXCollections.observableArrayList();

            while (rs.next()) {

                Seance sn = new Seance(rs.getInt("idMed"),
                        rs.getString("Salle"),
                        rs.getString("Materiel"),
                        rs.getString("Description"));
                //rs.getString("Tel"),
                // rs.getString("Adresse"),
                //rs.getString("Maladie")*/);


                SeanceList.add(sn);
            }


            num.setCellValueFactory(new PropertyValueFactory<>("idMed"));
            salleT.setCellValueFactory(new PropertyValueFactory<>("Salle"));
            mat.setCellValueFactory(new PropertyValueFactory<>("Materiel"));
            desc.setCellValueFactory(new PropertyValueFactory<>("Description"));
            // tel.setCellValueFactory(new PropertyValueFactory<>("Tel"));
            //adresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
            //maladie.setCellValueFactory(new PropertyValueFactory<>("Maladie"));

            tableCatInt.setItems(SeanceList);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @FXML
    void AnnulerAction(ActionEvent event) {

        NumMed.clear();
        salle.clear();
        materiel.clear();
        description.clear();
        id_Seance.clear();
        /*DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();



        try {

            PreparedStatement statement = connectDB.prepareStatement("ROLLBACK ");

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        messageS.setText("annulation derminer");*/

       /* Node node = (Node)event.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.show();*/


    }



}
