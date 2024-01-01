module Airport.METAR.Finder {
    requires javafx.controls;
    requires javafx.fxml;


    opens frontend to javafx.fxml;
    exports frontend;
}