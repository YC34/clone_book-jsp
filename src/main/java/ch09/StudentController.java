package ch09;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@WebServlet("/studentControl")
public class StudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    StudentDAO dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = new StudentDAO();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String view ="";
        if(request.getParameter("action") == null){
            getServletContext().getRequestDispatcher("/studentControl?action=list")
                    .forward(request, response);
        } else {
            switch (action) {
                case "list" : view = list(request,response);
                    break;
                case "insert" : view = insert(request,response);
                    break;
            }
            getServletContext().getRequestDispatcher("/ch09/"+view)
                    .forward(request,response);
        }
    }

    public String list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("students", dao.getAll());
        return "studentInfo.jsp";
    }

    public String insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student s = new Student();
        String username = request.getParameter("username");
        String univ = request.getParameter("univ");
        Date birth = java.sql.Date.valueOf(request.getParameter("birth"));
        String email = request.getParameter("email");

        s.setUsername(username);
        s.setUniv(univ);
        s.setBirth(birth);
        s.setEmail(email);

        dao.insert(s);
        return list(request,response);
    }
}
