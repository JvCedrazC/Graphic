package com.example.phase4.Controller;
import com.example.phase4.FilesUtils.StageController;
import com.example.phase4.HelloApplication;
import com.example.phase4.Model.Technician;
import com.example.phase4.dao.Dao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button btnConfirma;

    @FXML
    private Label erro_msg;

    @FXML
    private TextField loginBox;

    @FXML
    private TextField senhaBox;

    @FXML
    private ChoiceBox<String> tipoUsuario;

    @FXML
    void btnConfirmaAction(ActionEvent event) {
      if (this.tipoUsuario.getSelectionModel().getSelectedItem().equals("Administrador")){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaMenuAdm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = StageController.getStage(event);
            stage.setScene(scene);
            stage.setTitle("Menu Administrador");
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else if (this.tipoUsuario.getSelectionModel().getSelectedItem().equals("Técnico")){
        Technician tecn = Dao.getTechnicianDao().findById(Integer.parseInt(loginBox.getText()));
        if (tecn == null){
            this.erro_msg.setText("Técnico não encontrado!");
            this.erro_msg.setStyle("-fx-text-fill: red;");
        }
        else {
            if (Integer.toString(tecn.getId()).equals(senhaBox.getText())){
                this.erro_msg.setText("Senha incorreta!");
                this.erro_msg.setStyle("-fx-text-fill: red;");
            }
            else {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaMenuTecnico.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = StageController.getStage(event);
                    stage.setScene(scene);
                    stage.setTitle("Menu Técnico");
                    stage.setResizable(false);
                    stage.centerOnScreen();

                    MenuTechnicianController controller = fxmlLoader.getController();
                    //controller.setTecnico(tecn);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    } else{
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("JanelaMenuRecepcionista.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = StageController.getStage(event);
                    stage.setScene(scene);
                    stage.setTitle("Menu Recepcionista");
                    stage.setResizable(false);
                    stage.centerOnScreen();

                    //MenuRecepcionistaController controller = fxmlLoader.getController();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    @FXML
    void initialize(){
        ObservableList<String> tipos = FXCollections.observableArrayList("Administrador","Técnico", "Recepcionista");
        this.tipoUsuario.setItems(tipos);
    }
}