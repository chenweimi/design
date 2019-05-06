package net.sanlao.design.service.impl;

import net.sanlao.design.common.MyException;
import net.sanlao.design.common.util.JsonUtil;
import net.sanlao.design.core.mapper.DeliveryMapper;
import net.sanlao.design.core.mapper.FinanceMapper;
import net.sanlao.design.core.mapper.ProductMapper;
import net.sanlao.design.core.model.Delivery;
import net.sanlao.design.core.model.Finance;
import net.sanlao.design.core.model.Product;
import net.sanlao.design.core.model.vo.DeliveryVo;
import net.sanlao.design.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Jimi
 * @date : 2019/05/06
 * @since : Java 11
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryMapper deliveryMapper;
    private final FinanceMapper financeMapper;
    private final ProductMapper productMapper;

    @Autowired
    public DeliveryServiceImpl(DeliveryMapper deliveryMapper,FinanceMapper financeMapper,ProductMapper productMapper) {
        this.deliveryMapper = deliveryMapper;
        this.financeMapper = financeMapper;
        this.productMapper = productMapper;
    }

    @Override
    public boolean postDelivery(DeliveryVo deliveryVo) throws MyException {

        //List<Product> things = JsonUtil.getObjFromJson(deliveryVo.getThings(),List.class);

        Product[] things = deliveryVo.getThings();

        for (Product product : things) {
            System.out.println(product.getCount());

            int systemId = product.getSystemId();
            List<Product> productList = productMapper.selectByCondition(systemId);
            productList.get(0).setCount(productList.get(0).getCount()-product.getCount());

            System.out.println("productList.get(0).getCount()" + productList.get(0).getCount());
            productMapper.updateBySystemId(productList.get(0));
        }

        Delivery delivery = new Delivery();
        delivery.setSystemId(deliveryVo.getSystemId());
        delivery.setClientName(deliveryVo.getClientName());
        delivery.setStart(deliveryVo.getStart());
        delivery.setEnd(deliveryVo.getEnd());
        delivery.setThings(JsonUtil.getJsonString(deliveryVo.getThings()));

        Finance finance = new Finance();
        finance.setSystemId(deliveryVo.getSystemId());
        finance.setTotal(deliveryVo.getMoney());

        int i = deliveryMapper.insert(delivery);
        int j = financeMapper.insert(finance);
        if(i == 0 || j == 0) {
            throw new MyException("插入失败");
        }

        return true;

    }
}
