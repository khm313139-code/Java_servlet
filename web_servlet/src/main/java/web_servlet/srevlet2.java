package web_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import 안쓰는거 날려줘야 메모리를 덜 사용한다.

public class srevlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ArrayList<String> member = new ArrayList<String>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		String mname = request.getParameter("mname");
		String mtel = request.getParameter("mtel");
		String memail = request.getParameter("memail");
		
		//PrintWriter : 웹에서 java script 언어를 사용할 수 있는 유일한 io 입니다.
		PrintWriter pw = response.getWriter(); //응답을 뿌린다.
		
		
		if(mid.equals("") || mpass.equals("") || mname.equals("") || mtel.equals("") || memail.equals("")) {
			
			//자바 스크립트 코드를 printwrite에 사용하는 방식
			pw.write("<script>"
					+ "alert('올바른 정보가 아닙니다.');"
					+ "history.go(-1)"
					+ "</script>"); //history.go(-1) 한 단계 전 페이지로 이동하는 메소드
			
			pw.close();
		}
		else {
			this.member.add(mid);
			this.member.add(mpass);
			this.member.add(mname);
			this.member.add(mtel);
			this.member.add(memail);
		}
		//System.out.println(this.member);
		request.setAttribute("member", this.member);
		RequestDispatcher rd = request.getRequestDispatcher("./servlet2.jsp");
		rd.forward(request, response);
	}
}
