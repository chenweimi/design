package net.sanlao.design.service;

import net.sanlao.design.common.MyException;
import net.sanlao.design.core.model.Finance;
import net.sanlao.design.core.model.vo.DeliveryVo;

import java.util.List;
import java.util.Map;

/**
 * @author : Jimi
 * @date : 2019/05/06
 * @since : Java 11
 */
public interface FinanceService {


    /**
     * 查询
     *
     * @return
     */
    List<Map<String, Object>> getFinance(int systemId) throws MyException;

    /**
     * 修改
     * @param finance
     * @return
     */
    boolean updateFinance(Finance finance) throws MyException;


    /**
     * 查询统计
     *
     * @return
     */
    Map<String,Object> getStats() throws MyException;

}
