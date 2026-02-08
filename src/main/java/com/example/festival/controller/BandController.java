package com.example.festival.controller;
import com.example.festival.model.Band;
import com.example.festival.service.FestivalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BandController {

    private final FestivalService service;

    public BandController(FestivalService service) {
        this.service = service;
    }

    @GetMapping("/bands")
    public List<Band> getAllBands() {
        return service.getAllBands();
    }
}
