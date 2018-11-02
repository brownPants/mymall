package com.test.mymall.service;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.vo.Member;

public class MemberService {
	
	private MemberDao memberDao;
	//private MemberItemDao memberItemDao;
	
	// RemoveMemberController에서 MemberService.removeMember()호출
	/*public void removeMember(int no) {
		SqlSession sqlSession=null;
		try {
			sqlSession=DBHelper.getSqlSession();
			//  sqlSession.setAutoCommit(false); 자동 commit X
			// 첫번째 기능
			memberItemDao=new MemberItemDao();
			memberItemDao.deleteMemberItem(conn, no);
			// 두번째 기능
			memberDao=new MemberDao();
			memberDao.deleteMember(conn, no);
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
        } finally {
        	sqlSession.close();
        }
	}*/
	// 로그인 처리 서비스
	public Member login(Member member) {
		System.out.println("MemberService login");
		SqlSession sqlSession=null;
		Member resultMember=null;
		try {
			sqlSession=DBHelper.getSqlSession();
			this.memberDao=new MemberDao();
			resultMember=this.memberDao.login(sqlSession, member);
		} catch(Exception e) {
        	e.printStackTrace();
        } finally {
        	sqlSession.close();	
        }
		return resultMember;
	}
	// 회원가입 입력처리 서비스
	public void addMember(Member member) {
		System.out.println("MemberService addMember");
		SqlSession sqlSession=null;
		try {
			sqlSession=DBHelper.getSqlSession();
			this.memberDao=new MemberDao();
			this.memberDao.insertMember(sqlSession, member);
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
        } finally {
        	sqlSession.close();
        }
	}
	
}
