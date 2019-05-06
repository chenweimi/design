package net.sanlao.design.service.impl;

import net.sanlao.design.common.MyException;
import net.sanlao.design.core.mapper.ClientMapper;
import net.sanlao.design.core.model.Client;
import net.sanlao.design.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Jimi
 * @date : 2019/05/05
 * @since : Java 11
 */
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientMapper clientMapper;

    @Autowired
    public ClientServiceImpl(ClientMapper clientMapper) {
        this.clientMapper = clientMapper;
    }

    @Override
    public List<Map<String, Object>> getClient(int systemId) throws MyException {
        List<Map<String, Object>> rtv = new ArrayList<>();
        List<Client> clients = clientMapper.selectByCondition(systemId);
        if (clients.size() == 0) {
            throw new MyException("查询失败");
        } else {
            for (Client client : clients) {
                Map<String,Object> map = new HashMap<>(2);
                map.put("systemId",client.getSystemId());
                map.put("name",client.getName());
                rtv.add(map);
            }
        }
        return rtv;
    }

    @Override
    public boolean postClient(Client client) throws MyException {
        int i =  clientMapper.insert(client);
        if (i == 0) {
            throw new MyException("插入失败");
        }
        return true;
    }

    @Override
    public boolean updateClient(Client client) throws MyException {
        int i =  clientMapper.updateBySystemId(client);
        if (i == 0) {
            throw new MyException("修改失败");
        }
        return true;
    }

    @Override
    public boolean deleteClient(int systemId) throws MyException {
        int i =  clientMapper.deleteBySystemId(systemId);
        if (i == 0) {
            throw new MyException("删除失败");
        }
        return true;
    }
}
