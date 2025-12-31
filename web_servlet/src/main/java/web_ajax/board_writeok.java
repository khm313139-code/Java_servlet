package web_ajax;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


//MultipartConfig 설정
@MultipartConfig(
	 fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	 maxFileSize = 1024 * 1024 * 10,     // 파일 최대 10MB
	 maxRequestSize = 1024 * 1024 * 100
)

public class board_writeok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		System.out.println(content);
		
		//파일 속성을 체크하기 위한 배열값 - 이건 해보기 board_writeok.java
		
		String filetype[] = {"bmp","jpeg","jpg","png","svg","webp"};
		
		
		//저장 웹 경로
		String url = request.getServletContext().getRealPath("/upload/"); //웹 저장 경로
		
		
		//front에서 넘어온 name에 대한 파일 첨부사항을 체크하는 클래스 배열(지금은 자료형이 part임)을 이용하며 part 자료형으로 저장시킴
		Collection<Part> pt = request.getParts();
		
		
		for(Part p : pt) { //foreach를 이용하여 파일에 대한 각각 분리 작업
			if(p.getName().equals("file") &&p.getSize() > 0 ) {
				String filename = p.getSubmittedFileName();
				if(!filename.equals("")) {
					p.write(url+filename);
				}
				System.out.println(filename); //첨부된 파일명만 출력시킴
		
			}
		}
	}
}
