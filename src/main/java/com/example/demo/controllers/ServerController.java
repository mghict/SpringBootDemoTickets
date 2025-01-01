package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestController
public class ServerController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @Value(value = "${welcome.message}")
    private String message;

    private final ErrorAttributes errorAttributes;

    public ServerController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(path = "/health",method = RequestMethod.GET)
    public String serverHealth() {
        return message;
    }

    @RequestMapping(path = ERROR_PATH)
    public ResponseEntity<Map<String, Object>> error(WebRequest  request) {
        Map<String,Object> errorDetails=errorAttributes.getErrorAttributes(request, ErrorAttributeOptions.defaults());
        HttpStatus status=HttpStatus.valueOf((int)errorDetails.get("status"));

        return new ResponseEntity<>(errorDetails, status);
    }

//    @GetMapping(path = ERROR)
//    public String error() {
//        return "Request Path not found!!";
//    }

//    @Override
//    public String getErrorPath()
//    {
//        return ERROR;
//    }


}
