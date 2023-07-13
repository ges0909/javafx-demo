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
import java.net.URL;
import java.util.List;

@Slf4j
public class Main extends Application {

    private static Main instance;
    private Stage window;

    public static Main getInstance() {
        return instance;
    }

    public static void main(final String... args) {
        launch(args);
    }

    @Override
    public void init() {
        // called before 'start'
        instance = this;
    }

    @Override
    public void start(final Stage stage) throws IOException {
        window = stage;
        window.setTitle("JavaFX Demo!");

        final URL location = getClass().getResource("fx-demo-view.fxml"); // FxDemoApplication.class.getResource("fx-demo-view.fxml");
        final FXMLLoader loader = new FXMLLoader(location);
        final VBox root = loader.load(); // don't use 'Parent' because there is no 'Parent.getChildren()'
        root.getChildren().addAll(buildContent());

        final Scene scene = new Scene(root, 320, 240);
        // scene.getStylesheets().add(getClass().getResource("fx-demo-styles.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }

    @Override
    public void stop() {
        // for completeness only
    }

    public void browse(final String url) {
        getHostServices().showDocument(url);
    }

    private List<Node> buildContent() {
        final EventHandler<ActionEvent> clickHandler = event ->
                log.info("'{}' clicked", ((Button) event.getTarget()).getText());
        final var button = new Button("Button #1");
        button.setOnAction(clickHandler);
        final var button2 = new Button("Button #2");
        button2.setOnAction(clickHandler);
        return List.of(button, button2);
    }

}
