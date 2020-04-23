package gs.sbhh.springbatchhttptohttp.batch.processing;

import gs.sbhh.springbatchhttptohttp.batch.model.IncomingShip;
import org.springframework.batch.item.ItemReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ShipHTTPReader implements ItemReader<IncomingShip> {

    private final String baseUrl;

    private final RestTemplate restTemplate;

    public ShipHTTPReader(String baseUrl, RestTemplate restTemplate) {
        this.baseUrl = baseUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public IncomingShip read() throws Exception {
        ResponseEntity<IncomingShip> response = restTemplate.getForEntity(baseUrl + "/ship", IncomingShip.class);

        return response.getBody();
    }
}
