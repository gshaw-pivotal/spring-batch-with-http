package gs.sbhh.springbatchhttptohttp.batch.processing;

import gs.sbhh.springbatchhttptohttp.batch.model.OutgoingShip;
import org.springframework.batch.item.ItemWriter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ShipHTTPWriter implements ItemWriter<OutgoingShip> {

    private final String baseUrl;

    private final RestTemplate restTemplate;

    public ShipHTTPWriter(String baseUrl, RestTemplate restTemplate) {
        this.baseUrl = baseUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public void write(List<? extends OutgoingShip> list) throws Exception {
        restTemplate.postForEntity(baseUrl + "/ship", list, null);
    }
}
