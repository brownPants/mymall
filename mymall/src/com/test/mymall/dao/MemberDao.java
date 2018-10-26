package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Member;

public class MemberDao {
	
	// 회원가입 입력처리
	public void insertMember(Member member) throws Exception {
		System.out.println("MemberDao insertMember");
		Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
    	conn = DBHelper.getConnection();
    	stmt=conn.prepareStatement("INSERT INTO mall.member(id, pw, level) VALUES (?, ?, ?)");
    	stmt.setString(1, member.getId());
		stmt.setString(2, member.getPw());
		stmt.setInt(3, member.getLevel());
		stmt.executeUpdate();
		DBHelper.close(rs, stmt, conn);
	}
	
}
