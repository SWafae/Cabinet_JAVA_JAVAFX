package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.demo3.user;


public class HelloController {

    @FXML
    private Button btnAnnuler;
    @FXML
    private Label messagelabl1;

    @FXML
    private  Button btnConnecter;

    @FXML
    private  Button btnInscrire;

    @FXML
    private TextField Email;

    @FXML
    private PasswordField password;

    public void  btnConnecterOnAction(ActionEvent E){

        if(Email.getText().isBlank() == false && password.getText().isBlank() == false){

            try {
                validateLogin(E);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        else{
            messagelabl1.setText("S'il vous plaît  entrer  votre Email et le Mot de passe!");
        }
    }
    public void btnAnnulerOnAction(ActionEvent e){

        Stage stage =(Stage) btnAnnuler.getScene().getWindow();
        stage.close();
    }


public void validateLogin(Event event) throws Exception {

   DatabaseConnction connectNow = new DatabaseConnction();
    Connection connectDB = connectNow.getConnection();
    String Login = Email.getText();
    String PWD = password.getText();
    String verifyLogin = "SELECT * FROM admin WHERE email = ? AND password = ? ";

    try {

        PreparedStatement statement = connectDB.prepareStatement(verifyLogin);
        statement.setString(1,Login);
        statement.setString(2,PWD);
        ResultSet res = statement.executeQuery();


        if (res.next()) {

            try {

                Node node = (Node)event.getSource();
                Stage stage = (Stage)node.getScene().getWindow();
                stage.close();
                Parent root;
                Scene scene;

                root = (Parent)FXMLLoader.load(this.getClass().getResource("Home.fxml"));
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (Exception var6) {
                System.out.println("y" + var6.getMessage());
            }
        }else {
            messagelabl1.setText("votre email ou mot de passe est incorrect");            }






    } catch (Exception e) {
        e.printStackTrace();
    }

}



    public void btnInscrireOnAction(ActionEvent actionEvent) throws Exception  {
        try {

            Node node = (Node)actionEvent.getSource();
            Stage stage = (Stage)node.getScene().getWindow();
            stage.close();
            Parent root;
            Scene scene;

            root = (Parent)FXMLLoader.load(this.getClass().getResource("Inscrire.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception var6) {
            System.out.println("y" + var6.getMessage());
        }

    }


    /*public String USERNAMEAD() throws SQLException {
        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();
        String Login = Email.getText();
        String PWD = password.getText();
        String verifyLogin = "SELECT * FROM admin WHERE email = ? AND password = ? ";

        try {

            PreparedStatement statement = connectDB.prepareStatement(verifyLogin);
            statement.setString(1, Login);
            statement.setString(2, PWD);
            ResultSet res = statement.executeQuery();

             String nom = res.getString(2);
             String prenom = res.getString(3);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return "nom"+"prenom" ;
    }*/
}