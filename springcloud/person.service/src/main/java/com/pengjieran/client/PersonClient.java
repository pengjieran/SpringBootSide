package com.pengjieran.client;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.pengjieran.config.PersonConfig;
import com.pengjieran.service.PersonService;

@FeignClient(name = PersonConfig.SERVICE_ID)
public interface PersonClient extends PersonService {

}