package cn.tedu.csmall.cart.webapi.mapper;

import cn.tedu.csmall.commons.pojo.cart.entity.Cart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartMapper {

    // 向购物车中新增商品
    @Insert("insert into cart_tbl(commodity_code,price,count,user_id) values" +
            "(#{commodityCode},#{price},#{count},#{userId})")
    int insertCart(Cart cart);

    // 删除购物车中商品
    @Delete("delete from cart_tbl where user_id=#{userId} and " +
            " commodity_code=#{commodityCode}")
    int deleteCartByUserIdAndCommodityCode(
                               @Param("userId") String userId,
                               @Param("commodityCode") String commodityCode);
}









