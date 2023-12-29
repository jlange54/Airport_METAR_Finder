package frontend;

import backend.AirportList;
import backend.objects.Airport;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StartController implements Initializable {

    @FXML
    private ListView<String> airportListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Airport> airportList = null;
        try {
            airportList = AirportList.generate();
        } catch (IOException e) {
            throw new RuntimeException("Could not generate Airport List @StartController");
        }

        for (Airport airport : airportList) {
            airportListView.getItems().add(airport.getName());
            airportListView.getItems().add("Hullo?");
        }
    }




}
