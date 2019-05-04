package net.sanlao.design.core.model;

/**
 * @author : Jimi
 * @date : 2019/05/04
 * @since : Java 11
 */
public class Finance {
    private Integer systemId;
    private String total;
    private String current;

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }
}
