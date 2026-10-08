package com.vastudesign.backend.repository;

import com.vastudesign.backend.entity.FurnitureItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FurnitureItemRepository extends JpaRepository<FurnitureItem, Long> {

    List<FurnitureItem> findByRoomId(Long roomId);
}