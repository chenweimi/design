package net.sanlao.design.service.impl;

import net.sanlao.design.common.MyException;
import net.sanlao.design.core.model.vo.DeliveryVo;
import net.sanlao.design.service.FinanceService;
import org.springframework.stereotype.Service;

/**
 * @author : Jimi
 * @date : 2019/05/06
 * @since : Java 11
 */
@Service
public class FinanceImpl implements FinanceService {
    @Override
    public boolean postFinance(DeliveryVo deliveryVo) throws MyException {
        return false;
    }
}
