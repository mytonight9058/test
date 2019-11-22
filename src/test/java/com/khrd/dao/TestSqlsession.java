package com.khrd.dao;


import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestSqlsession {

//	@Test
	public void testSqlsessionFactory() {
		SqlSessionFactory sqlSessionFactory = null;
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println(sqlSessionFactory);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSqlSession() {
		SqlSessionFactory sqlsessionFactory = null;
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			sqlsessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlsessionFactory.openSession();
			System.out.println(sqlSession);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
