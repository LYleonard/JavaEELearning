package com.wrp.mybatis.po;

import java.util.List;

/**   
* @Title: UserQueryVo.java 
* @Description: 包装类型
* @author LYleonard
* @date 2016年10月9日 上午10:52:01 
* @version V1.0   
*/
public class UserQueryVo {
	// 包装所需要的查询条件
	
	// 传入多个id
	private List<Integer> ids;
	
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	// 用户查询条件
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}
	
	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	
	// 可以包装其他的查询条件，订单、商品
	
}
