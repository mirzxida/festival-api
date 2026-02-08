package com.example.festival.patterns;

import com.example.festival.model.Band;
import com.example.festival.model.Stage;
import com.example.festival.model.Slot;

import java.time.LocalDateTime;

public class SlotBuilder {

    private Band band;
    private Stage stage;
    private LocalDateTime start;
    private LocalDateTime end;

    public SlotBuilder band(Band band) {
        this.band = band;
        return this;
    }

    public SlotBuilder stage(Stage stage) {
        this.stage = stage;
        return this;
    }

    public SlotBuilder start(LocalDateTime start) {
        this.start = start;
        return this;
    }

    public SlotBuilder end(LocalDateTime end) {
        this.end = end;
        return this;
    }

    public Slot build() {
        return new Slot(band, stage, start, end);
    }
}
