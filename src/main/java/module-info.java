module Airport.METAR.Finder {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.ws.rs.api;


    opens frontend to javafx.fxml;
    exports frontend;
}