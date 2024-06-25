package ch05;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
//import java.io.PrintWriter;


/**
 * @WebServlet이라는 어노테이션을 사용하지 않으면 , web.xml파일에 서블릿을 직접 등록해야한다.
 */

@WebServlet(description = "My first servlet" ,urlPatterns = {"/hello"})
public class HelloWorld extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HelloWorld() {
        super();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html; charset=UTF-8");
//        PrintWriter out = response.getWriter();
//            out.append("< !doctype html><html><head><title>Hello World</title></head><body>")
//                    .append("<h2>Hello World !!</h2><hr>")
//                    .append("현재 날짜와 시간은:" +java.time.LocalDateTime.now())
//                    .append("</body></html>");





    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
