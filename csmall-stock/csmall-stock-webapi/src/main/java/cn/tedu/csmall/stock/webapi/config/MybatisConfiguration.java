package cn.tedu.csmall.stock.webapi.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration
// Mybatis框架要求扫描指定包,包中接口会生成实现类
@MapperScan("cn.tedu.csmall.stock.webapi.mapper")
public class MybatisConfiguration implements Serializable {
}
