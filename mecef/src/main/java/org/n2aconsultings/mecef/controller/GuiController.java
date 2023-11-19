package org.n2aconsultings.mecef.controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import lombok.Getter;
import org.n2aconsultings.mecef.Mecef;
import org.n2aconsultings.mecef.view.*;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class GuiController implements Initializable
{
    @Getter
    private static GuiController instance;

    public GuiController(){
        instance = this;
    }

    @FXML
    private AnchorPane content;

    @FXML
    void logout(ActionEvent event) {
        signout();
    }

    @FXML
    void help(ActionEvent event) {
        View.scene(FxmlView.SUPPORT);
    }
    
    public void emptyContent() {
        ObservableList<Node> nodes = content.getChildren();
        content.getChildren().removeAll(nodes);
    }
    
    public AnchorPane getContent() {
        return content;
    }
    
    public void setContent(String view) {
        emptyContent();
        try {
            AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(Mecef.class.getResource(view)));
            fxml.setMinSize(content.getWidth(),content.getHeight());
            fxml.setPrefSize(content.getWidth(),content.getHeight());
            fxml.setMaxSize(content.getWidth(),content.getHeight());
            content.getChildren().add(fxml);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void signout(){

        javafx.concurrent.Service<Void> load = new javafx.concurrent.Service<>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        //
                        return null;
                    }
                };
            }
        };

        load.stateProperty().addListener((ObservableValue<? extends Worker.State> observableValue, Worker.State oldValue, Worker.State newValue) -> {
            switch (newValue) {
                case FAILED, CANCELLED -> {
                    AlertWarning.getInstance().setHeaderText("Fermeture de session");
                    AlertWarning.getInstance().setContentText("Opération avortée !!!");
                    AlertWarning.getInstance().showAndWait();
                }
                case SUCCEEDED -> View.show(FxmlView.MAIN);
            }
        });

        load.start();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

        View.getInstance().getGui().maximizedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                View.getInstance().getGui().setMaximized(true);
            }
        });

        View.getInstance().getGui().setOnCloseRequest(event -> {
            AlertConfirm.getInstance().setTitle("Fermeture de l'application");
            AlertConfirm.getInstance().setContentText("Nous allons vous déconnecter de la session.");
            if(AlertConfirm.getInstance().showAndWait().get().equals(ButtonType.OK)){
                signout();
                System.exit(0);
            }else{
                event.consume();
            }
        });
    }
}
