package com.example.springCloudConsumer.service.feignClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springCloudConsumer.service.feignClient.hystrix.HelloRemoteHystrix;

/**
 * 定义Feign的Client接口，这里Client接口其实就是对提供服务的restful接口的本地定义，定义好后，在其他类中就可以像使用RPC本地接口类一样使用远程服务接口了
 * feign内部集成了Ribbon，所以通过serviceid找到服务后，会通过ribbon自动实现服务访问的负载均衡
 * 
 * 我们几乎完全可以从服务提供方的Controller中依靠复制操作，来构建出相应的服务接口客户端，或是通过Swagger生成的API文档来编写出客户端，亦或是通过Swagger的代码生成器来生成客户端绑定。
 * 
 * 在HelloRemote类添加指定fallback属性，在服务熔断的时候返回fallback类中的内容
 * @author LW  
 * @date 2017年10月9日
 */
@FeignClient(name = "spring-cloud-producer", fallback = HelloRemoteHystrix.class) //name:远程服务名，即spring.application.name配置的名称；此类中的方法和远程服务中contoller中的方法名和参数需保持一致。
public interface HelloRemote {

	@RequestMapping(value = "/hello")
	public String hello(@RequestParam(value = "name") String name);
}
