package com.example.festival.model;

import java.time.LocalDateTime;

public class Slot {
    private Band band;
    private Stage stage;
    private LocalDateTime start;
    private LocalDateTime end;

    public Slot(Band band, Stage stage, LocalDateTime start, LocalDateTime end){
        this.band = band;
        this.stage = stage;
        this.start = start;
        this.end = end;
    }

    public boolean overlap(Slot other){
        return start.isBefore(other.end) && end.isAfter(other.start);
    }

    public Band getBand() {
        return band;
    }

    public Stage getStage() {
        return stage;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }
}


