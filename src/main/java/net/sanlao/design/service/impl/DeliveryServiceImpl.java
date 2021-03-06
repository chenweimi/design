package net.sanlao.design.service.impl;

import net.sanlao.design.common.MyException;
import net.sanlao.design.common.util.JsonUtil;
import net.sanlao.design.core.mapper.DeliveryMapper;
import net.sanlao.design.core.mapper.EmployeeMapper;
import net.sanlao.design.core.mapper.FinanceMapper;
import net.sanlao.design.core.mapper.ProductMapper;
import net.sanlao.design.core.model.Delivery;
import net.sanlao.design.core.model.Employee;
import net.sanlao.design.core.model.Finance;
import net.sanlao.design.core.model.Product;
import net.sanlao.design.core.model.vo.DeliveryVo;
import net.sanlao.design.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private final EmployeeMapper employeeMapper;

    @Autowired
    public DeliveryServiceImpl(DeliveryMapper deliveryMapper, FinanceMapper financeMapper, ProductMapper productMapper, EmployeeMapper employeeMapper) {
        this.deliveryMapper = deliveryMapper;
        this.financeMapper = financeMapper;
        this.productMapper = productMapper;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public boolean postDelivery(DeliveryVo deliveryVo) throws MyException {

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
        delivery.setClientId(deliveryVo.getClientId());
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

    @Override
    public List<Map<String, Object>> getDelivery(int systemId) throws MyException {

        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat ("yyyy-MM-dd");




        List<Map<String, Object>> rtv = new ArrayList<>();
        List<Delivery> deliveries = deliveryMapper.selectByCondition(systemId);
        if (deliveries.size() == 0) {
            throw new MyException("查询失败");
        } else {
            for (Delivery delivery : deliveries) {
                Map<String,Object> map = new HashMap<>(8);
                map.put("systemId",delivery.getSystemId());
                map.put("clientId",delivery.getClientId());
                map.put("things",JsonUtil.getObjFromJson(delivery.getThings(), Product[].class));
                map.put("start", formatter.format(delivery.getStart()));
                map.put("end",formatter.format(delivery.getEnd()));
                map.put("status",delivery.getStatus());
                map.put("carId",delivery.getCarId());
                map.put("eId",delivery.geteId());


                List<Finance> finances = financeMapper.selectByCondition(delivery.getSystemId());
                map.put("money",finances.get(0).getTotal());

                rtv.add(map);
            }
        }


        return rtv;
    }

    @Override
    public boolean updateDelivery(DeliveryVo deliveryVo) throws MyException {

        Delivery delivery = new Delivery();
        delivery.setSystemId(deliveryVo.getSystemId());
        delivery.setClientId(deliveryVo.getClientId());
        delivery.setStart(deliveryVo.getStart());
        delivery.setEnd(deliveryVo.getEnd());
        delivery.setThings(JsonUtil.getJsonString(deliveryVo.getThings()));
        delivery.setStatus(deliveryVo.getStatus());
        delivery.setCarId(deliveryVo.getCarId());
        delivery.seteId(deliveryVo.geteId());

        Finance finance = new Finance();
        finance.setSystemId(deliveryVo.getSystemId());
        finance.setTotal(deliveryVo.getMoney());

        int i = deliveryMapper.updateBySystemId(delivery);
        int j = financeMapper.updateBySystemId(finance);

        if(i == 0 || j == 0) {
            throw new MyException("修改失败");
        }

        return true;

    }

    @Override
    public boolean deleteDelivery(int systemId) throws MyException {
        int i = deliveryMapper.deleteBySystemId(systemId);
        int j = financeMapper.deleteBySystemId(systemId);

        if(i == 0 || j == 0) {
            throw new MyException("删除失败");
        }

        return true;
    }

    @Override
    public List<Map<String, Object>> getDeliveryByEId(DeliveryVo deliveryVo) throws MyException {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat ("yyyy-MM-dd");


        List<Map<String, Object>> rtv = new ArrayList<>();
        List<Delivery> deliveries = deliveryMapper.selectByEId(deliveryVo);
        if (deliveries.size() == 0) {
            throw new MyException("查询失败");
        } else {
            for (Delivery delivery : deliveries) {
                Map<String,Object> map = new HashMap<>(8);
                map.put("systemId",delivery.getSystemId());
                map.put("clientId",delivery.getClientId());
                map.put("things",JsonUtil.getObjFromJson(delivery.getThings(), Product[].class));
                map.put("start", formatter.format(delivery.getStart()));
                map.put("end",formatter.format(delivery.getEnd()));
                map.put("status",delivery.getStatus());
                map.put("carId",delivery.getCarId());
                map.put("eId",delivery.geteId());


                List<Finance> finances = financeMapper.selectByCondition(delivery.getSystemId());
                map.put("money",finances.get(0).getTotal());

                rtv.add(map);
            }
        }


        return rtv;
    }
}
