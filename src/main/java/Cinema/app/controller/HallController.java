package Cinema.app.controller;


import Cinema.app.dto.CreateHallRequest;
import Cinema.app.dto.HallDto;
import Cinema.app.dto.UpdateHallRequest;
import Cinema.app.service.HallService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/saloon")
public class HallController {

    private final HallService hallService;

    public HallController(HallService hallService) {
        this.hallService = hallService;
    }

    @PostMapping
    public ResponseEntity<HallDto> createHall(@RequestBody CreateHallRequest createSaloonRequest){
        return ResponseEntity.ok(hallService.createHall(createSaloonRequest));
    }

    @GetMapping
    public ResponseEntity<List<HallDto>> getAllHalls(){
        return ResponseEntity.ok(hallService.getAllHall());
    }

    @GetMapping("/{saloonId}")
    public ResponseEntity<HallDto> getHallById(@PathVariable String saloonId){
        return ResponseEntity.ok(hallService.getHallById(saloonId));
    }

    @PutMapping("/{saloonId}")
    public ResponseEntity<HallDto> updateHall(@PathVariable String saloonId,
                                                @RequestBody UpdateHallRequest updateSaloonRequest){
        return ResponseEntity.ok(hallService.updateHall(saloonId, updateSaloonRequest));
    }

    @DeleteMapping("/{saloonId}")
    public ResponseEntity<Void> deleteHall(@PathVariable String saloonId){
        hallService.deleteHall(saloonId);
        return ResponseEntity.ok().build();
    }
}