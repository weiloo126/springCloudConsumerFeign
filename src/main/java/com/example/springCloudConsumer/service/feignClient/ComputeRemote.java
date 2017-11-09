package com.example.springCloudConsumer.service.feignClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author LW  
 * @date 2017年10月9日
 */
@FeignClient(name = "spring-cloud-producer")
public interface ComputeRemote {

	@RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
