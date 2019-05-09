package net.sanlao.design.core.mapper.provider;

import net.sanlao.design.core.model.Delivery;
import net.sanlao.design.core.model.vo.DeliveryVo;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author : Jimi
 * @date : 2019/05/06
 * @since : Java 11
 */
public class DeliveryProvider {

    public String setDelivery(Delivery delivery) {
        return new SQL() {
            {
                UPDATE("delivery");
                if(delivery.getClientId() != null) {
                    SET("client_id=#{clientId}");
                }
                if(delivery.getThings() != null) {
                    SET("d_thing=#{things}");
                }
                if(delivery.getStart() != null) {
                    SET("d_start=#{start}");
                }
                if(delivery.getEnd() != null) {
                    SET("d_end=#{end}");
                }
                if(delivery.getStatus() != null) {
                    SET("d_status=#{status}");
                }
                if(delivery.getCarId() != null) {
                    SET("car_id=#{carId}");
                }
                if(delivery.geteId() != null) {
                    SET("e_id=#{eId}");
                }
                WHERE("d_id=#{systemId}");

            }
        }.toString();
    }

    public String selectByCondition(Integer systemId) {
        return new SQL() {
            {
                SELECT("d_id AS systemId,client_id AS clientId,d_thing AS things,d_start AS start," +
                        "d_end AS end,d_status AS status,car_id AS carId,e_id AS eId");
                FROM("delivery");
                if (systemId != 0) {
                    WHERE("d_id=#{systemId}");
                }
            }
        }.toString();
    }

    public String selectByConditionByEId(DeliveryVo deliveryVo) {
        return new SQL() {
            {
                SELECT("d_id AS systemId,client_id AS clientId,d_thing AS things,d_start AS start," +
                        "d_end AS end,d_status AS status,car_id AS carId,e_id AS eId");
                FROM("delivery");
                WHERE("e_id=#{eId}");

            }
        }.toString();
    }


}
