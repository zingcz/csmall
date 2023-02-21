package cn.tedu.csmall.order.webapi.service.impl;

import cn.tedu.csmall.commons.pojo.order.dto.OrderAddDTO;

import cn.tedu.csmall.commons.pojo.stock.dto.StockReduceCountDTO;
import cn.tedu.csmall.order.service.service.IOrderService;
import cn.tedu.csmall.order.webapi.mapper.OrderMapper;
import cn.tedu.csmall.stock.service.IStockService;
import cn.tedu.csmallcart.service.service.ICartService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DubboService
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @DubboReference
    private ICartService iCartService;

    @DubboReference
    private IOrderService iOrderService;

    @DubboReference
    private IStockService iStockService;


    @Override
    public void orderAdd(OrderAddDTO orderAddDTO) {
        // 1.这里先要减少订单中商品的库存数(调用stock减少库存的方法)
        StockReduceCountDTO countDTO = new StockReduceCountDTO();
        countDTO.setReduceCount(orderAddDTO.getCount());
        countDTO.setCommodityCode(orderAddDTO.getCommodityCode());
        iStockService.reduceStockCount(countDTO);

        // 2.还要从购物车列表中删除用户选中的商品(调用cart模块删除购物车中商品的方法)
        iCartService.deleteUserCart(orderAddDTO.getUserId(),orderAddDTO.getCommodityCode());
        // 3.新增订单信息
        cn.tedu.csmall.commons.pojo.order.model.Order order=new cn.tedu.csmall.commons.pojo.order.model.Order();
        BeanUtils.copyProperties(orderAddDTO,order);
        // 执行新增
        orderMapper.insertOrder(order);
        log.info("新增订单信息为:{}",order);

    }
}







