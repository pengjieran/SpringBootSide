package com.mtoliv.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		
	    MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
	    //可以通过环境变量获取你的mapper路径,这样mapper扫描可以通过配置文件配置了
	    scannerConfigurer.setBasePackage("com.mtoliv.mapper.dao");
	    return scannerConfigurer;
	}

}