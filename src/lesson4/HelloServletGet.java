package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServletGet")
public class HelloServletGet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServletGet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");

//        PrintWriter out = response.getWriter();
//        String title = "GET method html";
//        String name =new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
//        String docType = "<!DOCTYPE html> \n";
//        out.println(docType +
//            "<html>\n" +
//            "<head><title>" + title + "</title></head>\n" +
//            "<body bgcolor=\"#f0f0f0\">\n" +
//            "<h1 align=\"center\">" + title + "</h1>\n" +
//            "<ul>\n" +
//            "  <li><b>name</b>："
//            + name + "\n" +
//            "  <li><b>url</b>："
//            + request.getParameter("url") + "\n" +
//            "</ul>\n" +
//            "</body></html>");

    	//JSP
        response.sendRedirect("./main.jsp?name=" + request.getParameter("name") + "&url=" + request.getParameter("url") );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	response.getWriter().write("hello post");
//        doGet(request, response);
    }

}