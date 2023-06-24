package com.cdac.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.model.Question;
import com.cdac.model.QuestionBankLoader;

/**
 * Servlet implementation class QuestionLoaderServlet
 */
@WebServlet("/QuestionLoaderServlet")
public class QuestionLoaderServlet extends HttpServlet {

	int qNo=0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionBankLoader qbLoader = new QuestionBankLoader();
		List<Question> questionsOnJava = qbLoader.loadQuestionsOnJava();
		
		if(qNo < questionsOnJava.size()) {
			Question question = questionsOnJava.get(qNo++);
			
			HttpSession session = request.getSession();
			session.setAttribute("q", question);
			
			response.sendRedirect("viewQuestion.jsp");
		}
		else
			response.sendRedirect("viewScore.jsp");
		
	}


}
