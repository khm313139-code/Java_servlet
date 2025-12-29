package web_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ajax5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
		String[][] companyUsers = {
				{"user01", "pass111!", "테크노솔루션", "김철수", "123-45-67890"},
				{"alpha_biz", "alpha99@!", "알파소프트", "이영희", "234-56-78901"},
				{"global_trade", "gt7788#", "글로벌무역", "박준호", "345-67-89012"},
				{"nature_farm", "nf123456", "네이처팜", "최미경", "456-78-90123"},
				{"blue_ocean", "blue!@#", "블루오션기획", "정태양", "567-89-01234"},
				{"smart_factory", "sf9876", "스마트공방", "강산아", "678-90-12345"},
				{"k_design", "kd_7410", "케이디자인", "조현우", "789-01-23456"},
				{"mega_corp", "mc0000**", "메가코퍼레이션", "윤지민", "890-12-34567"},
				{"fast_logis", "fl_9988", "신속로지스", "한상원", "901-23-45678"},
				{"dream_edu", "dream_77", "드림에듀케이션", "임수아", "012-34-56789"}
		};
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("access-control-allow-origin", "*");
		response.setHeader("access-control-allow-credentials", "true"); 
		
		String username = request.getParameter("username");
        String bizno = request.getParameter("bizno");
		System.out.println(username);
       
        
		PrintWriter out = response.getWriter();
		
		
		try {
			// 아이디 중복 체크
            if(!username.equals(null)) {
            	boolean ck = false;
                for(String[] user : companyUsers) {
                    if(user[0].equals(username.trim())) {
                        out.print("id_jb"); // 중복
                        ck=true;
                        break;
                    }
                }
                
                if(ck==false) {
                	out.print("id_ok"); // 사용 가능                	
                }
                
            }
            // 사업자 등록번호 중복 체크
            else if(!bizno.equals(null)) {
            	boolean ck = false;
                for(String[] user : companyUsers) {
                    if(user[4].equals(bizno.trim())) {
                        out.print("bz_jb"); // 중복
                        ck=true;
                        break;
                    }
                }
                if(ck==false) {
                out.print("bz_ok"); // 사용 가능
            
               }
            }
            else {
                out.print("error"); // 파라미터 없음
            }
        } catch(Exception e) {
            out.print("error");
        } finally {
            out.close();
        }
    }
}
