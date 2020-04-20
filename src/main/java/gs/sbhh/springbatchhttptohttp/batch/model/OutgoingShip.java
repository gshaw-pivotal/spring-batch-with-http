package gs.sbhh.springbatchhttptohttp.batch.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class OutgoingShip {

    private UUID regId;

    private String name;
    private String classification;

    private int emptyWeight;
    private int maxWeight;
    private int deadWeight;
}
