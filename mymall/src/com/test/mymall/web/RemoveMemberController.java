package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

@WebServlet("/RemoveMemberController")
public class RemoveMemberController extends HttpServlet {
	
	private MemberService memberService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RemoveMemberController doGet()");
		request.getRequestDispatcher("/WEB-INF/view/removeMember.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RemoveMemberController doPost()");
		request.setCharacterEncoding("utf-8");
		String pw=request.getParameter("pw");
		Member member=(Member)request.getSession().getAttribute("loginMember");
		int no=member.getNo();
		String id=member.getId();
		Member removeMember=new Member();
		removeMember.setNo(no);
		removeMember.setId(id);
		removeMember.setPw(pw);
		this.memberService=new MemberService();
		// 입력한 pw와 데이터베이스의 회원정보가 일치하는지 확인
		if(this.memberService.login(removeMember)!=null) {
			this.memberService.removeMember(removeMember);
			response.sendRedirect(request.getContextPath()+"/LogoutController");
		} else {
			response.sendRedirect(request.getContextPath()+"/IndexController");
		}
	}

}
