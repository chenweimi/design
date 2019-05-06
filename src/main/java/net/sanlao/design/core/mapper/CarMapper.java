package net.sanlao.design.core.mapper;

import net.sanlao.design.core.mapper.provider.CarProvider;
import net.sanlao.design.core.model.Car;
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
public interface CarMapper {
    /**
     * 筛选全部
     * @return product的集合
     */
    @SelectProvider(type = CarProvider.class, method = "selectByCondition")
    List<Car> selectByCondition(int systemId);

    /**
     * 插入产品
     * @param car
     * @return
     */
    @Insert("INSERT INTO car(c_id,c_name,c_number) VALUES(#{systemId},#{name},#{number})")
    @Options(useGeneratedKeys = true, keyProperty = "systemId")
    int insert(Car car);

    /**
     * 修改产品
     * @param car
     * @return
     */
    @UpdateProvider(type = CarProvider.class, method = "setCar")
    int updateBySystemId(Car car);

    @Delete("DELETE FROM car WHERE c_id=#{systemId}")
    int deleteBySystemId(int systemId);
}
