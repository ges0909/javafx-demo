package com.valantic.fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
public class FxDemoApplication extends Application {

    private static FxDemoApplication instance;

    public static FxDemoApplication getInstance() {
        return instance;
    }

    public static void main(final String[] args) {
        launch(); // derived from 'Application'
    }

    @Override
    public void init() {
        // called before 'start'
        instance = this;
    }

    @Override
    public void start(final Stage stage) throws IOException {
        // final FXMLLoader loader = new FXMLLoader(FxDemoApplication.class.getResource("fx-demo-view.fxml"));
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("fx-demo-view.fxml"));
        // final Parent root = loader.load(); // don't use because there is no 'Parent.getChildren()'
        final VBox root = loader.load();
        final Scene scene = new Scene(root, 320, 240);
        // scene.getStylesheets().add(getClass().getResource("fx-demo-styles.css").toExternalForm());
        root.getChildren().addAll(buildButtons());
        stage.setTitle("JavaFX Demo!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        // for the sake of completeness
    }

    public void browse(final String url) {
        getHostServices().showDocument(url);
    }

    private List<Node> buildButtons() {
        final EventHandler<ActionEvent> buttonClickHandler = event ->
                log.info("'{}' clicked", ((Button) event.getTarget()).getText());
        final var button = new Button("Button #1");
        button.setOnAction(buttonClickHandler);
        final var button2 = new Button("Button #2");
        button2.setOnAction(buttonClickHandler);
        return List.of(button, button2);
    }
}
