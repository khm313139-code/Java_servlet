package web_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ajax3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// cors를 정상적으로 요청을 받을 수 있도록 설정한 값
		// access-control-allow-origin : 특정 도메인 및 모든 외부 client 서버에서 접근을 허용해주는 사항
		// *: 모든 ip 및 도메인을 허락
		// "http://도메인" : 특정 도메인에 해당 되는 부분만 접속 허용
		
		//둘다 맞다 아래 코드는 cors 해결을 위한 코드
		//response.addHeader("access-control-allow-origin", "*");
		
		response.setHeader("access-control-allow-origin", "*");
//response.setHeader("access-control-allow-origin", "http://172.30.1.프론트앤드:8080이런식으로 특정 ip만 접속하게 할 수 있다.");
		
		response.setHeader("access-control-allow-credentials", "true"); 
		//쿠키라던가 http 인증서 관련된 것도 신용하기 때문에 응답 받을 수 있도록 허용해 주겠다는 코드 이렇게 하면 웬만한건 다 전송 가능하다.
		//access-control-allow-credentials : 인증 관련 사항을 정상적으로 외부에서 접근이 되도록 허용(API-KEY)
		
		
		PrintWriter pw = response.getWriter();
		
		try {
			String data = "[50,20,30,40,50]";
			pw.print(data);
			
			
		} catch (Exception e) {
			pw.print("error");
		} finally {
			pw.close();
		}
	}
}
