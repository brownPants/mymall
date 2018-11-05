package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

@WebServlet("/ModifyMemberController")
public class ModifyMemberController extends HttpServlet {

	private MemberService memberService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ModifyMemberController doGet()");
		request.getRequestDispatcher("/WEB-INF/view/modifyMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ModifyMemberController doPost()");
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String level=request.getParameter("level");
		Member member=new Member();
		member.setId(id);
		member.setPw(pw);
		member.setLevel(Integer.parseInt(level));
		this.memberService=new MemberService();
		this.memberService.modifyMember(member);
		response.sendRedirect(request.getContextPath()+"/LogoutController");
	}

}
