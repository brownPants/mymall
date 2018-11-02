package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Member;

public class MemberDao {
	
	// 로그인 실패시 -> null
	// 로그인 성공시 -> 성공한 Member객체
	public Member login(Connection conn, Member member) throws SQLException {
		System.out.println("MemberDao login");
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Member resultmember=null;
		stmt=conn.prepareStatement("SELECT id, pw, level FROM mall.member WHERE id = ? AND pw = ?");
		stmt.setString(1, member.getId());
		stmt.setString(2, member.getPw());
		rs=stmt.executeQuery();
		if(rs.next()) {
			resultmember=new Member();
			resultmember.setId(rs.getString("id"));
			resultmember.setPw(rs.getString("pw"));
			resultmember.setLevel(rs.getInt("level"));
		}
		DBHelper.close(rs, stmt, null);
		return resultmember;
	}
	// 회원탈퇴 처리
	public void deleteMember(Connection conn, int no) {
		System.out.println("MemberDao deleteMember");
	}
	// 회원가입 입력처리
	public void insertMember(Connection conn, Member member) throws SQLException {
		System.out.println("MemberDao insertMember");
        PreparedStatement stmt=null;
        stmt=conn.prepareStatement("INSERT INTO mall.member(id, pw, level) VALUES (?, ?, ?)");
    	stmt.setString(1, member.getId());
		stmt.setString(2, member.getPw());
		stmt.setInt(3, member.getLevel());
		stmt.executeUpdate();
		DBHelper.close(null, stmt, null);
	}
	
}
