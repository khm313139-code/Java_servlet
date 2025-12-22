package web_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
//http://mekeyace.kbsn.or.kr/servlet_test.zip
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String usernm = request.getParameter("usernm");
		String con = request.getParameter("con");
		String pw = request.getParameter("pw");
		
		PrintWriter pw1 = response.getWriter();

		if (title.equals("") || usernm.equals("") || con.equals("") || pw.equals("")) {
		    pw1.write("<script>"
		    +"alert('모든 항목을 입력하세요.');"
		    +"history.go(-1)"
		    +"</script>");
		    
		    pw1.close();
		    
		    return;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());

		
		ArrayList<String> board = new ArrayList<String>();
		board.add(title);
		board.add(usernm);
		board.add(con);
		board.add(date);
		
		request.setAttribute("board", board);
		
		RequestDispatcher rd = request.getRequestDispatcher("./servlet3.jsp");
		rd.forward(request, response);
	}

}
