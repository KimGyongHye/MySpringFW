package myspring.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	public UserController() {
		System.out.println("생성자 호출 됨");
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/userList.do")
	ModelAndView getUserList() {
		// ModelAndView : 전달받은 데이터와 화면정보를 한방에 담아주는 객체
		
		List<UserVO> userList = userService.getUserList();
		return new ModelAndView("userList","userList",userList);
	}
	
//	@RequestMapping(method = RequestMethod.GET, path = "/getUser.do")
//	ModelAndView getUserInfo(@RequestParam String id) {
//		
//		UserVO user = userService.getUser(id);
//		return new ModelAndView("userInfo","user",user);
//	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/getUser.do")
	String getUserInfo(@RequestParam(name = "id") String id, Model model) {

		UserVO user = userService.getUser(id);
		model.addAttribute("user",user);
		return "userInfo";
	}
	
	@RequestMapping(method = RequestMethod.GET,  path = "/updateUserForm.do")
	ModelAndView updateUserForm(@RequestParam(name = "id") String id) {
		
		UserVO user = userService.getUser(id);
		Map<String, Object> map = new HashMap<String, Object>();
		return new ModelAndView("userUpdate","user",user);
	}
	
	@RequestMapping(method = RequestMethod.POST,  path = "/updateUser.do")
	ModelAndView updateUserForm(@RequestParam UserVO user) {
		
		List<UserVO> userList = userService.getUserList();
		return new ModelAndView("userList","userList",userList);
	}
}
