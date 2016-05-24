package com.perma.sevice;

import java.util.List;

import com.perma.model.Task;

public interface TaskService {

	public int add(Task task);

	public int update(Task task);

	public int delete(int id);

	public List<Task> getAll();
}
