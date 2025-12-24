package web_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


public class servlet11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); //한줄로 작성방법
		response.setCharacterEncoding("utf-8");
		
		//front에서 같은 name 속성에 이름으로 전달하였을 경우 배열 값으로 받아야하며, 그때 쓰는게 로 getparametervalues 메소드를 이용
		String user[] = request.getParameterValues("user"); //얘는 배열이다 원시배열
		//System.out.println(Arrays.toString(user));
		PrintWriter pw = response.getWriter();
		if(user.length<2) {
			pw.write("<script"
					+ "alert('2개 이상의 데이터가 아닙니다.');"
					+ "history.go(-1);"
					+ "</script>");
			pw.flush();
			pw.close();
			
			
		}
		else {
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("./servlet11.jsp");
			rd.forward(request, response);
				
		}
		
	}
}
