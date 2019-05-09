package net.sanlao.design.core.mapper;

import net.sanlao.design.core.mapper.provider.CarProvider;
import net.sanlao.design.core.mapper.provider.DeliveryProvider;
import net.sanlao.design.core.model.Delivery;
import net.sanlao.design.core.model.vo.DeliveryVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Jimi
 * @date : 2019/05/06
 * @since : Java 11
 */
@Mapper
@Repository
public interface DeliveryMapper {


    /**
     * 插入产品
     * @param delivery
     * @return
     */
    @Insert("INSERT INTO delivery(d_id,client_id,d_thing,d_start,d_end) VALUES(#{systemId},#{clientId},#{things},#{start},#{end})")
    @Options(useGeneratedKeys = true, keyProperty = "systemId")
    int insert(Delivery delivery);

    /**
     * 筛选全部
     * @return product的集合
     */
    @SelectProvider(type = DeliveryProvider.class, method = "selectByCondition")
    List<Delivery> selectByCondition(int systemId);

    /**
     * 修改产品
     * @param delivery
     * @return
     */
    @UpdateProvider(type = DeliveryProvider.class, method = "setDelivery")
    int updateBySystemId(Delivery delivery);

    @Delete("DELETE FROM delivery WHERE d_id=#{systemId}")
    int deleteBySystemId(int systemId);


    /**
     * 筛选部分
     * @return product的集合
     */
    @SelectProvider(type = DeliveryProvider.class, method = "selectByConditionByEId")
    List<Delivery> selectByEId(DeliveryVo deliveryVo);
}
