package web_servlet;

//해당 class는 view가 없이 스크립트로 핸들링 후 다른 페이지로 이동

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//날라오는게 한글이 없으면 utf-8로 설정해주는거 안해도 됨
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//이 두가지만 쓴 이유는 해당 자바에서 자바 스크립트로 메세지를 출력하기 위해 한글 깨짐 방지(alert에 있는 한글)
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		String corp = request.getParameter("corp");
		
		if(corp.equals("")) {
			System.out.println("통신사 선택을 안함");
		}
		else {
			System.out.println(corp);
		}
		
		
		
		
		
		
		//체크박스는 체크를 안할 경우 null 값으로 적용이 되므로, equals를 사용하지 못한다. 절대 절대
		String ck = request.getParameter("ck");
		PrintWriter pw = response.getWriter(); //자동로그인은 사용자 선택이라 js에서 확인할 수 없으니 빽단에서 확인해야함
		//그래서 바로 찍어버림
		
		try {
		if(ck==null) { 
			//자동로그인은 사용자 선택이라 js에서 확인할 수 없으니 빽단에서 확인해야함
			//checkbox를 적용시 필수조건이 아닐 경우는 다음과 같이 적용해야만 합니다.
			
			
			//근데 이때 확인할때 사용자가 입력하고 날라온게 없으면 equals 쓰면 절대 안됨.
			//ck==null 이런 식으로 비교해야함.
			
			pw.write("<script>"
					+ "alert('자동 로그인이 무조건 체크 되어야 함');"
					+ "history.go(-1);"
					+ "</script>");
			
		}
		
		else {
			pw.write("<script>"
					+ "alert('pc방이나 공공장소에는 유의 하십시오');"
				 /* + "location.href='http://naver.com';" */
					+ "</script>");
					
					
			
		}
		}catch (Exception e) {
			System.out.println("전송 오류 발생!!");
		}finally {
			pw.close();
		}
		//pw.write(null);
		
		
		
		//.intern()을 붙일 수 있는 경우 => HTML에서 사용자가 필수로 무조건 입력하는 사항
		String no = request.getParameter("no").intern(); //연산기호 쓰려고 사용하는게 인턴
		String ag = request.getParameter("ag");
		
		
		if(no=="") { //equals는 사용자가 입력한 상황에서만 사용하는 것임
			System.out.println("테스트");
		}
			System.out.println(no);
	}

}
