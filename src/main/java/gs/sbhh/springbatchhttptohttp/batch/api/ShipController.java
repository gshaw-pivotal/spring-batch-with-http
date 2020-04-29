package gs.sbhh.springbatchhttptohttp.batch.api;

import gs.sbhh.springbatchhttptohttp.batch.model.IncomingShip;
import gs.sbhh.springbatchhttptohttp.batch.model.OutgoingShip;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ShipController {

    @GetMapping("/api/in/ship")
    public ResponseEntity<IncomingShip> getIncomingShipForBatch() {
        System.out.println("Creating a requested incoming ship object");
        return ResponseEntity.ok(IncomingShip.builder()
                .id(UUID.randomUUID())
                .name("New Orleans")
                .classification("CA")
                .emptyWeight(9950)
                .maxWeight(12463)
                .build());
    }

    @PostMapping("/api/out/ship")
    public ResponseEntity postOutgoingShipFromBatch(@RequestBody List<OutgoingShip> shipList) {
        shipList.forEach(outgoingShip -> outgoingShip.print());
        return ResponseEntity.accepted().build();
    }
}
