package com.test.mymall.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.MemberItem;

public class MemberItemService {
	
	private MemberItemDao memberItemDao;
	
	// 주문 리스트 서비스
	public List<HashMap<String, Object>> selectMemberItemList(HashMap<String, Object> map) {
		System.out.println("MemberItemService selectMemberItemList");
		SqlSession sqlSession=null;
		List<HashMap<String, Object>> list=null;
		try {
			sqlSession=DBHelper.getSqlSession();
			//리스트 처리
			int pagePerRow=10; // 페이지당 보여줄 글의 목록을 10개로 설정
			int startRow = ((int)map.get("currentPage")-1)*pagePerRow; // 현재페이지가 1페이지면 0행부터, 2페이지면 10행부터, 3페이지면 20행부터...
			map.put("startRow", startRow);
			map.put("pagePerRow", pagePerRow);
			this.memberItemDao=new MemberItemDao();
			list=this.memberItemDao.selectMemberItemList(sqlSession, map);
			//페이징 처리
			int memberitemRowCount=this.memberItemDao.selectMemberItemListCount(sqlSession, (int)map.get("memberNo"));
			int lastPage=memberitemRowCount/pagePerRow;
			if(memberitemRowCount%pagePerRow!=0) {
				lastPage++;
			}
			map.put("lastPage", lastPage);
		} catch(Exception e) {
        	e.printStackTrace();
        } finally {
        	sqlSession.close();
        }
		return list;
	}
	// 주문 추가 서비스
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
