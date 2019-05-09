package net.sanlao.design.web;

import net.sanlao.design.common.MyException;
import net.sanlao.design.common.RestData;
import net.sanlao.design.common.util.JsonUtil;
import net.sanlao.design.core.model.Finance;
import net.sanlao.design.core.model.vo.DeliveryVo;
import net.sanlao.design.service.DeliveryService;
import net.sanlao.design.service.FinanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author : Jimi
 * @date : 2019/05/06
 * @since : Java 11
 */
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class DeliveryAPI {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final FinanceService financeService;
    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryAPI(FinanceService financeService, DeliveryService deliveryService) {
        this.financeService = financeService;
        this.deliveryService = deliveryService;
    }

    @RequestMapping(value = "/delivery", method = RequestMethod.POST)
    public RestData postDelivery(@RequestBody DeliveryVo deliveryVo) {
        logger.info("POST postDelivery : " + JsonUtil.getJsonString(deliveryVo));

        try {
            return new RestData(deliveryService.postDelivery(deliveryVo));
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }

    @RequestMapping(value = "/delivery/{systemId}", method = RequestMethod.GET)
    public RestData getDelivery(@PathVariable(value = "systemId") int systemId) {
        logger.info("get getDelivery : " + systemId);
        System.out.println(systemId);
        try {
            List<Map<String, Object>> data = deliveryService.getDelivery(systemId);
            return new RestData(data);
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }

    @RequestMapping(value = "/delivery", method = RequestMethod.GET)
    public RestData getDeliveryByEId(DeliveryVo deliveryVo) {
        logger.info("get getDeliveryByEId : " );

        try {
            List<Map<String, Object>> data = deliveryService.getDeliveryByEId(deliveryVo);
            return new RestData(data);
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }


    @RequestMapping(value = "/delivery", method = RequestMethod.PUT)
    public RestData putDelivery(@RequestBody DeliveryVo deliveryVo) {
        logger.info("PUT putDelivery : ");

        try {
            return new RestData(deliveryService.updateDelivery(deliveryVo));
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }

    }

    @RequestMapping(value = "/delivery/{systemId}", method = RequestMethod.DELETE)
    public RestData deleteDelivery(@PathVariable(value = "systemId") int systemId) {
        logger.info("DELETE deleteDelivery : studentId = " + systemId);

        try {
            return new RestData(deliveryService.deleteDelivery(systemId));
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }


    @RequestMapping(value = "/finance/{systemId}", method = RequestMethod.GET)
    public RestData getFinance(@PathVariable(value = "systemId") int systemId) {
        logger.info("get getDelivery : " + systemId);

        try {
            List<Map<String, Object>> data = financeService.getFinance(systemId);
            return new RestData(data);
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }

    @RequestMapping(value = "/finance", method = RequestMethod.PUT)
    public RestData putFinance(@RequestBody Finance finance) {
        logger.info("PUT putDelivery : ");

        try {
            return new RestData(financeService.updateFinance(finance));
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }

    }

    @RequestMapping(value = "/stats", method = RequestMethod.GET)
    public RestData getStats() {
        logger.info("get getStats : " );
        try {
            Map<String, Object> data = financeService.getStats();
            return new RestData(data);
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }
}
