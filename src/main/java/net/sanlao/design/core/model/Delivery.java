package net.sanlao.design.core.model;

import java.util.Date;

/**
 * @author : Jimi
 * @date : 2019/05/04
 * @since : Java 11
 */
public class Delivery {

    private Integer SystemId;
    private String clientName;
    private String things;
    private Date start;
    private Date end;
    private Integer status;
    private String carNumber;
    private Integer eId;

    public Integer getSystemId() {
        return SystemId;
    }

    public void setSystemId(Integer systemId) {
        SystemId = systemId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getThings() {
        return things;
    }

    public void setThings(String things) {
        this.things = things;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }
}
