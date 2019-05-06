package net.sanlao.design.core.mapper;

import net.sanlao.design.core.mapper.provider.ClientProvider;
import net.sanlao.design.core.model.Client;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Jimi
 * @date : 2019/05/05
 * @since : Java 11
 */
@Mapper
@Repository
public interface ClientMapper {
    /**
     * 筛选全部
     * @return product的集合
     */
    @SelectProvider(type = ClientProvider.class, method = "selectByCondition")
    List<Client> selectByCondition(int systemId);

    /**
     * 插入产品
     * @param client
     * @return
     */
    @Insert("INSERT INTO client(c_id,c_name) VALUES(#{systemId},#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "systemId")
    int insert(Client client);

    /**
     * 修改产品
     * @param client
     * @return
     */
    @UpdateProvider(type = ClientProvider.class, method = "setClient")
    int updateBySystemId(Client client);

    @Delete("DELETE FROM client WHERE c_id=#{systemId}")
    int deleteBySystemId(int systemId);
}
