package net.sanlao.design.service;

import net.sanlao.design.common.MyException;
import net.sanlao.design.core.model.Employee;

import java.util.List;
import java.util.Map;

/**
 * @author : Jimi
 * @date : 2019/05/05
 * @since : Java 11
 */
public interface EmployeeService {

    /**
     * 查询
     *
     * @return 黑名单
     */
    List<Map<String, Object>> getEmployee(int systemId) throws MyException;

    /**
     * 插入
     * @param employee
     * @return
     * @throws MyException
     */
    boolean postEmployee(Employee employee) throws MyException;

    /**
     * 修改
     * @param employee
     * @return
     */
    boolean updateEmployee(Employee employee) throws MyException;

    /**
     * 删除
     * @param systemId
     * @return
     * @throws MyException
     */
    boolean deleteEmployee(int systemId) throws MyException;
}
