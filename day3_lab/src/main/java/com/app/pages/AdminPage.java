package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDao;
import com.app.dao.CandidateDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class AdminPage
 */
@WebServlet("/Admin")
public class AdminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Set content type
		response.setContentType("text/html");
		// 2. Get the PW
		try( PrintWriter pw=response.getWriter())
		{
			// 3. Get http session from WC
			HttpSession hs=request.getSession();
			// 4. get the user object from session
			User user=(User)hs.getAttribute("user_info");
			if(user.getRole().equals("admin"))
			{
				// 5. printing welcome msg for the Admin
				pw.print("<h4> Hello " + user.getFirstName() + " " + user.getLastName() + "</h4>");
				CandidateDaoImpl candidateDao=(CandidateDaoImpl)hs.getAttribute("candidate_dao");
				// 6. call dao's method to get top two candidates
				pw.println("<h5>"+candidateDao.topTwoCandidates()+"</h5>");
				// 7. call dao's method for getting vote analysis
				pw.print("<h5>"+candidateDao.voteAnalysis()+"</h5>");
				
				// 8. invalidate the session
				hs.invalidate();
				
				pw.print("<h5>You have logged out!<b> Please visit again</a></h5>");		
				
			}
		}catch(Exception e)
		{
			throw new ServletException("Admin page failed!!!"+ e);
		}
	}

}
