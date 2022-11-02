package com.rsushe.weblab3;

import com.rsushe.weblab3.beans.DotBean;
import com.rsushe.weblab3.dao.DotDao;
import com.rsushe.weblab3.dto.DotDTO;
import com.rsushe.weblab3.entity.Dot;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.time.*;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name = "service", eager = true)
@ApplicationScoped
@Getter
@Setter
public class Service {
    @ManagedProperty(value = "#{dotDao}")
    private DotDao dotDao;
    private final HitChecker hitChecker;

    public Service() {
        this.hitChecker = new AreaHitChecker();
    }

    public void addNewDot(DotBean dotBean) {
        double start = System.currentTimeMillis();

        double x = dotBean.getX(), y = dotBean.getY(), r = dotBean.getR();
        boolean hit = hitChecker.isPointHit(x, y, r);
        double workingTime = System.currentTimeMillis() - start;
        LocalDateTime currentTime = LocalDateTime.now(ZoneOffset.UTC);

        Dot dot = new Dot(dotBean.getListContainer().getSessionId(), x, y, r, hit,
                LocalDateTime.now(ZoneOffset.UTC), workingTime);
        DotDTO dotDTO = new DotDTO(x, y, r, hit, workingTime, currentTime);

        dotDao.saveDot(dot);
        dotBean.getListContainer().getDotsList().add(dotDTO);
    }
}
