package net.sanlao.design.core.mapper.provider;

import net.sanlao.design.core.model.Client;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author : Jimi
 * @date : 2019/05/05
 * @since : Java 11
 */
public class ClientProvider {
    public String setClient(Client client) {
        return new SQL() {
            {
                UPDATE("client");
                if(client.getName() != null) {
                    SET("c_name=#{name}");
                }
                WHERE("c_id=#{systemId}");

            }
        }.toString();
    }

    public String selectByCondition(Integer systemId) {
        return new SQL() {
            {
                SELECT("c_id AS systemId,c_name AS name");
                FROM("client");
                if (systemId != 0) {
                    WHERE("c_id=#{systemId}");
                }
            }
        }.toString();
    }
}
