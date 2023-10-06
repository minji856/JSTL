package myservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ELTestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		
		/* 방문자 수를 구했다 치고 */
		req.setAttribute("visitCount", 100);
		
		String[] favorateFood = {"냉면" , "돼지갈비" , "순대국" , "콩국수"};
		req.setAttribute("foods", favorateFood);
		
		/* 다른 애에게 역할을 맡기겠다 지금 받은 정보를 이 페이지에 넘겨줄 계획이다 */
		RequestDispatcher view = req.getRequestDispatcher("test08_proc.jsp");
		view.forward(req, resp);
	}
}
