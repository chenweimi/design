package net.sanlao.design.web;

import net.sanlao.design.common.MyException;
import net.sanlao.design.common.RestData;
import net.sanlao.design.common.util.JsonUtil;
import net.sanlao.design.core.model.vo.DeliveryVo;
import net.sanlao.design.service.DeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Jimi
 * @date : 2019/05/06
 * @since : Java 11
 */
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class DeliveryAPI {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryAPI(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @RequestMapping(value = "/delivery", method = RequestMethod.POST)
    public RestData postClient(@RequestBody DeliveryVo deliveryVo) {
        logger.info("POST postClient : " + JsonUtil.getJsonString(deliveryVo));

        try {
            return new RestData(deliveryService.postDelivery(deliveryVo));
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }
}
