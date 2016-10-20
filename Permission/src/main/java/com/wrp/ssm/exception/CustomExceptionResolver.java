/**   
*
* 
* 
*/
package com.wrp.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**   
* @Title: CustomExceptionResolver.java 
* @Description: 全局异常处理器
* @author LYleonard 
*/
public class CustomExceptionResolver implements HandlerExceptionResolver{
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// handler就是处理器适配器要执行handler对象（只有method）
		
/*		// 解析异常类型
		// 如果该异常是系统 自定义异常，直接取出异常信息，在错误页面展示
		String message = null;
		if (ex instanceof CustomException) {
			message = ((CustomException)ex).getMessage();
		}else {
			// 如果该异常不是系统 自定义异 常，构造一个自定义的异常类型（信息为“未知错误”）
			message = "未知错误";
		}*/
		
		//以上代码变为
		CustomException customException = null;
		if (ex instanceof CustomException) {
			customException = (CustomException)ex;
		}else {
			customException = new CustomException("未知错误");
		}
		
		// 错误信息
		String message = customException.getMessage();
		
		ModelAndView modelAndView = new ModelAndView();
		
		// 将错误信息传到页面
		modelAndView.addObject("message", message);
		
		// 指定错误页面
		modelAndView.setViewName("error");
		return modelAndView;
	}
	
}
