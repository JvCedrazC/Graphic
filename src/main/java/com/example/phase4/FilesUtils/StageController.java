package com.example.phase4.FilesUtils;


import com.example.phase4.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

public class StageController {

    public static void openScreen(ActionEvent event, String URl) throws IOException {

        Stage stage = getStage(event);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(URl));

        stage.setScene(new Scene(fxmlLoader.load()));

    }

    public static void  openScreenNewWindow(String URl) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(URl));

        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("Perfil");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public static void closeWindow(ActionEvent event){
        getStage(event).close();
    }

    public static Stage getStage(ActionEvent event){
        Node source = (Node)  event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        return stage;
    }
}
