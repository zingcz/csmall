package cn.tedu.csmall.cart.webapi.service.impl;




import cn.tedu.csmall.cart.webapi.mapper.CartMapper;
import cn.tedu.csmall.commons.pojo.cart.dto.CartAddDTO;
import cn.tedu.csmall.commons.pojo.cart.entity.Cart;
import cn.tedu.csmallcart.service.service.ICartService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.cn.tedu.csmall.cart.webapi.mapper.CartMapper;

@DubboService
@Service
@Slf4j
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public void cartAdd(CartAddDTO cartAddDTO) {
        // 当前方法参数是CartAddDTO,执行新增操作Mapper方法需要的是Cart
        // 需要将cartAddDTO对象中的同名属性赋值到Cart类对象中
        Cart cart=new Cart();
        // 利用BeanUtils赋值
        BeanUtils.copyProperties(cartAddDTO,cart);
        // cart对象必要属性都赋好值,就可以执行新增了
        int row = cartMapper.insertCart(cart);
        // 这里可以判断row的值,来断定新增成功与否
        log.info("购物车中新增了商品:{}",cart);
    }

    @Override
    public void deleteUserCart(String userId, String commodityCode) {
        // 删除方法可以直接调用持久层的方法即可
        cartMapper.deleteCartByUserIdAndCommodityCode(userId,commodityCode);
        // 输出日志
        log.info("购物车中商品已移除!");
    }
}
