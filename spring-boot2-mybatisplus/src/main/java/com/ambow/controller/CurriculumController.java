package com.ambow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ambow.entity.Curriculum;
import com.ambow.service.CurriculumService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1/curriculums", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(tags= "课程相关操作")
public class CurriculumController {
    
    @Autowired
    private CurriculumService curriculumService;
    
    @GetMapping(value = "/listByOrgId")
    @ApiOperation(value = "获取学校下的课程列表")
    public List<Curriculum> listByOrgId(@RequestParam(value = "orgId", required = true) String orgId) {
        
        return curriculumService.listByOrgId(orgId);
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "新增，修改课程")
    public Curriculum put(@RequestBody Curriculum curriculum) {
        
        curriculumService.saveOrUpdate(curriculum);
        return curriculum;
    }

}