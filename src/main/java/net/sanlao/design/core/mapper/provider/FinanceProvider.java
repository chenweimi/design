package net.sanlao.design.core.mapper.provider;

import net.sanlao.design.core.model.Finance;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author : Jimi
 * @date : 2019/05/06
 * @since : Java 11
 */
public class FinanceProvider {
    public String setFinance(Finance finance) {
        return new SQL() {
            {
                UPDATE("finance");
                if(finance.getTotal() != null) {
                    SET("f_total=#{total}");
                }
                if(finance.getCurrent() != null) {
                    SET("f_current=#{current}");
                }
                WHERE("f_id=#{systemId}");

            }
        }.toString();
    }

    public String selectByCondition(Integer systemId) {
        return new SQL() {
            {
                SELECT("f_id AS systemId,f_total AS total, f_current AS current");
                FROM("finance");
                if (systemId != 0) {
                    WHERE("f_id=#{systemId}");
                }
            }
        }.toString();
    }

    public String selectStats() {
        return new SQL() {
            {
                SELECT("sum(f_total) AS total,sum(f_current) AS current");
                FROM("finance");
            }
        }.toString();
    }
}
