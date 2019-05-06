package net.sanlao.design.service;

import net.sanlao.design.common.MyException;
import net.sanlao.design.core.model.vo.DeliveryVo;

import java.util.List;
import java.util.Map;

/**
 * @author : Jimi
 * @date : 2019/05/06
 * @since : Java 11
 */
public interface DeliveryService {

    /**
     * 插入
     * @param deliveryVo
     * @return
     * @throws MyException
     */
    boolean postDelivery(DeliveryVo deliveryVo) throws MyException;

    /**
     * 查询
     *
     * @return 黑名单
     */
    List<Map<String, Object>> getDelivery(int systemId) throws MyException;

    /**
     * 修改
     * @param deliveryVo
     * @return
     */
    boolean updateDelivery(DeliveryVo deliveryVo) throws MyException;

    /**
     * 删除
     * @param systemId
     * @return
     * @throws MyException
     */
    boolean deleteDelivery(int systemId) throws MyException;
}
