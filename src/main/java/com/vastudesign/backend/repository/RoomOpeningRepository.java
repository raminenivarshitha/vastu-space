package com.vastudesign.backend.repository;

import com.vastudesign.backend.entity.RoomOpening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomOpeningRepository extends JpaRepository<RoomOpening, Long> {

    List<RoomOpening> findByRoomId(Long roomId);
}