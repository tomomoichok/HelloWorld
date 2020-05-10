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
 * Servlet implementation class UserSearch
 */
@WebServlet("/UserSearch")
public class UserSearch extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBean bean = new UserBean();
//        bean.setUserId(Integer.parseInt(request.getParameter("userId")));
    	ArrayList<UserBean> datas = null;
    	UserTable db = new UserTable();
    	datas = db.exeSelectDB(bean);
        db.DBClose();
        HttpSession session=request.getSession();
        session.setAttribute("dataList",datas);
        // TODO Auto-generated method stub
        response.sendRedirect("./userList.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBean bean = new UserBean();
//        bean.setUserId(Integer.parseInt(request.getParameter("userId")));
    	ArrayList<UserBean> datas = null;
    	UserTable db = new UserTable();
    	datas = db.exeSelectDB(bean);
        db.DBClose();
        HttpSession session=request.getSession();
        session.setAttribute("dataList",datas);
        // TODO Auto-generated method stub
        response.sendRedirect("./userList.jsp");
    }

}