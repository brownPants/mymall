package com.test.mymall.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {
	
	private MemberDao memberDao;
	private MemberItemDao memberItemDao;
	
	// RemoveMemberController에서 MemberService.removeMember()호출
	public void removeMember(int no) {
		Connection conn=null;
		try {
			conn=DBHelper.getConnection();
			conn.setAutoCommit(false); // 자동 commit X
			// 첫번째 기능
			memberItemDao=new MemberItemDao();
			memberItemDao.deleteMemberItem(conn, no);
			// 두번째 기능
			memberDao=new MemberDao();
			memberDao.deleteMember(conn, no);
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
        	e.printStackTrace();
        } finally {
        	DBHelper.close(null, null, conn);	
        }
	}
	// 로그인 처리 서비스
	public Member login(Member member) {
		System.out.println("MemberService login");
		Connection conn=null;
		Member resultMember=null;
		try {
			conn=DBHelper.getConnection();
			memberDao=new MemberDao();
			resultMember=memberDao.login(conn, member);
		} catch(Exception e) {
        	e.printStackTrace();
        } finally {
        	DBHelper.close(null, null, conn);	
        }
		return resultMember;
	}
	// 회원가입 입력처리 서비스
	public void addMember(Member member) {
		System.out.println("MemberService addMember");
		Connection conn=null;
		try {
			conn=DBHelper.getConnection();
			memberDao=new MemberDao();
			memberDao.insertMember(conn, member);
		} catch(Exception e) {
        	e.printStackTrace();
        } finally {
        	DBHelper.close(null, null, conn);	
        }
	}
	
}
