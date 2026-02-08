package com.example.festival.controller;
import com.example.festival.dto.CreateSlotRequest;
import com.example.festival.service.FestivalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/slots")
public class SlotController {
    private final FestivalService service;
    public SlotController(FestivalService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateSlotRequest req) throws Exception {
        service.scheduleSlotFromRequest(req);
        return ResponseEntity.ok("Slot scheduled successfully");
    }
}
