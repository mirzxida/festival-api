package com.example.festival.service;

import java.util.List;
import com.example.festival.exceptions.InvalidSlotException;
import com.example.festival.exceptions.TimeCollisionException;
import com.example.festival.model.Band;
import com.example.festival.model.Slot;
import com.example.festival.repository.SlotRepository;
import org.springframework.stereotype.Service;



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
}
