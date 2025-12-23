package web_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class password extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String mid = request.getParameter("mid");
		String username = request.getParameter("username");
		
		String message = "";
		if(mid.equals("hong_gildong")&&username.equals("홍길동")) {
			message="a123456";
		}
		else {
			message="해당 사용자의 정보를 확인하지 못했습니다.";
		}
		
		//**Servlet과 JSP 사이에서 사용하는 “이름표(키)”**야. => "message"
		//setAttribute( "이름표", 값 ); - 뒤에 있는건 변수명 실제 jsp에서 받는건 "message"
		request.setAttribute("message", message);
		request.setAttribute("part", "pw");
		
		RequestDispatcher rd = request.getRequestDispatcher("./result.jsp");
		rd.forward(request, response);
	}

}
