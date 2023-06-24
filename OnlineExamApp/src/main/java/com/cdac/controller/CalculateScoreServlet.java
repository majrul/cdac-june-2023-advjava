package com.cdac.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.model.Option;
import com.cdac.model.Question;

/**
 * Servlet implementation class CalculateScoreServlet
 */
@WebServlet("/CalculateScoreServlet")
public class CalculateScoreServlet extends HttpServlet {

	int score = 0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Question question = (Question) session.getAttribute("q");
		
		int opNo = Integer.parseInt(request.getParameter("op"));
		Option selectedOption = question.getOptions().get(opNo);
		if(selectedOption.isRightAnswer())
			score ++;
		
		response.sendRedirect("QuestionLoaderServlet");
			
	}

}
