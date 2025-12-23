package web_servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://mekeyace.kbsn.or.kr/book.txt

/*
{
  {"안녕이라 그랬어","정현우","35000"},
  {"노 피플 존","이석영","25000"},
  {"머니 트렌드","정현우","15000"},
  {"부자의 조건","소준섭","20000"},
  {"영혼의 편지","김상욱","28000"},
  {"최소한의 삼국지","정재승","31000"},
  {"이상비행","이금희","29000"}
}

*/
public class servlet9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String choice = request.getParameter("choice");
		String search = request.getParameter("search");
		
		
		String name[][] = {
				{"안녕이라 그랬어","정현우","35000"},
				{"노 피플 존","이석영","25000"},
				{"머니 트렌드","정현우","15000"},
				{"부자의 조건","소준섭","20000"},
				{"영혼의 편지","김상욱","28000"},
				{"최소한의 삼국지","정재승","31000"},
				{"이상비행","이금희","29000"}
		};
		
		ArrayList<ArrayList<String>> al2 = new ArrayList<ArrayList<String>>();
		
		for(int i = 0; i<name.length; i++) {
			if(choice.equals("name") && name[i][0].contains(search)) {
				ArrayList<String> data = new ArrayList<String>();
				data.add(name[i][0]);
				data.add(name[i][1]);
				data.add(name[i][2]);
				al2.add(data);
		}
		
			if(choice.equals("auth") && name[i][1].contains(search)) {
				ArrayList<String> data = new ArrayList<String>();
				data.add(name[i][0]);
				data.add(name[i][1]);
				data.add(name[i][2]);
				al2.add(data);
			}
		}
	request.setAttribute("result", al2);
	request.getRequestDispatcher("./servlet9.jsp").forward(request, response);
	}
}


