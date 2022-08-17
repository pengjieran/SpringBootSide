package com.mtoliv;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig.Builder;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.util.Collections;
import org.junit.Test;

public class Generator {

	/**
	 * mysql数据库，生成dao,service,controller
	 * @param args
	 */
	@Test
	public void generator() {
		
		String srcPath = "E:\\workspace\\scaffold\\spring-boot-mybatisplus-shiro\\src\\main\\java";//项目源码绝对路径
		
		String username = "root";
		String password = "123456";
		String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";
		
		String[] tablePrefixs = new String[] {"t_"};//表前缀

		FastAutoGenerator.create(url, username, password)
				.globalConfig(builder -> {
					builder.author("Aaron") // 设置作者
							.enableSwagger() // 开启 swagger 模式
							.fileOverride() // 覆盖已生成文件
							.outputDir(srcPath); // 指定输出目录
				})
				.packageConfig(builder -> {
					builder.parent("com") // 设置父包名
							.moduleName("examplecn") // 设置父包模块名
							.controller("web.controller")
							.service("service")
							.serviceImpl("service.impl")
							.pathInfo(Collections.singletonMap(OutputFile.xml, "D://")); // 设置mapperXml生成路径
				})
				.strategyConfig(builder -> {
					builder.addInclude("t_simple") // 设置需要生成的表名
							.addTablePrefix(tablePrefixs); // 设置过滤表前缀
				})
				.templateConfig(builder -> {
					builder.controller(null);
				})
				.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
				.execute();
	}
}