package myservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybean.Dog;
import mybean.Person;

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
		
		ArrayList<String> movies = new ArrayList<String>();
		movies.add("영웅본색1");
		movies.add("영웅본색2");
		movies.add("영웅본색3");
		movies.add("어벤져스");
		req.setAttribute("movies", movies);
		/* 내가만든 객체 생성 + import */
		Person hong = new Person();
		Dog popee = new Dog();
		
		hong.setName("홍길동");
		popee.setName("뽀삐");
		
		hong.setDog(popee); /* 홍이란 사람은 자동으로 강아지를 가지게 된다 */
		req.setAttribute("hong", popee); /* request에 담았다는건 jsp에 전달하겠다는 의미*/
		
		/* 다른 애에게 역할을 맡기겠다 지금 받은 정보를 이 페이지에 넘겨줄 계획이다 */
		RequestDispatcher view = req.getRequestDispatcher("test08_proc.jsp");
		view.forward(req, resp);
	}
}
