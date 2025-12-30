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

// MultipartConfig 설정
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 파일 최대 10MB
    maxRequestSize = 1024 * 1024 * 100   // 전체 요청 최대 100MB
)
public class noticewrite extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();

        Part filePart = request.getPart("file"); // name="file"과 일치
        String filename = "";
        long filesize = 0;

        if (filePart != null && filePart.getSize() > 0) {
            filename = filePart.getSubmittedFileName();
            //System.out.println(filename);
            filesize = filePart.getSize();

            // 실제 저장 경로
            String path = request.getServletContext().getRealPath("/upload/");
            filePart.write(path + filename);
            //System.out.println(path);
            System.out.println(path);
        }

        // alert 후 페이지 이동
        pw.write("<script>"
                + "alert('공지사항이 올바르게 등록 되었습니다.');"
                + "location.href='../ajax/notice_write.html';"
                + "</script>");
        pw.close();
    }
}
