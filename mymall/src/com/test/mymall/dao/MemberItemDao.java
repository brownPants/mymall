package com.test.mymall.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.vo.MemberItem;

public class MemberItemDao {
	
	// 회원 탈퇴 시 주문 삭제 처리
	public void deleteMemberItem(SqlSession sqlSession, int memberNo) {
		System.out.println("MemberItemDao deleteMemberItem");
		sqlSession.delete("com.test.mymall.dao.MemberItemMapper.deleteMemberItem", memberNo);
	}
	// 주문 리스트 처리
	// MemberItem INNER JOIN item
	public List<HashMap<String, Object>> selectMemberItemList(SqlSession sqlSession, HashMap<String, Object> map) {
		System.out.println("MemberItemDao selectMemberItemList");
		return sqlSession.selectList("com.test.mymall.dao.MemberItemMapper.selectMemberItemList", map);
	}
	// 주문 총 갯수
	public int selectMemberItemListCount(SqlSession sqlSession, int MemberNo) {
		System.out.println("MemberItemDao selectMemberItemListCount");
		return sqlSession.selectOne("com.test.mymall.dao.MemberItemMapper.selectMemberItemListCount", MemberNo);
	}
	// 주문 추가 처리
	public void insertMemberItem(SqlSession sqlSession, MemberItem memberitem) {
		System.out.println("MemberItemDao insertMemberItem");
		sqlSession.insert("com.test.mymall.dao.MemberItemMapper.insertMemberItem", memberitem);
	}
	
}
