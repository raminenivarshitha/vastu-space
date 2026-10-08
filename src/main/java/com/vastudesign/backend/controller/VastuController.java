package com.vastudesign.backend.controller;

import com.vastudesign.backend.entity.FurnitureItem;
import com.vastudesign.backend.entity.Room;
import com.vastudesign.backend.entity.RoomOpening;
import com.vastudesign.backend.repository.FurnitureItemRepository;
import com.vastudesign.backend.repository.RoomOpeningRepository;
import com.vastudesign.backend.repository.RoomRepository;
import com.vastudesign.backend.vastu.LivingRoomVastuAnalyzer;
import com.vastudesign.backend.vastu.LivingRoomVastuReport;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vastu")
@CrossOrigin(origins = "http://localhost:4200")
public class VastuController {

    private final FurnitureItemRepository furnitureItemRepository;
    private final RoomRepository roomRepository;
    private final RoomOpeningRepository roomOpeningRepository;

    public VastuController(
            FurnitureItemRepository furnitureItemRepository,
            RoomRepository roomRepository,
            RoomOpeningRepository roomOpeningRepository
    ) {
        this.furnitureItemRepository = furnitureItemRepository;
        this.roomRepository = roomRepository;
        this.roomOpeningRepository = roomOpeningRepository;
    }

    @GetMapping("/living-room/{roomId}")
    public LivingRoomVastuReport analyzeLivingRoom(
            @PathVariable Long roomId
    ) {

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        List<FurnitureItem> furniture =
                furnitureItemRepository.findByRoomId(roomId);

        List<RoomOpening> openings =
                roomOpeningRepository.findByRoomId(roomId);

        LivingRoomVastuAnalyzer analyzer =
                new LivingRoomVastuAnalyzer();

        return analyzer.analyze(
                room,
                furniture,
                openings
        );
    }
}