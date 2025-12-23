package web_servlet;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String search = request.getParameter("search");
		
		try { //암호화 해석한거 방법 프런트에서 날라오는 base64코드 복호화 시킴 java에서
			
			//프런트에서 base64 인코딩으로 보낼 경우 byte로 변환해서 사용
			byte decode [] = Base64.getDecoder().decode(search); //byte로 변환
			String product = new String(decode, StandardCharsets.UTF_8);
			
			
			// encodeURIComponent(snm.value); <- 프런트에서 이거 쓰면 URLDecoder.decode 필수로 적용해야만 정상적 반영됨.
			String result = URLDecoder.decode(product); //이거 url 컴포넌트 사용 앞단에서(프런트)
			
			System.out.println(result);

		}catch (Exception e) {
			System.out.println("디코딩 에러!!");
		}
	}

}
