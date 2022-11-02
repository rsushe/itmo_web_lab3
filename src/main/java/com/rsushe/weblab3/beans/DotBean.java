package com.rsushe.weblab3.beans;

import com.rsushe.weblab3.Service;
import lombok.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
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

//        PrimeFaces.current().ajax().addCallbackParam("x", this.x);
//        PrimeFaces.current().ajax().addCallbackParam("y", this.y);
//        PrimeFaces.current().ajax().addCallbackParam("r", this.r);
//        PrimeFaces.current().ajax().addCallbackParam("hit", this.hit);
    }
}
