package cn.tedu.csmall.business.controller;

import cn.tedu.csmall.business.service.IBusiness;
import cn.tedu.csmall.commons.restful.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("business")
public class BusinessController {
    @Autowired
    private IBusiness business;

    @PostMapping("/buy")
    public JsonResult<Void> buy(){
        business.buy();
        return JsonResult.ok("已触发购买业务");
    }
}
