/**   
*
* 
* 
*/
package com.wrp.ssm.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wrp.ssm.po.ActiveUser;
import com.wrp.util.ResourcesUtil;

/**   
* @Title: HandlerInterceptor1.java 
* @Description: 测试拦截器1：
* 1. SpringMVC拦截器针对HandlerMapping进行拦截设置。即是若在某个HandlerMapping中配置拦截，经过HandlerMapping映射成功的handler最终才使用该拦截器。（不推荐使用）
* 2. SpringMVC可以配合类似全局的拦截器，SpringMVC框架将配置的类似全局的拦截器注入到每个HandlerMapping中。
* 3. 多个拦截器同时放行时，多个拦截器的preHandle方法顺序执行；postHandle和afterCompletion方法逆序执行。
* 4. 如果有两个拦截器1和拦截器2：拦截器1放行，拦截器2不放行，则拦截器1放行，拦截器2的 preHandler才会执行，拦截器2的preHandler不放行，拦截器2的postHandler和afterCompletion不会执行。
*	   只要有一个拦截器不放行，postHandler不会执行。
* 5. 两个拦截器都不放行：只执行拦截器1的preHandler，其他都不执行
* @author LYleonard 
*/
public class LoginInterceptor implements HandlerInterceptor{

	// 进入Handler方法之前执行该方法
	// 用于身份认证、身份授权：比如如果认证不通过表示当前用户没有登录，需要此方法拦截不再执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取请求的url
		String url = request.getRequestURI();
		// 判断url是否为公开的地址（实际开发中将公开地址配置在配置文件中）
		// 这里公开的地址是登录提交的地址
		List<String> open_urls = ResourcesUtil.gekeyList("anonymousURL");
		// 遍历公开地址，如果是公开地址则放行
		for (String open_url:open_urls) {
			if (url.indexOf(open_url)>=0) {
				// 如果登录提交则放行
				return true;
			}
		}
		
		// 判断session
		HttpSession session = request.getSession();
		// 从session中取出用户身份信息
		ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
		if (activeUser!=null) {
			// 已登录
			return true;
		}
		// 执行到这里表示需要进行登录
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		// return false表示拦截，不再执行;return true表示放行
		return false;
	}

	/* 在进入Handler后，返回ModelAndView之前执行该方法
	 * 应用场景可以从ModelAndView出发：将公用的模型数据（比如菜单导航）在这里传到试图，也可以在此方法指定统一的视图
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}

	/* 在Handler执行完成后执行此方法
	 * 应用场景：可以用于统一的异常处理、统一的日志处理
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}

}
