package top.lothar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import top.lothar.bean.User;
import top.lothar.service.impl.UserServiceImpl;

@Controller	// @Controller 代表本Java类是controller控制层
public class UserController {
	
	/**
     * @RequestParam注解的作用是：根据参数名从URL中取得参数值
     * 
     * @param username
     *            用户名，一定要对应着表单的name才行
     * @param password
     *            用户密码，也应该对应表单的数据项
     * @param model
     *            一个域对象，可用于存储数据值
     * @return
     */
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping(value = "/login.spring")// @RequestMapping 注解可以用指定的URL路径访问本控制层(请求执行器)
	public String login(@RequestParam("username") String username , @RequestParam("password") String password,Model model){
		
		User result = new User();
		result = userServiceImpl.findByUser(username, password);
		if (result != null) {
            model.addAttribute("username", result.getUsername());
            return "ok";
        } else {
            model.addAttribute("username", result.getUsername());
            return "no";
        }
	}
}
