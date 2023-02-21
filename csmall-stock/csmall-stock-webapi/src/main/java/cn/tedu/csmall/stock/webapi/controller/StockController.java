package cn.tedu.csmall.stock.webapi.controller;

import cn.tedu.csmall.commons.pojo.stock.dto.StockReduceCountDTO;
import cn.tedu.csmall.commons.restful.JsonResult;
import cn.tedu.csmall.stock.service.IStockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base/stock")
@Api(tags = "库存管理模块")
public class StockController {

    @Autowired
    private IStockService stockService;

    @PostMapping("/reduce/count")
    @ApiOperation("减少库存数的功能")
    public JsonResult reduceStock(StockReduceCountDTO stockReduceCountDTO){
        // 调用业务逻辑层方法,如果发生异常,将由全局异常处理类处理
        stockService.reduceStockCount(stockReduceCountDTO);
        return JsonResult.ok("库存减少完成!");
    }

}










