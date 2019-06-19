package com.wind.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wind.bean.User;

public class UserUtils {

	/**
	 * 	获取当前登录者对象
	 */
	public static User getUser(HttpServletRequest request) {
		/*User adminUser = null;
		if(SecurityUtils.getSubject().getSession().getAttribute("user")!=null){
		adminUser=(User) SecurityUtils.getSubject().getSession().getAttribute("user");
		}
		return adminUser;	*/
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return user;
	}
	/**
	 * 	获取当前用户
	 * @return 取不到返回 new User()
	 */
}
