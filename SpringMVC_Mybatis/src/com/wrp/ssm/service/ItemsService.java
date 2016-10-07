/**   
*
* 
* 
*/
package com.wrp.ssm.service;

import java.util.List;

import com.wrp.ssm.po.ItemsCustom;
import com.wrp.ssm.po.ItemsQueryVo;

/**   
* @Title: ItemsService.java 
* @Description: 定义Service接口
* @author LYleonard
* @date 2016年9月9日 下午4:01:47 
* @version V1.0   
*/
public interface ItemsService {
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	//根据id查询商品信息
	/**
	 * @param id 查询商品的id
	 * @return
	 * @throws Exception
	 */
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	//修改商品信息
	/**
	 * @param id 修改商品的id
	 * @param itemsCustom 修改的商品信息
	 * @throws Exception
	 */
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
	
	// 测试：增加商品信息
	
}
