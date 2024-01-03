package frontend;

import backend.AirportList;
import backend.AvwxApi;
import backend.MetarParser;
import backend.objects.Airport;
import backend.objects.metar.Metar;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StartController implements Initializable {

    @FXML
    private Label currentIcaoSelection;
    @FXML
    private Label countryLabel;
    @FXML
    private Label elevationLabel;
    @FXML
    private Label longestRunwayLabel;
    @FXML
    private Label generalAirportInformationLabel;
    @FXML
    private GridPane generalAirportInformationGridPane;
    @FXML
    private ListView<Airport> airportListView = new ListView<>();
    @FXML
    private TextArea currentWeatherTextArea;

    private String currentIcao;
    private Metar currentMetar;
    private boolean metarAvailable = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generalAirportInformationLabel.setVisible(false);
        generalAirportInformationGridPane.setVisible(false);

        List<Airport> airportList;
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
               if (airportListView.getSelectionModel().getSelectedItem().getCountryPrefix().getCountry().equals("noCountry")) {
                   countryLabel.setVisible(false);
               } else {
                   countryLabel.setText(airportListView.getSelectionModel().getSelectedItem().getCountryPrefix().getCountry());
                   countryLabel.setVisible(true);
               }
               elevationLabel.setText(airportListView.getSelectionModel().getSelectedItem().getElevation() + " feet");
               longestRunwayLabel.setText(airportListView.getSelectionModel().getSelectedItem().getLongestRunway() + " feet");

               generalAirportInformationLabel.setVisible(true);
               generalAirportInformationGridPane.setVisible(true);

               try {
                   if (AvwxApi.getMetarForStation(currentIcao) != null) {
                       currentMetar = MetarParser.parse(AvwxApi.getMetarForStation(currentIcao));
                       System.out.println(currentMetar);
                       metarAvailable = true;
                   }
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }

               if (metarAvailable) {
                   currentWeatherTextArea.setText(
                           "The weather at " + airportListView.getSelectionModel().getSelectedItem().getName() + " is : " +
                                   currentMetar.getWxCode().getFirst().getValue() + " the temperature is: " + currentMetar.getTemperature() +
                                   "Wind is coming from " + currentMetar.getWindDirection() + " at " + currentMetar.getWindSpeed() + currentMetar.getUnits().getWindSpeed()
                   );
               } else {
                   currentWeatherTextArea.setText("No METAR available for " + airportListView.getSelectionModel().getSelectedItem().getName());
               }
           }
       });
    }
}
