package com.test.mymall.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberItemService;
import com.test.mymall.vo.Member;

@WebServlet("/OrderListController")
public class OrderListController extends HttpServlet {
	
	private MemberItemService memberItemService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderListController doGet()");
		int currentPage=1;
		if(request.getParameter("currentPage")!=null) {
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		Member member=(Member)request.getSession().getAttribute("loginMember");
		int memberNo=member.getNo();
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("currentPage", currentPage);
		map.put("memberNo", memberNo);
		this.memberItemService=new MemberItemService();
		List<HashMap<String, Object>> list=this.memberItemService.selectMemberItemList(map);
		request.setAttribute("orderList", list);
		request.setAttribute("paging", map);
		request.getRequestDispatcher("/WEB-INF/view/orderList.jsp").forward(request, response);
	}

}
