package frontend;

import backend.AirportList;
import backend.objects.Airport;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StartController implements Initializable {

    @FXML
    private Label currentIcaoSelection;
    @FXML
    private ListView<Airport> airportListView = new ListView<>();

    private String currentIcao;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Airport> airportList = null;
        try {
            airportList = AirportList.generate();
        } catch (IOException e) {
            throw new RuntimeException("Could not generate Airport List @StartController");
        }

        for (Airport airport : airportList) {
            airportListView.getItems().add(airport);
        }
        airportListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Airport airport, boolean empty) {
                super.updateItem(airport, empty);
                if (empty || airport == null) {
                    setText(null);
                } else {
                    setText(airport.getName());
                }
            }
        });

       airportListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Airport>() {
           @Override
           public void changed(ObservableValue<? extends Airport> observable, Airport oldValue, Airport newValue) {
               currentIcao = airportListView.getSelectionModel().getSelectedItem().getIcaoCode();
               currentIcaoSelection.setText(currentIcao);
           }
       });
    }
}
