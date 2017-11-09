package com.example.springCloudConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableDiscoveryClient //启用服务注册与发现
@EnableFeignClients //启用feign进行远程调用..这个注解的意思是在该应用被启动的时候，会去所有类中搜索定义为FeignClient的接口，并自动注册到spring ioc容器中，然后会对所有使用client实现类的对象进行自动依赖注入。
public class SpringCloudConsumerFeignApplication {	

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConsumerFeignApplication.class, args);
	}
}
