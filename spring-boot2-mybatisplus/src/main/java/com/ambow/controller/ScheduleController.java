package com.ambow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ambow.entity.Schedule;
import com.ambow.service.ScheduleService;

@RestController
@RequestMapping(value = "/api/v1/schedule", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Schedule put(@RequestBody Schedule schedule) {
        
        scheduleService.saveOrUpdate(schedule);
        return schedule;
    }
    
    @GetMapping(value = "/byCurriculmId")
    public List<Schedule> getByCurriculmId(String curriculumId) {
        
        return scheduleService.listByCurriculumId(curriculumId);
    }
}