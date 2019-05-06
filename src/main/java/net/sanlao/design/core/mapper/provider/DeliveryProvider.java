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
                if(delivery.getClientName() != null) {
                    SET("client_name=#{clientName}");
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
                if(delivery.getCarNumber() != null) {
                    SET("car_number=#{carNumber}");
                }
                if(delivery.getEmployeeName() != null) {
                    SET("e_name=#{employeeName}");
                }
                WHERE("d_id=#{systemId}");

            }
        }.toString();
    }

    public String selectByCondition(Integer systemId) {
        return new SQL() {
            {
                SELECT("d_id AS systemId,client_name AS clientName,d_thing AS things,d_start AS start," +
                        "d_end AS end,d_status AS status,car_number AS carNumber,e_name AS employeeName");
                FROM("delivery");
                if (systemId != 0) {
                    WHERE("d_id=#{systemId}");
                }
            }
        }.toString();
    }
}
