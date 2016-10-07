package com.wrp.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.wrp.ssm.po.OrdersExample;

public interface OrderdetailMapper<Orderdetail> {
    int countByExample(com.wrp.ssm.po.OrderdetailExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(com.wrp.ssm.po.OrderdetailExample record);

    int insertSelective(com.wrp.ssm.po.Orderdetail record);

    List<com.wrp.ssm.po.Orderdetail> selectByExample(com.wrp.ssm.po.Orderdetail example);

    com.wrp.ssm.po.Orderdetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") com.wrp.ssm.po.Orderdetail record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") com.wrp.ssm.po.OrderdetailExample record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(com.wrp.ssm.po.Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);
}