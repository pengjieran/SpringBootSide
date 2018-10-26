package com.ambow.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ambow.entity.StreamRoom;

@FeignClient(url = "http://api.csslcloud.net", name = "edurp")
public interface LiveClient {

    @PostMapping(value = "/api/room/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String create(@RequestBody StreamRoom streamRoom);
}