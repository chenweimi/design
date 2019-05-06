package net.sanlao.design.service.impl;

import net.sanlao.design.common.MyException;
import net.sanlao.design.core.mapper.FinanceMapper;
import net.sanlao.design.core.model.Finance;
import net.sanlao.design.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class FinanceImpl implements FinanceService {

    private final FinanceMapper financeMapper;

    @Autowired
    public FinanceImpl(FinanceMapper financeMapper) {
        this.financeMapper = financeMapper;
    }

    @Override
    public List<Map<String, Object>> getFinance(int systemId) throws MyException {
        List<Map<String, Object>> rtv = new ArrayList<>();
        List<Finance> finances = financeMapper.selectByCondition(systemId);
        if (finances.size() == 0) {
            throw new MyException("查询失败");
        } else {
            for (Finance finance : finances) {
                Map<String,Object> map = new HashMap<>(3);
                map.put("systemId",finance.getSystemId());
                map.put("total",finance.getTotal());
                map.put("current",finance.getCurrent());
                rtv.add(map);
            }
        }
        return rtv;
    }

    @Override
    public boolean updateFinance(Finance finance) throws MyException {
        int i =  financeMapper.updateBySystemId(finance);
        if (i == 0) {
            throw new MyException("修改失败");
        }
        return true;
    }

    @Override
    public Map<String,Object> getStats() throws MyException {
        Map<String, Object> map = new HashMap<>(3);

        Finance finance = financeMapper.selectStats();

        map.put("total", finance.getTotal());
        map.put("current", finance.getCurrent());
        map.put("need", finance.getTotal() - finance.getCurrent());

        return map;
    }
}
