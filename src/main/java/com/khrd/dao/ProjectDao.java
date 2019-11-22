package com.khrd.dao;

import java.util.List;

import com.khrd.dto.Project;

public interface ProjectDao {

	public List<Project> list();
	public void insert(Project project);
	public void update(Project project);
	public void delete(int no);
	public Project SelectByNo(int no);
}
