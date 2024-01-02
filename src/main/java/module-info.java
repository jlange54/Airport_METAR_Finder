module Airport.METAR.Finder {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.ws.rs.api;
    requires jackson.core.asl;
    requires jackson.mapper.asl;


    opens frontend to javafx.fxml;
    exports frontend;
}