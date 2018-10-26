package com.ambow.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ambow.entity.StreamRoom;
import com.ambow.service.StreamRoomService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

@RestController
@RequestMapping(value = "/api/v1/streams", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SteamController {
    
    private static final String URL = "rtmp://47.93.240.174:1932/mtoliv";

    @Autowired
    private StreamRoomService streamService;
    
    @PostMapping
    public List<StreamRoom> put(@RequestParam(value = "scheduleId", required = true) String scheduleId) {
        
        List<StreamRoom> streamRooms = new ArrayList<>();
        StreamRoom streamRoom = new StreamRoom();
        streamRoom.setResourceId(scheduleId);
        String uid = StringUtils.remove(UUID.randomUUID().toString(), "-");
        streamRoom.setStreamUrl(URL + "/" + uid);
        streamRooms.add(streamRoom);
        streamService.saveOrUpdateBatch(streamRooms);
        return streamRooms;
    }
    
    @GetMapping(value = "/byScheduleId")
    public List<StreamRoom> getByScheduleId(@RequestParam(value = "resourceId", required = true) String resourceId) {
        
        QueryWrapper<StreamRoom> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("resource_id", resourceId);
        
        return streamService.list(queryWrapper);
    }
}