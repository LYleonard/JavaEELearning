package com.wrp.ssm.mapper;

import java.util.List;

import com.wrp.ssm.po.ItemsCustom;
import com.wrp.ssm.po.ItemsQueryVo;

public interface ItemsMapperCustom {
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
	
	
}