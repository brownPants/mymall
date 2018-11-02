package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Item;

public class ItemDao {
	
	//상품 리스트 처리
	public ArrayList<Item> selectItemList(Connection conn, HashMap<String, Object> map) throws SQLException {
		System.out.println("MemberDao selectItemList");
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Item> list=new ArrayList<Item>();
        stmt = conn.prepareStatement("SELECT no, name, price FROM mall.item ORDER BY no DESC LIMIT ?, ?");
        stmt.setInt(1, (int)map.get("startRow"));
        stmt.setInt(2, (int)map.get("pagePerRow"));
        rs = stmt.executeQuery();
        while(rs.next()) {
        	Item item=new Item();
        	item.setNo(rs.getInt("no"));
        	item.setName(rs.getString("name"));
        	item.setPrice(rs.getInt("price"));
        	list.add(item);
        }
        DBHelper.close(rs, stmt, null);
		return list;
	}
	//상품 총 갯수
	public int selectItemListCount(Connection conn) throws SQLException {
		System.out.println("MemberDao selectItemListCount");
        PreparedStatement stmt=null;
        ResultSet rs=null;
        int itemRowCount=0;
		stmt=conn.prepareStatement("SELECT COUNT(*) FROM mall.item");
		rs=stmt.executeQuery();
		if(rs.next()) {
			itemRowCount=rs.getInt(1);
		}
		DBHelper.close(rs, stmt, null);
		return itemRowCount;
	}
	
}
