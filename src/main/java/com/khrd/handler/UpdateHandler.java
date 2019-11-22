package com.khrd.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.khrd.controller.CommandHandler;

import com.khrd.dao.ProjectDao;
import com.khrd.dto.Project;

import com.khrd.util.MyBatisSqlSessionFactory;

public class UpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("get")) {
	
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			ProjectDao dao = sqlSession.getMapper(ProjectDao.class);		
			int no = Integer.parseInt(request.getParameter("no"));
			Project list = dao.SelectByNo(no);
			request.setAttribute("list",list );
			sqlSession.close();
			
			return "/WEB-INF/view/updateForm.jsp";
			
		} else if(request.getMethod().equalsIgnoreCase("post")) {
			
			int no = Integer.parseInt(request.getParameter("no"));
		
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String Start_date = request.getParameter("start_date");
			String End_date = request.getParameter("end_date");
			String state = request.getParameter("state");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			Date start_date = sdf.parse(Start_date);
			Date end_date = sdf.parse(End_date);
			
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
			dao.update(new Project(no, title, content, start_date, end_date, state));
			sqlSession.commit();
			sqlSession.close();
			
			response.sendRedirect(request.getContextPath()+"/list.do");
			
			
		}
		return null;
	}

}
