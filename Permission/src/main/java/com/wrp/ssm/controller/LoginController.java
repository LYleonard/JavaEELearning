/**   
*
* 
* 
*/
package com.wrp.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wrp.ssm.exception.CustomException;
import com.wrp.ssm.po.ActiveUser;
import com.wrp.ssm.service.SysService;

/**   
* @Title: LoginController.java 
* @Description: 登录controller
* @author LYleonard 
*/
@Controller
public class LoginController {
	
	@Autowired
	private SysService sysService;
	
	/**
	 * @param session
	 * @param randomcode 输入的验证码
	 * @param usercode  用户账号
	 * @param password  用户密码
	 * @return
	 * @throws Exception
	 */
	// 登录
	@RequestMapping("/login")
	public String login(HttpSession session, String randomcode, String usercode, String password) throws Exception{
		// 校验 验证码，防止恶意攻击，从session获取校验码
		String validateCode = (String) session.getAttribute("validateCode");
		// 判断验证码是否正确
		if (!randomcode.equals(validateCode)) {
			throw new CustomException("验证码输入错误！");
		}
		
		// 调用service进行用户身份验证
		ActiveUser activeUser = sysService.authenticat(usercode, password);
		
		// 在session中保存用户身份信息
		session.setAttribute("activeUser", activeUser);
		// 重定向到商品列表页面
		return "redirect:/first.action";
		
	}
	
	// 退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		// 清除session
		session.invalidate();
		
		// 重定向到商品列表页面
		return "redirect:/first.action";
	}
	
}
