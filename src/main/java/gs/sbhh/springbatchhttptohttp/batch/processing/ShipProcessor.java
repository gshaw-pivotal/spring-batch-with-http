package gs.sbhh.springbatchhttptohttp.batch.processing;

import gs.sbhh.springbatchhttptohttp.batch.model.IncomingShip;
import gs.sbhh.springbatchhttptohttp.batch.model.OutgoingShip;
import org.springframework.batch.item.ItemProcessor;

public class ShipProcessor implements ItemProcessor<IncomingShip, OutgoingShip> {

    @Override
    public OutgoingShip process(final IncomingShip inShip) {
         OutgoingShip.OutgoingShipBuilder outShipBuilder = OutgoingShip.builder();

         outShipBuilder.regId(inShip.getId())
                 .name(inShip.getName())
                 .classification(inShip.getClassification())
                 .emptyWeight(inShip.getEmptyWeight())
                 .maxWeight(inShip.getMaxWeight())
                 .deadWeight(inShip.getMaxWeight() - inShip.getEmptyWeight());

        return outShipBuilder.build();
    }
}
