package com.test.mymall.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.ItemDao;
import com.test.mymall.vo.Item;

public class ItemService {
	
	private ItemDao itemDao;
	// 상품 리스트 서비스
	public List<Item> selectItemList(HashMap<String, Object> map) {
		System.out.println("ItemService selectItemList");
		SqlSession sqlSession=null;
		List<Item> list=null;
		try {
			sqlSession=DBHelper.getSqlSession();
			//리스트 처리
			int pagePerRow=10; // 페이지당 보여줄 글의 목록을 10개로 설정
			int startRow = ((int)map.get("currentPage")-1)*pagePerRow; // 현재페이지가 1페이지면 0행부터, 2페이지면 10행부터, 3페이지면 20행부터...
			map.put("startRow", startRow);
			map.put("pagePerRow", pagePerRow);
			this.itemDao=new ItemDao();
			list=this.itemDao.selectItemList(sqlSession, map);
			//페이징 처리
			int itemRowCount=this.itemDao.selectItemListCount(sqlSession);
			int lastPage=itemRowCount/pagePerRow;
			if(itemRowCount%pagePerRow!=0) {
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
	
}
