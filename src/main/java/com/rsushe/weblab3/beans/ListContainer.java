package com.rsushe.weblab3.beans;

import com.rsushe.weblab3.dto.DotDTO;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class ListContainer {
    private final String sessionId;
    private final List<DotDTO> dotsList;

    public ListContainer() {
        FacesContext fCtx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
        this.sessionId = session.getId();
        this.dotsList = new LinkedList<>();
    }
}
