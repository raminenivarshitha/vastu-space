package com.vastudesign.backend.controller;

import com.vastudesign.backend.entity.RoomOpening;
import com.vastudesign.backend.repository.RoomOpeningRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/openings")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomOpeningController {

    private final RoomOpeningRepository roomOpeningRepository;

    public RoomOpeningController(RoomOpeningRepository roomOpeningRepository) {
        this.roomOpeningRepository = roomOpeningRepository;
    }

    @PostMapping
    public RoomOpening createOpening(@RequestBody RoomOpening roomOpening) {
        return roomOpeningRepository.save(roomOpening);
    }

    @GetMapping
    public List<RoomOpening> getAllOpenings() {
        return roomOpeningRepository.findAll();
    }

    @GetMapping("/room/{roomId}")
    public List<RoomOpening> getOpeningsByRoom(@PathVariable Long roomId) {
        return roomOpeningRepository.findByRoomId(roomId);
    }
}