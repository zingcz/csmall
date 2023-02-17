package cn.tedu.csmall.business.service.IMPL;

import cn.tedu.csmall.business.service.IBusiness;
import cn.tedu.csmall.commons.pojo.order.dto.OrderAddDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusinessIMPL implements IBusiness {
    /**
     *
     */
    @Override
    public void buy(){
        OrderAddDTO orderAddDTO = new OrderAddDTO();
        orderAddDTO.setCount(1);
        orderAddDTO.setUserId("uuid");
        orderAddDTO.setCommodityCode("PC100");
        orderAddDTO.setMoney(100);
        log.debug("新增加的订单信息为：",orderAddDTO);
    }
}
