package com.test.mymall.service;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {
	
	private MemberDao memberDao;
	private MemberItemDao memberItemDao;
	
	// 회원 정보 수정 서비스
	public void modifyMember(Member member) {
		System.out.println("MemberService modifyMember");
		SqlSession sqlSession=null;
		try {
			sqlSession=DBHelper.getSqlSession();
			this.memberDao=new MemberDao();
			this.memberDao.updateMember(sqlSession, member);
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
        } finally {
        	sqlSession.close();
        }
	}
	// 회원 탈퇴 서비스
	// RemoveMemberController에서 MemberService.removeMember()호출
	public void removeMember(Member member) {
		System.out.println("MemberService removeMember");
		SqlSession sqlSession=null;
		try {
			sqlSession=DBHelper.getSqlSession();
			// 첫번째 주문 삭제
			this.memberItemDao=new MemberItemDao();
			this.memberItemDao.deleteMemberItem(sqlSession, member.getNo());
			// 두번째 회원 삭제
			this.memberDao=new MemberDao();
			this.memberDao.deleteMember(sqlSession, member);
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
        } finally {
        	sqlSession.close();
        }
	}
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
