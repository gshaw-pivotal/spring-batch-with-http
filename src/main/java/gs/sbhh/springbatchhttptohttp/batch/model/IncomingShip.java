package gs.sbhh.springbatchhttptohttp.batch.model;


import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class IncomingShip {

    private UUID id;

    private String name;
    private String classification;

    private int emptyWeight;
    private int maxWeight;
}
