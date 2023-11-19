package org.n2aconsultings.mecef;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.n2aconsultings.mecef.view.FxmlView;
import org.n2aconsultings.mecef.view.View;

import java.io.IOException;

public class Mecef extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        View.show(FxmlView.MAIN);
    }

    @Override
    public void stop() {
        Platform.exit();
    }
}