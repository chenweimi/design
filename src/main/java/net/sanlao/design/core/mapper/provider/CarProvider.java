package net.sanlao.design.core.mapper.provider;

import net.sanlao.design.core.model.Car;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author : Jimi
 * @date : 2019/05/05
 * @since : Java 11
 */
public class CarProvider {
    public String setProduct(Car car) {
        return new SQL() {
            {
                UPDATE("car");
                if(car.getName() != null) {
                    SET("c_name=#{name}");
                }
                if(car.getNumber() != null) {
                    SET("c_number=#{number}");
                }
                if(car.getStatus() != null) {
                    SET("c_status=#{status}");
                }
                WHERE("c_id=#{systemId}");

            }
        }.toString();
    }

    public String selectByCondition(Integer systemId) {
        return new SQL() {
            {
                SELECT("c_id AS systemId,c_name AS name,c_number AS number,c_status AS status");
                FROM("car");
                if (systemId != 0) {
                    WHERE("c_id=#{systemId}");
                }
            }
        }.toString();
    }
}
