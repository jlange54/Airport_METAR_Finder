package backend;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;


public class AvwxApi {

    public static void getMetarForStation (String icao) {
        Client client = ClientBuilder.newClient();
        Response response = client.target("https://avwx.rest/api/metar/" + icao)
                        .request(MediaType.TEXT_PLAIN_TYPE)
                        .header("Authorization", Config.avwxToken)
                        .get();

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.readEntity(String.class));
    }
}
