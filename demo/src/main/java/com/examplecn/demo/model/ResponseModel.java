package com.examplecn.demo.model;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Data
public class ResponseModel implements Serializable {

    private int status;

    private Object result;

    private String traceId;

    private String devMessage = "";

    private String message = "";

    private String path;

    public static ResponseModel succeed(Object data) {

        ResponseModel response = new ResponseModel();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        response.setResult(data);
        response.setDevMessage("SUCCESS");
        response.setStatus(HttpStatus.OK.value());
        response.setTraceId(RequestContext.getTraceId());
        response.setPath(request.getServletPath());
        return response;
    }
}
