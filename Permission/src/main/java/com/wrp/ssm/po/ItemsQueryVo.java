package com.wrp.ssm.po;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 */
public class ItemsQueryVo {
	
	//商品信息
	private Items items;
	
	//为了系统 可扩展性，对原始生成的po进行扩展
	private ItemsCustom itemsCustom;
	
	// 批量商品信息
	private List<ItemsCustom> itemsList;
	
	// map类型的参数绑定
	private Map<String, Object> itemInfo = new HashMap<String,Object>();
	
	// 用户信息，对应创建UserCustom.java
	//private UserCustom userCustom;
	
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

	/**
	 * @return the itemsList
	 */
	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}

	/**
	 * @param itemsList the itemsList to set
	 */
	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}

	/**
	 * @return the itemInfo
	 */
	public Map<String, Object> getItemInfo() {
		return itemInfo;
	}

	/**
	 * @param itemInfo the itemInfo to set
	 */
	public void setItemInfo(Map<String, Object> itemInfo) {
		this.itemInfo = itemInfo;
	}

}
