package com.perma.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.perma.dao.TaskDAO;
import com.perma.model.Task;
import com.perma.sevice.TaskService;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

	@Resource
	private TaskDAO taskDao;

	public int add(Task task) {
		return taskDao.add(task);
	}

	public int update(Task task) {
		return taskDao.update(task);
	}

	public int delete(int id) {
		return taskDao.delete(id);
	}

	public List<Task> getAll() {
		return taskDao.getAll();
	}
}
