module com.tp1.sistemacopa2026 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens controller to javafx.fxml;
    opens main to javafx.graphics;

    exports main;
}