package net.sanlao.design.core.mapper;

import net.sanlao.design.core.model.Finance;
import net.sanlao.design.core.model.vo.DeliveryVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

/**
 * @author : Jimi
 * @date : 2019/05/06
 * @since : Java 11
 */
@Mapper
@Repository
public interface FinanceMapper {
    /**
     * 插入产品
     * @param deliveryVo
     * @return
     */
    @Insert("INSERT INTO finance(f_id,f_total) VALUES(#{systemId},#{total})")
    @Options(useGeneratedKeys = true, keyProperty = "systemId")
    int insert(Finance finance);

}
