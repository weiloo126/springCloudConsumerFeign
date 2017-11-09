package com.example.springCloudConsumer.service.feignClient.hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springCloudConsumer.service.feignClient.HelloRemote;

/**
 * 继承自HelloRemote实现回调的方法
 * @author LW  
 * @date 2017年10月10日
 */
@Component
public class HelloRemoteHystrix implements HelloRemote{

	@Override
	public String hello(@RequestParam(value = "name") String name) {
		return "hello " +name+", this messge send failed ";
	}

}
