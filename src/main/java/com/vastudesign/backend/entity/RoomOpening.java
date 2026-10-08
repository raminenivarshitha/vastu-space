package com.vastudesign.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "room_openings")
public class RoomOpening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long roomId;

    private String type;

    private String wall;

    private Double position;

    private Double width;

    public RoomOpening() {
    }

    public Long getId() {
        return id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public String getType() {
        return type;
    }

    public String getWall() {
        return wall;
    }

    public Double getPosition() {
        return position;
    }

    public Double getWidth() {
        return width;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public void setPosition(Double position) {
        this.position = position;
    }

    public void setWidth(Double width) {
        this.width = width;
    }
}