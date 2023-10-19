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

public class MedecinControl {


    @FXML
    private TextField Fname;

    @FXML
    private TextField Sp;

    @FXML
    private TextField ad;

    @FXML
    private TableColumn<Medecin, String> adr;

    @FXML
    private Button btnAfficher;

    @FXML
    private Button btnAjout;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnSupprimer;

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
    private TableColumn<Medecin, String> nom;

    @FXML
    private TextField numtel;

    @FXML
    private Pane pnConfig;

    @FXML
    private Pane pnUser;

    @FXML
    private TableColumn<Medecin, String> prenom;

    @FXML
    private TableView<Medecin> tableCatInt;

    @FXML
    private TextField tarif;

    @FXML
    private TableColumn<Medecin, String> tel;

    @FXML
    private TableColumn<Medecin, String> email;

    @FXML
    private TableColumn<Medecin, String> spc;

    @FXML
    private TableColumn<Medecin, String> trf;

    @FXML
    private TextField tfIdCatInt;

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

    public void btnModifierAction(ActionEvent actionEvent) {
        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();


        String Nom = name.getText();
        String Prenom = Fname.getText();
        String Adress = ad.getText();
        String Tel = numtel.getText();
        String Email = mail.getText();
        String Specialite = Sp.getText();
        int Tarif = Integer.parseInt(tarif.getText());
        int id = Integer.parseInt(tfIdCatInt.getText());


        try {

            PreparedStatement statement = connectDB.prepareStatement("UPDATE medecin SET Nom = ?, Prenom = ?,  Tel = ?, Adresse = ?,  Email = ? , Specialite= ?,Tarif = ? WHERE idMed   = ?");

            statement.setString(1, Nom);
            statement.setString(2, Prenom);
            statement.setString(4, Adress);
            statement.setString(3, Tel);
            statement.setString(5, Email);
            statement.setString(6, Specialite);
            statement.setInt(7, Tarif);
            statement.setInt(8,id);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        msg1.setText("La modification est faite avec succès !");
    }

    public void AjoutAction(ActionEvent actionEvent) {
        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();

        String Nom = name.getText();
        String Prenom = Fname.getText();
        String Adress = ad.getText();
        String Tel = numtel.getText();
        String Email = mail.getText();
        String Specialite = Sp.getText();
        int Tarif = Integer.parseInt(tarif.getText());


        try {

            PreparedStatement statement = connectDB.prepareStatement("INSERT INTO medecin(Nom, Prenom, Tel, Adresse, Email,Specialite,Tarif) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, Nom);
            statement.setString(2, Prenom);
            statement.setString(3, Tel);
            statement.setString(4, Adress);
            statement.setString(5, Email);
            statement.setString(6, Specialite);
            statement.setInt(7, Tarif);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        msg1.setText("L'ajout est fait avec succès !");
    }

    public void btnAfficherAction(ActionEvent actionEvent) {
        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();

        try {

            PreparedStatement statement = connectDB.prepareStatement("SELECT * FROM medecin ");
            ResultSet rs = statement.executeQuery();

            ObservableList<Medecin> MedList = FXCollections.observableArrayList();

            while (rs.next()) {

                Medecin med = new Medecin(//rs.getInt("idKin"),

                        rs.getString("Nom"),
                        rs.getString("Prenom"),
                        //rs.getString("Tel"),
                        rs.getString("Email"),
                       // rs.getString("Adresse"),
                        rs.getString("Specialite"),
                        rs.getInt("Tarif"));


                MedList.add(med);
            }


            nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
            prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
           // tel.setCellValueFactory(new PropertyValueFactory<>("Tel"));
            //adr.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
            email.setCellValueFactory(new PropertyValueFactory<>("Email"));
            spc.setCellValueFactory(new PropertyValueFactory<>("Specialite"));
            trf.setCellValueFactory(new PropertyValueFactory<>("Tarif"));

            tableCatInt.setItems(MedList);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void btnSupprimerAction(ActionEvent actionEvent) {
        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();
        int id = Integer.parseInt(tfIdCatInt.getText());


        try {

            PreparedStatement statement = connectDB.prepareStatement("DELETE  FROM medecin WHERE idMed  = ?");
            statement.setInt(1,id);
            int i = statement.executeUpdate();

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
