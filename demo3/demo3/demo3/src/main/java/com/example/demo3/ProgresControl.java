package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class ProgresControl {

    @FXML
    private Text ConcMessage;

    @FXML
    private TextField Etat;

    @FXML
    private Button bntMed;

    @FXML
    private Button btnAccueil;

    @FXML
    private Button btnAfficher;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnConclure;

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
    private Button btnTelecharger;

    @FXML
    private TextArea descriptionText;

    @FXML
    private TextField id_Pat;

    @FXML
    private Label message;

    @FXML
    private Label messageS;

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
    @FXML
    void btnConclureAction(ActionEvent event) {

        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();
        int idPr=idProgres();


        try {
            PreparedStatement stat = connectDB.prepareStatement("select Amélioration FROM progres WHERE idPr =?  ");
            stat.setInt(1, idPr);

            ResultSet rs=stat.executeQuery();
            if(rs.next()) {
                String eta = rs.getString("Amélioration");
                if(eta=="oui"){

                    message.setText("Etat de patient s'améliore");

                }else
                {
                    message.setText("Etat de patient ne s'améliore pas");
                }
                

            }
        }catch (Exception e) {
            e.printStackTrace();
        }








    }

     public int idProgres(){

        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();
        int idP = parseInt(id_Pat.getText());

        try {
            PreparedStatement statement = connectDB.prepareStatement("select idPr FROM patient WHERE idPat=?  ");
            statement.setInt(1, idP);
            ResultSet rs1 = statement.executeQuery();
           if(rs1.next()) {

               return rs1.getInt("idPr");

           }else return 0;

        }catch (Exception e) {
            e.printStackTrace();
        }


        return 0;
    }
    @FXML
    void AfficherAction(ActionEvent event) {

        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();
        int idPr=idProgres();


    try {
        PreparedStatement stat = connectDB.prepareStatement("select Info,Amélioration FROM progres WHERE idPr=?  ");
        stat.setInt(1, idPr);

        ResultSet rs=stat.executeQuery();
if(rs.next()) {
    String eta = rs.getString("Amélioration");
    String exm = rs.getString("Info");
  /*if(eta=="oui"){

      message.setText("Etat de patient s'améliore");

  }else
  {
      message.setText("Etat de patient ne s'améliore pas");
  }*/
    //Etat.setText(eta);
    descriptionText.setText(exm);
    //message.setText(eta+""+exm);

}
    }catch (Exception e) {
            e.printStackTrace();
        }


    }





    @FXML
    void btnModifierAction(ActionEvent event) throws SQLException {

        DatabaseConnction connectNow = new DatabaseConnction();
        Connection connectDB = connectNow.getConnection();
        int id=idProgres();
        //AfficherAction(event);

        String etat = Etat.getText();
        String desc=descriptionText.getText();

        try {

            PreparedStatement statement = connectDB.prepareStatement("UPDATE progres SET Info = ?, Amélioration = ? WHERE idPr = ?");

            statement.setString(1,desc);
            statement.setString(2,etat );
            statement.setInt(3,id);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        messageS.setText("Le progrès est bien modifiée "+id);


    }

    @FXML
    void btnTelechargerAction(ActionEvent event) {
        id_Pat.clear();
        Etat.clear();
        descriptionText.clear();
        //messageS.clear();

    }

}
