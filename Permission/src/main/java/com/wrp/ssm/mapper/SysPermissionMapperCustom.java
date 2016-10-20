package com.wrp.ssm.mapper;

import java.util.List;

import com.wrp.ssm.po.SysPermission;

public interface SysPermissionMapperCustom{

	public List<SysPermission> findMenuListByUserId(String userid)throws Exception;

	public List<SysPermission> findPermissionListByUserId(String userid)throws Exception;
	
}
