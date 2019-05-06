package net.sanlao.design.service;

import net.sanlao.design.common.MyException;
import net.sanlao.design.core.model.vo.DeliveryVo;

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
}
