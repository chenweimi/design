package net.sanlao.design.core.mapper.provider;

import net.sanlao.design.core.model.Employee;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author : Jimi
 * @date : 2019/05/05
 * @since : Java 11
 */
public class EmployeeProvider {

    public String setEmployee(Employee employee) {
        return new SQL() {
            {
                UPDATE("employee");
                if(employee.getName() != null) {
                    SET("e_name=#{name}");
                }
                if(employee.getSex() != null) {
                    SET("e_sex=#{sex}");
                }
                if(employee.getPosition() != null) {
                    SET("e_position=#{position}");
                }
                if(employee.getComment() != null) {
                    SET("e_comment=#{comment}");
                }
                WHERE("e_id=#{systemId}");

            }
        }.toString();
    }

    public String selectByCondition(Integer systemId) {
        return new SQL() {
            {
                SELECT("e_id AS systemId,e_name AS name,e_sex AS sex,e_position AS position,e_comment AS comment");
                FROM("employee");
                if (systemId != 0) {
                    WHERE("e_id=#{systemId}");
                }
            }
        }.toString();
    }
}
