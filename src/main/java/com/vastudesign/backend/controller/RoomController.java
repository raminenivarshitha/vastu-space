package com.vastudesign.backend.controller;

import com.vastudesign.backend.entity.Room;
import com.vastudesign.backend.repository.RoomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomRepository.save(room);
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/project/{projectId}")
    public List<Room> getRoomsByProject(@PathVariable Long projectId) {
        return roomRepository.findByProjectId(projectId);
    }
}