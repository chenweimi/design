package net.sanlao.design.core.mapper;

import net.sanlao.design.core.mapper.provider.EmployeeProvider;
import net.sanlao.design.core.model.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Jimi
 * @date : 2019/05/05
 * @since : Java 11
 */
@Mapper
@Repository
public interface EmployeeMapper {


    /**
     * 筛选全部
     * @return product的集合
     */
    @SelectProvider(type = EmployeeProvider.class, method = "selectByCondition")
    List<Employee> selectByCondition(int systemId);

    /**
     * 插入产品
     * @param employee
     * @return
     */
    @Insert("INSERT INTO employee(e_id,e_name,e_sex,e_position,e_comment) VALUES(#{systemId},#{name},#{sex},#{position},#{comment})")
    @Options(useGeneratedKeys = true, keyProperty = "systemId")
    int insert(Employee employee);

    /**
     * 修改产品
     * @param employee
     * @return
     */
    @UpdateProvider(type = EmployeeProvider.class, method = "setEmployee")
    int updateBySystemId(Employee employee);

    @Delete("DELETE FROM employee WHERE e_id=#{systemId}")
    int deleteBySystemId(int systemId);
}
