/**   
*
* 
* 
*/
package com.wrp.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.wrp.ssm.exception.CustomException;
import com.wrp.ssm.mapper.ItemsMapper;
import com.wrp.ssm.mapper.ItemsMapperCustom;
import com.wrp.ssm.po.Items;
import com.wrp.ssm.po.ItemsCustom;
import com.wrp.ssm.po.ItemsQueryVo;
import com.wrp.ssm.service.ItemsService;

/**   
* @Title: ItemsServiceImpl.java 
* @Description: 商品管理Service接口的实现类
* @author LYleonard
* @date 2016年9月13日 下午8:17:16 
* @version V1.0   
*/
public class ItemsServiceImpl implements ItemsService{

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		//通过ItemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	
	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		
		Items items = itemsMapper.selectByPrimaryKey(id);
		if (items==null) {
			throw new CustomException("修改的商品信息不存在");
		}
		//中间对商品进行处理
		// ......
		// 返回ItemsCustom
		ItemsCustom itemsCustom = null;
		// 将Items属性拷贝到itemsCustom
		if (items !=null) {
			itemsCustom = new ItemsCustom();
			BeanUtils.copyProperties(items, itemsCustom);
		}
		
		return itemsCustom;
	}

	
	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		// 添加一些业务的校验，通常在service接口对关键参数进行校验
		// 校验id是否为空，如果为空则抛出异常
		
		// 更新商品信息,使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括大文本类型字段
		// updateByPrimaryKeyWithBLOBs要求必须转入id
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}
	
}
