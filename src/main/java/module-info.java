module com.shay {
    requires transitive javafx.graphics;
    requires transitive javafx.base;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.shay to javafx.fxml;
    exports com.shay;
}
