package com.perma.dao;

import java.util.List;

import com.perma.model.Task;

public interface TaskDAO {

	public int add(Task task);

	public int delete(int id);

	public int update(Task task);

	public Task getTask(int id);

	public List<Task> getAll();
}
