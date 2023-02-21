package cn.tedu.csmall.order.webapi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 当前类是配置Spring扫描环境的配置类,必须添加配置注解@Configuration才能生效
@Configuration
// 我们要扫描统一异常处理类所在的包才能让这个类生效,实现它能处理异常的效果
@ComponentScan("cn.tedu.csmall.commons.exception")
public class CommonsConfiguration {
}
