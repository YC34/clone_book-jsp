//package com.book_clone.test;
//
//import java.io.*;
//
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//
//@WebServlet(name = "helloServlet", value = "/hello-servlet")
//public class HelloServlet extends HttpServlet {
//    private String message;
//
//    public void init() {
//        message = "Hello World!";
//        System.out.println("init~~ !::: ");
//    }
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        init();
//        response.setContentType("application/json");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
//        destroy();
//
//    }
//
//    public void destroy() {
//        message="ㅎ2ㅎ2";
//        System.out.println("end");
//    }
//}