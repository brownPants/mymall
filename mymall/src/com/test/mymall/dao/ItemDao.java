package com.test.mymall.dao;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.vo.Item;

public class ItemDao {
	
	//상품 리스트 처리
	public List<Item> selectItemList(SqlSession sqlSession, HashMap<String, Object> map) throws SQLException {
		System.out.println("MemberDao selectItemList");
		return sqlSession.selectList("com.test.mymall.dao.ItemMapper.selectItemList", map);
	}
	//상품 총 갯수
	public int selectItemListCount(SqlSession sqlSession) {
		System.out.println("MemberDao selectItemListCount");
		return sqlSession.selectOne("com.test.mymall.dao.ItemMapper.selectItemListCount");
	}
	
}
