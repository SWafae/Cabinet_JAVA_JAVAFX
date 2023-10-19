package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class KineControl {

    @FXML
    private TextField Fname;

    @FXML
    private TextField ad;
    @FXML
    private TextField med;

    @FXML
    private TableColumn<Kine, String> adress;

    @FXML
    private Button btnAccueil;

    @FXML
    private Button btnAfficher;

    @FXML
    private Button btnAjout;

    @FXML
    private Button btnMed;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnPatients;

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
    private TextField mail;

    @FXML
    private Label msg;

    @FXML
    private Label msg1;

    @FXML
    private Label msg2;

    @FXML
    private TextField name;

    @FXML
    private TextField numtel;

    @FXML
    private Pane pnConfig;

    @FXML
    private Pane pnUser;

    @FXML
    private TableColumn<Kine, String> nom;

    @FXML
    private TableColumn<Kine, String> prenom;

    @FXML
    private TableColumn<Kine, Integer> idKine;

    @FXML
    private TableColumn<Kine, String> email;

    @FXML
    private TableColumn<Kine, Integer> idMed;

    @FXML
    private TableView<Kine> tableCatInt;

    @FXML
    private TableColumn<Kine, String> tel;

    @FXML
    private TextField tfIdCatInt;


    @FXML
    void btnAfficherAction(ActionEvent event) {


            DatabaseConnction connectNow = new DatabaseConnction();
            Connection connectDB = connectNow.getConnection();

            try {

                PreparedStatement statement = connectDB.prepareStatement("SELECT idKin,Nom,Prenom,Adress,Email,Adress FROM kinesitherapeute ");
                ResultSet rs = statement.executeQuery();

                ObservableList<Kine> kineList = FXCollections.observableArrayList();

                while (rs.next()) {

                    Kine kine = new Kine(//rs.getInt("idKin"),
                            //rs.getInt("idKin"),
                            rs.getString("Nom"),
                            rs.getString("Prenom"),
                            rs.getString("Adress"),
                            rs.getString("Email"),
                            rs.getString("Adress"));

                    kineList.add(kine);
                }

               // idKine.setCellValueFactory(new PropertyValueFactory<>("idKin"));
              //  idMed.setCellValueFactory(new PropertyValueFactory<>("idMed"));
                nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
                prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
                tel.setCellValueFactory(new PropertyValueFactory<>("Tel"));
                adress.setCellValueFactory(new PropertyValueFactory<>("Adress"));
                email.setCellValueFactory(new PropertyValueFactory<>("Email"));

                tableCatInt.setItems(kineList);


            } catch (Exception e) {
                e.printStackTrace();
            }

        }






    @FXML
    void AjoutAction(ActionEvent event) {
        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();

        String Nom = name.getText();
        String Prenom = Fname.getText();
        String Adress = ad.getText();
        String Tel = numtel.getText();
        String Email = mail.getText();
        int Med = Integer.parseInt(med.getText());


        try {

            PreparedStatement statement = connectDB.prepareStatement("INSERT INTO kinesitherapeute(idMed,Nom, Prenom, Tel, Adress, Email) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, Med);
            statement.setString(2, Nom);
            statement.setString(3, Prenom);
            statement.setString(4, Tel);
            statement.setString(5, Adress);
            statement.setString(6, Email);
            int i = statement.executeUpdate();

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
        String Adress = ad.getText();
        String Tel = numtel.getText();
        String Email = mail.getText();
        int id = Integer.parseInt(tfIdCatInt.getText());
        int Med = Integer.parseInt(med.getText());


        try {

            PreparedStatement statement = connectDB.prepareStatement("UPDATE kinesitherapeute SET idMed=?, Nom = ?, Prenom = ?,  Tel = ?, Adress = ?,  Email = ? WHERE idKin  = ?");
            statement.setInt(1,Med);
            statement.setString(2, Nom);
            statement.setString(3, Prenom);
            statement.setString(5, Adress);
            statement.setString(4, Tel);
            statement.setString(6, Email);
            statement.setInt(7,id);
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
        int id = Integer.parseInt(tfIdCatInt.getText());


        try {

            PreparedStatement statement = connectDB.prepareStatement("DELETE FROM kinesitherapeute WHERE idKin  = ?");
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




    }
