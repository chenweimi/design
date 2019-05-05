package net.sanlao.design.service.impl;

import net.sanlao.design.common.MyException;
import net.sanlao.design.core.mapper.EmployeeMapper;
import net.sanlao.design.core.model.Employee;
import net.sanlao.design.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Jimi
 * @date : 2019/05/05
 * @since : Java 11
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<Map<String, Object>> getEmployee(int systemId) throws MyException {
        List<Map<String, Object>> rtv = new ArrayList<>();
        List<Employee> employees = employeeMapper.selectByCondition(systemId);
        if (employees.size() == 0) {
            throw new MyException("查询失败");
        } else {
            for (Employee employee : employees) {
                Map<String,Object> map = new HashMap<>(5);
                map.put("systemId",employee.getSystemId());
                map.put("name",employee.getName());
                map.put("sex",employee.getSex());
                map.put("position",employee.getPosition());
                map.put("comment",employee.getComment());
                rtv.add(map);
            }
        }
        return rtv;
    }

    @Override
    public boolean postEmployee(Employee employee) throws MyException {
        int i =  employeeMapper.insert(employee);
        if (i == 0) {
            throw new MyException("插入失败");
        }
        return true;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws MyException {
        int i =  employeeMapper.updateBySystemId(employee);
        if (i == 0) {
            throw new MyException("插入失败");
        }
        return true;
    }

    @Override
    public boolean deleteEmployee(int systemId) throws MyException {
        int i =  employeeMapper.deleteBySystemId(systemId);
        if (i == 0) {
            throw new MyException("删除失败");
        }
        return true;
    }
}
