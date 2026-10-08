package com.vastudesign.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long projectId;

    private String roomType;

    private Double length;

    private Double width;

    private String northDirection;

    public Room() {
    }

    public Long getId() {
        return id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public String getRoomType() {
        return roomType;
    }

    public Double getLength() {
        return length;
    }

    public Double getWidth() {
        return width;
    }

    public String getNorthDirection() {
        return northDirection;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public void setNorthDirection(String northDirection) {
        this.northDirection = northDirection;
    }
}