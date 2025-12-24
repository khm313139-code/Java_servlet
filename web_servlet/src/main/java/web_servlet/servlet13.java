package web_servlet;
//controller 임
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servlet13 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String message=""; //자바 스크립트 언어를 적용하기 위한 변수
		
		String agree1 = request.getParameter("agree1");
		String agree2 = request.getParameter("agree2");
		String agree3 = request.getParameter("agree3");
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String memail = request.getParameter("memail");
		String person = request.getParameter("person");
		
		ArrayList<String> userinfo = new ArrayList<String>(); 
		//보통 여기에 null 때려놓으면 jsp 에서는 if(userinfo.size()>0) { 이거 null로 검토가 가능하지만
		//이거는 이미 배열을 만들어서 넘기기 때문에 jsp에서는 if(userinfo.size()>0) 이렇게 해야한다.
		
		if(!"Y".equals(agree1) || !"Y".equals(agree2) || !"Y".equals(agree3)) {
			message = "alert('올바른 방식의 접근이 아닙니다.'); history.go(-1);";
		}
		
		else {
			userinfo.add(mid);
			userinfo.add(mpw);
			userinfo.add(memail);
			userinfo.add(person);
		}
		
		
		request.setAttribute("message", message); //이거 순서 바꾸면 안됨
		request.setAttribute("userinfo", userinfo);
		
		RequestDispatcher rd = request.getRequestDispatcher("./servlet13.jsp");
		rd.forward(request, response);
		
	}

}
