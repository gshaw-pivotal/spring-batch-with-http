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

    public void print() {
        System.out.println("Reg Id         " + regId);
        System.out.println("Name           " + name);
        System.out.println("Classification " + classification);
        System.out.println("Empty Weight   " + emptyWeight);
        System.out.println("Max Weight     " + maxWeight);
        System.out.println("Dead Weight    " + deadWeight);
    }
}
