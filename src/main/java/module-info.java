module fx.demo.main {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    requires static lombok;
    requires org.slf4j;

    opens com.valantic.fx to javafx.fxml;

    exports com.valantic.fx;
}
