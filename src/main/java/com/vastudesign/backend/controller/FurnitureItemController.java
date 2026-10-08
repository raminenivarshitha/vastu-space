package com.vastudesign.backend.controller;

import com.vastudesign.backend.entity.FurnitureItem;
import com.vastudesign.backend.repository.FurnitureItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/furniture")
@CrossOrigin(origins = "http://localhost:4200")
public class FurnitureItemController {

    private final FurnitureItemRepository furnitureItemRepository;

    public FurnitureItemController(FurnitureItemRepository furnitureItemRepository) {
        this.furnitureItemRepository = furnitureItemRepository;
    }

    @PostMapping
    public FurnitureItem createFurnitureItem(@RequestBody FurnitureItem furnitureItem) {
        return furnitureItemRepository.save(furnitureItem);
    }

    @GetMapping
    public List<FurnitureItem> getAllFurnitureItems() {
        return furnitureItemRepository.findAll();
    }

    @GetMapping("/room/{roomId}")
    public List<FurnitureItem> getFurnitureByRoom(@PathVariable Long roomId) {
        return furnitureItemRepository.findByRoomId(roomId);
    }
}