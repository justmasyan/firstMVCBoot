package mainpackage.maintask.Config;

import org.springframework.cloud.openfeign.EnableFeignClients;

import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeignClients(basePackages = "mainpackage.proxy")
public class configuration {
}
