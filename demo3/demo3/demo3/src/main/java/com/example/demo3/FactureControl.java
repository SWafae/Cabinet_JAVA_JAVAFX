package com.example.demo3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

//import java.awt.Desktop;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.SocketTimeoutException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/*
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;*/

import com.example.demo3.Patient;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableColumn;

public class FactureControl {
    @FXML
    private Button Afficher;

    @FXML
    private Button Annuler;

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
    private Label dat;

    @FXML
    private DatePicker date;

    @FXML
    private Label description;

    @FXML
    private TextField idPati;

    @FXML
    private Label idfact;

    @FXML
    private Label idmed;

    @FXML
    private Label idpas;

    @FXML
    private Label idsea;

    @FXML
    private TextField idsean;

    @FXML
    private Label materiel;

    @FXML
    private Label msg1;

    @FXML
    private Label nom;

    @FXML
    private Label prenom;

    @FXML
    private Label salle;







    public void imprimerOnAction(ActionEvent E) {
        if (idsean.getText().isBlank() == false && idPati.getText().isBlank()==false) {
            v();
            A();
            K();
            getDate();

        } else {

        }

    }

    public void v(){
        DatabaseConnction connectNow = new DatabaseConnction();
        //Connection connectDB = connectNow.getConnection();
        String Login = idsean.getText();
        String verifyLogin = "SELECT * FROM facture WHERE idSea = ?  ";

        try {
            PreparedStatement statement = connectNow.getConnection().prepareStatement(verifyLogin);
            statement.setString(1, Login);
            ResultSet res = statement.executeQuery();

            if(res.next()){
                String d = res.getString(1);

                idfact.setText(d);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void A( ){
        String S=idsean.getText();
        DatabaseConnction connectNow = new DatabaseConnction();
        String G="SELECT * FROM seance WHERE idSea = ? " ;
        try{
            PreparedStatement statement = connectNow.getConnection().prepareStatement(G);
            statement.setString(1,S);
            ResultSet res = statement.executeQuery();

            if(res.next()){
                String d = res.getString(1);
                String H= res.getString(2);
                String m = res.getString(3);
                String s = res.getString(4);
                String L=res.getString(5);
                idsea.setText("1");
                idmed.setText(H);
                salle.setText(m);
                materiel.setText(s);
                description.setText(L);

            }

        }catch (Exception e){

        }

    }

    public void K(){
        String S=idPati.getText();
        DatabaseConnction connectNow = new DatabaseConnction();
        String G="SELECT idPat,Nom,Prenom FROM patient WHERE idPat = ? " ;
        try{
            PreparedStatement statement = connectNow.getConnection().prepareStatement(G);
            statement.setString(1,S);
            ResultSet re = statement.executeQuery();

            if(re.next()){
                String d = re.getString(1);
                String f=re.getString(2);

                String c=re.getString(3);

                idpas.setText(d);
                nom.setText(f);
                prenom.setText(c);


            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public  void getDate(){
        LocalDate mydate=date.getValue();
        dat.setText(mydate.toString());
    }
    public  void AnnulerOnAction(ActionEvent E){
        idPati.clear();
        idsean.clear();
        // date.clear();
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
