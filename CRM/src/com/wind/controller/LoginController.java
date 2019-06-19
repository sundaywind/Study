package com.wind.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wind.bean.Authority;
import com.wind.bean.User;
import com.wind.service.LoginService;
import com.wind.utils.Navigation;
/*
 	RedirectAttributes：是Spring mvc 3.1版本之后出来的一个功能，专门用于重定向之后还能带参数跳转的。
	他有两种带参的方式：
		第一种： 
			attr.addAttribute("param", value);  
			这种方式就相当于重定向之后，在url后面拼接参数，这样在重定向之后的页面或者控制器再去获取url后面的参数就可以了，但这个方式因为是在url后面添加参数的方式，所以暴露了参数，有风险！这样就相当于：return "redirect:/index?name=123&success=success"
		第二种： 
			attr.addFlashAttribute("param", value);
			这种方式也能达到重新向带参，而且能隐藏参数，其原理就是放到session中，session在跳到页面后马上移除对象。所以你刷新一下后这个值就会丢掉。
 */
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String goHome(@RequestParam(value = "username")String name, @RequestParam("password")String pwd, 
			Model model, RedirectAttributes  addAttribute, HttpServletRequest request) {
		if (name != null && name != "" && pwd != null && pwd != "") {
			User user = loginService.verifyUserLogin(name, pwd);
			if (user != null) {
				model.addAttribute("msg", "登陆成功！");
				//session.setAttribute("user", user);
				 HttpSession session = request.getSession();
				 session.setAttribute("user", user);
				return "view/success";
			}
		}
		addAttribute.addAttribute("message", "用户名或密码不能为空");
		return "redirect:/index";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		/*
		 * 	有两种方法可以清理HttpSession：
		 * 		session.removeAttribute("user") ： 清理session中对应的内容。（你把user放进session，<K,V>的方式 用K去清理对应的session内容）
		 * 		session.invalidate() ：清理session中所有的内容。
		 */
		session.removeAttribute("user");
		session.invalidate();
		return "login";
	}
	
	/*
		原导航栏信息是一个JSON数组文件，JSON数组中有很多属性 我后端要返回一个JSON数组 那些属性我们最好放在一个类对象中（JSON文件有什么属性 我们类对象要和它一致）
		List集合返回JSON数据是一个JSON数组，我们可以仿照原JSON文件格式，返回类似的样式。（就是中间逻辑得好好屡屡）
	*/
	@RequestMapping(value = "/menuNav", method = RequestMethod.GET)
	@ResponseBody
	public List<Navigation> gettUser(HttpSession session) {
		// List转化为JSON数据后就是一个JSON数组
		List<Navigation> list = new ArrayList<Navigation>();
		// 先从最外层开始 最大的数组（先把顶级的导航栏加入到List列表中）
		Navigation top = new Navigation(Long.MAX_VALUE, "客户关系管理系统"); // 为防止id和下面的子id冲突，我们将id设置为最大值。
		list.add(top);
		/**
		 * 	Why?我返回原样显示？没Tree（请求地址的menu和别的名重复）
		 */
		// 因为成功登陆后，我们已经把User的信息放入到HttpSession中，从session中获取权限信息。
		User user = (User) session.getAttribute("user");
		List<Authority> authorities = user.getRole().getAuthorities();
		// 创建一个存放父导航栏的Map集合，Map集合的键：就是父权限的id，值就是父权限对应的导航栏信息。
		Map<Long, Navigation> parentNavigations = new HashMap<Long, Navigation>();
		// 获取当前项目名（在导航栏请求信息中添加）
		String contextPath = session.getServletContext().getContextPath();
		// 遍历从Session中获取的权限信息
		for (Authority authority : authorities) {
			Navigation sonNavigation = new Navigation(authority.getId(), authority.getDisplayName());// 子权限对象
			sonNavigation.setUrl(contextPath + authority.getUrl());					// 给子权限的URL属性赋值
			// 当前登录用户的所有权限中获取它的父权限
			Authority parentAuthority = authority.getParentAuthority(); 
			Long id = parentAuthority.getId(); 							// 拿到父权限的ID
			Navigation parentNavigation = parentNavigations.get(id);	// 通过遍历的id，看看有没有id对应的父权限。
			// 如果为空 说明Map里面没有父权限的id对应的父权限
			if (parentNavigation == null) {	
				// 创建父权限的导航信息（ id还是从当前登录用户的父权限的id，text是当前登录用户的权限的名字）
				parentNavigation = new Navigation(id, parentAuthority.getDisplayName());	
				parentNavigation.setState("closed");					// 将父导航栏设置为关闭
				// 放入到Map中
				parentNavigations.put(id, parentNavigation);			
				// 把放入Map中的父导航栏信息加入到List中（是给顶级后面加孩子）
				top.getChildren().add(parentNavigation);
			}
			// 把子权限的信息加入到父导航栏中
			parentNavigation.getChildren().add(sonNavigation);
		}
		return list;
	}
}
