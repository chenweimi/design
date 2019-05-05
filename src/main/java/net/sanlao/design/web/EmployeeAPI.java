package net.sanlao.design.web;

import net.sanlao.design.common.MyException;
import net.sanlao.design.common.RestData;
import net.sanlao.design.common.util.JsonUtil;
import net.sanlao.design.core.model.Employee;
import net.sanlao.design.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author : Jimi
 * @date : 2019/05/05
 * @since : Java 11
 */
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class EmployeeAPI {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeAPI(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/employee/{systemId}", method = RequestMethod.GET)
    public RestData getEmployee(@PathVariable(value = "systemId") int systemId) {
        logger.info("get getEmployee : " + systemId);
        System.out.println(systemId);
        try {
            List<Map<String, Object>> data = employeeService.getEmployee(systemId);
            return new RestData(data);
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public RestData postEmployee(@RequestBody Employee employee) {
        logger.info("POST postEmployee : " + JsonUtil.getJsonString(employee));

        try {
            return new RestData(employeeService.postEmployee(employee));
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public RestData putEmployee(@RequestBody Employee employee) {
        logger.info("PUT putEmployee : ");

        try {
            return new RestData(employeeService.updateEmployee(employee));
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }

    }

    @RequestMapping(value = "/employee/{systemId}", method = RequestMethod.DELETE)
    public RestData deleteEmployee(@PathVariable(value = "systemId") int systemId) {
        logger.info("DELETE deleteEmployee : studentId = " + systemId);

        try {
            return new RestData(employeeService.deleteEmployee(systemId));
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }
}
