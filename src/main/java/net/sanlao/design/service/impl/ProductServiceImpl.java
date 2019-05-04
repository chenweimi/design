package net.sanlao.design.service.impl;

import net.sanlao.design.common.MyException;
import net.sanlao.design.core.mapper.ProductMapper;
import net.sanlao.design.core.model.Product;
import net.sanlao.design.service.ProductService;
import org.apache.tomcat.jni.Proc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Jimi
 * @date : 2019/05/04
 * @since : Java 11
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }


    @Override
    public List<Map<String, Object>> getProduct(int systemId) throws MyException {
        List<Map<String, Object>> rtv = new ArrayList<>();
        List<Product> products = productMapper.selectByCondition(systemId);
        if (products != null || products.size() == 0) {
            throw new MyException("查询失败");
        } else {
            for (Product product : products) {
                Map<String,Object> map = new HashMap<>(3);
               map.put("id",product.getSystemId());
               map.put("name",product.getName());
               map.put("count",product.getCount());
               rtv.add(map);
            }
        }
        return rtv;
    }

    @Override
    public boolean postProduct(Product product) throws MyException {
       int i =  productMapper.insert(product);
       if (i == 0) {
           throw new MyException("插入失败");
       }
       return true;

    }

    @Override
    public boolean updateProduct(Product product) throws MyException {
        int i =  productMapper.updateBySystemId(product);
        if (i == 0) {
            throw new MyException("插入失败");
        }
        return true;

    }

    @Override
    public boolean deleteProduct(int systemId) throws MyException {
        int i =  productMapper.deleteBySystemId(systemId);
        if (i == 0) {
            throw new MyException("删除失败");
        }
        return true;
    }


}
