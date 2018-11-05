package com.test.mymall.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberItemService;
import com.test.mymall.vo.Member;
import com.test.mymall.vo.MemberItem;


@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	
	private MemberItemService memberItemService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderController doGet()");
		Member member=(Member)request.getSession().getAttribute("loginMember");
		int memberNo=member.getNo();
		int itemNo=Integer.parseInt(request.getParameter("itemNo"));
		MemberItem memberItem=new MemberItem();
		memberItem.setMemberNo(memberNo);
		memberItem.setItemNo(itemNo);
		this.memberItemService=new MemberItemService();
		this.memberItemService.insertMemberItem(memberItem);
		response.sendRedirect(request.getContextPath()+"/IndexController");
	}

}
