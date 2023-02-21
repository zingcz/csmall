package cn.tedu.csmall.order.webapi.mapper;


import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

    // 新增订单的方法
    @Insert("insert into order_tbl(user_id,commodity_code,count,money) values" +
            "(#{userId},#{commodityCode},#{count},#{money})")
    int insertOrder(cn.tedu.csmall.commons.pojo.order.model.Order order);
}
