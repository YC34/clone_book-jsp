package ch11;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class ListenerExam implements ServletContextListener ,
        ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener {

    public ListenerExam() {
    }

    // ServletContext 시작
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("ServletContext 시작됨.");
    }

    // ServletContext 종료
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().log("ServletContext 종료됨.");
    }


    // ServletContext 속성추가
    public void attributeAdded(ServletContextAttributeEvent scae) {
        scae.getServletContext().log("ServletContext 속성 추가: "+scae.getValue());
    }

    // ServletContext 속성 변경
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        scae.getServletContext().log("ServletContext 속성 변경: "+scae.getValue());
    }

    // ServletContext 속성 삭제
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        scae.getServletContext().log("ServletContext 속성 삭제: "+scae.getValue());
    }
}

