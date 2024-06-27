package ch10;

import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;


@WebServlet(urlPatterns = "/news.nhn")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10, location = "/Users/y_chan/study/JSP/test/src/main/java/ch10/img")
public class NewsController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private NewsDAO dao;
    private ServletContext ctx;

    private final String START_PAGE = "/ch10/newsList.jsp";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = new NewsDAO();
        ctx = getServletContext();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        dao = new NewsDAO();

        Method m; // java reflect
        String view = null;

        if(action== null){
            action = "listNews";
        }

        try{
            m = this.getClass().getMethod(action,HttpServletRequest.class);

            view = (String)m.invoke(this,request);

        }catch (NoSuchMethodException e){
            System.out.println("ERROR : "+  e.getMessage());
            ctx.log("요청 action 없음");
            request.setAttribute("error","action 파라미터가 잘못되었습니다.");
            view = START_PAGE;
        }catch (Exception e){
            System.out.println("ERROR : "+  e.getMessage());
        }



        if(view.startsWith("redirect:/")){
            String review = view.substring("redirect:/".length());
            response.sendRedirect(review);
        } else{
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request,response);
        }

    }

    public String addNews(HttpServletRequest request){
        News n = new News();
        try{
            Part part = request.getPart("file");
            String fileName = getFileName(part);
            if(fileName != null && !fileName.isEmpty()){
                part.write(fileName);
            }

            String title = request.getParameter("title");
            String date = request.getParameter("date");
            String content = request.getParameter("content");
            String img = request.getParameter("img");

            n.setTitle(title);
            n.setDate(date);
            n.setContent(content);
            n.setImg("/img/"+img);

            dao.addNews(n);

        }catch (Exception e){
            System.out.println("controller service ERROR  : "+  e.getMessage());
            ctx.log("뉴스 추가 과정에서 문제 발생 !");
            request.setAttribute("error","뉴스가 정상적으로 등록되지 않았습니다.");
            return listNews(request);
        }
        return "redirect:/news.nhn?action=listNews";
    }


    public String deleteNews(HttpServletRequest request){
        int aid = Integer.parseInt(request.getParameter("aid"));
        try {
            dao.delNews(aid);
        }catch (SQLException e){
            System.out.println("controller delete ERROR : " +  e.getMessage());
            ctx.log("뉴스 삭제 과정에서 문제 발생");
            request.setAttribute("error","뉴스가 정상적으로 삭제되지 않았습니다.");
            return listNews(request);
        }

        return "redirect:/news.nhn?action=listNews";

    }

    public String listNews(HttpServletRequest request){
        List<News> list;
        try{
            list = dao.getAll();
            request.setAttribute("newslist", list);
        }catch (Exception e){
            System.out.println("controller listNews ERROR : "+  e.getMessage());
            ctx.log("뉴스 목록 생성 과정에서 문제 발생 .");
            request.setAttribute("error","뉴스 목록이 정상적으로 처리되지 않았습니다.");
        }
        return "ch10/newsList.jsp";
    }


    public String getNews(HttpServletRequest request){
        int aid = Integer.parseInt(request.getParameter("aid"));
        try{
            News n = dao.getNews(aid);
            request.setAttribute("news", n);
        }catch (Exception e){
            System.out.println("controller getNews ERROR : "+  e.getMessage());
            ctx.log("뉴스를 가져오는 과정에서 문제 발생 !");
            request.setAttribute("error","뉴스를 정상적으로 가져오지 못했습니다.!");
        }
        return "ch10/newsView.jsp";
    }

    private String getFileName(Part part){
        String fileName = null;
        String header = part.getHeader("content-disposition");
        System.out.println("header =>"+header);
        int start = header.indexOf("filename=");
        fileName = header.substring(start+10,header.length()-1);
        ctx.log("파일명 :"+fileName);
        return fileName;
    }
}
