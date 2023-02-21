package cn.tedu.csmallcart.service.service;


import cn.tedu.csmall.commons.pojo.cart.dto.CartAddDTO;

public interface ICartService {

    // 新增购物车商品的业务逻辑层
    void cartAdd(CartAddDTO cartAddDTO);

    // 删除购物车商品的方法
    void deleteUserCart(String userId,String commodityCode);
}
