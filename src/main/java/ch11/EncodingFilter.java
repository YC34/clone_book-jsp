package ch11;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;


@WebFilter("/*nhn")
public class EncodingFilter implements Filter{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if(request.getMethod().equalsIgnoreCase("POST")){
            servletRequest.setCharacterEncoding("UTF-8");

        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
