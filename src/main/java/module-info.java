module com.tp1.sistemacopa2026 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    opens users to javafx.base, javafx.fxml;
    opens stadium to javafx.base, javafx.fxml;
    opens matches to javafx.base, javafx.fxml;
    opens nationsAndPlayers to javafx.base, javafx.fxml;
    opens controller to javafx.fxml;
    opens main to javafx.graphics;

    exports main;
}