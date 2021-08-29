package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserDao;

import lombok.AllArgsConstructor;

@Service@AllArgsConstructor
public class UserService {

	private UserDao userDao; 
	private RuntimeService runtimeService;
	private TaskService taskService;
	
	public User Start() {
		User user = userDao.findById(1).get();
		Map<String, Object> variables = new HashMap<>();
		variables.put("name", user.getName());
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess", variables);
		user.setWorkflow(processInstance.getId());
		user = userDao.save(user);
		return user;
		
	}
	
	public void next() {
		User user = userDao.getById(1);
        Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("name", user.getName());
		Task task = taskService.createTaskQuery()
        .processInstanceId(user.getWorkflow())
        .singleResult();
		 taskService.complete(task.getId(), variables );
		 List<Task> tasks = taskService.createNativeTaskQuery()
		 .sql("SELECT * FROM ACT_RU_TASK where PROC_INST_ID_ = #{taskName}")
		 .parameter("taskName", user.getWorkflow())
		 .list();
		 tasks.forEach(e -> System.out.println(e.getTaskDefinitionKey()));
		 System.out.println("hhelo " +task.getTaskDefinitionKey());
			Task newtask = taskService.createTaskQuery()
			        .processInstanceId(user.getWorkflow())
			        .singleResult();
			 System.out.println("new task " +newtask.getTaskDefinitionKey());

	}

}
