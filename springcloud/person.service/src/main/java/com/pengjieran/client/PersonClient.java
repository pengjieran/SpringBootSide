package com.pengjieran.client;

import org.springframework.cloud.openfeign.FeignClient;

import com.pengjieran.config.PersonConfig;
import com.pengjieran.service.PersonService;

@FeignClient(name = PersonConfig.SERVICE_ID, fallbackFactory = PersonClientFallbackFactory.class)
public interface PersonClient extends PersonService {

}