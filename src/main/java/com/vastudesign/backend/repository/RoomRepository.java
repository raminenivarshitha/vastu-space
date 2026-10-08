package com.vastudesign.backend.repository;

import com.vastudesign.backend.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByProjectId(Long projectId);
}