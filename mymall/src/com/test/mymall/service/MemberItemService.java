package com.test.mymall.service;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.MemberItem;

public class MemberItemService {
	
private MemberItemDao memberItemDao;

	public void insertMemberItem(MemberItem memberitem) {
		System.out.println("MemberItemService insertMemberItem");
		SqlSession sqlSession=null;
		try {
			sqlSession=DBHelper.getSqlSession();
			this.memberItemDao=new MemberItemDao();
			this.memberItemDao.insertMemberItem(sqlSession, memberitem);
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
        } finally {
        	sqlSession.close();
        }
	}
	
}
