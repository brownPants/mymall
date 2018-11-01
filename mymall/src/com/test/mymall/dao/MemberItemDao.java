package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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
}
