package com.khrd.handler;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;


import com.khrd.controller.CommandHandler;
import com.khrd.dao.ProjectDao;
import com.khrd.dto.Project;

import com.khrd.util.MyBatisSqlSessionFactory;

public class ListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		ProjectDao dao = sqlSession.getMapper(ProjectDao.class);

		List<Project> list = dao.list();
		request.setAttribute("list", list);
		sqlSession.commit();
		sqlSession.close();
		
		return "/WEB-INF/view/list.jsp";
		

		
		
	}

}
