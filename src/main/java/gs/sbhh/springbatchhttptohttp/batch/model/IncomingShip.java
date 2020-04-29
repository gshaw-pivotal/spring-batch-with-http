package gs.sbhh.springbatchhttptohttp.batch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomingShip {

    private UUID id;

    private String name;
    private String classification;

    private int emptyWeight;
    private int maxWeight;
}
