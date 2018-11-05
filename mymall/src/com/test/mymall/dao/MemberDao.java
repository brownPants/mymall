package com.test.mymall.dao;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.vo.Member;

public class MemberDao {
	
	// 로그인 실패시 -> null
	// 로그인 성공시 -> 성공한 Member객체
	public Member login(SqlSession sqlSession, Member member) {
		System.out.println("MemberDao login");
		return sqlSession.selectOne("com.test.mymall.dao.MemberMapper.login", member);
	}
	// 회원탈퇴 처리
	public void deleteMember(SqlSession sqlSession, Member member) {	
		System.out.println("MemberDao deleteMember");
		sqlSession.delete("com.test.mymall.dao.MemberMapper.deleteMember", member);
	}
	// 회원가입 입력처리
	public void insertMember(SqlSession sqlSession, Member member) {
		System.out.println("MemberDao insertMember");
        sqlSession.insert("com.test.mymall.dao.MemberMapper.insertMember", member);
	}
	
}
