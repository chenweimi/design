package net.sanlao.design.core.model.vo;

import net.sanlao.design.core.model.Product;

import java.util.Date;
import java.util.List;

/**
 * @author : Jimi
 * @date : 2019/05/06
 * @since : Java 11
 */
public class DeliveryVo {
    private Integer SystemId;
    private String clientName;
    private Product[] things;
    private Date start;
    private Date end;
    private Integer money;
    private Integer status;
    private String carNumber;
    private String employeeName;

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

    public Product[] getThings() {
        return things;
    }

    public void setThings(Product[] things) {
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

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}