package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InscrireControl {
    @FXML
    private TextField Email;

    @FXML
    private Button btnqt;

    @FXML
    private PasswordField MPassord;

    @FXML
    private TextField Nom;

    @FXML
    private TextField Prenom;

    @FXML
    private Button bnAnull;

    @FXML
    private Button inscrire;

    @FXML
    private Button connecter;

    @FXML
    private TextField telephone;
    @FXML
    private Label messagelabel2;

    public void bnconnecter(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("hello-view.fxml"));
            Scene scene = new Scene((Parent) fxmlLoader.load(), 700, 473);
            Stage stage=new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void btnAnullOnAction(ActionEvent e){

        /*Stage stage =(Stage) bnAnull.getScene().getWindow();
        stage.close();*/
        Email.clear();
        Nom.clear();
        Prenom.clear();
        telephone.clear();
        MPassord.clear();

    }

    public void btnscrire(ActionEvent E){
        if(Nom.getText().isBlank() == false && Prenom.getText().isBlank() == false && Email.getText().isBlank() == false && MPassord.getText().isBlank() == false && telephone.getText().isBlank() == false) {

            try {
                validatesign();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else{
                messagelabel2.setText("S'il vous plaît  entrer  votre Email et le Mot de passe!");
            }

        }



    public void validatesign()throws Exception{
        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();
        String email = Email.getText();
        String password = MPassord.getText();
        String nom=Nom.getText();
        String prenom=Prenom.getText();
        String tel=telephone.getText();
        String verifysign = "INSERT INTO  admin(Nom,Prenom,Email,Password,Tel)VALUES (?,?,?,?,?)";

        try {
            PreparedStatement statement = connectNow.getConnection().prepareStatement(verifysign);
            statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setString(3, email);
            statement.setString(4,password );
            statement.setString(5, tel);
            statement.executeUpdate();
            messagelabel2.setText("l'inscription est réussite");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void btnQuitterOnAction(ActionEvent e){

        Stage stage =(Stage) btnqt.getScene().getWindow();
        stage.close();
    }

}
