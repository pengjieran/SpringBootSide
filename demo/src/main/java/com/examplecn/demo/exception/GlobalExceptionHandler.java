package com.examplecn.demo.exception;

import com.examplecn.demo.model.ResponseModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @author: Aaron
 * @date: 2019/12/31 16:55
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    private static Boolean alwaysOk = false;//默认使用真实的http状态码

    @ExceptionHandler(value = {Exception.class,BaseException.class,RuntimeException.class,Throwable.class})
    @ResponseBody
    public ResponseModel jsonErrorHandler(HttpServletRequest req, HttpServletResponse response, Exception e) throws Exception {
        ResponseModel responseModel = ResponseModel.succeed("");
        String clientType = req.getHeader("clientType");

        boolean okByClient = "feignClient".equals(clientType);//feignClient 调用的时候返回正常的状态码

        responseModel.setPath(req.getServletPath());
        if(e instanceof BaseException)
        {
            BaseException baseException = (BaseException)e;
            responseModel.setStatus(baseException.getHttpStatus());
            responseModel.setMessage(baseException.getMessage());
            responseModel.setDevMessage(baseException.getDevMessage());
            logger.error(baseException.getDevMessage());
            logger.error(e.getMessage(),e);
            response.setStatus(baseException.getHttpStatus());
        } else {

            responseModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseModel.setDevMessage(e.getMessage());
            responseModel.setMessage("未知错误,请联系管理员.");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

            logger.error(e.getMessage(),e);
        }

        if(alwaysOk && !okByClient)
            response.setStatus(HttpStatus.OK.value());//http返回码永远都是200，真是的返回码见responseBody中的status字段

        return responseModel;
    }

    public static Boolean getAlwaysOk() {
        return alwaysOk;
    }

    public static void setAlwaysOk(Boolean flag) {
        alwaysOk = flag;
    }
}
