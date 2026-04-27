module com.tp1.sistemacopa2026 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tp1.sistemacopa2026 to javafx.fxml;
    exports com.tp1.sistemacopa2026;
}