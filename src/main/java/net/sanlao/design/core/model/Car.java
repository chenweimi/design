package net.sanlao.design.core.model;

/**
 * @author : Jimi
 * @date : 2019/05/04
 * @since : Java 11
 */
public class Car {

    private Integer systemId;
    private String name;
    private String number;
    private Integer status;

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
