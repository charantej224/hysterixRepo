package com.service.consumer.web.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ProductResource controller
 */
@RestController
@RequestMapping("/api/product")
public class ProductResource {

    private final Logger log = LoggerFactory.getLogger(ProductResource.class);

    String url1 = "http://localhost:8040/tenSecondsDelay";
    String url2 = "http://localhost:8040/twentySecondsDelay";


    /**
    * GET getRemoteResponse
    */
    @GetMapping("/get-remote-response-tenseconds")
    @HystrixCommand(commandKey = "tenSeconds",fallbackMethod = "returnTenError")
    public String getTenRemoteResponse() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url1,String.class);
        return response;
    }


    @GetMapping("/get-remote-response-twentyseconds")
    @HystrixCommand(commandKey = "twentySeconds",fallbackMethod = "returnTwentyError")
    public String getTwentyRemoteResponse() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url2,String.class);
        return response;
    }

    public String returnTenError(){
        log.debug("Logs : fallBack");
        return "You killed it, ten seconds - circuit opened!!!";
    }

    public String returnTwentyError(){
        log.debug("Logs : fallBack");
        return "You killed it, twenty seconds - circuit opened!!!";
    }

}
