package net.sanlao.design.service;

import net.sanlao.design.common.MyException;
import net.sanlao.design.core.model.Car;

import java.util.List;
import java.util.Map;

/**
 * @author : Jimi
 * @date : 2019/05/05
 * @since : Java 11
 */
public interface CarService {
    /**
     * 查询
     *
     * @return 黑名单
     */
    List<Map<String, Object>> getCar(int systemId) throws MyException;

    /**
     * 插入
     * @param car
     * @return
     * @throws MyException
     */
    boolean postCar(Car car) throws MyException;

    /**
     * 修改
     * @param car
     * @return
     */
    boolean updateCar(Car car) throws MyException;

    /**
     * 删除
     * @param systemId
     * @return
     * @throws MyException
     */
    boolean deleteCar(int systemId) throws MyException;
}
