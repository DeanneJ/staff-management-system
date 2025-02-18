package com.searchmember;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/searchstaffmembersevelet")
public class searchstaffmembersevelet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String staffmemberid = request.getParameter("staffmemid");

		try {
			List<staffmember> smdetails = staffmemberDButil.validate(staffmemberid);
			request.setAttribute("smdetails", smdetails);
		}
		catch(Exception e) {
			e.printStackTrace();
		}


		RequestDispatcher dis = request.getRequestDispatcher("staffmemberaccount.jsp");
		dis.forward(request, response);

	}

}
