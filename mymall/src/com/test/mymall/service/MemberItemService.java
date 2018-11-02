package com.test.mymall.service;

import java.sql.Connection;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.MemberItem;

public class MemberItemService {
	
/*	private MemberItemDao memberItemDao;

	public void insertMemberItem(MemberItem memberitem) {
		System.out.println("MemberItemService insertMemberItem");
		Connection conn=null;
		try {
			conn=DBHelper.getConnection();
			this.memberItemDao=new MemberItemDao();
			this.memberItemDao.insertMemberItem(conn, memberitem);
		} catch(Exception e) {
        	e.printStackTrace();
        } finally {
        	DBHelper.close(null, null, conn);
        }
	}
	*/
}
