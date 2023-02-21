package cn.tedu.csmall.cart.webapi.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// Mybatis框架要求扫描指定包,包中接口会生成实现类
@MapperScan("cn.tedu.csmall.cart.webapi.mapper")
public class MybatisConfiguration {
}
