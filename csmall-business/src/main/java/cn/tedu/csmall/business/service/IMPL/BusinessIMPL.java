package cn.tedu.csmall.business.service.IMPL;

import cn.tedu.csmall.business.service.IBusiness;
import cn.tedu.csmall.commons.pojo.order.dto.OrderAddDTO;
import cn.tedu.csmall.order.service.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusinessIMPL implements IBusiness {

    @DubboReference
    private IOrderService dubboOrderService;

    @Override
    public void buy(){
        OrderAddDTO orderAddDTO = new OrderAddDTO();
        orderAddDTO.setCount(10);
        orderAddDTO.setUserId("uuid");
        orderAddDTO.setCommodityCode("PC100");
        orderAddDTO.setMoney(100);
        log.debug("新增加的订单信息为：",orderAddDTO);

        dubboOrderService.orderAdd(orderAddDTO);
    }
}
