package com.wind.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/file")
public class UploadAndDownload {

	/*
	 * 	过程遇到的错误：
	 * 		1）Caused by: java.lang.NoSuchMethodException: org.springframework.web.multipart.commons.CommonsMultipartFile.<init>()
	 * 			是因为：在接收 CommonsMultipartFile 对象时，需要在对象前加 @RequestParam 注解 。
	 * 		2）Required CommonsMultipartFile parameter 'pic' is not present
	 * 			是因为：添加@RequestParam 注解 后，接收到空的 CommonsMultipartFile 对象 , 所以 CommonsMultipartFile 允许为 null，添加required=false 即可。
	 * 		3)若name和接收的变量名不一样可以用value值绑定 ；一样可以省略。
	 * 		4）如上传多个文件：CommonsMultipartFile[] file（What！）
	 */
	
	/*
	 * 	若资源要被访问：
	 * 		必须放在Tomc服务器目录下。
	 * 		也可以放在项目中，因为项目就运行在Tomcat容器中。
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(@RequestParam(value = "file", required=false)CommonsMultipartFile file, HttpServletRequest request) {
		System.out.println(file);	// 文件对象已到后台
		// 1.通过HttpServletRequest获取文件在本地磁盘的真实路径
		ServletContext context = request.getServletContext(); 	// 当前项目（当前Web应用）
		String realPath = context.getRealPath("/upload"); 		// 上传文件夹的真实路径
		// 为了代码的健壮性，判断是否有该目录
		File uploadDir = new File(realPath);
		if (!uploadDir.exists()) {	// 如果不存在
			uploadDir.mkdirs();		// 创建出来
		}
		String fileName = file.getOriginalFilename();	// 上传文件的文件名
		// 如果文件名重复 会覆盖前面上传的文件，为避免我们一般是使用UUID+"_"+文件名。
		String uuid = UUID.randomUUID().toString();	// 根据电脑ID和时间戳生成 重复几率很小。
		String prifix = uuid.replaceAll("-", "");	// 生成的格式是：fss-23df-rre 有横杠的 一般会去掉横杆。
		fileName = prifix + "_" + fileName;			// 如果我们想获取真实的文件名 截第一下划线就可以。
		// 2.把上传的文件 写到upload文件夹；通过commons-io-2.4.jar里面有个工具类
		InputStream input = null;
		OutputStream output = null;
		try {
			input = file.getInputStream();			// 把文件转换为输入流
			output = new FileOutputStream(new File(realPath + "\\" + fileName));	// 创建输出流（真实路径 + 文件名）
			IOUtils.copy(input, output);			// 使用工具类
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("完成上传！");
		/*
		 * 	
		 * 	别高兴太早  是上传了 但是在文件夹中找不到？
		 * 		是上传到Tomcat服务器上了，不是Eclipse该项目的工作空间
		 * 		如果在本地Tomcat服务器也找不到，那是因为虽然配置了本地Tomcat 但是启动的是Eclipse工作空间中的 Tomcat的镜像（双击Servers Tomcat 查看）。
		 * 		查看镜像目录：工作空间/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/项目
		 */
		return "success";
	}
	
	@RequestMapping(value = "download", method = RequestMethod.GET)
	public ResponseEntity<byte[]> download(HttpServletRequest request) {	// 下载的返回值必须是它，要返回 所以在方法中创建出来 它没有无参构造器 只有有参构造器。
		String fileName = "风吹麦浪.mp3";
		// 要下载肯定要找到文件的真实路径，还得把HttpServletRequest整进来。
		ServletContext context = request.getServletContext();
		String realPath = context.getRealPath("/WEB-INF/" + fileName); 	// 获取到文件的真实路径
		InputStream input = null;
		try {
			input = new FileInputStream(realPath);	// 通过真实路径把它转换为输入流
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		byte[] body = null;
		try {
			body = new byte[input.available()];	// available() 返回输入流的大小
			input.read(body);	// 将文件的输入流写入到字节数组中
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			// 还要设置文件名的编码，要不然点下载时文件名是空的；并且要在设置头前设置 要不也不起作用！
			fileName = new String(fileName.getBytes("gbk"), "iso8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		MultiValueMap<String, String> headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=" + fileName);	// 将设置头设置为附件下载（不设置的话浏览器默认会文本打开）
		HttpStatus statusCode = HttpStatus.OK;	// 响应状态码，设置为OK！
		ResponseEntity<byte[]> result = new ResponseEntity<byte[]>(body, headers, statusCode);	// 下载需要返回的对象
		System.out.println("下载成功！");
		return result;
	}

}
