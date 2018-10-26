package com.ambow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ambow.entity.Organization;
import com.ambow.service.OrganizationService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/api/v2/organizations", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(tags = "组织机构，学校相关操作类")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping
    public List<Organization> all() {

        return organizationService.all();
    }

    @PutMapping
    public Organization put(@RequestBody Organization organization) {

        organizationService.saveOrUpdate(organization);
        return organization;
    }

    @GetMapping(value = "/page")
    public Page<Organization> page(@RequestParam(value = "pageNum", required = true) Integer pageNum,
                                   @RequestParam(value = "pageSize", required = true) Integer pageSize) {

        return (Page<Organization>) organizationService.page(new Page<Organization>(pageNum, pageSize), null);
    }
}