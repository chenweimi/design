package net.sanlao.design.web;

import net.sanlao.design.common.MyException;
import net.sanlao.design.common.RestData;
import net.sanlao.design.common.util.JsonUtil;
import net.sanlao.design.core.model.Product;
import net.sanlao.design.service.ProductService;
import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author : Jimi
 * @date : 2019/05/04
 * @since : Java 11
 */

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class ProductAPI {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ProductService productService;

    @Autowired
    public ProductAPI(ProductService productService ) {
        this.productService = productService;
    }

    @RequestMapping(value = "/product/{systemId}", method = RequestMethod.GET)
    public RestData getProduct(@PathVariable(value = "systemId") int systemId) {
        logger.info("get getProduct : " + systemId);
        System.out.println(systemId);
        try {
            List<Map<String, Object>> data = productService.getProduct(systemId);
            return new RestData(data);
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public RestData postProduct(@RequestBody Product product) {
        logger.info("POST postProduct : " + JsonUtil.getJsonString(product));

        try {
            return new RestData(productService.postProduct(product));
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public RestData putProduct(@RequestBody Product product) {
        logger.info("PUT putProduct : ");

        try {
            return new RestData(productService.updateProduct(product));
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }

    }

    @RequestMapping(value = "/product/{systemId}", method = RequestMethod.DELETE)
    public RestData deleteBlackList(@PathVariable(value = "systemId") int systemId) {
        logger.info("DELETE deleteBlackList : studentId = " + systemId);

        try {
            return new RestData(productService.deleteProduct(systemId));
        } catch (MyException e) {
            return new RestData(1, e.getMessage());
        }
    }
}
