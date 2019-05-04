package net.sanlao.design.core.mapper;

import net.sanlao.design.core.mapper.provider.ProductProvider;
import net.sanlao.design.core.model.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author : Jimi
 * @date : 2019/05/04
 * @since : Java 11
 */
@Mapper
@Repository
public interface ProductMapper {
    /**
     * 筛选全部
     * @return product的集合
     */
    @SelectProvider(type = ProductProvider.class, method = "selectByCondition")
    List<Product> selectByCondition(int systemId);

    /**
     * 插入产品
     * @param product
     * @return
     */
    @Insert("INSERT INTO product(p_id,p_name,p_count) VALUES(#{systemId},#{name},#{count})")
    @Options(useGeneratedKeys = true, keyProperty = "systemId")
    int insert(Product product);

    /**
     * 修改产品
     * @param product
     * @return
     */
    @UpdateProvider(type = ProductProvider.class, method = "setProduct")
    int updateBySystemId(Product product);

    @Delete("DELETE FROM product WHERE p_id=#{systemId}")
    int deleteBySystemId(int systemId);
}
