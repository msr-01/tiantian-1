package com.msr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends BaseServlet {
	public String test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("=====TestServlet=========");
		return "member-list.jsp";
	}
	
}
