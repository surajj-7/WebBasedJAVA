package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;


import com.app.dao.UserDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet(value="/RS",loadOnStartup = 1)
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("in init>>>");
		try {
		userDao=new UserDaoImpl();
		}catch(Exception e)
		{
			throw new ServletException("error in int"+getClass(),e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy>>");
		try {
			userDao.cleanUp();
		}catch(Exception e) {
			System.out.println("err in destroy - " + getClass());
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter()){
			String fname=request.getParameter("fn");
			String lname=request.getParameter("ln");
			String email=request.getParameter("em");
			String password=request.getParameter("pass");
			String date=request.getParameter("dob");
			LocalDate date2=LocalDate.parse(date);
			
			
			double age=Period.between(date2,LocalDate.now()).getYears();
			
			if(age<21) {
				pw.print("<h5>Under Age , Please  <a href='login.html'>Retry</a><h5>");
			}
			else
			{	
			// 4. Invoke user dao's --sign in method for user authentication
			String user=userDao.voterRegistration(new User(fname,lname,email,password,Date.valueOf(date2)));
				
			}
		}catch(Exception e) {
			throw new ServletException("err in servicing " + getClass(), e);
		}
		
		
	}

}
