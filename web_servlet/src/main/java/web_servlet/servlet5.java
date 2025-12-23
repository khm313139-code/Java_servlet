package web_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//405 띄우기 싫을 때 이렇게 작성 - 405 뜨면 해커가 post만 날려야 하는구나 생각함
		//ip 알면 html 만들어서 때려볼 수 있다.
		//보안에 도움이 됨.
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8"); //자바 스크립트로 찍을거라서 한글 변환 필요
		PrintWriter pw = res.getWriter();
		pw.write( "<script>"
				+ "location.href='./servlet5.html';"
				+ "</script>");
		pw.close();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		//써야할때도 있고 안써야할때도 있음 왜냐면 홍길동@naver.com 이렇게 날라오는 경우도 있으니
		//그리고 도메인이 한국어 인 것을 처리해야 하니까 변환이 필요하다.
		//이메일 중 도메인이 한글로 된 사항이 있음
		
		/* name 2개 받음
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String email = email1 + "@" + email2; //만약 name 2개 쓰면 이렇게 하나하나 다 합쳐야한다.
		System.out.println(email1);
		System.out.println(email2);
		*/
		
		String email = request.getParameter("email");
		
		PrintWriter pw = response.getWriter();
		String message = ""; //스크립트 언어를 적용하기 위한 변수
		
		if(email.equals("khm31313@naver.com")) { //하나로 날아와서 이렇게 볼 수 있음 만약에 따로 날라오면 뒷단에서 합쳐서 검사해야함
			message = "alert('이미 가입된 이메일 입니다.'); history.go(-1);";
		}
		else {
			message = "alert('인증번호 이메일을 발송 하였습니다.'); history.go(-1);";
		}
		//자바 스크립트 태그를 이용하여 작동시키는 코드
		pw.write("<script>"+message+"</script>");
		
	}

}
