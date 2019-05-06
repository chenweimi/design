package net.sanlao.design.core.model;

/**
 * @author : Jimi
 * @date : 2019/05/04
 * @since : Java 11
 */
public class Finance {
    private Integer systemId;
    private Integer total;
    private Integer current;

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }
}
