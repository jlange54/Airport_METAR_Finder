package backend;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;


public class AvwxApi {

    public static String  getMetarForStation (String icao) {
        Client client = ClientBuilder.newClient();
        Response response = client.target("https://avwx.rest/api/metar/" + icao)
                        .request(MediaType.TEXT_PLAIN_TYPE)
                        .header("Authorization", Config.avwxToken)
                        .get();

//        System.out.println(response.readEntity(String.class));
        if (response.getStatus() == 200) {
            return response.readEntity(String.class);
        } else if (response.getStatus() == 204) {
            System.out.println(response.getStatus());
            return null;
        } else {
            new Exception("response.getStatus()");
            return null;
        }
    }
}
