/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bamdule.memorymap.model.entity.place;

import java.time.LocalDateTime;

/**
 *
 * @author MW
 */
public class Place {

    private Integer id;
    private String title;
    private String description;
    private double x;
    private double y;
    private Integer order;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
    private LocalDateTime travelDt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public LocalDateTime getCreateDt() {
        return createDt;
    }

    public void setCreateDt(LocalDateTime createDt) {
        this.createDt = createDt;
    }

    public LocalDateTime getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(LocalDateTime updateDt) {
        this.updateDt = updateDt;
    }

    public LocalDateTime getTravelDt() {
        return travelDt;
    }

    public void setTravelDt(LocalDateTime travelDt) {
        this.travelDt = travelDt;
    }

    @Override
    public String toString() {
        return "Place{" + "id=" + id + ", title=" + title + ", description=" + description + ", x=" + x + ", y=" + y + ", order=" + order + ", createDt=" + createDt + ", updateDt=" + updateDt + ", travelDt=" + travelDt + '}';
    }

}
