package net.sanlao.design.core.model;

/**
 * @author : Jimi
 * @date : 2019/05/02
 * @since : Java 11
 */
public class Product {
    private Integer SystemId;
    private String name;
    private Integer count;

    public Integer getSystemId() {
        return SystemId;
    }

    public void setSystemId(Integer systemId) {
        SystemId = systemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
