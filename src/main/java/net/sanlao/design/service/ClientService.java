package net.sanlao.design.service;

import net.sanlao.design.common.MyException;
import net.sanlao.design.core.model.Client;

import java.util.List;
import java.util.Map;

/**
 * @author : Jimi
 * @date : 2019/05/05
 * @since : Java 11
 */
public interface ClientService {
    /**
     * 查询
     *
     * @return 黑名单
     */
    List<Map<String, Object>> getClient(int systemId) throws MyException;

    /**
     * 插入
     * @param client
     * @return
     * @throws MyException
     */
    boolean postClient(Client client) throws MyException;

    /**
     * 修改
     * @param client
     * @return
     */
    boolean updateClient(Client client) throws MyException;

    /**
     * 删除
     * @param systemId
     * @return
     * @throws MyException
     */
    boolean deleteClient(int systemId) throws MyException;
}
