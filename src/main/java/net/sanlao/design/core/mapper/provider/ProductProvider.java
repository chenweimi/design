package net.sanlao.design.core.mapper.provider;

import net.sanlao.design.core.model.Product;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author : Jimi
 * @date : 2019/05/04
 * @since : Java 11
 */
public class ProductProvider {
    public String setProduct(Product product) {
        return new SQL() {
            {
                UPDATE("product");
                if(product.getName() != null) {
                    SET("p_name=#{name}");
                }
                if(product.getCount() != null) {
                    SET("p_count=#{count}");
                }
                WHERE("p_id=#{systemId}");

            }
        }.toString();
    }

    public String selectByCondition(Integer systemId) {
        return new SQL() {
            {
               SELECT("p_id AS systemId,p_name AS name,p_count AS count");
               FROM("product");
               if (systemId != 0) {
                   WHERE("p_id=#{systemId}");
               }
            }
        }.toString();
    }
}
