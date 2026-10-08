package com.vastudesign.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "furniture_items")
public class FurnitureItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long roomId;

    private String type;

    private Double xPosition;

    private Double yPosition;

    private Double width;

    private Double depth;

    private Double rotation;

    public FurnitureItem() {
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

    public Double getXPosition() {
        return xPosition;
    }

    public Double getYPosition() {
        return yPosition;
    }

    public Double getWidth() {
        return width;
    }

    public Double getDepth() {
        return depth;
    }

    public Double getRotation() {
        return rotation;
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

    public void setXPosition(Double xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(Double yPosition) {
        this.yPosition = yPosition;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public void setRotation(Double rotation) {
        this.rotation = rotation;
    }
}