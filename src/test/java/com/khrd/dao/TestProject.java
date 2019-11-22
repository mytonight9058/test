package com.khrd.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.khrd.dto.Project;
import com.khrd.util.MyBatisSqlSessionFactory;

public class TestProject {

	private ProjectDao dao = null;
	private SqlSession sqlSession = null;
	
	@Before
	public void openSqlSession() {
		
		sqlSession = MyBatisSqlSessionFactory.openSession();
		ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
	}
	@After
	public void closeSqlSession() {
		sqlSession.close();
	}
//	@Test
	public void SelectByNo() {	
		ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
		dao.SelectByNo(1);
		sqlSession.commit();		
	}
	@Test
	public void testInsert() {
		ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
		dao.insert(new Project(2, "t", "c", new Date(),new Date(), "i"));	
	}
//	@Test
	public void testUpdate() {
		ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
		dao.update(new Project(1, "t", "c", new Date(),new Date(), "i"));
	
	}
//	@Test
	public void testDelete() {
		ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
		dao.delete(1);	
	}
//	@Test
	public void list(){
		ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
		List<Project> list = dao.list(); 
		System.out.println(list);
	}
	
}
