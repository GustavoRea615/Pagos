package boots.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


import boots.service.CustomerService;
import boots.service.DesingService;
import boots.service.TaskService;

@RestController
public class Controller {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private DesingService desingService;
	
	@GetMapping("/hello")
	public String hello(){
		return "Hello World forever";
		
	}
	/*
	@GetMapping("/all-tasks")
	public String allTasks(){
		return taskService.findAll().toString();
		
	}
	
	@GetMapping("/save")
	public String allTasks(@RequestParam String name, @RequestParam String desc){
		Task task = new Task(name, desc, new Date(), false);
		taskService.save(task);
		return "Task saved!";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int id){
		taskService.delete(id);
		return "Task deleted!";
		
	}
*/
}
