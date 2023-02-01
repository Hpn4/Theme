module eus.ehu.theme.theme {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens eus.ehu.theme.theme to javafx.fxml;
    exports eus.ehu.theme.theme;
}