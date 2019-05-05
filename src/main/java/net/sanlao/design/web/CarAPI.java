package net.sanlao.design.web;

import net.sanlao.design.common.MyException;
import net.sanlao.design.common.RestData;
import net.sanlao.design.common.util.JsonUtil;
import net.sanlao.design.core.model.Car;
import net.sanlao.design.service.CarService;
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
public class CarAPI {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CarService carService;

    @Autowired
    public CarAPI(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/car/{systemId}", method = RequestMethod.GET)
    public RestData getCar(@PathVariable(value = "systemId") int systemId) {
        logger.info("get getProduct : " + systemId);
        System.out.println(systemId);
        try {
            List<Map<String, Object>> data = carService.getCar(systemId);
            return new RestData(data);
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public RestData postCar(@RequestBody Car car) {
        logger.info("POST postProduct : " + JsonUtil.getJsonString(car));

        try {
            return new RestData(carService.postCar(car));
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }

    @RequestMapping(value = "/car", method = RequestMethod.PUT)
    public RestData putCar(@RequestBody Car car) {
        logger.info("PUT putProduct : ");

        try {
            return new RestData(carService.updateCar(car));
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }

    }

    @RequestMapping(value = "/car/{systemId}", method = RequestMethod.DELETE)
    public RestData deleteCar(@PathVariable(value = "systemId") int systemId) {
        logger.info("DELETE deleteCar : studentId = " + systemId);

        try {
            return new RestData(carService.deleteCar(systemId));
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }
}
