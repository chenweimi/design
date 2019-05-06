package net.sanlao.design.core.mapper;

import net.sanlao.design.core.mapper.provider.FinanceProvider;
import net.sanlao.design.core.model.Finance;
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
public interface FinanceMapper {
    /**
     * 插入产品
     * @param finance
     * @return
     */
    @Insert("INSERT INTO finance(f_id,f_total) VALUES(#{systemId},#{total})")
    @Options(useGeneratedKeys = true, keyProperty = "systemId")
    int insert(Finance finance);


    /**
     * 筛选全部
     * @return product的集合
     */
    @SelectProvider(type = FinanceProvider.class, method = "selectByCondition")
    List<Finance> selectByCondition(int systemId);

    /**
     * 修改产品
     * @param finance
     * @return
     */
    @UpdateProvider(type = FinanceProvider.class, method = "setFinance")
    int updateBySystemId(Finance finance);

    @Delete("DELETE FROM finance WHERE f_id=#{systemId}")
    int deleteBySystemId(int systemId);

    /**
     * 筛选统计信息
     * @return product的集合
     */
    @SelectProvider(type = FinanceProvider.class, method = "selectStats")
    Finance selectStats();
}
