package com.rsushe.weblab3.beans;

import com.rsushe.weblab3.Service;
import lombok.*;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ManagedProperty;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean(name = "dotBean")
@RequestScoped
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DotBean implements Serializable {

    private Double x;
    private Double y;
    private Double r;
    private Integer timezone;

    @ManagedProperty(value = "#{service}")
    private Service service;

    @ManagedProperty(value = "#{listContainer}")
    private ListContainer listContainer;

    public void processRequest() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("timezone", timezone);
        System.out.println(this);
        service.addNewDot(this);
    }
}
