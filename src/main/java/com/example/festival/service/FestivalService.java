package com.example.festival.service;

import java.util.List;
import com.example.festival.exceptions.InvalidSlotException;
import com.example.festival.exceptions.TimeCollisionException;
import com.example.festival.model.Band;
import com.example.festival.model.Slot;
import com.example.festival.model.Stage;
import com.example.festival.dto.CreateSlotRequest;
import com.example.festival.repository.SlotRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
public class FestivalService {
    private final SlotRepository repo;

    public FestivalService(SlotRepository slotRepo) {
        this.repo = slotRepo;
    }

    public void scheduleSlot(Slot slot)
            throws Exception {

        if (!slot.getBand().isValid())
            throw new InvalidSlotException("Invalid band");

        if (repo.hasTimeCollision(
                slot.getStage().getId(),
                slot.getStart(),
                slot.getEnd())) {

            throw new TimeCollisionException(
                    "Stage time collision");
        }

        System.out.println("Slot scheduled successfully");
    }

    public String evaluateStageRisk(int capacity, int slotCount) {
        if (capacity >= 5000 && slotCount > 3)
            return "HIGH RISK";
        return "NORMAL";
    }

    public List<Band> getAllBands() {
        return repo.findAllBands();
    }

    public void scheduleSlotFromRequest(CreateSlotRequest req) throws Exception {
        Band band = repo.findBandById(req.bandId);
        if (band == null) throw new InvalidSlotException("Band not found: " + req.bandId);

        Stage stage = repo.findStageById(req.stageId);
        if (stage == null) throw new InvalidSlotException("Stage not found: " + req.stageId);

        LocalDateTime start = LocalDateTime.parse(req.start);
        LocalDateTime end = LocalDateTime.parse(req.end);

        Slot slot = new Slot(band, stage, start, end);

        scheduleSlot(slot);
    }
}
