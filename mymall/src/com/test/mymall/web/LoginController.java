package com.test.mymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	private MemberService memberService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginController doGet()");
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginController doPost()");
		request.setCharacterEncoding("utf-8");
		// id, pw를 가져옴
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		Member member=new Member();
		member.setId(id);
		member.setPw(pw);
		this.memberService=new MemberService();
		Member resultMember = this.memberService.login(member);
		if(resultMember!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("loginMember", resultMember);
			response.sendRedirect(request.getContextPath()+"/IndexController");
		} else {
			response.sendRedirect(request.getContextPath()+"/LoginController");
		}
	}

}
