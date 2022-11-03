package com.rsushe.weblab3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Entity(name = "dots")
@NoArgsConstructor
@Getter
@Setter
public class Dot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String sessionId;

    private Double x;
    private Double y;
    private Double r;
    private boolean hit;
    private LocalDateTime creationDate;
    private double workingTime;

    public Dot(String sessionId, Double x, Double y, Double r, boolean hit, LocalDateTime creationDate, double workingTime) {
        this.sessionId = sessionId;
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
        this.creationDate = creationDate;
        this.workingTime = workingTime;
    }
}
