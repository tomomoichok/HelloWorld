package com.web.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.Bean.UserBean;
import com.web.DB.UserTable;

/**
 * Servlet implementation class UserDel
 */
@WebServlet("/UserDel")
public class UserDel extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDel() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("hello .................");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	UserTable db = new UserTable();
        UserBean bean = new UserBean();
        bean.setUserId(Integer.parseInt(request.getParameter("userId")));
        db.DeleteUser(bean);
        ArrayList<UserBean>datas = db.exeSelectDB(bean);
        db.DBClose();
        HttpSession session=request.getSession();
        session.setAttribute("dataList",datas);
        response.sendRedirect("./userList.jsp");
    }

}