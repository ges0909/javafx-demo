package com.valantic.fx;

import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.service.finder.NodeFinder;
import org.testfx.service.query.NodeQuery;

import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import static org.testfx.assertions.api.Assertions.assertThat;


@ExtendWith(ApplicationExtension.class)
class FxDemoApplicationTest {

    private final NodeFinder nodeFinder = FxAssert.assertContext().getNodeFinder();

    private Stage window;

    @BeforeAll
    static void setHeadlessMode() {
        final boolean headless = System.getProperty("headless") != null && Boolean.parseBoolean(System.getProperty("headless"));
        if (headless) {
            System.setProperty("testfx.robot", "glass");
            System.setProperty("testfx.headless", "true");
            System.setProperty("prism.order", "sw");
            System.setProperty("prism.text", "t2k");
        }
    }

    @Start
    private void start(final Stage stage) {
        this.window = stage;
        stage.show();
    }

    private <T> T find(final Class<T> clazz, final String query) {
        final NodeQuery nodeQuery = nodeFinder.from(window.getScene().getRoot());
        return nodeQuery.lookup(query).queryAll().stream().findFirst().map(clazz::cast).orElse(null);
    }

    private <T> List<T> findAll(final Class<T> clazz, final String query) {
        final NodeQuery nodeQuery = nodeFinder.from(window.getScene().getRoot());
        return nodeQuery.lookup(query).queryAll().stream().map(clazz::cast).collect(Collectors.toList());
    }

    @BeforeEach
    void beforeEachTest() throws Exception {
        ApplicationTest.launch(FxDemoApplication.class);
    }

    @AfterEach
    void afterEachTest() throws TimeoutException {
        FxToolkit.hideStage();
    }

    @Test
    void window_should_be_shown(final FxRobot robot) {
        final Window window = robot.window("JavaFX Demo!");
        assertThat(window).isShowing();
    }

    @Test
    void ui_controls_should_contain_text(final FxRobot robot) {
        final Label label = find(Label.class, "#welcomeText");
        assertThat(label).hasText("Welcome");
        //
        final Hyperlink hyperLink = find(Hyperlink.class, "#valanticLink");
        assertThat(hyperLink).hasText("www.valantic.com");
        //
        final Button button = find(Button.class, "#showMessageButton");
        assertThat(button).hasText("Show message");
    }

    @Test
    void ui_controls_should_contain_text_using_fxassert(final FxRobot robot) {
        final var buttonText = "Show message";
        final Button button = find(Button.class, "#showMessageButton");
        FxAssert.verifyThat(button, LabeledMatchers.hasText(buttonText));
        // lookup by css id
        FxAssert.verifyThat("#showMessageButton", LabeledMatchers.hasText(buttonText));
        // lookup by css class
        FxAssert.verifyThat(".button", LabeledMatchers.hasText(buttonText));
    }

    @Test
    void when_button_is_clicked_then_welcome_text_is_shown(final FxRobot robot) {
        robot.clickOn("#showMessageButton");
        FxAssert.verifyThat("#welcomeText", LabeledMatchers.hasText("Welcome to JavaFX!"));
    }
}
