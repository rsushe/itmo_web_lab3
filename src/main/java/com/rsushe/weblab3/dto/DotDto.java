package com.rsushe.weblab3.dto;

import lombok.*;

import jakarta.faces.context.FacesContext;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DotDto {
    private double x;
    private double y;
    private double r;
    private boolean hit;
    private double workingTime;
    private LocalDateTime creationDate;

    public LocalDateTime getCreationDate() {
        Integer timezone = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("timezone", 0);
        return creationDate.minusHours(timezone / 60);
    }
}
