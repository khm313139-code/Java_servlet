package web_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//@MultipartConfig -> io에서 날라온 것을 사용하기 위해서 (저장?) 사용하는 어노테이션(@) 코드
//메모리에 저장했다가 한번에 찍어버리는 역할
//버퍼역할임(메모리 역할) - buffered 역할
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 2, //한 개의 파일 전송 크기: 2mb (temp)
	maxFileSize = 1024 * 1024 * 3, //파일 한개당 최대 크기 : 3mb
	maxRequestSize = 1024 * 1024 * 100 //파일 전체 용량 : 100 MB
)
public class fileok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		
		
		
		Part mfile = request.getPart("mfile");
		//throws ServletException, IOException { 이거 붙어 있어서 try - catch 안써도 된다.
		String filename = mfile.getSubmittedFileName();
		long filesize = mfile.getSize();
		
		String file = mfile.getName(); //front에서 어떤 이름으로 날라왔는지 확인하는 것
		
		System.out.println(file);
		System.out.println(filename);
		System.out.println(filesize);
		//System.out.println(mfile);
		
		
		//request.getServletContext() : was의 전체 경로를 설정하는 class 입니다.
		//getRealPath(디렉토리명) : web 디렉토리를 말합니다.
		String url = request.getServletContext().getRealPath("/upload/");
		
		
		mfile.write(url + filename);
		
		pw.write("<script>"
				+ "alert('해당 파일을 올바르게 저장 하였습니다.');"
				+ "location.href='../ajax/file.html';"
				+ "</script>");
		pw.close();
		
	}
}
