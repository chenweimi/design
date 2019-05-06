package net.sanlao.design.core.mapper;

import net.sanlao.design.core.mapper.provider.CarProvider;
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
     * @param deliveryVo
     * @return
     */
    @Insert("INSERT INTO delivery(d_id,client_name,d_thing,d_start,d_end) VALUES(#{systemId},#{clientName},#{things},#{start},#{end})")
    @Options(useGeneratedKeys = true, keyProperty = "systemId")
    int insert(Delivery delivery);

}
