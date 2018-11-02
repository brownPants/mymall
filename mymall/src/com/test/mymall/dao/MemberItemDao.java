package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.MemberItem;

public class MemberItemDao {
	
	public void deleteMemberItem(Connection conn, int no) throws SQLException {
		PreparedStatement stmt=conn.prepareStatement("");
	}
	// MemberItem INNER JOIN item
	public ArrayList<HashMap<String, Object>> getMemberItemList(int MemberNO) throws SQLException {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String sql = "";
		/*
	 	SELECT mi.`no`, mi.order_date, mi.item_no, i.name, i.price
		FROM member_item mi INNER JOIN item i
		ON mi.item_no = i.`no`
		WHERE mi.member_no = 1
		 */
		ResultSet rs= null;
		while(rs.next()) {
			// MemberItemJoinItem -> HashMap
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("memberItemNo", rs.getInt("mi.no"));
			map.put("itemPrice", rs.getInt("mi.price"));
		}
		return list;
	}
	public void insertMemberItem(Connection conn, MemberItem memberitem) throws SQLException {
		System.out.println("MemberItemDao insertMemberItem");
		PreparedStatement stmt=null;
		stmt=conn.prepareStatement("INSERT INTO mall.member_item(member_no, item_no, order_date) VALUES (?, ?, now())");
		stmt.setInt(1, memberitem.getMemberNo());
		stmt.setInt(2, memberitem.getItemNo());
		stmt.executeUpdate();
	}
}
