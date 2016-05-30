package com.mvc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.perma.model.Task;
import com.perma.service.TaskService;

@Controller
@RequestMapping("task")
public class TaskController {

	@Resource
	private TaskService taskService;

	private List<Task> tasklist;

	@RequestMapping("alltask")
	public ModelAndView allTask() {
		tasklist = taskService.getAll();
		if (tasklist != null) {
			return new ModelAndView("task/alltask", "tasklist", tasklist);
		}
		return new ModelAndView("user/hello", "errorMsg", "²éÕÒÊ§°Ü");
	}

	@RequestMapping("addpage")
	public String addPage() {
		return "task/add";
	}

	@RequestMapping("add")
	public ModelAndView add(Task task) {
		int result = taskService.add(task);
		if (result > 0) {
			tasklist.add(task);
			return new ModelAndView("task/alltask", "tasklist", tasklist);
		}
		return new ModelAndView("task/alltask", "errorMsg", "Ìí¼ÓÊ§°Ü");
	}

	@RequestMapping("delete")
	public ModelAndView delete(int id) {
		int result = taskService.delete(id);
		if (result > 0) {
			return new ModelAndView("redirect:/task/alltask.do");
		}
		return new ModelAndView("task/alltask", "errorMsg", "É¾³ýÊ§°Ü");
	}

	@RequestMapping("updatepage")
	public String updatePage(int id, ModelMap model) {
		Task task = null;
		Integer i = 0;
		for (Task t : tasklist) {
			if (t.getId() == id) {
				task = t;
				break;
			}
			i++;
		}
		model.put("task", task);
		model.put("num", i);
		return "task/update";
	}

	@RequestMapping("update")
	public ModelAndView update(int num, Task task) {
		int result = taskService.update(task);
		if (result > 0) {
			tasklist.set(num, task);
			return new ModelAndView("task/alltask", "tasklist", tasklist);
		}
		return new ModelAndView("redirect:/task/alltask.do", "errorMsg",
				"ÐÞ¸ÄÊ§°Ü");
	}
}
