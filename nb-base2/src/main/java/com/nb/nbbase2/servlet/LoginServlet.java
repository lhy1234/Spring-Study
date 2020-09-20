package com.nb.nbbase2.servlet;

import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * create by lihaoyang on 2020/9/9
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String msg = "username="+username+",password="+password;
        System.err.println(msg);

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("xxoo","nb-Jaava");
//        servletContext.add
        WebApplicationContext webCtx = (WebApplicationContext)servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        String[] names = webCtx.getBeanDefinitionNames();
        boolean e = webCtx.containsBean("sysUserController");
        System.err.println("sysUserController --- >" +e);

        for(String name:names){
            System.err.println("webCtx --- >" +name);
        }
        resp.getWriter().write(msg);
    }
}
