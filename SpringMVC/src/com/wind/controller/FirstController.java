package com.wind.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wind.bean.User;

@Controller
@RequestMapping(value = "/First")
public class FirstController {

	/*
	 * 	服务器的根目录：http://localhost:8080/
	 * 	当前项目的根目录：http://localhost:8080/项目名
	 */
	
	/*
	 * 	SpringMVC运行流程：
	 * 		1）页面发起请求（index.jsp），因为我们在web.xml文件中配置了（springDispatcherServlet）拦截所有请求。
	 * 		2）拦截后会去配置Controller类中找（在springmvc.xml配置文件中配置了Controller类了），有没有RequestMapping和我请求的URL保持一致。
	 * 		3）有就走这个方法，没找到就报404。
	 */
	
	/*
	 * 	/WEB-INF/文件夹 外界（浏览器）不能直接访问的（安全）
	 */
	
	/*
	 * 	@RequestMapping（用于映射请求URL）（方法上是一定要标注的 也可以标注在类上）属性：
	 * 		value：要和RUL保持一致。它是一个数组。RequestMapping只有一个属性时 value可以省略：@RequestMapping("/success")。
	 * 			支持Ant（通配符）请求风格请求的URL：
	 * 				-	?		代表匹配请求路径中的任意一个字符
	 * 				-	*		代表匹配请求路径中的任意多个字符
	 * 				-	**		代表匹配请求路径中的多层路径
	 * 		method：表示请求的方式（默认不写四种请求方式都支持）（也是一个数组）：
	 * 			GET：超链接或者查询
	 * 			POST：添加或者上传文件
	 * 			PUT：更新数据
	 * 			DELETE：删除
	 * 		params：表示的是限制请求URL中携带的参数（限制 请求路径中带哪些参数、参数的值）
	 * 			params = {"username"}：请求路径必须携带username参数（http://localhost:8080/SpringMVC/First/index?username=aaa）
	 * 			params = {"username", "!password"}：请求路径必须携带username参数并且不能携带password参数（http://localhost:8080/SpringMVC/First/index?username=aaa&password=123  报404）
	 * 		headers：表示限制请求头信息。（指定的话 必须按指定的请求头走！浏览器按F12 NetWork查看请求头和响应头）
	 * 			headers = {"Accept-Language=zh-CN,zh;q=0.9"}  *中间不能有空格，params也一样 不能有空格！
	 */
	
	/*
	 *	@RequestParam(value = "username") String name
	 *		意思是：将请求的name值等于username的参数的值  绑定到 请求方法的 name这个变量上。
	 *			        如果表单中的 name值和方法中接收的变量名称一致时 注解可以省略。
	 *		* 目标方法上的参数顺序没关系！（耻辱啊 不说了！）
	 */
	
	/*
	 * 	处理请求乱码的问题：
	 * 		get请求乱码：在Tomcat服务器（包资源管理器的Servers）的server.xml文件中Connector标签那 port=8080 那加 URIEncoding="UTF-8"
	 *		post请求乱码：在web.xml文件中设置一个Filter，拦截所有请求（/*）将POST请求参数值的中文不乱码。
	 */
	
	/*
	 * 	如何给后台服务器发送PUT、DELETE请求：
	 * 		在web.xml文件中配置一个Filter，HiddenHttpMethodFilter（作用是将POST请求转换为PUT、DELETE请求）
	 */
	
	/*
	 * 	接收的参数：
	 * 		1）单个参数：name名和参数的变量名一致。
	 * 		2）接收数组： String[] hobby（用数组接收）
	 * 		3）接收POJO（普通的Java对象）：SpringMVC框架会将表单中的name值注入到POJO对象的属性值 框架帮我们完成 并且 会自动转换简单的数据类型。
	 */
	
	/*
	 * 	@RequestHeader(value = "User-Agent") String headerInfo
	 * 		将请求头 value值对应的信息绑定到 后面的变量上。
	 */
	
	// 在POJO中 params属性限制也是起作用的！
	@RequestMapping(value = {"/success/?", "/index"}, method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, params = {"username", "!password", "username!=aaa"}, headers = {"Accept-Language=zh-CN,zh;q=0.9"})
	public String toIndexPage(@RequestParam(value = "username") String name, String age, String[] hobby, User user, @RequestHeader(value = "User-Agent") String headerInfo) {
		System.out.println("Controller方法进来了！");
		if (hobby != null) {
			System.out.println("username的值是：" + name + "、年龄是：" + age + "岁、爱好有：" + Arrays.asList(hobby)); // Arrays.asList()：将数组转换为List
		}
		System.out.println("user的值是：" + user);
		System.out.println("请求头信息：" + headerInfo);
		return "success";	// *第一个斜杠代表当前项目的根目录。
		/*
		 * 	return 现在这样直接写页面是转发。
		 * 	重定向相当于浏览器给服务器又发了一次请求，而浏览器不能直接访问/WEB-INF/目录下的资源。（但是可以重定向到Controller类的方法！）
		 */
	}
	
	/*
	 * 	Rest请求风格 建议在请求路径中携带参数；@RequestMapping("getUserById/{id}") // 占位符占住请求路径
	 * 	而Http请求 习惯 ?username=ZhangSan&password=123
	 */
	
	/*
	 * 	@PathVariable(value = "id") String pathId	（用于接收请求路径中的值）
	 * 		将请求路径中的值 绑定到目标方法的变量上。
	 */
	@RequestMapping("getUserById/{id}")
	public String getUserById(@PathVariable(value = "id") String pathId) {
		System.out.println(pathId);
		return "success";
	}
	
	/*
	 * 	SpringMVC支持的返回值类型：
	 * 		1）String
	 * 		2）void	（看起来没返回值，其实是return ;）
	 * 		3）ModelAndView
	 */
	@RequestMapping("returnType")
	public ModelAndView returnType() {
		// 有参的会指定一个viewName（视图名），会经过视图解析器的解析 转化为物理视图并转发过去。
		ModelAndView mv = new ModelAndView("success");
		// 把数据放到ModelAndView中，ModelAndView会经过Spring框架的解析 会把数据放到request域中一份，所有可以用EL表达式在页面获取。
		mv.addObject("list", Arrays.asList(new Integer[] {1,2,3,4,5}));
		return mv;
	}
	
	/*
	 * 	SpringMVC转发与重定向：
	 * 		转发：    return "forward:/list.jsp";
	 * 		重定向：return "redirect:/list.jsp";
	 */
	@RequestMapping("redirect")
	public String redirect() {
		return "redirect:/list.jsp";	// 重定向不能直接访问/WEB-INF/目录下的资源，并且它也不会经过视图解析器。
	}
	@RequestMapping("forward")
	public String forward() {
		return "forward:/list.jsp";	// 直接用forward转发也不会经过视图解析器。
	}
	
	/*
	 * 	SpringMVC对于JSON数据的处理：
	 * 		1）导入json.jar包
	 * 		2）@ResponseBody
	 */
	@RequestMapping("toJson")
	@ResponseBody
	public List<User> toJson() {
		List<User> list = new ArrayList<User>();
		User user = new User("一蛋", "123", 24);
		list.add(user);
		user = new User("二蛋", "456", 45);
		list.add(user);
		user = new User("三蛋", "789", 15);
		list.add(user);
		return list;
	}
}
