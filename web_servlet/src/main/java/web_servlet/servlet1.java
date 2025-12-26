package web_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//연결확인
//연결

/**
 * Servlet implementation class servlet1
 */
/*
 * 다 지워버려야 함 저 get post 빼고(왜냐면 post 통신이므로 get은 필요없다.)
 * 해당 class는 웹에서 가상으로 제공되는 java 입니다. 
 * 즉, extends httpservelet servelet이라는 class를 상속 받아서 웹이 작동 되도록 하는 웹 전용 클래스 입니다.
 * 
 * doget - get 통신
 * dopost - post 통신
 */
@WebServlet("/servlet1")

//controller 영역
public class servlet1 extends HttpServlet {
	// 해당 웹 페이지에 접근하는 호출 가능 용량
	private static final long serialVersionUID = 1L; //애초부터 크게 잡아놓으면 static 메모리니까 메모리가 바닥나버림 크게 잡아놓으면 안됨.
	//위 코드는 서버에 얼마나 접속하는지 counting 하는 코드임.
       
  
	//request => 데이터를 받는 역할 / response => 데이터를 출력하는 역할
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		response.setContentType("text/html"); //이거 do파일이라서 html코드가 없다 그래서 변환하는 코드가 들어가야 한다.
		//jsp에 전달될 데이터를 문자 또는 html 코드로 전달 할 수 있는 기능
		response.setCharacterEncoding("utf-8"); //jsp로 전달할 때 언어셋(do 입장에서)
		request.setCharacterEncoding("utf-8"); //html에서 name 속성을 받을 때 출력되는 가상의 언어셋
		
		
		//request.getParameter: Front에서 name 속성의 이름
		String usernm = request.getParameter("usernm");
		String message = "";
			if(usernm.equals("홍길동")) {
				message = "해당 사용자는 실버회원 입니다.";
			}
			else {
				message = "해당 사용자는 확인되지 않습니다.";
			}
			
		//request.setAttribute -> java class에서 jsp에 출력하기 위한 메소드
		//request.getAttribute -> java class에서 보내준 데이터를 로드하는 메소드
		request.setAttribute("message", message); //해당 ("별명명칭", 변수)
		
		//RequestDispatcher: view를 담당하며 해당 jsp의 대한 경로 및 파일명을 설정
		RequestDispatcher rd = request.getRequestDispatcher("/servlet1.jsp");
		rd.forward(request, response); //.do가 실행되었을 때 .jsp 파일을 로드하여 같이 출력
		
		
	}

}
