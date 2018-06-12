package com.mtoliv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class WebConfig {

	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {

		MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = jackson2HttpMessageConverter.getObjectMapper();
		// 不显示为null的字段
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

		//web段需要注意处理long超长的问题，接口返回的结果是正确的，但是js处理的时候就出现了误差
		objectMapper.configure(DeserializationFeature.USE_LONG_FOR_INTS, true);
		objectMapper.configure(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS, true);
		objectMapper.configure(Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
		
		jackson2HttpMessageConverter.setObjectMapper(objectMapper);
		return jackson2HttpMessageConverter;
	}

}