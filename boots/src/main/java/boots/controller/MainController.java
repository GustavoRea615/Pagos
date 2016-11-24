package boots.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	

	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("desing")
	public String desing(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "desing";
	}
	
	@GetMapping("task")
	public String task(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "task";
		
		
	}
	@GetMapping("customer")
	public String customer(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "customer";
	}
}

