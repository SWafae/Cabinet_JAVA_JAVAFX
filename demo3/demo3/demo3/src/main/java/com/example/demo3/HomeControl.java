package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import com.example.demo3.HelloController;


public class HomeControl {

        @FXML
        private Pane PnTableActe;

        @FXML
        private Pane PnTablePatient;

        @FXML
        private Button btnKine;
        @FXML
        private Button btnAccueil;



        @FXML
        private Button btnClose;



        @FXML
        private Button btnManage;

        @FXML
        private Button btnPatients;

        @FXML
        private Button btnRDV;

        @FXML
        private Button btnFacture;
        @FXML
        private Button btnSeance;

        @FXML
        private Button btnProgres;

        @FXML
        private Button bntMed;

        @FXML
        private Label label_welcome;





       /* HelloController HC=new HelloController();
        String NomAdmin=HC.USERNAMEAD();*/

    public HomeControl() throws SQLException {


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

    /*public void setUserInformation(String NomAdmin) {
        label_welcome.setText("Welcome " + NomAdmin);


    }*/






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


