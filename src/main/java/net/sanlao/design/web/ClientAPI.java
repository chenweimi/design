package net.sanlao.design.web;

import net.sanlao.design.common.MyException;
import net.sanlao.design.common.RestData;
import net.sanlao.design.common.util.JsonUtil;
import net.sanlao.design.core.model.Client;
import net.sanlao.design.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author : Jimi
 * @date : 2019/05/05
 * @since : Java 11
 */
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class ClientAPI {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ClientService clientService;

    @Autowired
    public ClientAPI(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/client/{systemId}", method = RequestMethod.GET)
    public RestData getClient(@PathVariable(value = "systemId") int systemId) {
        logger.info("get getClient : " + systemId);
        System.out.println(systemId);
        try {
            List<Map<String, Object>> data = clientService.getClient(systemId);
            return new RestData(data);
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public RestData postClient(@RequestBody Client client) {
        logger.info("POST postClient : " + JsonUtil.getJsonString(client));

        try {
            return new RestData(clientService.postClient(client));
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }

    @RequestMapping(value = "/client", method = RequestMethod.PUT)
    public RestData putClient(@RequestBody Client client) {
        logger.info("PUT putClient : ");

        try {
            return new RestData(clientService.updateClient(client));
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }

    }

    @RequestMapping(value = "/client/{systemId}", method = RequestMethod.DELETE)
    public RestData deleteClient(@PathVariable(value = "systemId") int systemId) {
        logger.info("DELETE deleteClient : studentId = " + systemId);

        try {
            return new RestData(clientService.deleteClient(systemId));
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }

}
