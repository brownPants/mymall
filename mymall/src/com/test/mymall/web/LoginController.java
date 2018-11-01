package com.test.mymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.dao.MemberDao;
import com.test.mymall.vo.Member;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	private MemberDao memberDao;
	
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
		this.memberDao=new MemberDao();
		Member member = this.memberDao.login(id, pw);
		if(member!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("loginMember", member);
			response.sendRedirect(request.getContextPath()+"/IndexController");
		} else {
			response.sendRedirect(request.getContextPath()+"/LoginController");
		}
	}

}
