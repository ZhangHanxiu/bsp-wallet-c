package com.neusoft.bsp.common.base;

import com.neusoft.bsp.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    Logger logger = LoggerFactory.getLogger(Exception.class);

    @ExceptionHandler
    @ResponseBody
    public BaseModel exp(HttpServletRequest request, Exception exception) {
        BaseModel baseModel = new BaseModel();
        if(exception instanceof BusinessException) {
            baseModel.message = exception.getMessage();
            this.logger.error("errorResponse:{}", baseModel.toString());
        }else{
            this.logger.error("errorResponse:{}",exception.toString());
            baseModel.code = 500;
            baseModel.message = "Sorry!Exception occurs!Please try it later";
        }
        return baseModel;

    }
}
