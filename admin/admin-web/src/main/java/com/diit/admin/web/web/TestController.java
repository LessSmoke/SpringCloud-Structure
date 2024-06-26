package com.diit.admin.web.web;

import com.diit.common.base.response.APIResponse;
import com.diit.common.base.response.ResponseCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    public APIResponse hello(){
        return new APIResponse(ResponseCode.SUCCESS,"成功");
    }
}
