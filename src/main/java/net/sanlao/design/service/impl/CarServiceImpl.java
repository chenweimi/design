package net.sanlao.design.service.impl;

import net.sanlao.design.common.MyException;
import net.sanlao.design.core.mapper.CarMapper;
import net.sanlao.design.core.model.Car;
import net.sanlao.design.service.CarService;
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
public class CarServiceImpl implements CarService {


    private final CarMapper carMapper;

    @Autowired
    public CarServiceImpl(CarMapper carMapper) {
        this.carMapper = carMapper;
    }


    @Override
    public List<Map<String, Object>> getCar(int systemId) throws MyException {
        List<Map<String, Object>> rtv = new ArrayList<>();
        List<Car> cars = carMapper.selectByCondition(systemId);
        if (cars.size() == 0) {
            throw new MyException("查询失败");
        } else {
            for (Car car : cars) {
                Map<String,Object> map = new HashMap<>(4);
                map.put("systemId",car.getSystemId());
                map.put("name",car.getName());
                map.put("number",car.getNumber());
                map.put("status",car.getStatus());
                rtv.add(map);
            }
        }
        return rtv;
    }

    @Override
    public boolean postCar(Car car) throws MyException {
        int i =  carMapper.insert(car);
        if (i == 0) {
            throw new MyException("插入失败");
        }
        return true;
    }

    @Override
    public boolean updateCar(Car car) throws MyException {
        int i =  carMapper.updateBySystemId(car);
        if (i == 0) {
            throw new MyException("插入失败");
        }
        return true;
    }

    @Override
    public boolean deleteCar(int systemId) throws MyException {
        int i =  carMapper.deleteBySystemId(systemId);
        if (i == 0) {
            throw new MyException("删除失败");
        }
        return true;
    }
}
