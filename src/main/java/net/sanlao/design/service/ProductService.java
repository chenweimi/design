package net.sanlao.design.service;

import net.sanlao.design.common.MyException;
import net.sanlao.design.core.model.Product;

import java.util.List;
import java.util.Map;

/**
 * @author : Jimi
 * @date : 2019/05/04
 * @since : Java 11
 */
public interface ProductService {
    /**
     * 查询黑名单
     *
     * @return 黑名单
     */
    List<Map<String, Object>> getProduct(int systemId) throws MyException;

    /**
     * 插入产品
     * @param product
     * @return
     * @throws MyException
     */
    boolean postProduct(Product product) throws MyException;

    /**
     * 修改产品
     * @param product
     * @return
     */
    boolean updateProduct(Product product) throws MyException;

    /**
     * 删除产品
     * @param systemId
     * @return
     * @throws MyException
     */
    boolean deleteProduct(int systemId) throws MyException;
}
