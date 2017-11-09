package com.example.springCloudConsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springCloudConsumer.service.feignClient.ComputeRemote;
import com.example.springCloudConsumer.service.feignClient.HelloRemote;

/**
 * Feign通过以接口和注解配置的方式，轻松实现对服务的绑定，这样我们就可以在本地应用中像本地服务一样的调用它，并且做到了客户端均衡负载。
 * 
 * Feign是一个声明式Web Service客户端。使用Feign能让编写Web Service客户端更加简单, 它的使用方法是定义一个接口，然后在上面添加注解，同时也支持JAX-RS标准的注解。
 * Feign也支持可拔插式的编码器和解码器。Spring Cloud对Feign进行了封装，使其支持了Spring MVC标准注解和HttpMessageConverters。
 * Feign可以与Eureka和Ribbon组合使用以支持负载均衡。
 * @author LW  
 * @date 2017年10月9日
 */
@RestController
@RequestMapping("/feign")
public class ConsumerFeignController {

	@Autowired
	private HelloRemote helloRemote;
	
	@Autowired
	private ComputeRemote computeRemote;
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name){
		return helloRemote.hello(name);
	}
	
	@RequestMapping("/add/{a}/{b}")
	public Integer add(@PathVariable("a") Integer a, @PathVariable("b") Integer b){
		return computeRemote.add(a, b);
	}
}
